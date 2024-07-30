package de.sprachlvs.skydrugs.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UUIDFetcher {

    public static final long FEBRUARY_2015 = 1422748800000L;
    private static final Gson gson = new GsonBuilder().registerTypeAdapter(UUID.class, new UUIDTypeAdapter()).create();
    public static final Map<String, UUID> uuidCache = new HashMap<>();
    public static final Map<UUID, String> nameCache = new HashMap<>();
    private static final ExecutorService pool = Executors.newCachedThreadPool();
    private String name;
    private UUID id;

    public static void getUUID(final String name, Consumer<UUID> action) {
        pool.execute(new Acceptor<UUID>(action) {
            public UUID getValue() {
                return UUIDFetcher.getUUID(name);
            }
        });
    }

    public static UUID getUUID(String name) {
        return getUUIDAt(name, System.currentTimeMillis());
    }

    public static void getUUIDAt(final String name, final long timestamp, Consumer<UUID> action) {
        pool.execute(new Acceptor<UUID>(action) {
            public UUID getValue() {
                return UUIDFetcher.getUUIDAt(name, timestamp);
            }
        });
    }

    public static UUID getUUIDAt(String name, long timestamp) {
        name = name.toLowerCase();
        if (uuidCache.containsKey(name)) {
            return (UUID) uuidCache.get(name);
        }
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(
                    String.format("https://api.mojang.com/users/profiles/minecraft/%s?at=%d",
                            name, timestamp / 1000L)).openConnection();
            connection.setReadTimeout(5000);
            UUIDFetcher data = (UUIDFetcher) gson.fromJson(
                    new BufferedReader(new InputStreamReader(connection.getInputStream())), UUIDFetcher.class);

            uuidCache.put(name, data.id);
            nameCache.put(data.id, data.name);

            return data.id;
        } catch (Exception ignored) {
        }
        return null;
    }

    public static void getName(final UUID uuid, Consumer<String> action) {
        pool.execute(new Acceptor<String>(action) {
            public String getValue() {
                return UUIDFetcher.getName(uuid);
            }
        });
    }

    public static String getName(UUID uuid) { //is der gleiche bloß was geändert
        if (nameCache.containsKey(uuid)) {
            return (String) nameCache.get(uuid);
        }
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(String.format(
                    "https://api.mojang.com/user/profiles/%s/names", UUIDTypeAdapter.fromUUID(uuid)))
                    .openConnection();
            connection.setReadTimeout(5000);
            UUIDFetcher[] nameHistory = (UUIDFetcher[]) gson.fromJson(
                    new BufferedReader(new InputStreamReader(connection.getInputStream())), UUIDFetcher[].class);
            UUIDFetcher currentNameData = nameHistory[(nameHistory.length - 1)];

            uuidCache.put(currentNameData.name.toLowerCase(), uuid);
            nameCache.put(uuid, currentNameData.name);

            return currentNameData.name;
        } catch (Exception ignored) {
        }
        return null;
    }

    public interface Consumer<T> {
        void accept(T paramT);
    }

    public static abstract class Acceptor<T> implements Runnable {
        private final Consumer<T> consumer;

        public Acceptor(Consumer<T> consumer) {
            this.consumer = consumer;
        }

        public abstract T getValue();

        public void run() {
            this.consumer.accept(getValue());
        }
    }

    public static class UUIDTypeAdapter extends TypeAdapter<UUID> {
        public UUIDTypeAdapter() {
        }

        public void write(JsonWriter var1, UUID var2) throws IOException {
            var1.value(fromUUID(var2));
        }

        public UUID read(JsonReader var1) throws IOException {
            return fromString(var1.nextString());
        }

        public static String fromUUID(UUID var0) {
            return var0.toString().replace("-", "");
        }

        public static UUID fromString(String var0) {
            return UUID.fromString(var0.replaceFirst("(\\w{8})(\\w{4})(\\w{4})(\\w{4})(\\w{12})", "$1-$2-$3-$4-$5"));
        }
    }
}

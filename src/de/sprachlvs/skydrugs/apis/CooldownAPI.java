package de.sprachlvs.skydrugs.apis;

import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CooldownAPI {
    public static File file = new File("plugins/System/database/cooldowns.yml");
    public static FileConfiguration cfg;

    static {
        cfg = YamlConfiguration.loadConfiguration(file);
    }

    public static int toSeconds(final long millis) {
        return (int) TimeUnit.MILLISECONDS.toSeconds(millis);
    }

    public static int getCooldown(Player p1, String var) {
        int i = 0;
        String uuid = p1.getUniqueId().toString();
        if (cfg.getString("cool." + var + "." + uuid) != null) {
            long secondsLeft = cfg.getLong("cool." + var + "." + uuid + ".Milis") / 1000L + (long) cfg.getInt("cool." + var + "." + uuid + ".Zeit") - System.currentTimeMillis() / 1000L;
            if (secondsLeft > 0L) {
                i = (int) secondsLeft;
            } else {
                cfg.set("cool." + var + "." + uuid, (Object) null);

                try {
                    cfg.save(file);
                } catch (IOException var7) {
                    var7.printStackTrace();
                }
            }
        }

        return i;
    }

    public static void addCooldown(OfflinePlayer p, String cool, int Time) {
        long secondsLeft = cfg.getLong("cool." + cool + "." + p.getUniqueId() + ".Milis") / 1000L + (long) cfg.getInt("cool." + cool + "." + p.getUniqueId() + ".Zeit") - System.currentTimeMillis() / 1000L;
        cfg.set("cool." + cool + "." + p.getUniqueId() + ".name", cool);
        cfg.set("cool." + cool + "." + p.getUniqueId() + ".Milis", System.currentTimeMillis());
        cfg.set("cool." + cool + "." + p.getUniqueId() + ".Zeit", Time);

        try {
            cfg.save(file);
        } catch (IOException var7) {
            var7.printStackTrace();
        }

    }

    public static String getSekunden(Integer time) {
        String newtime = null;
        int seconds = time / 1 % 60;
        newtime = "§d" + seconds + " §7Sekunde§8(§7n§8)";
        return newtime;
    }

    public static String getWeeks(Integer time) {
        String newtime = null;
        int minutes = time / 60 % 60;
        int hour = time / 60 / 60 % 24;
        int days = time / 24 / 60 / 60;
        newtime = "§f" + days + " §7Tag§8(§7e§8), §f" + hour + " §7Stunde§8(§7n§8) §7und §f" + minutes + " §7Minute§8(§7n§8)";
        return newtime;
    }

    public static String getMinuten(Integer time) {
        String newtime = null;
        int seconds = time / 1 % 60;
        int minutes = time / 60 % 60;
        newtime = "§f" + minutes + " §7Minute§8(§7n§8) §7und §f" + seconds + " §7Sekunde§8(§7n§8)";
        return newtime;
    }

    public static String getStunden(Integer time) {
        String newtime = null;
        int minutes = time / 60 % 60;
        int hour = time / 60 / 60 % 24;
        newtime = "§f" + hour + " §7Stunde§8(§7n§8) §7und §f" + minutes + " §7Minute§8(§7n§8)";
        return newtime;
    }

    public static void addKit(Player p, String kit, int Time) {
        long secondsLeft = cfg.getLong("Kit." + kit + "." + p.getUniqueId() + ".Milis") / 1000L + (long) cfg.getInt("Kit." + kit + "." + p.getUniqueId() + ".Zeit") - System.currentTimeMillis() / 1000L;
        cfg.set("Kit." + kit + "." + p.getUniqueId() + ".Kit", kit);
        cfg.set("Kit." + kit + "." + p.getUniqueId() + ".Milis", System.currentTimeMillis());
        cfg.set("Kit." + kit + "." + p.getUniqueId() + ".Zeit", Time);

        try {
            cfg.save(file);
        } catch (IOException var7) {
            var7.printStackTrace();
        }

    }

    public static void addKit1(Player p, String kit, int Time) {
        long secondsLeft = cfg.getLong("Kit." + kit + "." + p.getUniqueId() + ".Milis") / 1000L + (long) cfg.getInt("Kit." + kit + "." + p.getUniqueId() + ".Zeit") - System.currentTimeMillis() / 1000L;
        cfg.set("Kit." + kit + "." + p.getUniqueId() + ".Kit", kit);
        cfg.set("Kit." + kit + "." + p.getUniqueId() + ".Milis", System.currentTimeMillis());
        cfg.set("Kit." + kit + "." + p.getUniqueId() + ".Zeit", Time);

        try {
            cfg.save(file);
        } catch (IOException var7) {
            var7.printStackTrace();
        }

    }
}


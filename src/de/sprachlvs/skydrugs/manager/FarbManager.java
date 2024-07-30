package de.sprachlvs.skydrugs.manager;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

public class FarbManager {
    public ArrayList<Object> list;

    public static File file = new File("plugins/System/farbe.yml");

    public static YamlConfiguration configuration = YamlConfiguration.loadConfiguration(file);

    public static void setFarbe(UUID uuid, String value) {
        configuration.set(uuid + ".color", value);
        try {
            configuration.save(file);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static String getFarbe(UUID uuid) {
        if (configuration.getString(uuid + ".color") == null)
            return "§7";
        return configuration.getString(uuid + ".color");
    }

    public static void setItalic(UUID uuid, Boolean value) {
        configuration.set(uuid + ".italic", value);
        try {
            configuration.save(file);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static Boolean isItalic(UUID uuid) {
        return configuration.getBoolean(uuid + ".italic");
    }

    public static void setBold(UUID uuid, Boolean value) {
        configuration.set(uuid + ".bold", value);
        try {
            configuration.save(file);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static Boolean isBold(UUID uuid) {
        return configuration.getBoolean(uuid + ".bold");
    }

    public static void setUnderline(UUID uuid, Boolean value) {
        configuration.set(uuid + ".underline", value);
        try {
            configuration.save(file);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static Boolean isUnderline(UUID uuid) {
        return configuration.getBoolean(uuid + ".underline");
    }

    public static void setCrossedOut(UUID uuid, Boolean value) {
        configuration.set(uuid + ".crossedout", value);
        try {
            configuration.save(file);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static Boolean isCrossedOut(UUID uuid) {
        return configuration.getBoolean(uuid + ".crossedout");
    }
}

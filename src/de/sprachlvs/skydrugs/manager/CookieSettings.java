package de.sprachlvs.skydrugs.manager;

import de.sprachlvs.skydrugs.apis.CookieAPI;

import java.util.UUID;

public class CookieSettings {

    UUID uuid;

    public CookieSettings(final UUID uuid) {
        this.uuid = uuid;
    }

    public boolean getClickStatus() {
        if(CookieAPI.playersettings.getConfig().get(uuid.toString() + ".ClickSound") == null) {
            CookieAPI.playersettings.getConfig().set(uuid.toString() + ".ClickSound", true);
            CookieAPI.playersettings.saveConfig();
            return true;
        } else {
            return CookieAPI.playersettings.getConfig().getBoolean(uuid.toString() + ".ClickSound");
        }
    }

    public boolean getTitleStatus() {
        if(CookieAPI.playersettings.getConfig().get(uuid.toString() + ".Title") == null) {
            CookieAPI.playersettings.getConfig().set(uuid.toString() + ".Title", true);
            CookieAPI.playersettings.saveConfig();
            return true;
        } else {
            return CookieAPI.playersettings.getConfig().getBoolean(uuid.toString() + ".Title");
        }
    }

    public String getThemeColor() {
        if(CookieAPI.playersettings.getConfig().get(uuid.toString() + ".ThemeColor") == null) {
            CookieAPI.playersettings.getConfig().set(uuid.toString() + ".ThemeColor", "default");
            CookieAPI.playersettings.saveConfig();
            return "default";
        } else {
            return CookieAPI.playersettings.getConfig().getString(uuid.toString() + ".ThemeColor");
        }
    }

    public String getColoredThemeColor() {

        final String uncolored = getThemeColor();

        return uncolored
                .replaceAll("rot", "§c§lRot")
                .replaceAll("weiss", "§f§lWeiß")
                .replaceAll("gelb", "§e§lGelb")
                .replaceAll("gruen", "§2§lGrün")
                .replaceAll("blau", "§9§lBlau")
                .replaceAll("default", "§e§lStandard")
                .replaceAll("lila", "§5§lLila");
    }

    public void setThemeColor(String color) {
        if(CookieAPI.playersettings.getConfig().get(uuid.toString() + ".ThemeColor") == null) {
            CookieAPI.playersettings.getConfig().set(uuid.toString() + ".ThemeColor", "default");
            CookieAPI.playersettings.saveConfig();
        } else {
            CookieAPI.playersettings.getConfig().set(uuid.toString() + ".ThemeColor", color);
            CookieAPI.playersettings.saveConfig();
        }
    }


    public void setClickSound(boolean status) {
        if(CookieAPI.playersettings.getConfig().get(uuid.toString() + ".ClickSound") == null) {
            CookieAPI.playersettings.getConfig().set(uuid.toString() + ".ClickSound", true);
            CookieAPI.playersettings.saveConfig();
        } else {
            CookieAPI.playersettings.getConfig().set(uuid.toString() + ".ClickSound", status);
            CookieAPI.playersettings.saveConfig();
        }

    }

    public void setTitle(boolean status) {
        if(CookieAPI.playersettings.getConfig().get(uuid.toString() + ".Title") == null) {
            CookieAPI.playersettings.getConfig().set(uuid.toString() + ".Title", true);
            CookieAPI.playersettings.saveConfig();
        } else {
            CookieAPI.playersettings.getConfig().set(uuid.toString() + ".Title", status);
            CookieAPI.playersettings.saveConfig();
        }

    }

    public void setLevel(int level) {
        if(CookieAPI.playersettings.getConfig().get(uuid.toString() + ".Level") == null) {
            CookieAPI.playersettings.getConfig().set(uuid.toString() + ".Level", true);
            CookieAPI.playersettings.saveConfig();
        } else {
            CookieAPI.playersettings.getConfig().set(uuid.toString() + ".Level", level);
            CookieAPI.playersettings.saveConfig();
        }
    }

    public int getLevel() {
        if(CookieAPI.playersettings.getConfig().get(uuid.toString() + ".Level") == null) {
            CookieAPI.playersettings.getConfig().set(uuid.toString() + ".Level", 0);
            CookieAPI.playersettings.saveConfig();
            return 0;
        } else {
            return CookieAPI.playersettings.getConfig().getInt(uuid.toString() + ".Level");
        }
    }


    public void setKeksFarmer(boolean status) {
        if(CookieAPI.playersettings.getConfig().get(uuid.toString() + ".Keksfarmer") == null) {
            CookieAPI.playersettings.getConfig().set(uuid.toString() + ".Keksfarmer", true);
            CookieAPI.playersettings.saveConfig();
        } else {
            CookieAPI.playersettings.getConfig().set(uuid.toString() + ".Keksfarmer", status);
            CookieAPI.playersettings.saveConfig();
        }
    }

    public boolean getKeksFarmer() {
        if(CookieAPI.playersettings.getConfig().get(uuid.toString() + ".Keksfarmer") == null) {
            CookieAPI.playersettings.getConfig().set(uuid.toString() + ".Keksfarmer", false);
            CookieAPI.playersettings.saveConfig();
            return false;
        } else {
            return CookieAPI.playersettings.getConfig().getBoolean(uuid.toString() + ".Keksfarmer");
        }
    }

    public String getColoredKeksFarmer() {

        final boolean keksfarmer = getKeksFarmer();

        if(keksfarmer) {
            return "§a§l✔";
        } else {
            return "§c§l✘";
        }
    }


}


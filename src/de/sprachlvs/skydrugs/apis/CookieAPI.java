package de.sprachlvs.skydrugs.apis;

import de.sprachlvs.skydrugs.SkyDrugs;
import de.sprachlvs.skydrugs.manager.ItemSkullManager;
import de.sprachlvs.skydrugs.manager.PrefixManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.text.DecimalFormat;
import java.util.UUID;

public class CookieAPI {

    public static String getFormated(int amount) {
        final DecimalFormat decimalFormat = new DecimalFormat("###,###.###");
        return decimalFormat.format(amount).replace(",", "§8'§e");
    }

    public static String getHeader(String string) {
        return "§7   §8× §8§m---------|§7 " + string + " §8§m|---------§7 §8×";
    }

    public static void playBigSuccessSound(Player player) {

        player.playSound(player.getLocation(), Sound.NOTE_PLING, 1.5F, 14.5F);

        Bukkit.getScheduler().runTaskLater(SkyDrugs.getInstance(), () -> player.playSound(player.getLocation(), Sound.NOTE_PLING, 1.5F, 14.5F), 4);

        Bukkit.getScheduler().runTaskLater(SkyDrugs.getInstance(), () -> player.playSound(player.getLocation(), Sound.NOTE_STICKS, 1.5F, 14.5F), 6);

        Bukkit.getScheduler().runTaskLater(SkyDrugs.getInstance(), () -> player.playSound(player.getLocation(), Sound.NOTE_STICKS, 1.5F, 14.5F), 8);

        Bukkit.getScheduler().runTaskLater(SkyDrugs.getInstance(), () -> player.playSound(player.getLocation(), Sound.NOTE_STICKS, 1.5F, 14.5F), 10);

        Bukkit.getScheduler().runTaskLater(SkyDrugs.getInstance(), () -> player.playSound(player.getLocation(), Sound.EXPLODE, 1.5F, 18.5F), 11);
    }

    public static final ConfigAPI cfg;
    public static final ConfigAPI database;
    public static final ConfigAPI playersettings;
    public static final ConfigAPI settings;


    final UUID uuid;
    Location location;
    public static String texture = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjU5MmNmOWY0MmE1YThjOTk1OTY4NDkzZmRkMWIxMWUwYjY5YWFkNjQ3M2ZmNDUzODRhYmU1OGI3ZmM3YzcifX19";
    public static ItemStack clicker = ItemSkullManager.getSkull("§8»│ §6Cookie-Clicker", texture, new String[]{"", "§8➥ §7Platziere diesen Kopf um einen", "§8➥ §6CookieClicker §7zu erstellen§8.", ""});

    static {
        cfg = new ConfigAPI("plugins/System/cookieclicker", "config.yml");
        database = new ConfigAPI("plugins/System/cookieclicker", "database.yml");
        playersettings = new ConfigAPI("plugins/System/cookieclicker", "playersettings.yml");
        settings = new ConfigAPI("plugins/System/cookieclicker", "settings.yml");
    }

    public CookieAPI(UUID uuid) {
        this.uuid = uuid;
    }


    public void giveClicker() {

        Player player = Bukkit.getPlayer(uuid);
        if (player == null) return;
        player.getInventory().addItem(clicker);
        player.sendMessage(PrefixManager.COOKIECLICKER + "§7Du hast einen §8'§6CookieClicker§8' §7erhalten§8.");

    }

    public void place(Location location) {

        cfg.getConfig().set("CookieClicker." + ".world", location.getWorld().getName());
        cfg.getConfig().set("CookieClicker." + ".x", location.getX());
        cfg.getConfig().set("CookieClicker." + ".y", location.getY());
        cfg.getConfig().set("CookieClicker." + ".z", location.getZ());

        cfg.saveConfig();
        Player player = Bukkit.getPlayer(uuid);
        if (player == null) return;

        player.sendMessage(PrefixManager.COOKIECLICKER + "§7Der §6CookieClicker §7wurde platziert§8.");

    }

    public void destroy() {

        cfg.getConfig().set("CookieClicker." + ".world", null);
        cfg.getConfig().set("CookieClicker." + ".x", null);
        cfg.getConfig().set("CookieClicker." + ".y", null);
        cfg.getConfig().set("CookieClicker." + ".z", null);

        cfg.saveConfig();
        Player player = Bukkit.getPlayer(uuid);
        if (player == null) return;

        player.sendMessage(PrefixManager.COOKIECLICKER + "§7Der §6Cookie-Clicker §7wurde entfernt§8.");

    }

    public Location getLocation() {

        String world = cfg.getConfig().getString("CookieClicker." + ".world");
        Double x = cfg.getConfig().getDouble("CookieClicker." + ".x");
        Double y = cfg.getConfig().getDouble("CookieClicker." + ".y");
        Double z = cfg.getConfig().getDouble("CookieClicker." + ".z");

        return new Location(Bukkit.getWorld(world), x, y, z, 0,0);

    }


    public void setCookies(int amount) {
        if(database.getConfig().get(uuid + ".Cookies") == null) {
            database.getConfig().set(uuid + ".Cookies", 0);
        } else {
            database.getConfig().set(uuid + ".Cookies", amount);
        }
        database.saveConfig();
    }

    public int getCookies() {
        if(database.getConfig().get(uuid + ".Cookies") == null) {
            database.getConfig().set(uuid + ".Cookies", 0);
            return 0;
        } else {
            return database.getConfig().getInt(uuid + ".Cookies");
        }
    }

    public void addCookies(int amount) {
        if(database.getConfig().get(uuid + ".Cookies") == null) {
            database.getConfig().set(uuid + ".Cookies", amount);
        } else {
            database.getConfig().set(uuid + ".Cookies", getCookies()+amount);
        }
        database.saveConfig();
    }

    public void removeCookies(int amount) {
        if(database.getConfig().get(uuid + ".Cookies") == null) {
            database.getConfig().set(uuid + ".Cookies", 0);
        } else {
            database.getConfig().set(uuid + ".Cookies", getCookies()-amount);
        }
        database.saveConfig();
    }
    // SETTINGS


    public void setParticles(boolean mode) {

        if(settings.getConfig().get("CookieClicker." + ".particle") == null) {
            settings.getConfig().set("CookieClicker." + ".particle", true);
        } else {
            settings.getConfig().set("CookieClicker." + ".particle", mode);
        }
        settings.saveConfig();
    }

    public boolean getParticlesMode() {
        if(settings.getConfig().get("CookieClicker." + ".particle") == null) {
            return true;
        } else {
            return settings.getConfig().getBoolean("CookieClicker." + ".particle");

        }

    }

    public void setStatus(boolean mode) {
        if(settings.getConfig().get("CookieClicker." + ".status") == null) {
            settings.getConfig().set("CookieClicker." + ".status", true);
        } else {
            settings.getConfig().set("CookieClicker." + ".status", mode);
        }
        settings.saveConfig();
    }

    public boolean getStatus() {
        if(settings.getConfig().get("CookieClicker." + ".status") == null) {
            return true;
        } else {
            return settings.getConfig().getBoolean("CookieClicker." + ".status");

        }

    }

}

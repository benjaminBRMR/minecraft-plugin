package de.sprachlvs.skydrugs.inventorys;

import de.sprachlvs.skydrugs.manager.ItemManager;
import de.sprachlvs.skydrugs.manager.ItemSkullManager;
import de.sprachlvs.skydrugs.manager.PrefixManager;
import de.sprachlvs.skydrugs.utils.InventoryUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class WarpGUI {

    private static String angelteich64 = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjNmNWY2OWI5NGI2NGNkNTJhY2MyZTg3ZDg0NmY2MzUyYTRjYjA3MDU2YjE0N2UyNDhhZjZlZjlmMjc4ZWY4ZiJ9fX0";
    private static String cookieclicker64 = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjU5MmNmOWY0MmE1YThjOTk1OTY4NDkzZmRkMWIxMWUwYjY5YWFkNjQ3M2ZmNDUzODRhYmU1OGI3ZmM3YzcifX19";
    private static String spawn64 = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzdlOGNiNTdmZTc5MGU5NjVlM2NmYTZjNGZiYzE2ZTMyMjYyMTBkNjVmNTYxNGU4ODUzZmE5ZmI4NDA3NDQ0MSJ9fX0";
    private static String enchanter64 = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjYyNjUxODc5ZDg3MDQ5OWRhNTBlMzQwMzY4MDBkZGZmZDUyZjNlNGUxOTkzYzVmYzBmYzgyNWQwMzQ0NmQ4YiJ9fX0";
    private static String arena64 = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODMxNTJiMzhkYzE0MjU4OGQxNGZkZDM4YWFhMGI1NGU2MTM4NjBmN2QxNTM5NTM1YjMyYzAxZWIyMjBmZTY3YiJ9fX0";


    public static void openWarpMenu(Player player) {

        Inventory inventory = Bukkit.createInventory(null, 45, PrefixManager.WARP);

        InventoryUtils.fill(inventory, new ItemManager(Material.STAINED_GLASS_PANE).setData(15).setName("§8-/-").build());
        InventoryUtils.fillBorders(inventory, new ItemManager(Material.STAINED_GLASS_PANE).setData(7).setName("§8-/-").build());
        ItemStack sign = new ItemManager(Material.SIGN).setName("§8»│ §7Weitere Warps").build();

        String[] angelteich_lore = new String[]{"", " §8▰§7▱ §3Information","  §8- §7Nehme deine Freunde mit zum Angelteich", "  §8- §7und fange deine §b§obesonderen §7Fische§8§o.", "", "§8» §7Aktuell sind §3" + Bukkit.getWorld("world").getPlayers().size() + " §7Spieler dort§8.", "", "§3Linksklick §8┃ §7Teleportiere dich§8!"};
        String[] arena_lore = new String[]{"", " §8▰§7▱ §3Information", "  §8- §7Kämpfe gegen andere Spieler und", "  §8- §7erreiche den §b§o1§7sten Platz in §8§o/§b§oranking§8§o", "", "§8» §7Aktuell sind §3" + Bukkit.getWorld("world").getPlayers().size() + " §7Spieler dort§8.", "", "§3Linksklick §8┃ §7Teleportiere dich§8!"};


        ItemStack angelteich = ItemSkullManager.getSkull("§8»│ §3§lWARPS §8▰§7▱ §7Angelteich", angelteich64, angelteich_lore);
        ItemStack cookierclicker = ItemSkullManager.getSkull("§8»│ §3§lWARPS §8▰§7▱ §7CookieClicker", cookieclicker64, new String[]{"", " §8▰§7▱ §3Information","  §8- §7Sammle Kekse und bekomme §b§overschiedene", "  §8- §7Errungenschaften und vieles mehr§8§o.", "", "§8» §7Aktuell sind §3" + Bukkit.getWorld("world").getPlayers().size() + " §7Spieler dort§8.", "", "§3Linksklick §8┃ §7Teleportiere dich§8!"});
        ItemStack spawn = ItemSkullManager.getSkull("§8»│ §3§lWARPS §8▰§7▱ §7Spawn", spawn64, new String[]{"", " §8▰§7▱ §3Information","  §8- §7Siehe dich um und finde Secrets§8§o,", "  §8- §7NPC§8§o'§7s und §b§ovielleicht §7auch neue Freunde", "", "§8» §7Aktuell sind §3" + Bukkit.getWorld("world").getPlayers().size() + " §7Spieler dort§8.", "", "§3Linksklick §8┃ §7Teleportiere dich§8!"});
        ItemStack enchanter = ItemSkullManager.getSkull("§8»│ §3§lWARPS §8▰§7▱ §7Enchanter", enchanter64, new String[]{"", " §8▰§7▱ §3Information","  §8- §7Verzaubere deine Schwerter und Rüstung", "  §8- §7mit einem §b§ozauberlichen §7Enchanter§8§o.", "", "§8» §7Aktuell sind §3" + Bukkit.getWorld("world").getPlayers().size() + " §7Spieler dort§8.", "", "§3Linksklick §8┃ §7Teleportiere dich§"});
        ItemStack arena = ItemSkullManager.getSkull("§8»│ §3§lWARPS §8▰§7▱ §7Arena", arena64, arena_lore);

        inventory.setItem(11, angelteich);
        inventory.setItem(15, enchanter);
        inventory.setItem(22, spawn);
        inventory.setItem(29, cookierclicker);
        inventory.setItem(33, arena);
        inventory.setItem(44, sign);
        ;






        player.openInventory(inventory);
        player.playSound(player.getLocation(), Sound.HORSE_ARMOR, 1.5F, 14.8F);




    }
}
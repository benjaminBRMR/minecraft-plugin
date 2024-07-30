package de.sprachlvs.skydrugs.inventorys;

import de.sprachlvs.skydrugs.apis.PerkAPI;
import de.sprachlvs.skydrugs.apis.PerkEnum;
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

public class PerkGUI {

    protected static String speedperk_base64 = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjllNWZiMzEzNTEwYmJiMGIyMmMzNTAwYjQyNWUzMGZjZTM1YmQ5NzE3N2FiOGQyZmRkNjE5NDZjY2NkNGJmMCJ9fX0=";
    public static ItemStack zurück = ItemSkullManager.getSkull("§8»│ §7Vorherige Seite", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYmQ2OWUwNmU1ZGFkZmQ4NGU1ZjNkMWMyMTA2M2YyNTUzYjJmYTk0NWVlMWQ0ZDcxNTJmZGM1NDI1YmMxMmE5In19fQ==", null);

    public static void openPerkSeite1(final Player player) {


        Inventory inventory = Bukkit.createInventory(null, 54, PrefixManager.PERKS + " §7Perks 1");


        ItemStack borderitem = new ItemManager(Material.STAINED_GLASS_PANE).setData(15).setName("§8-/-").build();
        ItemStack glass = new ItemManager(Material.STAINED_GLASS_PANE).setData(7).setName("§8-/-").build();

        InventoryUtils.fill(inventory, glass);
        InventoryUtils.fillBorders(inventory, borderitem);


        String[] nohungerperk_lore = new String[]{
                "",
                " §8▰§7▱ §cWas macht das§8?",
                "  §8- §7Dieses Perk bringt dir den Vorteil nichts",
                "  §8- §7mehr essen zu müssen bzw. nie wieder§8.",
                "",
                " §8▰§7▱ §cPreis",
                "  §8- §f500§8.§f000 §7Tokens",
                ""
        };

        String[] jumpboostperk_lore = new String[]{
                "",
                " §8▰§7▱ §cWas macht das§8?",
                "  §8- §7Dieses Perk bringt dir den Vorteil",
                "  §8- §7höher springen zu können§8.",
                "",
                " §8▰§7▱ §cPreis",
                "  §8- §f250§8.§f000 §7Tokens",
                ""
        };

        String[] nachtsichtperk_lore = new String[]{
                "",
                " §8▰§7▱ §cWas macht das§8?",
                "  §8- §7Dieses Perk bringt dir den Vorteil den",
                "  §8- §7Nachtsicht Effekt dauerhaft zu erhalten§8.",
                "",
                " §8▰§7▱ §cPreis",
                "  §8- §f200§8.§f000 §7Tokens",
                ""
        };

        String[] speedperk_lore = new String[]{
                "",
                " §8▰§7▱ §cWas macht das§8?",
                "  §8- §7Dieses Perk bringt dir den Vorteil den",
                "  §8- §7Schnelligkeit I Effekt dauerhaft zu erhalten§8.",
                "",
                " §8▰§7▱ §cPreis",
                "  §8- §f350§8.§f000 §7Tokens",
                ""
        };

        String[] nohungerperk_lore_buyed  = new String[]{
                "",
                " §8▰§7▱ §cWas macht das§8?",
                "  §8- §7Dieses Perk bringt dir den Vorteil nichts",
                "  §8- §7mehr essen zu müssen bzw. nie wieder§8.",
                "",
                " §8▰§7▱ §cDu besitzt bereits dieses Perk§8.",
                ""
        };

        String[] jumpboostperk_lore_buyed  = new String[]{
                "",
                " §8▰§7▱ §cWas macht das§8?",
                "  §8- §7Dieses Perk bringt dir den Vorteil",
                "  §8- §7höher springen zu können§8.",
                "",
                " §8▰§7▱ §cDu besitzt bereits dieses Perk§8.",
                ""
        };

        String[] itemsaverperk_lore_buyed  = new String[]{
                "",
                " §8▰§7▱ §cWas macht das§8?",
                "  §8- §7Dieses Perk bringt dir den Vorteil ein Item aus deinem ",
                "  §8- §7alten Inventar beim Respawnen wiederzubekommen§8.",
                "",
                " §8▰§7▱ §cDu besitzt bereits dieses Perk§8.",
                ""
        };

        String[] nachtsichtperk_lore_buyed  = new String[]{
                "",
                " §8▰§7▱ §cWas macht das§8?",
                "  §8- §7Dieses Perk bringt dir den Vorteil den",
                "  §8- §7Nachtsicht Effekt dauerhaft zu erhalten§8.",
                "",
                " §8▰§7▱ §cDu besitzt bereits dieses Perk§8.",
                ""
        };

        String[] speedperk_lore_buyed = new String[]{
                "",
                " §8▰§7▱ §cWas macht das§8?",
                "  §8- §7Dieses Perk bringt dir den Vorteil den",
                "  §8- §7Schnelligkeit I Effekt dauerhaft zu erhalten§8.",
                "",
                " §8▰§7▱ §cDu besitzt bereits dieses Perk§8.",
                ""
        };


        String[] info_lore = new String[]{
                "",
                " §8▰§7▱ §cInformation",
                "  §8- §7Diese Übersicht zeigt dir§8,",
                "  §8- §7welche Perks du gekauft",
                "  §8- §7und aktiviert hast§8.",
                "",
                " §8▰§7▱ §cIm Besitz",
                "  §8- §fKein Hunger Perk§8: §a" + new PerkAPI(player).hasPerkColored(PerkEnum.NOHUNGER),
                "  §8- §fSprungkraft Perk§8: §a" + new PerkAPI(player).hasPerkColored(PerkEnum.JUMPBOOST),
                "  §8- §fSchnelligkeit I Perk§8: §a" + new PerkAPI(player).hasPerkColored(PerkEnum.SPEEDEINS),
                "  §8- §fNachtsicht Perk§8: §a" + new PerkAPI(player).hasPerkColored(PerkEnum.NACHTSICHT),
                "",
                "",
                " §8▰§7▱ §cStatus",
                "  §8- §fKein Hunger Perk§8: §a" + new PerkAPI(player).getPerkStatusColored(PerkEnum.NOHUNGER),
                "  §8- §fSprungkraft I Perk§8: §a" + new PerkAPI(player).getPerkStatusColored(PerkEnum.JUMPBOOST),
                "  §8- §fSchnelligkeit I Perk§8: §a" + new PerkAPI(player).getPerkStatusColored(PerkEnum.SPEEDEINS),
                "  §8- §fNachtsicht Perk§8: §a" + new PerkAPI(player).getPerkStatusColored(PerkEnum.NACHTSICHT),
                ""
        };


        ItemStack info = new ItemManager(Material.POTION).setName("§8»│ §c§lPERK §8▰§7▱ §7Übersicht").setLore(info_lore).build();

        ItemStack nohungerperk = new ItemManager(Material.COOKED_BEEF).setName("§8»│ §c§lPERK §8▰§7▱ §7Kein Hunger Perk").setLore(nohungerperk_lore).build();
        ItemStack jumpboostperk = new ItemManager(Material.RABBIT_FOOT).setName("§8»│ §c§lPERK §8▰§7▱ §7Sprungkraft I Perk").setLore(jumpboostperk_lore).build();
        ItemStack speed1perk = new ItemManager(Material.FEATHER).setName("§8»│ §c§lPERK §8▰§7▱ §7Schnelligkeit I Perk").setLore(speedperk_lore).build();
        ItemStack nachtsichtperk = new ItemManager(Material.EYE_OF_ENDER).setName("§8»│ §c§lPERK §8▰§7▱ §7Nachtsicht Perk").setLore(nachtsichtperk_lore).build();

        ItemStack nohungerperk_bought = new ItemManager(Material.COOKED_BEEF).setName("§8»│ §c§lPERK §8▰§7▱ §7Kein Hunger Perk").setLore(nohungerperk_lore_buyed).build();
        ItemStack jumpboostperk_bought = new ItemManager(Material.RABBIT_FOOT).setName("§8»│ §c§lPERK §8▰§7▱ §7Sprungkraft I Perk").setLore(jumpboostperk_lore_buyed).build();
        ItemStack speed1perk_bought = new ItemManager(Material.FEATHER).setName("§8»│ §c§lPERK §8▰§7▱ §7Schnelligkeit I Perk").setLore(speedperk_lore_buyed).build();
        ItemStack nachtsichtperk_bought = new ItemManager(Material.EYE_OF_ENDER).setName("§8»│ §c§lPERK §8▰§7▱ §7Nachtsicht Perk").setLore(nachtsichtperk_lore_buyed).build();

        ItemStack weiter = ItemSkullManager.getSkull("§8»│ §7Nächste Seite", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTliZjMyOTJlMTI2YTEwNWI1NGViYTcxM2FhMWIxNTJkNTQxYTFkODkzODgyOWM1NjM2NGQxNzhlZDIyYmYifX19", null);


        inventory.setItem(43, weiter);

        inventory.setItem(13, info);

        if(!new PerkAPI(player).hasPerk(PerkEnum.NOHUNGER)) {
            inventory.setItem(29, nohungerperk);
        } else {
            inventory.setItem(29, nohungerperk_bought);
        }

        if(!new PerkAPI(player).hasPerk(PerkEnum.JUMPBOOST)) {
            inventory.setItem(30, jumpboostperk);
        } else {
            inventory.setItem(30, jumpboostperk_bought);
        }

        if(!new PerkAPI(player).hasPerk(PerkEnum.SPEEDEINS)) {
            inventory.setItem(32, speed1perk);
        } else {
            inventory.setItem(32, speed1perk_bought);
        }


        if(!new PerkAPI(player).hasPerk(PerkEnum.NACHTSICHT)) {
            inventory.setItem(33, nachtsichtperk);
        } else {
            inventory.setItem(33, nachtsichtperk_bought);
        }







        player.closeInventory();
        player.openInventory(inventory);
        player.playSound(player.getLocation(), Sound.HORSE_ARMOR, 1.5F, 14.8F);

    }


    public static void openPerkSeite2(final Player player) {
        Inventory inventory = Bukkit.createInventory(null, 54, PrefixManager.PERKS + " §7Perks 2");



        ItemStack borderitem = new ItemManager(Material.STAINED_GLASS_PANE).setData(15).setName("§8-/-").build();
        ItemStack glass = new ItemManager(Material.STAINED_GLASS_PANE).setData(7).setName("§8-/-").build();

        InventoryUtils.fill(inventory, glass);
        InventoryUtils.fillBorders(inventory, borderitem);


        String[] speed2perk_lore = new String[]{
                "",
                " §8▰§7▱ §cWas macht das§8?",
                "  §8- §7Dieses Perk bringt dir den Vorteil den",
                "  §8- §7Schnelligkeit II Effekt dauerhaft zu erhalten§8.",
                "",
                " §8▰§7▱ §cPreis",
                "  §8- §f5 §7Euro",
                ""
        };

        String[] stärke1perk_lore = new String[]{
                "",
                " §8▰§7▱ §cWas macht das§8?",
                "  §8- §7Dieses Perk bringt dir den Vorteil den",
                "  §8- §7Stärke I Effekt dauerhaft zu erhalten§8.",
                "",
                " §8▰§7▱ §cPreis",
                "  §8- §f5 §7Euro",
                ""
        };

        String[] stärke2perk_lore = new String[]{
                "",
                " §8▰§7▱ §cWas macht das§8?",
                "  §8- §7Dieses Perk bringt dir den Vorteil den",
                "  §8- §7Stärke II Effekt dauerhaft zu erhalten§8.",
                "",
                " §8▰§7▱ §cPreis",
                "  §8- §f10 §7Euro",
                ""
        };

        String[] speed2perk_lore_bought = new String[]{
                "",
                " §8▰§7▱ §cWas macht das§8?",
                "  §8- §7Dieses Perk bringt dir den Vorteil den",
                "  §8- §7Schnelligkeit II Effekt dauerhaft zu erhalten§8.",
                "",
                " §8▰§7▱ §cDu besitzt bereits dieses Perk§8.",
                ""
        };

        String[] stärke1perk_lore_bought = new String[]{
                "",
                " §8▰§7▱ §cWas macht das§8?",
                "  §8- §7Dieses Perk bringt dir den Vorteil den",
                "  §8- §7Stärke I Effekt dauerhaft zu erhalten§8.",
                "",
                " §8▰§7▱ §cDu besitzt bereits dieses Perk§8.",
                ""
        };

        String[] stärke2perk_lore_bought = new String[]{
                "",
                " §8▰§7▱ §cWas macht das§8?",
                "  §8- §7Dieses Perk bringt dir den Vorteil den",
                "  §8- §7Stärke II Effekt dauerhaft zu erhalten§8.",
                "",
                " §8▰§7▱ §cDu besitzt bereits dieses Perk§8.",
                ""
        };



        /*
                    return "§a§l✔";
        } else {
            return "§c§l✘";
        }
         */

        String[] info_lore = new String[]{
                "",
                " §8▰§7▱ §cInformation",
                "  §8- §7Diese Übersicht zeigt dir§8,",
                "  §8- §7welche Perks du gekauft",
                "  §8- §7und aktiviert hast§8.",
                "",
                " §8▰§7▱ §cIm Besitz",
                "  §8- §fSchnelligkeit II Perk§8: §a" + new PerkAPI(player).hasPerkColored(PerkEnum.SPEEDZWEI),
                "  §8- §fStärke I Perk§8: §a" + new PerkAPI(player).hasPerkColored(PerkEnum.STAERKEEINS),
                "  §8- §fStärke II Perk§8: §a" + new PerkAPI(player).hasPerkColored(PerkEnum.STAERKEZWEI),
                "",
                "",
                " §8▰§7▱ §cStatus",
                "  §8- §fSchnelligkeit II Perk§8: §a" + new PerkAPI(player).getPerkStatusColored(PerkEnum.SPEEDZWEI),
                "  §8- §fStärke I Perk§8: §a" + new PerkAPI(player).getPerkStatusColored(PerkEnum.STAERKEEINS),
                "  §8- §fStärke II Perk§8: §a" + new PerkAPI(player).getPerkStatusColored(PerkEnum.STAERKEZWEI),
                ""
        };


        ItemStack info = new ItemManager(Material.POTION).setName("§8»│ §c§lPERK §8▰§7▱ §7Übersicht").setLore(info_lore).build();

        ItemStack speed2perk = new ItemManager(Material.FEATHER).setName("§8»│ §c§lPERK §8▰§7▱ §7Schnelligkeit II").setLore(speed2perk_lore).build();
        ItemStack stärke1perk = new ItemManager(Material.FERMENTED_SPIDER_EYE).setName("§8»│ §c§lPERK §8▰§7▱ §7Stärke I").setLore(stärke1perk_lore).build();
        ItemStack stärke2perk = new ItemManager(Material.FERMENTED_SPIDER_EYE).setName("§8»│ §c§lPERK §8▰§7▱ §7Stärke II").setLore(stärke2perk_lore).build();

        ItemStack speed2perk_bought = new ItemManager(Material.FEATHER).setName("§8»│ §c§lPERK §8▰§7▱ §7Schnelligkeit II").setLore(speed2perk_lore).build();
        ItemStack stärke1perk_bought = new ItemManager(Material.FERMENTED_SPIDER_EYE).setName("§8»│ §c§lPERK §8▰§7▱ §7Stärke I").setLore(stärke1perk_lore).build();
        ItemStack stärke2perk_bought = new ItemManager(Material.FERMENTED_SPIDER_EYE).setName("§8»│ §c§lPERK §8▰§7▱ §7Stärke II").setLore(stärke2perk_lore).build();

        ItemStack weiter = ItemSkullManager.getSkull("§8»│ §7Nächste Seite", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTliZjMyOTJlMTI2YTEwNWI1NGViYTcxM2FhMWIxNTJkNTQxYTFkODkzODgyOWM1NjM2NGQxNzhlZDIyYmYifX19", null);


        inventory.setItem(37, zurück);

        inventory.setItem(13, info);


        if(!new PerkAPI(player).hasPerk(PerkEnum.SPEEDZWEI)) {
            inventory.setItem(30, speed2perk);
        } else {
            inventory.setItem(30, speed2perk_bought);
        }

        if(!new PerkAPI(player).hasPerk(PerkEnum.SPEEDZWEI)) {
            inventory.setItem(31, stärke1perk);
        } else {
            inventory.setItem(31, stärke1perk_bought);
        }

        if(!new PerkAPI(player).hasPerk(PerkEnum.SPEEDZWEI)) {
            inventory.setItem(32, stärke2perk);
        } else {
            inventory.setItem(32, stärke2perk_bought);
        }




        player.closeInventory();
        player.openInventory(inventory);
        player.playSound(player.getLocation(), Sound.HORSE_ARMOR, 1.5F, 14.8F);
    }
}


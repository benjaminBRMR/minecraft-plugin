package de.sprachlvs.skydrugs.inventorys;

import de.sprachlvs.skydrugs.apis.CookieAPI;
import de.sprachlvs.skydrugs.apis.stats.TokenAPI;
import de.sprachlvs.skydrugs.manager.CookieSettings;
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

public class CookieGUI {




    public CookieGUI() {
    }

    public static void openCookieClicker(final Player player) {

        Inventory inventory = Bukkit.createInventory(null, 54, PrefixManager.COOKIECLICKER + " §7CookieClicker");



        String[] stats = new String[]{"", "§8➥ §7Deine Cookies§8: §e" + CookieAPI.getFormated(new CookieAPI(player.getUniqueId()).getCookies()), "§8➥ §7Deine Tokens§8: §e" + CookieAPI.getFormated((int) new TokenAPI(player).getTokens()),  "§8➥ §7Dein Level§8: §e"  +  + new CookieSettings(player.getUniqueId()).getLevel() + "§8/§65", "§8➥ §7Dein Theme§8: " + new CookieSettings(player.getUniqueId()).getColoredThemeColor().toUpperCase(), "§8➥ §7Keksfarmer§8: " + new CookieSettings(player.getUniqueId()).getColoredKeksFarmer(),  ""};

        String[] shop_ = new String[]{"", "§8➥ §7Klicke§8, §7um die §eShop-Kategorie §7zu öffnen", ""};
        String[] wechsler_ = new String[]{"", "§8➥ §7Klicke§8, §7um die §eWechsler-Kategorie §7zu öffnen", ""};
        String[] settings_ = new String[]{"", "§8➥ §7Klicke§8, §7um die §eEinstellungs-Kategorie §7zu öffnen", ""};


        ItemStack borderitem = new ItemManager(Material.STAINED_GLASS_PANE).setData(15).setName("§8-/-").build();
        ItemStack glass = new ItemManager(Material.STAINED_GLASS_PANE).setData(7).setName("§8-/-").build();

        ItemStack paper = new ItemManager(Material.PAPER).setName("§8»│ §e§lSTATISTIK §8▰§7▱ Übersicht").setLore(stats).build();
        ItemStack door = new ItemManager(Material.IRON_DOOR).setName("§8»│ §c✘").build();
        ItemStack shopitem = ItemSkullManager.getSkull("§8»│ §e§lCOOKIE §8▰§7▱ Shop", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGVmNmNkMWM1ZjMzZWEyNzg0NzgwYWE3OTNkYzg1NWQwYmMwNjQwMGNmYjg1NjQ1YWQ3MTA3MmVkNGMyMzk0NiJ9fX0=", shop_);
        ItemStack wechsler = new ItemManager(Material.SIGN).setName("§8»│ §e§lCOOKIE §8▰§7▱ Wechsler").setLore(wechsler_).build();
        ItemStack settings = new ItemManager(Material.COMMAND).setName("§8»│ §e§lCOOKIE §8▰§7▱ Optionen").setLore(settings_).build();


        InventoryUtils.fill(inventory, glass);
        InventoryUtils.fillBordersWithTheme(player, inventory);




        inventory.setItem(21, paper);
        inventory.setItem(23, door);

        inventory.setItem(29, shopitem);
        inventory.setItem(31, wechsler);
        inventory.setItem(33, settings);



        player.openInventory(inventory);
        player.playSound(player.getLocation(), Sound.HORSE_ARMOR, 1.5F, 14.8F);


    }

    public static ItemStack zurück = ItemSkullManager.getSkull("§8»│ §7Vorherige Seite", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYmQ2OWUwNmU1ZGFkZmQ4NGU1ZjNkMWMyMTA2M2YyNTUzYjJmYTk0NWVlMWQ0ZDcxNTJmZGM1NDI1YmMxMmE5In19fQ==", null);
    public static ItemStack reset = new ItemManager(Material.BARRIER).setName("§8»│ §cSetze dein Theme zurück").build();

    public static ItemStack enabled = new ItemManager(Material.INK_SACK).setData(10).setName("§8»│ §7Status§8: §aAktiviert").build();
    public static ItemStack disabled = new ItemManager(Material.INK_SACK).setData(1).setName("§8»│ §7Status§8: §cDeaktiviert").build();

    static String[] clicksound_lore = new String[]{"", " §8▰§7▱ §6Information", "  §8- §7Diese Option ermöglicht dir das §cde§8/§aaktivieren §7des Klicksounds§8.", ""};
    static String[] clicktitle_lore = new String[]{"", " §8▰§7▱ §6Information", "  §8- §7Diese Option ermöglicht dir das §cde§8/§aakivieren §7des Klicktitels§8.", ""};

    public static ItemStack ClickSound = new ItemManager(Material.STONE_BUTTON).setName("§8»│ §e§lCOOKIE§6§lCLICKER §8▰§7▱ Sound").setLore(clicksound_lore).build();
    public static ItemStack ClickTitle = new ItemManager(Material.SIGN).setName("§8»│ §e§lCOOKIE§6§lCLICKER §8▰§7▱ Titel").setLore(clicktitle_lore).build();

    public static ItemStack borderitem = new ItemManager(Material.STAINED_GLASS_PANE).setData(15).setName("§8-/-").build();
    public static ItemStack glass = new ItemManager(Material.STAINED_GLASS_PANE).setData(7).setName("§8-/-").build();

    // FARBEN

    static String[] theme_rot_lore = new String[]{"", " §8▰§7▱ §6Information", "  §8- §7Mit dieser Farbe wird dein Theme zu §cRot§8.", "  §8- §7Mit dem Theme ist die Umrandung des Inventar§8'§7s gemeint§8!", "", "  §8(§c§l!§8) §7Diese Farbe schaltest du ab dem §e§lKAVAIN §7Rang frei§8.", ""};
    static String[] theme_blau_lore = new String[]{"", " §8▰§7▱ §6Information", "  §8- §7Mit dieser Farbe wird dein Theme zu §bBlau§8.", "  §8- §7Mit dem Theme ist die Umrandung des Inventar§8'§7s gemeint§8!", "",  "  §8(§c§l!§8) §7Diese Farbe schaltest du ab dem §b§lOPIAT §7Rang frei§8.", ""};
    static String[] theme_gelb_lore = new String[]{"", " §8▰§7▱ §6Information", "  §8- §7Mit dieser Farbe wird dein Theme zu §eGelb§8.", "  §8- §7Mit dem Theme ist die Umrandung des Inventar§8'§7s gemeint§8!", "", "  §8(§c§l!§8) §7Diese Farbe schaltest du ab dem §6§lVALIUM §7Rang frei§8.", ""};
    static String[] theme_gruen_lore = new String[]{"", " §8▰§7▱ §6Information", "  §8- §7Mit dieser Farbe wird dein Theme zu §2Grün§8.", "  §8- §7Mit dem Theme ist die Umrandung des Inventar§8'§7s gemeint§8!", "",  "  §8(§c§l!§8) §7Diese Farbe schaltest du ab dem §d§lBOOSTER §7Rang frei§8.", ""};
    static String[] theme_lila_lore = new String[]{"", " §8▰§7▱ §6Information", "  §8- §7Mit dieser Farbe wird dein Theme zu §5Lila§8.", "  §8- §7Mit dem Theme ist die Umrandung des Inventar§8'§7s gemeint§8!", "",  "  §8(§c§l!§8) §7Diese Farbe schaltest du ab dem §5§lSALVIA §7Rang frei§8.", ""};
    static String[] theme_weiss_lore = new String[]{"", " §8▰§7▱ §6Information", "  §8- §7Mit dieser Farbe wird dein Theme zu §fWeiß§8.", "  §8- §7Mit dem Theme ist die Umrandung des Inventar§8'§7s gemeint§8!", "",  "  §8(§c§l!§8) §7Diese Farbe schaltest du ab dem §c§lEPHEDRA §7Rang frei§8.", ""};

    public static ItemStack rot = new ItemManager(Material.STAINED_CLAY).setData(14).setName("§8»│ §e§lTHE§6§lME §8▰§7▱ §cRot").setLore(theme_rot_lore).build();
    public static ItemStack blau = new ItemManager(Material.STAINED_CLAY).setData(11).setName("§8»│ §e§lTHE§6§lME §8▰§7▱ §bBlau").setLore(theme_blau_lore).build();
    public static ItemStack gelb = new ItemManager(Material.STAINED_CLAY).setData(4).setName("§8»│ §e§lTHE§6§lME §8▰§7▱ §eGelb").setLore(theme_gelb_lore).build();

    public static ItemStack grün = new ItemManager(Material.STAINED_CLAY).setData(13).setName("§8»│ §e§lTHE§6§lME §8▰§7▱ §2Grün").setLore(theme_gruen_lore).build();
    public static ItemStack lila = new ItemManager(Material.STAINED_CLAY).setData(10).setName("§8»│ §e§lTHE§6§lME §8▰§7▱ §5Lila").setLore(theme_lila_lore).build();
    public static ItemStack weiß = new ItemManager(Material.STAINED_CLAY).setData(0).setName("§8»│ §e§lTHE§6§lME §8▰§7▱ §fWeiß").setLore(theme_weiss_lore).build();

    public static ItemStack rot_glowing = new ItemManager(Material.STAINED_CLAY).setData(14).setName("§8»│ §e§lTHE§6§lME §8▰§7▱ §cRot").setGlowing().setLore(theme_rot_lore).build();
    public static ItemStack blau_glowing = new ItemManager(Material.STAINED_CLAY).setData(11).setName("§8»│ §e§lTHE§6§lME §8▰§7▱ §bBlau").setGlowing().setLore(theme_blau_lore).build();
    public static ItemStack gelb_glowing = new ItemManager(Material.STAINED_CLAY).setData(4).setName("§8»│ §e§lTHE§6§lME §8▰§7▱ §eGelb").setGlowing().setLore(theme_gelb_lore).build();

    public static ItemStack grün_glowing = new ItemManager(Material.STAINED_CLAY).setData(13).setName("§8»│ §e§lTHE§6§lME §8▰§7▱ §2Grün").setGlowing().setLore(theme_gruen_lore).build();
    public static ItemStack lila_glowing = new ItemManager(Material.STAINED_CLAY).setData(10).setName("§8»│ §e§lTHE§6§lME §8▰§7▱ §5Lila").setGlowing().setLore(theme_lila_lore).build();
    public static ItemStack weiß_glowing = new ItemManager(Material.STAINED_CLAY).setData(0).setName("§8»│ §e§lTHE§6§lME §8▰§7▱ §fWeiß").setGlowing().setLore(theme_weiss_lore).build();

    // FARBEN

    public static ItemStack rot_glass = new ItemManager(Material.STAINED_GLASS_PANE).setData(14).setName("§8-/-").build();
    public static ItemStack blau_glass = new ItemManager(Material.STAINED_GLASS_PANE).setData(11).setName("§8-/-").build();
    public static ItemStack gelb_glass = new ItemManager(Material.STAINED_GLASS_PANE).setData(4).setName("§8-/-").build();

    public static ItemStack grün_glass = new ItemManager(Material.STAINED_GLASS_PANE).setData(13).setName("§8-/-").build();
    public static ItemStack lila_glass = new ItemManager(Material.STAINED_GLASS_PANE).setData(10).setName("§8-/-").build();
    public static ItemStack weiß_glass = new ItemManager(Material.STAINED_GLASS_PANE).setData(0).setName("§8-/-").build();

    public static void openCookieClickerOptionen(final Player player) {

        Inventory inventory = Bukkit.createInventory(null, 54, PrefixManager.COOKIECLICKER + " §7Cookie Optionen");




        InventoryUtils.fill(inventory, glass);
        InventoryUtils.fillBordersWithTheme(player, inventory);

        inventory.setItem(20, ClickSound); // 29

        if(new CookieSettings(player.getUniqueId()).getClickStatus()) {
            inventory.setItem(29, enabled);
        } else {
            inventory.setItem(29, disabled);
        }

        inventory.setItem(21, ClickTitle); // 30

        if(new CookieSettings(player.getUniqueId()).getTitleStatus()) {
            inventory.setItem(30, enabled);
        } else {
            inventory.setItem(30, disabled);
        }


        // 24,24,25 | 32,33,34


        if(new CookieSettings(player.getUniqueId()).getThemeColor() == "rot") {
            inventory.setItem(32, blau);
            inventory.setItem(24, gelb);
            inventory.setItem(25, grün);
            inventory.setItem(23, weiß);
            inventory.setItem(33, lila);
            inventory.setItem(34, rot_glowing);
        } else if(new CookieSettings(player.getUniqueId()).getThemeColor() == "weiss") {
            inventory.setItem(32, blau);
            inventory.setItem(24, gelb);
            inventory.setItem(25, grün);
            inventory.setItem(23, weiß_glowing);
            inventory.setItem(33, lila);
            inventory.setItem(34, rot);
        } else if(new CookieSettings(player.getUniqueId()).getThemeColor() == "gruen") {
            inventory.setItem(32, blau);
            inventory.setItem(24, gelb);
            inventory.setItem(25, grün_glowing);
            inventory.setItem(23, weiß);
            inventory.setItem(33, lila);
            inventory.setItem(34, rot);
        } else if(new CookieSettings(player.getUniqueId()).getThemeColor() == "lila") {
            inventory.setItem(32, blau);
            inventory.setItem(24, gelb);
            inventory.setItem(25, grün);
            inventory.setItem(23, weiß);
            inventory.setItem(33, lila_glowing);
            inventory.setItem(34, rot);
        } else if(new CookieSettings(player.getUniqueId()).getThemeColor() == "blau") {
            inventory.setItem(32, blau_glowing);
            inventory.setItem(24, gelb);
            inventory.setItem(25, grün);
            inventory.setItem(23, weiß);
            inventory.setItem(33, lila);
            inventory.setItem(34, rot);
        } else if(new CookieSettings(player.getUniqueId()).getThemeColor() == "gelb") {
            inventory.setItem(32, blau);
            inventory.setItem(24, gelb_glowing);
            inventory.setItem(25, grün);
            inventory.setItem(23, weiß);
            inventory.setItem(33, lila);
            inventory.setItem(34, rot);
        } else {
            inventory.setItem(32, blau);
            inventory.setItem(24, gelb);
            inventory.setItem(25, grün);
            inventory.setItem(23, weiß);
            inventory.setItem(33, lila);
            inventory.setItem(34, rot);
        }



        inventory.setItem(39, zurück);
        inventory.setItem(41, reset);



        player.closeInventory();
        player.openInventory(inventory);
        player.playSound(player.getLocation(), Sound.HORSE_ARMOR, 1.5F, 14.8F);
    }


    static int kurs;

    public static void openCookieClickerWechsler(final Player player) {

        if(new CookieAPI(player.getUniqueId()).getCookies() > 99) {
            kurs = new CookieAPI(player.getUniqueId()).getCookies() / 20;
        } else {
            kurs = 0;

        }


        Inventory inventory = Bukkit.createInventory(null, 54, PrefixManager.COOKIECLICKER + " §7Cookie Wechsler");



        ItemStack dispenser = new ItemManager(org.bukkit.Material.DISPENSER).setName("§8»│ §e§lWECH§6§lSLER §8▰§7▱ §7Ausgewählte Coins§8: §6" + CookieAPI.getFormated(new CookieAPI(player.getUniqueId()).getCookies())).build();


        String[] auzahlen100lore = new String[]{"", " §8▰§7▱ §6Information", "  §8- §7Klicke§8, §7um deine §6Cookies §7in §6Tokens §7umzuwandeln§8.", "  §8- §7Du bekommst für §6100 Cookies §8▰§7▱ §65 Tokens§8.", "", "  §8(§c§l!§8) §7Klicke das Item darunter§8,§7 um sie umzuwandeln§8.", ""};
        String[] auszahlen1000lore = new String[]{"", " §8▰§7▱ §6Information", "  §8- §7Klicke§8, §7um deine §6Cookies §7in §6Tokens §7umzuwandeln§8.", "  §8- §7Du bekommst für §61§8'§6000 Cookies §8▰§7▱ §650 Tokens§8.", "", "  §8(§c§l!§8) §7Klicke das Item darunter§8,§7 um sie umzuwandeln§8.", ""};
        String[] auszahlen_allelore = new String[]{"", " §8▰§7▱ §6Information", "  §8- §7Klicke§8, §7um deine §6Cookies §7in §6Tokens §7umzuwandeln§8.", "  §8- §7Du bekommst für §6alle Cookies §8▰§7▱ §e" + CookieAPI.getFormated(kurs) + " Tokens", "", "  §8- §7Du benötigst dafür mindestens §6100 Cookies§8!", "", "  §8(§c§l!§8) §7Klicke das Item darunter§8,§7 um sie umzuwandeln§8.", ""};

        ItemStack auszahlen_100 = new ItemManager(org.bukkit.Material.COOKIE).setName("§8»│ §e§lWECH§6§lSLER §8▰§7▱ §7100 Cookies").setLore(auzahlen100lore).build();
        ItemStack auszahlen_1000 = new ItemManager(org.bukkit.Material.COOKIE).setName("§8»│ §e§lWECH§6§lSLER §8▰§7▱ §71§8'§7000 Cookies").setLore(auszahlen1000lore).build();
        ItemStack auszahlen_alle = new ItemManager(org.bukkit.Material.COOKIE).setName("§8»│ §e§lWECH§6§lSLER §8▰§7▱ §7Alle Cookies").setLore(auszahlen_allelore).build();

        ItemStack auszahlen_button = new ItemManager(org.bukkit.Material.TRIPWIRE_HOOK).setName("§8»│ §e§lWECH§6§lSLER §8▰§7▱ §7Umwandeln").build();


        InventoryUtils.fill(inventory, glass);
        InventoryUtils.fillBordersWithTheme(player, inventory);

        inventory.setItem(37, zurück);

        inventory.setItem(21, auszahlen_100);
        inventory.setItem(22, auszahlen_1000);
        inventory.setItem(23, auszahlen_alle);

        inventory.setItem(30, auszahlen_button);
        inventory.setItem(31, auszahlen_button);
        inventory.setItem(32, auszahlen_button);

        player.closeInventory();
        player.openInventory(inventory);
        player.playSound(player.getLocation(), Sound.HORSE_ARMOR, 1.5F, 14.8F);


    }

    public static void openCookieClickerTokenShop(final Player player) {

        Inventory inventory = Bukkit.createInventory(null, 54, PrefixManager.COOKIECLICKER + " §7Cookie Tokenshop");

        InventoryUtils.fill(inventory, glass);
        InventoryUtils.fillBordersWithTheme(player, inventory);

        inventory.setItem(37, zurück);

        // 20 - 24
        // 29 33


        String[] level1_lore = new String[]{"", " §8▰§7▱ §6Information", "  §8- §7Mit diesem Level bekommst du                       ", "  §8- §7durch das Klicken §65 Cookies§8.", "", " §8▰§7▱ §6Preis", "    §8- §e150§8.§e000 §7Tokens", ""};
        String[] level2_lore = new String[]{"", " §8▰§7▱ §6Information", "  §8- §7Mit diesem Level bekommst du", "  §8- §7durch das Klicken §610 Cookies§8.", "", "  §8(§c§l!§8) §7Du kannst dieses Level nur erwerben§8,", "  §8(§c§l!§8) §7wenn du bereits §eLevel 1§7 besitzt§8.", "", " §8▰§7▱ §6Preis", "  §8- §e300§8.§e000 §7Tokens", ""};
        String[] level3_lore = new String[]{"", " §8▰§7▱ §6Information", "  §8- §7Mit diesem Level bekommst du", "  §8- §7durch das Klicken §615 Cookies§8.", "", "  §8(§c§l!§8) §7Du kannst dieses Level nur erwerben§8,", "  §8(§c§l!§8) §7wenn du bereits §eLevel 2§7 besitzt§8.", "", " §8▰§7▱ §6Preis", "  §8- §e500§8.§e000 §7Tokens", ""};
        String[] level4_lore = new String[]{"", " §8▰§7▱ §6Information", "  §8- §7Mit diesem Level bekommst du", "  §8- §7durch das Klicken §620 Cookies§8.", "", "  §8(§c§l!§8) §7Du kannst dieses Level nur erwerben§8,", "  §8(§c§l!§8) §7wenn du bereits §eLevel 3§7 besitzt§8.", "", " §8▰§7▱ §6Preis", "  §8- §e750§8.§e000 §7Tokens", ""};
        String[] level5_lore = new String[]{"", " §8▰§7▱ §6Information", "  §8- §7Mit diesem Level bekommst du", "  §8- §7durch das Klicken §625 Cookies§8.", "", "  §8(§c§l!§8) §7Du kannst dieses Level nur erwerben§8,", "  §8(§c§l!§8) §7wenn du bereits §eLevel 4§7 besitzt§8.", "", " §8▰§7▱ §6Preis", "  §8- §e1§8.§e000§8.§e000 §7Tokens", ""};

        String[] level1_lore_glowing = new String[]{"", " §8▰§7▱ §6Information", "  §8- §7Mit diesem Level bekommst du                       ", "  §8- §7durch das Klicken §65 Cookies§8.", "", " §8▰§7▱ §6Preis", " §e150§8.§e000 §7Tokens", ""};
        String[] level2_lore_glowing = new String[]{"", " §8▰§7▱ §6Information", "  §8- §7Mit diesem Level bekommst du", "  §8- §7durch das Klicken §610 Cookies§8.", "", "  §8(§c§l!§8) §7Du kannst dieses Level nur erwerben§8,", "  §8(§c§l!§8) §7wenn du bereits §eLevel 1§7 besitzt§8.", "", " §8▰§7▱ §6Dieses Level besitzt du aktuell§8.", ""};
        String[] level3_lore_glowing = new String[]{"", " §8▰§7▱ §6Information", "  §8- §7Mit diesem Level bekommst du", "  §8- §7durch das Klicken §615 Cookies§8.", "", "  §8(§c§l!§8) §7Du kannst dieses Level nur erwerben§8,", "  §8(§c§l!§8) §7wenn du bereits §eLevel 2§7 besitzt§8.", "", " §8▰§7▱ §6Dieses Level besitzt du aktuell§8.", ""};
        String[] level4_lore_glowing = new String[]{"", " §8▰§7▱ §6Information", "  §8- §7Mit diesem Level bekommst du", "  §8- §7durch das Klicken §620 Cookies§8.", "", "  §8(§c§l!§8) §7Du kannst dieses Level nur erwerben§8,", "  §8(§c§l!§8) §7wenn du bereits §eLevel 3§7 besitzt§8.", "", " §8▰§7▱ §6Dieses Level besitzt du aktuell§8.", ""};
        String[] level5_lore_glowing = new String[]{"", " §8▰§7▱ §6Information", "  §8- §7Mit diesem Level bekommst du", "  §8- §7durch das Klicken §625 Cookies§8.", "", "  §8(§c§l!§8) §7Du kannst dieses Level nur erwerben§8,", "  §8(§c§l!§8) §7wenn du bereits §eLevel 4§7 besitzt§8.", "", " §8▰§7▱ §6Dieses Level besitzt du aktuell§8.", ""};


        ItemStack level1 = new ItemManager(Material.WOOD_HOE).setName("§8»│ §e§lLEV§6§lEL §8▰§7▱ §71").setLore(level1_lore).hideAttackDamage().build();
        ItemStack level2 = new ItemManager(Material.WOOD_PICKAXE).setName("§8»│ §e§lLEV§6§lEL §8▰§7▱ §72").setLore(level2_lore).hideAttackDamage().build();
        ItemStack level3 = new ItemManager(Material.IRON_SPADE).setName("§8»│ §e§lLEV§6§lEL §8▰§7▱ §73").setLore(level3_lore).hideAttackDamage().build();
        ItemStack level4 = new ItemManager(Material.DIAMOND_AXE).setName("§8»│ §e§lLEV§6§lEL §8▰§7▱ §74").setLore(level4_lore).hideAttackDamage().build();
        ItemStack level5 = new ItemManager(Material.DIAMOND_PICKAXE).setName("§8»│ §e§lLEV§6§lEL §8▰§7▱ §75").setLore(level5_lore).hideAttackDamage().build();



        ItemStack weiter = ItemSkullManager.getSkull("§8»│ §7Nächste Seite", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTliZjMyOTJlMTI2YTEwNWI1NGViYTcxM2FhMWIxNTJkNTQxYTFkODkzODgyOWM1NjM2NGQxNzhlZDIyYmYifX19", null);


        ItemStack level1_glowing = new ItemManager(Material.WOOD_HOE).setName("§8»│ §e§lLEV§6§lEL §8▰§7▱ §71").setLore(level1_lore_glowing).setGlowing().hideAttackDamage().build();
        ItemStack level2_glowing = new ItemManager(Material.WOOD_PICKAXE).setName("§8»│ §e§lLEV§6§lEL §8▰§7▱ §72").setLore(level2_lore_glowing).setGlowing().hideAttackDamage().build();
        ItemStack level3_glowing = new ItemManager(Material.IRON_SPADE).setName("§8»│ §e§lLEV§6§lEL §8▰§7▱ §73").setLore(level3_lore_glowing).setGlowing().hideAttackDamage().build();
        ItemStack level4_glowing = new ItemManager(Material.DIAMOND_AXE).setName("§8»│ §e§lLEV§6§lEL §8▰§7▱ §74").setLore(level4_lore_glowing).setGlowing().hideAttackDamage().build();
        ItemStack level5_glowing = new ItemManager(Material.DIAMOND_PICKAXE).setName("§8»│ §e§lLEV§6§lEL §8▰§7▱ §75").setLore(level5_lore_glowing).setGlowing().hideAttackDamage().build();


        ItemStack levelother = new ItemManager(Material.STAINED_GLASS_PANE).setData(14).setAnzahl(-1).setName("§8-/-").build();

        String[] info_lore = new String[]{"", " §8▰§7▱ §6Information", "  §8- §7Die aufgelisteten Items können", "  §8- §7nur mit §6Tokens§7 erworben werden§8.", "", "  §8(§c§l!§8) §7Auf der nächsten Seite findest du weitere", "  §8(§c§l!§8) §7Items die mit §6Cookies§7 erworben werden können§8.", ""};

        ItemStack info = new ItemManager(Material.DOUBLE_PLANT).setName("§8»│ §e§lINFOR§6§lMATION §8▰§7▱ §7Token Shop").setLore(info_lore).build();

        String[] keksfarmer_lore = new String[]{
                "",
                " §8▰§7▱ §6Information",
                "  §8- §7Der §eKeksfarmer §7ermöglicht es dir§8,",
                "  §8- §eCookies §7zu farmen§8, §7egal ob du §6online",
                "  §8- §7oder §6offline §7bist§8.",
                "  §8- §7Dieser generiert dir jede Minute §61 Cookie§8.",
                "",
                " §8▰§7▱ §6Preis",
                "  §8- §e2§8.§e000§8.§e000 §7Tokens",
                ""
        };

        ItemStack keksfarmer = new ItemManager(Material.GOLD_NUGGET).setName("§8»│ §e§lKEKS§6§lFARMER").setLore(keksfarmer_lore).build();


        if(new CookieSettings(player.getUniqueId()).getLevel() == 1) {
            inventory.setItem(20, level1_glowing);
            inventory.setItem(21, level2);
            inventory.setItem(22, level3);
            inventory.setItem(23, level4);
            inventory.setItem(24, level5);
        } else if(new CookieSettings(player.getUniqueId()).getLevel() == 2) {
            inventory.setItem(20, level1);
            inventory.setItem(21, level2_glowing);
            inventory.setItem(22, level3);
            inventory.setItem(23, level4);
            inventory.setItem(24, level5);
        } else if(new CookieSettings(player.getUniqueId()).getLevel() == 3) {
            inventory.setItem(20, level1);
            inventory.setItem(21, level2);
            inventory.setItem(22, level3_glowing);
            inventory.setItem(23, level4);
            inventory.setItem(24, level5);
        } else if(new CookieSettings(player.getUniqueId()).getLevel() == 4) {
            inventory.setItem(20, level1);
            inventory.setItem(21, level2);
            inventory.setItem(22, level3);
            inventory.setItem(23, level4_glowing);
            inventory.setItem(24, level5);
        } else if(new CookieSettings(player.getUniqueId()).getLevel() == 5) {
            inventory.setItem(20, level1);
            inventory.setItem(21, level2);
            inventory.setItem(22, level3);
            inventory.setItem(23, level4);
            inventory.setItem(24, level5_glowing);
        } else {
            inventory.setItem(20, level1);
            inventory.setItem(21, level2);
            inventory.setItem(22, level3);
            inventory.setItem(23, level4);
            inventory.setItem(24, level5);
        }
        inventory.setItem(13, info);
        inventory.setItem(43, weiter);

        inventory.setItem(29, keksfarmer);

        for(int i = 30; i < 34; i++) {
            inventory.setItem(i, levelother);

        }





        player.closeInventory();
        player.openInventory(inventory);
        player.playSound(player.getLocation(), Sound.HORSE_ARMOR, 1.5F, 14.8F);

    }

    public static void openCookieClickerCookieShop(final Player player) {


        Inventory inventory = Bukkit.createInventory(null, 54, PrefixManager.COOKIECLICKER + " §7Cookie Cookieshop");

        InventoryUtils.fill(inventory, glass);
        InventoryUtils.fillBordersWithTheme(player, inventory);

        inventory.setItem(37, zurück);

        String[] info_lore = new String[]{"", " §8▰§7▱ §6Information", "  §8- §7Die aufgelisteten Items können", "  §8- §7nur mit §6Cookies§7 erworben werden§8.", "", "  §8(§c§l!§8) §7Auf der vorherigen Seite findest du weitere", "  §8(§c§l!§8) §7Items die mit §6Tokens§7 erworben werden können§8.", ""};
        String[] cookiearmor_lore = new String[]{"", " §8▰§7▱ §6Information", "  §8- §7Die §6Cookie §7Rüstung ist sehr stark gegenüber", "  §8- §7den anderen Rüstungen und bringt einen großen Vorteil§8!", "", " §8▰§7▱ §6Beim Kauf bekommst du§8:", "  §8- §7§eProt 6 §7Eisenhelm §8(§61§7x§8)", "  §8- §7§eProt 6 §7Eisenbrustplatte §8(§61§7x§8)", "  §8- §7§eProt 6 §7Eisenhose §8(§61§7x§8)", "  §8- §7§eProt 6 §7Eisenschuhe §8(§61§7x§8)", "", " §8▰§7▱ §6Preis", "  §8- §e25§8.§e000 §7Cookies", ""};
        String[] cookiesword_lore = new String[]{"", " §8▰§7▱ §6Information", "  §8- §7Das §6Cookie §7Schwert ist sehr mächtig gegenüber", "  §8- §7den anderen Schwertern und bringt einen großen Vorteil§8!", "", " §8▰§7▱ §6Beim Kauf bekommst du§8:", "  §8- §7§eSharp 6 §7Eisenschwert §8(§61§7x§8)", "", " §8▰§7▱ §6Preis", "  §8- §e15§8.§e000 §7Cookies", ""};

        ItemStack info = new ItemManager(Material.DOUBLE_PLANT).setName("§8»│ §e§lINFOR§6§lMATION §8▰§7▱ §7Token Shop").setLore(info_lore).build();
        ItemStack cookiearmor = new ItemManager(Material.IRON_CHESTPLATE).setName("§8»│ §e§lCOOKIE §6§LRÜSTUNG").setLore(cookiearmor_lore).build();
        ItemStack cookiesword = new ItemManager(Material.IRON_SWORD).setName("§8»│ §e§lCOOKIE §6§LSCHWERT").setLore(cookiesword_lore).hideAttackDamage().build();

        inventory.setItem(13, info);
        inventory.setItem(20, cookiearmor);
        inventory.setItem(21, cookiesword);

        player.openInventory(inventory);
        player.playSound(player.getLocation(), Sound.HORSE_ARMOR, 1.5F, 14.8F);

    }
}

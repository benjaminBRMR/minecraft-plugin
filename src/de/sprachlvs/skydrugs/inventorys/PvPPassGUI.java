package de.sprachlvs.skydrugs.inventorys;

import de.sprachlvs.skydrugs.apis.stats.KillAPI;
import de.sprachlvs.skydrugs.manager.ItemManager;
import de.sprachlvs.skydrugs.manager.ItemSkullManager;
import de.sprachlvs.skydrugs.manager.PvPPassManager;
import de.sprachlvs.skydrugs.utils.InventoryUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

public class PvPPassGUI {

    public static String
        CURRENTSITE = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGNlZWI3N2Q0ZDI1NzI0YTljYWYyYzdjZGYyZDg4Mzk5YjE0MTdjNmI5ZmY1MjEzNjU5YjY1M2JlNDM3NmUzIn19fQ==",
        NEXTSITE = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTliZjMyOTJlMTI2YTEwNWI1NGViYTcxM2FhMWIxNTJkNTQxYTFkODkzODgyOWM1NjM2NGQxNzhlZDIyYmYifX19",
        BACKSITE = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYmQ2OWUwNmU1ZGFkZmQ4NGU1ZjNkMWMyMTA2M2YyNTUzYjJmYTk0NWVlMWQ0ZDcxNTJmZGM1NDI1YmMxMmE5In19fQ==";

    public static ItemStack Stufe1Claimed = new ItemManager(Material.BARRIER).setName("§8»│ §6§lStufe 1 §8▰§7▱ §7Bereits abgeholt").setLore(new String[]{
            "",
            " §8▰§7▱ §6Belohnungen§8:",
            "  §8- §e1.000 §7Tokens",
            "  §8- §7Doppelte Belohnung für den §5Salvia §7Rang§8.",
            "",
            "§7Diese Belohnung hast du bereits abgeholt§8.",
            ""
    }).setAnzahl(1).build();

    public static ItemStack Stufe2Claimed = new ItemManager(Material.BARRIER).setName("§8»│ §6§lStufe 2 §8▰§7▱ §7Bereits abgeholt").setLore(new String[]{
            "",
            " §8▰§7▱ §6Belohnungen§8:",
            "  §8- §eProt 2 §7Diamanthelm §8(§61§7x§8)",
            "  §8- §eProt 2 §7Diamantbrustplatte §8(§61§7x§8)",
            "  §8- §eProt 2 §7Diamanthose §8(§61§7x§8)",
            "  §8- §eProt 2 §7Diamantschuhe §8(§61§7x§8)",
            "  §8- §eSharp 2 §7Diamantschwert §8(§61§7x§8)",
            "  §8- §7Doppelte Belohnung für den §5Salvia §7Rang§8.",
            "",
            "§7Diese Belohnung hast du bereits abgeholt§8.",
            ""
    }).setAnzahl(1).build();

    public static ItemStack Stufe3Claimed = new ItemManager(Material.BARRIER).setName("§8»│ §6§lStufe 3 §8▰§7▱ §7Bereits abgeholt").setLore(new String[]{
            "",
            " §8▰§7▱ §6Belohnungen§8:",
            "  §8- §e3§8x §aSkyblock §7Schlüssel",
            "  §8- §7Doppelte Belohnung für den §5Salvia §7Rang§8.",
            "",
            "§7Diese Belohnung hast du bereits abgeholt§8.",
            ""
    }).setAnzahl(1).build();

    public static ItemStack Stufe4Claimed = new ItemManager(Material.BARRIER).setName("§8»│ §6§lStufe 4 §8▰§7▱ §7Bereits abgeholt").setLore(new String[]{
            "",
            " §8▰§7▱ §6Belohnungen§8:",
            "  §8- §e1§8x §cAlles§4Oder§cNichts §7Schlüssel",
            "  §8- §7Doppelte Belohnung für den §5Salvia §7Rang§8.",
            "",
            "§7Diese Belohnung hast du bereits abgeholt§8.",
            ""
    }).setAnzahl(1).build();

    public static ItemStack Stufe5Claimed = new ItemManager(Material.BARRIER).setName("§8»│ §6§lStufe 5 §8▰§7▱ §7Bereits abgeholt").setLore(new String[]{
            "",
            " §8▰§7▱ §6Belohnungen§8:",
            "  §8- §e1§8x §7Beacon",
            "  §8- §7Doppelte Belohnung für den §5Salvia §7Rang§8.",
            "",
            "§7Diese Belohnung hast du bereits abgeholt§8.",
            ""
    }).setAnzahl(1).build();

    public static ItemStack Stufe6Claimed = new ItemManager(Material.BARRIER).setName("§8»│ §6§lStufe 6 §8▰§7▱ §7Bereits abgeholt").setLore(new String[]{
            "",
            " §8▰§7▱ §6Belohnungen§8:",
            "  §8- §e5000 §7Tokens",
            "  §8- §7Doppelte Belohnung für den §5Salvia §7Rang§8.",
            "",
            "§7Diese Belohnung hast du bereits abgeholt§8.",
            ""
    }).setAnzahl(1).build();

    public static ItemStack Stufe7Claimed = new ItemManager(Material.BARRIER).setName("§8»│ §6§lStufe 7 §8▰§7▱ §7Bereits abgeholt").setLore(new String[]{
            "",
            " §8▰§7▱ §6Belohnungen§8:",
            "  §8- §e1§8x §6Zufälliges Spawnegg",
            "  §8- §7Doppelte Belohnung für den §5Salvia §7Rang§8.",
            "",
            "§7Diese Belohnung hast du bereits abgeholt§8.",
            ""
    }).setAnzahl(1).build();

    public static ItemStack Stufe8Claimed = new ItemManager(Material.BARRIER).setName("§8»│ §6§lStufe 8 §8▰§7▱ §7Bereits abgeholt").setLore(new String[]{
            "",
            " §8▰§7▱ §6Belohnungen§8:",
            "  §8- §e1§8x §5Salvia §7Schlüssel",
            "  §8- §7Doppelte Belohnung für den §5Salvia §7Rang§8.",
            "",
            "§7Diese Belohnung hast du bereits abgeholt§8.",
            ""
    }).setAnzahl(1).build();

    public static ItemStack Stufe9Claimed = new ItemManager(Material.BARRIER).setName("§8»│ §6§lStufe 9 §8▰§7▱ §7Bereits abgeholt").setLore(new String[]{
            "",
            " §8▰§7▱ §6Belohnungen§8:",
            "  §8- §e12§8x §7Goldäpfel",
            "  §8- §7Doppelte Belohnung für den §5Salvia §7Rang§8.",
            "",
            "§7Diese Belohnung hast du bereits abgeholt§8.",
            ""
    }).setAnzahl(1).build();

    public static ItemStack Stufe10Claimed = new ItemManager(Material.BARRIER).setName("§8»│ §6§lStufe 10 §8▰§7▱ §7Bereits abgeholt").setLore(new String[]{
            "",
            " §8▰§7▱ §6Belohnungen§8:",
            "  §8- §e1§8x §8»│ §a§lFLY §7Gutschein §8(§230§7min.§8)",
            "  §8- §7Doppelte Belohnung für den §5Salvia §7Rang§8.",
            "",
            "§7Diese Belohnung hast du bereits abgeholt§8.",
            ""
    }).setAnzahl(1).build();

    public static ItemStack Stufe11Claimed = new ItemManager(Material.BARRIER).setName("§8»│ §6§lStufe 11 §8▰§7▱ §7Bereits abgeholt").setLore(new String[]{
            "",
            " §8▰§7▱ §6Belohnungen§8:",
            "  §8- §e15.000 §7Tokens",
            "  §8- §7Doppelte Belohnung für den §5Salvia §7Rang§8.",
            "",
            "§7Diese Belohnung hast du bereits abgeholt§8.",
            ""
    }).setAnzahl(1).build();

    public static ItemStack Stufe12Claimed = new ItemManager(Material.BARRIER).setName("§8»│ §6§lStufe 12 §8▰§7▱ §7Bereits abgeholt").setLore(new String[]{
            "",
            " §8▰§7▱ §6Belohnungen§8:",
            "  §8- §eProt 3 §7Diamanthelm §8(§61§7x§8)",
            "  §8- §eProt 3 §7Diamantbrustplatte §8(§61§7x§8)",
            "  §8- §eProt 3 §7Diamanthose §8(§61§7x§8)",
            "  §8- §eProt 3 §7Diamantschuhe §8(§61§7x§8)",
            "  §8- §eSharp 3 §7Diamantschwert §8(§61§7x§8)",
            "  §8- §7Doppelte Belohnung für den §5Salvia §7Rang§8.",
            "",
            "§7Diese Belohnung hast du bereits abgeholt§8.",
            ""
    }).setAnzahl(1).build();

    public static ItemStack Stufe13Claimed = new ItemManager(Material.BARRIER).setName("§8»│ §6§lStufe 13 §8▰§7▱ §7Bereits abgeholt").setLore(new String[]{
            "",
            " §8▰§7▱ §6Belohnungen§8:",
            "  §8- §e1§8x §7Regenerationstrank",
            "  §8- §e1§8x §7Sprungkrafttrank",
            "  §8- §e1§8x §7Schnelligkeitstrank",
            "  §8- §e1§8x §7Stärketrank",
            "  §8- §e1§8x §7Feuerressistenztrank",
            "  §8- §7Doppelte Belohnung für den §5Salvia §7Rang§8.",
            "",
            "§7Diese Belohnung hast du bereits abgeholt§8.",
            ""
    }).setAnzahl(1).build();

    public static ItemStack Stufe14Claimed = new ItemManager(Material.BARRIER).setName("§8»│ §6§lStufe 14 §8▰§7▱ §7Bereits abgeholt").setLore(new String[]{
            "",
            " §8▰§7▱ §6Belohnungen§8:",
            "  §8- §e16§8x §aSkyblock §7Schlüssel",
            "  §8- §7Doppelte Belohnung für den §5Salvia §7Rang§8.",
            "",
            "§7Diese Belohnung hast du bereits abgeholt§8.",
            ""
    }).setAnzahl(1).build();

    public static void openPvPPassInventorySite2(Player player) {
        Inventory inv = Bukkit.createInventory((InventoryHolder) null, 27, "§8»│ §6§lPVP§8 - §6§lPASS §7S2");

        ItemStack yellowglass = new ItemManager(Material.STAINED_GLASS_PANE).setData(4).setName("§8-/-§r").setAnzahl(1).build();
        ItemStack redglass = new ItemManager(Material.STAINED_GLASS_PANE).setData(14).setName("§8-/-§r").setAnzahl(-1).build();
        ItemStack currentsite = ItemSkullManager.getSkull("§8»│ §6Aktuelle Seite §8▰§7▱ §e2", CURRENTSITE, null);
        ItemStack backsite = ItemSkullManager.getSkull("§8»│ §6Vorherige Seite", BACKSITE, new String[]{
                "§8┃ §7Klicke§8, §7um auf die vorherige Seite zu gelangen§8."});

        InventoryUtils.fillBorders(inv, yellowglass);

        ItemStack Stufe8Available = new ItemManager(Material.TRIPWIRE_HOOK).setName("§8»│ §6§lStufe 8 §8▰§7▱ §7Abholbereit").setLore(new String[]{
                "",
                " §8▰§7▱ §6Belohnungen§8:",
                "  §8- §e1§8x §5Salvia §7Schlüssel",
                "  §8- §7Doppelte Belohnung für den §5Salvia §7Rang§8.",
                "",
                "§7Klicke§8, §7um deine Belohnung abzuholen§8.",
                ""
        }).setAnzahl(1).build();

        ItemStack Stufe8Unavailable = new ItemManager(Material.CLAY_BALL).setName("§8»│ §6§lStufe 8 §8▰§7▱ §7Noch nicht abholbereit").setLore(new String[]{
                "",
                " §8▰§7▱ §6Voraussetzung§8:",
                "  §8- §e40 §7Kills",
                "",
                " §8▰§7▱ §6Belohnungen§8:",
                "  §8- §e1§8x §5Salvia §7Schlüssel",
                "  §8- §7Doppelte Belohnung für den §5Salvia §7Rang§8.",
                "",
                "§7Diese Belohnung ist noch nicht abholbereit§8.",
                ""
        }).setAnzahl(1).build();

        ItemStack Stufe9Available = new ItemManager(Material.GOLDEN_APPLE).setData(1).setName("§8»│ §6§lStufe 9 §8▰§7▱ §7Abholbereit").setLore(new String[]{
                "",
                " §8▰§7▱ §6Belohnungen§8:",
                "  §8- §e12§8x §7Goldäpfel",
                "  §8- §7Doppelte Belohnung für den §5Salvia §7Rang§8.",
                "",
                "§7Klicke§8, §7um deine Belohnung abzuholen§8.",
                ""
        }).setAnzahl(1).build();

        ItemStack Stufe9Unavailable = new ItemManager(Material.CLAY_BALL).setName("§8»│ §6§lStufe 9 §8▰§7▱ §7Noch nicht abholbereit").setLore(new String[]{
                "",
                " §8▰§7▱ §6Voraussetzung§8:",
                "  §8- §e45 §7Kills",
                "",
                " §8▰§7▱ §6Belohnungen§8:",
                "  §8- §e12§8x §7Goldäpfel",
                "  §8- §7Doppelte Belohnung für den §5Salvia §7Rang§8.",
                "",
                "§7Diese Belohnung ist noch nicht abholbereit§8.",
                ""
        }).setAnzahl(1).build();

        ItemStack Stufe10Available = new ItemManager(Material.PAPER).setName("§8»│ §6§lStufe 10 §8▰§7▱ §7Abholbereit").setLore(new String[]{
                "",
                " §8▰§7▱ §6Belohnungen§8:",
                "  §8- §e1§8x §8»│ §a§lFLY §7Gutschein §8(§230§7min.§8)",
                "  §8- §7Doppelte Belohnung für den §5Salvia §7Rang§8.",
                "",
                "§7Klicke§8, §7um deine Belohnung abzuholen§8.",
                ""
        }).setAnzahl(1).build();

        ItemStack Stufe10Unavailable = new ItemManager(Material.CLAY_BALL).setName("§8»│ §6§lStufe 10 §8▰§7▱ §7Noch nicht abholbereit").setLore(new String[]{
                "",
                " §8▰§7▱ §6Voraussetzung§8:",
                "  §8- §e50 §7Kills",
                "",
                " §8▰§7▱ §6Belohnungen§8:",
                "  §8- §e1§8x §8»│ §a§lFLY §7Gutschein §8(§230§7min.§8)",
                "  §8- §7Doppelte Belohnung für den §5Salvia §7Rang§8.",
                "",
                "§7Diese Belohnung ist noch nicht abholbereit§8.",
                ""
        }).setAnzahl(1).build();

        ItemStack Stufe11Available = new ItemManager(Material.GOLD_BLOCK).setName("§8»│ §6§lStufe 11 §8▰§7▱ §7Abholbereit").setLore(new String[]{
                "",
                " §8▰§7▱ §6Belohnungen§8:",
                "  §8- §e15.000 §7Tokens",
                "  §8- §7Doppelte Belohnung für den §5Salvia §7Rang§8.",
                "",
                "§7Klicke§8, §7um deine Belohnung abzuholen§8.",
                ""
        }).setAnzahl(1).build();

        ItemStack Stufe11Unavailable = new ItemManager(Material.CLAY_BALL).setName("§8»│ §6§lStufe 11 §8▰§7▱ §7Noch nicht abholbereit").setLore(new String[]{
                "",
                " §8▰§7▱ §6Voraussetzung§8:",
                "  §8- §e55 §7Kills",
                "",
                " §8▰§7▱ §6Belohnungen§8:",
                "  §8- §e15.000 §7Tokens",
                "  §8- §7Doppelte Belohnung für den §5Salvia §7Rang§8.",
                "",
                "§7Diese Belohnung ist noch nicht abholbereit§8.",
                ""
        }).setAnzahl(1).build();

        ItemStack Stufe12Available = new ItemManager(Material.DIAMOND_HELMET).setName("§8»│ §6§lStufe 12 §8▰§7▱ §7Abholbereit").setLore(new String[]{
                "",
                " §8▰§7▱ §6Belohnungen§8:",
                "  §8- §eProt 3 §7Diamanthelm §8(§61§7x§8)",
                "  §8- §eProt 3 §7Diamantbrustplatte §8(§61§7x§8)",
                "  §8- §eProt 3 §7Diamanthose §8(§61§7x§8)",
                "  §8- §eProt 3 §7Diamantschuhe §8(§61§7x§8)",
                "  §8- §eSharp 3 §7Diamantschwert §8(§61§7x§8)",
                "  §8- §7Doppelte Belohnung für den §5Salvia §7Rang§8.",
                "",
                "§7Klicke§8, §7um deine Belohnung abzuholen§8.",
                ""
        }).setAnzahl(1).build();

        ItemStack Stufe12Unavailable = new ItemManager(Material.CLAY_BALL).setName("§8»│ §6§lStufe 12 §8▰§7▱ §7Noch nicht abholbereit").setLore(new String[]{
                "",
                " §8▰§7▱ §6Voraussetzung§8:",
                "  §8- §e60 §7Kills",
                "",
                " §8▰§7▱ §6Belohnungen§8:",
                "  §8- §eProt 3 §7Diamanthelm §8(§61§7x§8)",
                "  §8- §eProt 3 §7Diamantbrustplatte §8(§61§7x§8)",
                "  §8- §eProt 3 §7Diamanthose §8(§61§7x§8)",
                "  §8- §eProt 3 §7Diamantschuhe §8(§61§7x§8)",
                "  §8- §eSharp 3 §7Diamantschwert §8(§61§7x§8)",
                "  §8- §7Doppelte Belohnung für den §5Salvia §7Rang§8.",
                "",
                "§7Diese Belohnung ist noch nicht abholbereit§8.",
                ""
        }).setAnzahl(1).build();

        ItemStack Stufe13Available = new ItemManager(Material.POTION).setName("§8»│ §6§lStufe 13 §8▰§7▱ §7Abholbereit").setLore(new String[]{
                "",
                " §8▰§7▱ §6Belohnungen§8:",
                "  §8- §e1§8x §7Regenerationstrank",
                "  §8- §e1§8x §7Sprungkrafttrank",
                "  §8- §e1§8x §7Schnelligkeitstrank",
                "  §8- §e1§8x §7Stärketrank",
                "  §8- §e1§8x §7Feuerressistenztrank",
                "  §8- §7Doppelte Belohnung für den §5Salvia §7Rang§8.",
                "",
                "§7Klicke§8, §7um deine Belohnung abzuholen§8.",
                ""
        }).setAnzahl(1).build();

        ItemStack Stufe13Unavailable = new ItemManager(Material.CLAY_BALL).setName("§8»│ §6§lStufe 13 §8▰§7▱ §7Noch nicht abholbereit").setLore(new String[]{
                "",
                " §8▰§7▱ §6Voraussetzung§8:",
                "  §8- §e65 §7Kills",
                "",
                " §8▰§7▱ §6Belohnungen§8:",
                "  §8- §e1§8x §7Regenerationstrank",
                "  §8- §e1§8x §7Sprungkrafttrank",
                "  §8- §e1§8x §7Schnelligkeitstrank",
                "  §8- §e1§8x §7Stärketrank",
                "  §8- §e1§8x §7Feuerressistenztrank",
                "  §8- §7Doppelte Belohnung für den §5Salvia §7Rang§8.",
                "",
                "§7Diese Belohnung ist noch nicht abholbereit§8.",
                ""
        }).setAnzahl(1).build();

        ItemStack Stufe14Available = new ItemManager(Material.TRIPWIRE_HOOK).setName("§8»│ §6§lStufe 14 §8▰§7▱ §7Abholbereit").setLore(new String[]{
                "",
                " §8▰§7▱ §6Belohnungen§8:",
                "  §8- §e16§8x §aSkyblock §7Schlüssel",
                "  §8- §7Doppelte Belohnung für den §5Salvia §7Rang§8.",
                "",
                "§7Klicke§8, §7um deine Belohnung abzuholen§8.",
                ""
        }).setAnzahl(1).build();

        ItemStack Stufe14Unavailable = new ItemManager(Material.CLAY_BALL).setName("§8»│ §6§lStufe 14 §8▰§7▱ §7Noch nicht abholbereit").setLore(new String[]{
                "",
                " §8▰§7▱ §6Voraussetzung§8:",
                "  §8- §e70 §7Kills",
                "",
                " §8▰§7▱ §6Belohnungen§8:",
                "  §8- §e16§8x §aSkyblock §7Schlüssel",
                "  §8- §7Doppelte Belohnung für den §5Salvia §7Rang§8.",
                "",
                "§7Diese Belohnung ist noch nicht abholbereit§8.",
                ""
        }).setAnzahl(1).build();

        inv.setItem(22, currentsite);
        inv.setItem(23, redglass);
        inv.setItem(21, backsite);

        if(new KillAPI(player).getKills() > 39) {
            if(!new PvPPassManager().getStufe(player.getUniqueId(), 8)) {
                inv.setItem(10, Stufe8Available);
            } else {
                inv.setItem(10, Stufe8Claimed);
            }
        } else {
            inv.setItem(10, Stufe8Unavailable);
        }

        if(new KillAPI(player).getKills() > 44) {
            if(!new PvPPassManager().getStufe(player.getUniqueId(), 9)) {
                inv.setItem(11, Stufe9Available);
            } else {
                inv.setItem(11, Stufe9Claimed);
            }
        } else {
            inv.setItem(11, Stufe9Unavailable);
        }

        if(new KillAPI(player).getKills() > 49) {
            if(!new PvPPassManager().getStufe(player.getUniqueId(), 10)) {
                inv.setItem(12, Stufe10Available);
            } else {
                inv.setItem(12, Stufe10Claimed);
            }
        } else {
            inv.setItem(12, Stufe10Unavailable);
        }

        if(new KillAPI(player).getKills() > 54) {
            if(!new PvPPassManager().getStufe(player.getUniqueId(), 11)) {
                inv.setItem(13, Stufe11Available);
            } else {
                inv.setItem(13, Stufe11Claimed);
            }
        } else {
            inv.setItem(13, Stufe11Unavailable);
        }

        if(new KillAPI(player).getKills() > 59) {
            if(!new PvPPassManager().getStufe(player.getUniqueId(), 12)) {
                inv.setItem(14, Stufe12Available);
            } else {
                inv.setItem(14, Stufe12Claimed);
            }
        } else {
            inv.setItem(14, Stufe12Unavailable);
        }

        if(new KillAPI(player).getKills() > 64) {
            if(!new PvPPassManager().getStufe(player.getUniqueId(), 13)) {
                inv.setItem(15, Stufe13Available);
            } else {
                inv.setItem(15, Stufe13Claimed);
            }
        } else {
            inv.setItem(15, Stufe13Unavailable);
        }

        if(new KillAPI(player).getKills() > 69) {
            if(!new PvPPassManager().getStufe(player.getUniqueId(),14)) {
                inv.setItem(16, Stufe14Available);
            } else {
                inv.setItem(16, Stufe14Claimed);
            }
        } else {
            inv.setItem(16, Stufe14Unavailable);
        }

        player.openInventory(inv);
    }

    public static void openPvPPassInventorySite1(Player player) {

        Inventory inv = Bukkit.createInventory((InventoryHolder) null, 27, "§8»│ §6§lPVP§8 - §6§lPASS §7S1");

        ItemStack yellowglass = new ItemManager(Material.STAINED_GLASS_PANE).setData(4).setName("§8-/-§r").setAnzahl(1).build();
        ItemStack redglass = new ItemManager(Material.STAINED_GLASS_PANE).setData(14).setName("§8-/-§r").setAnzahl(-1).build();
        ItemStack currentsite = ItemSkullManager.getSkull("§8»│ §6Aktuelle Seite §8▰§7▱ §e1", CURRENTSITE, null);
        ItemStack nextsite = ItemSkullManager.getSkull("§8»│ §6Nächste Seite", NEXTSITE, new String[]{
                "§8┃ §7Klicke§8, §7um auf die nächste Seite zu gelangen§8."});

        InventoryUtils.fillBorders(inv, yellowglass);

        ItemStack Stufe1Available = new ItemManager(Material.GOLD_NUGGET).setName("§8»│ §6§lStufe 1 §8▰§7▱ §7Abholbereit").setLore(new String[]{
                "",
                " §8▰§7▱ §6Belohnungen§8:",
                "  §8- §e1.000 §7Tokens",
                "  §8- §7Doppelte Belohnung für den §5Salvia §7Rang§8.",
                "",
                "§7Klicke§8, §7um deine Belohnung abzuholen§8.",
                ""
        }).setAnzahl(1).build();

        ItemStack Stufe1Unavailable = new ItemManager(Material.CLAY_BALL).setName("§8»│ §6§lStufe 1 §8▰§7▱ §7Noch nicht abholbereit").setLore(new String[]{
                "",
                " §8▰§7▱ §6Voraussetzung§8:",
                "  §8- §e5 §7Kills",
                "",
                " §8▰§7▱ §6Belohnungen§8:",
                "  §8- §e1.000 §7Tokens",
                "  §8- §7Doppelte Belohnung für den §5Salvia §7Rang§8.",
                "",
                "§7Diese Belohnung ist noch nicht abholbereit§8.",
                ""
        }).setAnzahl(1).build();


        ItemStack Stufe2Available = new ItemManager(Material.DIAMOND_CHESTPLATE).setName("§8»│ §6§lStufe 2 §8▰§7▱ §7Abholbereit").setLore(new String[]{
                "",
                " §8▰§7▱ §6Belohnungen§8:",
                "  §8- §eProt 2 §7Diamanthelm §8(§61§7x§8)",
                "  §8- §eProt 2 §7Diamantbrustplatte §8(§61§7x§8)",
                "  §8- §eProt 2 §7Diamanthose §8(§61§7x§8)",
                "  §8- §eProt 2 §7Diamantschuhe §8(§61§7x§8)",
                "  §8- §eSharp 2 §7Diamantschwert §8(§61§7x§8)",
                "  §8- §7Doppelte Belohnung für den §5Salvia §7Rang§8.",
                "",
                "§7Klicke§8, §7um deine Belohnung abzuholen§8.",
                ""
        }).setAnzahl(1).build();

        ItemStack Stufe2Unavailable = new ItemManager(Material.CLAY_BALL).setName("§8»│ §6§lStufe 2 §8▰§7▱ §7Noch nicht abholbereit").setLore(new String[]{
                "",
                " §8▰§7▱ §6Voraussetzung§8:",
                "  §8- §e10 §7Kills",
                "",
                " §8▰§7▱ §6Belohnungen§8:",
                "  §8- §eProt 2 §7Diamanthelm §8(§61§7x§8)",
                "  §8- §eProt 2 §7Diamantbrustplatte §8(§61§7x§8)",
                "  §8- §eProt 2 §7Diamanthose §8(§61§7x§8)",
                "  §8- §eProt 2 §7Diamantschuhe §8(§61§7x§8)",
                "  §8- §eSharp 2 §7Diamantschwert §8(§61§7x§8)",
                "  §8- §7Doppelte Belohnung für den §5Salvia §7Rang§8.",
                "",
                "§7Diese Belohnung ist noch nicht abholbereit§8.",
                ""
        }).setAnzahl(1).build();

        ItemStack Stufe3Available = new ItemManager(Material.TRIPWIRE_HOOK).setGlowing().setName("§8»│ §6§lStufe 3 §8▰§7▱ §7Abholbereit").setLore(new String[]{
                "",
                " §8▰§7▱ §6Belohnungen§8:",
                "  §8- §e3§8x §aSkyblock §7Schlüssel",
                "  §8- §7Doppelte Belohnung für den §5Salvia §7Rang§8.",
                "",
                "§7Klicke§8, §7um deine Belohnung abzuholen§8.",
                ""
        }).setAnzahl(1).build();

        ItemStack Stufe3Unavailable = new ItemManager(Material.CLAY_BALL).setName("§8»│ §6§lStufe 3 §8▰§7▱ §7Noch nicht abholbereit").setLore(new String[]{
                "",
                " §8▰§7▱ §6Voraussetzung§8:",
                "  §8- §e15 §7Kills",
                "",
                " §8▰§7▱ §6Belohnungen§8:",
                "  §8- §e3§8x §aSkyblock §7Schlüssel",
                "  §8- §7Doppelte Belohnung für den §5Salvia §7Rang§8.",
                "",
                "§7Diese Belohnung ist noch nicht abholbereit§8.",
                ""
        }).setAnzahl(1).build();

        ItemStack Stufe4Available = new ItemManager(Material.TRIPWIRE_HOOK).setGlowing().setName("§8»│ §6§lStufe 4 §8▰§7▱ §7Abholbereit").setLore(new String[]{
                "",
                " §8▰§7▱ §6Belohnungen§8:",
                "  §8- §e1§8x §cAlles§4Oder§cNichts §7Schlüssel",
                "  §8- §7Doppelte Belohnung für den §5Salvia §7Rang§8.",
                "",
                "§7Klicke§8, §7um deine Belohnung abzuholen§8.",
                ""
        }).setAnzahl(1).build();

        ItemStack Stufe4Unavailable = new ItemManager(Material.CLAY_BALL).setName("§8»│ §6§lStufe 4 §8▰§7▱ §7Noch nicht abholbereit").setLore(new String[]{
                "",
                " §8▰§7▱ §6Voraussetzung§8:",
                "  §8- §e20 §7Kills",
                "",
                " §8▰§7▱ §6Belohnungen§8:",
                "  §8- §e1§8x §cAlles§4Oder§cNichts §7Schlüssel",
                "  §8- §7Doppelte Belohnung für den §5Salvia §7Rang§8.",
                "",
                "§7Diese Belohnung ist noch nicht abholbereit§8.",
                ""
        }).setAnzahl(1).build();

        ItemStack Stufe5Available = new ItemManager(Material.GOLD_NUGGET).setName("§8»│ §6§lStufe 5 §8▰§7▱ §7Abholbereit").setLore(new String[]{
                "",
                " §8▰§7▱ §6Belohnungen§8:",
                "  §8- §e1§8x §7Beacon",
                "  §8- §7Doppelte Belohnung für den §5Salvia §7Rang§8.",
                "",
                "§7Klicke§8, §7um deine Belohnung abzuholen§8.",
                ""
        }).setAnzahl(1).build();

        ItemStack Stufe5Unavailable = new ItemManager(Material.CLAY_BALL).setName("§8»│ §6§lStufe 5 §8▰§7▱ §7Noch nicht abholbereit").setLore(new String[]{
                "",
                " §8▰§7▱ §6Voraussetzung§8:",
                "  §8- §e25 §7Kills",
                "",
                " §8▰§7▱ §6Belohnungen§8:",
                "  §8- §e1§8x §7Beacon",
                "  §8- §7Doppelte Belohnung für den §5Salvia §7Rang§8.",
                "",
                "§7Diese Belohnung ist noch nicht abholbereit§8.",
                ""
        }).setAnzahl(1).build();


        ItemStack Stufe6Available = new ItemManager(Material.GOLD_INGOT).setName("§8»│ §6§lStufe 6 §8▰§7▱ §7Abholbereit").setLore(new String[]{
                "",
                " §8▰§7▱ §6Belohnungen§8:",
                "  §8- §e5000 §7Tokens",
                "  §8- §7Doppelte Belohnung für den §5Salvia §7Rang§8.",
                "",
                "§7Klicke§8, §7um deine Belohnung abzuholen§8.",
                ""
        }).setAnzahl(1).build();

        ItemStack Stufe6Unavailable = new ItemManager(Material.CLAY_BALL).setName("§8»│ §6§lStufe 6 §8▰§7▱ §7Noch nicht abholbereit").setLore(new String[]{
                "",
                " §8▰§7▱ §6Voraussetzung§8:",
                "  §8- §e30 §7Kills",
                "",
                " §8▰§7▱ §6Belohnungen§8:",
                "  §8- §e5000 §7Tokens",
                "  §8- §7Doppelte Belohnung für den §5Salvia §7Rang§8.",
                "",
                "§7Diese Belohnung ist noch nicht abholbereit§8.",
                ""
        }).setAnzahl(1).build();

        ItemStack Stufe7Available = new ItemManager(Material.MONSTER_EGG).setData(50).setName("§8»│ §6§lStufe 7 §8▰§7▱ §7Abholbereit").setLore(new String[]{
                "",
                " §8▰§7▱ §6Belohnungen§8:",
                "  §8- §e1§8x §6Zufälliges Spawnegg",
                "  §8- §7Doppelte Belohnung für den §5Salvia §7Rang§8.",
                "",
                "§7Klicke§8, §7um deine Belohnung abzuholen§8.",
                ""
        }).setAnzahl(1).build();

        ItemStack Stufe7Unavailable = new ItemManager(Material.CLAY_BALL).setName("§8»│ §6§lStufe 7 §8▰§7▱ §7Noch nicht abholbereit").setLore(new String[]{
                "",
                " §8▰§7▱ §6Voraussetzung§8:",
                "  §8- §e35 §7Kills",
                "",
                " §8▰§7▱ §6Belohnungen§8:",
                "  §8- §e1§8x §6Zufälliges Spawnegg",
                "  §8- §7Doppelte Belohnung für den §5Salvia §7Rang§8.",
                "",
                "§7Diese Belohnung ist noch nicht abholbereit§8.",
                ""
        }).setAnzahl(1).build();

        inv.setItem(22, currentsite);
        inv.setItem(21, redglass);
        inv.setItem(23, nextsite);

        if(new KillAPI(player).getKills() > 4) {
            if(!new PvPPassManager().getStufe(player.getUniqueId(), 1)) {
                inv.setItem(10, Stufe1Available);
            } else {
                inv.setItem(10, Stufe1Claimed);
            }
        } else {
            inv.setItem(10, Stufe1Unavailable);
        }

        if(new KillAPI(player).getKills() > 9) {
            if(!new PvPPassManager().getStufe(player.getUniqueId(), 2)) {
                inv.setItem(11, Stufe2Available);
            } else {
                inv.setItem(11, Stufe2Claimed);
            }
        } else {
            inv.setItem(11, Stufe2Unavailable);
        }

        if(new KillAPI(player).getKills() > 14) {
            if(!new PvPPassManager().getStufe(player.getUniqueId(), 3)) {
                inv.setItem(12, Stufe3Available);
            } else {
                inv.setItem(12, Stufe3Claimed);
            }
        } else {
            inv.setItem(12, Stufe3Unavailable);
        }

        if(new KillAPI(player).getKills() > 19) {
            if(!new PvPPassManager().getStufe(player.getUniqueId(), 4)) {
                inv.setItem(13, Stufe4Available);
            } else {
                inv.setItem(13, Stufe4Claimed);
            }
        } else {
            inv.setItem(13, Stufe4Unavailable);
        }

        if(new KillAPI(player).getKills() > 24) {
            if(!new PvPPassManager().getStufe(player.getUniqueId(),5)) {
                inv.setItem(14, Stufe5Available);
            } else {
                inv.setItem(14, Stufe5Claimed);
            }
        } else {
            inv.setItem(14, Stufe5Unavailable);
        }

        if(new KillAPI(player).getKills() > 29) {
            if(!new PvPPassManager().getStufe(player.getUniqueId(),6)) {
                inv.setItem(15, Stufe6Available);
            } else {
                inv.setItem(15, Stufe6Claimed);
            }
        } else {
            inv.setItem(15, Stufe6Unavailable);
        }

        if(new KillAPI(player).getKills() > 34) {
            if(!new PvPPassManager().getStufe(player.getUniqueId(),7)) {
                inv.setItem(16, Stufe7Available);
            } else {
                inv.setItem(16, Stufe7Claimed);
            }
        } else {
            inv.setItem(16, Stufe7Unavailable);
        }

        player.openInventory(inv);
    }
}

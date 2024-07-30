package de.sprachlvs.skydrugs.commands;

import de.sprachlvs.skydrugs.SkyDrugs;
import de.sprachlvs.skydrugs.manager.ItemManager;
import de.sprachlvs.skydrugs.manager.ItemSkullManager;
import de.sprachlvs.skydrugs.utils.InventoryUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class RanginfoCommand implements CommandExecutor, Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if (event.getInventory().getName().equalsIgnoreCase("§8»│ §5§lRANGINFO§8")) {
            event.setCancelled(true);
        }
    }

    private String
        BASE64 = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYThlMDc2OWQ4ZmY4Y2I5M2U1OGExZWM0YjI3ZTIzMDFmMDhjMDMyZjA4ODVkNDI1YjU5MjQ1YWJmZjM2ZGU5ZSJ9fX0=";

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if (sender instanceof Player) {
            final Player player = (Player) sender;

            openInventory(player);
            player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 100, 14);
            player.sendMessage(SkyDrugs.PREFIX + "§7Die §5Ranginfo §7wurde geöffnet§8.");
        } else {
            sender.sendMessage(SkyDrugs.PREFIX + "§7Du musst ein Spieler sein§8!");
        }
        return false;
    }

    private void openInventory(Player player) {
        Inventory inventory = Bukkit.createInventory(null, 45, "§8»│ §5§lRANGINFO§8");
        for (int i = 0; i < inventory.getSize(); i++)
            inventory.setItem(i, new ItemManager(Material.STAINED_GLASS_PANE).setData(7).setName("§8-/-").build());

        InventoryUtils.fillBorders(inventory, new ItemManager(Material.STAINED_GLASS_PANE).setData(15).setName("§8-/-").build());

        ItemStack Kavain = ItemSkullManager.getSkull("§8»│ §5§lRECHTE §8▰§7▱ §8'§eKavain§8' §7Rang", BASE64, new String[]{
                "",
                " §8▰§7▱ §5Wie bekomme ich diesen Rang§8?",
                "  §8- §7Diesen Rang bekommst du kostenlos§8.",
                "  §8- §7Warte auf geplante oder spontane Events",
                "  §8- §7und gewinne ihn mit etwas Glück§8.",
                "",
                " §8▰§7▱ §5Welche Extras hat dieser Rang in sich§8?",
                "  §8- /§dtrash §8▰§7▱ Öffne einen mobilen Mülleimer",
                "  §8- /§dcraft §8▰§7▱ Öffne eine mobilen Werkbank",
                "  §8- /§dfeed §8▰§7▱ Füttere dich§8, §7ohne zu essen§8!",
                "",
                "  §8- §7Bekomme eine §dextra §7Enderchest §8(§7/§5ec§8)",
                "  §8- §7Du erhälst Zugriff zum §eKavain §7Kit §8(§7/§6kit§8)",
                "  §8- §7Bekomme das §crote §7Theme beim §eCookie Clicker§8. §8(§7/§cspawn§8)",
                ""
        });

        ItemStack Valium = ItemSkullManager.getSkull("§8»│ §5§lRECHTE §8▰§7▱ §8'§6Valium§8' §7Rang", BASE64, new String[]{
                "",
                " §8▰§7▱ §5Wie bekomme ich diesen Rang§8?",
                "  §8- §7Diesen Rang bekommst du kostenlos§8.",
                "  §8- §7Warte auf geplante oder spontane Events",
                "  §8- §7und gewinne ihn mit etwas Glück§8.",
                "",
                " §8▰§7▱ §5Welche Extras hat dieser Rang in sich§8?",
                "  §8- /§dkopf §8▰§7▱ Hole dir ein Kopf von einem anderen Spieler",
                "  §8- /§dday §8▰§7▱ Stelle die Serverzeit auf Tag",
                "  §8- /§dnight §8▰§7▱ Stelle die Serverzeit auf Nacht",
                "  §8- /§dhat §8▰§7▱ Setze dir ein Item auf den Kopf",
                "  §8- /§dclear §8▰§7▱ Entferne alle Items in deinem Inventar",
                "",
                "  §8- §7Alle Extras von den unteren Rängen§8.",
                "  §8- §7Bekomme zwei §dextra §7Enderchest§8'§7s §8(§7/§5ec§8)",
                "  §8- §7Du erhälst Zugriff zum §6Valium §7Kit §8(§7/§ekit§8)",
                "  §8- §7Bekomme das §egelbe §7Theme beim §eCookie Clicker§8. §8(§7/§espawn§8)",
                ""
        });

        ItemStack Opiat = ItemSkullManager.getSkull("§8»│ §5§lRECHTE §8▰§7▱ §8'§bOpiat§8' §7Rang", BASE64, new String[]{
                "",
                " §8▰§7▱ §5Wie bekomme ich diesen Rang§8?",
                "  §8- §7Diesen Rang bekommst du kostenlos§8.",
                "  §8- §7Warte auf geplante oder spontane Events",
                "  §8- §7und gewinne ihn mit etwas Glück§8.",
                "",
                " §8▰§7▱ §5Welche Extras hat dieser Rang in sich§8?",
                "  §8- /§dinvsee §8▰§7▱ Sehe das Inventar von anderen Spielern",
                "  §8- /§dheal §8▰§7▱ Fülle deine Herzen komplett auf",
                "  §8- /§dstack §8▰§7▱ Stacke deine Items in deinem Inventar",
                "  §8- /§dxp §8▰§7▱ Zahle deine Erfahrungslevel in EXP Flaschen aus",
                "  §8- /§dcc §8▰§7▱ Leere deinen persönlichen Chat",
                "",
                "  §8- §7Alle Extras von den unteren Rängen§8.",
                "  §8- §7Du kannst nun §2Kopfgeld §7auf andere aussetzen§8.",
                "  §8- §7Bekomme drei §dextra §7Enderchest§8'§7s §8(§7/§5ec§8)",
                "  §8- §7Du erhälst Zugriff zum §bOpiat §7Kit §8(§7/§ekit§8)",
                "  §8- §7Bekomme das §bblaue §7Theme beim §eCookie Clicker§8. §8(§7/§3spawn§8)",
                ""
        });

        ItemStack Ephedra = ItemSkullManager.getSkull("§8»│ §5§lRECHTE §8▰§7▱ §8'§cEphedra§8' §7Rang", BASE64, new String[]{
                "",
                " §8▰§7▱ §5Wie bekomme ich diesen Rang§8?",
                "  §8- §7Diesen Rang kannst du für §d25§7eur erwerben§8.",
                "  §8- §7Kaufe diesen Rang unter §dbuy.skydrugs.de§8!",
                "  §8- §8(§d§l!§8) §7Jeder Spieler bekommt beim Kauf §d5.000 §7Tokens§8.",
                "",
                " §8▰§7▱ §5Welche Extras hat dieser Rang in sich§8?",
                "  §8- /§djoinmsg §8▰§7▱ Setze eine persönliche Beitrittsnachricht",
                "  §8- /§dwerbung §8▰§7▱ Mache Werbung für deine Insel etc.",
                "  §8- /§dsign §8▰§7▱ Hinterlasse bei einem Item deine Unterschrift",
                "  §8- /§dbodysee §8▰§7▱ Siehe die Rüstung von anderen Spielern",
                "  §8- /§dfreekey §8▰§7▱ Bekomme jede Woche 1 kostenlosen §cAdmin §7Schlüssel",
                "  §8- /§dvotemute §8▰§7▱ Starte eine Abstimmung um einen Spieler zu muten",
                "  §8- /§dfw §8▰§7▱ Ein zufälligfarbiges Feuerwerk wird gespawnt",
                "",
                "  §8- §7Alle Extras von den unteren Rängen§8.",
                "  §8- §7Du kannst nun §2Kopfgeld §7auf andere aussetzen§8.",
                "  §8- §7Bekomme vier §dextra §7Enderchest§8'§7s §8(§7/§5ec§8)",
                "  §8- §7Du erhälst Zugriff zum §cEphedra §7Kit §8(§7/§ckit§8)",
                "  §8- §7Bekomme das §fweiße §7Theme beim §eCookie Clicker§8. §8(§7/§fspawn§8)",
                ""
        });

        ItemStack Salvia = ItemSkullManager.getSkull("§8»│ §5§lRECHTE §8▰§7▱ §8'§5Salvia§8' §7Rang", BASE64, new String[]{
                "",
                " §8▰§7▱ §5Wie bekomme ich diesen Rang§8?",
                "  §8- §7Diesen Rang kannst du für §d50§7eur erwerben§8.",
                "  §8- §7Kaufe diesen Rang unter §dbuy.skydrugs.de§8!",
                "  §8- §8(§d§l!§8) §7Jeder Spieler bekommt beim Kauf §d10.000 §7Tokens§8.",
                "",
                " §8▰§7▱ §5Welche Extras hat dieser Rang in sich§8?",
                "  §8- /§dleavemsg §8▰§7▱ Setze eine persönliche Verlassnachricht",
                "  §8- /§dumfrage §8▰§7▱ Starte eine öffentliche Umfrage",
                "  §8- /§dauszahlen §8▰§7▱ Zahle deine Tokens als Gutschein aus",
                "  §8- /§dfreekey+ §8▰§7▱ Bekomme jede Woche 2 kostenlose §cAdmin §7Schlüssel",
                "  §8- /§dchance §8▰§7▱ Verdopple das in deiner handgehaltene Item §8(§530§7%§8)",
                "  §8- /§dpvp §8▰§7▱ Aktiviere oder Deaktiviere deinen PvP-Status",
                "  §8- /§dfly §8▰§7▱ Redbull verleiht Flügel§8!",
                "  §8- /§dblöcke §8▰§7▱ Bekomme verschiedene Blöcke gratis",
                "  §8- /§dvotekick §8▰§7▱ Starte eine Abstimmung um einen Spieler zu kicken",
                "",
                "  §8- §7Alle Extras von den unteren Rängen§8.",
                "  §8- §7Du kannst nicht von dem Befehl §8/§dvotekick §7gekickt werden§8.",
                "  §8- §7Du kannst nun §2Kopfgeld §7auf andere aussetzen§8.",
                "  §8- §7Bekomme fünf §dextra §7Enderchest§8'§7s §8(§7/§5ec§8)",
                "  §8- §7Du erhälst Zugriff zum §5Salvia §7Kit §8(§7/§ckit§8)",
                "  §8- §7Bekomme das §5lila §7Theme beim §eCookie Clicker§8. §8(§7/§dspawn§8)",
                ""
        });

        ItemStack Booster = ItemSkullManager.getSkull("§8»│ §5§lRECHTE §8▰§7▱ §8'§dBooster§8' §7Rang", BASE64, new String[]{
                "",
                " §8▰§7▱ §5Wie bekomme ich diesen Rang§8?",
                "  §8- §7Diesen Rang bekommst du durchs §dBoosten§8!",
                "  §8- §7Für weitere Infos§8, §7benutze §8/§dbooster§8.",
                "",
                " §8▰§7▱ §5Welche Extras hat dieser Rang in sich§8?",
                "  §8- /§drandomkey §8▰§7▱ Bekomme jede Woche 1 zufälligen Schlüssel",
                "  §8- /§dfreekey++ §8▰§7▱ Bekomme jede Woche 3 kostenlos §cAdmin §7Schlüssel",
                "  §8- /§dnear §8▰§7▱ Siehe die Spieler in deiner Nähe",
                "  §8- /§djump §8▰§7▱ Werde in die Luft geschossen§8!",
                "  §8- /§drecipe §8▰§7▱ Bekomme Rezepte von verschiedenen Items",
                "  §8- /§dmsgtoggle §8▰§7▱ Bekomme keine Nachrichten von anderen Spielern",
                "",
                "  §8- §7Alle Extras von den unteren Rängen§8.",
                "  §8- §7Du kannst nicht von dem Befehl §8/§dvotekick §7gekickt werden§8.",
                "  §8- §7Du kannst nun §2Kopfgeld §7auf andere aussetzen§8.",
                "  §8- §7Bekomme sechs §dextra §7Enderchest§8'§7s §8(§7/§5ec§8)",
                "  §8- §7Du erhälst Zugriff zum §dBooster §7Kit §8(§7/§ckit§8)",
                "  §8- §7Bekomme das §2grüne §7Theme beim §eCookie Clicker§8. §8(§7/§fspawn§8)",
                ""
        });

        inventory.setItem(11, Kavain);
        inventory.setItem(13, Valium);
        inventory.setItem(15, Opiat);
        inventory.setItem(21, Ephedra);
        inventory.setItem(23, Salvia);
        inventory.setItem(31, Booster);

        player.openInventory(inventory);
    }
}

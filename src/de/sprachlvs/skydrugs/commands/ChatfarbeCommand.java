package de.sprachlvs.skydrugs.commands;

import de.sprachlvs.skydrugs.SkyDrugs;
import de.sprachlvs.skydrugs.apis.GetGroupAPI;
import de.sprachlvs.skydrugs.manager.ItemManager;
import de.sprachlvs.skydrugs.manager.PrefixManager;
import de.sprachlvs.skydrugs.utils.InventoryUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class ChatfarbeCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (!(sender instanceof Player)) {

            sender.sendMessage(PrefixManager.CHATFARBE + "§7Du musst ein Spieler sein§8!");
        } else {
            Player player = (Player)sender;
            if (PermissionsEx.getUser(player).inGroup("Salvia") || PermissionsEx.getUser(player).inGroup("Booster") || PermissionsEx.getUser(player).inGroup("Creator") || PermissionsEx.getUser(player).inGroup("Content") || PermissionsEx.getUser(player).inGroup("Supporter") || PermissionsEx.getUser(player).inGroup("Moderator") || PermissionsEx.getUser(player).inGroup("SrModerator") || PermissionsEx.getUser(player).inGroup("Developer") || PermissionsEx.getUser(player).inGroup("Admin") || PermissionsEx.getUser(player).inGroup("Owner")) {

                openInventory(player);
                player.sendMessage(PrefixManager.CHATFARBE + "§7Das §eFarbe§8-§eInventar §7wurde geöffnet§8.");
            } else {
                player.sendMessage(SkyDrugs.NOPERM);
            }
        }
        return false;
    }

    private void openInventory(Player player) {
        Inventory inventory = Bukkit.createInventory(null, 54, "§8»│ §e§lFARBE§8");
        for (int i = 0; i < inventory.getSize(); i++)
            inventory.setItem(i, new ItemManager(Material.STAINED_GLASS_PANE).setAnzahl(1).setData(7).setName("§8-/-").build());

        InventoryUtils.fillBorders(inventory, new ItemManager(Material.STAINED_GLASS_PANE).setData(15).setName("§8-/-").build());

        inventory.setItem(10, new ItemManager(Material.INK_SACK).setData(10).setAnzahl(1).setName(GetGroupAPI.getGroupScoreboard(player) + "§8│ §7" + player.getName() + " §8» §aTest-Nachricht §8(§aGRÜN§8)").setLore(new String[]{
                "",
                "§8│ §7Klicke§8, §7um deine Nachricht in Chat §8'§aGrün§8' §7anzeigen zu lassen§8.",
                ""
        }).build());

        inventory.setItem(11, new ItemManager(Material.INK_SACK).setData(12).setAnzahl(1).setName(GetGroupAPI.getGroupScoreboard(player) + "§8│ §7" + player.getName() + " §8» §bTest-Nachricht §8(§bHELLBLAU§8)").setLore(new String[]{
                "",
                "§8│ §7Klicke§8, §7um deine Nachricht in Chat §8'§bHellblau§8' §7anzeigen zu lassen§8.",
                ""
        }).build());

        inventory.setItem(12, new ItemManager(Material.INK_SACK).setData(1).setAnzahl(1).setName(GetGroupAPI.getGroupScoreboard(player) + "§8│ §7" + player.getName() + " §8» §cTest-Nachricht §8(§cROT§8)").setLore(new String[]{
                "",
                "§8│ §7Klicke§8, §7um deine Nachricht in Chat §8'§cRot§8' §7anzeigen zu lassen§8.",
                ""
        }).build());

        inventory.setItem(13, new ItemManager(Material.INK_SACK).setData(9).setAnzahl(1).setName(GetGroupAPI.getGroupScoreboard(player) + "§8│ §7" + player.getName() + " §8» §dTest-Nachricht §8(§dPINK§8)").setLore(new String[]{
                "",
                "§8│ §7Klicke§8, §7um deine Nachricht in Chat §8'§dPink§8' §7anzeigen zu lassen§8.",
                ""
        }).build());

        inventory.setItem(14, new ItemManager(Material.INK_SACK).setData(11).setAnzahl(1).setName(GetGroupAPI.getGroupScoreboard(player) + "§8│ §7" + player.getName() + " §8» §eTest-Nachricht §8(§eGELB§8)").setLore(new String[]{
                "",
                "§8│ §7Klicke§8, §7um deine Nachricht in Chat §8'§eGelb§8' §7anzeigen zu lassen§8.",
                ""
        }).build());

        inventory.setItem(15, new ItemManager(Material.INK_SACK).setData(15).setAnzahl(1).setName(GetGroupAPI.getGroupScoreboard(player) + "§8│ §7" + player.getName() + " §8» §fTest-Nachricht §8(§fWEISS§8)").setLore(new String[]{
                "",
                "§8│ §7Klicke§8, §7um deine Nachricht in Chat §8'§fWeiß§8' §7anzeigen zu lassen§8.",
                ""
        }).build());

        inventory.setItem(16, new ItemManager(Material.INK_SACK).setAnzahl(1).setName(GetGroupAPI.getGroupScoreboard(player) + "§8│ §7" + player.getName() + " §8» §0Test-Nachricht §8(§0SCHWARZ§8)").setLore(new String[]{
                "",
                "§8│ §7Klicke§8, §7um deine Nachricht in Chat §8'§0Schwarz§8' §7anzeigen zu lassen§8.",
                ""
        }).build());

        inventory.setItem(19, new ItemManager(Material.INK_SACK).setData(4).setAnzahl(1).setName(GetGroupAPI.getGroupScoreboard(player) + "§8│ §7" + player.getName() + " §8» §1Test-Nachricht §8(§1BLAU§8)").setLore(new String[]{
                "",
                "§8│ §7Klicke§8, §7um deine Nachricht in Chat §8'§1Blau§8' §7anzeigen zu lassen§8.",
                ""
        }).build());


        inventory.setItem(20, new ItemManager(Material.INK_SACK).setData(2).setAnzahl(1).setName(GetGroupAPI.getGroupScoreboard(player) + "§8│ §7" + player.getName() + " §8» §2Test-Nachricht §8(§2DUNKELGRÜN§8)").setLore(new String[]{
                "",
                "§8│ §7Klicke§8, §7um deine Nachricht in Chat §8'§2Dunkelgrün§8' §7anzeigen zu lassen§8.",
                ""
        }).build());

        inventory.setItem(21, new ItemManager(Material.INK_SACK).setData(6).setAnzahl(1).setName(GetGroupAPI.getGroupScoreboard(player) + "§8│ §7" + player.getName() + " §8» §3Test-Nachricht §8(§3CYAN§8)").setLore(new String[]{
                "",
                "§8│ §7Klicke§8, §7um deine Nachricht in Chat §8'§3Cyan§8' §7anzeigen zu lassen§8.",
                ""
        }).build());

        inventory.setItem(22, new ItemManager(Material.REDSTONE).setAnzahl(1).setName(GetGroupAPI.getGroupScoreboard(player) + "§8│ §7" + player.getName() + " §8» §4Test-Nachricht §8(§4DUNKELROT§8)").setLore(new String[]{
                "",
                "§8│ §7Klicke§8, §7um deine Nachricht in Chat §8'§4Dunkelrot§8' §7anzeigen zu lassen§8.",
                ""
        }).build());

        inventory.setItem(23, new ItemManager(Material.INK_SACK).setData(5).setAnzahl(1).setName(GetGroupAPI.getGroupScoreboard(player) + "§8│ §7" + player.getName() + " §8» §5Test-Nachricht §8(§5LILA§8)").setLore(new String[]{
                "",
                "§8│ §7Klicke§8, §7um deine Nachricht in Chat §8'§5Lila§8' §7anzeigen zu lassen§8.",
                ""
        }).build());

        inventory.setItem(24, new ItemManager(Material.INK_SACK).setData(14).setAnzahl(1).setName(GetGroupAPI.getGroupScoreboard(player) + "§8│ §7" + player.getName() + " §8» §6Test-Nachricht §8(§6ORANGE§8)").setLore(new String[]{
                "",
                "§8│ §7Klicke§8, §7um deine Nachricht in Chat §8'§6Orange§8' §7anzeigen zu lassen§8.",
                ""
        }).build());

        inventory.setItem(25, new ItemManager(Material.INK_SACK).setData(8).setAnzahl(1).setName(GetGroupAPI.getGroupScoreboard(player) + "§8│ §7" + player.getName() + " §8» §8Test-Nachricht §8(§8GRAU§8)").setLore(new String[]{
                "",
                "§8│ §7Klicke§8, §7um deine Nachricht in Chat §8'Grau' §7anzeigen zu lassen§8.",
                ""
        }).build());

        inventory.setItem(40, new ItemManager(Material.BARRIER).setAnzahl(1).setName("§8▰§7▱ §c§lRESET").setLore(new String[]{
                "",
                "§8│ §7Klicke§8, §7um deine Nachricht im Chat zurückzusetzen§8.",
                ""
        }).build());

        if (PermissionsEx.getUser(player).inGroup("Content") || PermissionsEx.getUser(player).inGroup("Supporter") || PermissionsEx.getUser(player).inGroup("Moderator") || PermissionsEx.getUser(player).inGroup("SrModerator") || PermissionsEx.getUser(player).inGroup("Developer") || PermissionsEx.getUser(player).inGroup("Admin") || PermissionsEx.getUser(player).inGroup("Owner")) {

            inventory.setItem(37, new ItemManager(Material.PAPER).setAnzahl(1).setName(GetGroupAPI.getGroupScoreboard(player) + "§8│ §7" + player.getName() + " §8» §7§lTest-Nachricht §8(§7§lDICK§8)").setLore(new String[]{
                   "",
                   "§8│ §7Klicke§8, §7um deine Nachricht im Chat §7§lDICK §7anzeigen zu lassen§8.",
                   ""
            }).build());
            inventory.setItem(38, new ItemManager(Material.PAPER).setAnzahl(1).setName(GetGroupAPI.getGroupScoreboard(player) + "§8│ §7" + player.getName() + " §8» §7§lTest-Nachricht §8(§7§oKURSIV§8)").setLore(new String[]{
                    "",
                    "§8│ §7Klicke§8, §7um deine Nachricht im Chat §7§oKURSIV §7anzeigen zu lassen§8.",
                    ""
            }).build());
            inventory.setItem(42, new ItemManager(Material.PAPER).setAnzahl(1).setName(GetGroupAPI.getGroupScoreboard(player) + "§8│ §7" + player.getName() + " §8» §7§lTest-Nachricht §8(§7§nUNTERSTRICHEN§8)").setLore(new String[]{
                    "",
                    "§8│ §7Klicke§8, §7um deine Nachricht im Chat §7§nUNTERSTRICHEN §7anzeigen zu lassen§8.",
                    ""
            }).build());
            inventory.setItem(43, new ItemManager(Material.PAPER).setAnzahl(1).setName(GetGroupAPI.getGroupScoreboard(player) + "§8│ §7" + player.getName() + " §8» §7§lTest-Nachricht §8(§7§mDURCHGESTRICHEN§8)").setLore(new String[]{
                    "",
                    "§8│ §7Klicke§8, §7um deine Nachricht im Chat §7§mDURCHGESTRICHEN §7anzeigen zu lassen§8.",
                    ""
            }).build());
        }

        player.openInventory(inventory);
        player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 1.0F, 1.0F);
    }
}

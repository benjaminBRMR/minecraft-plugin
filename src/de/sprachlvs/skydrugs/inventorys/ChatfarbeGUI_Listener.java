package de.sprachlvs.skydrugs.inventorys;

import de.sprachlvs.skydrugs.SkyDrugs;
import de.sprachlvs.skydrugs.apis.GetGroupAPI;
import de.sprachlvs.skydrugs.manager.FarbManager;
import de.sprachlvs.skydrugs.manager.PrefixManager;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import ru.tehkode.permissions.bukkit.PermissionsEx;

import java.util.UUID;

public class ChatfarbeGUI_Listener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Inventory inventory = event.getInventory();
        Player player = (Player)event.getWhoClicked();
        UUID uuid = player.getUniqueId();
        ItemStack itemStack = event.getCurrentItem();
        boolean italic = FarbManager.isItalic(uuid);
        boolean bold = FarbManager.isBold(uuid);
        boolean underline = FarbManager.isUnderline(uuid);
        boolean crossedout = FarbManager.isCrossedOut(uuid);

        if (inventory.getName().equalsIgnoreCase("§8»│ §e§lFARBE§8"))
            event.setCancelled(true);
        if (inventory.getName().equalsIgnoreCase("§8»│ §e§lFARBE§8")) {
            if (itemStack.getType().equals(Material.STAINED_GLASS_PANE))
                return;
            if (itemStack.getType().equals(Material.BARRIER) && itemStack.getItemMeta().getDisplayName().equalsIgnoreCase("§8▰§7▱ §c§lRESET")) {
                FarbManager.setFarbe(player.getUniqueId(), "§7");
                if (FarbManager.isBold(uuid))
                    FarbManager.setBold(uuid, false);
                if (FarbManager.isItalic(uuid))
                    FarbManager.setItalic(uuid, false);
                if (FarbManager.isCrossedOut(uuid))
                    FarbManager.setCrossedOut(uuid, false);
                if (FarbManager.isUnderline(uuid))
                    FarbManager.setUnderline(uuid, false);
                player.sendMessage(PrefixManager.CHATFARBE + "§7Du hast deine Farbe zurückgesetzt!");
                player.closeInventory();
                return;
            }
            if (itemStack.getType().equals(Material.INK_SACK) && itemStack.getItemMeta().getDisplayName().equalsIgnoreCase(GetGroupAPI.getGroupScoreboard(player) + "§8│ §7" + player.getName() + " §8» §aTest-Nachricht §8(§aGRÜN§8)")) {
                FarbManager.setFarbe(player.getUniqueId(), "§a");
                player.sendMessage(PrefixManager.CHATFARBE + "§7Du hast die Chatfarbe §8'§aGrün§8' §7ausgewählt§8.");
            }
            if (itemStack.getType().equals(Material.INK_SACK) && itemStack.getItemMeta().getDisplayName().equalsIgnoreCase(GetGroupAPI.getGroupScoreboard(player) + "§8│ §7" + player.getName() + " §8» §bTest-Nachricht §8(§bHELLBLAU§8)")) {
                FarbManager.setFarbe(player.getUniqueId(), "§b");
                player.sendMessage(PrefixManager.CHATFARBE + "§7Du hast die Chatfarbe §8'§bHellblau§8' §7ausgewählt§8.");
            }
            if (itemStack.getType().equals(Material.INK_SACK) && itemStack.getItemMeta().getDisplayName().equalsIgnoreCase(GetGroupAPI.getGroupScoreboard(player) + "§8│ §7" + player.getName() + " §8» §cTest-Nachricht §8(§cROT§8)")) {
                FarbManager.setFarbe(player.getUniqueId(), "§c");
                player.sendMessage(PrefixManager.CHATFARBE + "§7Du hast die Chatfarbe §8'§cRot§8' §7ausgewählt§8.");
            }
            if (itemStack.getType().equals(Material.INK_SACK) && itemStack.getItemMeta().getDisplayName().equalsIgnoreCase(GetGroupAPI.getGroupScoreboard(player) + "§8│ §7" + player.getName() + " §8» §dTest-Nachricht §8(§dPINK§8)")) {
                FarbManager.setFarbe(player.getUniqueId(), "§d");
                player.sendMessage(PrefixManager.CHATFARBE + "§7Du hast die Chatfarbe §8'§dPink§8' §7ausgewählt§8.");
            }
            if (itemStack.getType().equals(Material.INK_SACK) && itemStack.getItemMeta().getDisplayName().equalsIgnoreCase(GetGroupAPI.getGroupScoreboard(player) + "§8│ §7" + player.getName() + " §8» §eTest-Nachricht §8(§eGELB§8)")) {
                FarbManager.setFarbe(player.getUniqueId(), "§e");
                player.sendMessage(PrefixManager.CHATFARBE + "§7Du hast die Chatfarbe §8'§eGelb§8' §7ausgewählt§8.");
            }
            if (itemStack.getType().equals(Material.INK_SACK) && itemStack.getItemMeta().getDisplayName().equalsIgnoreCase(GetGroupAPI.getGroupScoreboard(player) + "§8│ §7" + player.getName() + " §8» §fTest-Nachricht §8(§fWEISS§8)")) {
                FarbManager.setFarbe(player.getUniqueId(), "§f");
                player.sendMessage(PrefixManager.CHATFARBE + "§7Du hast die Chatfarbe §8'§fWeiss§8' §7ausgewählt§8.");
            }
            if (itemStack.getType().equals(Material.INK_SACK) && itemStack.getItemMeta().getDisplayName().equalsIgnoreCase(GetGroupAPI.getGroupScoreboard(player) + "§8│ §7" + player.getName() + " §8» §0Test-Nachricht §8(§0SCHWARZ§8)")) {
                FarbManager.setFarbe(player.getUniqueId(), "§0");
                player.sendMessage(PrefixManager.CHATFARBE + "§7Du hast die Chatfarbe §8'§0Schwarz§8' §7ausgewählt§8.");
            }
            if (itemStack.getType().equals(Material.INK_SACK) && itemStack.getItemMeta().getDisplayName().equalsIgnoreCase(GetGroupAPI.getGroupScoreboard(player) + "§8│ §7" + player.getName() + " §8» §1Test-Nachricht §8(§1BLAU§8)")) {
                FarbManager.setFarbe(player.getUniqueId(), "§1");
                player.sendMessage(PrefixManager.CHATFARBE + "§7Du hast die Chatfarbe §8'§1Blau§8' §7ausgewählt§8.");
            }
            if (itemStack.getType().equals(Material.INK_SACK) && itemStack.getItemMeta().getDisplayName().equalsIgnoreCase(GetGroupAPI.getGroupScoreboard(player) + "§8│ §7" + player.getName() + " §8» §2Test-Nachricht §8(§2DUNKELGRÜN§8)")) {
                FarbManager.setFarbe(player.getUniqueId(), "§2");
                player.sendMessage(PrefixManager.CHATFARBE + "§7Du hast die Chatfarbe §8'§2Dunkel Grün§8' §7ausgewählt§8.");
            }
            if (itemStack.getType().equals(Material.INK_SACK) && itemStack.getItemMeta().getDisplayName().equalsIgnoreCase(GetGroupAPI.getGroupScoreboard(player) + "§8│ §7" + player.getName() + " §8» §3Test-Nachricht §8(§3CYAN§8)")) {
                FarbManager.setFarbe(player.getUniqueId(), "§3");
                player.sendMessage(PrefixManager.CHATFARBE + "§7Du hast die Chatfarbe §8'§3Cyan§8' §7ausgewählt§8.");
            }
            if (itemStack.getType().equals(Material.REDSTONE) && itemStack.getItemMeta().getDisplayName().equalsIgnoreCase(GetGroupAPI.getGroupScoreboard(player) + "§8│ §7" + player.getName() + " §8» §4Test-Nachricht §8(§4DUNKELROT§8)")) {
                FarbManager.setFarbe(player.getUniqueId(), "§4");
                player.sendMessage(PrefixManager.CHATFARBE + "§7Du hast die Chatfarbe §8'§4Dunkelrot§8' §7ausgewählt§8.");
            }
            if (itemStack.getType().equals(Material.INK_SACK) && itemStack.getItemMeta().getDisplayName().equalsIgnoreCase(GetGroupAPI.getGroupScoreboard(player) + "§8│ §7" + player.getName() + " §8» §5Test-Nachricht §8(§5LILA§8)")) {
                FarbManager.setFarbe(player.getUniqueId(), "§5");
                player.sendMessage(PrefixManager.CHATFARBE + "§7Du hast die Chatfarbe §8'§5Lila§8' §7ausgewählt§8.");
            }
            if (itemStack.getType().equals(Material.INK_SACK) && itemStack.getItemMeta().getDisplayName().equalsIgnoreCase(GetGroupAPI.getGroupScoreboard(player) + "§8│ §7" + player.getName() + " §8» §6Test-Nachricht §8(§6ORANGE§8)")) {
                FarbManager.setFarbe(player.getUniqueId(), "§6");
                player.sendMessage(PrefixManager.CHATFARBE + "§7Du hast die Chatfarbe §8'§6Orange§8' §7ausgewählt§8.");
            }
            if (itemStack.getType().equals(Material.INK_SACK) && itemStack.getItemMeta().getDisplayName().equalsIgnoreCase(GetGroupAPI.getGroupScoreboard(player) + "§8│ §7" + player.getName() + " §8» §8Test-Nachricht §8(§8GRAU§8)")) {
                FarbManager.setFarbe(player.getUniqueId(), "§8");
                player.sendMessage(PrefixManager.CHATFARBE + "§7Du hast die Chatfarbe §8'§8Grau§8' §7ausgewählt§8.");
            }

            if (itemStack.getType().equals(Material.PAPER) && itemStack.getItemMeta().getDisplayName().equalsIgnoreCase(GetGroupAPI.getGroupScoreboard(player) + "§8│ §7" + player.getName() + " §8» §7§lTest-Nachricht §8(§7§lDICK§8)")) {
                if (!FarbManager.isBold(uuid)) {
                    FarbManager.setBold(uuid, true);
                    player.sendMessage(PrefixManager.CHATFARBE + "§7Deine Chatfarbe ist nun §r" + FarbManager.getFarbe(player.getUniqueId()) + (italic ? "§o" : "") + (bold ? "§l" : "") + (underline ? "§n" : "") + (crossedout ? "§m" : "") + "§lTEST§8!");
                } else {
                    FarbManager.setBold(uuid, false);
                    player.sendMessage(PrefixManager.CHATFARBE + "§7Deine Chatfarbe ist nun §r" + FarbManager.getFarbe(player.getUniqueId()) + (italic ? "§o" : "") + (underline ? "§n" : "") + (crossedout ? "§m" : "") + "TEST§8!");
                }
            }

            if (itemStack.getType().equals(Material.PAPER) && itemStack.getItemMeta().getDisplayName().equalsIgnoreCase(GetGroupAPI.getGroupScoreboard(player) + "§8│ §7" + player.getName() + " §8» §7§lTest-Nachricht §8(§7§oKURSIV§8)")) {
                if (!FarbManager.isItalic(uuid)) {
                    FarbManager.setItalic(uuid, true);
                    player.sendMessage(PrefixManager.CHATFARBE + "§7Deine Chatfarbe ist nun §r" + FarbManager.getFarbe(player.getUniqueId()) + (italic ? "§o" : "") + (bold ? "§l" : "") + (underline ? "§n" : "") + (crossedout ? "§m" : "") + "§oTEST§8!");
                } else {
                    FarbManager.setItalic(uuid, false);
                    player.sendMessage(PrefixManager.CHATFARBE + "§7Deine Chatfarbe ist nun §r" + FarbManager.getFarbe(player.getUniqueId()) + (bold ? "§l" : "") + (underline ? "§n" : "") + (crossedout ? "§m" : "") + "TEST§8!");
                }
            }

            if (itemStack.getType().equals(Material.PAPER) && itemStack.getItemMeta().getDisplayName().equalsIgnoreCase(GetGroupAPI.getGroupScoreboard(player) + "§8│ §7" + player.getName() + " §8» §7§lTest-Nachricht §8(§7§nUNTERSTRICHEN§8)")) {
                if (PermissionsEx.getUser(player).inGroup("Owner")) {
                    if (!FarbManager.isUnderline(uuid)) {
                        FarbManager.setUnderline(uuid, true);
                        player.sendMessage(PrefixManager.CHATFARBE + "§7Deine Chatfarbe ist nun §r" + FarbManager.getFarbe(player.getUniqueId()) + (italic ? "§o" : "") + (bold ? "§l" : "") + (underline ? "§n" : "") + (crossedout ? "§m" : "") + "§nTEST§8!");
                    } else {
                        FarbManager.setUnderline(uuid, false);
                        player.sendMessage(PrefixManager.CHATFARBE + "§7Deine Chatfarbe ist nun §r" + FarbManager.getFarbe(player.getUniqueId()) + (italic ? "§o" : "") + (bold ? "§l" : "") + (crossedout ? "§m" : "") + "TEST§8!");
                    }
                } else {
                    player.sendMessage(SkyDrugs.NOPERM);
                }
            }

            if (itemStack.getType().equals(Material.PAPER) && itemStack.getItemMeta().getDisplayName().equalsIgnoreCase(GetGroupAPI.getGroupScoreboard(player) + "§8│ §7" + player.getName() + " §8» §7§lTest-Nachricht §8(§7§mDURCHGESTRICHEN§8)")) {
                if (PermissionsEx.getUser(player).inGroup("Owner")) {
                    if (!FarbManager.isCrossedOut(uuid)) {
                        FarbManager.setCrossedOut(uuid, true);
                        player.sendMessage(PrefixManager.CHATFARBE + "§7Deine Chatfarbe ist nun §r" + FarbManager.getFarbe(player.getUniqueId()) + (italic ? "§o" : "") + (bold ? "§l" : "") + (underline ? "§n" : "") + (crossedout ? "§m" : "") + "§mTEST§8!");
                    } else {
                        FarbManager.setCrossedOut(uuid, false);
                        player.sendMessage(PrefixManager.CHATFARBE + "§7Deine Chatfarbe ist nun §r" + FarbManager.getFarbe(player.getUniqueId()) + (italic ? "§o" : "") + (bold ? "§l" : "") + (underline ? "§n" : "") + "TEST§8!");
                    }
                } else {
                    player.sendMessage(SkyDrugs.NOPERM);
                }
            }
            player.playSound(player.getLocation(), Sound.HORSE_ARMOR, 0.5F, 0.5F);
        }
    }
}

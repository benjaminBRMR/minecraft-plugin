package de.sprachlvs.skydrugs.commands;

import de.sprachlvs.skydrugs.SkyDrugs;
import de.sprachlvs.skydrugs.manager.EnderChestManager;
import de.sprachlvs.skydrugs.manager.ItemManager;
import de.sprachlvs.skydrugs.manager.ItemSkullManager;
import de.sprachlvs.skydrugs.manager.PrefixManager;
import de.sprachlvs.skydrugs.utils.InventoryUtils;
import de.sprachlvs.skydrugs.utils.UUIDFetcher;
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

import javax.annotation.Nullable;
import java.util.UUID;

public class EnderChestCommand implements CommandExecutor, Listener {
    @Override
    public boolean onCommand(CommandSender commandSender, Command cmd, String s, String[] args) {

        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if (args.length != 1) {

                player.sendMessage(PrefixManager.ENDERCHEST + "§7Das §dEC§8-§dHauptmenü §7wurde geöffnet§8.");
                player.playSound(player.getLocation(), Sound.HORSE_ARMOR, 100, 14);
                openMainGUI(player, true, null);
            } else {
                UUID target = UUIDFetcher.getUUID(args[0]);
                if (target == null) {
                    player.sendMessage(PrefixManager.ENDERCHEST + "§cDieser Spieler existiert nicht§8.");
                    return false;
                }
                player.sendMessage(PrefixManager.ENDERCHEST + "§7Das §dEC§8-§dHauptmenü§7 von §d" + args[0] + " §7wurde geöffnet§8.");
                player.playSound(player.getLocation(), Sound.HORSE_ARMOR, 100, 14);
                openMainGUI(player, false, target);
                return true;
            }
        }
        return false;
    }

    public static void openMainGUI(Player player, boolean self, @Nullable UUID uuid) {
        Inventory inventory = Bukkit.createInventory(null, 27, PrefixManager.ENDERCHEST + (self ? "§1" : "§2") + "§7Hub");

        InventoryUtils.fillBorders(inventory, new ItemManager(Material.STAINED_GLASS_PANE).setData(15).setName("§8-/-").build());

        ItemStack info = new ItemManager(Material.SIGN).setName(PrefixManager.ENDERCHEST + "§7Information").setLore(
                "",
                "§8 ▰§7▱ Menü von §d" + (uuid == null ? player.getName() : UUIDFetcher.getName(uuid)),
                ""
        ).build();

        ItemStack pageone = ItemSkullManager.getSkull(PrefixManager.ENDERCHEST + "§7Seite 1", SkyDrugs.getBase64("ENDERCHEST"), new String[]{
                "",
                " §8▰§7▱ §7Klicke§8, §7um die §derste §7Seite zu öffnen§8.",
                ""
        });

        ItemStack pagetwo = ItemSkullManager.getSkull(PrefixManager.ENDERCHEST + "§7Seite 2", SkyDrugs.getBase64("ENDERCHEST"), new String[]{
                "",
                " §8▰§7▱ §7Klicke§8, §7um die §dzweite §7Seite zu öffnen§8.",
                ""
        });

        ItemStack pagethree = ItemSkullManager.getSkull(PrefixManager.ENDERCHEST + "§7Seite 3", SkyDrugs.getBase64("ENDERCHEST"), new String[]{
                "",
                " §8▰§7▱ §7Klicke§8, §7um die §ddritte §7Seite zu öffnen§8.",
                ""
        });

        ItemStack pagefour = ItemSkullManager.getSkull(PrefixManager.ENDERCHEST + "§7Seite 4", SkyDrugs.getBase64("ENDERCHEST"), new String[]{
                "",
                " §8▰§7▱ §7Klicke§8, §7um die §dvierte §7Seite zu öffnen§8.",
                ""
        });

        ItemStack pagefive = ItemSkullManager.getSkull(PrefixManager.ENDERCHEST + "§7Seite 5", SkyDrugs.getBase64("ENDERCHEST"), new String[]{
                "",
                " §8▰§7▱ §7Klicke§8, §7um die §dfünfte §7Seite zu öffnen§8.",
                ""
        });

        ItemStack pagesix = ItemSkullManager.getSkull(PrefixManager.ENDERCHEST + "§7Seite 6", SkyDrugs.getBase64("ENDERCHEST"), new String[]{
                "",
                " §8▰§7▱ §7Klicke§8, §7um die §dsechste §7Seite zu öffnen§8.",
                ""
        });

        ItemStack pageseven = ItemSkullManager.getSkull(PrefixManager.ENDERCHEST + "§7Seite 7", SkyDrugs.getBase64("ENDERCHEST"), new String[]{
                "",
                " §8▰§7▱ §7Klicke§8, §7um die §dsiebte §7Seite zu öffnen§8.",
                ""
        });

        inventory.setItem(4, info);
        inventory.setItem(10, pageone);
        inventory.setItem(11, pagetwo);
        inventory.setItem(12, pagethree);
        inventory.setItem(13, pagefour);
        inventory.setItem(14, pagefive);
        inventory.setItem(15, pagesix);
        inventory.setItem(16, pageseven); //dann schreib da was anderes hin xd

        player.openInventory(inventory);
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        if (event.getInventory().getName().equalsIgnoreCase(PrefixManager.ENDERCHEST + "§1§7Hub")) {
            event.setCancelled(true);
            if (event.getRawSlot() == 10) {
                player.closeInventory();
                EnderChestManager.openEnderChest(1, player, player.getUniqueId());
                player.playSound(player.getLocation(), Sound.CHEST_OPEN, 18, 4);
                //player.sendMessage(PrefixManager.ENDERCHEST + "§7Du hast die §dSeite 1 §7von deiner Enderchest geöffnet§8.");
            } else if (event.getRawSlot() == 11) {
                player.closeInventory();
                EnderChestManager.openEnderChest(2, player, player.getUniqueId());
                player.playSound(player.getLocation(), Sound.CHEST_OPEN, 18, 4);
                //player.sendMessage(PrefixManager.ENDERCHEST + "§7Du hast die §dSeite 2 §7von deiner Enderchest geöffnet§8.");
            } else if (event.getRawSlot() == 12) {
                player.closeInventory();
                EnderChestManager.openEnderChest(3, player, player.getUniqueId());
                player.playSound(player.getLocation(), Sound.CHEST_OPEN, 18, 4);
                //player.sendMessage(PrefixManager.ENDERCHEST + "§7Du hast die §dSeite 3 §7von deiner Enderchest geöffnet§8.");
            } else if (event.getRawSlot() == 13) {
                player.closeInventory();
                EnderChestManager.openEnderChest(4, player, player.getUniqueId());
                player.playSound(player.getLocation(), Sound.CHEST_OPEN, 18, 4);
                //player.sendMessage(PrefixManager.ENDERCHEST + "§7Du hast die §dSeite 4 §7von deiner Enderchest geöffnet§8.");
            } else if (event.getRawSlot() == 14) {
                player.closeInventory();
                EnderChestManager.openEnderChest(5, player, player.getUniqueId());
            } else if (event.getRawSlot() == 15) {
                player.closeInventory();
                EnderChestManager.openEnderChest(6, player, player.getUniqueId());
                player.playSound(player.getLocation(), Sound.CHEST_OPEN, 18, 4);
            } else if (event.getRawSlot() == 16) {
                player.closeInventory();
                EnderChestManager.openEnderChest(7, player, player.getUniqueId());
                player.playSound(player.getLocation(), Sound.CHEST_OPEN, 18, 4);
            }
        } else if (event.getInventory().getName().equalsIgnoreCase(PrefixManager.ENDERCHEST + "§2§7Hub")) {
            UUID uuid = UUIDFetcher.getUUID(event.getInventory().getItem(4).getItemMeta().getLore().get(event.getInventory().getItem(4).getItemMeta().getLore().size()-2).replaceAll("§8 ▰§7▱ Menü von §d", ""));
            event.setCancelled(true);
            if (event.getRawSlot() == 10) {
                player.closeInventory();
                EnderChestManager.openEnderChest(1, player, uuid);
                player.playSound(player.getLocation(), Sound.CHEST_OPEN, 18, 4);
                //player.sendMessage(PrefixManager.ENDERCHEST + "§7Du hast die §dSeite 1 §7von deiner Enderchest geöffnet§8.");
            } else if (event.getRawSlot() == 11) {
                player.closeInventory();
                EnderChestManager.openEnderChest(2, player, uuid);
                player.playSound(player.getLocation(), Sound.CHEST_OPEN, 18, 4);
                //player.sendMessage(PrefixManager.ENDERCHEST + "§7Du hast die §dSeite 2 §7von deiner Enderchest geöffnet§8.");
            } else if (event.getRawSlot() == 12) {
                player.closeInventory();
                EnderChestManager.openEnderChest(3, player, uuid);
                player.playSound(player.getLocation(), Sound.CHEST_OPEN, 18, 4);
                //player.sendMessage(PrefixManager.ENDERCHEST + "§7Du hast die §dSeite 3 §7von deiner Enderchest geöffnet§8.");
            } else if (event.getRawSlot() == 13) {
                player.closeInventory();
                EnderChestManager.openEnderChest(4, player, uuid);
                player.playSound(player.getLocation(), Sound.CHEST_OPEN, 18, 4);
                //player.sendMessage(PrefixManager.ENDERCHEST + "§7Du hast die §dSeite 4 §7von deiner Enderchest geöffnet§8.");
            } else if (event.getRawSlot() == 14) {
                player.closeInventory();
                EnderChestManager.openEnderChest(5, player, uuid);
            } else if (event.getRawSlot() == 15) {
                player.closeInventory();
                EnderChestManager.openEnderChest(6, player, uuid);
                player.playSound(player.getLocation(), Sound.CHEST_OPEN, 18, 4);
            } else if (event.getRawSlot() == 16) {
                player.closeInventory();
                EnderChestManager.openEnderChest(7, player, uuid);
                player.playSound(player.getLocation(), Sound.CHEST_OPEN, 18, 4);
            }
        }
    }
}

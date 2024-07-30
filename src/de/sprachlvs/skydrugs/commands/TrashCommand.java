package de.sprachlvs.skydrugs.commands;

import de.sprachlvs.skydrugs.SkyDrugs;
import de.sprachlvs.skydrugs.manager.ItemManager;
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
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class TrashCommand implements CommandExecutor, Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if (event.getInventory().getName().equalsIgnoreCase("§8»│ §d§lTRASH§8")) {
            if (event.getCurrentItem() != null) {
                if (event.getCurrentItem().getItemMeta() != null && event.getCurrentItem().getItemMeta().hasDisplayName()) {
                    if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8-/-")) {
                        event.setCancelled(true);
                    }
                }
            }
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if (sender instanceof Player) {
            final Player player = (Player) sender;
            if (PermissionsEx.getUser(player).inGroup("Kavain") || PermissionsEx.getUser(player).inGroup("Valium") || PermissionsEx.getUser(player).inGroup("Opiat") || PermissionsEx.getUser(player).inGroup("Ephedra") || PermissionsEx.getUser(player).inGroup("Salvia") || PermissionsEx.getUser(player).inGroup("Booster") || PermissionsEx.getUser(player).inGroup("Creator") || PermissionsEx.getUser(player).inGroup("Content") || PermissionsEx.getUser(player).inGroup("Supporter") || PermissionsEx.getUser(player).inGroup("Moderator") || PermissionsEx.getUser(player).inGroup("SrModerator") || PermissionsEx.getUser(player).inGroup("Developer") || PermissionsEx.getUser(player).inGroup("Admin") || PermissionsEx.getUser(player).inGroup("Owner")) {

                openInventory(player);
                player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 100, 14);
                player.sendMessage(SkyDrugs.PREFIX + "§7Der §dMülleimer §7wurde geöffnet§8.");
            } else {
                player.sendMessage(SkyDrugs.NOPERM);
            }
        } else {
            sender.sendMessage(SkyDrugs.PREFIX + "§7Du musst ein Spieler sein§8!");
        }
        return false;
    }

    private void openInventory(Player player) {
        Inventory inventory = Bukkit.createInventory(null, 54, "§8»│ §d§lTRASH§8");
        ItemStack glass = new ItemManager(Material.STAINED_GLASS_PANE).setData(15).setName("§8-/-").build();

        InventoryUtils.fillBorders(inventory, glass); //ik ik teste du mal aus wenn du fertig bist ich lieg so bequem ok chef
        player.openInventory(inventory);
    }
}

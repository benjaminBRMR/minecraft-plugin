package de.sprachlvs.skydrugs.inventorys;

import de.sprachlvs.skydrugs.manager.PrefixManager;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class BlockGUI_Listener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event) {

        Player player = (Player) event.getWhoClicked();

        if (event.getInventory().getName().equalsIgnoreCase(PrefixManager.BLOCK + "§7Hub")) {
            event.setCancelled(true);
            if (event.getRawSlot() == 11) {

                player.playSound(player.getLocation(), Sound.HORSE_ARMOR, 100, 14);
                player.sendMessage(PrefixManager.BLOCK + "§7Du hast die §9Seite 1 §7vom Blockmenü geöffnet§8.");
            } else if (event.getRawSlot() == 22) {

                player.playSound(player.getLocation(), Sound.HORSE_ARMOR, 100, 14);
                player.sendMessage(PrefixManager.BLOCK + "§7Du hast die §9Seite 2 §7vom Blockmenü geöffnet§8.");
            } else if (event.getRawSlot() == 15) {

                player.playSound(player.getLocation(), Sound.HORSE_ARMOR, 100, 14);
                player.sendMessage(PrefixManager.BLOCK + "§7Du hast die §9Seite 3 §7vom Blockmenü geöffnet§8.");
            }
        }
    }
}

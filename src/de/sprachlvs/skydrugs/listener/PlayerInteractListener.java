package de.sprachlvs.skydrugs.listener;

import de.sprachlvs.skydrugs.commands.EnderChestCommand;
import de.sprachlvs.skydrugs.manager.PrefixManager;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteractListener implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {

        Player player = event.getPlayer();
        if (event.getClickedBlock() != null && event.getClickedBlock().getType() == Material.ENDER_CHEST) {

            EnderChestCommand.openMainGUI(player, true, null);
            player.sendMessage(PrefixManager.ENDERCHEST + "§7Das Hauptmenü von der §dEnderchest §7wurde geöffnet§8.");
            player.playSound(player.getLocation(), Sound.HORSE_ARMOR, 100, 14);
        }
    }
}

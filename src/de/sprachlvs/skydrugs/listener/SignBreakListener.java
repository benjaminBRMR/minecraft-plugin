package de.sprachlvs.skydrugs.listener;

import de.sprachlvs.skydrugs.SkyDrugs;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class SignBreakListener implements Listener {

    @EventHandler
    public void onSignBreak(final BlockBreakEvent e) {

        final Player player = e.getPlayer();
        final Block block = e.getBlock();

        if(block != null && block.getState() != null) {
            if (block.getState() instanceof Sign) {
                Sign sign = (Sign) block.getState();

                if(player.hasPermission("*")) {

                    if (sign.getLine(0).equalsIgnoreCase("§8»│ §a§lFREE ITEMS")) {
                        if (!player.isSneaking()) {
                            e.setCancelled(true);
                            player.sendMessage(SkyDrugs.PREFIX + "§cBitte sneake§8, §cum das Schild abzubauen§8.");
                        }
                    }
                }
            }
        }
    }
}

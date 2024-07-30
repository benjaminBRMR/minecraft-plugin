package de.sprachlvs.skydrugs.listener;

import de.sprachlvs.skydrugs.apis.CookieAPI;
import de.sprachlvs.skydrugs.inventorys.CookieGUI;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

public class CookieBlockListener implements Listener {

    @EventHandler
    public void onBlockBreak(final BlockBreakEvent e) {

        final Player player = e.getPlayer();
        final Block block = e.getBlock();


        if (block.getLocation().getX() == CookieAPI.cfg.getConfig().getInt("CookieClicker." + ".x")) {
            if (block.getLocation().getY() == CookieAPI.cfg.getConfig().getInt("CookieClicker." + ".y")) {
                if (block.getLocation().getZ() == CookieAPI.cfg.getConfig().getInt("CookieClicker." + ".z")) {
                    if(player.isOp()) {
                        if(player.getItemInHand() != null && player.getItemInHand().getType() == Material.SHEARS) {
                            new CookieAPI(player.getUniqueId()).destroy();
                            block.getLocation().getWorld().dropItem(block.getLocation(), CookieAPI.clicker);
                            player.playSound(player.getLocation(), Sound.LAVA_POP, 100, 14.8F);
                        } else {
                            e.setCancelled(true);
                            CookieGUI.openCookieClicker(player);
                        }
                    } else {
                        e.setCancelled(true);
                        CookieGUI.openCookieClicker(player);
                    }
                }

            }

        }

    }

    @EventHandler
    public void onBlockPlace(final BlockPlaceEvent e) {

        final Player player = e.getPlayer();
        final Block block = e.getBlock();

        if(player.isOp()) {
            if (player.getItemInHand() != null && player.getItemInHand().getItemMeta().getDisplayName() != null && player.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§8»│ §6Cookie-Clicker")) {
                if (player.getItemInHand().getAmount() > 1) {
                    player.getItemInHand().setAmount(player.getItemInHand().getAmount() - 1);
                } else {
                    player.setItemInHand(new ItemStack(Material.AIR));
                }

                new CookieAPI(player.getUniqueId()).place(block.getLocation());


            }
        }

    }
}


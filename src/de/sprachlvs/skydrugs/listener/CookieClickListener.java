package de.sprachlvs.skydrugs.listener;

import de.sprachlvs.skydrugs.SkyDrugs;
import de.sprachlvs.skydrugs.apis.TitleAPI;
import de.sprachlvs.skydrugs.apis.CookieAPI;
import de.sprachlvs.skydrugs.inventorys.CookieGUI;
import de.sprachlvs.skydrugs.manager.CookieSettings;
import de.sprachlvs.skydrugs.manager.PrefixManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class CookieClickListener implements Listener {

    @EventHandler
    public void onBlockClick(PlayerInteractEvent e) {

        final Player player = e.getPlayer();
        final Block block = e.getClickedBlock();


        if(e.getClickedBlock() != null) {
            if (block.getLocation().getX() == CookieAPI.cfg.getConfig().getInt("CookieClicker." + ".x")) {
                if (block.getLocation().getY() == CookieAPI.cfg.getConfig().getInt("CookieClicker." + ".y")) {
                    if (block.getLocation().getZ() == CookieAPI.cfg.getConfig().getInt("CookieClicker." + ".z")) {
                        if(e.getAction() != null && e.getAction() == Action.RIGHT_CLICK_BLOCK) {

                            if(new CookieAPI(player.getUniqueId()).getStatus()) {
                                if (CookieCPSListener.forbidden.get(player) != Boolean.TRUE) {

                                    if(new CookieSettings(player.getUniqueId()).getLevel() == 1) {
                                        new CookieAPI(player.getUniqueId()).addCookies(5);
                                    } else if(new CookieSettings(player.getUniqueId()).getLevel() == 2) {
                                        new CookieAPI(player.getUniqueId()).addCookies(10);
                                    } else if(new CookieSettings(player.getUniqueId()).getLevel() == 3) {
                                        new CookieAPI(player.getUniqueId()).addCookies(15);
                                    } else if(new CookieSettings(player.getUniqueId()).getLevel() == 4) {
                                        new CookieAPI(player.getUniqueId()).addCookies(20);
                                    } else if(new CookieSettings(player.getUniqueId()).getLevel() == 5) {
                                        new CookieAPI(player.getUniqueId()).addCookies(25);
                                    } else {
                                        new CookieAPI(player.getUniqueId()).addCookies(1);
                                    }
                                }


                                if (new CookieSettings(player.getUniqueId()).getTitleStatus()) {
                                    TitleAPI.sendTitle(player, 3, 13, 15, "§8» §e§lCLICKER §8«", "§e" + CookieAPI.getFormated(new CookieAPI(player.getUniqueId()).getCookies()) + " §6§oC§e§oookie§6§os");
                                }
                                TitleAPI.sendActionbar(player, "§8»│ §7Deine Cookies§8: §e" + CookieAPI.getFormated(new CookieAPI(player.getUniqueId()).getCookies()));


                                if (new CookieSettings(player.getUniqueId()).getClickStatus()) {
                                    player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 0.7F, 14.8F);
                                }


                                ItemStack is = new ItemStack(Material.COOKIE);
                                final Item cookie = block.getWorld().dropItem(block.getLocation().add(0.5D, 0.5D, 0.5D), is);
                                cookie.setPickupDelay(9999);


                                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(SkyDrugs.getInstance(), new Runnable() {
                                    public void run() {
                                        cookie.remove();
                                    }
                                }, 15L);
                            } else {
                                player.sendMessage(PrefixManager.COOKIECLICKER + "§7Der §eCookieClicker §7ist derzeit §cdeaktiviert§8.");
                            }





                        } else if (e.getAction() == Action.LEFT_CLICK_BLOCK) {
                            CookieGUI.openCookieClicker(player);
                        } else {
                            e.setCancelled(true);
                        }
                    }
                }

            }
        }
    }
}


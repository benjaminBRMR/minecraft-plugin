package de.sprachlvs.skydrugs.listener;

import de.sprachlvs.skydrugs.SkyDrugs;
import de.sprachlvs.skydrugs.apis.CookieAPI;
import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.*;

public class CookieCPSListener implements Listener {

    private static Map<UUID, List<Long>> clicks = new HashMap<>();

    public static void addClick(UUID uuid) {
        List<Long> list = null;
        if (clicks.containsKey(uuid)) {
            list = clicks.get(uuid);
        } else {
            list = new ArrayList<>();
        }
        list.add(Long.valueOf(System.currentTimeMillis()));
        clicks.put(uuid, list);
    }

    public static int getClicks(UUID uuid) {
        Iterator<Long> iterator = clicks.get(uuid).iterator();
        while (iterator.hasNext()) {
            if (((Long) iterator.next()).longValue() < System.currentTimeMillis() - 1000L) {
                iterator.remove();
            }
        }
        return clicks.get(uuid).size();
    }


    public static HashMap<Player, Boolean> forbidden = new HashMap<>();

    @EventHandler
    public void onJoin(final PlayerJoinEvent e) {
        forbidden.put(e.getPlayer(), false);
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onClick(PlayerInteractEvent e) {

        final Player player = e.getPlayer();
        final Block block = e.getClickedBlock();




        if(e.getClickedBlock() != null) {
            if (block.getLocation().getX() == CookieAPI.cfg.getConfig().getInt("CookieClicker." + ".x")) {
                if (block.getLocation().getY() == CookieAPI.cfg.getConfig().getInt("CookieClicker." + ".y")) {
                    if (block.getLocation().getZ() == CookieAPI.cfg.getConfig().getInt("CookieClicker." + ".z")) {
                        if (e.getAction() != null && e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                            if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                                addClick(player.getUniqueId());
                                if(getClicks(player.getUniqueId()) > 19) {


                                    if(forbidden.get(player) != Boolean.TRUE){
                                        if(!player.isOp()) {
                                            forbidden.put(player, true);
                                        }
                                    }

                                    Bukkit.getScheduler().runTaskLater(SkyDrugs.getInstance(), new Runnable() {
                                        @Override
                                        public void run() {
                                            forbidden.put(player, false);
                                        }
                                    }, 40L);


                                }

                                //player.sendMessage(PrefixManager.COOKIECLICKER + "§7CPS§8: §6" + getClicks(player.getUniqueId()));

                            }
                        }
                    }
                }
            }
        }
    }
}


package de.sprachlvs.skydrugs.inventorys;

import de.sprachlvs.skydrugs.apis.TextHoverAPI;
import de.sprachlvs.skydrugs.apis.TitleAPI;
import de.sprachlvs.skydrugs.manager.LocationManager;
import de.sprachlvs.skydrugs.manager.PrefixManager;
import de.sprachlvs.skydrugs.utils.TeleportUtil;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class WarpGUI_Listener implements Listener {

    @EventHandler
    public void onInventoryClick(final InventoryClickEvent event) {

        final Player player = (Player)event.getWhoClicked();

        if(event.getInventory().getName().equalsIgnoreCase(PrefixManager.WARP)) {
            event.setCancelled(true);

            if(event.getRawSlot() == 11) {
                new TeleportUtil(player).start(LocationManager.getLocation("angelteich"));
                player.playSound(player.getLocation(), Sound.ENDERMAN_TELEPORT, 100, 14.8F);
                player.closeInventory();
                TitleAPI.sendTitle(player, 10,15,10,"§8» §3&lWARP §8«", "§7§oAngelteich");
            }

            if(event.getRawSlot() == 15) {
                new TeleportUtil(player).start(LocationManager.getLocation("enchanter"));
                player.playSound(player.getLocation(), Sound.ENDERMAN_TELEPORT, 100, 14.8F);
                player.closeInventory();
                TitleAPI.sendTitle(player, 10,15,10,"§8» §3&lWARP §8«", "§7§oEnchanter");
            }
            if(event.getRawSlot() == 22) {
                new TeleportUtil(player).start(LocationManager.getLocation("spawn"));
                player.playSound(player.getLocation(), Sound.ENDERMAN_TELEPORT, 100, 14.8F);
                player.closeInventory();
                TitleAPI.sendTitle(player, 10,15,10,"§8» §3&lWARP §8«", "§7§oSpawn");
            }

            if(event.getRawSlot() == 29) {
                new TeleportUtil(player).start(LocationManager.getLocation("cookieclicker"));
                player.playSound(player.getLocation(), Sound.ENDERMAN_TELEPORT, 100, 14.8F);
                player.closeInventory();
                TitleAPI.sendTitle(player, 10,15,10,"§8» §3&lWARP §8«", "§7§oCookieClicker");
            }

            if(event.getRawSlot() == 33) {
                new TeleportUtil(player).start(LocationManager.getLocation("arena"));
                player.playSound(player.getLocation(), Sound.ENDERMAN_TELEPORT, 100, 14.8F);
                player.closeInventory();
                TitleAPI.sendTitle(player, 10,15,10,"§8» §3&lWARP §8«", "§7§oArena");
            }
            if(event.getRawSlot() == 44) {

                player.playSound(player.getLocation(), Sound.DOOR_OPEN, 100, 14.8F);
                player.closeInventory();


                if(LocationManager.getAllLocation() != null && !LocationManager.getAllLocation().isEmpty()) {

                    player.sendMessage("");
                    player.sendMessage(PrefixManager.WARP  + "§7Weitere verfügbare Warps die gefunden wurden§8:");
                    for (String all_locs : LocationManager.getAllLocation()) {


                        //player.sendMessage(PrefixManager.WARP  + "§3§o" + all_locs.toUpperCase());
                        TextHoverAPI.HoverCommand(player, PrefixManager.WARP  + "§3§o" + all_locs.toUpperCase(), "/warp teleport " + all_locs, "§8»│ §7Klicke um zu §3§o" + all_locs.toUpperCase() + " §7teleportiert zu werden§8.");
                    }
                    player.sendMessage("");
                    player.playSound(player.getLocation(), Sound.WOOD_CLICK, 100, 18.4F);
                } else {
                    player.sendMessage(PrefixManager.WARP + "§cEs wurden keine weiteren Warps gefunden§8.");
                }
            }


        }
    }
}
package de.sprachlvs.skydrugs.listener;

import de.sprachlvs.skydrugs.utils.UUIDFetcher;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        event.setQuitMessage(null);
        UUIDFetcher.nameCache.remove(player.getUniqueId()); //wenn das dann nicht geht liegt an dir bei mir gehts haste nh anderen uuidfetcher maybe? ja warte
        UUIDFetcher.uuidCache.remove(player.getName());
    }
}

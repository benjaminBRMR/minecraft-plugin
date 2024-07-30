package de.sprachlvs.skydrugs.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import java.util.ArrayList;

public class PlayerBlockListener implements Listener {


    public static ArrayList<Player> buildmode = new ArrayList<>();



    @EventHandler
    public void BlockPlace(BlockPlaceEvent event) {

        Player player = event.getPlayer();

        if(!buildmode.contains(player)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void BlockBreak(BlockBreakEvent event) {

        Player player = event.getPlayer();

        if(!buildmode.contains(player)) {
            event.setCancelled(true);
        }
    }
}

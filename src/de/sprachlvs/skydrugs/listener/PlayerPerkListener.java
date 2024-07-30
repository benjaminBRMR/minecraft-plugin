package de.sprachlvs.skydrugs.listener;

import de.sprachlvs.skydrugs.apis.PerkAPI;
import de.sprachlvs.skydrugs.apis.PerkEnum;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class PlayerPerkListener implements Listener {

    @EventHandler
    public void onFoodLevelChange(final FoodLevelChangeEvent e) {

        final Player player = (Player) e.getEntity();

        if (new PerkAPI(player).getPerkStatus(PerkEnum.NOHUNGER)) {
            e.setCancelled(true);
        }
    }
}

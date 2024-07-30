package de.sprachlvs.skydrugs.apis;

import de.sprachlvs.skydrugs.apis.stats.DeathAPI;
import de.sprachlvs.skydrugs.apis.stats.KillAPI;
import org.bukkit.entity.Player;

import java.text.NumberFormat;

public class KD_RatioAPI {
    public static String getPlayerKD(Player p) {
        NumberFormat n = NumberFormat.getInstance();
        n.setMaximumFractionDigits(2);
        double kills = new KillAPI(p).getKills();
        double deaths = new DeathAPI(p).getDeaths();
        return String.format("%.1f", new Object[] { kills / deaths });
    }
}
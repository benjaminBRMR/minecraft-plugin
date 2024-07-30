package de.sprachlvs.skydrugs.events;

import de.sprachlvs.skydrugs.apis.EventAPI;
import de.sprachlvs.skydrugs.apis.stats.TokenAPI;
import de.sprachlvs.skydrugs.manager.PrefixManager;
import de.sprachlvs.skydrugs.utils.GeneralUtils;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import java.text.DecimalFormat;

public class TokenverlosungEvent {

    static double value;

    static boolean active;

    public void start(Player starter, double tokens) {
        value = tokens;
        if (EventAPI.event) {
            starter.sendMessage(PrefixManager.EVENT + "§cEs läuft bereits ein anderes Event§8.");
            return;
        }
        EventAPI.event = true;
        active = true;
        Player winner = GeneralUtils.getRandomPlayer(starter, true);
        if (winner == null) {
            EventAPI.event = false;
            active = false;
            return;
        }
        GeneralUtils.clearChatAll();
        Bukkit.broadcastMessage("§r");
        Bukkit.broadcastMessage(PrefixManager.EVENT + "§7Eine §fTokenverlosung§7 wurde soeben gestartet§8.");
        Bukkit.broadcastMessage(PrefixManager.EVENT + "§7Es werden §e" + new DecimalFormat("#,###.##").format(tokens) + " §7Tokens§7 verlost§8.");
        Bukkit.broadcastMessage("§r");
        for (Player all : Bukkit.getOnlinePlayers()) all.playSound(all.getLocation(), Sound.ENDERDRAGON_WINGS, 1.0f, 1.0f);
        Verlosung.showTitleTokenverlosung(winner.getName(), () -> {
            Bukkit.broadcastMessage("§r");
            Bukkit.broadcastMessage(PrefixManager.EVENT + "§7Der Spieler §f" + winner.getName() + " §7hat die Verlosung gewonnen§8.");
            Bukkit.broadcastMessage("§r");
            new TokenAPI(winner).addTokens(value);
            EventAPI.event = false;
            active = false;
        });
    }

}

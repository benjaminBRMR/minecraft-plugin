package de.sprachlvs.skydrugs.scoreboard;

import de.sprachlvs.skydrugs.apis.GetGroupAPI;
import de.sprachlvs.skydrugs.apis.stats.DeathAPI;
import de.sprachlvs.skydrugs.apis.stats.KillAPI;
import de.sprachlvs.skydrugs.apis.stats.TokenAPI;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;

import java.text.DecimalFormat;

import static de.sprachlvs.skydrugs.apis.PlayTimeAPI.getTime;


public class Scoreboard {
    public static String worldname;


    public static String getFormatedTokens(double amount) {
        DecimalFormat decimalFormat = new DecimalFormat("###,###.###");
        return decimalFormat.format(amount).replace(",", "§8'§e");
    }

    public static String getFormatedKills(double amount) {
        DecimalFormat decimalFormat = new DecimalFormat("###,###.###");
        return decimalFormat.format(amount).replace(",", "§8'§a");
    }

    public static String getFormatedDeaths(double amount) {
        DecimalFormat decimalFormat = new DecimalFormat("###,###.###");
        return decimalFormat.format(amount).replace(",", "§8'§c");
    }

    public static Character getFirstCharacter(String s) {
        if (s == null || s.length() == 0)
            return null;
        return s.charAt(0);
    }

    public static void updatescoreboard(FastBoard board) {
        Player p = board.getPlayer();
        DecimalFormat format = new DecimalFormat("#.##");
        double kills = new KillAPI(p).getKills();
        double deaths = new DeathAPI(p).getDeaths();
        double kd = kills / deaths;

        board.updateTitle("§d§l" + getFirstCharacter(p.getName().toUpperCase()) + "§d§l" + p.getName().substring(1).toLowerCase());
        board.updateLines("      §7§oskydrugs.de",
                "",
                "§8▰§7▱ §7Rang §8(§d✎§8)",
                " §8➥ §d" + GetGroupAPI.getGroupScoreboard(p),
                "",
                "§8▰§7▱ §7Tokens §8(§6⛃§8)",
                " §8➥ §e" + getFormatedTokens(new TokenAPI(p).getTokens()),
                "",
                "§8▰§7▱ §7Statistiken §8(§c✞§8)",
                " §8➥ §a" + getFormatedKills(new KillAPI(p).getKills()) + "§8/§c" + getFormatedDeaths(new DeathAPI(p).getDeaths()),
                "",
                "§8▰§7▱ §7Spielzeit §8(§f❤§8)",
                " §8➥ §a" + getTime(p.getStatistic(Statistic.PLAY_ONE_TICK) / 20),
                "");

    }
}
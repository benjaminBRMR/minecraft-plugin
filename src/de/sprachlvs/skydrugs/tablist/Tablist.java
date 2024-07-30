package de.sprachlvs.skydrugs.tablist;

import de.sprachlvs.skydrugs.commands.ClanCommand;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class Tablist {

    static Scoreboard sb;

    public static void syncTablist() {


        sb = Bukkit.getScoreboardManager().getNewScoreboard();

        sb.registerNewTeam("00000Owner");
        sb.registerNewTeam("00001Admin");
        sb.registerNewTeam("00002Dev");
        sb.registerNewTeam("00003SrMod");
        sb.registerNewTeam("00004Mod");
        sb.registerNewTeam("00005Sup");
        sb.registerNewTeam("00006Content");
        sb.registerNewTeam("00007Creator");
        sb.registerNewTeam("00008Booster");
        sb.registerNewTeam("00009Salvia");
        sb.registerNewTeam("00010Ephedra");
        sb.registerNewTeam("00011Opiat");
        sb.registerNewTeam("00012Valium");
        sb.registerNewTeam("00013Kavain");
        sb.registerNewTeam("00014default");



        sb.getTeam("00000Owner").setPrefix("§4O §8▰§7▱ §7");
        sb.getTeam("00001Admin").setPrefix("§cA §8▰§7▱ §7");
        sb.getTeam("00002Dev").setPrefix("§bD §8▰§7▱ §7");
        sb.getTeam("00003SrMod").setPrefix("§cSrM §8▰§7▱ §7");
        sb.getTeam("00004Mod").setPrefix("§3M §8▰§7▱ §7");
        sb.getTeam("00005Sup").setPrefix("§aS §8▰§7▱ §7");
        sb.getTeam("00006Content").setPrefix("§eC §8▰§7▱ §7");
        sb.getTeam("00007Creator").setPrefix("§5C §8▰§7▱ §7");
        sb.getTeam("00008Booster").setPrefix("§dB §8▰§7▱ §7");
        sb.getTeam("00009Salvia").setPrefix("§5S §8▰§7▱ §7");
        sb.getTeam("00010Ephedra").setPrefix("§cE §8▰§7▱ §7");
        sb.getTeam("00011Opiat").setPrefix("§bO §8▰§7▱ §7");
        sb.getTeam("00012Valium").setPrefix("§cV §8▰§7▱ §7");
        sb.getTeam("00013Kavain").setPrefix("§eK §8▰§7▱ §7");
        sb.getTeam("00014default").setPrefix("§7");

    }


    @SuppressWarnings("deprecation")
    public static void updateTablistRanks(Player player) {
        final String team;

        if(PermissionsEx.getUser(player).inGroup("Owner")) {
            team = "00000Owner";
        } else if(PermissionsEx.getUser(player).inGroup("Admin")) {
            team = "00001Admin";
        } else if(PermissionsEx.getUser(player).inGroup("Developer")) {
            team = "00002Dev";
        } else if(PermissionsEx.getUser(player).inGroup("SrModerator")) {
            team = "00003SrMod";
        } else if(PermissionsEx.getUser(player).inGroup("Moderator")) {
            team = "00004Mod";
        } else if(PermissionsEx.getUser(player).inGroup("Supporter")) {
            team = "00005Sup";
        } else if(PermissionsEx.getUser(player).inGroup("Content")) {
            team = "00006Content";
        } else if(PermissionsEx.getUser(player).inGroup("Creator")) {
            team = "00007Creator";
        } else if(PermissionsEx.getUser(player).inGroup("Booster")) {
            team = "00008Booster";
        } else if(PermissionsEx.getUser(player).inGroup("Salvia")) {
            team = "00009Salvia";
        } else if(PermissionsEx.getUser(player).inGroup("Ephedra")) {
            team = "00010Ephedra";
        } else if(PermissionsEx.getUser(player).inGroup("Opiat")) {
            team = "00011Opiat";
        } else if(PermissionsEx.getUser(player).inGroup("Valium")) {
            team = "00012Valium";
        } else if(PermissionsEx.getUser(player).inGroup("Kavain")) {
            team = "00013Kavain";
        } else {
            team = "00014default";
        }


        sb.getTeam(team).addPlayer(player);
        if (ClanCommand.claned(player)) {
            player.setPlayerListName(sb.getTeam(team).getPrefix() + player.getName() + " §8[§5" + ClanCommand.getClan(player).toUpperCase() + "§8]");
        } else {
            player.setPlayerListName(sb.getTeam(team).getPrefix() + player.getName());
        }
        Bukkit.getOnlinePlayers().forEach(all -> all.setScoreboard(sb));

    }
}

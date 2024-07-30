package de.sprachlvs.skydrugs.commands;

import de.sprachlvs.skydrugs.SkyDrugs;
import de.sprachlvs.skydrugs.apis.stats.KillAPI;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.tehkode.permissions.bukkit.PermissionsEx;

import java.text.DecimalFormat;

public class SetKillsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if (PermissionsEx.getUser(player).inGroup("Owner")) {
                if (args.length != 2) {
                    player.sendMessage(SkyDrugs.PREFIX + "§7Syntax§8: /§csetkills §8<§cSpielername§8> <§cAnzahl§8>");
                } else {
                    if (Bukkit.getPlayer(args[0]) == null) {
                        player.sendMessage(SkyDrugs.PREFIX + "§cDer Spieler ist nicht online§8.");
                    } else {
                        Player target = Bukkit.getPlayer(args[0]);
                        try {
                            long kills = Long.parseLong(args[1]);
                            new KillAPI(target.getUniqueId()).setKills(kills);
                            player.sendMessage(SkyDrugs.PREFIX + "§7Du hast die Kills von §d" + target.getName() + "§7 zu §a" + new DecimalFormat("#,###.##").format(kills) + " §7gesetzt§8.");
                        } catch (NumberFormatException e) {
                            player.sendMessage(SkyDrugs.PREFIX + "§7Syntax§8: /§csetkills §8<§cSpielername§8> <§cAnzahl§8>");
                        }
                    }
                }
            } else {
                player.sendMessage(SkyDrugs.NOPERM);
            }
        }

        return false;
    }
}

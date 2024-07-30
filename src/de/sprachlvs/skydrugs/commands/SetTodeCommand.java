package de.sprachlvs.skydrugs.commands;

import de.sprachlvs.skydrugs.SkyDrugs;
import de.sprachlvs.skydrugs.apis.stats.DeathAPI;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.tehkode.permissions.bukkit.PermissionsEx;

import java.text.DecimalFormat;

public class SetTodeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if (PermissionsEx.getUser(player).inGroup("Owner")) {
                if (args.length != 2) {
                    player.sendMessage(SkyDrugs.PREFIX + "§7Syntax§8: /§csetkills §8<§cspielername§8> <§canzahl§8>");
                } else {
                    if (Bukkit.getPlayer(args[0]) == null) {
                        player.sendMessage(SkyDrugs.PREFIX + "§cDer Spieler ist nicht online§8.");
                    } else {
                        Player target = Bukkit.getPlayer(args[0]);
                        try {
                            long deaths = Long.parseLong(args[1]);
                            new DeathAPI(target.getUniqueId()).setDeaths(deaths);
                            player.sendMessage(SkyDrugs.PREFIX + "§7Du hast die Tode von §d" + target.getName() + "§7 zu §a" + new DecimalFormat("#,###.##").format(deaths) + " §7gesetzt§8.");
                        } catch (NumberFormatException e) {
                            player.sendMessage(SkyDrugs.PREFIX + "§7Syntax§8: /§csettode §8<§cspielername§8> <§canzahl§8>");
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


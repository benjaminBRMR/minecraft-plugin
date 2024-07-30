package de.sprachlvs.skydrugs.commands;

import de.sprachlvs.skydrugs.SkyDrugs;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class RamCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (cmd.getName().equalsIgnoreCase("ram")) {

            if (sender instanceof Player) {
                final Player player = (Player) sender;
                if (PermissionsEx.getUser(player).inGroup("Admin") || PermissionsEx.getUser(player).inGroup("Owner")) {

                    if (args.length != 0) {
                        player.sendMessage(SkyDrugs.PREFIX + "§7Syntax§8: /§eram");
                        return true;
                    }
                    Runtime r = Runtime.getRuntime();
                    long ramnutzung = r.maxMemory() - r.freeMemory();
                    long prozent = ramnutzung * 100L / r.maxMemory();
                    player.sendMessage("§7 ");
                    player.sendMessage(SkyDrugs.getHeader("§e§lRAM"));
                    player.sendMessage("§7 ");
                    player.sendMessage("§8» §7In Benutzung: §e" + (ramnutzung / 1048576L) + "§8/§6" + (r.maxMemory() / 1048576L) + " §7MB");
                    player.sendMessage("§8» §7Benutzung in %: §e" + prozent + "%");
                    player.sendMessage("§8» §7Maximal: §e" + (r.maxMemory() / 1048576L) + " §7MB");
                    player.sendMessage("§8» §7Frei: §e" + (r.maxMemory() / 1048576L - ramnutzung / 1048576L) + " §7MB");
                    player.sendMessage(" ");
                    player.sendMessage(SkyDrugs.getHeader("§e§lRAM"));
                    player.sendMessage("§7 ");
                } else {
                    player.sendMessage(SkyDrugs.NOPERM);
                }
            } else {
                sender.sendMessage(SkyDrugs.PREFIX + "§7Du musst ein Spieler sein§8!");
            }
        }
        return false;
    }
}

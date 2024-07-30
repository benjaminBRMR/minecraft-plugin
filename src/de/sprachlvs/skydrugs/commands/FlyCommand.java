package de.sprachlvs.skydrugs.commands;

import de.sprachlvs.skydrugs.SkyDrugs;
import de.sprachlvs.skydrugs.manager.PrefixManager;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class FlyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if (sender instanceof Player) {
            final Player player = (Player) sender;

            if (PermissionsEx.getUser(player).inGroup("Salvia") || PermissionsEx.getUser(player).inGroup("Booster") || PermissionsEx.getUser(player).inGroup("Creator") || PermissionsEx.getUser(player).inGroup("Content") || PermissionsEx.getUser(player).inGroup("Supporter") || PermissionsEx.getUser(player).inGroup("Moderator") || PermissionsEx.getUser(player).inGroup("SrModerator") || PermissionsEx.getUser(player).inGroup("Developer") || PermissionsEx.getUser(player).inGroup("Admin") || PermissionsEx.getUser(player).inGroup("Owner")) {

                if (args.length == 1) {
                    if (PermissionsEx.getUser(player).inGroup("Admin") || PermissionsEx.getUser(player).inGroup("Owner")) {
                        try {
                            final Player arg = Bukkit.getPlayer(args[0]);

                            if (!arg.getAllowFlight()) {

                                arg.setAllowFlight(true);
                                arg.sendMessage(PrefixManager.FLY + "§7Dein Flugmodus wurde von §5" + player.getName() + " §7aktiviert§8.");
                                arg.playSound(arg.getLocation(), Sound.PISTON_EXTEND, 100, 14);

                                player.sendMessage(PrefixManager.FLY + "§7Du hast den Flugmodus von §5" + arg.getName() + " §7aktiviert§8.");
                                player.playSound(player.getLocation(), Sound.PISTON_EXTEND, 100, 14);

                            } else {

                                arg.setAllowFlight(false);
                                arg.sendMessage(PrefixManager.FLY + "§7Dein Flugmodus wurde von §5" + player.getName() + " §7deaktiviert§8.");
                                arg.playSound(arg.getLocation(), Sound.PISTON_RETRACT, 100, 14);

                                player.sendMessage(PrefixManager.FLY + "§7Du hast den Flugmodus von §5" + arg.getName() + " §7deaktiviert§8.");
                                player.playSound(player.getLocation(), Sound.PISTON_RETRACT, 100, 14);
                            }
                        } catch (NullPointerException e) {
                            player.sendMessage(PrefixManager.FLY + "§7Dieser Spieler ist nicht online§8.");
                        }
                    } else {
                        player.sendMessage(SkyDrugs.NOPERM);
                    }
                } else if (args.length == 0){

                    if (!player.getAllowFlight()) {

                        player.setAllowFlight(true);
                        player.sendMessage(PrefixManager.FLY + "§7Dein Flugmodus wurde §aaktiviert§8.");
                        player.playSound(player.getLocation(), Sound.PISTON_EXTEND, 100, 14);

                    } else {

                        player.setAllowFlight(false);
                        player.sendMessage(PrefixManager.FLY + "§7Dein Flugmodus wurde §cdeaktiviert§8.");
                        player.playSound(player.getLocation(), Sound.PISTON_RETRACT, 100, 14);

                    }
                }
            } else {
                player.sendMessage(SkyDrugs.NOPERM);
            }
        } else {
            sender.sendMessage(PrefixManager.BUILD + "§7Du musst ein Spieler sein§8!");
        }
        return false;
    }
}
package de.sprachlvs.skydrugs.commands;

import de.sprachlvs.skydrugs.SkyDrugs;
import de.sprachlvs.skydrugs.inventorys.WarpGUI;
import de.sprachlvs.skydrugs.manager.LocationManager;
import de.sprachlvs.skydrugs.manager.PrefixManager;
import de.sprachlvs.skydrugs.utils.TeleportUtil;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class WarpCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if(sender instanceof Player) {
            final Player player = (Player)sender;

            if(args.length == 0) {
                WarpGUI.openWarpMenu(player);
            } else {
                if (args[0].equalsIgnoreCase("set")) {
                    if (PermissionsEx.getUser(player).inGroup("Admin") || PermissionsEx.getUser(player).inGroup("Owner ")) {


                        if (args[1].isEmpty()) {
                            player.sendMessage(PrefixManager.WARP  + "§7Syntax§8: /§3warp §8<§7set§8,§7 delete§8> §8<§7name§8>");
                        } else {
                            final String warpname = args[1];

                            if (warpname == null) {
                                player.sendMessage(PrefixManager.WARP  + "§7Syntax§8: /§3warp §8<§7set§8,§7 delete§8> §8<§7name§8>");
                            } else {
                                LocationManager.setLocation(player.getLocation(), warpname.toLowerCase());
                                player.sendMessage(PrefixManager.WARP  + "§7Der Warp §8'§b" + warpname.toUpperCase() + "§8' §7wurde gesetzt§8.");
                                player.playSound(player.getLocation(), Sound.PISTON_EXTEND, 100, 14.8F);
                            }
                        }
                    } else {
                        WarpGUI.openWarpMenu(player);
                    }
                } else if (args[0].equalsIgnoreCase("del") || args[0].equalsIgnoreCase("delete")) {

                    if(PermissionsEx.getUser(player).inGroup("Admin") || PermissionsEx.getUser(player).inGroup("Owner")) {

                        if (args.length < 1) {
                            player.sendMessage(PrefixManager.WARP  + "§7Syntax§8: /§3warp §8<§7set§8,§7 delete§8, §7tp§8> §8<§7name§8>");
                        } else {
                            final String warpname = args[1];

                            if (warpname == null) {
                                player.sendMessage(PrefixManager.WARP  + "§7Syntax§8: /§3warp §8<§7set§8,§7 delete§8, §7tp§8> §8<§7name§8>");
                            } else {
                                LocationManager.remLocation(warpname.toLowerCase());
                                player.sendMessage(PrefixManager.WARP  + "§7Der Warp §8'§b" + warpname.toUpperCase() + "§8' §7wurde entfernt§8.");
                                player.playSound(player.getLocation(), Sound.PISTON_RETRACT, 100, 14.8F);
                            }
                        }
                    } else {
                        WarpGUI.openWarpMenu(player);
                    }

                } else if(args[0].equalsIgnoreCase("teleport") || args[0].equalsIgnoreCase("tp")){

                    if(args.length < 1) {
                        player.sendMessage(PrefixManager.WARP  + "§7Syntax§8: /§3warp §8<§7teleport§8> §8<§7name§8>");
                    } else {
                        final String warpname = args[1];

                        if (warpname == null) {
                            player.sendMessage(PrefixManager.WARP  + "§7Syntax§8: /§3warp §8<§7teleport§8> §8<§7name§8>");
                        } else {
                            new TeleportUtil(player).start(LocationManager.getLocation(warpname));
                        }
                    }



                } else {
                    if (PermissionsEx.getUser(player).inGroup("Admin") || PermissionsEx.getUser(player).inGroup("Owner")) {
                        player.sendMessage(PrefixManager.WARP + "§7Syntax§8: /§3warp §8<§7set§8,§7 delete§8> §8<§7name§8>");
                    } else {
                        player.sendMessage(SkyDrugs.NOPERM);
                    }
                }
            }
        } else {
            sender.sendMessage(SkyDrugs.PREFIX + "§7Du musst ein Spieler sein§8!");
        }
        return false;
    }
}

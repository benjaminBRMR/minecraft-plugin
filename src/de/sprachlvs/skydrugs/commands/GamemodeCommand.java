package de.sprachlvs.skydrugs.commands;

import de.sprachlvs.skydrugs.SkyDrugs;
import de.sprachlvs.skydrugs.manager.PrefixManager;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class GamemodeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if (sender instanceof Player) {
            final Player player = (Player) sender;

            if (PermissionsEx.getUser(player).inGroup("Owner")) {

                if (args.length == 1) {
                    if (args[0].equalsIgnoreCase("0")) {

                        player.setGameMode(GameMode.SURVIVAL);
                        player.playSound(player.getLocation(), Sound.SPLASH, 100, 14);
                        player.sendMessage(PrefixManager.GAMEMODE + "§7Du bist nun im §aÜberlebensmodus§8!");
                    } else if (args[0].equalsIgnoreCase("1")) {

                        player.setGameMode(GameMode.CREATIVE);
                        player.playSound(player.getLocation(), Sound.SPLASH, 100, 14);
                        player.sendMessage(PrefixManager.GAMEMODE + "§7Du bist nun im §aKreativmodus§8!");
                    } else if (args[0].equalsIgnoreCase("2")) {

                        player.setGameMode(GameMode.ADVENTURE);
                        player.playSound(player.getLocation(), Sound.SPLASH, 100, 14);
                        player.sendMessage(PrefixManager.GAMEMODE + "§7Du bist nun im §aAbenteuermodus§8!");
                    } else if (args[0].equalsIgnoreCase("3")) {

                        player.setGameMode(GameMode.SPECTATOR);
                        player.playSound(player.getLocation(), Sound.SPLASH, 100, 14);
                        player.sendMessage(PrefixManager.GAMEMODE + "§7Du bist nun im §aZuschauermodus§8!");
                    } else {
                        player.sendMessage(PrefixManager.GAMEMODE + "§7Syntax§8: /§agm §8<§20§8, §21§8, §22§8, §23§8>");
                    }
                } else if (args.length == 2) {
                    if (PermissionsEx.getUser(player).inGroup("Owner")) {
                        try {
                            final Player arg = Bukkit.getPlayer(args[1]);

                            if (args[0].equalsIgnoreCase("0")) {

                                arg.setGameMode(GameMode.SURVIVAL);
                                arg.playSound(player.getLocation(), Sound.SPLASH, 100, 14);
                                arg.sendMessage(PrefixManager.GAMEMODE + "§2" + player.getName() + " §7hat dich in den §aÜberlebensmodus §7gesetzt§8.");

                                player.playSound(player.getLocation(), Sound.SPLASH, 100, 14);
                                player.sendMessage(PrefixManager.GAMEMODE + "§2" + arg.getName() + " §7wurde von dir in den §aÜberlebensmodus §7gesetzt§8.");

                            } else if (args[0].equalsIgnoreCase("1")) {

                                arg.setGameMode(GameMode.CREATIVE);
                                arg.playSound(player.getLocation(), Sound.SPLASH, 100, 14);
                                arg.sendMessage(PrefixManager.GAMEMODE + "§2" + player.getName() + " §7hat dich in den §aKreativmodus §7gesetzt§8.");

                                player.playSound(player.getLocation(), Sound.SPLASH, 100, 14);
                                player.sendMessage(PrefixManager.GAMEMODE + "§2" + arg.getName() + " §7wurde von dir in den §aKreativmodus §7gesetzt§8.");
                            } else if (args[0].equalsIgnoreCase("2")) {

                                arg.setGameMode(GameMode.ADVENTURE);
                                arg.playSound(player.getLocation(), Sound.SPLASH, 100, 14);
                                arg.sendMessage(PrefixManager.GAMEMODE + "§2" + player.getName() + " §7hat dich in den §aAbenteuermodus §7gesetzt§8.");

                                player.playSound(player.getLocation(), Sound.SPLASH, 100, 14);
                                player.sendMessage(PrefixManager.GAMEMODE + "§2" + arg.getName() + " §7wurde von dir in den §aAbenteuermodus §7gesetzt§8.");
                            } else if (args[0].equalsIgnoreCase("3")) {

                                arg.setGameMode(GameMode.SPECTATOR);
                                arg.playSound(player.getLocation(), Sound.SPLASH, 100, 14);
                                arg.sendMessage(PrefixManager.GAMEMODE + "§2" + player.getName() + " §7hat dich in den §aZuschauermodus §7gesetzt§8.");

                                player.playSound(player.getLocation(), Sound.SPLASH, 100, 14);
                                player.sendMessage(PrefixManager.GAMEMODE + "§2" + arg.getName() + " §7wurde von dir in den §aZuschauermodus §7gesetzt§8.");
                            } else {
                                player.sendMessage(PrefixManager.GAMEMODE + "§7Syntax§8: /§agm §8<§20§8, §21§8, §22§8, §23§8>");
                            }
                        } catch (NullPointerException e) {
                            player.sendMessage(PrefixManager.GAMEMODE + "§7Dieser Spieler ist nicht online§8.");
                        }
                    } else {
                        player.sendMessage(SkyDrugs.NOPERM);
                    }
                } else {
                    player.sendMessage(PrefixManager.GAMEMODE + "§7Syntax§8: /§agm §8<§20§8, §21§8, §22§8, §23§8>");
                }
            } else {
                player.sendMessage(SkyDrugs.NOPERM);
            }
        }
        return false;
    }
}

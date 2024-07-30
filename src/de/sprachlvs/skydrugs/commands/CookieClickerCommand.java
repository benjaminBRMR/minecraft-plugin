package de.sprachlvs.skydrugs.commands;

import de.sprachlvs.skydrugs.SkyDrugs;
import de.sprachlvs.skydrugs.apis.CookieAPI;
import de.sprachlvs.skydrugs.manager.PrefixManager;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class CookieClickerCommand implements CommandExecutor, TabExecutor {

    private void sendSyntax(final Player player) {
        CookieAPI.getHeader("§6§lCOOKIES");
        player.sendMessage(PrefixManager.COOKIECLICKER + "");
        player.sendMessage(PrefixManager.COOKIECLICKER + "§8/§ecookie §8<§6give§8>");
        player.sendMessage(PrefixManager.COOKIECLICKER + "§8/§ecookie §8<§6teleport§8>");
        player.sendMessage(PrefixManager.COOKIECLICKER + "§8/§ecookie §8<§6partikel§8> §8<§6an§8,§6aus§8>");
        player.sendMessage(PrefixManager.COOKIECLICKER + "§8/§ecookie §8<§6status§8> §8<§6an§8,§6aus§8>");
        player.sendMessage(PrefixManager.COOKIECLICKER + "§8/§ecookie §8<§6setcookies§8> §8<§6spieler§8> §8<§6anzahl§8>");
        player.sendMessage(PrefixManager.COOKIECLICKER + "");
        CookieAPI.getHeader("§6§lCOOKIES");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if(sender instanceof Player) {
            final Player player = (Player)sender;

            if(!player.isOp()) {
                player.sendMessage(SkyDrugs.NOPERM);
            } else {

                /*

                    /cookie setcolor
                    /cookie setcookies





                 */

                if(args.length > 0) {
                    if (args[0].equalsIgnoreCase("give")) {
                        new CookieAPI(player.getUniqueId()).giveClicker();
                    } else if(args[0].equalsIgnoreCase("particle") || args[0].equalsIgnoreCase("partikel")) {

                        if(args.length > 1) {

                            final String mode = args[1];

                            if (mode == null) {
                                sendSyntax(player);

                            } else {

                                if (mode.equalsIgnoreCase("an") || mode.equalsIgnoreCase("on")) {
                                    new CookieAPI(player.getUniqueId()).setParticles(true);
                                    player.sendMessage(PrefixManager.COOKIECLICKER + "§7Die §ePartikel §7wurden §aaktiviert§8.");

                                } else if (mode.equalsIgnoreCase("aus") || mode.equalsIgnoreCase("off")) {
                                    new CookieAPI(player.getUniqueId()).setParticles(false);
                                    player.sendMessage(PrefixManager.COOKIECLICKER + "§7Die §ePartikel §7wurden §cdeaktiviert§8.");
                                }
                            }
                        } else {
                            sendSyntax(player);
                        }


                    } else if(args[0].equalsIgnoreCase("status")) {

                        if(args.length > 1) {

                            final String mode = args[1];

                            if (mode == null) {
                                sendSyntax(player);

                            } else {

                                if (mode.equalsIgnoreCase("an") || mode.equalsIgnoreCase("on")) {
                                    new CookieAPI(player.getUniqueId()).setStatus(true);

                                    Bukkit.getOnlinePlayers().forEach(all -> all.sendMessage(PrefixManager.COOKIECLICKER + "§7Der §eCookieClicker §7wurde §e§lGLOBAL §aaktiviert§8."));

                                } else if (mode.equalsIgnoreCase("aus") || mode.equalsIgnoreCase("off")) {
                                    new CookieAPI(player.getUniqueId()).setStatus(false);

                                    Bukkit.getOnlinePlayers().forEach(all -> all.sendMessage(PrefixManager.COOKIECLICKER + "§7Der §eCookieClicker §7wurde §e§lGLOBAL §cdeaktiviert§8."));


                                }
                            }
                        }

                    } else if(args[0].equalsIgnoreCase("setcookies")) {

                        if (args.length > 2) {
                            final Player target = Bukkit.getPlayer(args[1]);


                            if (target == null) {
                                player.sendMessage(SkyDrugs.OFFLINE);
                            } else {


                                try {
                                    final int amount = Integer.parseInt(args[2]);

                                    if (args[2] != null && amount > 0) {

                                        new CookieAPI(target.getUniqueId()).setCookies(amount);
                                        player.sendMessage(PrefixManager.COOKIECLICKER + "§e" + target.getName() + "§8'§es §7Cookies wurden zu §e" + CookieAPI.getFormated(amount) + " §7gesetzt§8.");
                                        target.sendMessage(PrefixManager.COOKIECLICKER + "§eDeine §7Cookies wurden zu  §e" + CookieAPI.getFormated(amount) + " §6gesetzt§8.");

                                    } else {
                                        sendSyntax(player);
                                    }
                                } catch (NumberFormatException e) {
                                    player.sendMessage(PrefixManager.COOKIECLICKER + "§cBitte gebe eine gültige Anzahl an§8.");
                                }
                            }
                        }


                    } else if(args[0].equalsIgnoreCase("tp") || args[0].equalsIgnoreCase("teleport")) {
                        player.teleport(new CookieAPI(player.getUniqueId()).getLocation());
                        player.playSound(player.getLocation(), Sound.ENDERMAN_TELEPORT, 100, 18.4F);
                        player.sendMessage(PrefixManager.COOKIECLICKER + "§7Du wurdest zum §6CookieClicker §7teleportiert§8.");


                    } else {
                        sendSyntax(player);
                    }


                } else {
                    sendSyntax(player);
                }
            }
        }
        return false;
    }

    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        ArrayList<String> arguments = new ArrayList<>();
        if (!(sender.isOp())) return null;
        if (args.length == 1) {
            arguments.add("give");
            arguments.add("teleport");
            arguments.add("partikel");
            arguments.add("status");
            arguments.add("setcookies");
            return arguments;
        }
        return null;
    }
}


package de.sprachlvs.skydrugs.commands;

import de.sprachlvs.skydrugs.SkyDrugs;
import de.sprachlvs.skydrugs.apis.PerkAPI;
import de.sprachlvs.skydrugs.apis.PerkEnum;
import de.sprachlvs.skydrugs.apis.TextHoverAPI;
import de.sprachlvs.skydrugs.apis.stats.TokenAPI;
import de.sprachlvs.skydrugs.utils.SoundUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class BuyCommand implements CommandExecutor, TabExecutor {

    private void sendSyntax(final Player player) {
        SkyDrugs.getHeader("§c§lPERKS");
        player.sendMessage(SkyDrugs.PREFIX + "");
        player.sendMessage(SkyDrugs.PREFIX + "§8/§dbuy schnelligkeit2 §8<§5spieler§8>");
        player.sendMessage(SkyDrugs.PREFIX + "§8/§dbuy stärke1 §8<§5spieler§8>");
        player.sendMessage(SkyDrugs.PREFIX + "§8/§dbuy stärke2 §8<§5spieler§8>");
        player.sendMessage(SkyDrugs.PREFIX + "");
        SkyDrugs.getHeader("§c§lPERKS");
    }


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if(sender instanceof Player) {
            final Player player = (Player)sender;

            if(!player.isOp()) {
                player.sendMessage(SkyDrugs.NOPERM);
            } else {
                if(args.length > 1) {
                    if(args[0].equalsIgnoreCase("schnelligkeit2")) {

                        if(args.length > 1) {
                            final Player target = Bukkit.getPlayer(args[1]);

                            if (target == null) {
                                player.sendMessage(SkyDrugs.OFFLINE);
                            } else {

                                if(!new PerkAPI(target).hasPerk(PerkEnum.SPEEDZWEI)) {
                                    new PerkAPI(target).setPerk(PerkEnum.SPEEDZWEI, true);
                                    new PerkAPI(target).setPerkStatus(PerkEnum.SPEEDZWEI, true);
                                    player.sendMessage(SkyDrugs.PREFIX + "§5" + target.getName() + " §7besitzt nun das §cSchnelligkeit II Perk§8.");
                                    new PerkAPI(target).syncPerks();
                                    for (Player all : Bukkit.getOnlinePlayers()) {
                                        SoundUtils.playBigSuccessSound(all);
                                        new TokenAPI(all).addTokens(2000);

                                        all.sendMessage("");
                                        all.sendMessage(SkyDrugs.PREFIX + "§5" + target.getName() + " §7hat sich ein §dPerk §7gekauft§8.");
                                        all.sendMessage(SkyDrugs.PREFIX + "§7Als Danke bekommt jeder §e2§8.§e000 §7Tokens§8.");
                                        all.sendMessage("");
                                        TextHoverAPI.HoverURL(all, SkyDrugs.PREFIX + "§7Unser Shop§8: §c§nhttps://buy.skydrugs.de", "https://buy.skydrugs.de", "§8»│ §7Klicke§8,§7 um in den Shop zu gelangen§8.");
                                        all.sendMessage("");
                                    }
                                } else {
                                    player.sendMessage(SkyDrugs.PREFIX + "§5" + target.getName() + " §7besitzt bereits dieses §dPerk§8.");
                                }
                            }
                        } else {
                            sendSyntax(player);
                        }
                    } else if(args[0].equalsIgnoreCase("stärke1")) {

                        if(args.length > 1) {
                            final Player target = Bukkit.getPlayer(args[1]);

                            if (target == null) {
                                player.sendMessage(SkyDrugs.OFFLINE);
                            } else {

                                if(!new PerkAPI(target).hasPerk(PerkEnum.STAERKEEINS)) {
                                    new PerkAPI(target).setPerk(PerkEnum.STAERKEEINS, true);
                                    new PerkAPI(target).setPerkStatus(PerkEnum.STAERKEEINS, true);
                                    new PerkAPI(target).syncPerks();
                                    player.sendMessage(SkyDrugs.PREFIX + "§5" + target.getName() + " §7besitzt nun das §cStärke I Perk§8.");
                                    for (Player all : Bukkit.getOnlinePlayers()) {
                                        SoundUtils.playBigSuccessSound(all);
                                        new TokenAPI(all).addTokens(2000);

                                        all.sendMessage("");
                                        all.sendMessage(SkyDrugs.PREFIX + "§5" + target.getName() + " §7hat sich ein §dPerk §7gekauft§8.");
                                        all.sendMessage(SkyDrugs.PREFIX + "§7Als Danke bekommt jeder §e2§8.§e000 §7Tokens§8.");
                                        all.sendMessage("");
                                        TextHoverAPI.HoverURL(all, SkyDrugs.PREFIX + "§7Unser Shop§8: §c§nhttps://buy.skydrugs.de", "https://buy.skydrugs.de", "§8»│ §7Klicke§8,§7 um in den Shop zu gelangen§8.");
                                        all.sendMessage("");
                                    }
                                } else {
                                    player.sendMessage(SkyDrugs.PREFIX + "§5" + target.getName() + " §7besitzt bereits dieses §dPerk§8.");
                                }
                            }
                        } else {
                            sendSyntax(player);
                        }
                    } else if(args[0].equalsIgnoreCase("stärke2")) {
                        if(args.length > 1) {
                            final Player target = Bukkit.getPlayer(args[1]);

                            if (target == null) {
                                player.sendMessage(SkyDrugs.OFFLINE);
                            } else {

                                if(!new PerkAPI(target).hasPerk(PerkEnum.STAERKEZWEI)) {
                                    new PerkAPI(target).setPerk(PerkEnum.STAERKEZWEI, true);
                                    new PerkAPI(target).syncPerks();
                                    new PerkAPI(target).setPerkStatus(PerkEnum.STAERKEZWEI, true);
                                    player.sendMessage(SkyDrugs.PREFIX + "§5" + target.getName() + " §7besitzt nun das §cStärke II Perk§8.");
                                    for (Player all : Bukkit.getOnlinePlayers()) {
                                        SoundUtils.playBigSuccessSound(all);
                                        new TokenAPI(all).addTokens(2000);

                                        all.sendMessage("");
                                        all.sendMessage(SkyDrugs.PREFIX + "§5" + target.getName() + " §7hat sich ein §dPerk §7gekauft§8.");
                                        all.sendMessage(SkyDrugs.PREFIX + "§7Als Danke bekommt jeder §e2§8.§e000 §7Tokens§8.");
                                        all.sendMessage("");
                                        TextHoverAPI.HoverURL(all, SkyDrugs.PREFIX + "§7Unser Shop§8: §c§nhttps://buy.skydrugs.de", "https://buy.skydrugs.de", "§8»│ §7Klicke§8,§7 um in den Shop zu gelangen§8.");
                                        all.sendMessage("");
                                    }
                                } else {
                                    player.sendMessage(SkyDrugs.PREFIX + "§5" + target.getName() + " §7besitzt bereits dieses §dPerk§8.");
                                }
                            }
                        } else {
                            sendSyntax(player);
                        }
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
            arguments.add("schnelligkeit2");
            arguments.add("stärke1");
            arguments.add("stärke2");
            return arguments;
        }
        return null;
    }
}


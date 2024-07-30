package de.sprachlvs.skydrugs.commands;

import de.sprachlvs.skydrugs.SkyDrugs;
import de.sprachlvs.skydrugs.utils.UUIDFetcher;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class TeamchatCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if(sender instanceof Player) {

            final Player player = (Player)sender;


            if (PermissionsEx.getUser(player).inGroup("Content") || PermissionsEx.getUser(player).inGroup("Supporter") || PermissionsEx.getUser(player).inGroup("Moderator") || PermissionsEx.getUser(player).inGroup("SrModerator") || PermissionsEx.getUser(player).inGroup("Developer") || PermissionsEx.getUser(player).inGroup("Admin") || PermissionsEx.getUser(player).inGroup("Owner")) {
                if(args.length >= 1) {
                    String m = "";

                    for (int i = 0; i < args.length; ++i) {
                        m = m + " " + args[i];
                    }

                    for (Player all : Bukkit.getOnlinePlayers()) {
                        if (PermissionsEx.getUser(all).inGroup("Content") || PermissionsEx.getUser(all).inGroup("Supporter") || PermissionsEx.getUser(all).inGroup("Moderator") || PermissionsEx.getUser(all).inGroup("SrModerator") || PermissionsEx.getUser(all).inGroup("Developer") || PermissionsEx.getUser(all).inGroup("Admin") || PermissionsEx.getUser(all).inGroup("Owner")) {
                            if (UUIDFetcher.getUUID(player.getName()).toString().equalsIgnoreCase("bc9db661-f101-4350-80e9-8e44f6263fde") || UUIDFetcher.getUUID(player.getName()).toString().equalsIgnoreCase("625d8ec2-c141-457c-b74a-4c6ba2cbdb31")) {
                                all.sendMessage(SkyDrugs.TEAMCHAT_PREFIX + "§f" + player.getName() + " §8»§f§l" + m);
                                all.playSound(all.getLocation(), Sound.SUCCESSFUL_HIT, 5, 18.4F);
                                continue;
                            }
                            all.sendMessage(SkyDrugs.TEAMCHAT_PREFIX + "§7" + player.getName() + " §8»§d" + m);
                            all.playSound(all.getLocation(), Sound.WOOD_CLICK, 5, 18.4F);
                        }
                    }
                } else {
                    player.sendMessage(SkyDrugs.TEAMCHAT_PREFIX + "§7Syntax§8: /§dtc §8<§7nachricht§8>");
                }
            } else {
                player.sendMessage(SkyDrugs.NOPERM);
            }
        }
        return false;
    }
}

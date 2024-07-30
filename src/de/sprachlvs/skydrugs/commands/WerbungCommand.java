package de.sprachlvs.skydrugs.commands;

import de.sprachlvs.skydrugs.SkyDrugs;
import de.sprachlvs.skydrugs.apis.CookieAPI;
import de.sprachlvs.skydrugs.apis.CooldownAPI;
import de.sprachlvs.skydrugs.manager.PrefixManager;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class WerbungCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if(sender instanceof Player) {
            final Player player = (Player)sender;

            if(PermissionsEx.getUser(player).inGroup("Ephedra") || PermissionsEx.getUser(player).inGroup("Salvia") || PermissionsEx.getUser(player).inGroup("Booster") || PermissionsEx.getUser(player).inGroup("Creator") || PermissionsEx.getUser(player).inGroup("Content") || PermissionsEx.getUser(player).inGroup("Supporter") || PermissionsEx.getUser(player).inGroup("Moderator") || PermissionsEx.getUser(player).inGroup("SrModerator") || PermissionsEx.getUser(player).inGroup("Developer") || PermissionsEx.getUser(player).inGroup("Admin") || PermissionsEx.getUser(player).inGroup("Owner")) {

                if(CooldownAPI.getCooldown(player, "werbung_cmd") == 0) {
                    if(args.length >= 1) {
                        String m = "";

                        for (int i = 0; i < args.length; ++i) {

                            m = m + " " + args[i].replaceAll("&", "§");
                        }


                        for(Player all : Bukkit.getOnlinePlayers()) {
                            all.sendMessage(CookieAPI.getHeader("§b§lWERBUNG"));
                            all.sendMessage("");
                            all.sendMessage(PrefixManager.WERBUNG + " §7Werbung von §b" + player.getName());
                            all.sendMessage(PrefixManager.WERBUNG + "§7" + m.replaceAll("§l", "").replaceAll("§m", "").replaceAll("§n", "").replaceAll("§o", "").replaceAll("§k", "").replaceAll("§r", ""));
                            all.sendMessage("");
                            all.sendMessage(CookieAPI.getHeader("§b§lWERBUNG"));
                            all.playSound(all.getLocation(), Sound.ITEM_BREAK, 10, 18.4F);
                        }
                        CooldownAPI.addCooldown(player, "werbung_cmd", 21600);
                    } else {
                        player.sendMessage(PrefixManager.WERBUNG + "§7Syntax§8: /§bwerbung §8<§7nachricht§8>");
                    }
                } else {
                    player.sendMessage(PrefixManager.WERBUNG + "§cDieser Befehl hat einen Cooldown§8.");
                    player.sendMessage(PrefixManager.WERBUNG + "§7Verfügbar in§8: §b" + CooldownAPI.getStunden(CooldownAPI.getCooldown(player, "werbung_cmd")));
                }
            } else {
                player.sendMessage(SkyDrugs.NOPERM);
            }
        }
        return false;
    }
}

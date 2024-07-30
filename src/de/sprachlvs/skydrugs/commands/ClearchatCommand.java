package de.sprachlvs.skydrugs.commands;

import de.sprachlvs.skydrugs.SkyDrugs;
import de.sprachlvs.skydrugs.apis.TitleAPI;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class ClearchatCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if (sender instanceof Player) {
            final Player player = (Player) sender;

            if (PermissionsEx.getUser(player).inGroup("Opiat") || PermissionsEx.getUser(player).inGroup("Ephedra") || PermissionsEx.getUser(player).inGroup("Salvia") || PermissionsEx.getUser(player).inGroup("Booster") || PermissionsEx.getUser(player).inGroup("Creator") || PermissionsEx.getUser(player).inGroup("Content") || PermissionsEx.getUser(player).inGroup("Supporter")) {

                for (int i = 0; i < 100; i++) {
                    player.sendMessage("");
                }

                player.playSound(player.getLocation(), Sound.NOTE_PLING, 100, 14);
                player.sendMessage(SkyDrugs.PREFIX + "§7Du hast deinen Chat erfolgreich geleert§8.");
                return true;

            } else if (PermissionsEx.getUser(player).inGroup("Moderator") || PermissionsEx.getUser(player).inGroup("SrModerator") || PermissionsEx.getUser(player).inGroup("Developer") || PermissionsEx.getUser(player).inGroup("Admin") || PermissionsEx.getUser(player).inGroup("Owner")){

                Bukkit.getOnlinePlayers().forEach(all -> {
                    all.playSound(all.getLocation(), Sound.NOTE_PLING, 100, 14);
                    if (PermissionsEx.getUser(all).inGroup("default") || PermissionsEx.getUser(all).inGroup("Kavain") || PermissionsEx.getUser(all).inGroup("Valium") || PermissionsEx.getUser(all).inGroup("Opiat") || PermissionsEx.getUser(all).inGroup("Ephedra") || PermissionsEx.getUser(all).inGroup("Salvia") || PermissionsEx.getUser(all).inGroup("Booster") || PermissionsEx.getUser(all).inGroup("Creator")) {
                        for (int i = 0; i < 100; i++) {
                            all.sendMessage("");
                        }
                    } else {
                        Bukkit.getOnlinePlayers().forEach(team -> {
                            if (PermissionsEx.getUser(team).inGroup("Content") || PermissionsEx.getUser(team).inGroup("Supporter") || PermissionsEx.getUser(team).inGroup("Moderator") || PermissionsEx.getUser(team).inGroup("SrModerator") || PermissionsEx.getUser(team).inGroup("Developer") || PermissionsEx.getUser(team).inGroup("Admin") || PermissionsEx.getUser(team).inGroup("Owner")) {
                                TitleAPI.sendActionbar(team, SkyDrugs.PREFIX + "Da du ein §cTeammitglied§7 bist§8, §7ist der Chat noch §asichtbar§8!");
                            }
                        });
                    }
                    all.sendMessage(SkyDrugs.PREFIX + "Der Spieler §d" + player.getName() + " §7hat den Chat geleert§8!");
                });
            } else {
                player.sendMessage(SkyDrugs.NOPERM);
            }
        } else {
            sender.sendMessage(SkyDrugs.PREFIX + "§7Du musst ein Spieler sein§8!");
        }
        return false;
    }
}

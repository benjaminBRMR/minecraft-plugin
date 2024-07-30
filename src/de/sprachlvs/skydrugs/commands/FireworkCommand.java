package de.sprachlvs.skydrugs.commands;

import de.sprachlvs.skydrugs.SkyDrugs;
import de.sprachlvs.skydrugs.apis.CooldownAPI;
import de.sprachlvs.skydrugs.apis.FireworkAPI;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class FireworkCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if (sender instanceof Player) {
            final Player player = (Player) sender;
            Location loc = player.getLocation();
            if (PermissionsEx.getUser(player).inGroup("Ephedra") || PermissionsEx.getUser(player).inGroup("Salvia") || PermissionsEx.getUser(player).inGroup("Booster") || PermissionsEx.getUser(player).inGroup("Creator") || PermissionsEx.getUser(player).inGroup("Content") || PermissionsEx.getUser(player).inGroup("Supporter") || PermissionsEx.getUser(player).inGroup("Moderator") || PermissionsEx.getUser(player).inGroup("SrModerator") || PermissionsEx.getUser(player).inGroup("Developer") || PermissionsEx.getUser(player).inGroup("Admin") || PermissionsEx.getUser(player).inGroup("Owner")) {
                if (PermissionsEx.getUser(player).inGroup("Admin") || PermissionsEx.getUser(player).inGroup("Owner")) {

                    FireworkAPI.spawnRandomFirework(loc);
                    player.sendMessage(SkyDrugs.PREFIX + "§7Du hast ein §dFeuerwerk §7gespawnt§8.");
                    return true;
                }
               if (CooldownAPI.getCooldown(player, "firework_cmd") == 0) {

                    CooldownAPI.addCooldown(player, "firework_cmd", 60);
                    FireworkAPI.spawnRandomFirework(loc);
                    player.sendMessage(SkyDrugs.PREFIX + "§7Du hast ein §dFeuerwerk §7gespawnt§8.");

                } else {
                    player.sendMessage(SkyDrugs.PREFIX + "§cDieser Befehl hat einen Cooldown§8.");
                    player.sendMessage(SkyDrugs.PREFIX + "§7Verfügbar in§8: §d" + CooldownAPI.getSekunden(CooldownAPI.getCooldown(player, "firework_cmd")));
                }

            } else {
                player.sendMessage(SkyDrugs.NOPERM);
            }
        } else {
            sender.sendMessage(SkyDrugs.PREFIX + "§7Du musst ein Spieler sein§8!");
        }
        return false;
    }
}

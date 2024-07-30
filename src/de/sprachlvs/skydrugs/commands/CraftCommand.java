package de.sprachlvs.skydrugs.commands;

import de.sprachlvs.skydrugs.SkyDrugs;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class CraftCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if (sender instanceof Player) {
            final Player player = (Player) sender;
            if (PermissionsEx.getUser(player).inGroup("Kavain") || PermissionsEx.getUser(player).inGroup("Valium") || PermissionsEx.getUser(player).inGroup("Opiat") || PermissionsEx.getUser(player).inGroup("Ephedra") || PermissionsEx.getUser(player).inGroup("Salvia") || PermissionsEx.getUser(player).inGroup("Booster") || PermissionsEx.getUser(player).inGroup("Creator") || PermissionsEx.getUser(player).inGroup("Content") || PermissionsEx.getUser(player).inGroup("Supporter") || PermissionsEx.getUser(player).inGroup("Moderator") || PermissionsEx.getUser(player).inGroup("SrModerator") || PermissionsEx.getUser(player).inGroup("Developer") || PermissionsEx.getUser(player).inGroup("Admin") || PermissionsEx.getUser(player).inGroup("Owner")) {

                player.openWorkbench(player.getLocation(), true);
                player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 100, 14);
                player.sendMessage(SkyDrugs.PREFIX + "§7Die §5Werkbank §7wurde geöffnet§8.");

            } else {
                player.sendMessage(SkyDrugs.NOPERM);
            }
        } else {
            sender.sendMessage(SkyDrugs.PREFIX + "§7Du musst ein Spieler sein§8!");
        }
        return false;
    }
}

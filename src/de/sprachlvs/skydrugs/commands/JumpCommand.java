package de.sprachlvs.skydrugs.commands;

import de.sprachlvs.skydrugs.SkyDrugs;
import de.sprachlvs.skydrugs.manager.PrefixManager;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.util.Vector;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class JumpCommand implements CommandExecutor, Listener {






    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if(sender instanceof Player) {
            final Player player = (Player)sender;

            if (PermissionsEx.getUser(player).inGroup("Booster") || PermissionsEx.getUser(player).inGroup("Creator") || PermissionsEx.getUser(player).inGroup("Content") || PermissionsEx.getUser(player).inGroup("Supporter") || PermissionsEx.getUser(player).inGroup("Moderator") || PermissionsEx.getUser(player).inGroup("SrModerator") || PermissionsEx.getUser(player).inGroup("Developer") || PermissionsEx.getUser(player).inGroup("Admin") || PermissionsEx.getUser(player).inGroup("Owner")) {
                if(player.getLocation().subtract(0, 1, 0).getBlock().getType() != Material.AIR) { // hat peso gemacht fixx mal xd peso ist manchmal echt dumm
                    //getBlock ist der, wo der player DRINNESTEHT und nicht DRAUF


                    player.setVelocity(new Vector(0, +5, 0));
                    player.sendMessage(PrefixManager.JUMP + "§7Du wurdest in die Luft geschleudert§8.");
                    player.playSound(player.getLocation(), Sound.WITHER_SHOOT, 100, 18.4F);


                } else {
                    player.sendMessage(PrefixManager.JUMP + "§7Diesen Befehl kannst du nur am Boden ausführen§8.");
                }
            } else {
                player.sendMessage(SkyDrugs.NOPERM);
            }
        }
        return false;
    }
}


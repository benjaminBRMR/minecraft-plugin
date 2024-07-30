package de.sprachlvs.skydrugs.commands;

import de.sprachlvs.skydrugs.manager.PrefixManager;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import ru.tehkode.permissions.bukkit.PermissionsEx;

import java.util.ArrayList;
import java.util.List;

public class NearCommand implements CommandExecutor {

    public int getDistance(Player one, Player two) {
        return (int)one.getLocation().distance(two.getLocation());
    }

    public static List<Player> near(Player p) {
        ArrayList<Player> local = new ArrayList<Player>();
        Location loc = p.getLocation();
        for (Entity e : p.getNearbyEntities(200.0, 256.0, 200.0)) {
            if (!(e instanceof Player)) continue;
            if (e.getName().contains("§")) {

            } else {
                local.add((Player) e);
            }
        }
        return local;
    }

    private void sendNearMessage(Player p, Boolean isEmpty) {
        if (!isEmpty) {
            p.sendMessage(PrefixManager.NEAR + "§7Es befinden sich §e" + near(p).size() + " Spieler§7 in deiner Nähe§8.");
            p.playSound(p.getLocation(), Sound.NOTE_PIANO, 100, 18.4F);
            for (Player pl : near(p)) {
                p.sendMessage(PrefixManager.NEAR+ "§8» §6" + pl.getDisplayName());
            }
        } else {
            p.sendMessage(PrefixManager.NEAR + "§cEs befindet sich derzeit kein Spieler in deiner Nähe8.");
            p.playSound(p.getLocation(), Sound.ANVIL_LAND, 100, 18.4F);
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if(sender instanceof Player) {
            final Player player = (Player)sender;

            if (PermissionsEx.getUser(player).inGroup("Booster") || PermissionsEx.getUser(player).inGroup("Creator") || PermissionsEx.getUser(player).inGroup("Content") || PermissionsEx.getUser(player).inGroup("Supporter") || PermissionsEx.getUser(player).inGroup("Moderator") || PermissionsEx.getUser(player).inGroup("SrModerator") || PermissionsEx.getUser(player).inGroup("Developer") || PermissionsEx.getUser(player).inGroup("Admin") || PermissionsEx.getUser(player).inGroup("Owner")) {

                if (near(player).isEmpty()) {
                    sendNearMessage(player, true);
                } else {
                    sendNearMessage(player, false);
                }
            }
        }
        return false;
    }
}


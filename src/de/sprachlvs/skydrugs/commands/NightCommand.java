package de.sprachlvs.skydrugs.commands;

import de.sprachlvs.skydrugs.SkyDrugs;
import de.sprachlvs.skydrugs.apis.CooldownAPI;
import de.sprachlvs.skydrugs.manager.PrefixManager;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class NightCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if(sender instanceof Player) {
            final Player player = (Player)sender;

            if(PermissionsEx.getUser(player).inGroup("Valium") || PermissionsEx.getUser(player).inGroup("Opiat") || PermissionsEx.getUser(player).inGroup("Ephedra") || PermissionsEx.getUser(player).inGroup("Salvia") || PermissionsEx.getUser(player).inGroup("Booster") || PermissionsEx.getUser(player).inGroup("Creator") || PermissionsEx.getUser(player).inGroup("Content") || PermissionsEx.getUser(player).inGroup("Supporter") || PermissionsEx.getUser(player).inGroup("Moderator") || PermissionsEx.getUser(player).inGroup("SrModerator") || PermissionsEx.getUser(player).inGroup("Developer") || PermissionsEx.getUser(player).inGroup("Admin") || PermissionsEx.getUser(player).inGroup("Owner")) {
                if (CooldownAPI.getCooldown(player, "night_cmd") == 0) {

                    for(World all : Bukkit.getWorlds()) {
                        if(!all.getName().equalsIgnoreCase("spawnn")) {
                            all.setFullTime(15000);
                        } else {
                            player.sendMessage(PrefixManager.TIME + "§7Diesen Befehl kannst du hier nicht§8.");
                            return true;
                        }
                    }
                    Bukkit.getOnlinePlayers().forEach(all -> all.playSound(all.getLocation(), Sound.SUCCESSFUL_HIT, 100, 18.4F));
                    Bukkit.broadcastMessage(PrefixManager.TIME + "§2" + player.getName() + " §7hat die Zeit auf §2Nacht §7gestellt§8.");
                    CooldownAPI.addCooldown(player, "night_cmd", 900);

                } else {
                    player.sendMessage(PrefixManager.TIME + "§cDieser Befehl hat einen Cooldown§8.");
                    player.sendMessage(PrefixManager.TIME + "§7Verfügbar in§8: §e" + CooldownAPI.getMinuten(CooldownAPI.getCooldown(player, "night_cmd")));
                }
            } else {
                player.sendMessage(SkyDrugs.NOPERM);
            }

        }
        return false;
    }
}

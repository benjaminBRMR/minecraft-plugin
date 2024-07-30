package de.sprachlvs.skydrugs.commands;

import de.sprachlvs.skydrugs.SkyDrugs;
import de.sprachlvs.skydrugs.manager.PrefixManager;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class ClearCommand implements CommandExecutor {

    private boolean checkEmptyInventory(final Player player) {
        for(ItemStack it : player.getInventory().getContents()) {
            if(it != null) return false;
        }
        return player.getInventory().firstEmpty() != -1;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if(sender instanceof Player) {

            final Player player = (Player)sender;

            if(PermissionsEx.getUser(player).inGroup("Valium") || PermissionsEx.getUser(player).inGroup("Opiat") || PermissionsEx.getUser(player).inGroup("Ephedra") || PermissionsEx.getUser(player).inGroup("Salvia") || PermissionsEx.getUser(player).inGroup("Booster") || PermissionsEx.getUser(player).inGroup("Creator") || PermissionsEx.getUser(player).inGroup("Content") || PermissionsEx.getUser(player).inGroup("Supporter") || PermissionsEx.getUser(player).inGroup("Moderator") || PermissionsEx.getUser(player).inGroup("SrModerator") || PermissionsEx.getUser(player).inGroup("Developer") || PermissionsEx.getUser(player).inGroup("Admin") || PermissionsEx.getUser(player).inGroup("Owner")) {

                if(args.length <= 1) {
                    if (checkEmptyInventory(player)) {
                        player.sendMessage(PrefixManager.CLEAR + "§cEs konnten keine Gegenstände gefunden werden§8.");
                    } else {

                        player.getInventory().clear();
                        player.getInventory().setArmorContents(null);
                        player.sendMessage(PrefixManager.CLEAR + "§7Alle Gegenstände wurden entfernt§8.");
                        player.playSound(player.getLocation(), Sound.ENDERDRAGON_WINGS, 100, 18.4F);
                    }
                } else {

                    if(PermissionsEx.getUser(player).inGroup("Admin") || PermissionsEx.getUser(player).inGroup("Owner")) {

                        final Player target = Bukkit.getPlayer(args[0]);

                        if(target == null) {
                            player.sendMessage(SkyDrugs.OFFLINE);
                        } else {
                            if(checkEmptyInventory(target)) {
                                player.sendMessage(PrefixManager.CLEAR + "§c" + target.getName() + " §7hat keine Gegenstände im Inventar§8.");
                            } else {
                               target.getInventory().clear();
                               target.getInventory().setArmorContents(null);
                               target.sendMessage(PrefixManager.CLEAR + "§7Alle Gegenstände wurden von §f" + player.getName() + " §7entfernt§8.");
                               target.playSound(target.getLocation(), Sound.ENDERDRAGON_WINGS, 100, 18.4F);

                               player.sendMessage(PrefixManager.CLEAR + "§7Alle Gegenstände von §f" + target.getName() + " §7wurden entfernt§8.");
                               player.playSound(player.getLocation(), Sound.ENDERDRAGON_WINGS, 100, 18.4F);
                            }
                        }

                    } else {
                        player.sendMessage(SkyDrugs.NOPERM);
                    }
                }
            } else {
                player.sendMessage(SkyDrugs.NOPERM);
            }
        }
        return false;
    }
}


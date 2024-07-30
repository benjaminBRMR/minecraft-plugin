package de.sprachlvs.skydrugs.commands;

import de.sprachlvs.skydrugs.manager.ItemManager;
import de.sprachlvs.skydrugs.manager.PrefixManager;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class HatCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if(sender instanceof Player) {
            final Player player = (Player) sender;
            final ItemStack item = player.getItemInHand();
            final ItemStack headitem = new ItemManager(item.getType()).setAnzahl(1).setData(item.getData().getData()).build();

            if (PermissionsEx.getUser(player).inGroup("Valium") || PermissionsEx.getUser(player).inGroup("Opiat") || PermissionsEx.getUser(player).inGroup("Ephedra") || PermissionsEx.getUser(player).inGroup("Salvia") || PermissionsEx.getUser(player).inGroup("Booster") || PermissionsEx.getUser(player).inGroup("Creator") || PermissionsEx.getUser(player).inGroup("Content") || PermissionsEx.getUser(player).inGroup("Supporter") || PermissionsEx.getUser(player).inGroup("Moderator") || PermissionsEx.getUser(player).inGroup("SrModerator") || PermissionsEx.getUser(player).inGroup("Developer") || PermissionsEx.getUser(player).inGroup("Admin") || PermissionsEx.getUser(player).inGroup("Owner")) {
                if(item != null && item.getType() != Material.AIR && !item.getType().name().contains("SWORD") && !item.getType().equals(Material.POTION)) {
                    player.getInventory().setHelmet(headitem);
                    player.sendMessage(PrefixManager.HAT + "§7Du hast deinen neuen Hut aufgesetzt§8.");
                    player.playSound(player.getLocation(), Sound.HORSE_ARMOR, 100, 18.4F);
                    if (player.getItemInHand().getAmount() > 1) {
                        player.getItemInHand().setAmount(player.getItemInHand().getAmount() - 1);
                    } else {
                        player.setItemInHand(new ItemStack(Material.AIR));
                    }

                } else {
                    player.sendMessage(PrefixManager.HAT + "§cBitte halte ein gültiges Item in deiner Hand§8.");
                }

            }
        }
        return false;
    }
}


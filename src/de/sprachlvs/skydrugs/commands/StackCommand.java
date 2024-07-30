package de.sprachlvs.skydrugs.commands;

import de.sprachlvs.skydrugs.SkyDrugs;
import de.sprachlvs.skydrugs.manager.PrefixManager;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class StackCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if(sender instanceof Player) {

            final Player player = (Player)sender;

            if(PermissionsEx.getUser(player).inGroup("Opiat") || PermissionsEx.getUser(player).inGroup("Ephedra") || PermissionsEx.getUser(player).inGroup("Salvia") || PermissionsEx.getUser(player).inGroup("Booster") || PermissionsEx.getUser(player).inGroup("Creator") || PermissionsEx.getUser(player).inGroup("Content") || PermissionsEx.getUser(player).inGroup("Supporter") || PermissionsEx.getUser(player).inGroup("Moderator") || PermissionsEx.getUser(player).inGroup("SrModerator") || PermissionsEx.getUser(player).inGroup("Developer") || PermissionsEx.getUser(player).inGroup("Admin") || PermissionsEx.getUser(player).inGroup("Owner")) {
                ItemStack[] contents = player.getInventory().getContents();
                int changed = 0;

                for (int i = 0; i < contents.length; ++i) {
                    ItemStack current = contents[i];
                    if (current != null && current.getType() != Material.AIR && current.getType() != Material.POTION && current.getAmount() > 0 && current.getAmount() < 64) {
                        int needed = 64 - current.getAmount();

                        for (int i2 = i + 1; i2 < contents.length; ++i2) {
                            ItemStack nextCurrent = contents[i2];
                            if (nextCurrent != null && nextCurrent.getType() != Material.AIR && nextCurrent.getType() != Material.POTION && nextCurrent.getAmount() > 0 && current.getType() == nextCurrent.getType() && current.getDurability() == nextCurrent.getDurability() && (current.getItemMeta() == null && nextCurrent.getItemMeta() == null || current.getItemMeta() != null && current.getItemMeta().equals(nextCurrent.getItemMeta()))) {
                                if (nextCurrent.getAmount() > needed) {
                                    current.setAmount(64);
                                    nextCurrent.setAmount(nextCurrent.getAmount() - needed);
                                    break;
                                }

                                contents[i2] = null;
                                current.setAmount(current.getAmount() + nextCurrent.getAmount());
                                needed = 64 - current.getAmount();
                                ++changed;
                            }
                        }
                    }
                }

                if (changed > 0) {
                    player.getInventory().setContents(contents);
                    player.sendMessage(PrefixManager.STACK + "§7Alle deine Items wurden gestackt§8.");
                    player.playSound(player.getLocation(), Sound.LAVA_POP, 0.5F, 7.5F);
                } else {
                    player.sendMessage(PrefixManager.STACK + "§cEs konnten keine Items gestackt werden§8.");
                }
            } else {
                player.sendMessage(SkyDrugs.NOPERM);
            }
        }
        return false;
    }
}


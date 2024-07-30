package de.sprachlvs.skydrugs.commands;

import de.sprachlvs.skydrugs.SkyDrugs;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class RenameCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if (sender instanceof Player) {
            final Player player = (Player) sender;
            if (PermissionsEx.getUser(player).inGroup("Owner") || PermissionsEx.getUser(player).inGroup("Admin")) {
                if(args.length < 1) {
                    player.sendMessage(SkyDrugs.PREFIX + "§7Syntax§8: /§drename §8<§5name§8>");
                } else {
                    if (player.getItemInHand() != null && player.getItemInHand().getType() != Material.AIR) {

                        StringBuilder sb = new StringBuilder();
                        for (int i = 0; i < args.length; i++) {
                            sb.append(args[i]).append(" ");
                        }

                        String name = args[0];
                        for (int j = 1; j < args.length; j++)
                            name = String.valueOf(name) + " " + args[j];
                        name = ChatColor.translateAlternateColorCodes('&', name);
                        ItemStack i = player.getItemInHand();
                        ItemMeta im = i.getItemMeta();
                        im.setDisplayName(name);
                        i.setItemMeta(im);
                        player.updateInventory();

                        player.playSound(player.getLocation(), Sound.ANVIL_USE, 100, 14);
                        player.sendMessage(SkyDrugs.PREFIX + "§7Dein Item wurde erfolgreich unbenannt§8.");
                        player.sendMessage(SkyDrugs.PREFIX + "§7Neuer Name§8: §r" + name);
                    } else {
                        player.sendMessage(SkyDrugs.PREFIX + "§7Bitte halte ein Item in deiner Hand§8.");
                    }
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

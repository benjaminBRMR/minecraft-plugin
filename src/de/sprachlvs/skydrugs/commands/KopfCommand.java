package de.sprachlvs.skydrugs.commands;

import de.sprachlvs.skydrugs.SkyDrugs;
import de.sprachlvs.skydrugs.apis.CooldownAPI;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class KopfCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if (args.length == 1) {
            if (sender instanceof Player) {
                final Player player = (Player) sender;
                if (PermissionsEx.getUser(player).inGroup("Valium") || PermissionsEx.getUser(player).inGroup("Opiat") || PermissionsEx.getUser(player).inGroup("Ephedra") || PermissionsEx.getUser(player).inGroup("Salvia") || PermissionsEx.getUser(player).inGroup("Booster") || PermissionsEx.getUser(player).inGroup("Creator") || PermissionsEx.getUser(player).inGroup("Content") || PermissionsEx.getUser(player).inGroup("Supporter") || PermissionsEx.getUser(player).inGroup("Moderator") || PermissionsEx.getUser(player).inGroup("SrModerator") || PermissionsEx.getUser(player).inGroup("Developer") || PermissionsEx.getUser(player).inGroup("Admin") || PermissionsEx.getUser(player).inGroup("Owner")) {
                    if (PermissionsEx.getUser(player).inGroup("Admin") || PermissionsEx.getUser(player).inGroup("Owner")) {

                        player.getInventory().addItem(getKopf(args[0]));
                        player.sendMessage(SkyDrugs.PREFIX + "§7Du hast den Kopf von §d" + args[0] + " §7erhalten§8.");
                        player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 100, 14);
                    } else {
                        if (CooldownAPI.getCooldown(player, "kopf_cmd") == 0) {
                            CooldownAPI.addCooldown(player, "kopf_cmd", 21600);

                            player.getInventory().addItem(getKopf(args[0]));
                            player.sendMessage(SkyDrugs.PREFIX + "§7Du hast den Kopf von §d" + args[0] + " §7erhalten§8.");
                            player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 100, 14);
                        } else {
                            player.sendMessage(SkyDrugs.PREFIX + "§cDieser Befehl hat einen Cooldown§8.");
                            player.sendMessage(SkyDrugs.PREFIX + "§7Verfügbar in§8: §d" + CooldownAPI.getStunden(CooldownAPI.getCooldown(player, "kopf_cmd")));
                        }
                    }
                } else {
                    player.sendMessage(SkyDrugs.NOPERM);
                }
            } else {
                sender.sendMessage(SkyDrugs.PREFIX + "§7Du musst ein Spieler sein§8!");
            }
        } else {
            sender.sendMessage(SkyDrugs.PREFIX + "§7Syntax§8: /§dkopf §8<§5spieler§8>");
        }
        return false;
    }

    private ItemStack getKopf(String pName) {
        ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        SkullMeta itemmeta = (SkullMeta) item.getItemMeta();
        itemmeta.setOwner(pName);
        itemmeta.setDisplayName("§8▰§7▱ §d" + pName + "§8'§ds §7Kopf");
        item.setItemMeta(itemmeta);
        return item;
    }
}

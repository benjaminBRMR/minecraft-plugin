package de.sprachlvs.skydrugs.commands;

import de.sprachlvs.skydrugs.apis.CooldownAPI;
import de.sprachlvs.skydrugs.manager.PrefixManager;
import de.sprachlvs.skydrugs.manager.SignManager;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class SignCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {


        if(sender instanceof Player) {

            final Player player = (Player) sender;
            final ItemStack item = player.getItemInHand();
            final SignManager signManager = new SignManager(player.getItemInHand());

            if (PermissionsEx.getUser(player).inGroup("Ephedra") || PermissionsEx.getUser(player).inGroup("Salvia") || PermissionsEx.getUser(player).inGroup("Booster") || PermissionsEx.getUser(player).inGroup("Creator") || PermissionsEx.getUser(player).inGroup("Content") || PermissionsEx.getUser(player).inGroup("Supporter") || PermissionsEx.getUser(player).inGroup("Moderator") || PermissionsEx.getUser(player).inGroup("SrModerator") || PermissionsEx.getUser(player).inGroup("Developer") || PermissionsEx.getUser(player).inGroup("Admin") || PermissionsEx.getUser(player).inGroup("Owner")) {
                if (args.length >= 1) {
                    if (player.getItemInHand().getType() != Material.AIR) {

                        if (args[0].equalsIgnoreCase("clear") || args[0].equalsIgnoreCase("del")) {
                            if (signManager.isSigned()) {
                                player.setItemInHand(signManager.unSign());
                                player.sendMessage(PrefixManager.SIGN + "§7cDie Signatur deines Items wurde entfernt§8.");
                            } else {
                                player.sendMessage(PrefixManager.SIGN + "§cDieses Item besitzt keine Signatur§8.");
                            }
                        } else {
                            if(CooldownAPI.getCooldown(player, "sign_cmd") == 0) {
                                StringBuilder stringBuilder = new StringBuilder();
                                for (String arg : args)
                                    stringBuilder.append(arg).append(" ");
                                if (!signManager.isSigned()) {
                                    player.setItemInHand(signManager.sign(player.getName(), stringBuilder.toString()));
                                    player.sendMessage(PrefixManager.SIGN + "§7Dein Item wurde §aerfolgreich §7signiert§8.");
                                    CooldownAPI.addCooldown(player, "sign_cmd", 300);
                                } else {
                                    player.sendMessage(PrefixManager.SIGN + "§cDieses Item besitzt bereits eine Signatur§8.");
                                }
                            } else {
                                player.sendMessage(PrefixManager.SIGN + "§cDieser Befehl hat einen Cooldown§8.");
                                player.sendMessage(PrefixManager.SIGN + "§7Verfügbar in§8: §e" + CooldownAPI.getMinuten(CooldownAPI.getCooldown(player, "sign_cmd")));
                            }
                        }
                    } else {
                        player.sendMessage(PrefixManager.SIGN + "§cBitte halte ein gültiges Item in deiner Hand§8.");
                    }
                } else {
                    player.sendMessage(PrefixManager.SIGN + "§7Syntax§8: /§bsign §8<§7nachricht§8>");
                    player.sendMessage(PrefixManager.SIGN + "§7Syntax§8: /§bsign clear");
                }
            }
        }
        return false;
    }
}


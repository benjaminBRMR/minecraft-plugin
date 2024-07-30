package de.sprachlvs.skydrugs.commands;

import de.sprachlvs.skydrugs.SkyDrugs;
import de.sprachlvs.skydrugs.manager.ItemManager;
import de.sprachlvs.skydrugs.manager.PrefixManager;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class GutscheinCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if(sender instanceof Player) {
            final Player player = (Player)sender;

            if(PermissionsEx.getUser(player).inGroup("Admin") || PermissionsEx.getUser(player).inGroup("Owner")) {

                if(args.length > 0) {

                    if (args[0].equalsIgnoreCase("fly")) {

                        if (args[1] == null) {
                            player.sendMessage(PrefixManager.GUTSCHEIN + "§7Syntax§8: /§3gutschein §8<§7fly§8> §8<§7min.§8>");
                        } else {
                            try {
                                final int minuten = Integer.parseInt(args[1]);

                                ItemStack gutschein = new ItemManager(Material.PAPER).setName("§8»│ §a§lFLY §7Gutschein §8(§2" + minuten + "§7min.§8)").setLore(new String[]{"", "§8➥ §7Rechtsklicke diesen Gutschein und", "§8➥ §7erhalte §a" + minuten + "§7min§8. §7Flugdauer§8.", ""}).build();

                                if (Integer.parseInt(args[1]) > 0) {
                                    player.getInventory().addItem(gutschein);
                                    player.sendMessage(PrefixManager.GUTSCHEIN + "§7Du hast einen §a§lFLY §7Gutschein §8(§2" + minuten + "§7min.§8) §7erhalten§8.");
                                } else {
                                    player.sendMessage(PrefixManager.GUTSCHEIN + "§cBitte gebe eine gültige Anzahl an§8.");
                                }

                            } catch (NumberFormatException e) {
                                player.sendMessage(PrefixManager.GUTSCHEIN + "§cBitte gebe eine gültige Anzahl an§8.");
                            }

                        }
                    } else {
                        player.sendMessage(PrefixManager.GUTSCHEIN + "§7Syntax§8: /§3gutschein §8<§7fly§8> §8<§7min.§8>");
                    }
                } else {
                    player.sendMessage(PrefixManager.GUTSCHEIN + "§7Syntax§8: /§3gutschein §8<§7fly§8> §8<§7min.§8>");
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


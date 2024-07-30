package de.sprachlvs.skydrugs.commands;

import de.sprachlvs.skydrugs.SkyDrugs;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class EnchantCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        final Player player = (Player)sender;
        if (PermissionsEx.getUser(player).inGroup("Owner")) {
            if (args.length == 0 || args.length == 1) {
                player.sendMessage(SkyDrugs.PREFIX + "§7Verwendung: §5/enchant <enchantment> <level>");
                player.sendMessage(SkyDrugs.PREFIX + "§7Enchantments: §5Stärke§8, §5Flamme§8, §5Unendlichkeit§8, §5Schlag§8, §5Haltbarkeit§8, §5Schärfe§8, §5Verbrennung§8, §5Rückstoß§8, §5Untot§8, §5Bann§8, §5Plünderung§8, §5Schutz§8, §5Feuerschutz§8, §5Exploschutz§8, §5ProjSchutz§8, §5Federfall§8, §5Atmung§8, §5Wasserläufer§8, §5Dornen§8, §5Effizienz§8, §5Glück§8, §5Behutsamkeit");
            }
            if (args.length == 2) {
                if (player.getItemInHand() != null && player.getItemInHand().getType() != Material.AIR) {
                    final ItemStack hand = player.getInventory().getItemInHand();
                    final int level = Integer.parseInt(args[1]);
                    if (args[0].equalsIgnoreCase("Stärke")) {
                        hand.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, level);
                        player.sendMessage(SkyDrugs.PREFIX + "§7Du hast dein Item verzaubert§8.");
                        player.sendMessage(SkyDrugs.PREFIX + "§7Enchantment§8: §dStärke §5" + level);
                        player.playSound(player.getLocation(), Sound.ANVIL_USE, 100, 14);
                    } else if (args[0].equalsIgnoreCase("Flamme")) {
                        hand.addUnsafeEnchantment(Enchantment.ARROW_FIRE, level);
                        player.sendMessage(SkyDrugs.PREFIX + "§7Du hast dein Item verzaubert§8.");
                        player.sendMessage(SkyDrugs.PREFIX + "§7Enchantment§8: §dFlamme §5" + level);
                        player.playSound(player.getLocation(), Sound.ANVIL_USE, 100, 14);
                    } else if (args[0].equalsIgnoreCase("Unendlichkeit")) {
                        hand.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, level);
                        player.sendMessage(SkyDrugs.PREFIX + "§7Du hast dein Item verzaubert§8.");
                        player.sendMessage(SkyDrugs.PREFIX + "§7Enchantment§8: §dUnendlichkeit §5" + level);
                        player.playSound(player.getLocation(), Sound.ANVIL_USE, 100, 14);
                    } else if (args[0].equalsIgnoreCase("Schlag")) {
                        hand.addUnsafeEnchantment(Enchantment.ARROW_KNOCKBACK, level);
                        player.sendMessage(SkyDrugs.PREFIX + "§7Du hast dein Item verzaubert§8.");
                        player.sendMessage(SkyDrugs.PREFIX + "§7Enchantment§8: §dSchlag §5" + level);
                        player.playSound(player.getLocation(), Sound.ANVIL_USE, 100, 14);
                    } else if (args[0].equalsIgnoreCase("Haltbarkeit")) {
                        hand.addUnsafeEnchantment(Enchantment.DURABILITY, level);
                        player.sendMessage(SkyDrugs.PREFIX + "§7Du hast dein Item verzaubert§8.");
                        player.sendMessage(SkyDrugs.PREFIX + "§7Enchantment§8: §dHaltbarkeit §5" + level);
                        player.playSound(player.getLocation(), Sound.ANVIL_USE, 100, 14);
                    } else if (args[0].equalsIgnoreCase("Schärfe")) {
                        hand.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, level);
                        player.sendMessage(SkyDrugs.PREFIX + "§7Du hast dein Item verzaubert§8.");
                        player.sendMessage(SkyDrugs.PREFIX + "§7Enchantment§8: §dSchärfe §5" + level);
                        player.playSound(player.getLocation(), Sound.ANVIL_USE, 100, 14);
                    } else if (args[0].equalsIgnoreCase("Verbrennung")) {
                        hand.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, level);
                        player.sendMessage(SkyDrugs.PREFIX + "§7Du hast dein Item verzaubert§8.");
                        player.sendMessage(SkyDrugs.PREFIX + "§7Enchantment§8: §dVerbrennung §5" + level);
                        player.playSound(player.getLocation(), Sound.ANVIL_USE, 100, 14);
                    } else if (args[0].equalsIgnoreCase("Rückstoß")) {
                        hand.addUnsafeEnchantment(Enchantment.KNOCKBACK, level);
                        player.sendMessage(SkyDrugs.PREFIX + "§7Du hast dein Item verzaubert§8.");
                        player.sendMessage(SkyDrugs.PREFIX + "§7Enchantment§8: §dRückstoß §5" + level);
                        player.playSound(player.getLocation(), Sound.ANVIL_USE, 100, 14);
                    } else if (args[0].equalsIgnoreCase("Smite")) {
                        hand.addUnsafeEnchantment(Enchantment.DAMAGE_UNDEAD, level);
                        player.sendMessage(SkyDrugs.PREFIX + "§7Du hast dein Item verzaubert§8.");
                        player.sendMessage(SkyDrugs.PREFIX + "§7Enchantment§8: §dSmite §5" + level);
                        player.playSound(player.getLocation(), Sound.ANVIL_USE, 100, 14);
                    } else if (args[0].equalsIgnoreCase("Bann")) {
                        hand.addUnsafeEnchantment(Enchantment.DAMAGE_ARTHROPODS, level);
                        player.sendMessage(SkyDrugs.PREFIX + "§7Du hast dein Item verzaubert§8.");
                        player.sendMessage(SkyDrugs.PREFIX + "§7Enchantment§8: §dBann §5" + level);
                        player.playSound(player.getLocation(), Sound.ANVIL_USE, 100, 14);
                    } else if (args[0].equalsIgnoreCase("Plünderung")) {
                        hand.addUnsafeEnchantment(Enchantment.LOOT_BONUS_MOBS, level);
                        player.sendMessage(SkyDrugs.PREFIX + "§7Du hast dein Item verzaubert§8.");
                        player.sendMessage(SkyDrugs.PREFIX + "§7Enchantment§8: §dPlünderung §5" + level);
                        player.playSound(player.getLocation(), Sound.ANVIL_USE, 100, 14);
                    } else if (args[0].equalsIgnoreCase("Schutz")) {
                        hand.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, level);
                        player.sendMessage(SkyDrugs.PREFIX + "§7Du hast dein Item verzaubert§8.");
                        player.sendMessage(SkyDrugs.PREFIX + "§7Enchantment§8: §dSchutz §5" + level);
                        player.playSound(player.getLocation(), Sound.ANVIL_USE, 100, 14);
                    } else if (args[0].equalsIgnoreCase("Feuerschutz")) {
                        hand.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, level);
                        player.sendMessage(SkyDrugs.PREFIX + "§7Du hast dein Item verzaubert§8.");
                        player.sendMessage(SkyDrugs.PREFIX + "§7Enchantment§8: §dFeuerschutz §5" + level);
                        player.playSound(player.getLocation(), Sound.ANVIL_USE, 100, 14);
                    } else if (args[0].equalsIgnoreCase("Exploschutz")) {
                        hand.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, level);
                        player.sendMessage(SkyDrugs.PREFIX + "§7Du hast dein Item verzaubert§8.");
                        player.sendMessage(SkyDrugs.PREFIX + "§7Enchantment§8: §dExploSchutz §5" + level);
                        player.playSound(player.getLocation(), Sound.ANVIL_USE, 100, 14);
                    } else if (args[0].equalsIgnoreCase("ProjSchutz")) {
                        hand.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, level);
                        player.sendMessage(SkyDrugs.PREFIX + "§7Du hast dein Item verzaubert§8.");
                        player.sendMessage(SkyDrugs.PREFIX + "§7Enchantment§8: §dProjSchutz §5" + level);
                        player.playSound(player.getLocation(), Sound.ANVIL_USE, 100, 14);
                    } else if (args[0].equalsIgnoreCase("Federfall")) {
                        hand.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, level);
                        player.sendMessage(SkyDrugs.PREFIX + "§7Du hast dein Item verzaubert§8.");
                        player.sendMessage(SkyDrugs.PREFIX + "§7Enchantment§8: §dFederfall §5" + level);
                        player.playSound(player.getLocation(), Sound.ANVIL_USE, 100, 14);
                    } else if (args[0].equalsIgnoreCase("Atmung")) {
                        hand.addUnsafeEnchantment(Enchantment.OXYGEN, level);
                        player.sendMessage(SkyDrugs.PREFIX + "§7Du hast dein Item verzaubert§8.");
                        player.sendMessage(SkyDrugs.PREFIX + "§7Enchantment§8: §dAtmung §5" + level);
                        player.playSound(player.getLocation(), Sound.ANVIL_USE, 100, 14);
                    } else if (args[0].equalsIgnoreCase("Wasserläufer")) {
                        hand.addUnsafeEnchantment(Enchantment.DEPTH_STRIDER, level);
                        player.sendMessage(SkyDrugs.PREFIX + "§7Du hast dein Item verzaubert§8.");
                        player.sendMessage(SkyDrugs.PREFIX + "§7Enchantment§8: §dWasserläufer §5" + level);
                        player.playSound(player.getLocation(), Sound.ANVIL_USE, 100, 14);
                    } else if (args[0].equalsIgnoreCase("Dornen")) {
                        hand.addUnsafeEnchantment(Enchantment.THORNS, level);
                        player.sendMessage(SkyDrugs.PREFIX + "§7Du hast dein Item verzaubert§8.");
                        player.sendMessage(SkyDrugs.PREFIX + "§7Enchantment§8: §dDornen §5" + level);
                        player.playSound(player.getLocation(), Sound.ANVIL_USE, 100, 14);
                    } else if (args[0].equalsIgnoreCase("Effizienz")) {
                        hand.addUnsafeEnchantment(Enchantment.DIG_SPEED, level);
                        player.sendMessage(SkyDrugs.PREFIX + "§7Du hast dein Item verzaubert§8.");
                        player.sendMessage(SkyDrugs.PREFIX + "§7Enchantment§8: §dEffizienz §5" + level);
                        player.playSound(player.getLocation(), Sound.ANVIL_USE, 100, 14);
                    } else if (args[0].equalsIgnoreCase("Glück")) {
                        hand.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, level);
                        player.sendMessage(SkyDrugs.PREFIX + "§7Du hast dein Item verzaubert§8.");
                        player.sendMessage(SkyDrugs.PREFIX + "§7Enchantment§8: §dGlück §5" + level);
                        player.playSound(player.getLocation(), Sound.ANVIL_USE, 100, 14);
                    } else if (args[0].equalsIgnoreCase("Behutsamkeit")) {
                        hand.addUnsafeEnchantment(Enchantment.SILK_TOUCH, level);
                        player.sendMessage(SkyDrugs.PREFIX + "§7Du hast dein Item verzaubert§8.");
                        player.sendMessage(SkyDrugs.PREFIX + "§7Enchantment§8: §dBehutsamkeit §5" + level);
                        player.playSound(player.getLocation(), Sound.ANVIL_USE, 100, 14);
                    }
                } else {
                    player.sendMessage(SkyDrugs.PREFIX + "§7Bitte halte ein Item in der Hand§8.");
                }
            } else {
                player.sendMessage(SkyDrugs.PREFIX + "§7Verwendung: §5/enchant <enchantment> <level>");
                player.sendMessage(SkyDrugs.PREFIX + "§7Enchantments: §5Stärke§8, §5Flamme§8, §5Unendlichkeit§8, §5Schlag§8, §5Haltbarkeit§8, §5Schärfe§8, §5Verbrennung§8, §5Rückstoß§8, §5Untot§8, §5Bann§8, §5Plünderung§8, §5Schutz§8, §5Feuerschutz§8, §5Exploschutz§8, §5ProjSchutz§8, §5Federfall§8, §5Atmung§8, §5Wasserläufer§8, §5Dornen§8, §5Effizienz§8, §5Glück§8, §5Behutsamkeit");
            }
        } else {
            player.sendMessage(SkyDrugs.NOPERM);
        }
        return false;
    }
}

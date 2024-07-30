package de.sprachlvs.skydrugs.listener;

import de.sprachlvs.skydrugs.SkyDrugs;
import de.sprachlvs.skydrugs.manager.PrefixManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import ru.tehkode.permissions.bukkit.PermissionsEx;

import java.util.HashMap;

public class GutscheinListener implements Listener {

    public static final HashMap<Player, Boolean> flugmodus = new HashMap<>();

    @EventHandler
    public void onPlayerJoin(final PlayerJoinEvent e) {
        final Player player = e.getPlayer();

        flugmodus.put(e.getPlayer(), false);
    }

    @EventHandler
    public void onInteract(final PlayerInteractEvent e) {

        final Player player = e.getPlayer();


        if(e.getItem() != null && e.getItem().getType() == Material.PAPER && player.getItemInHand().getItemMeta().getDisplayName() != null) {


            if(player.getItemInHand().getItemMeta().getDisplayName().contains("§8»│ §a§lFLY §7Gutschein")) {

                if (PermissionsEx.getUser(player).inGroup("Salvia") || PermissionsEx.getUser(player).inGroup("Booster") || PermissionsEx.getUser(player).inGroup("Creator") || PermissionsEx.getUser(player).inGroup("Content") || PermissionsEx.getUser(player).inGroup("Supporter") || PermissionsEx.getUser(player).inGroup("Moderator") || PermissionsEx.getUser(player).inGroup("SrModerator") || PermissionsEx.getUser(player).inGroup("Developer") || PermissionsEx.getUser(player).inGroup("Admin") || PermissionsEx.getUser(player).inGroup("Owner")) {
                    player.sendMessage(PrefixManager.GUTSCHEIN + "§cDu hast bereits Rechte auf §8/§a§lFLY §cmit deinem Rang§8.");
                    player.playSound(player.getLocation(), Sound.SKELETON_HURT, 100, 14.8F);
                } else {
                    if(flugmodus.get(player) == Boolean.FALSE) {


                        player.playSound(player.getLocation(), Sound.LEVEL_UP, 100F, 1);

                        final String itemname = player.getItemInHand().getItemMeta().getDisplayName().replaceAll("§8»│ §a§lFLY §7Gutschein §8\\(§2", "").replaceAll("§7min.§8\\)", "");

                /*
                            send "{@p} &7Dein Flugmodus wurde nun für &a%{_name}%&7min&8. &7aktiviert&8."
                            send "{@p} &8(&a&l!&8) &7Beim &arejoinen &7ist der Gutschein ungültig&8."
                 */


                        flugmodus.put(player, true);
                        player.sendMessage(PrefixManager.GUTSCHEIN + "§7Dein Flugmodus wurde nun für §a" + itemname + "§7min" + " §7aktiviert§8.");
                        player.sendMessage(PrefixManager.GUTSCHEIN + "§8(§c§l!§8) §7Beim Rejoinen wird dieser deaktiviert§8.");


                        player.setAllowFlight(true);
                        Bukkit.getScheduler().runTaskLater(SkyDrugs.getInstance(), new Runnable() {
                            @Override
                            public void run() {
                                player.setAllowFlight(false);
                                player.setFlying(false);
                                player.sendMessage(PrefixManager.GUTSCHEIN + "§7Dein §aFlugmodus §8(§a" + itemname + "§7min§8." + "§8) §7ist abgelaufen§8.");
                                player.playSound(player.getLocation(), Sound.SKELETON_DEATH, 100, 14.8F);
                                flugmodus.put(player, false);
                            }
                        }, 1200 * Integer.parseInt(itemname));

                        if (player.getItemInHand().getAmount() > 1) {
                            player.getItemInHand().setAmount(player.getItemInHand().getAmount() - 1);
                        } else {
                            player.setItemInHand(new ItemStack(Material.AIR));
                        }
                    } else {
                        player.sendMessage(PrefixManager.GUTSCHEIN + "§cDu hast bereits einen FLY-Gutschein eingelöst§8.");
                        player.playSound(player.getLocation(), Sound.SKELETON_HURT, 100, 14.8F);
                    }
                }
            }
        }
    }


}

package de.sprachlvs.skydrugs.listener;

import de.sprachlvs.skydrugs.apis.EventAPI;
import de.sprachlvs.skydrugs.manager.FarbManager;
import de.sprachlvs.skydrugs.manager.PrefixManager;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import ru.tehkode.permissions.bukkit.PermissionsEx;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class AsyncPlayerChatListener implements Listener {

    public static final ArrayList<Player> tokenEvent = new ArrayList<>();
    public static final HashMap<Player, Integer> numberEvent = new HashMap<>(); //player, status
    static int endindex;

    @EventHandler
    public void onAsyncPlayerChat(final AsyncPlayerChatEvent event) {
        final Player player = event.getPlayer();
        if (tokenEvent.contains(player)) {
            event.setCancelled(true);
            if (event.getMessage().equalsIgnoreCase("cancel")) {
                player.sendMessage(PrefixManager.EVENT + "§cVorgang abgebrochen§8.");
                return;
            }
            try {
                double tokens = Double.parseDouble(event.getMessage());
                EventAPI.getTokenverlosungEvent().start(player, tokens);
                tokenEvent.remove(player);
            } catch (NumberFormatException e) {
                player.sendMessage(PrefixManager.EVENT + "§cGebe eine Anzahl an§8.");
            }
        } else if (numberEvent.containsKey(player)) {
            event.setCancelled(true);
            int status = numberEvent.get(player);
            if (player.getItemInHand() != null && player.getItemInHand().getType() != Material.AIR) {
                if (status == 1) {
                    try {
                        endindex = Integer.parseInt(event.getMessage());
                        numberEvent.replace(player, 2);
                        player.sendMessage(PrefixManager.EVENT + "§7Gebe die Zahl die erraten werden soll im Chat ein§8.");
                        player.sendMessage(PrefixManager.EVENT + "§8'§ccancel§8' §7zum abbrechen§8.");
                    } catch (NumberFormatException e) {
                        player.sendMessage(PrefixManager.EVENT + "§7Gebe die höchste Zahl im Chat ein§8.");
                        player.sendMessage(PrefixManager.EVENT + "§8'§ccancel§8' §7zum abbrechen§8.");
                    }
                } else if (status == 2) {
                    try {
                        int toGuess = Integer.parseInt(event.getMessage());
                        EventAPI.getGuessTheNumberEvent().start(player, player.getItemInHand(), endindex, toGuess);
                        numberEvent.remove(player);
                    } catch (NumberFormatException e) {
                        player.sendMessage(PrefixManager.EVENT + "§7 Gebe die Zahl die erraten werden soll im Chat ein§8.");
                        player.sendMessage(PrefixManager.EVENT + "§8'§ccancel§8' §7zum abbrechen§8.");
                    }
                }
            } else {
                player.sendMessage(PrefixManager.EVENT + "§7Bitte halte ein Item dabei in der Hand§8.");
                player.sendMessage(PrefixManager.EVENT + "§8'§ccancel§8' §7zum abbrechen§8.");
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        UUID uuid = player.getUniqueId();
        String message = event.getMessage().replace("%", "%%");
        String prefix = PermissionsEx.getUser(player).getPrefix();
        String suffix = PermissionsEx.getUser(player).getSuffix();
        prefix = ChatColor.translateAlternateColorCodes('&', prefix);
        suffix = ChatColor.translateAlternateColorCodes('&', suffix);
        boolean italic = FarbManager.isItalic(uuid);
        boolean bold = FarbManager.isBold(uuid);
        boolean underline = FarbManager.isUnderline(uuid);
        boolean crossedout = FarbManager.isCrossedOut(uuid);

        if (EventAPI.eventstatus) {
            if (PermissionsEx.getUser(player).inGroup("default") || PermissionsEx.getUser(player).inGroup("Kavain") || PermissionsEx.getUser(player).inGroup("Valium") || PermissionsEx.getUser(player).inGroup("Opiat") || PermissionsEx.getUser(player).inGroup("Ephedra") || PermissionsEx.getUser(player).inGroup("Salvia") || PermissionsEx.getUser(player).inGroup("Booster") || PermissionsEx.getUser(player).inGroup("Creator")) {
                event.setCancelled(true);
                player.sendMessage(PrefixManager.EVENT + "§cWährend eines Events kannst du nicht schreiben§8.");
            } else {
                if (FarbManager.getFarbe(uuid) == null) {
                    event.setFormat(prefix + suffix + " §8┃ §7" + player.getName() + " §8» §7" + message);
                } else {
                    event.setFormat(prefix + suffix + " §8┃ §7" + player.getName() + " §8» " + FarbManager.getFarbe(player.getUniqueId()) + (italic ? "§o" : "") + (bold ? "§l" : "") + (underline ? "§n" : "") + (crossedout ? "§m" : "") + message);
                }
            }
        } else {
            if (FarbManager.getFarbe(uuid) == null) {
                event.setFormat(prefix + suffix + " §8┃ §7" + player.getName() + " §8» §7" + message);
            } else {
                event.setFormat(prefix + suffix + " §8┃ §7" + player.getName() + " §8» " + FarbManager.getFarbe(player.getUniqueId()) + (italic ? "§o" : "") + (bold ? "§l" : "") + (underline ? "§n" : "") + (crossedout ? "§m" : "") + message);
            }
        }
    }
}

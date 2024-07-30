package de.sprachlvs.skydrugs.events;

import de.sprachlvs.skydrugs.SkyDrugs;
import de.sprachlvs.skydrugs.apis.EventAPI;
import de.sprachlvs.skydrugs.manager.PrefixManager;
import de.sprachlvs.skydrugs.utils.GeneralUtils;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class GuessTheNumberEvent implements Listener {
    static ItemStack itemStack;
    static boolean active;

    static int zahl;

    public void start(Player starter, ItemStack win, int endIndex, int zahl1) {
        itemStack = win;
        zahl = zahl1;
        if (EventAPI.event) {
            starter.sendMessage(PrefixManager.EVENT + "§cEs läuft bereits ein anderes Event§8.");
            return;
        }
        for (Player all : Bukkit.getOnlinePlayers()) all.playSound(all.getLocation(), Sound.ENDERDRAGON_WINGS, 1.0f, 1.0f);
        GeneralUtils.clearChatAll();
        EventAPI.event = true;
        Bukkit.broadcastMessage("§r");
        Bukkit.broadcastMessage(PrefixManager.EVENT + "§7Errate die Zahl zwischen §f1 §7und §a" + endIndex + "§8.");
        Bukkit.broadcastMessage(PrefixManager.EVENT + "§7Schreibt eure Antworten in den Chat§8. §f§lVIEL GLÜCK§8!");
        Bukkit.broadcastMessage(PrefixManager.EVENT + "§7Gewinn§8: §7" + win.getAmount() + "§8x §7" + (win.getItemMeta().hasDisplayName() ? win.getItemMeta().getDisplayName() : win.getType().toString()));
        Bukkit.broadcastMessage("§r");
        new BukkitRunnable() {
            @Override
            public void run() {
                Bukkit.broadcastMessage(PrefixManager.EVENT + "§7Das Event startet in §f3 Sekunden§8...");
                for (Player all : Bukkit.getOnlinePlayers()) all.playSound(all.getLocation(), Sound.SUCCESSFUL_HIT, 1.0f, 0.7f);
            }
        }.runTaskLater(SkyDrugs.getInstance(), 60L);
        new BukkitRunnable() {
            @Override
            public void run() {
                Bukkit.broadcastMessage(PrefixManager.EVENT + "§7Das Event startet in §f2 Sekunden§8...");
                for (Player all : Bukkit.getOnlinePlayers()) all.playSound(all.getLocation(), Sound.SUCCESSFUL_HIT, 1.0f, 1.0f);
            }
        }.runTaskLater(SkyDrugs.getInstance(), 80L);
        new BukkitRunnable() {
            @Override
            public void run() {
                Bukkit.broadcastMessage(PrefixManager.EVENT + "§7Das Event startet in §f1 Sekunde§8...");
                for (Player all : Bukkit.getOnlinePlayers()) all.playSound(all.getLocation(), Sound.SUCCESSFUL_HIT, 1.0f, 1.3f);
            }
        }.runTaskLater(SkyDrugs.getInstance(), 100L);
        new BukkitRunnable() {
            @Override
            public void run() {
                Bukkit.broadcastMessage(PrefixManager.EVENT + "§7Das Event hat begonnen§8.");
                for (Player all : Bukkit.getOnlinePlayers()) all.playSound(all.getLocation(), Sound.LEVEL_UP, 1.0f, 10.0f);
                active = true;
            }
        }.runTaskLater(SkyDrugs.getInstance(), 120L);
        new BukkitRunnable() {
            @Override
            public void run() {
                if (active) {
                    Bukkit.broadcastMessage(PrefixManager.EVENT + "§7Das Event endet in §f10 Sekunden§8...");
                    for (Player all : Bukkit.getOnlinePlayers()) all.playSound(all.getLocation(), Sound.NOTE_BASS, 1.0f, 1.0f);
                }
            }
        }.runTaskLater(SkyDrugs.getInstance(), 1400);
        new BukkitRunnable() {
            @Override
            public void run() {
                if (active) {
                    Bukkit.broadcastMessage(PrefixManager.EVENT + "§7Das Event endet in §f5 Sekunden§8...");
                    for (Player all : Bukkit.getOnlinePlayers()) all.playSound(all.getLocation(), Sound.NOTE_BASS, 1.0f, 1.0f);
                }
            }
        }.runTaskLater(SkyDrugs.getInstance(), 1500L);
        new BukkitRunnable() {
            @Override
            public void run() {
                if (active) {
                    Bukkit.broadcastMessage(PrefixManager.EVENT + "§7Das Event endet in §f4 Sekunden§8...");
                    for (Player all : Bukkit.getOnlinePlayers()) all.playSound(all.getLocation(), Sound.NOTE_BASS, 1.0f, 1.0f);
                }
            }
        }.runTaskLater(SkyDrugs.getInstance(), 1520L);
        new BukkitRunnable() {
            @Override
            public void run() {
                if (active) {
                    Bukkit.broadcastMessage(PrefixManager.EVENT + "§7Das Event endet in §f3 Sekunden§8...");
                    for (Player all : Bukkit.getOnlinePlayers()) all.playSound(all.getLocation(), Sound.NOTE_BASS, 1.0f, 1.0f);
                }
            }
        }.runTaskLater(SkyDrugs.getInstance(), 1540L);
        new BukkitRunnable() {
            @Override
            public void run() {
                if (active) {
                    Bukkit.broadcastMessage(PrefixManager.EVENT + "§7Das Event endet in §f2 Sekunden§8...");
                    for (Player all : Bukkit.getOnlinePlayers()) all.playSound(all.getLocation(), Sound.NOTE_BASS, 1.0f, 1.0f);
                }
            }
        }.runTaskLater(SkyDrugs.getInstance(), 1560L);
        new BukkitRunnable() {
            @Override
            public void run() {
                if (active) {
                    Bukkit.broadcastMessage(PrefixManager.EVENT + "§7Das Event endet in §f1 Sekunde§8...");
                    for (Player all : Bukkit.getOnlinePlayers()) all.playSound(all.getLocation(), Sound.NOTE_BASS, 1.0f, 1.0f);
                }
            }
        }.runTaskLater(SkyDrugs.getInstance(), 1580L);
        new BukkitRunnable() {
            @Override
            public void run() {
                if (active) {
                    active = false;
                    if (EventAPI.event) EventAPI.event = false;
                    Bukkit.broadcastMessage("§r");
                    Bukkit.broadcastMessage(PrefixManager.EVENT + "§7Das Event wurde beendet§8.");
                    Bukkit.broadcastMessage(PrefixManager.EVENT + "§7Die Zahl §f" + zahl + "§7 wurde §cnicht§7 erraten§8.");
                    Bukkit.broadcastMessage("§r");
                    for (Player all : Bukkit.getOnlinePlayers()) all.playSound(all.getLocation(), Sound.ANVIL_BREAK, 1.0f, 1.0f);
                }
            }
        }.runTaskLater(SkyDrugs.getInstance(), 1600L);
    }

    @EventHandler
    public void onChat(final AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        if (active && EventAPI.event) {
            EventAPI.eventstatus = false;
            try {
                int number = Integer.parseInt(event.getMessage());
                if (number == zahl) {
                    event.setCancelled(true);
                    Bukkit.broadcastMessage("§r");
                    Bukkit.broadcastMessage(PrefixManager.EVENT + "§7Der Gewinner wurde ermittelt§8:");
                    Bukkit.broadcastMessage(PrefixManager.EVENT + "§f§l" + player.getName());
                    Bukkit.broadcastMessage("§r");
                    Bukkit.broadcastMessage(PrefixManager.EVENT + "§7Gewinn§8: §f" + itemStack.getAmount() + "§8x §f" + (itemStack.getItemMeta().hasDisplayName() ? itemStack.getItemMeta().getDisplayName() : itemStack.getType().toString()));
                    Bukkit.broadcastMessage("§r");
                    for (Player all : Bukkit.getOnlinePlayers()) all.playSound(all.getLocation(), Sound.LEVEL_UP, 1.0f, 0.5f);
                    if (player.getInventory().firstEmpty() == -1) {
                        player.getWorld().dropItemNaturally(player.getLocation(), itemStack);
                        player.sendMessage(PrefixManager.EVENT + "§7Der Gewinn wurde unter dir gedroppt§8,");
                        player.sendMessage(PrefixManager.EVENT + "§7weil du keinen Platz im Inventar hast§8.");
                    } else {
                        player.getInventory().addItem(itemStack);
                        player.sendMessage(PrefixManager.EVENT + "§7Du hast deinen Gewinn erhalten§8.");
                    }
                    active = false;
                    EventAPI.event = false;
                    EventAPI.eventstatus = true;
                }
            } catch (NumberFormatException e) {
                event.setCancelled(true);
                player.sendMessage(PrefixManager.EVENT + "§cGebe eine Nummer ein§8.");
            }
        }
    }

}


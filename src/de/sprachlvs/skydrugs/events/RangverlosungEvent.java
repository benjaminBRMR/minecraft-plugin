package de.sprachlvs.skydrugs.events;

import de.sprachlvs.skydrugs.SkyDrugs;
import de.sprachlvs.skydrugs.apis.EventAPI;
import de.sprachlvs.skydrugs.manager.PrefixManager;
import de.sprachlvs.skydrugs.utils.GeneralUtils;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import ru.tehkode.permissions.PermissionGroup;
import ru.tehkode.permissions.bukkit.PermissionsEx;

import java.util.concurrent.CopyOnWriteArrayList;

public class RangverlosungEvent {

    static PermissionGroup value;

    static boolean active;

    public void start(Player starter, PermissionGroup group) {
        value = group;
        if (EventAPI.event) {
            starter.sendMessage(PrefixManager.EVENT + "§cEs läuft bereits ein anderes Event§8.");
            return;
        }
        EventAPI.event = true;
        active = true;
        Player winner = determinWinner(starter, group);
        if (winner == null) {
            EventAPI.event = false;
            active = false;
            return;
        }
        GeneralUtils.clearChatAll();
        Bukkit.broadcastMessage("§r");
        Bukkit.broadcastMessage(PrefixManager.EVENT + "§7Es wurde eine §fRangverlosung §7gestartet§8!");
        Bukkit.broadcastMessage(PrefixManager.EVENT + "§7Der §f" + group.getName() + " §7Rang wird verlost§8.");
        Bukkit.broadcastMessage("§r");

        new BukkitRunnable() {
            @Override
            public void run() {
                Bukkit.broadcastMessage(PrefixManager.EVENT + "§7Der Gewinner wird ermittelt§8.");
                for (Player all : Bukkit.getOnlinePlayers())
                    all.playSound(all.getLocation(), Sound.SUCCESSFUL_HIT, 1.0f, 0.7f);
            }
        }.runTaskLater(SkyDrugs.getInstance(), 60L);

        new BukkitRunnable() {
            @Override
            public void run() {
                Bukkit.broadcastMessage(PrefixManager.EVENT + "§7Der Gewinner wird ermittelt§8..");
                for (Player all : Bukkit.getOnlinePlayers())
                    all.playSound(all.getLocation(), Sound.SUCCESSFUL_HIT, 1.0f, 0.7f);
            }
        }.runTaskLater(SkyDrugs.getInstance(), 80L);

        new BukkitRunnable() {
            @Override
            public void run() {
                Bukkit.broadcastMessage(PrefixManager.EVENT + "§7Der Gewinner wird ermittelt§8...");
                for (Player all : Bukkit.getOnlinePlayers())
                    all.playSound(all.getLocation(), Sound.SUCCESSFUL_HIT, 1.0f, 0.7f);
            }
        }.runTaskLater(SkyDrugs.getInstance(), 100L);

        new BukkitRunnable() {
            @Override
            public void run() {
                for (Player all : Bukkit.getOnlinePlayers())
                    all.playSound(all.getLocation(), Sound.ENDERDRAGON_WINGS, 1.0f, 1.0f);
                Verlosung.showTitleRangverlosung(winner.getName(), () -> {
                    Bukkit.broadcastMessage("§r");
                    Bukkit.broadcastMessage(PrefixManager.EVENT + "§7Der Spieler §f" + winner.getName() + "§7 hat den §f" + group.getName() + " §7Rang §7gewonnen§8.");
                    Bukkit.broadcastMessage("§r");

                    if (PermissionsEx.getUser(winner).inGroup("default")) {
                        if (group.getName().equalsIgnoreCase("Kavain") || group.getName().equalsIgnoreCase("Valium") || group.getName().equalsIgnoreCase("Opiat") || group.getName().equalsIgnoreCase("Ephedra") || group.getName().equalsIgnoreCase("Salvia")) {
                            ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
                            String command = "pex user " + winner.getName() + " group set " + group.getName();
                            Bukkit.dispatchCommand(console, command);
                        }
                    } else if (PermissionsEx.getUser(winner).inGroup("Kavain")) {
                        if (group.getName().equalsIgnoreCase("Valium") || group.getName().equalsIgnoreCase("Opiat") || group.getName().equalsIgnoreCase("Ephedra") || group.getName().equalsIgnoreCase("Salvia")) {
                            ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
                            String command = "pex user " + winner.getName() + " group set " + group.getName();
                            Bukkit.dispatchCommand(console, command);
                        }
                    } else if (PermissionsEx.getUser(winner).inGroup("Valium")) {
                        if (group.getName().equalsIgnoreCase("Opiat") || group.getName().equalsIgnoreCase("Ephedra") || group.getName().equalsIgnoreCase("Salvia")) {
                            ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
                            String command = "pex user " + winner.getName() + " group set " + group.getName();
                            Bukkit.dispatchCommand(console, command);
                        }
                    } else if (PermissionsEx.getUser(winner).inGroup("Opiat")) {
                        if (group.getName().equalsIgnoreCase("Ephedra") || group.getName().equalsIgnoreCase("Salvia")) {
                            ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
                            String command = "pex user " + winner.getName() + " group set " + group.getName();
                            Bukkit.dispatchCommand(console, command);
                        }
                    } else if (PermissionsEx.getUser(winner).inGroup("Ephedra")) {
                        if (group.getName().equalsIgnoreCase("Salvia")) {
                            ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
                            String command = "pex user " + winner.getName() + " group set " + group.getName();
                            Bukkit.dispatchCommand(console, command);
                        }
                    }
                    EventAPI.event = false;
                    active = false;
                });
            }
        }.runTaskLater(SkyDrugs.getInstance(), 120L);
    }

    private static Player determinWinner(Player player, PermissionGroup group) {
        CopyOnWriteArrayList<Player> players = new CopyOnWriteArrayList<>();
        for (Player all : Bukkit.getOnlinePlayers()) {
            if (group.getName().equalsIgnoreCase("Kavain")) {
                if (PermissionsEx.getUser(all).inGroup("default")) players.add(all);
            } else if (group.getName().equalsIgnoreCase("Valium")) {
                if (PermissionsEx.getUser(all).inGroup("default") || PermissionsEx.getUser(all).inGroup("Kavain")) players.add(all);
            } else if (group.getName().equalsIgnoreCase("Opiat")) {
                if (PermissionsEx.getUser(all).inGroup("default") || PermissionsEx.getUser(all).inGroup("Kavain") || PermissionsEx.getUser(all).inGroup("Valium")) players.add(all);
            } else if (group.getName().equalsIgnoreCase("Ephedra")) {
                if (PermissionsEx.getUser(all).inGroup("default") || PermissionsEx.getUser(all).inGroup("Kavain") || PermissionsEx.getUser(all).inGroup("Valium") || PermissionsEx.getUser(all).inGroup("Opiat")) players.add(all);
            } else if (group.getName().equalsIgnoreCase("Salvia")) {
                if (PermissionsEx.getUser(all).inGroup("default") || PermissionsEx.getUser(all).inGroup("Kavain") || PermissionsEx.getUser(all).inGroup("Valium") || PermissionsEx.getUser(all).inGroup("Opiat") || PermissionsEx.getUser(all).inGroup("Ephedra")) players.add(all);
            }
        }
        if (players.size() == 0) {
            player.sendMessage(PrefixManager.EVENT + "§cDer Rang kann derzeit nicht verlost werden§8.");
            return null;
        } else {
            int index = GeneralUtils.PUBLIC_RANDOM.nextInt(players.size());
            return players.get(index);
        }
    }

}


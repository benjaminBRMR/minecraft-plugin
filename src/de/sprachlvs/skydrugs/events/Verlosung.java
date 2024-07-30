package de.sprachlvs.skydrugs.events;

import de.sprachlvs.skydrugs.SkyDrugs;
import de.sprachlvs.skydrugs.utils.GeneralUtils;
import org.bukkit.Bukkit;
import org.bukkit.Sound;

public class Verlosung {

    static int taskId;
    static int i = 0;

    public static void showTitleTokenverlosung(String name, Runnable whatToDoAfter) {
        String[] letters = name.split("");
        int length = letters.length;
        i = 0;
        StringBuilder builder = new StringBuilder();
        taskId = Bukkit.getScheduler().scheduleSyncRepeatingTask(SkyDrugs.getInstance(), () -> {
            if (i < length) {
                builder.append(letters[i]);
                String title = builder + "§k" + name.substring(i + 1);
                i++;
                Bukkit.getOnlinePlayers().forEach(player -> {
                    GeneralUtils.sendTitle(player, 0, 20, 0, "§8▪ §f§lTOKEN VERLOSUNG §8▪", "§f§o" + title);
                    player.playSound(player.getLocation(), Sound.WOOD_CLICK, 1.0f, 1.0f);
                });
            } else {
                Bukkit.getOnlinePlayers().forEach(player -> {
                    GeneralUtils.sendTitle(player, 0, 30, 10, "§8▪ §f§lTOKEN VERLOSUNG §8▪", "§f§l§o" + name + "§7§o hat gewonnen§8§o!");
                    player.playSound(player.getLocation(), Sound.LEVEL_UP, 1.0f, 0.5f);
                });
                cancelTask();
                whatToDoAfter.run();
            }
        }, 0L, 15L);
    }

    public static void showTitleRangverlosung(String name, Runnable whatToDoAfter) {
        String[] letters = name.split("");
        int length = letters.length;
        i = 0;
        StringBuilder builder = new StringBuilder();
        taskId = Bukkit.getScheduler().scheduleSyncRepeatingTask(SkyDrugs.getInstance(), () -> {
            if (i < length) {
                builder.append(letters[i]);
                String title = builder + "§k" + name.substring(i + 1);
                i++;
                Bukkit.getOnlinePlayers().forEach(player -> {
                    GeneralUtils.sendTitle(player, 0, 20, 0, "§8▪ §f§lRANG VERLOSUNG §8▪", "§f§o" + title);
                    player.playSound(player.getLocation(), Sound.WOOD_CLICK, 1.0f, 1.0f);
                });
            } else {
                Bukkit.getOnlinePlayers().forEach(player -> {
                    GeneralUtils.sendTitle(player, 0, 30, 10, "§8▪ §f§LRANG VERLOSUNG §8▪", "§f§l§o" + name + "§7§o hat gewonnen§8§o!");
                    player.playSound(player.getLocation(), Sound.LEVEL_UP, 1.0f, 0.5f);
                });
                cancelTask();
                whatToDoAfter.run();
            }
        }, 0L, 15L);
    }

    static void cancelTask() {
        i = 0;
        Bukkit.getScheduler().cancelTask(taskId);
    }
}


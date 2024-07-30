package de.sprachlvs.skydrugs.utils;

import de.sprachlvs.skydrugs.SkyDrugs;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class SoundUtils {

    public static void playJoinSound(Player player) {
        player.playSound(player.getLocation(), Sound.CHEST_OPEN, 1.5F, 14.5F);

        Bukkit.getScheduler().runTaskLater(SkyDrugs.getInstance(), new Runnable() {
            @Override
            public void run() {
                player.playSound(player.getLocation(), Sound.NOTE_STICKS, 1.5F, 14.5F);
            }
        }, 4);

        Bukkit.getScheduler().runTaskLater(SkyDrugs.getInstance(), new Runnable() {
            @Override
            public void run() {
                player.playSound(player.getLocation(), Sound.NOTE_STICKS, 1.5F, 14.5F);
            }
        }, 6);

        Bukkit.getScheduler().runTaskLater(SkyDrugs.getInstance(), new Runnable() {
            @Override
            public void run() {
                player.playSound(player.getLocation(), Sound.NOTE_STICKS, 1.5F, 14.5F);
            }
        }, 8);

        Bukkit.getScheduler().runTaskLater(SkyDrugs.getInstance(), new Runnable() {
            @Override
            public void run() {
                player.playSound(player.getLocation(), Sound.NOTE_STICKS, 1.5F, 14.5F);
            }
        }, 10);

        Bukkit.getScheduler().runTaskLater(SkyDrugs.getInstance(), new Runnable() {
            @Override
            public void run() {
                player.playSound(player.getLocation(), Sound.CHEST_CLOSE, 1.5F, 14.5F);
            }
        }, 11);


    }

    public static void playSuccessSound(Player player) {
        player.playSound(player.getLocation(), Sound.SUCCESSFUL_HIT, 2.5F, 14.5F);
    }

    public static void playBigSuccessSound(Player player) {

        player.playSound(player.getLocation(), Sound.NOTE_PLING, 1.5F, 14.5F);

        Bukkit.getScheduler().runTaskLater(SkyDrugs.getInstance(), new Runnable() {
            @Override
            public void run() {
                player.playSound(player.getLocation(), Sound.NOTE_STICKS, 1.5F, 14.5F);
            }
        }, 4);

        Bukkit.getScheduler().runTaskLater(SkyDrugs.getInstance(), new Runnable() {
            @Override
            public void run() {
                player.playSound(player.getLocation(), Sound.NOTE_STICKS, 1.5F, 14.5F);
            }
        }, 6);

        Bukkit.getScheduler().runTaskLater(SkyDrugs.getInstance(), new Runnable() {
            @Override
            public void run() {
                player.playSound(player.getLocation(), Sound.NOTE_STICKS, 1.5F, 14.5F);
            }
        }, 8);

        Bukkit.getScheduler().runTaskLater(SkyDrugs.getInstance(), new Runnable() {
            @Override
            public void run() {
                player.playSound(player.getLocation(), Sound.NOTE_STICKS, 1.5F, 14.5F);
            }
        }, 10);

        Bukkit.getScheduler().runTaskLater(SkyDrugs.getInstance(), new Runnable() {
            @Override
            public void run() {
                player.playSound(player.getLocation(), Sound.NOTE_PLING, 1.5F, 14.5F);
            }
        }, 11);
    }

    public static void playUnsuccessSound(Player player) {
        player.playSound(player.getLocation(), Sound.ITEM_BREAK, 0.5F, 14.5F);
    }

    public static void playOpenSound(Player player) {
        player.playSound(player.getLocation(), Sound.HORSE_ARMOR, 1.5F, 14.5F);
    }

}

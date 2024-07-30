package de.sprachlvs.skydrugs.listener;

import de.sprachlvs.skydrugs.SkyDrugs;
import de.sprachlvs.skydrugs.apis.CounterAPI;
import de.sprachlvs.skydrugs.apis.TablistAPI;
import de.sprachlvs.skydrugs.apis.stats.TokenAPI;
import de.sprachlvs.skydrugs.manager.LocationManager;
import de.sprachlvs.skydrugs.tablist.Tablist;
import de.sprachlvs.skydrugs.utils.LabyModUtils;
import de.sprachlvs.skydrugs.utils.SoundUtils;
import de.sprachlvs.skydrugs.utils.TimeUtils;
import de.sprachlvs.skydrugs.utils.UUIDFetcher;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.IntStream;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {

        Player player = event.getPlayer();

        UUIDFetcher.nameCache.put(player.getUniqueId(), player.getName());
        UUIDFetcher.uuidCache.put(player.getName(), player.getUniqueId());

        if (!player.hasPlayedBefore()) {
            CounterAPI.addPlayercount(1);
            Bukkit.broadcastMessage(SkyDrugs.getHeader("§d§lJOIN"));
            Bukkit.broadcastMessage("");
            Bukkit.broadcastMessage(SkyDrugs.PREFIX + "§7Der Spieler §5" + player.getName() + " §7ist neu! §8[§d§l#" + Bukkit.getOfflinePlayers().length + "§8]");
            Bukkit.broadcastMessage(SkyDrugs.PREFIX + "§7Alle Spieler haben §d1§8'§d000 §7Tokens erhalten§8.");
            Bukkit.broadcastMessage("");
            Bukkit.broadcastMessage(SkyDrugs.getHeader("§d§lJOIN"));
            for (Player all : Bukkit.getOnlinePlayers()) {
                new TokenAPI(all).addTokens(1000);
            }
        }

        Tablist.updateTablistRanks(player);
        TablistAPI.sendTablist(player, "\n        §d§lSKYDRUGS§7.§d§lDE §8┃ §7Dein SkyPvP §8& §7Skyblock Server \n §7Online §8▰§7▱ §d" + Bukkit.getOnlinePlayers().size() + " §8/ §d120 \n",
                "\n §7Discord §8▰§7▱ §ddc.skydrugs.de §8┃ §7Vote §8▰§7▱ §dvote.skydrugs.de \n\n §7Ingesamt registrierte Spieler§8: §d" + CounterAPI.getPlayerCount() + "\n§5↑ §dSkyPvP-1 §7ist erreichbar seit§8: §d" + TimeUtils.timeToString((System.currentTimeMillis() - TimeUtils.getInstance().getUptime()), true) + " §5↓ \n"
        );

        event.setJoinMessage(null);
        IntStream.range(0, 200).mapToObj(i -> "§8").forEach(player::sendMessage);
        player.teleport(LocationManager.getLocation("spawn"));
        SoundUtils.playJoinSound(player);
        LabyModUtils.sendCurrentPlayingGamemode(player, true, SkyDrugs.PREFIX + "§7SkyPvP");

        player.sendMessage("");
        player.sendMessage("    §8(§d§l✎§8) §7Willkommen zurück§8, §d" + player.getName() + "§8!");
        player.sendMessage("    §8(§b§l✌§8) §7Uhrzeit§8: §b" + new SimpleDateFormat("HH:mm:ss").format(new Date()).replaceAll(":", "§8:§b"));
        player.sendMessage("    §8(§c§l❤§8) §7Derzeitige Spieleranzahl§8: §c" + Bukkit.getOnlinePlayers().size());
        player.sendMessage("    §8(§e§l⚔§8) §7Unser Onlineshop§8: §ebuy.skydrugs.de");
        player.sendMessage("");


    }
}

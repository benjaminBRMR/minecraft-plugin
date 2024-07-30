package de.sprachlvs.skydrugs.runnables;

import de.sprachlvs.skydrugs.apis.CookieAPI;
import de.sprachlvs.skydrugs.manager.CookieSettings;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

public class CookieFarmerRunnable implements Runnable {
    @Override
    public void run() {
        for (Player all : Bukkit.getOnlinePlayers()) {
            CookieSettings cookieSettings = new CookieSettings(all.getUniqueId());
            CookieAPI cookieAPI = new CookieAPI(all.getUniqueId());
            if (cookieSettings.getKeksFarmer()) {
                if (cookieAPI.getStatus()) {
                    cookieAPI.addCookies(1);
                }
            }
        }
        for (OfflinePlayer all : Bukkit.getOfflinePlayers()) {
            if (all.isOnline()) continue;
            CookieSettings cookieSettings = new CookieSettings(all.getUniqueId());
            CookieAPI cookieAPI = new CookieAPI(all.getUniqueId());
            if (cookieSettings.getKeksFarmer()) {
                if (cookieAPI.getStatus()) {
                    cookieAPI.addCookies(1);
                }
            }
        }
    }
}

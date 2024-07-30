package de.sprachlvs.skydrugs.manager;

import de.sprachlvs.skydrugs.apis.ConfigAPI;
import de.sprachlvs.skydrugs.utils.TimeUtils;

import java.util.UUID;

public class OfflineManager {

    private static ConfigAPI configAPI;

    private final UUID uuid;

    public OfflineManager(UUID uuid) {
        this.uuid = uuid;
        this.load();
    }

    void load() {
        configAPI = new ConfigAPI("plugins/SkyPvP/database/offlinetime/", this.uuid + ".yml");
    }

    public static ConfigAPI getConfigAPI() {
        return configAPI;
    }

    public void setOffline() {
        configAPI.getConfig().set("offline-since", System.currentTimeMillis());
        configAPI.saveConfig();
    }

    public String getOfflineSince() {
        long offline = configAPI.getConfig().getLong("offline-since");
        long current = System.currentTimeMillis();
        return TimeUtils.timeToString((current - offline), false).replaceAll(",", "§8,§e");
    }
}



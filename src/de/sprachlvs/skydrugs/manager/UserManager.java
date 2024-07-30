package de.sprachlvs.skydrugs.manager;

import de.sprachlvs.skydrugs.apis.ConfigAPI;
import org.bukkit.entity.Player;

import java.text.SimpleDateFormat;

public class UserManager {

    public static ConfigAPI cfg;
    private final Player player;
    private String datum = new SimpleDateFormat("MM/dd/yyyy").format(System.currentTimeMillis());

    void init() {
        cfg = new ConfigAPI("plugins/SkyPvP/database/usercache/", "users.yml");
    }

    public UserManager(Player player) {
        this.player = player;
        this.init();
    }

    public void register() {
        cfg.getConfig().set(this.player.getName() + ".Name", this.player.getName());
        cfg.getConfig().set(this.player.getName() + ".Uuid", this.player.getUniqueId().toString());
        cfg.getConfig().set(this.player.getName() + ".ErsterJoin", this.datum.replace("/", "."));
        cfg.saveConfig();
    }






}

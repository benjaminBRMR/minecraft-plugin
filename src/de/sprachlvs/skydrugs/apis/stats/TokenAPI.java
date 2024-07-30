package de.sprachlvs.skydrugs.apis.stats;

import de.sprachlvs.skydrugs.listener.PlayerChangeCoinEvent;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class TokenAPI {

    private final String uuid;
    private File file;
    private YamlConfiguration configuration;

    public TokenAPI(final Player player) {
        this(player.getUniqueId().toString());
    }
    public TokenAPI(final UUID uuid) {
        this(uuid.toString());
    }
    public TokenAPI(final String uuid) {
        this.uuid = uuid;
        this.load();
        Bukkit.getPluginManager().callEvent(new PlayerChangeCoinEvent(UUID.fromString(uuid)));
    }

    private void load() {
        this.file = new File("plugins/System/statistics/tokens", this.uuid + ".yml");
        this.configuration = YamlConfiguration.loadConfiguration(file);
    }

    public String getUniqueId() {
        return this.uuid;
    }

    public double getTokens() {
        if (this.configuration.get("tokens") == null) {
            return 0;
        } else {
            return this.configuration.getDouble("tokens");
        }
    }

    public void setTokens(double tokens) {
        if (tokens < 0) tokens = 0;
        this.configuration.set("tokens", tokens);
        this.save();
    }

    public void save() {
        try {
            this.configuration.save(this.file);
        } catch (IOException exception) { exception.printStackTrace(); }
    }

    public void addTokens(double tokens) {
        this.setTokens(this.getTokens() + tokens);
    }

    public void removeTokens(double tokens) {
        this.setTokens(this.getTokens() - tokens);
    }

    public boolean deleteFile() {
        return this.file.delete();
    }
}
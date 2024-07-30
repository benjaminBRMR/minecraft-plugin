package de.sprachlvs.skydrugs.apis.stats;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class DeathAPI {
    final File file = new File("plugins/System/stats/", "deaths.yml");
    final YamlConfiguration cfg;
    final String uuid;

    public DeathAPI(Player player) {
        this.cfg = YamlConfiguration.loadConfiguration(this.file);
        this.uuid = player.getUniqueId().toString();
    }

    public DeathAPI(UUID uuid) {
        this.cfg = YamlConfiguration.loadConfiguration(this.file);
        this.uuid = uuid.toString();
    }

    public DeathAPI(String uuid) {
        this.cfg = YamlConfiguration.loadConfiguration(this.file);
        this.uuid = uuid;
    }

    public Long getDeaths() {
        return this.cfg.getLong(this.uuid);
    }

    public void setDeaths(Long amount) {
        if (amount < 0L) {
            amount = 0L;
        }

        this.cfg.set(this.uuid, amount);

        try {
            this.cfg.save(this.file);
        } catch (IOException var3) {
        }

    }

    public void addDeaths(Long amount) {
        this.setDeaths(this.getDeaths() + amount);
    }

    public void remDeaths(Long amount) {
        this.setDeaths(this.getDeaths() - amount);
    }
}


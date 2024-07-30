package de.sprachlvs.skydrugs.apis.stats;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class KillAPI {
    final File file = new File("plugins/System/stats/", "kills.yml");
    final YamlConfiguration cfg;
    final String uuid;

    public KillAPI(Player player) {
        this.cfg = YamlConfiguration.loadConfiguration(this.file);
        this.uuid = player.getUniqueId().toString();
    }

    public KillAPI(UUID uuid) {
        this.cfg = YamlConfiguration.loadConfiguration(this.file);
        this.uuid = uuid.toString();
    }

    public KillAPI(String uuid) {
        this.cfg = YamlConfiguration.loadConfiguration(this.file);
        this.uuid = uuid;
    }

    public Long getKills() {
        return this.cfg.getLong(this.uuid);
    }

    public void setKills(Long amount) {
        if (amount < 0L) {
            amount = 0L;
        }

        this.cfg.set(this.uuid, amount);

        try {
            this.cfg.save(this.file);
        } catch (IOException var3) {
        }

    }

    public void addKills(Long amount) {
        this.setKills(this.getKills() + amount);
    }

    public void removeKills(Long amount) {
        this.setKills(this.getKills() - amount);
    }
}


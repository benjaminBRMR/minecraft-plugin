package de.sprachlvs.skydrugs.apis;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class CounterAPI {

    public static int getPlayerCount() {
        final File playerFile = new File("plugins/System/counter/anzahl.yml");
        final YamlConfiguration cfg = YamlConfiguration.loadConfiguration(playerFile);
        return cfg.getInt("Anzahl");
    }

    public static void addPlayercount(final int amount) {
        final File playerFile = new File("plugins/System/counter/anzahl.yml");
        final YamlConfiguration cfg = YamlConfiguration.loadConfiguration(playerFile);
        cfg.set("Anzahl", (Object)(cfg.getInt("Anzahl") + amount));
        try {
            cfg.save(playerFile);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

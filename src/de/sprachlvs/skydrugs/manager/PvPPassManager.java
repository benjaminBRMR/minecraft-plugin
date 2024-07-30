package de.sprachlvs.skydrugs.manager;

import de.sprachlvs.skydrugs.apis.ConfigAPI;

import java.util.UUID;

public class PvPPassManager {

    public static ConfigAPI configAPI;

    static {
        configAPI = new ConfigAPI("plugins/System/pvppass/", "config.yml");
    }

    /*

        sprachlvs:
        Stufe: 1
        Status_1: true


     */


    /*

        new PvPPassManager().setStufe(player, 1, true);


     */

    public void setStufe(UUID uuid, int stufe) {
        configAPI.getConfig().set(uuid + ".stufe", stufe);
        configAPI.getConfig().set(uuid + ".status", false); //iommer auf false wenn stufe erhöht, wenn abgeholt einfach setStufe(UUID, getStufe()+1);
        for (int i = stufe; i > 0; i--) configAPI.getConfig().set(uuid + ".status_" + stufe, true);
        configAPI.saveConfig();
    }

    public boolean getStufe(UUID uuid, int stufe) {
        return configAPI.getConfig().getBoolean(uuid + ".status_" + stufe);
    }
}

package de.sprachlvs.skydrugs.apis;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PerkAPI {

    final Player player;
    static final ConfigAPI cfg;

    static {
        cfg = new ConfigAPI("plugins/System/perks/", "config.yml");
    }


    public PerkAPI(final Player player) {
        this.player = player;
    }

    /*
        GEBE EINEM SPIELER DAS PERK ( KAUF )
     */
    public void setPerk(PerkEnum perkEnum, Boolean mode) {
        cfg.getConfig().set(player.getUniqueId() + ".Perk" + "." + perkEnum.name() + ".Gekauft", mode);
        cfg.saveConfig();
    }


    /*
        HAT DER SPIELER DAS PERK?
     */
    public boolean hasPerk(PerkEnum perkEnum) {
        if (cfg.getConfig().get(player.getUniqueId() + ".Perk" + "." + perkEnum.name()) == null) {
            cfg.getConfig().get(player.getUniqueId() + ".Perk" + "." + perkEnum.name(), false);
            cfg.saveConfig();
            return false;
        } else {
            return cfg.getConfig().getBoolean(player.getUniqueId() + ".Perk" + "." + perkEnum.name() + ".Gekauft");
        }
    }

    public String hasPerkColored(PerkEnum perkEnum) {
        if (cfg.getConfig().get(player.getUniqueId() + ".Perk" + "." + perkEnum.name()) == null) {
            cfg.getConfig().get(player.getUniqueId() + ".Perk" + "." + perkEnum.name(), false);
            cfg.saveConfig();
            return "§c§l✘";
        } else {
            return "§a§l✔";
        }
    }

    /*
        SETZE PERK STATUS
    */
    public void setPerkStatus(PerkEnum perkEnum, Boolean status) {
        if (hasPerk(perkEnum)) {
            cfg.getConfig().set(player.getUniqueId() + ".Perk" + "." + perkEnum.name() + ".Status", status);
            cfg.saveConfig();
        }
    }

    /*
        GETTE DEN PERK STATUS
     */
    public boolean getPerkStatus(PerkEnum perkEnum) {
        if (hasPerk(perkEnum)) {
            return cfg.getConfig().getBoolean(player.getUniqueId() + ".Perk" + "." + perkEnum.name() + ".Status");
        } else {
            return false;
        }
    }

    public String getPerkStatusColored(PerkEnum perkEnum) {
        if (hasPerk(perkEnum)) {
            if (getPerkStatus(perkEnum)) {
                return "§a§lAKTIVIERT";
            } else {
                return "§c§lDEAKTIVIERT";
            }
        } else {
            return "§cNicht im Besitz§8.";
        }
    }


    /*
        SYNCT DIE PERKS VON DEM SPIELER
     */
    public void syncPerks() {


        for (PotionEffect effect : player.getActivePotionEffects()) {
            player.removePotionEffect(effect.getType());
        }



        if (getPerkStatus(PerkEnum.JUMPBOOST)) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, Integer.MAX_VALUE, 0, true, false));
        }

        if (getPerkStatus(PerkEnum.NACHTSICHT)) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, Integer.MAX_VALUE, 0, true, false));
        }

        if (getPerkStatus(PerkEnum.SPEEDEINS)) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 0, true, false));
        } else if(getPerkStatus(PerkEnum.SPEEDZWEI)) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1, true, false));

        }


        if (getPerkStatus(PerkEnum.STAERKEEINS)) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 0, true, false));
        } else if(getPerkStatus(PerkEnum.STAERKEZWEI)) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 1, true, false));
        }

    }
}

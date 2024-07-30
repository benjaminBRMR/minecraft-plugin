package de.sprachlvs.skydrugs.apis;

import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

public enum PerkEnum {

    JUMPBOOST(PotionType.JUMP),
    NACHTSICHT(PotionType.NIGHT_VISION),

    SPEEDEINS(PotionType.SPEED),
    SPEEDZWEI(PotionType.SPEED),

    STAERKEEINS(PotionType.STRENGTH),
    STAERKEZWEI(PotionType.STRENGTH),

    NOHUNGER(null);

    private PotionType potionType;

    PerkEnum(PotionType potionType) {
        this.potionType = potionType;
    }

    public PotionEffectType getPotionType() {
        return PotionEffectType.getByName(potionType.name());
    }

    public void setPotionType(PotionType potionType) {
        this.potionType = potionType;
    }
}


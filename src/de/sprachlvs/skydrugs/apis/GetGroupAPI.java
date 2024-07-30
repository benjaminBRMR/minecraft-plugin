package de.sprachlvs.skydrugs.apis;

import org.bukkit.entity.Player;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class GetGroupAPI {

    public static String getGroupScoreboard(Player player) {

        if (PermissionsEx.getUser(player).inGroup("Owner")) {
            return "§4Owner";
        }

        if (PermissionsEx.getUser(player).inGroup("Admin")) {
            return "§cAdmin";
        }

        if (PermissionsEx.getUser(player).inGroup("Developer")) {
            return "§bDeveloper";
        }

        if (PermissionsEx.getUser(player).inGroup("SrModerator")) {
            return "§cSrMod";
        }

        if (PermissionsEx.getUser(player).inGroup("Moderator")) {
            return "§3Mod";
        }

        if (PermissionsEx.getUser(player).inGroup("Supporter")) {
            return "§aSup";
        }

        if (PermissionsEx.getUser(player).inGroup("Content")) {
            return "§eContent";
        }

        if (PermissionsEx.getUser(player).inGroup("Creator")) {
            return "§5Creator";
        }

        if (PermissionsEx.getUser(player).inGroup("Booster")) {
            return "§dBooster";
        }

        if (PermissionsEx.getUser(player).inGroup("Salvia")) {
            return "§5Salvia";
        }

        if (PermissionsEx.getUser(player).inGroup("Ephedra")) {
            return "§cEphedra";
        }

        if (PermissionsEx.getUser(player).inGroup("Opiat")) {
            return "§bOpiat";
        }

        if (PermissionsEx.getUser(player).inGroup("Valium")) {
            return "§6Valium";
        }

        if (PermissionsEx.getUser(player).inGroup("Kavain")) {
            return "§eKavain";
        }

        return "§7Spieler";
    }
}

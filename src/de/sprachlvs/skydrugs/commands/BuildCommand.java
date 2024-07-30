package de.sprachlvs.skydrugs.commands;

import de.sprachlvs.skydrugs.SkyDrugs;
import de.sprachlvs.skydrugs.listener.PlayerBlockListener;
import de.sprachlvs.skydrugs.manager.PrefixManager;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class BuildCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if (!(sender instanceof Player)) {

            sender.sendMessage(PrefixManager.BUILD + "§7Du musst ein Spieler sein§8!");
        } else {

            final Player player = (Player) sender;
            if (PermissionsEx.getUser(player).inGroup("Admin") || PermissionsEx.getUser(player).inGroup("Owner")) {


                if (PlayerBlockListener.buildmode.contains(player)) {

                    PlayerBlockListener.buildmode.remove(player);
                    player.setGameMode(GameMode.SURVIVAL);
                    player.playSound(player.getLocation(), Sound.ENDERMAN_TELEPORT, 100, 14);
                    player.sendMessage(PrefixManager.BUILD + "§7Dein Baumodus wurde §cdeaktiviert§8.");
                } else {

                    PlayerBlockListener.buildmode.add(player);
                    player.playSound(player.getLocation(), Sound.ENDERMAN_TELEPORT, 100, 14);
                    player.sendMessage(PrefixManager.BUILD + "§7Dein Baumodus wurde §aaktiviert§8.");
                    player.setGameMode(GameMode.CREATIVE);
                }
            } else {
                player.sendMessage(SkyDrugs.NOPERM);
            }
        }
        return false;
    }
}

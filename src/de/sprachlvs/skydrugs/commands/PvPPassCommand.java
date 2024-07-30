package de.sprachlvs.skydrugs.commands;

import de.sprachlvs.skydrugs.SkyDrugs;
import de.sprachlvs.skydrugs.inventorys.PvPPassGUI;
import de.sprachlvs.skydrugs.manager.PrefixManager;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PvPPassCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if (!(sender instanceof Player)) {

            sender.sendMessage(SkyDrugs.PREFIX + "§7Du musst ein Spieler sein§8!");
        } else {

            final Player player = (Player)sender;

            player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 100, 14);
            player.sendMessage(PrefixManager.PVP_PASS + "§7Der §ePvP§8-§ePass §7wurde geöffnet§8.");
            PvPPassGUI.openPvPPassInventorySite1(player);
        }
        return false;
    }
}

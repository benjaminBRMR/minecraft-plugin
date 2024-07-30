package de.sprachlvs.skydrugs.commands;

import de.sprachlvs.skydrugs.inventorys.PerkGUI;
import de.sprachlvs.skydrugs.manager.PrefixManager;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PerkCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if(sender instanceof Player) {
            final Player player = (Player)sender;

            PerkGUI.openPerkSeite1(player);
            player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 100, 14);
            player.sendMessage(PrefixManager.PERKS + "§7Das §cPerks-Inventar §7wurde geöffnet§8.");

        }
        return false;
    }
}

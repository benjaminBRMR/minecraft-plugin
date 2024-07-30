package de.sprachlvs.skydrugs.commands;

import de.sprachlvs.skydrugs.SkyDrugs;
import de.sprachlvs.skydrugs.utils.SpawnUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String args, String[] strings) {


        if (!(sender instanceof Player)) {

            sender.sendMessage(SkyDrugs.PREFIX + "§7Du musst ein Spieler sein§8!");
        } else {
            final Player player = (Player)sender;
            new SpawnUtils(player).start();
        }

        return false;


    }
}

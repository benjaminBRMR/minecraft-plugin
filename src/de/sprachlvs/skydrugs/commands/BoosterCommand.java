package de.sprachlvs.skydrugs.commands;

import de.sprachlvs.skydrugs.SkyDrugs;
import de.sprachlvs.skydrugs.manager.PrefixManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BoosterCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (!(sender instanceof Player)) {

            sender.sendMessage(SkyDrugs.PREFIX + "§7Du musst ein Spieler sein§8!");
        } else {
            Player player = (Player)sender;

            player.sendMessage(SkyDrugs.getHeader("§d§lBOOSTER"));
            player.sendMessage("§8");
            player.sendMessage(PrefixManager.BOOSTER + "§7Durch das §d§lBOOSTEN§7 unseres Discord Servers§8, ");
            player.sendMessage(PrefixManager.BOOSTER + "§7bekommst du §d§LKRASSE BELOHNUNGEN§8!");
            player.sendMessage("§8");
            player.sendMessage(PrefixManager.BOOSTER + "§7Liste aller §d§lBELOHNUNGEN§8:");
            player.sendMessage("§8");
            player.sendMessage(PrefixManager.BOOSTER + "§d§LBOOSTER §7RANG bis dein §dBoost§7 abläuft§8!");
            player.sendMessage(PrefixManager.BOOSTER + "§d1§8x §4Admin §7Schlüssel");
            player.sendMessage(PrefixManager.BOOSTER + "§d8§8x §bLeuchtfeuer");
            player.sendMessage(PrefixManager.BOOSTER + "§d4§8x §4Mystic §7Schlüssel");
            player.sendMessage(PrefixManager.BOOSTER + "§d4§8x §4Spawner §7Schlüssel");
            player.sendMessage(PrefixManager.BOOSTER + "§d16§8x §9Selten §7Schlüssel");
            player.sendMessage("§8");
            player.sendMessage(SkyDrugs.getHeader("§d§lBOOSTER"));

        }
        return false;
    }
}

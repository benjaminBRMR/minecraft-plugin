package de.sprachlvs.skydrugs.commands;

import de.sprachlvs.skydrugs.SkyDrugs;
import de.sprachlvs.skydrugs.apis.ConfigAPI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class LeaveMSGCommand implements CommandExecutor, Listener {

    @EventHandler
    public void onJoin(final PlayerQuitEvent e) {
        final Player player = e.getPlayer();

        if(getQuitMsg(player) != null) {
            e.setQuitMessage("§8»│ §c§lLEAVE §8▰§7▱" + getQuitMsg(player).replaceAll("&", "§"));
        }
    }


    static final ConfigAPI cfg;

    static {
        cfg = new ConfigAPI("plugins/System/joinleavemsg/", "leave.yml");
    }

    private String getQuitMsg(Player player) {
        return cfg.getConfig().getString(player.getUniqueId() + ".QuitMsg");
    }

    private void setQuitMsg(Player player, String message) {
        cfg.getConfig().set(player.getUniqueId() + ".QuitMsg", message);
        cfg.saveConfig();
    }


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if(sender instanceof Player) {
            final Player player = (Player) sender;


            if (PermissionsEx.getUser(player).inGroup("Salvia") || PermissionsEx.getUser(player).inGroup("Booster") || PermissionsEx.getUser(player).inGroup("Creator") || PermissionsEx.getUser(player).inGroup("Content") || PermissionsEx.getUser(player).inGroup("Supporter") || PermissionsEx.getUser(player).inGroup("Moderator") || PermissionsEx.getUser(player).inGroup("SrModerator") || PermissionsEx.getUser(player).inGroup("Developer") || PermissionsEx.getUser(player).inGroup("Admin") || PermissionsEx.getUser(player).inGroup("Owner")) {

                if(args.length >= 1) {

                    if(args[0].equalsIgnoreCase("clear") || args[0].equalsIgnoreCase("delete")) {

                        setQuitMsg(player, null);
                        player.sendMessage("§8»│ §c§lLEAVE §8▰§7▱ " + "§7Deine Leavemessage wurde §aerfolgreich §7entfernt§8.");

                    } else {
                        String m = "";

                        for (int i = 0; i < args.length; ++i) {
                            m = m + " " + args[i];
                        }

                        setQuitMsg(player, m);
                        player.sendMessage("§8»│ §c§lLEAVE §8▰§7▱ " + "§7Deine Leavemessage wurde erfolgreich geändert§8.");
                        player.sendMessage("§8»│ §c§lLEAVE §8▰§7▱ " + m.replaceAll("&", "§"));
                    }
                } else {
                    player.sendMessage("§8»│ §c§lLEAVE §8▰§7▱ " + "§7Syntax§8: /§cleavemsg §8<§7nachricht§8>");
                    player.sendMessage("§8»│ §c§lLEAVE §8▰§7▱ "+ "§7Syntax§8: /§cleavemsg clear");
                }
            } else {
                player.sendMessage(SkyDrugs.NOPERM);
            }
        }
        return false;
    }
}

package de.sprachlvs.skydrugs.listener;

import de.sprachlvs.skydrugs.SkyDrugs;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class SignChangeListener implements Listener {

    @EventHandler
    public void onSignChange(final org.bukkit.event.block.SignChangeEvent e) {

        final String[] line = e.getLines();
        final Player player = e.getPlayer();
        final ItemStack item;

        final String[] message = new String[0];


        if(PermissionsEx.getUser(player).inGroup("Owner")) {
            if (line[0].equalsIgnoreCase("Free")) {

                if(line[2] == null || line[3] == null || e.getLine(2).isEmpty() || e.getLine(3).isEmpty()) {

                    line[0] = "FREE"; // TOP
                    line[1] = ""; // EMPTY
                    line[2] = "ID"; // ID
                    line[3] = "AMOUNT"; // AMOUNT



                    player.sendMessage(SkyDrugs.PREFIX + "§7Fehler§8, §7bitte erstelle das Schild wie gezeigt§8.");
                    player.playSound(player.getLocation(), Sound.VILLAGER_NO, 1.5F, 14.8F);

                } else {


                    line[0] = "§8»│ §a§lFREE ITEMS"; // TOP
                    line[1] = "§7§oklick mich"; // EMPTY
                    line[2] = String.valueOf("§8► §a" + line[2] + " §8◄"); // ID
                    line[3] = String.valueOf("§8► §a" + Integer.parseInt(line[3]) + " §8◄"); // AMOUNT
                }
            }
        }
    }
}

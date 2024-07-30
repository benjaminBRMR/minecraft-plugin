package de.sprachlvs.skydrugs.crashfix;

import de.sprachlvs.skydrugs.SkyDrugs;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class MessageFix implements Listener {
    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        boolean asd = false;
        String a = e.getMessage();
        char[] charArray;
        for (int length = (charArray = a.toCharArray()).length, i = 0; i < length; i++) {
            char c = charArray[i];
            if ((c < 'a' || c > 'z') && (
                    c < 'A' || c > 'Z') && c != ':' && c != ',' && c != '.' && c != '\'' && c != '*' && c != '+' && c != '~' && c != '-' && c != '|' && c != '>' && c != '<' && c != '^' && c != '?' && c != '=' && c != ')' && c != '(' && c != '%' && c != '$' && c != '"' && c != '!' && c != '&' && c != ' ' && c != '/' && c != '§' && c != '_' && c != '1' && c != '2' && c != '3' && c != '4' && c != '5' && c != '6' && c != '7' && c != '8' && c != '9' && c != '0' && c != 'ö' && c != '@' && c != 'ä' && c != '#' && c != 'Ä' && c != 'Ö' && c != 'ü' && c != 'Ü' && c != 'ß') {
                if (!e.getPlayer().isOp()) {
                    e.setCancelled(true);
                    asd = true;
                }
            }
        }
        if (asd)
            if (!e.getPlayer().isOp())
                e.getPlayer().sendMessage(SkyDrugs.PREFIX + "§cDu darfst keine Sonderzeichen benutzen.");
    }
}

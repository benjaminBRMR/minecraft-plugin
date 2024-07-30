package de.sprachlvs.skydrugs.apis;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;

public class TextHoverAPI {

    public static void HoverURL(Player player, String message, String link, String hoverlore){

        final TextComponent tcan = new TextComponent();
        tcan.setText(message);
        tcan.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, (link)));
        tcan.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(hoverlore).create()));
        player.spigot().sendMessage(tcan);

    }

    public static void HoverCommand(Player player, String message, String command, String hoverlore){

        final TextComponent tcan = new TextComponent();
        tcan.setText(message);
        tcan.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, (command)));
        tcan.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(hoverlore).create()));
        player.spigot().sendMessage(tcan);

    }
}

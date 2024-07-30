package de.sprachlvs.skydrugs.listener;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.UUID;

public class PlayerChangeCoinEvent extends Event {

    private final UUID uuid;
    public static HandlerList HANDLER_LIST = new HandlerList();

    public PlayerChangeCoinEvent(UUID uuid) {
        this.uuid = uuid;
        //System.out.println("[SKYDRUGS] PlayerChangeCoinEvent > " + uuid.toString());
    }

    public HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLER_LIST;
    }

    public UUID getUniqueId() {
        return uuid;
    }

}
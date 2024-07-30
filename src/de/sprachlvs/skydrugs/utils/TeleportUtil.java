package de.sprachlvs.skydrugs.utils;

import de.sprachlvs.skydrugs.SkyDrugs;
import de.sprachlvs.skydrugs.manager.LocationManager;
import de.sprachlvs.skydrugs.manager.PrefixManager;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.Packet;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashMap;

public class TeleportUtil implements Listener {
    public static HashMap<Player, BukkitTask> countdown;
    private Player p;
    private int count;

    static {
        TeleportUtil.countdown = new HashMap<Player, BukkitTask>();
    }

    public TeleportUtil(final Player p) {
        this.p = p;
        this.count = 3;
    }

    public void start(Location location) {
        if (TeleportUtil.countdown.containsKey(this.p)) {
            return;
        }
        if (!this.p.hasPermission("system.team")) {
            final BukkitTask task = Bukkit.getScheduler().runTaskTimer((Plugin) SkyDrugs.getInstance(), (Runnable) new Runnable() {
                @Override
                public void run() {
                    TeleportUtil.this.sendBar(TeleportUtil.this.count);
                    if (TeleportUtil.this.count == 0) {
                        TeleportUtil.this.p.teleport(location);
                        TeleportUtil.countdown.get(TeleportUtil.this.p).cancel();
                        TeleportUtil.countdown.remove(TeleportUtil.this.p);
                        if (!TeleportUtil.this.p.isOp()) {
                            TeleportUtil.this.p.setAllowFlight(false);
                            TeleportUtil.this.p.setFlying(false);
                        }
                        return;
                    }
                    final TeleportUtil this$0 = TeleportUtil.this;
                    TeleportUtil.access$3(this$0, this$0.count - 1);
                }
            }, 0L, 20L);
            TeleportUtil.countdown.put(this.p, task);
        } else {

            p.teleport(location);
            p.sendMessage(PrefixManager.WARP + "§7Du wurdest erfolgreich teleportiert§8.");
            p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1.5F, 8.5F);

            if (!this.p.hasPermission("system.team")) {
                this.p.setAllowFlight(false);
                this.p.setFlying(false);
            }
        }
    }

    public void stop() {
        if (!TeleportUtil.countdown.containsKey(this.p)) {
            return;
        }
        TeleportUtil.countdown.get(this.p).cancel();
        this.p.sendMessage(String.valueOf(PrefixManager.WARP) + "§cDie Teleportation wurde unterbrochen!");
        p.playSound(p.getLocation(), Sound.ANVIL_BREAK, 0.5F, 14.5F);
        TeleportUtil.countdown.remove(this.p);
    }

    private void sendBar(final int count) {
        String s = "";
        if (count == 1) {
            s = PrefixManager.WARP + "§7Du wirst in §c1 §7Sekunden teleportiert§8.";
            p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.5F, 8.5F);
        } else if (count == 0) {
            s = PrefixManager.WARP + "§7Du wurdest erfolgreich teleportiert§8.";
            p.teleport(LocationManager.getLocation("spawn"));
            p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1.5F, 8.5F);
        } else {
            s = PrefixManager.WARP + "§7Du wirst in §c" + count + " §7Sekunden teleportiert§8.";
            p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.5F, 8.5F);
        }
        p.sendMessage(s);
        //this.sendBar(this.p, s);
    }

    private void sendBar(final Player p, final String msg) {
        final IChatBaseComponent icbc = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + msg + "\"}");
        final PacketPlayOutChat bar = new PacketPlayOutChat(icbc, (byte) 2);
        ((CraftPlayer) p).getHandle().playerConnection.sendPacket((Packet) bar);
    }

    @EventHandler
    public void onMove(final PlayerMoveEvent e) {
        if (e.getFrom().getBlockX() != e.getTo().getBlockX() || e.getFrom().getBlockY() != e.getTo().getBlockY() || e.getFrom().getBlockZ() != e.getTo().getBlockZ()) {
            new TeleportUtil(e.getPlayer()).stop();
        }
    }

    @EventHandler
    public void onDmg(final EntityDamageEvent e) {
        if (e.getEntityType() == EntityType.PLAYER) {
            new TeleportUtil((Player) e.getEntity()).stop();
        }
    }

    static /* synthetic */ void access$3(final TeleportUtil TeleportUtil, final int count) {
        TeleportUtil.count = count;
    }
}

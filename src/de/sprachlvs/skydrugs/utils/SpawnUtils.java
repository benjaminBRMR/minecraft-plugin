package de.sprachlvs.skydrugs.utils;

import de.sprachlvs.skydrugs.SkyDrugs;
import de.sprachlvs.skydrugs.manager.LocationManager;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.Packet;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import org.bukkit.Bukkit;
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
import ru.tehkode.permissions.bukkit.PermissionsEx;

import java.util.HashMap;

public class SpawnUtils implements Listener {
    public static HashMap<Player, BukkitTask> countdown;
    private Player p;
    private int count;

    static {
        SpawnUtils.countdown = new HashMap<Player, BukkitTask>();
    }

    public SpawnUtils(final Player p) {
        this.p = p;
        this.count = 3;
    }

    public void start() {
        if (SpawnUtils.countdown.containsKey(this.p)) {
            return;
        }
        if (!PermissionsEx.getUser(p).inGroup("Content") || PermissionsEx.getUser(p).inGroup("Supporter") || PermissionsEx.getUser(p).inGroup("Moderator") || PermissionsEx.getUser(p).inGroup("SrModerator") || PermissionsEx.getUser(p).inGroup("Developer") || PermissionsEx.getUser(p).inGroup("Admin") || PermissionsEx.getUser(p).inGroup("Owner")) {
            final BukkitTask task = Bukkit.getScheduler().runTaskTimer((Plugin) SkyDrugs.getInstance(), (Runnable) new Runnable() {
                @Override
                public void run() {
                    SpawnUtils.this.sendBar(SpawnUtils.this.count);
                    if (SpawnUtils.this.count == 0) {
                        SpawnUtils.this.p.teleport(LocationManager.getLocation("spawn"));
                        SpawnUtils.countdown.get(SpawnUtils.this.p).cancel();
                        SpawnUtils.countdown.remove(SpawnUtils.this.p);
                        if (!SpawnUtils.this.p.isOp()) {
                            SpawnUtils.this.p.setAllowFlight(false);
                            SpawnUtils.this.p.setFlying(false);
                        }
                        return;
                    }
                    final SpawnUtils this$0 = SpawnUtils.this;
                    SpawnUtils.access$3(this$0, this$0.count - 1);
                }
            }, 0L, 20L);
            SpawnUtils.countdown.put(this.p, task);
        } else {
            p.teleport(LocationManager.getLocation("spawn"));
            p.sendMessage(SkyDrugs.PREFIX + "§7Du wurdest zum §dSpawn §7teleportiert§8.");
            p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1.5F, 14.5F);

            if (!PermissionsEx.getUser(p).inGroup("Salvia") || !PermissionsEx.getUser(p).inGroup("Booster") || !PermissionsEx.getUser(p).inGroup("Creator") || !PermissionsEx.getUser(p).inGroup("Content") || !PermissionsEx.getUser(p).inGroup("Supporter") || !PermissionsEx.getUser(p).inGroup("Moderator") || !PermissionsEx.getUser(p).inGroup("SrModerator") || !PermissionsEx.getUser(p).inGroup("Developer") || !PermissionsEx.getUser(p).inGroup("Admin") || !PermissionsEx.getUser(p).inGroup("Owner")) {
                this.p.setAllowFlight(false);
                this.p.setFlying(false);
            } else {
                this.p.setAllowFlight(true);
                this.p.setFlying(true);
            }
        }
    }

    public void stop() {
        if (!SpawnUtils.countdown.containsKey(this.p)) {
            return;
        }
        SpawnUtils.countdown.get(this.p).cancel();
        this.p.sendMessage(String.valueOf(SkyDrugs.PREFIX) + "§7Die Teleportation wurde unterbrochen§8!");
        SoundUtils.playUnsuccessSound(p);
        SpawnUtils.countdown.remove(this.p);
    }

    private void sendBar(final int count) {
        String s = "";
        if (count == 1) {
            s = SkyDrugs.PREFIX + "§7Du wirst in §d1 §7Sekunden teleportiert§8.";
            p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.5F, 8.5F);
        } else if (count == 0) {
            s = SkyDrugs.PREFIX + "§7Du wurdest zum §dSpawn §7teleportiert§8.";
            p.teleport(LocationManager.getLocation("spawn"));
            p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1.5F, 8.5F);
        } else {
            s = SkyDrugs.PREFIX + "§7Du wirst in §d" + count + " §7Sekunden teleportiert§8.";
            p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.5F, 8.5F);
            sendBar(p, "§8» §cEine Bewegung unterbricht die Teleportierung§8.");
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
            new SpawnUtils(e.getPlayer()).stop();
        }
    }

    @EventHandler
    public void onDmg(final EntityDamageEvent e) {
        if (e.getEntityType() == EntityType.PLAYER) {
            new SpawnUtils((Player) e.getEntity()).stop();
        }
    }

    static void access$3(final SpawnUtils SpawnUtils, final int count) {
        SpawnUtils.count = count;
    }
}


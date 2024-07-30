package de.sprachlvs.skydrugs.utils;

import de.sprachlvs.skydrugs.manager.PrefixManager;
import io.netty.util.internal.ThreadLocalRandom;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.Packet;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import net.minecraft.server.v1_8_R3.PlayerConnection;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;
import ru.tehkode.permissions.bukkit.PermissionsEx;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class GeneralUtils {

    static Random random = new Random();
    public static Random PUBLIC_RANDOM = new Random();
    public static final Random randomm = ThreadLocalRandom.current();

    public static void clearChatAll() {
        {
            for (int i = 0; i < 256; i++) Bukkit.broadcastMessage("§r");
        }
    }

    public static void sendTitle(Player player, Integer fadeIn, Integer stay, Integer fadeOut, String title, String subtitle) {
        PlayerConnection connection = (((CraftPlayer) player).getHandle()).playerConnection;
        PacketPlayOutTitle packetPlayOutTimes = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TIMES, null, fadeIn.intValue(), stay.intValue(), fadeOut.intValue());
        connection.sendPacket((Packet) packetPlayOutTimes);
        if (subtitle != null) {
            subtitle = subtitle.replaceAll("%player%", player.getDisplayName());
            subtitle = ChatColor.translateAlternateColorCodes('&', subtitle);
            IChatBaseComponent titleSub = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + subtitle + "\"}");
            PacketPlayOutTitle packetPlayOutSubTitle = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE, titleSub);
            connection.sendPacket((Packet) packetPlayOutSubTitle);
        }
        if (title != null) {
            title = title.replaceAll("%player%", player.getDisplayName());
            title = ChatColor.translateAlternateColorCodes('&', title);
            IChatBaseComponent titleMain = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + title + "\"}");
            PacketPlayOutTitle packetPlayOutTitle = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, titleMain);
            connection.sendPacket((Packet) packetPlayOutTitle);
        }
    }

    public static String getFormated(int amount) {
        final DecimalFormat decimalFormat = new DecimalFormat("###,###.###");
        return decimalFormat.format(amount).replace(",", "§8'§e");
    }

    public static void addItem(Player p, ItemStack item) {
        if (p.getInventory().firstEmpty() == -1) {
            p.getWorld().dropItemNaturally(p.getLocation(), item);
        } else {
            p.getInventory().addItem(item);
        }
    }

    public static int getDifference(int number1, int number2) {

        if(number1 < number2) {
            return number2 - number1;
        } else {
            return number1 - number2;
        }

    }

    public static Player getRandomPlayer(Player senderOfRequest, boolean noTeammembers) {
        CopyOnWriteArrayList<Player> players = new CopyOnWriteArrayList<>();
        if (noTeammembers) {
            for (Player all : Bukkit.getOnlinePlayers()) {
                if (PermissionsEx.getUser(all).inGroup("Kavain") || PermissionsEx.getUser(all).inGroup("Valium") || PermissionsEx.getUser(all).inGroup("Opiat") || PermissionsEx.getUser(all).inGroup("Ephedra") || PermissionsEx.getUser(all).inGroup("Salvia") || PermissionsEx.getUser(all).inGroup("Booster") || PermissionsEx.getUser(all).inGroup("Creator")) {
                    players.add(all);
                }
            }
            if (players.size() == 0) {
                senderOfRequest.sendMessage(PrefixManager.EVENT + "§cDiese Aktion kann derzeit nicht ausgeführt werden§8.");
                return null;
            }
            int index = random.nextInt(players.size());
            return players.get(index);
        } else {
            for (Player all : Bukkit.getOnlinePlayers()) {
                if (PermissionsEx.getUser(all).inGroup("Kavain") || PermissionsEx.getUser(all).inGroup("Valium") || PermissionsEx.getUser(all).inGroup("Opiat") || PermissionsEx.getUser(all).inGroup("Ephedra") || PermissionsEx.getUser(all).inGroup("Salvia") || PermissionsEx.getUser(all).inGroup("Booster") || PermissionsEx.getUser(all).inGroup("Creator") || PermissionsEx.getUser(all).inGroup("Supporter") || PermissionsEx.getUser(all).inGroup("Moderator") || PermissionsEx.getUser(all).inGroup("SrModerator")) {
                    players.add(all);
                }
            }
            int index = random.nextInt(players.size());
            return players.get(index);
        }
    }

    public static Vector getRandomVector() {
        double d1 = randomm.nextDouble() * 2.0D - 1.0D;
        double d2 = randomm.nextDouble() * 2.0D - 1.0D;
        double d3 = randomm.nextDouble() * 2.0D - 1.0D;
        return new Vector(d1, d2, d3).normalize();
    }

    public static Vector getRandomFlatVector() {
        double d1 = randomm.nextDouble() * 2.0D - 1.0D;
        double d2 = randomm.nextDouble() * 2.0D - 1.0D;
        return new Vector(d1, 0.0D, d2);
    }

    public static Vector getRandomCircleVector() {
        double d1 = randomm.nextDouble() * 2.0D * Math.PI;
        double d2 = Math.cos(d1);
        double d3 = Math.sin(d1);
        return new Vector(d2, 0.0D, d3);
    }

    public static Material getRandomMaterial(Material[] paramArrayOfMaterial) {
        return paramArrayOfMaterial[randomm.nextInt(paramArrayOfMaterial.length)];
    }

    public static double getRandomAngle() {
        return randomm.nextDouble() * 2.0D * Math.PI;
    }

    public static boolean checkProbability(double paramDouble) {
        return (paramDouble >= 1.0D || randomm.nextDouble() < paramDouble);
    }
}

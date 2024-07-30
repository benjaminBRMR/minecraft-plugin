package de.sprachlvs.skydrugs.inventorys;

import de.sprachlvs.skydrugs.SkyDrugs;
import de.sprachlvs.skydrugs.apis.EventAPI;
import de.sprachlvs.skydrugs.manager.ItemManager;
import de.sprachlvs.skydrugs.manager.PrefixManager;
import de.sprachlvs.skydrugs.utils.SoundUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import ru.tehkode.permissions.bukkit.PermissionsEx;

import javax.annotation.Nonnull;

import static de.sprachlvs.skydrugs.utils.InventoryUtils.fill;
import static de.sprachlvs.skydrugs.utils.InventoryUtils.fillBorders;

public class RankEventGUI implements Listener {

    static Inventory inventory;

    public static Inventory getInventory() {
        return inventory;
    }

    public static void openGUI(@Nonnull Player player) {
        inventory = Bukkit.createInventory(null, 27, PrefixManager.EVENT + "§cRänge");

        fill(getInventory(), new ItemManager(Material.STAINED_GLASS_PANE).setData(7).setName("§8-/-§r").build());
        fillBorders(getInventory(), new ItemManager(Material.STAINED_GLASS_PANE).setData(0).setName("§8-/-§r").build());

        inventory.setItem(15, new ItemManager(Material.STAINED_CLAY).setData(11).setName("§8»│ §5§lRANG §8▰§7▱ §5Salvia").build());
        inventory.setItem(14, new ItemManager(Material.STAINED_CLAY).setData(14).setName("§8»│ §5§lRANG §8▰§7▱ §cEphedra").build());
        inventory.setItem(13, new ItemManager(Material.STAINED_CLAY).setData(3).setName("§8»│ §5§lRANG §8▰§7▱ §bOpiat").build());
        inventory.setItem(12, new ItemManager(Material.STAINED_CLAY).setData(4).setName("§8»│ §5§lRANG §8▰§7▱ §6Valium").build());
        inventory.setItem(11, new ItemManager(Material.STAINED_CLAY).setData(4).setName("§8»│ §5§lRANG §8▰§7▱ §eKavain").build());
        inventory.setItem(18, SkyDrugs.zurück);

        player.openInventory(inventory);
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        final Player player = (Player) event.getWhoClicked();
        if (event.getInventory().getName().equalsIgnoreCase(PrefixManager.EVENT + "§cRänge")) {
            event.setCancelled(true);
            int clickedSlot = event.getRawSlot();
            if (clickedSlot == 15) {
                if (EventAPI.eventstatus) {
                    EventAPI.getRangverlosungEvent().start(player, PermissionsEx.getPermissionManager().getGroup("Salvia"));
                } else {
                    player.sendMessage(PrefixManager.EVENT + "§7Aktiviere zuerst den §fEvent-Status§8!");
                    SoundUtils.playUnsuccessSound(player);
                }
            } else if (clickedSlot == 14) {
                if (EventAPI.eventstatus) {
                    EventAPI.getRangverlosungEvent().start(player, PermissionsEx.getPermissionManager().getGroup("Ephedra"));
                } else {
                    player.sendMessage(PrefixManager.EVENT + "§7Aktiviere zuerst den §fEvent-Status§8!");
                    SoundUtils.playUnsuccessSound(player);
                }
            } else if (clickedSlot == 13) {
                if (EventAPI.eventstatus) {
                    EventAPI.getRangverlosungEvent().start(player, PermissionsEx.getPermissionManager().getGroup("Opiat"));
                } else {
                    player.sendMessage(PrefixManager.EVENT + "§7Aktiviere zuerst den §fEvent-Status§8!");
                    SoundUtils.playUnsuccessSound(player);
                }
            } else if (clickedSlot == 12) {
                if (EventAPI.eventstatus) {
                    EventAPI.getRangverlosungEvent().start(player, PermissionsEx.getPermissionManager().getGroup("Valium"));
                } else {
                    player.sendMessage(PrefixManager.EVENT + "§7Aktiviere zuerst den §fEvent-Status§8!");
                    SoundUtils.playUnsuccessSound(player);
                }
            } else if (clickedSlot == 11) {
                if (EventAPI.eventstatus) {
                    EventAPI.getRangverlosungEvent().start(player, PermissionsEx.getPermissionManager().getGroup("Kavain"));
                } else {
                    player.sendMessage(PrefixManager.EVENT + "§7Aktiviere zuerst den §fEvent-Status§8!");
                    SoundUtils.playUnsuccessSound(player);
                }
            }
        }
    }
}

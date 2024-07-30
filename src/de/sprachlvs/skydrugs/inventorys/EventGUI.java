package de.sprachlvs.skydrugs.inventorys;

import de.sprachlvs.skydrugs.apis.EventAPI;
import de.sprachlvs.skydrugs.listener.AsyncPlayerChatListener;
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

import javax.annotation.Nonnull;

import static de.sprachlvs.skydrugs.utils.InventoryUtils.fill;
import static de.sprachlvs.skydrugs.utils.InventoryUtils.fillBorders;

public class EventGUI implements Listener {

    static Inventory inventory;

    public static Inventory getInventory() {
        return inventory;
    }

    public static void openGUI(@Nonnull Player player) {
        inventory = Bukkit.createInventory(null, 27, PrefixManager.EVENT);

        fill(inventory, new ItemManager(Material.STAINED_GLASS_PANE).setData(7).setName("§8-/-§r").build());
        fillBorders(inventory, new ItemManager(Material.STAINED_GLASS_PANE).setData(0).setName("§8-/-§r").build());

        inventory.setItem(11, new ItemManager(Material.SIGN).setName("§8▰§7▱ §fGuessTheNumber Event").setLore(new String[]{
                "§r",
                "§r  §8▰§7▱ Startet ein §fGuessTheNumber Event§8.",
                "§r"
        }).build());
        inventory.setItem(13, new ItemManager(Material.SIGN).setName("§8▰§7▱ §fRangverlosung").setLore(new String[]{
                "§r",
                "§r  §8▰§7▱ Startet eine §fRangverlosung§8.",
                "§r"
        }).build());
        inventory.setItem(15, new ItemManager(Material.SIGN).setName("§8▰§7▱ §fTokenverlosung").setLore(new String[]{
                "§r",
                "§r  §8▰§7▱ Startet eine §fTokenverlosung§8.",
                "§r"
        }).build());

        if (EventAPI.eventstatus) {
            inventory.setItem(22, new ItemManager(Material.EMERALD).setGlowing().setName("§8▰§7▱ §fEventstatus§8: §aAktiv").build());
        } else
            inventory.setItem(22, new ItemManager(Material.EMERALD).setName("§8▰§7▱ §fEventstatus§8: §cInaktiv").build());

        player.openInventory(inventory);
    }


    @EventHandler
    public void onClick(final InventoryClickEvent event) {
        final Player player = (Player) event.getWhoClicked();
        if (event.getInventory().getName().equalsIgnoreCase(PrefixManager.EVENT)) {
            event.setCancelled(true);
            int clickedSlot = event.getRawSlot();
            if (clickedSlot == 13) {
                if (EventAPI.eventstatus) {
                    player.closeInventory();
                    RankEventGUI.openGUI(player);
                } else {
                    player.sendMessage(PrefixManager.EVENT + "§7Aktiviere zuerst den §fEvent-Status§8!");
                    SoundUtils.playUnsuccessSound(player);
                }
            } else if (clickedSlot == 11) {
                if (EventAPI.eventstatus) {
                    player.closeInventory();
                    AsyncPlayerChatListener.numberEvent.put(player, 1);
                    player.sendMessage(PrefixManager.EVENT + "§7Gebe die höchste Zahl im Chat ein§8.");
                    player.sendMessage(PrefixManager.EVENT + "§8'§ccancel§8' §7zum abbrechen§8.");
                } else {
                    player.sendMessage(PrefixManager.EVENT + "§7Aktiviere zuerst den §fEvent-Status§8!");
                    SoundUtils.playUnsuccessSound(player);
                }
            } else if (clickedSlot == 15) {
                if (EventAPI.eventstatus) {
                    player.closeInventory();
                    AsyncPlayerChatListener.tokenEvent.add(player);
                    player.sendMessage(PrefixManager.EVENT + "§7Gebe die Anzahl an Tokens im Chat ein§8.");
                    player.sendMessage(PrefixManager.EVENT + "§8'§ccancel§8' §7zum abbrechen§8.");
                } else {
                    player.sendMessage(PrefixManager.EVENT + "§7Aktiviere zuerst den §fEvent-Status§8!");
                    SoundUtils.playUnsuccessSound(player);
                }
            } else if (clickedSlot == 22 && event.getCurrentItem().getItemMeta().getDisplayName() == "§8▰§7▱ §fEventstatus§8: §aAktiv") {
                EventAPI.eventstatus = false;
                inventory.setItem(22, new ItemManager(Material.EMERALD).setName("§8▰§7▱ §fEventstatus§8: §cInaktiv").build());
                SoundUtils.playUnsuccessSound(player);
                player.sendMessage(PrefixManager.EVENT + "§7Der Event-Status wurde auf §8'§cInaktiv§8' §7gesetzt§8.");
            } else if (clickedSlot == 22 && event.getCurrentItem().getItemMeta().getDisplayName() == "§8▰§7▱ §fEventstatus§8: §cInaktiv") {
                EventAPI.eventstatus = true;
                inventory.setItem(22, new ItemManager(Material.EMERALD).setGlowing().setName("§8▰§7▱ §fEventstatus§8: §aAktiv").build());
                SoundUtils.playSuccessSound(player);
                player.sendMessage(PrefixManager.EVENT + "§7Der Event-Status wurde auf §8'§aAktiv§8' §7gesetzt§8.");
            }
        }
    }
}


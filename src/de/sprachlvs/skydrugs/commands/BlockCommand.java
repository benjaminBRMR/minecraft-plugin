package de.sprachlvs.skydrugs.commands;

import de.sprachlvs.skydrugs.SkyDrugs;
import de.sprachlvs.skydrugs.manager.ItemManager;
import de.sprachlvs.skydrugs.manager.ItemSkullManager;
import de.sprachlvs.skydrugs.manager.PrefixManager;
import de.sprachlvs.skydrugs.utils.InventoryUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class BlockCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if (PermissionsEx.getUser(player).inGroup("Salvia") || PermissionsEx.getUser(player).inGroup("Booster") || PermissionsEx.getUser(player).inGroup("Creator") || PermissionsEx.getUser(player).inGroup("Content") || PermissionsEx.getUser(player).inGroup("Supporter") || PermissionsEx.getUser(player).inGroup("Moderator") || PermissionsEx.getUser(player).inGroup("SrModerator") || PermissionsEx.getUser(player).inGroup("Developer") || PermissionsEx.getUser(player).inGroup("Admin") || PermissionsEx.getUser(player).inGroup("Owner")) {

                openMainGUI(player);
                player.sendMessage(PrefixManager.BLOCK + "§7Du hast das §9Hauptmenü §7vom Blockmenü geöffnet§8.");
            } else {
                player.sendMessage(SkyDrugs.NOPERM);
            }
        }
        return false;
    }

    public void openMainGUI(Player player) {
        Inventory inventory = Bukkit.createInventory(null, 36, PrefixManager.BLOCK + "§7Hub");

        InventoryUtils.fillBorders(inventory, new ItemManager(Material.STAINED_GLASS_PANE).setData(11).setName("§8-/-").build());
        InventoryUtils.fill(inventory, new ItemManager(Material.STAINED_GLASS_PANE).setData(3).setName("§8-/-").build());

        inventory.setItem(11, ItemSkullManager.getSkull(PrefixManager.BLOCK + "§7Seite 1", SkyDrugs.getBase64("GRASSBLOCK"), new String[] {
                "",
                " §8▰§7▱ §7Klicke§8, §7um die erste Seite zu öffnen§8.",
                ""
        }));

        inventory.setItem(22, ItemSkullManager.getSkull(PrefixManager.BLOCK + "§7Seite 2", SkyDrugs.getBase64("GRASSBLOCK"), new String[] {
                "",
                " §8▰§7▱ §7Klicke§8, §7um die zweite Seite zu öffnen§8.",
                ""
        }));

        inventory.setItem(15, ItemSkullManager.getSkull(PrefixManager.BLOCK + "§7Seite 3", SkyDrugs.getBase64("GRASSBLOCK"), new String[] {
                "",
                " §8▰§7▱ §7Klicke§8, §7um die dritte Seite zu öffnen§8.",
                ""
        }));

        player.openInventory(inventory);
    }

    public void openGUI_2 (Player player) {
        Inventory inventory = Bukkit.createInventory(null, 45, "§8»│ §9§lBLOCK§8");

        InventoryUtils.fillBorders(inventory, new ItemManager(Material.STAINED_GLASS_PANE).setData(3).setName("§8-/-").build());

        inventory.setItem(10, new ItemManager(Material.GRASS).setAnzahl(64).build());
        inventory.setItem(11, new ItemManager(Material.DIRT).setAnzahl(64).build());
        inventory.setItem(12, new ItemManager(Material.DIRT).setData(1).setAnzahl(64).build());
        inventory.setItem(13, new ItemManager(Material.MYCEL).setAnzahl(64).build());
        inventory.setItem(14, new ItemManager(Material.DIRT).setData(2).setAnzahl(64).build());
        inventory.setItem(15, new ItemManager(Material.SOUL_SAND).setAnzahl(64).build());
        inventory.setItem(16, new ItemManager(Material.GLOWSTONE).setAnzahl(64).build());

        inventory.setItem(19, new ItemManager(Material.STONE).setAnzahl(64).build());
        inventory.setItem(20, new ItemManager(Material.STONE).setData(1).setAnzahl(64).build());
        inventory.setItem(21, new ItemManager(Material.STONE).setData(3).setAnzahl(64).build());
        inventory.setItem(22, new ItemManager(Material.STONE).setData(5).setAnzahl(64).build());
        inventory.setItem(23, new ItemManager(Material.WOOD).setAnzahl(64).build());
        inventory.setItem(24, new ItemManager(Material.WOOD).setData(2).setAnzahl(64).build());
        inventory.setItem(25, new ItemManager(Material.WOOD).setData(3).setAnzahl(64).build());

        inventory.setItem(28, new ItemManager(Material.WOOD).setData(1).setAnzahl(64).build());
        inventory.setItem(29, new ItemManager(Material.WOOL).setAnzahl(64).build());
        inventory.setItem(30, new ItemManager(Material.HARD_CLAY).setAnzahl(64).build());
        inventory.setItem(31, new ItemManager(Material.GLASS).setAnzahl(64).build());
        inventory.setItem(32, new ItemManager(Material.GLOWSTONE).setAnzahl(64).build());
        inventory.setItem(33, new ItemManager(Material.QUARTZ_BLOCK).setAnzahl(64).build());
        inventory.setItem(34, new ItemManager(Material.QUARTZ_STAIRS).setAnzahl(64).build());

        inventory.setItem(44, SkyDrugs.weiter);

        player.openInventory(inventory);
    }
}


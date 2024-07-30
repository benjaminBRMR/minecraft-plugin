package de.sprachlvs.skydrugs.manager;

import de.sprachlvs.skydrugs.SkyDrugs;
import de.sprachlvs.skydrugs.apis.ConfigAPI;
import de.sprachlvs.skydrugs.commands.EnderChestCommand;
import de.sprachlvs.skydrugs.utils.UUIDFetcher;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.io.BukkitObjectInputStream;
import org.bukkit.util.io.BukkitObjectOutputStream;
import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;
import ru.tehkode.permissions.bukkit.PermissionsEx;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

public class EnderChestManager implements Listener {

    private static final ConfigAPI config = new ConfigAPI("plugins/System/enderchests/", "enderchests.yml");

    public static String itemStackArrayToBase64(ItemStack[] items) throws IllegalStateException {
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            BukkitObjectOutputStream dataOutput = new BukkitObjectOutputStream(outputStream);

            dataOutput.writeInt(items.length);

            for (int i = 0; i < items.length; i++) {
                dataOutput.writeObject(items[i]);
            }

            dataOutput.close();
            return Base64Coder.encodeLines(outputStream.toByteArray());
        } catch (Exception e) {
            throw new IllegalStateException("Unable to save item stacks.", e);
        }

    }

    public static String toBase64(Inventory inventory) throws IllegalStateException {
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            BukkitObjectOutputStream dataOutput = new BukkitObjectOutputStream(outputStream);

            dataOutput.writeInt(inventory.getSize());

            for (int i = 0; i < inventory.getSize(); i++) {
                dataOutput.writeObject(inventory.getItem(i));
            }

            dataOutput.close();
            return Base64Coder.encodeLines(outputStream.toByteArray());
        } catch (Exception e) {
            throw new IllegalStateException("Unable to save item stacks.", e);
        }
    }

    public static Inventory fromBase64(String data) throws IOException {
        try {
            ByteArrayInputStream inputStream = new ByteArrayInputStream(Base64Coder.decodeLines(data));
            BukkitObjectInputStream dataInput = new BukkitObjectInputStream(inputStream);
            Inventory inventory = Bukkit.getServer().createInventory(null, dataInput.readInt());

            // Read the serialized inventory
            for (int i = 0; i < inventory.getSize(); i++) {
                inventory.setItem(i, (ItemStack) dataInput.readObject());
            }
            dataInput.close();
            return inventory;
        } catch (ClassNotFoundException e) {
            throw new IOException("Unable to decode class type.", e);
        }
    }

    public static ItemStack[] itemStackArrayFromBase64(String data) {
        try {
            ByteArrayInputStream inputStream = new ByteArrayInputStream(Base64Coder.decodeLines(data));
            BukkitObjectInputStream dataInput = new BukkitObjectInputStream(inputStream);
            ItemStack[] items = new ItemStack[dataInput.readInt()];

            // Read the serialized inventory
            for (int i = 0; i < items.length; i++) {
                items[i] = (ItemStack) dataInput.readObject();
            }

            dataInput.close();
            return items;
        } catch (Exception e) {
            return null;
        }
    }

    private static List<Player> noClick = new CopyOnWriteArrayList<>();

    public static void openEnderChest(int enderChestId, Player toOpenFor, UUID fromPlayer) {
        if (enderChestId == 1) {
            if (!UUIDFetcher.getName(fromPlayer).equalsIgnoreCase(toOpenFor.getName()) && !PermissionsEx.getUser(toOpenFor).inGroup("Owner")) noClick.add(toOpenFor);
            Inventory inventory = Bukkit.createInventory(null, 54, PrefixManager.ENDERCHEST + "§7Seite 1 von §d" + UUIDFetcher.getName(fromPlayer));
            int size = inventory.getSize();
            int rows = (size + 1) / 9;

            for (int i = 0; i < rows * 9; ++i) {
                if (i <= 8 || i >= rows * 9 - 9 || i == 9 || i == 18 || i == 27 || i == 36 || i == 17 || i == 26 || i == 35 || i == 44) {
                    inventory.setItem(i, new ItemManager(Material.STAINED_GLASS_PANE).setDurability(15).setName("§8-/-§r").build());
                }
            }
            toOpenFor.playSound(toOpenFor.getLocation(), Sound.CHEST_OPEN, 18, 4);
            if (UUIDFetcher.getName(fromPlayer).equalsIgnoreCase(toOpenFor.getName())) toOpenFor.sendMessage(PrefixManager.ENDERCHEST + "§7Du hast die §dSeite " + enderChestId + " §7von deiner Enderchest geöffnet§8.");
            if (!UUIDFetcher.getName(fromPlayer).equalsIgnoreCase(toOpenFor.getName())) toOpenFor.sendMessage(PrefixManager.ENDERCHEST + "§7Du hast die §dSeite " + enderChestId + " §7von §d" + UUIDFetcher.getName(fromPlayer) + "§7 seiner Enderchest geöffnet§8.");
            inventory.setItem(45, SkyDrugs.zurück);
            ItemStack[] contents = itemStackArrayFromBase64(config.getConfig().getString(fromPlayer + ".one"));
            if (contents != null) inventory.setContents(contents);
            toOpenFor.openInventory(inventory);
            return;
        }
        if (enderChestId == 2) {
            if (playerHas(enderChestId, fromPlayer)) {
                if (!UUIDFetcher.getName(fromPlayer).equalsIgnoreCase(toOpenFor.getName()) && !PermissionsEx.getUser(toOpenFor).inGroup("Owner")) noClick.add(toOpenFor);
                Inventory inventory = Bukkit.createInventory(null, 54, PrefixManager.ENDERCHEST + "§7Seite 2 von §d" + UUIDFetcher.getName(fromPlayer));

                int size = inventory.getSize();
                int rows = (size + 1) / 9;

                for (int i = 0; i < rows * 9; ++i) {
                    if (i <= 8 || i >= rows * 9 - 9 || i == 9 || i == 18 || i == 27 || i == 36 || i == 17 || i == 26 || i == 35 || i == 44) {
                        inventory.setItem(i, new ItemManager(Material.STAINED_GLASS_PANE).setDurability(15).setName("§8-/-§r").build());
                    }
                }
                toOpenFor.playSound(toOpenFor.getLocation(), Sound.CHEST_OPEN, 18, 4);
                if (UUIDFetcher.getName(fromPlayer).equalsIgnoreCase(toOpenFor.getName())) toOpenFor.sendMessage(PrefixManager.ENDERCHEST + "§7Du hast die §dSeite " + enderChestId + " §7von deiner Enderchest geöffnet§8.");
                if (!UUIDFetcher.getName(fromPlayer).equalsIgnoreCase(toOpenFor.getName())) toOpenFor.sendMessage(PrefixManager.ENDERCHEST + "§7Du hast die §dSeite " + enderChestId + " §7von §d" + UUIDFetcher.getName(fromPlayer) + "§7 seiner Enderchest geöffnet§8.");
                inventory.setItem(45, SkyDrugs.zurück);
                ItemStack[] contents = itemStackArrayFromBase64(config.getConfig().getString(fromPlayer + ".two"));
                if (contents != null) inventory.setContents(contents);
                toOpenFor.openInventory(inventory);
                return;
            }
            toOpenFor.sendMessage(PrefixManager.ENDERCHEST + "§7Diese Seite ist erst ab §8'§e§lKAVAIN§8' §7verfügbar§8.");
            return;
        }
        if (enderChestId == 3) {
            if (playerHas(enderChestId, fromPlayer)) {
                if (!UUIDFetcher.getName(fromPlayer).equalsIgnoreCase(toOpenFor.getName()) && !PermissionsEx.getUser(toOpenFor).inGroup("Owner")) noClick.add(toOpenFor);
                Inventory inventory = Bukkit.createInventory(null, 54, PrefixManager.ENDERCHEST + "§7Seite 3 von §d" + UUIDFetcher.getName(fromPlayer));

                int size = inventory.getSize();
                int rows = (size + 1) / 9;

                for (int i = 0; i < rows * 9; ++i) {
                    if (i <= 8 || i >= rows * 9 - 9 || i == 9 || i == 18 || i == 27 || i == 36 || i == 17 || i == 26 || i == 35 || i == 44) {
                        inventory.setItem(i, new ItemManager(Material.STAINED_GLASS_PANE).setDurability(15).setName("§8-/-§r").build());
                    }
                }
                toOpenFor.playSound(toOpenFor.getLocation(), Sound.CHEST_OPEN, 18, 4);
                if (UUIDFetcher.getName(fromPlayer).equalsIgnoreCase(toOpenFor.getName())) toOpenFor.sendMessage(PrefixManager.ENDERCHEST + "§7Du hast die §dSeite " + enderChestId + " §7von deiner Enderchest geöffnet§8.");
                if (!UUIDFetcher.getName(fromPlayer).equalsIgnoreCase(toOpenFor.getName())) toOpenFor.sendMessage(PrefixManager.ENDERCHEST + "§7Du hast die §dSeite " + enderChestId + " §7von §d" + UUIDFetcher.getName(fromPlayer) + "§7 seiner Enderchest geöffnet§8.");
                inventory.setItem(45, SkyDrugs.zurück);
                ItemStack[] contents = itemStackArrayFromBase64(config.getConfig().getString(fromPlayer + ".three"));
                if (contents != null) inventory.setContents(contents);
                toOpenFor.openInventory(inventory);
                return;
            }
            toOpenFor.sendMessage(PrefixManager.ENDERCHEST + "§7Diese Seite ist erst ab §8'§6§lVALIUM§8' §7verfügbar§8.");
            return;
        }
        if (enderChestId == 4) {
            if (playerHas(enderChestId, fromPlayer)) {
                if (!UUIDFetcher.getName(fromPlayer).equalsIgnoreCase(toOpenFor.getName()) && !PermissionsEx.getUser(toOpenFor).inGroup("Owner")) noClick.add(toOpenFor);
                Inventory inventory = Bukkit.createInventory(null, 54, PrefixManager.ENDERCHEST + "§7Seite 4 von §d" + UUIDFetcher.getName(fromPlayer));

                int size = inventory.getSize();
                int rows = (size + 1) / 9;

                for (int i = 0; i < rows * 9; ++i) {
                    if (i <= 8 || i >= rows * 9 - 9 || i == 9 || i == 18 || i == 27 || i == 36 || i == 17 || i == 26 || i == 35 || i == 44) {
                        inventory.setItem(i, new ItemManager(Material.STAINED_GLASS_PANE).setDurability(15).setName("§8-/-§r").build());
                    }
                }
                toOpenFor.playSound(toOpenFor.getLocation(), Sound.CHEST_OPEN, 18, 4);
                if (UUIDFetcher.getName(fromPlayer).equalsIgnoreCase(toOpenFor.getName())) toOpenFor.sendMessage(PrefixManager.ENDERCHEST + "§7Du hast die §dSeite " + enderChestId + " §7von deiner Enderchest geöffnet§8.");
                if (!UUIDFetcher.getName(fromPlayer).equalsIgnoreCase(toOpenFor.getName())) toOpenFor.sendMessage(PrefixManager.ENDERCHEST + "§7Du hast die §dSeite " + enderChestId + " §7von §d" + UUIDFetcher.getName(fromPlayer) + "§7 seiner Enderchest geöffnet§8.");
                inventory.setItem(45, SkyDrugs.zurück);
                ItemStack[] contents = itemStackArrayFromBase64(config.getConfig().getString(fromPlayer + ".four"));
                if (contents != null) inventory.setContents(contents);
                toOpenFor.openInventory(inventory);
                return;
            }
            toOpenFor.sendMessage(PrefixManager.ENDERCHEST + "§7Diese Seite ist erst ab §8'§b§lOPIAT§8' §7verfügbar§8.");
            return;
        }
        if (enderChestId == 5) {
            if (playerHas(enderChestId, fromPlayer)) {
                if (!UUIDFetcher.getName(fromPlayer).equalsIgnoreCase(toOpenFor.getName()) && !PermissionsEx.getUser(toOpenFor).inGroup("Owner")) noClick.add(toOpenFor);
                Inventory inventory = Bukkit.createInventory(null, 54, PrefixManager.ENDERCHEST + "§7Seite 5 von §d" + UUIDFetcher.getName(fromPlayer));

                int size = inventory.getSize();
                int rows = (size + 1) / 9;

                for (int i = 0; i < rows * 9; ++i) {
                    if (i <= 8 || i >= rows * 9 - 9 || i == 9 || i == 18 || i == 27 || i == 36 || i == 17 || i == 26 || i == 35 || i == 44) {
                        inventory.setItem(i, new ItemManager(Material.STAINED_GLASS_PANE).setDurability(15).setName("§8-/-§r").build());
                    }
                }
                toOpenFor.playSound(toOpenFor.getLocation(), Sound.CHEST_OPEN, 18, 4);
                if (UUIDFetcher.getName(fromPlayer).equalsIgnoreCase(toOpenFor.getName())) toOpenFor.sendMessage(PrefixManager.ENDERCHEST + "§7Du hast die §dSeite " + enderChestId + " §7von deiner Enderchest geöffnet§8.");
                if (!UUIDFetcher.getName(fromPlayer).equalsIgnoreCase(toOpenFor.getName())) toOpenFor.sendMessage(PrefixManager.ENDERCHEST + "§7Du hast die §dSeite " + enderChestId + " §7von §d" + UUIDFetcher.getName(fromPlayer) + "§7 seiner Enderchest geöffnet§8.");
                inventory.setItem(45, SkyDrugs.zurück);
                ItemStack[] contents = itemStackArrayFromBase64(config.getConfig().getString(fromPlayer + ".five"));
                if (contents != null) inventory.setContents(contents);
                toOpenFor.openInventory(inventory);
                return;
            }
            toOpenFor.sendMessage(PrefixManager.ENDERCHEST + "§7Diese Seite ist erst ab §8'§c§lEPHEDRA§8' §7verfügbar§8.");
            return;
        }
        if (enderChestId == 6) {
            if (playerHas(enderChestId, fromPlayer)) {
                if (!UUIDFetcher.getName(fromPlayer).equalsIgnoreCase(toOpenFor.getName()) && !PermissionsEx.getUser(toOpenFor).inGroup("Owner")) noClick.add(toOpenFor);
                Inventory inventory = Bukkit.createInventory(null, 54, PrefixManager.ENDERCHEST + "§7Seite 6 von §d" + UUIDFetcher.getName(fromPlayer));

                int size = inventory.getSize();
                int rows = (size + 1) / 9;

                for (int i = 0; i < rows * 9; ++i) {
                    if (i <= 8 || i >= rows * 9 - 9 || i == 9 || i == 18 || i == 27 || i == 36 || i == 17 || i == 26 || i == 35 || i == 44) {
                        inventory.setItem(i, new ItemManager(Material.STAINED_GLASS_PANE).setDurability(15).setName("§8-/-§r").build());
                    }                }
                toOpenFor.playSound(toOpenFor.getLocation(), Sound.CHEST_OPEN, 18, 4);
                if (UUIDFetcher.getName(fromPlayer).equalsIgnoreCase(toOpenFor.getName())) toOpenFor.sendMessage(PrefixManager.ENDERCHEST + "§7Du hast die §dSeite " + enderChestId + " §7von deiner Enderchest geöffnet§8.");
                if (!UUIDFetcher.getName(fromPlayer).equalsIgnoreCase(toOpenFor.getName())) toOpenFor.sendMessage(PrefixManager.ENDERCHEST + "§7Du hast die §dSeite " + enderChestId + " §7von §d" + UUIDFetcher.getName(fromPlayer) + "§7 seiner Enderchest geöffnet§8.");
                inventory.setItem(45, SkyDrugs.zurück);
                ItemStack[] contents = itemStackArrayFromBase64(config.getConfig().getString(fromPlayer + ".six"));
                if (contents != null) inventory.setContents(contents);
                toOpenFor.openInventory(inventory);
                return;
            }
            toOpenFor.sendMessage(PrefixManager.ENDERCHEST + "§7Diese Seite ist erst ab §8'§5§lSALVIA§8' §7verfügbar§8.");
            return;
        }
        if (enderChestId == 7) {
            if (playerHas(enderChestId, fromPlayer)) {
                if (!UUIDFetcher.getName(fromPlayer).equalsIgnoreCase(toOpenFor.getName()) && !PermissionsEx.getUser(toOpenFor).inGroup("Owner")) noClick.add(toOpenFor);
                Inventory inventory = Bukkit.createInventory(null, 54, PrefixManager.ENDERCHEST + "§7Seite 7 von §d" + UUIDFetcher.getName(fromPlayer));
//nullpointer = spieler gibts ned mit dem namen oder .... hab ich maybe was kaputt gemacht weil ich den title von der ec gechanged habe?
                int size = inventory.getSize();
                int rows = (size + 1) / 9;

                for (int i = 0; i < rows * 9; ++i) {
                    if (i <= 8 || i >= rows * 9 - 9 || i == 9 || i == 18 || i == 27 || i == 36 || i == 17 || i == 26 || i == 35 || i == 44) {
                        inventory.setItem(i, new ItemManager(Material.STAINED_GLASS_PANE).setDurability(15).setName("§8-/-§r").build());
                    }
                }
                toOpenFor.playSound(toOpenFor.getLocation(), Sound.CHEST_OPEN, 18, 4);
                if (UUIDFetcher.getName(fromPlayer).equalsIgnoreCase(toOpenFor.getName())) toOpenFor.sendMessage(PrefixManager.ENDERCHEST + "§7Du hast die §dSeite " + enderChestId + " §7von deiner Enderchest geöffnet§8.");
                if (!UUIDFetcher.getName(fromPlayer).equalsIgnoreCase(toOpenFor.getName())) toOpenFor.sendMessage(PrefixManager.ENDERCHEST + "§7Du hast die §dSeite " + enderChestId + " §7von §d" + UUIDFetcher.getName(fromPlayer) + "§7 seiner Enderchest geöffnet§8.");
                inventory.setItem(45, SkyDrugs.zurück);
                ItemStack[] contents = itemStackArrayFromBase64(config.getConfig().getString(fromPlayer + ".seven"));
                if (contents != null) inventory.setContents(contents);
                toOpenFor.openInventory(inventory);
                return;
            }
            toOpenFor.sendMessage(PrefixManager.ENDERCHEST + "§7Diese Seite ist erst ab §8'§d§lBOOSTER§8' §7verfügbar§8.");
            return;
        }
    }

    public static void saveEnderchest(int what, Player invPlayer, UUID from, Inventory enderChest) {
        ItemStack[] contents = enderChest.getContents();
        if (UUIDFetcher.getName(from).equalsIgnoreCase(invPlayer.getName())) {
            if (what == 1) { // die nachricht kam ja iwie 2mal bei mir xd
                config.getConfig().set(from.toString() + ".one", itemStackArrayToBase64(contents));
                config.saveConfig();
                invPlayer.sendMessage(PrefixManager.ENDERCHEST + "§7Deine §dEnderchest §7wurde §aerfolgreich §7gespeichert§8.");
                return;
            }
            if (what == 2) {
                if (playerHas(2, from)) {
                    config.getConfig().set(from.toString() + ".two", itemStackArrayToBase64(contents));
                    config.saveConfig();
                    invPlayer.sendMessage(PrefixManager.ENDERCHEST + "§7Deine §dEnderchest §7wurde §aerfolgreich §7gespeichert§8.");
                    return;
                }
                invPlayer.sendMessage(PrefixManager.ENDERCHEST + "§cDazu hast du keine Rechte§8!");
                return;
            }
            if (what == 3) {
                if (playerHas(3, from)) {
                    config.getConfig().set(from.toString() + ".three", itemStackArrayToBase64(contents));
                    config.saveConfig();
                    invPlayer.sendMessage(PrefixManager.ENDERCHEST + "§7Deine §dEnderchest §7wurde §aerfolgreich §7gespeichert§8.");
                    return;
                }
                invPlayer.sendMessage(PrefixManager.ENDERCHEST + "§cDazu hast du keine Rechte§8!");
                return;
            }
            if (what == 4) {
                if (playerHas(4, from)) {
                    config.getConfig().set(from.toString() + ".four", itemStackArrayToBase64(contents));
                    config.saveConfig();
                    invPlayer.sendMessage(PrefixManager.ENDERCHEST + "§7Deine §dEnderchest §7wurde §aerfolgreich §7gespeichert§8.");
                    return;
                }
                invPlayer.sendMessage(PrefixManager.ENDERCHEST + "§cDazu hast du keine Rechte§8!");
                return;
            }
            if (what == 5) {
                if (playerHas(5, from)) {
                    config.getConfig().set(from.toString() + ".five", itemStackArrayToBase64(contents));
                    config.saveConfig();
                    invPlayer.sendMessage(PrefixManager.ENDERCHEST + "§7Deine §dEnderchest §7wurde §aerfolgreich §7gespeichert§8.");
                    return;
                }
                invPlayer.sendMessage(PrefixManager.ENDERCHEST + "§cDazu hast du keine Rechte§8!");
                return;
            }
            if (what == 6) {
                if (playerHas(6, from)) {
                    config.getConfig().set(from.toString() + ".six", itemStackArrayToBase64(contents));
                    config.saveConfig();
                    invPlayer.sendMessage(PrefixManager.ENDERCHEST + "§7Deine §dEnderchest §7wurde §aerfolgreich §7gespeichert§8.");
                    return;
                }
                invPlayer.sendMessage(PrefixManager.ENDERCHEST + "§cDazu hast du keine Rechte§8!");
                return;
            }
            if (what == 7) {
                if (playerHas(7, from)) {
                    config.getConfig().set(from.toString() + ".seven", itemStackArrayToBase64(contents));
                    config.saveConfig();
                    invPlayer.sendMessage(PrefixManager.ENDERCHEST + "§7Deine §dEnderchest §7wurde §aerfolgreich §7gespeichert§8.");
                    return;
                }
                invPlayer.sendMessage(PrefixManager.ENDERCHEST + "§cDazu hast du keine Rechte§8!");
            }
        } else { //komm mal gleich mein any
            String name = UUIDFetcher.getName(from);
            if (what == 1) { // die nachricht kam ja iwie 2mal bei mir xd
                config.getConfig().set(from.toString() + ".one", itemStackArrayToBase64(contents));
                config.saveConfig();
                invPlayer.sendMessage(PrefixManager.ENDERCHEST + "§7Die §dEnderchest §7von §d" + name + " §7wurde §aerfolgreich §7gespeichert§8.");
                return;
            }
            if (what == 2) {
                if (playerHas(2, from)) {
                    config.getConfig().set(from.toString() + ".two", itemStackArrayToBase64(contents));
                    config.saveConfig();
                    invPlayer.sendMessage(PrefixManager.ENDERCHEST + "§7Die §dEnderchest §7von §d" + name + " §7wurde §aerfolgreich §7gespeichert§8.");
                    return;
                }
                invPlayer.sendMessage(PrefixManager.ENDERCHEST + "§cDazu hast du keine Rechte§8!");
                return;
            }
            if (what == 3) {
                if (playerHas(3, from)) {
                    config.getConfig().set(from.toString() + ".three", itemStackArrayToBase64(contents));
                    config.saveConfig();
                    invPlayer.sendMessage(PrefixManager.ENDERCHEST + "§7Die §dEnderchest §7von §d" + name + " §7wurde §aerfolgreich §7gespeichert§8.");
                    return;
                }
                invPlayer.sendMessage(PrefixManager.ENDERCHEST + "§cDazu hast du keine Rechte§8!");
                return;
            }
            if (what == 4) {
                if (playerHas(4, from)) {
                    config.getConfig().set(from.toString() + ".four", itemStackArrayToBase64(contents));
                    config.saveConfig();
                    invPlayer.sendMessage(PrefixManager.ENDERCHEST + "§7Die §dEnderchest §7von §d" + name + " §7wurde §aerfolgreich §7gespeichert§8.");
                    return;
                }
                invPlayer.sendMessage(PrefixManager.ENDERCHEST + "§cDazu hast du keine Rechte§8!");
                return;
            }
            if (what == 5) {
                if (playerHas(5, from)) {
                    config.getConfig().set(from.toString() + ".five", itemStackArrayToBase64(contents));
                    config.saveConfig();
                    invPlayer.sendMessage(PrefixManager.ENDERCHEST + "§7Die §dEnderchest §7von §d" + name + " §7wurde §aerfolgreich §7gespeichert§8.");
                    return;
                }
                invPlayer.sendMessage(PrefixManager.ENDERCHEST + "§cDazu hast du keine Rechte§8!");
                return;
            }
            if (what == 6) {
                if (playerHas(6, from)) {
                    config.getConfig().set(from.toString() + ".six", itemStackArrayToBase64(contents));
                    config.saveConfig();
                    invPlayer.sendMessage(PrefixManager.ENDERCHEST + "§7Die §dEnderchest §7von §d" + name + " §7wurde §aerfolgreich §7gespeichert§8.");
                    return;
                }
                invPlayer.sendMessage(PrefixManager.ENDERCHEST + "§cDazu hast du keine Rechte§8!");
                return;
            }
            if (what == 7) {
                if (playerHas(7, from)) {
                    config.getConfig().set(from.toString() + ".seven", itemStackArrayToBase64(contents));
                    config.saveConfig();
                    invPlayer.sendMessage(PrefixManager.ENDERCHEST + "§7Die §dEnderchest §7von §d" + name + " §7wurde §aerfolgreich §7gespeichert§8.");
                    return;
                }
                invPlayer.sendMessage(PrefixManager.ENDERCHEST + "§cDazu hast du keine Rechte§8!");
            }
        }
    }


    public static boolean playerHas(int enderchest, UUID playerUuid) {
        return PermissionsEx.getUser(UUIDFetcher.getName(playerUuid)).has("enderchest." + enderchest);
    }

    @EventHandler
    public void onInventoryClick(final InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        String inventoryName = event.getInventory().getName();
        if (!inventoryName.contains(PrefixManager.ENDERCHEST + "§7Seite")) return;
        inventoryName = inventoryName.replaceAll(PrefixManager.ENDERCHEST, "");
        int id = Integer.parseInt(inventoryName.split(" ")[1]);
        if (noClick.contains(player)) event.setCancelled(true);
        if (event.getSlot() == 45) {
            event.setCancelled(true);
            if (inventoryName.split(" ")[3].replace("§d", "").equalsIgnoreCase(player.getName())) {
                //saveEnderchest(id, player, UUIDFetcher.getUUID(inventoryName.split(" ")[3].replace("§d", "")), event.getInventory());
                player.closeInventory();
                EnderChestCommand.openMainGUI(player, true, null); //scheiße
            } else {
                player.closeInventory();
                EnderChestCommand.openMainGUI(player, false, UUIDFetcher.getUUID(inventoryName.split(" ")[3].replace("§d", ""))); //scheiße
            }
        }
    }

    @EventHandler
    public void onInventoryClose(final InventoryCloseEvent event) { //inv close event wird nochmal getriggert
        Player player = (Player) event.getPlayer();
        String inventoryName = event.getInventory().getName();
        if (!inventoryName.contains(PrefixManager.ENDERCHEST + "§7Seite")) return;
        inventoryName = inventoryName.replaceAll(PrefixManager.ENDERCHEST, "");
        int id = Integer.parseInt(inventoryName.split(" ")[1]);

        if (!noClick.contains(player)) {
            saveEnderchest(id, player, UUIDFetcher.getUUID(inventoryName.split(" ")[3].replace("§d", "")), event.getInventory());
            return;
        }
        noClick.remove(player);
        //no save weil nix ihm gehören
    }
}

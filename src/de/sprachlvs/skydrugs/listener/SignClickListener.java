package de.sprachlvs.skydrugs.listener;

import de.sprachlvs.skydrugs.manager.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import java.util.HashMap;

public class SignClickListener implements Listener {

    private void fillBorders(@Nonnull Inventory inventory, @Nonnull ItemStack itemStack) {
        int size = inventory.getSize();
        int rows = (size + 1) / 9;

        for(int i = 0; i < rows * 9; ++i) {
            if (i <= 8 || i >= rows * 9 - 9 || i == 9 || i == 18 || i == 27 || i == 36 || i == 17 || i == 26 || i == 35 || i == 44) {
                inventory.setItem(i, itemStack);
            }
        }

    }

    public static HashMap<Player, Integer> counter = new HashMap<>();


    @EventHandler
    public void onInvClick(final InventoryClickEvent e) {

        final Player player = (Player)e.getWhoClicked();



        if(e.getInventory().getName().equalsIgnoreCase("§8»│ §a§lFREE ITEMS")) {

            int countnow = counter.get(player);

            if(e.getClick().isKeyboardClick() || e.getClick().isShiftClick()) {
                e.setCancelled(true);
            }



            for(int i = 10; i < 17; i++) {
                if (e.getRawSlot() != i) {
                    e.setCancelled(true);
                } else {
                    if(e.getCurrentItem().getType() != org.bukkit.Material.BARRIER) {





                        if(countnow < 6) {

                            player.getInventory().addItem(e.getCurrentItem());
                            e.getCurrentItem().setType(org.bukkit.Material.BARRIER);
                            e.getCurrentItem().setAmount(1);
                            player.playSound(player.getLocation(), Sound.WOOD_CLICK, 0.3F, 25.8F);

                            counter.replace(player, countnow + 1);


                        } else {

                            counter.remove(player);

                            player.closeInventory();
                            player.playSound(player.getLocation(), Sound.CHEST_CLOSE, 0.5F, 14.8F);
                        }



                    } else {
                        e.setCancelled(true);
                        player.playSound(player.getLocation(), Sound.NOTE_BASS, 0.5F, 14.8F);
                    }
                }
            }
        }
    }

    @EventHandler
    public void onInventoryClose(final InventoryCloseEvent e) {

        final Player player = (Player)e.getPlayer();

        if(e.getInventory().getName().equalsIgnoreCase("§8»│ §a§lFREE ITEMS")) {
            counter.remove(player);
        }
    }

    @EventHandler
    public void onSignClick(final PlayerInteractEvent e) {

        final Player player = e.getPlayer();
        final Block block = e.getClickedBlock();


        if(block != null && block.getState() != null) {
            if(block.getState() instanceof Sign) {

                if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                    Sign sign = (Sign) e.getClickedBlock().getState();

                    if (sign.getLine(0).equalsIgnoreCase("§8»│ §a§lFREE ITEMS") && sign.getLine(2) != null && sign.getLine(3) != null) {

                        Inventory inv = Bukkit.createInventory(null, 27, "§8»│ §a§lFREE ITEMS");
                        ItemStack glass = new ItemManager(org.bukkit.Material.STAINED_GLASS_PANE).setData(15).setName("§8-/-").build();

                        final String id =
                                sign.getLine(2)
                                        .replaceAll("►", "")
                                        .replaceAll("◄", "")
                                        .replaceAll("&", "")
                                        .replaceAll("&a", "")
                                        .replaceAll("&8", "")
                                        .replaceAll("§8", "")
                                        .replaceAll(" ", "")
                                        .replaceAll("§a", "");


                        final int amount =
                                Integer.parseInt(sign.getLine(3)
                                        .replaceAll("►", "")
                                        .replaceAll("◄", "")
                                        .replaceAll("&", "")
                                        .replaceAll("&a", "")
                                        .replaceAll("&8", "")
                                        .replaceAll("§8", "")
                                        .replaceAll(" ", "")
                                        .replaceAll("§a", ""));


                        String[] string = id.split(":");
                        int ID = Integer.parseInt(string[0]);
                        int Byte = 0;
                        if (sign.getLine(2).contains(":")) {
                            Byte = Integer.parseInt(string[1]);
                        }



                        ItemStack itemStack = new ItemStack(ID, amount, (short) Byte);
                        //ItemStack itemStack = new ItemManager(Material.matchMaterial(id)).setAnzahl(amount).build();


                        fillBorders(inv, glass);
                        inv.setItem(10, itemStack);
                        inv.setItem(11, itemStack);
                        inv.setItem(12, itemStack);
                        inv.setItem(13, itemStack);
                        inv.setItem(14, itemStack);
                        inv.setItem(15, itemStack);
                        inv.setItem(16, itemStack);


                        player.openInventory(inv);
                        player.playSound(player.getLocation(), Sound.ARROW_HIT, 0.5F, 14.8F);

                        counter.put(player, 0);


                    }
                }
            }
        }

    }
}
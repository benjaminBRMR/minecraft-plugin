package de.sprachlvs.skydrugs.utils;

import de.sprachlvs.skydrugs.inventorys.CookieGUI;
import de.sprachlvs.skydrugs.manager.CookieSettings;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

public class InventoryUtils {

    public static  void fill(@Nonnull Inventory inventory, @Nonnull ItemStack itemStack) {
        for(int i = 0; i < inventory.getSize(); ++i) {
            inventory.setItem(i, itemStack);
        }

    }

    public static void fillBordersWithTheme(@Nonnull Player player, @Nonnull Inventory inventory) {
        int size = inventory.getSize();
        int rows = (size + 1) / 9;

        for (int i = 0; i < rows * 9; ++i) {
            if (i <= 8 || i >= rows * 9 - 9 || i == 9 || i == 18 || i == 27 || i == 36 || i == 17 || i == 26 || i == 35 || i == 44) {

                if(new CookieSettings(player.getUniqueId()).getThemeColor().equalsIgnoreCase("rot")) {
                    inventory.setItem(i, CookieGUI.rot_glass);
                }else if(new CookieSettings(player.getUniqueId()).getThemeColor().equalsIgnoreCase("weiss")) {
                    inventory.setItem(i, CookieGUI.weiß_glass);
                }else if(new CookieSettings(player.getUniqueId()).getThemeColor().equalsIgnoreCase("gruen")) {
                    inventory.setItem(i, CookieGUI.grün_glass);
                }else if(new CookieSettings(player.getUniqueId()).getThemeColor().equalsIgnoreCase("lila")) {
                    inventory.setItem(i, CookieGUI.lila_glass);
                }else if(new CookieSettings(player.getUniqueId()).getThemeColor().equalsIgnoreCase("blau")) {
                    inventory.setItem(i, CookieGUI.blau_glass);
                }else if(new CookieSettings(player.getUniqueId()).getThemeColor().equalsIgnoreCase("gelb")) {
                    inventory.setItem(i, CookieGUI.gelb_glass);
                } else {
                    inventory.setItem(i, CookieGUI.borderitem);
                }
            }
        }
    }

    public static void fillBorders(@Nonnull Inventory inventory, @Nonnull ItemStack itemStack) {
        int size = inventory.getSize();
        int rows = (size + 1) / 9;

        for(int i = 0; i < rows * 9; ++i) {
            if (i <= 8 || i >= rows * 9 - 9 || i == 9 || i == 18 || i == 27 || i == 36 || i == 17 || i == 26 || i == 35 || i == 44) {
                inventory.setItem(i, itemStack);
            }
        }

    }
}

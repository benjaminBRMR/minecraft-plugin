package de.sprachlvs.skydrugs.manager;

import com.google.common.collect.Lists;
import net.minecraft.server.v1_8_R3.NBTTagCompound;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.text.SimpleDateFormat;
import java.util.List;

public class SignManager {
    private ItemStack itemStack;

    public SignManager(ItemStack itemStack) {
        this.itemStack = itemStack;
    }

    public ItemStack sign(String name, String message) {
        List<String> lore;
        if (!isSigned())
            setSigned(true);
        ItemMeta itemMeta = this.itemStack.getItemMeta();
        if (itemMeta.getLore() == null) {
            lore = Lists.newArrayList();
        } else {
            lore = itemMeta.getLore();
        }
        lore.add("§r");
        lore.add("§7" + message.replace('&', '§'));
        lore.add("§8§m--------------------------------------");
        lore.add("§7Signiert von §b" + name + " §7am §b" + fortmatTime(System.currentTimeMillis()));
        itemMeta.setLore(lore);
        //itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        this.itemStack.setItemMeta(itemMeta);
        return this.itemStack;
    }

    public ItemStack unSign() {
        if (isSigned())
            setSigned(false);
        ItemMeta itemMeta = this.itemStack.getItemMeta();
        List<String> lore = itemMeta.getLore();
        for (int i = 0; i < 3; i++)
            lore.remove(lore.size() - 1);
        itemMeta.setLore(lore);
        this.itemStack.setItemMeta(itemMeta);
        return this.itemStack;
    }

    public boolean isSigned() {
        NBTTagCompound nbtTagCompound;
        net.minecraft.server.v1_8_R3.ItemStack nms = CraftItemStack.asNMSCopy(this.itemStack);
        if (nms.getTag() != null) {
            nbtTagCompound = nms.getTag();
        } else {
            nbtTagCompound = new NBTTagCompound();
            setSigned(false);
        }
        return nbtTagCompound.getBoolean("signed");
    }

    public void setSigned(boolean signed) {
        NBTTagCompound nbtTagCompound;
        net.minecraft.server.v1_8_R3.ItemStack nms = CraftItemStack.asNMSCopy(this.itemStack);
        if (nms.getTag() != null) {
            nbtTagCompound = nms.getTag();
        } else {
            nbtTagCompound = new NBTTagCompound();
        }
        nbtTagCompound.setBoolean("signed", signed);
        nms.setTag(nbtTagCompound);
        this.itemStack = (ItemStack)CraftItemStack.asCraftMirror(nms);
    }

    private String fortmatTime(Long millis) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        return simpleDateFormat.format(millis);
    }
}

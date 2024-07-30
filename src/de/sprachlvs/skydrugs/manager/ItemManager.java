package de.sprachlvs.skydrugs.manager;

import net.minecraft.server.v1_8_R3.NBTTagCompound;
import net.minecraft.server.v1_8_R3.NBTTagList;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.*;

public class ItemManager {
    private static ItemStack Item;
    private ItemStack is;

    public ItemManager() {
        Item = new ItemStack(1);
    }

    public ItemManager(Material Material) {
        Item = new ItemStack(Material, 1);
    }

    public ItemManager(ItemStack IS) {
        Item = IS;
    }

    public ItemManager setData(int Data) {
        Item = new ItemStack(Item.getType(), Item.getAmount(), (short) Data);
        return this;
    }

    public ItemManager hideAttackDamage() {
        ItemMeta iM = Item.getItemMeta();
        iM.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        Item.setItemMeta(iM);
        return this;
    }

    public ItemManager setAnzahl(Integer Anzahl) {
        Item.setAmount(Anzahl);
        return this;
    }

    public ItemManager setSkullOwner(String kopf) {
        if (this.is.getType() != Material.SKULL_ITEM && this.is.getType() != Material.SKULL) {
            throw new IllegalArgumentException("skullOwner() only applicable for skulls!");
        } else {
            this.is.setDurability((short) SkullType.PLAYER.ordinal());
            SkullMeta meta = (SkullMeta) this.is.getItemMeta();
            meta.setOwner(kopf);
            this.is.setItemMeta(meta);
            return this;
        }
    }

    public ItemManager setName(String Name) {
        ItemMeta Meta = Item.getItemMeta();
        Meta.setDisplayName(Name);
        Item.setItemMeta(Meta);
        return this;
    }

    public ItemManager addLore(String Lore) {
        ItemMeta Meta = Item.getItemMeta();
        List<String> List = Meta.getLore();
        if (List == null) {
            List = new ArrayList();
        }

        ((List) List).add(Lore);
        Meta.setLore((List) List);
        Item.setItemMeta(Meta);
        return this;
    }



    public ItemManager setLore(String... List) {
        ItemMeta Meta = Item.getItemMeta();
        if (List != null) {
            List<String> li = new ArrayList<>(Arrays.asList(List));
            Meta.setLore(li);
        }
        //Meta.setLore(Collections.singletonList(List));
        Item.setItemMeta(Meta);
        return this;
    }

    public ItemManager setSkull(String player) {
        ItemStack i = new ItemStack(Material.SKULL_ITEM);
        i.setDurability((short) 3);
        SkullMeta im = (SkullMeta) i.getItemMeta();
        im.setOwner(player);
        i.setItemMeta(im);
        return this;
    }

    public ItemManager setUnbreakable() {
        ItemMeta Meta = Item.getItemMeta();
        Meta.spigot().setUnbreakable(true);
        Item.setItemMeta(Meta);
        return this;
    }

    public ItemManager setDurability(int Anzahl) {
        Item.setDurability((short) Anzahl);
        return this;
    }

    public ItemManager addEnchantment(Enchantment Enchantment, Integer Level) {
        Item.addUnsafeEnchantment(Enchantment, Level);
        return this;
    }

    public ItemManager setType(Material Material) {
        Item.setType(Material);
        return this;
    }

    public ItemManager resetLore() {
        ItemMeta Meta = Item.getItemMeta();
        Meta.setLore((List) null);
        Item.setItemMeta(Meta);
        return this;
    }

    public ItemManager setColor(Color Color) {
        LeatherArmorMeta Meta = (LeatherArmorMeta) Item.getItemMeta();
        Meta.setColor(Color);
        Item.setItemMeta(Meta);
        return this;
    }

    public ItemManager setGlowing() {
        net.minecraft.server.v1_8_R3.ItemStack nmsStack = CraftItemStack.asNMSCopy(Item);
        NBTTagCompound tag = null;
        if (!nmsStack.hasTag()) {
            tag = new NBTTagCompound();
            nmsStack.setTag(tag);
        }

        if (tag == null) {
            tag = nmsStack.getTag();
        }

        NBTTagList ench = new NBTTagList();
        tag.set("ench", ench);
        nmsStack.setTag(tag);
        Item = CraftItemStack.asCraftMirror(nmsStack);
        return this;
    }

    public ItemManager setEnchantments(ItemStack item) {
        Iterator var2 = item.getEnchantments().keySet().iterator();

        while (var2.hasNext()) {
            Enchantment enchant = (Enchantment) var2.next();
            int level = item.getEnchantmentLevel(enchant);
            Item.addUnsafeEnchantment(enchant, level);
        }

        return this;
    }

    public ItemStack build() {
        return Item;
    }


    public static class SkullAPI {

        private ItemStack itemStack;
        private SkullMeta itemMeta;

        public ItemStack getSkull(final String skullOwner) {
            itemStack = new ItemStack(397, 1, (short) 3);
            itemMeta = (SkullMeta) itemStack.getItemMeta();
            itemMeta.setOwner(skullOwner);
            itemStack.setItemMeta(itemMeta);
            return itemStack;
        }

        public ItemStack getKopf(String title, String base64, String[] lore) {
            if (title == null) {
                title = "title";
            }
            ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
            UUID hashAsId = new UUID(base64.hashCode(), base64.hashCode());


            item = Bukkit.getUnsafe().modifyItemStack(item,
                    "{display:{Name:\"" + title + "\"},SkullOwner:{Id:\"" + hashAsId + "\",Properties:{textures:[{Value:\"" + base64 + "\"}]}}}"
            );
            ItemMeta im = item.getItemMeta();
            im.setDisplayName(title);
            im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            im.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            if (lore != null) {
                List<String> li = new ArrayList<>(Arrays.asList(lore));
                im.setLore(Arrays.asList(lore));
            }
            item.setItemMeta(im);
            return item;

        }

        public ItemStack getPlayerKopf(String title, String player, String[] lore) {
            ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);

            item = Bukkit.getUnsafe().modifyItemStack(item,
                    "{display:{Name:\"" + title + "\"},SkullOwner:{Name:\"" + player + "\"}}"
            );
            ItemMeta im = item.getItemMeta();
            im.setDisplayName(title);
            im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            im.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            if (lore != null) {
                List<String> li = new ArrayList<>(Arrays.asList(lore));
                im.setLore(li);
            }
            item.setItemMeta(im);
            return item;
        }
    }
}



package de.sprachlvs.skydrugs.inventorys;

import de.sprachlvs.skydrugs.apis.PerkAPI;
import de.sprachlvs.skydrugs.apis.PerkEnum;
import de.sprachlvs.skydrugs.apis.TextHoverAPI;
import de.sprachlvs.skydrugs.apis.stats.TokenAPI;
import de.sprachlvs.skydrugs.manager.ItemManager;
import de.sprachlvs.skydrugs.manager.PrefixManager;
import de.sprachlvs.skydrugs.utils.SoundUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;

import static de.sprachlvs.skydrugs.utils.GeneralUtils.getDifference;
import static de.sprachlvs.skydrugs.utils.GeneralUtils.getFormated;

public class PerkGUI_Listener implements Listener {

    public static void startTask(Plugin plugin) {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, () -> {

            for (Player player : Bukkit.getOnlinePlayers()) {
                if (player.getOpenInventory().getTitle().equalsIgnoreCase(PrefixManager.PERKS + " §7Perks 1")) {
                    String[] info_lore = new String[]{
                            "",
                            " §8▰§7▱ §cInformation",
                            "  §8- §7Diese Übersicht zeigt dir§8,",
                            "  §8- §7welche Perks du gekauft",
                            "  §8- §7und aktiviert hast§8.",
                            "",
                            " §8▰§7▱ §cIm Besitz",
                            "  §8- §fKein Hunger Perk§8: §a" + new PerkAPI(player).hasPerkColored(PerkEnum.NOHUNGER),
                            "  §8- §fSprungkraft Perk§8: §a" + new PerkAPI(player).hasPerkColored(PerkEnum.JUMPBOOST),
                            "  §8- §fSchnelligkeit I Perk§8: §a" + new PerkAPI(player).hasPerkColored(PerkEnum.SPEEDEINS),
                            "  §8- §fNachtsicht Perk§8: §a" + new PerkAPI(player).hasPerkColored(PerkEnum.NACHTSICHT),
                            "",
                            "",
                            " §8▰§7▱ §cStatus",
                            "  §8- §fKein Hunger Perk§8: §a" + new PerkAPI(player).getPerkStatusColored(PerkEnum.NOHUNGER),
                            "  §8- §fSprungkraft I Perk§8: §a" + new PerkAPI(player).getPerkStatusColored(PerkEnum.JUMPBOOST),
                            "  §8- §fSchnelligkeit I Perk§8: §a" + new PerkAPI(player).getPerkStatusColored(PerkEnum.SPEEDEINS),
                            "  §8- §fNachtsicht Perk§8: §a" + new PerkAPI(player).getPerkStatusColored(PerkEnum.NACHTSICHT),
                            ""
                    };

                    String[] nohungerperk_lore = new String[]{
                            "",
                            " §8▰§7▱ §cWas macht das§8?",
                            "  §8- §7Dieses Perk bringt dir den Vorteil nichts",
                            "  §8- §7mehr essen zu müssen bzw. nie wieder§8.",
                            "",
                            " §8▰§7▱ §cPreis",
                            "  §8- §f500§8.§f000 §7Tokens",
                            ""
                    };

                    String[] jumpboostperk_lore = new String[]{
                            "",
                            " §8▰§7▱ §cWas macht das§8?",
                            "  §8- §7Dieses Perk bringt dir den Vorteil",
                            "  §8- §7höher springen zu können§8.",
                            "",
                            " §8▰§7▱ §cPreis",
                            "  §8- §f250§8.§f000 §7Tokens",
                            ""
                    };

                    String[] nachtsichtperk_lore = new String[]{
                            "",
                            " §8▰§7▱ §cWas macht das§8?",
                            "  §8- §7Dieses Perk bringt dir den Vorteil den",
                            "  §8- §7Nachtsicht Effekt dauerhaft zu erhalten§8.",
                            "",
                            " §8▰§7▱ §cPreis",
                            "  §8- §f200§8.§f000 §7Tokens",
                            ""
                    };

                    String[] speedperk_lore = new String[]{
                            "",
                            " §8▰§7▱ §cWas macht das§8?",
                            "  §8- §7Dieses Perk bringt dir den Vorteil den",
                            "  §8- §7Schnelligkeit I Effekt dauerhaft zu erhalten§8.",
                            "",
                            " §8▰§7▱ §cPreis",
                            "  §8- §f350§8.§f000 §7Tokens",
                            ""
                    };

                    String[] nohungerperk_lore_buyed  = new String[]{
                            "",
                            " §8▰§7▱ §cWas macht das§8?",
                            "  §8- §7Dieses Perk bringt dir den Vorteil nichts",
                            "  §8- §7mehr essen zu müssen bzw. nie wieder§8.",
                            "",
                            " §8▰§7▱ §cDu besitzt bereits dieses Perk§8.",
                            ""
                    };

                    String[] jumpboostperk_lore_buyed  = new String[]{
                            "",
                            " §8▰§7▱ §cWas macht das§8?",
                            "  §8- §7Dieses Perk bringt dir den Vorteil",
                            "  §8- §7höher springen zu können§8.",
                            "",
                            " §8▰§7▱ §cDu besitzt bereits dieses Perk§8.",
                            ""
                    };

                    String[] nachtsichtperk_lore_buyed  = new String[]{
                            "",
                            " §8▰§7▱ §cWas macht das§8?",
                            "  §8- §7Dieses Perk bringt dir den Vorteil den",
                            "  §8- §7Nachtsicht Effekt dauerhaft zu erhalten§8.",
                            "",
                            " §8▰§7▱ §cDu besitzt bereits dieses Perk§8.",
                            ""
                    };

                    String[] speedperk_lore_buyed = new String[]{
                            "",
                            " §8▰§7▱ §cWas macht das§8?",
                            "  §8- §7Dieses Perk bringt dir den Vorteil den",
                            "  §8- §7Schnelligkeit I Effekt dauerhaft zu erhalten§8.",
                            "",
                            " §8▰§7▱ §cDu besitzt bereits dieses Perk§8.",
                            ""
                    };

                    ItemStack nohungerperk = new ItemManager(Material.COOKED_BEEF).setName("§8»│ §c§lPERK §8▰§7▱ §7Kein Hunger Perk").setLore(nohungerperk_lore).build();
                    ItemStack jumpboostperk = new ItemManager(Material.RABBIT_FOOT).setName("§8»│ §c§lPERK §8▰§7▱ §7Sprungkraft I Perk").setLore(jumpboostperk_lore).build();
                    ItemStack speed1perk = new ItemManager(Material.FEATHER).setName("§8»│ §c§lPERK §8▰§7▱ §7Schnelligkeit I Perk").setLore(speedperk_lore).build();
                    ItemStack nachtsichtperk = new ItemManager(Material.EYE_OF_ENDER).setName("§8»│ §c§lPERK §8▰§7▱ §7Nachtsicht Perk").setLore(nachtsichtperk_lore).build();

                    ItemStack nohungerperk_bought = new ItemManager(Material.COOKED_BEEF).setName("§8»│ §c§lPERK §8▰§7▱ §7Kein Hunger Perk").setLore(nohungerperk_lore_buyed).build();
                    ItemStack jumpboostperk_bought = new ItemManager(Material.RABBIT_FOOT).setName("§8»│ §c§lPERK §8▰§7▱ §7Sprungkraft I Perk").setLore(jumpboostperk_lore_buyed).build();
                    ItemStack speed1perk_bought = new ItemManager(Material.FEATHER).setName("§8»│ §c§lPERK §8▰§7▱ §7Schnelligkeit I Perk").setLore(speedperk_lore_buyed).build();
                    ItemStack nachtsichtperk_bought = new ItemManager(Material.EYE_OF_ENDER).setName("§8»│ §c§lPERK §8▰§7▱ §7Nachtsicht Perk").setLore(nachtsichtperk_lore_buyed).build();


                    if(!new PerkAPI(player).hasPerk(PerkEnum.NOHUNGER)) {
                        player.getOpenInventory().setItem(29, nohungerperk);
                    } else {
                        player.getOpenInventory().setItem(29, nohungerperk_bought);
                    }

                    if(!new PerkAPI(player).hasPerk(PerkEnum.JUMPBOOST)) {
                        player.getOpenInventory().setItem(30, jumpboostperk);
                    } else {
                        player.getOpenInventory().setItem(30, jumpboostperk_bought);
                    }

                    if(!new PerkAPI(player).hasPerk(PerkEnum.SPEEDEINS)) {
                        player.getOpenInventory().setItem(32, speed1perk);
                    } else {
                        player.getOpenInventory().setItem(32, speed1perk_bought);
                    }


                    if(!new PerkAPI(player).hasPerk(PerkEnum.NACHTSICHT)) {
                        player.getOpenInventory().setItem(33, nachtsichtperk);
                    } else {
                        player.getOpenInventory().setItem(33, nachtsichtperk_bought);
                    }


                    ItemStack info = new ItemManager(Material.POTION).setName("§8»│ §c§lPERK §8▰§7▱ §7Übersicht").setLore(info_lore).build();

                    player.getOpenInventory().setItem(13, info);

                } else if (player.getOpenInventory().getTitle().equalsIgnoreCase(PrefixManager.PERKS + " §7Perks 2")) {
                    String[] info_lore = new String[]{
                            "",
                            " §8▰§7▱ §cInformation",
                            "  §8- §7Diese Übersicht zeigt dir§8,",
                            "  §8- §7welche Perks du gekauft",
                            "  §8- §7und aktiviert hast§8.",
                            "",
                            " §8▰§7▱ §cIm Besitz",
                            "  §8- §fSchnelligkeit II Perk§8: §a" + new PerkAPI(player).hasPerkColored(PerkEnum.SPEEDZWEI),
                            "  §8- §fStärke I Perk§8: §a" + new PerkAPI(player).hasPerkColored(PerkEnum.STAERKEEINS),
                            "  §8- §fStärke II Perk§8: §a" + new PerkAPI(player).hasPerkColored(PerkEnum.STAERKEZWEI),
                            "",
                            "",
                            " §8▰§7▱ §cStatus",
                            "  §8- §fSchnelligkeit II Perk§8: §a" + new PerkAPI(player).getPerkStatusColored(PerkEnum.SPEEDZWEI),
                            "  §8- §fStärke I Perk§8: §a" + new PerkAPI(player).getPerkStatusColored(PerkEnum.STAERKEEINS),
                            "  §8- §fStärke II Perk§8: §a" + new PerkAPI(player).getPerkStatusColored(PerkEnum.STAERKEZWEI),
                            ""
                    };

                    String[] speed2perk_lore = new String[]{
                            "",
                            " §8▰§7▱ §cWas macht das§8?",
                            "  §8- §7Dieses Perk bringt dir den Vorteil den",
                            "  §8- §7Schnelligkeit II Effekt dauerhaft zu erhalten§8.",
                            "",
                            " §8▰§7▱ §cPreis",
                            "  §8- §f5 §7Euro",
                            ""
                    };

                    String[] stärke1perk_lore = new String[]{
                            "",
                            " §8▰§7▱ §cWas macht das§8?",
                            "  §8- §7Dieses Perk bringt dir den Vorteil den",
                            "  §8- §7Stärke I Effekt dauerhaft zu erhalten§8.",
                            "",
                            " §8▰§7▱ §cPreis",
                            "  §8- §f5 §7Euro",
                            ""
                    };

                    String[] stärke2perk_lore = new String[]{
                            "",
                            " §8▰§7▱ §cWas macht das§8?",
                            "  §8- §7Dieses Perk bringt dir den Vorteil den",
                            "  §8- §7Stärke II Effekt dauerhaft zu erhalten§8.",
                            "",
                            " §8▰§7▱ §cPreis",
                            "  §8- §f10 §7Euro",
                            ""
                    };

                    String[] speed2perk_lore_bought = new String[]{
                            "",
                            " §8▰§7▱ §cWas macht das§8?",
                            "  §8- §7Dieses Perk bringt dir den Vorteil den",
                            "  §8- §7Schnelligkeit II Effekt dauerhaft zu erhalten§8.",
                            "",
                            " §8▰§7▱ §cDu besitzt bereits dieses Perk§8.",
                            ""
                    };

                    String[] stärke1perk_lore_bought = new String[]{
                            "",
                            " §8▰§7▱ §cWas macht das§8?",
                            "  §8- §7Dieses Perk bringt dir den Vorteil den",
                            "  §8- §7Stärke I Effekt dauerhaft zu erhalten§8.",
                            "",
                            " §8▰§7▱ §cDu besitzt bereits dieses Perk§8.",
                            ""
                    };

                    String[] stärke2perk_lore_bought = new String[]{
                            "",
                            " §8▰§7▱ §cWas macht das§8?",
                            "  §8- §7Dieses Perk bringt dir den Vorteil den",
                            "  §8- §7Stärke II Effekt dauerhaft zu erhalten§8.",
                            "",
                            " §8▰§7▱ §cDu besitzt bereits dieses Perk§8.",
                            ""
                    };

                    ItemStack speed2perk = new ItemManager(Material.FEATHER).setName("§8»│ §c§lPERK §8▰§7▱ §7Schnelligkeit II").setLore(speed2perk_lore).build();
                    ItemStack stärke1perk = new ItemManager(Material.FERMENTED_SPIDER_EYE).setName("§8»│ §c§lPERK §8▰§7▱ §7Stärke I").setLore(stärke1perk_lore).build();
                    ItemStack stärke2perk = new ItemManager(Material.FERMENTED_SPIDER_EYE).setName("§8»│ §c§lPERK §8▰§7▱ §7Stärke II").setLore(stärke2perk_lore).build();

                    ItemStack speed2perk_bought = new ItemManager(Material.FEATHER).setName("§8»│ §c§lPERK §8▰§7▱ §7Schnelligkeit II").setLore(speed2perk_lore_bought).build();
                    ItemStack stärke1perk_bought = new ItemManager(Material.FERMENTED_SPIDER_EYE).setName("§8»│ §c§lPERK §8▰§7▱ §7Stärke I").setLore(stärke1perk_lore_bought).build();
                    ItemStack stärke2perk_bought = new ItemManager(Material.FERMENTED_SPIDER_EYE).setName("§8»│ §c§lPERK §8▰§7▱ §7Stärke II").setLore(stärke2perk_lore_bought).build();


                    ItemStack info = new ItemManager(Material.POTION).setName("§8»│ §c§lPERK §8▰§7▱ §7Übersicht").setLore(info_lore).build();

                    player.getOpenInventory().setItem(13, info);

                    if(!new PerkAPI(player).hasPerk(PerkEnum.SPEEDZWEI)) {
                        player.getOpenInventory().setItem(30, speed2perk);
                    } else {
                        player.getOpenInventory().setItem(30, speed2perk_bought);
                    }

                    if(!new PerkAPI(player).hasPerk(PerkEnum.STAERKEEINS)) {
                        player.getOpenInventory().setItem(31, stärke1perk);
                    } else {
                        player.getOpenInventory().setItem(31, stärke1perk_bought);
                    }

                    if(!new PerkAPI(player).hasPerk(PerkEnum.STAERKEZWEI)) {
                        player.getOpenInventory().setItem(32, stärke2perk);
                    } else {
                        player.getOpenInventory().setItem(32, stärke2perk_bought);
                    }

                }
            }

        }, 0L, 10L);
    }

    @EventHandler
    public void onPerkInventoryClick(final InventoryClickEvent e) {

        if(e.getInventory().getName().equalsIgnoreCase(PrefixManager.PERKS + " §7Perks 1")){

            e.setCancelled(true);
            final Player player = (org.bukkit.entity.Player)e.getWhoClicked();

            final PerkAPI perkAPI = new PerkAPI(player);
            final double tokens = new TokenAPI(player).getTokens();




            if(e.getRawSlot() == 29) {

                if(tokens > 500000) {


                    if (!perkAPI.hasPerk(PerkEnum.NOHUNGER)) {
                        perkAPI.setPerk(PerkEnum.NOHUNGER, true);
                        perkAPI.setPerkStatus(PerkEnum.NOHUNGER, true);

                        new TokenAPI(player).removeTokens(500000);

                        player.sendMessage(PrefixManager.PERKS + "§7Du hast erfolgreich das §cKein Hunger Perk §7erworben§8.");
                        SoundUtils.playBigSuccessSound(player);
                    } else {
                        if (perkAPI.getPerkStatus(PerkEnum.NOHUNGER)) {
                            perkAPI.setPerkStatus(PerkEnum.NOHUNGER, false);
                            perkAPI.syncPerks();
                            player.sendMessage(PrefixManager.PERKS + "§cDu hast das Kein Hunger Perk deaktiviert§8.");
                            player.playSound(player.getLocation(), Sound.NOTE_BASS, 100, 18.4F);
                        } else {
                            perkAPI.setPerkStatus(PerkEnum.NOHUNGER, true);
                            perkAPI.syncPerks();
                            player.sendMessage(PrefixManager.PERKS + "§aDu hast das Kein Hunger Perk aktiviert§8.");
                            player.playSound(player.getLocation(), Sound.NOTE_PLING, 100, 18.4F);
                        }
                    }
                } else {
                    player.sendMessage(PrefixManager.PERKS + "§7Dafür fehlen dir noch §e" + getFormated(getDifference((int) tokens, 500000)) + " §7Tokens§8.");
                }
            } else if(e.getRawSlot() == 30) {

                if(tokens > 250000) {

                    if (!perkAPI.hasPerk(PerkEnum.JUMPBOOST)) {
                        perkAPI.setPerk(PerkEnum.JUMPBOOST, true);
                        perkAPI.setPerkStatus(PerkEnum.JUMPBOOST, true);
                        player.addPotionEffect(new PotionEffect(PerkEnum.JUMPBOOST.getPotionType(), Integer.MAX_VALUE, 1, true, false));

                        new TokenAPI(player).removeTokens(250000);

                        player.sendMessage(PrefixManager.PERKS + "§7Du hast erfolgreich das §cSprungkraft Perk §7erworben§8.");
                        SoundUtils.playBigSuccessSound(player);
                    } else {
                        if (perkAPI.getPerkStatus(PerkEnum.JUMPBOOST)) {
                            perkAPI.setPerkStatus(PerkEnum.JUMPBOOST, false);
                            perkAPI.syncPerks();
                            player.sendMessage(PrefixManager.PERKS + "§cDu hast das Sprungkraft Perk deaktiviert§8.");
                            player.playSound(player.getLocation(), Sound.NOTE_BASS, 100, 18.4F);
                        } else {
                            perkAPI.setPerkStatus(PerkEnum.JUMPBOOST, true);
                            perkAPI.syncPerks();
                            player.sendMessage(PrefixManager.PERKS + "§aDu hast das Sprungkraft Perk aktiviert§8.");
                            player.playSound(player.getLocation(), Sound.NOTE_PLING, 100, 18.4F);
                        }
                    }
                } else {
                    player.sendMessage(PrefixManager.PERKS + "§7Dafür fehlen dir noch §e" + getFormated(getDifference((int) tokens, 250000)) + " §7Tokens§8.");
                }
            } else if(e.getRawSlot() == 32) {

                if (tokens > 350000) {

                    if (!perkAPI.hasPerk(PerkEnum.SPEEDEINS)) {
                        perkAPI.setPerk(PerkEnum.SPEEDEINS, true);
                        perkAPI.setPerkStatus(PerkEnum.SPEEDEINS, true);

                        new TokenAPI(player).removeTokens(350000);

                        player.sendMessage(PrefixManager.PERKS + "§7Du hast erfolgreich das §cSchnelligkeit I Perk §7erworben§8.");
                        SoundUtils.playBigSuccessSound(player);
                    } else {
                        if (perkAPI.getPerkStatus(PerkEnum.SPEEDEINS)) {
                            perkAPI.setPerkStatus(PerkEnum.SPEEDEINS, false);
                            perkAPI.syncPerks();
                            player.sendMessage(PrefixManager.PERKS + "§cDu hast das Schnelligkeit I Perk deaktiviert§8.");
                            player.playSound(player.getLocation(), Sound.NOTE_BASS, 100, 18.4F);
                        } else {
                            perkAPI.setPerkStatus(PerkEnum.SPEEDEINS, true);
                            perkAPI.syncPerks();
                            player.sendMessage(PrefixManager.PERKS + "§aDu hast das Schnelligkeit I Perk aktiviert§8.");
                            player.playSound(player.getLocation(), Sound.NOTE_PLING, 100, 18.4F);
                        }
                    }
                } else {
                    player.sendMessage(PrefixManager.PERKS + "§7Dafür fehlen dir noch §e" + getFormated(getDifference((int) tokens, 350000)) + " §7Tokens§8.");
                }
            } else if(e.getRawSlot() == 33) {

                if (tokens > 200000) {

                    if (!perkAPI.hasPerk(PerkEnum.NACHTSICHT)) {
                        perkAPI.setPerk(PerkEnum.NACHTSICHT, true);
                        perkAPI.setPerkStatus(PerkEnum.NACHTSICHT, true);

                        new TokenAPI(player).removeTokens(200000);

                        player.sendMessage(PrefixManager.PERKS + "§7Du hast erfolgreich das §cNachtsicht Perk §7erworben§8.");
                        SoundUtils.playBigSuccessSound(player);
                    } else {
                        if (perkAPI.getPerkStatus(PerkEnum.NACHTSICHT)) {
                            perkAPI.setPerkStatus(PerkEnum.NACHTSICHT, false);
                            perkAPI.syncPerks();
                            player.sendMessage(PrefixManager.PERKS + "§cDu hast das Nachtsicht Perk deaktiviert§8.");
                            player.playSound(player.getLocation(), Sound.NOTE_BASS, 100, 18.4F);
                        } else {
                            perkAPI.setPerkStatus(PerkEnum.NACHTSICHT, true);
                            perkAPI.syncPerks();
                            player.sendMessage(PrefixManager.PERKS + "§aDu hast das Nachtsicht Perk aktiviert§8.");
                            player.playSound(player.getLocation(), Sound.NOTE_PLING, 100, 18.4F);
                        }
                    }
                } else {
                    player.sendMessage(PrefixManager.PERKS + "§7Dafür fehlen dir noch §e" + getFormated(getDifference((int) tokens, 200000)) + " §7Tokens§8.");
                }
            } else if(e.getRawSlot() == 43) {
                PerkGUI.openPerkSeite2(player);
                player.playSound(player.getLocation(), Sound.BURP, 100, 18.4F);
            }
        } else if(e.getInventory().getName().equalsIgnoreCase(PrefixManager.PERKS + " §7Perks 2")) {

            e.setCancelled(true);
            final Player player = (org.bukkit.entity.Player) e.getWhoClicked();

            final PerkAPI perkAPI = new PerkAPI(player);
            final double tokens = new TokenAPI(player).getTokens();

            if(e.getRawSlot() == 30) {
                if (!perkAPI.hasPerk(PerkEnum.SPEEDZWEI)) {

                    player.playSound(player.getLocation(), Sound.FIZZ, 100, 18.4F);
                    player.sendMessage(PrefixManager.PERKS + "§7Du hast dieses Perk nicht freigeschalten§8.");
                    TextHoverAPI.HoverURL(player, PrefixManager.PERKS + "§7Unser Shop§8: §chttps://buy.skydrugs.de", "https://buy.skydrugs.de", "§8»│ §7Klicke§8,§7 um in den Shop zu gelangen§8.");
                    player.sendMessage("");


                } else {
                    if (perkAPI.getPerkStatus(PerkEnum.SPEEDZWEI)) {
                        perkAPI.setPerkStatus(PerkEnum.SPEEDZWEI, false);
                        perkAPI.syncPerks();
                        player.sendMessage(PrefixManager.PERKS + "§cDu hast das Schnelligkeit II Perk deaktiviert§8.");
                        player.playSound(player.getLocation(), Sound.NOTE_BASS, 100, 18.4F);
                    } else {
                        perkAPI.setPerkStatus(PerkEnum.SPEEDZWEI, true);
                        perkAPI.syncPerks();
                        player.sendMessage(PrefixManager.PERKS + "§aDu hast das Schnelligkeit II Perk aktiviert§8.");
                        player.playSound(player.getLocation(), Sound.NOTE_PLING, 100, 18.4F);
                    }
                }
            } else if(e.getRawSlot() == 31) {
                if (!perkAPI.hasPerk(PerkEnum.STAERKEEINS)) {

                    player.playSound(player.getLocation(), Sound.FIZZ, 100, 18.4F);
                    player.sendMessage(PrefixManager.PERKS + "§7Du hast dieses Perk nicht freigeschalten§8.");
                    TextHoverAPI.HoverURL(player, PrefixManager.PERKS + "§7Unser Shop§8: §chttps://buy.skydrugs.de", "https://buy.skydrugs.de", "§8»│ §7Klicke§8,§7 um in den Shop zu gelangen§8.");
                    player.sendMessage("");

                } else {
                    if (perkAPI.getPerkStatus(PerkEnum.STAERKEEINS)) {
                        perkAPI.setPerkStatus(PerkEnum.STAERKEEINS, false);
                        perkAPI.syncPerks();
                        player.sendMessage(PrefixManager.PERKS + "§cDu hast das Stärke I Perk deaktiviert§8.");
                        player.playSound(player.getLocation(), Sound.NOTE_BASS, 100, 18.4F);
                    } else {
                        perkAPI.setPerkStatus(PerkEnum.STAERKEEINS, true);
                        perkAPI.syncPerks();
                        player.sendMessage(PrefixManager.PERKS + "§aDu hast das Stärke I Perk aktiviert§8.");
                        player.playSound(player.getLocation(), Sound.NOTE_PLING, 100, 18.4F);
                    }
                }
            } else if(e.getRawSlot() == 32) {
                if (!perkAPI.hasPerk(PerkEnum.STAERKEZWEI)) {

                    player.playSound(player.getLocation(), Sound.FIZZ, 100, 18.4F);
                    player.sendMessage(PrefixManager.PERKS + "§7Du hast dieses Perk nicht freigeschalten§8.");
                    TextHoverAPI.HoverURL(player, PrefixManager.PERKS + "§7Unser Shop§8: §chttps://buy.skydrugs.de", "https://buy.skydrugs.de", "§8»│ §7Klicke§8,§7 um in den Shop zu gelangen§8.");
                    player.sendMessage("");

                } else {
                    if (perkAPI.getPerkStatus(PerkEnum.STAERKEZWEI)) {
                        perkAPI.setPerkStatus(PerkEnum.STAERKEZWEI, false);
                        perkAPI.syncPerks();
                        player.sendMessage(PrefixManager.PERKS + "§cDu hast das Stärke II Perk deaktiviert§8.");
                        player.playSound(player.getLocation(), Sound.NOTE_BASS, 100, 18.4F);
                    } else {
                        perkAPI.setPerkStatus(PerkEnum.STAERKEZWEI, true);
                        perkAPI.syncPerks();
                        player.sendMessage(PrefixManager.PERKS + "§aDu hast das Stärke II Perk aktiviert§8.");
                        player.playSound(player.getLocation(), Sound.NOTE_PLING, 100, 18.4F);
                    }
                }
            } else if(e.getRawSlot() == 37) {
                PerkGUI.openPerkSeite1(player);
                player.playSound(player.getLocation(), Sound.BURP, 100, 18.4F);
            }
        }
    }
}


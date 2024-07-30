package de.sprachlvs.skydrugs.inventorys;

import de.sprachlvs.skydrugs.apis.TitleAPI;
import de.sprachlvs.skydrugs.apis.CookieAPI;
import de.sprachlvs.skydrugs.apis.stats.TokenAPI;
import de.sprachlvs.skydrugs.manager.CookieSettings;
import de.sprachlvs.skydrugs.manager.ItemManager;
import de.sprachlvs.skydrugs.manager.PrefixManager;
import de.sprachlvs.skydrugs.utils.SoundUtils;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class CookieGUI_Listener implements Listener {

    @EventHandler
    public void onInventoryClick(final InventoryClickEvent e) {

        final Player player = (Player)e.getWhoClicked();

        if(e.getInventory().getName().equalsIgnoreCase(PrefixManager.COOKIECLICKER  + " §7CookieClicker")) {

            e.setCancelled(true);


            if(e.getRawSlot() == 23) {
                player.closeInventory();
                player.playSound(player.getLocation(), Sound.DOOR_CLOSE, 100, 18.4F);
            } else if(e.getRawSlot() == 33) {
                CookieGUI.openCookieClickerOptionen(player);
                player.playSound(player.getLocation(), Sound.BURP, 100, 18.4F);
            } else if(e.getRawSlot() == 31) {
                CookieGUI.openCookieClickerWechsler(player);
                player.playSound(player.getLocation(), Sound.BURP, 100, 18.4F);
            } else if(e.getRawSlot() == 29) {
                CookieGUI.openCookieClickerTokenShop(player);
                player.playSound(player.getLocation(), Sound.BURP, 100, 18.4F);
            }
        }
    }

    @EventHandler
    public void onInventoryOptionenClick(final InventoryClickEvent e) {

        final Player player = (Player)e.getWhoClicked();

        if(e.getInventory().getName().equalsIgnoreCase(PrefixManager.COOKIECLICKER + " §7Cookie Optionen")) {

            e.setCancelled(true);

            if(e.getRawSlot() == 29) {
                if(new CookieSettings(player.getUniqueId()).getClickStatus()) {
                    new CookieSettings(player.getUniqueId()).setClickSound(false);
                    e.getInventory().setItem(29, CookieGUI.disabled);

                    player.playSound(player.getLocation(), Sound.NOTE_BASS, 100, 18.4F);
                    //TitleAPI.sendTitle(player, 3, 13, 15, "§8» §e§lOPTIONEN §8«", "§7CookieClicker-Sound§8: §c§lDEAKTIVIERT");
                    player.sendMessage(PrefixManager.COOKIECLICKER + "§7Der §7Sound wurde §cdeaktiviert§8.");

                } else {
                    new CookieSettings(player.getUniqueId()).setClickSound(true);
                    e.getInventory().setItem(29, CookieGUI.enabled);



                    player.playSound(player.getLocation(), Sound.NOTE_PLING, 100, 18.4F);
                    //TitleAPI.sendTitle(player, 3, 13, 15, "§8» §e§lOPTIONEN §8«", "§7CookieClicker-Sound§8: §a§lAKTIVIERT");
                    player.sendMessage(PrefixManager.COOKIECLICKER + "§7Der §7Sound wurde §aaktiviert§8.");
                }
            } else if(e.getRawSlot() == 30) {
                if(new CookieSettings(player.getUniqueId()).getTitleStatus()) {
                    new CookieSettings(player.getUniqueId()).setTitle(false);
                    e.getInventory().setItem(30, CookieGUI.disabled);


                    //TitleAPI.sendTitle(player, 3, 13, 15, "§8» §e§lOPTIONEN §8«", "§7CookieClicker-Title§8: §C§lDEAKTIVIERT");
                    player.sendMessage(PrefixManager.COOKIECLICKER + "§7Der §7Title wurde §cdeaktiviert§8.");

                    player.playSound(player.getLocation(), Sound.NOTE_BASS, 100, 18.4F);
                } else {
                    new CookieSettings(player.getUniqueId()).setTitle(true);
                    e.getInventory().setItem(30, CookieGUI.enabled);


                    //TitleAPI.sendTitle(player, 3, 13, 15, "§8» §e§lOPTIONEN §8«", "§7CookieClicker-Title§8: §a§lAKTIVIERT");
                    player.sendMessage(PrefixManager.COOKIECLICKER + "§7Der §7Sound wurde §aaktiviert§8.");

                    player.playSound(player.getLocation(), Sound.NOTE_PLING, 100, 18.4F);
                }
            } else if(e.getRawSlot() == 39) {
                player.closeInventory();
                CookieGUI.openCookieClicker(player);
            } else if(e.getRawSlot() == 41) {
                new CookieSettings(player.getUniqueId()).setThemeColor("default");
                player.closeInventory();
                CookieGUI.openCookieClicker(player);
                player.sendMessage(PrefixManager.COOKIECLICKER + "§7Dein §7Theme wurde zurückgesetzt§8.");
                player.playSound(player.getLocation(), Sound.BLAZE_HIT, 100, 18.4F);



            } else if(e.getRawSlot() == 32) {
                new CookieSettings(player.getUniqueId()).setThemeColor("blau");
                player.closeInventory();
                CookieGUI.openCookieClicker(player);
                player.sendMessage(PrefixManager.COOKIECLICKER + "§7Dein §7Theme wurde zu §9Blau §7geändert§8.");
                player.playSound(player.getLocation(), Sound.BLAZE_HIT, 100, 18.4F);


            } else if(e.getRawSlot() == 24) {
                new CookieSettings(player.getUniqueId()).setThemeColor("gelb");
                player.closeInventory();
                CookieGUI.openCookieClicker(player);
                player.sendMessage(PrefixManager.COOKIECLICKER + "§7Dein §7Theme wurde zu §eGelb §7geändert§8.");
                player.playSound(player.getLocation(), Sound.BLAZE_HIT, 100, 18.4F);

            } else if(e.getRawSlot() == 25) {
                new CookieSettings(player.getUniqueId()).setThemeColor("gruen");
                player.closeInventory();
                CookieGUI.openCookieClicker(player);
                player.sendMessage(PrefixManager.COOKIECLICKER + "§7Dein §7Theme wurde zu §2Grün §7geändert§8.");
                player.playSound(player.getLocation(), Sound.BLAZE_HIT, 100, 18.4F);

            } else if(e.getRawSlot() == 23) {
                new CookieSettings(player.getUniqueId()).setThemeColor("weiss");
                player.closeInventory();
                CookieGUI.openCookieClicker(player);
                player.sendMessage(PrefixManager.COOKIECLICKER + "§7Dein §7Theme wurde zu §fWeiß §7geändert§8.");
                player.playSound(player.getLocation(), Sound.BLAZE_HIT, 100, 18.4F);

            } else if(e.getRawSlot() == 33) {
                new CookieSettings(player.getUniqueId()).setThemeColor("lila");
                player.closeInventory();
                CookieGUI.openCookieClicker(player);
                player.sendMessage(PrefixManager.COOKIECLICKER + "§7Dein §7Theme wurde zu §5Lila §7geändert§8.");
                player.playSound(player.getLocation(), Sound.BLAZE_HIT, 100, 18.4F);

            } else if(e.getRawSlot() == 34) {
                new CookieSettings(player.getUniqueId()).setThemeColor("rot");
                player.closeInventory();
                CookieGUI.openCookieClicker(player);
                player.sendMessage(PrefixManager.COOKIECLICKER + "§7Dein §7Theme wurde zu §cRot §7geändert§8.");
                player.playSound(player.getLocation(), Sound.BLAZE_HIT, 100, 18.4F);
            }
        }
    }


    @EventHandler
    public void onInventoryWechslerClick(final InventoryClickEvent e) {

        // LEFT CLICK = +1
        // MIDDLE CLICK = +100
        // RIGHT CLCIK = +10
        // Q / andere = +alle


        //if(e.getAction() = InventoryAction.)

        final Player player = (Player)e.getWhoClicked();

        if(e.getInventory().getName().equalsIgnoreCase(PrefixManager.COOKIECLICKER + " §7Cookie Wechsler")) {

            e.setCancelled(true);

            if(e.getRawSlot() == 37) {
                player.closeInventory();
                CookieGUI.openCookieClicker(player);
            } else if(e.getRawSlot() == 30) {
                int cookies = new CookieAPI(player.getUniqueId()).getCookies();

                if(cookies >= 100) {
                    new CookieAPI(player.getUniqueId()).setCookies(cookies-99);
                    new TokenAPI(player).addTokens(5);
                    player.sendMessage(PrefixManager.COOKIECLICKER + "§7Du hast §6100 Cookies §7in §65 §6Tokens §7umgewandelt§8.");
                    player.playSound(player.getLocation(), Sound.LEVEL_UP, 100, 18.4F);
                } else {
                    player.sendMessage(PrefixManager.COOKIECLICKER + "§7Dafür fehlen dir noch §e" + getDifference(cookies, 100) + " §7Cookies§8.");
                    player.playSound(player.getLocation(), Sound.VILLAGER_NO, 100, 18.4F);
                }


            } else if(e.getRawSlot() == 31) {
                int cookies = new CookieAPI(player.getUniqueId()).getCookies();

                if(cookies >= 1000) {
                    new CookieAPI(player.getUniqueId()).setCookies(cookies-1000);
                    new TokenAPI(player).addTokens(40);
                    player.sendMessage(PrefixManager.COOKIECLICKER + "§7Du hast §61§8'§6000 Cookies §7in §640 §6Tokens §7umgewandelt§8.");
                    player.playSound(player.getLocation(), Sound.LEVEL_UP, 100, 18.4F);
                } else {
                    player.sendMessage(PrefixManager.COOKIECLICKER + "§7Dafür fehlen dir noch §e" + CookieAPI.getFormated(getDifference(cookies, 1000)) + " §7Cookies§8.");
                    player.playSound(player.getLocation(), Sound.VILLAGER_NO, 100, 18.4F);
                }


            } else if(e.getRawSlot() == 32) {
                int cookies = new CookieAPI(player.getUniqueId()).getCookies();
                int kurs = cookies / 20;



                if(cookies >= 100) {
                    player.sendMessage(PrefixManager.COOKIECLICKER + "§7Du hast §e" + CookieAPI.getFormated(cookies) + " Cookies §7in §6" + CookieAPI.getFormated(kurs)+ " §6Tokens §7umgewandelt§8.");
                    new TokenAPI(player).addTokens(Math.round(cookies/30));
                    new CookieAPI(player.getUniqueId()).setCookies(0);
                    player.playSound(player.getLocation(), Sound.LEVEL_UP, 100, 18.4F);
                } else {
                    player.sendMessage(PrefixManager.COOKIECLICKER + "§7Dafür benötigst du mindestens §e100 §7Cookies§8.");
                    player.playSound(player.getLocation(), Sound.VILLAGER_NO, 100, 18.4F);
                }
            }
        }
    }

    public static int getDifference(int number1, int number2) {

        if(number1 < number2) {
            return number2 - number1;
        } else {
            return number1 - number2;
        }

    }

    @EventHandler
    public void onInventoryShopClick(final InventoryClickEvent e) {

        final Player player = (Player)e.getWhoClicked();


        if(e.getInventory().getName().equalsIgnoreCase(PrefixManager.COOKIECLICKER + " §7Cookie Tokenshop")) {

            e.setCancelled(true);

            if(e.getRawSlot() == 20) {

                final double tokens = new TokenAPI(player).getTokens();


                if (new CookieSettings(player.getUniqueId()).getLevel() == 0) {
                    if (tokens >= 150000) {
                        player.sendMessage(PrefixManager.COOKIECLICKER + "§7Du hast erfolgreich das §6Level 1 §7erworben§8.");
                        player.closeInventory();
                        TitleAPI.sendTitle(player, 10,15,10,"§8» §e§lCLICKER §8«", "§6§oLevel 1 §7wurde erfolgreich erworben§8");


                        new CookieSettings(player.getUniqueId()).setLevel(1);
                        new TokenAPI(player).removeTokens(150000);
                        CookieAPI.playBigSuccessSound(player);
                    } else {
                        player.sendMessage(PrefixManager.COOKIECLICKER + "§7Dafür fehlen dir noch §e" + CookieAPI.getFormated(getDifference((int) tokens, 300000)) + " §7Tokens§8.");
                    }

                } else if(new CookieSettings(player.getUniqueId()).getLevel() == 1) {
                    player.sendMessage(PrefixManager.COOKIECLICKER + "§cDu besitzt bereits dieses Level§8.");
                } else if(new CookieSettings(player.getUniqueId()).getLevel() > 1) {
                    player.sendMessage(PrefixManager.COOKIECLICKER + "§cDu besitzt ein höheres Level§8.");
                }

            } else if(e.getRawSlot() == 21) {

                final double tokens = new TokenAPI(player).getTokens();

                if (new CookieSettings(player.getUniqueId()).getLevel() == 1) {
                    if (tokens >= 300000) {
                        player.sendMessage(PrefixManager.COOKIECLICKER + "§7Du hast erfolgreich das §6Level 2 §7erworben§8.");
                        player.closeInventory();
                        TitleAPI.sendTitle(player, 10,15,10,"§8» §e§lCLICKER §8«", "§6§oLevel 2 §7wurde erfolgreich erworben§8");



                        new CookieSettings(player.getUniqueId()).setLevel(2);
                        new TokenAPI(player).removeTokens(300000);
                        CookieAPI.playBigSuccessSound(player);
                    } else {
                        player.sendMessage(PrefixManager.COOKIECLICKER + "§7Dafür fehlen dir noch §e" + CookieAPI.getFormated(getDifference((int) tokens, 300000)) + " §7Tokens§8.");
                    }
                } else if(new CookieSettings(player.getUniqueId()).getLevel() == 2) {
                    player.sendMessage(PrefixManager.COOKIECLICKER + "§cDu besitzt bereits dieses Level§8.");
                } else if(new CookieSettings(player.getUniqueId()).getLevel() > 2) {
                    player.sendMessage(PrefixManager.COOKIECLICKER + "§cDu besitzt ein höheres Level§8.");
                } else {
                    player.sendMessage(PrefixManager.COOKIECLICKER + "§7Du musst zuerst §6Level 1 §7erworben haben§8.");
                }


            } else if(e.getRawSlot() == 22) {

                final double tokens = new TokenAPI(player).getTokens();

                if (new CookieSettings(player.getUniqueId()).getLevel() == 2) {
                    if (tokens >= 500000) {
                        player.sendMessage(PrefixManager.COOKIECLICKER + "§7Du hast erfolgreich das §6Level 3 §7erworben§8.");
                        player.closeInventory();
                        TitleAPI.sendTitle(player, 10,15,10,"§8» §e§lCLICKER §8«", "§6§oLevel 3 §7wurde erfolgreich erworben§8");


                        new CookieSettings(player.getUniqueId()).setLevel(3);
                        new TokenAPI(player).removeTokens(500000);
                        CookieAPI.playBigSuccessSound(player);
                    } else {
                        player.sendMessage(PrefixManager.COOKIECLICKER + "§7Dafür fehlen dir noch §e" + CookieAPI.getFormated(getDifference((int) tokens, 500000)) + " §7Tokens§8.");
                    }
                } else if(new CookieSettings(player.getUniqueId()).getLevel() == 3) {
                    player.sendMessage(PrefixManager.COOKIECLICKER + "§cDu besitzt bereits dieses Level§8.");
                } else if(new CookieSettings(player.getUniqueId()).getLevel() > 3) {
                    player.sendMessage(PrefixManager.COOKIECLICKER + "§cDu besitzt ein höheres Level§8.");
                } else {
                    player.sendMessage(PrefixManager.COOKIECLICKER + "§7Du musst zuerst §6Level 2 §7erworben haben§8.");
                }


            } else if(e.getRawSlot() == 23) {

                final double tokens = new TokenAPI(player).getTokens();


                if (new CookieSettings(player.getUniqueId()).getLevel() == 3) {
                    if (tokens >= 750000) {
                        player.sendMessage(PrefixManager.COOKIECLICKER + "§7Du hast erfolgreich das §6Level 4 §7erworben§8.");
                        player.closeInventory();
                        TitleAPI.sendTitle(player, 10,15,10,"§8» §e§lCLICKER §8«", "§6§oLevel 4 §7wurde erfolgreich erworben§8");

                        new CookieSettings(player.getUniqueId()).setLevel(4);
                        new TokenAPI(player).removeTokens(750000);
                        CookieAPI.playBigSuccessSound(player);
                    } else {
                        player.sendMessage(PrefixManager.COOKIECLICKER + "§7Dafür fehlen dir noch §e" + CookieAPI.getFormated(getDifference((int) tokens, 750000)) + " §7Tokens§8.");
                    }
                } else if(new CookieSettings(player.getUniqueId()).getLevel() == 4) {
                    player.sendMessage(PrefixManager.COOKIECLICKER + "§cDu besitzt bereits dieses Level§8.");
                } else if(new CookieSettings(player.getUniqueId()).getLevel() > 4) {
                    player.sendMessage(PrefixManager.COOKIECLICKER + "§cDu besitzt ein höheres Level§8.");
                } else {
                    player.sendMessage(PrefixManager.COOKIECLICKER + "§7Du musst zuerst §6Level 3 §7erworben haben§8.");
                }


            } else if(e.getRawSlot() == 24) {

                final double tokens = new TokenAPI(player).getTokens();

                if (new CookieSettings(player.getUniqueId()).getLevel() == 4) {
                    if (tokens >= 1000000) {
                        player.sendMessage(PrefixManager.COOKIECLICKER + "§7Du hast erfolgreich das §6Level 5 §7erworben§8.");
                        player.closeInventory();
                        TitleAPI.sendTitle(player, 10, 15, 10, "§8» §e§lCLICKER §8«", "§6§oLevel 5 §7wurde erfolgreich erworben§8");


                        new CookieSettings(player.getUniqueId()).setLevel(5);
                        new TokenAPI(player).removeTokens(1000000);
                        CookieAPI.playBigSuccessSound(player);

                    } else {
                        player.sendMessage(PrefixManager.COOKIECLICKER + "§7Dafür fehlen dir noch §e" + CookieAPI.getFormated(getDifference((int) tokens, 1000000)) + " §7Tokens§8.");
                    }
                } else if (new CookieSettings(player.getUniqueId()).getLevel() == 5) {
                    player.sendMessage(PrefixManager.COOKIECLICKER + "§cDu besitzt bereits dieses Level§8.");
                } else if (new CookieSettings(player.getUniqueId()).getLevel() > 5) {
                    player.sendMessage(PrefixManager.COOKIECLICKER + "§cDu besitzt ein höheres Level§8.");
                } else {
                    player.sendMessage(PrefixManager.COOKIECLICKER + "§7Du musst zuerst §6Level 4 §7erworben haben§8.");
                }

            } else if(e.getRawSlot() == 29) {

                final double tokens = new TokenAPI(player).getTokens();

                if(!new CookieSettings(player.getUniqueId()).getKeksFarmer()) {
                    if(tokens > 2000000) {
                        player.sendMessage(PrefixManager.COOKIECLICKER + "§7Du hast erfolgreich den §6Keksfarmer §7erworben§8.");
                        player.closeInventory();
                        TitleAPI.sendTitle(player, 10, 15, 10, "§8» §e§lCLICKER §8«", "§6§oKeksfarmer §7wurde erfolgreich erworben§8");



                        new CookieSettings(player.getUniqueId()).setKeksFarmer(true);
                        new TokenAPI(player).removeTokens(2000000);
                        CookieAPI.playBigSuccessSound(player);
                    } else {
                        player.sendMessage(PrefixManager.COOKIECLICKER + "§7Dafür fehlen dir noch §e" + CookieAPI.getFormated(getDifference((int) tokens, 2000000)) + " §7Tokens§8.");
                    }
                } else {
                    player.sendMessage(PrefixManager.COOKIECLICKER + "§cDu besitzt bereits den Keksfarmer§8.");
                }


            } else if(e.getRawSlot() == 43) {
                player.closeInventory();
                CookieGUI.openCookieClickerCookieShop(player);


            }else if(e.getRawSlot() == 37) {
                player.closeInventory();
                CookieGUI.openCookieClicker(player);
            }
        }
    }

    @EventHandler
    public void onInventoryTokenClick(final InventoryClickEvent e) {

        final Player player = (Player)e.getWhoClicked();


        if(e.getInventory().getName().equalsIgnoreCase(PrefixManager.COOKIECLICKER + " §7Cookie Cookieshop")) {

            e.setCancelled(true);


            if(e.getRawSlot() == 37) {
                player.closeInventory();
                CookieGUI.openCookieClickerTokenShop(player);
            }

            if (e.getRawSlot() == 20) {
                if (new CookieAPI(player.getUniqueId()).getCookies() >= 25000) {
                    new CookieAPI(player.getUniqueId()).removeCookies(25000);
                    SoundUtils.playSuccessSound(player);
                    player.sendMessage(PrefixManager.COOKIECLICKER + "§7Du hast die §6Cookie §7Rüstung gekauft§8!");

                    player.getInventory().addItem(new ItemManager(Material.IRON_HELMET).setName("§8»│ §e§lCOOKIE §6§LHELM").addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 6).build());
                    player.getInventory().addItem(new ItemManager(Material.IRON_CHESTPLATE).setName("§8»│ §e§lCOOKIE §6§lBRUSTPLATTE").addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 6).build());
                    player.getInventory().addItem(new ItemManager(Material.IRON_LEGGINGS).setName("§8»│ §e§lCOOKIE §6§LHOSE").addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 6).build());
                    player.getInventory().addItem(new ItemManager(Material.IRON_BOOTS).setName("§8»│ §e§lCOOKIE §6§LSCHUHE").addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 6).build());
                } else {
                    player.sendMessage(PrefixManager.COOKIECLICKER + "§7Dafür fehlen dir noch §e" + CookieAPI.getFormated(getDifference((int) new CookieAPI(player.getUniqueId()).getCookies(), 25000)) + " §7Cookies§8.");
                }
            }

            if (e.getRawSlot() == 21) {
                if (new CookieAPI(player.getUniqueId()).getCookies() >= 15000) {
                    new CookieAPI(player.getUniqueId()).removeCookies(15000);
                    SoundUtils.playSuccessSound(player);
                    player.sendMessage(PrefixManager.COOKIECLICKER + "§7Du hast das §6Cookie §7Schwert gekauft§8!");

                    player.getInventory().addItem(new ItemManager(Material.IRON_SWORD).setName("§8»│ §e§lCOOKIE §6§lSCHWERT").addEnchantment(Enchantment.DAMAGE_ALL, 6).build());
               } else {
                    player.sendMessage(PrefixManager.COOKIECLICKER + "§7Dafür fehlen dir noch §e" + CookieAPI.getFormated(getDifference((int) new CookieAPI(player.getUniqueId()).getCookies(), 15000)) + " §7Cookies§8.");
                }
            }
        }


    }
}

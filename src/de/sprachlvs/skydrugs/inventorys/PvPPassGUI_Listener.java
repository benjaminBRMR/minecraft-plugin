package de.sprachlvs.skydrugs.inventorys;

import de.sprachlvs.skydrugs.apis.stats.KillAPI;
import de.sprachlvs.skydrugs.apis.stats.TokenAPI;
import de.sprachlvs.skydrugs.manager.ItemManager;
import de.sprachlvs.skydrugs.manager.PrefixManager;
import de.sprachlvs.skydrugs.manager.PvPPassManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import ru.tehkode.permissions.bukkit.PermissionsEx;

import java.util.ArrayList;
import java.util.Random;

public class PvPPassGUI_Listener implements Listener {



    public static ArrayList<ItemStack> randomSpawnEgg = new ArrayList<ItemStack>();

    public static void setup() {

        ItemStack CreeperEGG = new ItemManager(Material.MONSTER_EGG).setData(50).build();
        ItemStack FledermausEGG = new ItemManager(Material.MONSTER_EGG).setData(65).build();
        ItemStack HöhlenspinnenEGG = new ItemManager(Material.MONSTER_EGG).setData(59).build();
        ItemStack HuhnEGG = new ItemManager(Material.MONSTER_EGG).setData(93).build();
        ItemStack KuhEGG = new ItemManager(Material.MONSTER_EGG).setData(92).build();
        ItemStack EndermanEGG = new ItemManager(Material.MONSTER_EGG).setData(58).build();
        ItemStack EndermiteEGG = new ItemManager(Material.MONSTER_EGG).setData(57).build();
        ItemStack WächterEGG = new ItemManager(Material.MONSTER_EGG).setData(68).build();
        ItemStack PferdEGG = new ItemManager(Material.MONSTER_EGG).setData(100).build();
        ItemStack MagmaCubeEGG = new ItemManager(Material.MONSTER_EGG).setData(62).build();
        ItemStack PilzkuhEGG = new ItemManager(Material.MONSTER_EGG).setData(96).build();
        ItemStack OcelotEGG = new ItemManager(Material.MONSTER_EGG).setData(98).build();
        ItemStack SchweinEGG = new ItemManager(Material.MONSTER_EGG).setData(90).build();
        ItemStack HaseEGG = new ItemManager(Material.MONSTER_EGG).setData(101).build();
        ItemStack SchafEGG = new ItemManager(Material.MONSTER_EGG).setData(91).build();
        ItemStack SkelettEGG = new ItemManager(Material.MONSTER_EGG).setData(51).build();
        ItemStack SchleimEGG = new ItemManager(Material.MONSTER_EGG).setData(55).build();
        ItemStack SpinnenEGG = new ItemManager(Material.MONSTER_EGG).setData(52).build();
        ItemStack TintenfischEGG = new ItemManager(Material.MONSTER_EGG).setData(94).build();
        ItemStack DorfbewohnerEGG = new ItemManager(Material.MONSTER_EGG).setData(120).build();
        ItemStack HexenEGG = new ItemManager(Material.MONSTER_EGG).setData(66).build();
        ItemStack WolfEGG = new ItemManager(Material.MONSTER_EGG).setData(95).build();
        ItemStack ZombieEGG = new ItemManager(Material.MONSTER_EGG).setData(54).build();
        ItemStack ZombiePigmanEGG = new ItemManager(Material.MONSTER_EGG).setData(57).build();

        randomSpawnEgg.add(CreeperEGG);
        randomSpawnEgg.add(FledermausEGG);
        randomSpawnEgg.add(HöhlenspinnenEGG);
        randomSpawnEgg.add(HuhnEGG);
        randomSpawnEgg.add(KuhEGG);
        randomSpawnEgg.add(EndermanEGG);
        randomSpawnEgg.add(EndermiteEGG);
        randomSpawnEgg.add(WächterEGG);
        randomSpawnEgg.add(PferdEGG);
        randomSpawnEgg.add(MagmaCubeEGG);
        randomSpawnEgg.add(PilzkuhEGG);
        randomSpawnEgg.add(OcelotEGG);
        randomSpawnEgg.add(SchweinEGG);
        randomSpawnEgg.add(HaseEGG);
        randomSpawnEgg.add(SchafEGG);
        randomSpawnEgg.add(SkelettEGG);
        randomSpawnEgg.add(SchleimEGG);
        randomSpawnEgg.add(SpinnenEGG);
        randomSpawnEgg.add(TintenfischEGG);
        randomSpawnEgg.add(DorfbewohnerEGG);
        randomSpawnEgg.add(HexenEGG);
        randomSpawnEgg.add(WolfEGG);
        randomSpawnEgg.add(ZombieEGG);
        randomSpawnEgg.add(ZombiePigmanEGG);
    }



    @EventHandler
    public void onClick(final InventoryClickEvent event) {

        final Player player = (Player)event.getWhoClicked();
        TokenAPI tokens = new TokenAPI(player);

        if (event.getInventory().getName().equalsIgnoreCase("§8»│ §6§lPVP§8 - §6§lPASS §7S2")) {
            event.setCancelled(true);

            if (event.getRawSlot() == 23) {
                player.playSound(player.getLocation(), Sound.NOTE_BASS, 100, 14);
                player.sendMessage(PrefixManager.PVP_PASS + "§7Diese Seite existiert nicht§8.");
            }

            if (event.getRawSlot() == 21) {
                player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 100, 14);
                player.sendMessage(PrefixManager.PVP_PASS + "§7Der §ePvP§8-§ePass §8(§7Seite §6I§8) §7wurde geöffnet§8.");
                PvPPassGUI.openPvPPassInventorySite1(player);
            }

            if (event.getRawSlot() == 10) {

                if (new KillAPI(player).getKills() > 39) {
                    if (!new PvPPassManager().getStufe(player.getUniqueId(), 8)) {
                        if (PermissionsEx.getUser(player).inGroup("Salvia") || PermissionsEx.getUser(player).inGroup("Booster") || PermissionsEx.getUser(player).inGroup("Creator") || PermissionsEx.getUser(player).inGroup("Content") || PermissionsEx.getUser(player).inGroup("Supporter") || PermissionsEx.getUser(player).inGroup("Moderator") || PermissionsEx.getUser(player).inGroup("SrModerator") || PermissionsEx.getUser(player).inGroup("Developer") || PermissionsEx.getUser(player).inGroup("Admin") || PermissionsEx.getUser(player).inGroup("Owner")) {

                            ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
                            String command = "crate key " + player.getName() + " salvia 2";
                            Bukkit.dispatchCommand(console, command);

                            new PvPPassManager().setStufe(player.getUniqueId(), 8);
                            event.getInventory().setItem(10, PvPPassGUI.Stufe8Claimed);
                            player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 100, 14);
                            player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast deine §6Stufe §eVIII §7Belohnung erhalten§8.");
                            player.sendMessage(PrefixManager.PVP_PASS + "§8+§e2§8x §5Salvia §7Schlüssel");
                        } else {

                            ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
                            String command = "crate key " + player.getName() + " salvia 1";
                            Bukkit.dispatchCommand(console, command);

                            new PvPPassManager().setStufe(player.getUniqueId(), 8);
                            event.getInventory().setItem(10, PvPPassGUI.Stufe8Claimed);
                            player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 100, 14);
                            player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast deine §6Stufe §eVIII §7Belohnung erhalten§8.");
                            player.sendMessage(PrefixManager.PVP_PASS + "§8+§e1§8x §5Salvia §7Schlüssel");
                        }
                    } else {
                        player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast deine Belohnung §ebereits §7abgeholt§8.");
                        player.playSound(player.getLocation(), Sound.ANVIL_LAND, 100, 14);
                    }
                }
            }

            if (event.getRawSlot() == 11) {

                if (new KillAPI(player).getKills() > 44) {
                    if (!new PvPPassManager().getStufe(player.getUniqueId(),9)) {
                        if (PermissionsEx.getUser(player).inGroup("Salvia") || PermissionsEx.getUser(player).inGroup("Booster") || PermissionsEx.getUser(player).inGroup("Creator") || PermissionsEx.getUser(player).inGroup("Content") || PermissionsEx.getUser(player).inGroup("Supporter") || PermissionsEx.getUser(player).inGroup("Moderator") || PermissionsEx.getUser(player).inGroup("SrModerator") || PermissionsEx.getUser(player).inGroup("Developer") || PermissionsEx.getUser(player).inGroup("Admin") || PermissionsEx.getUser(player).inGroup("Owner")) {

                            player.getInventory().addItem(new ItemManager(Material.GOLDEN_APPLE).setData(1).setAnzahl(24).build());

                            new PvPPassManager().setStufe(player.getUniqueId(), 9);
                            event.getInventory().setItem(11, PvPPassGUI.Stufe9Claimed);
                            player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 100, 14);
                            player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast deine §6Stufe §eIX §7Belohnung erhalten§8.");
                            player.sendMessage(PrefixManager.PVP_PASS + "§8+§e24§8x §7Goldäpfel");
                        } else {

                            player.getInventory().addItem(new ItemManager(Material.GOLDEN_APPLE).setData(1).setAnzahl(12).build());

                            new PvPPassManager().setStufe(player.getUniqueId(), 9);
                            event.getInventory().setItem(11, PvPPassGUI.Stufe9Claimed);
                            player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 100, 14);
                            player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast deine §6Stufe §eIX §7Belohnung erhalten§8.");
                            player.sendMessage(PrefixManager.PVP_PASS + "§8+§e12§8x §7Goldäpfel");
                        }
                    } else {
                        player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast deine Belohnung §ebereits §7abgeholt§8.");
                        player.playSound(player.getLocation(), Sound.ANVIL_LAND, 100, 14);
                    }
                }
            }

            if (event.getRawSlot() == 12) {

                if (new KillAPI(player).getKills() > 49) {
                    if (!new PvPPassManager().getStufe(player.getUniqueId(),10)) {
                        if (PermissionsEx.getUser(player).inGroup("Salvia") || PermissionsEx.getUser(player).inGroup("Booster") || PermissionsEx.getUser(player).inGroup("Creator") || PermissionsEx.getUser(player).inGroup("Content") || PermissionsEx.getUser(player).inGroup("Supporter") || PermissionsEx.getUser(player).inGroup("Moderator") || PermissionsEx.getUser(player).inGroup("SrModerator") || PermissionsEx.getUser(player).inGroup("Developer") || PermissionsEx.getUser(player).inGroup("Admin") || PermissionsEx.getUser(player).inGroup("Owner")) {

                            ItemStack gutschein = new ItemManager(Material.PAPER).setName("§8»│ §a§lFLY §7Gutschein §8(§230§7min.§8)").setLore(new String[]{"", "§8➥ §7Rechtsklicke diesen Gutschein und", "§8➥ §7erhalte §a30§7min§8. §7Flugdauer§8.", ""}).setAnzahl(2).build();
                            player.getInventory().addItem(gutschein);

                            new PvPPassManager().setStufe(player.getUniqueId(), 10);
                            event.getInventory().setItem(12, PvPPassGUI.Stufe10Claimed);
                            player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 100, 14);
                            player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast deine §6Stufe §eX §7Belohnung erhalten§8.");
                            player.sendMessage(PrefixManager.PVP_PASS + "§8+§e2§8x §8»│ §a§lFLY §7Gutschein §8(§230§7min.§8)");
                        } else {

                            ItemStack gutschein = new ItemManager(Material.PAPER).setName("§8»│ §a§lFLY §7Gutschein §8(§230§7min.§8)").setLore(new String[]{"", "§8➥ §7Rechtsklicke diesen Gutschein und", "§8➥ §7erhalte §a30§7min§8. §7Flugdauer§8.", ""}).build();
                            player.getInventory().addItem(gutschein);

                            new PvPPassManager().setStufe(player.getUniqueId(), 10);
                            event.getInventory().setItem(12, PvPPassGUI.Stufe10Claimed);
                            player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 100, 14);
                            player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast deine §6Stufe §eX §7Belohnung erhalten§8.");
                            player.sendMessage(PrefixManager.PVP_PASS + "§8+§e1§8x §8»│ §a§lFLY §7Gutschein §8(§230§7min.§8)");
                        }
                    } else {
                        player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast deine Belohnung §ebereits §7abgeholt§8.");
                        player.playSound(player.getLocation(), Sound.ANVIL_LAND, 100, 14);
                    }
                }
            }

            if (event.getRawSlot() == 13) {
                if (new KillAPI(player).getKills() > 54) {
                    if (!new PvPPassManager().getStufe(player.getUniqueId(),12)) {
                        if (PermissionsEx.getUser(player).inGroup("Salvia") || PermissionsEx.getUser(player).inGroup("Booster") || PermissionsEx.getUser(player).inGroup("Creator") || PermissionsEx.getUser(player).inGroup("Content") || PermissionsEx.getUser(player).inGroup("Supporter") || PermissionsEx.getUser(player).inGroup("Moderator") || PermissionsEx.getUser(player).inGroup("SrModerator") || PermissionsEx.getUser(player).inGroup("Developer") || PermissionsEx.getUser(player).inGroup("Admin") || PermissionsEx.getUser(player).inGroup("Owner")) {

                            tokens.addTokens(30000);

                            new PvPPassManager().setStufe(player.getUniqueId(), 12);
                            event.getInventory().setItem(14, PvPPassGUI.Stufe12Claimed);
                            player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 100, 14);
                            player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast deine §6Stufe §eXII §7Belohnung erhalten§8.");
                            player.sendMessage(PrefixManager.PVP_PASS + "§8+§e30.000 §7Tokens");
                        } else {

                            tokens.addTokens(15000);

                            new PvPPassManager().setStufe(player.getUniqueId(), 12);
                            event.getInventory().setItem(14, PvPPassGUI.Stufe12Claimed);
                            player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 100, 14);
                            player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast deine §6Stufe §eXII §7Belohnung erhalten§8.");
                            player.sendMessage(PrefixManager.PVP_PASS + "§8+§e15.000 §7Tokens");
                        }
                    } else {
                        player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast deine Belohnung §ebereits §7abgeholt§8.");
                        player.playSound(player.getLocation(), Sound.ANVIL_LAND, 100, 14);
                    }
                }
            }

            if (event.getRawSlot() == 14) {

                if (new KillAPI(player).getKills() > 59) {
                    if (!new PvPPassManager().getStufe(player.getUniqueId(),11)) {
                        if (PermissionsEx.getUser(player).inGroup("Salvia") || PermissionsEx.getUser(player).inGroup("Booster") || PermissionsEx.getUser(player).inGroup("Creator") || PermissionsEx.getUser(player).inGroup("Content") || PermissionsEx.getUser(player).inGroup("Supporter") || PermissionsEx.getUser(player).inGroup("Moderator") || PermissionsEx.getUser(player).inGroup("SrModerator") || PermissionsEx.getUser(player).inGroup("Developer") || PermissionsEx.getUser(player).inGroup("Admin") || PermissionsEx.getUser(player).inGroup("Owner")) {

                            player.getInventory().addItem(new ItemManager(Material.DIAMOND_HELMET).setAnzahl(2).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3).setAnzahl(1).build());
                            player.getInventory().addItem(new ItemManager(Material.DIAMOND_CHESTPLATE).setAnzahl(2).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3).setAnzahl(1).build());
                            player.getInventory().addItem(new ItemManager(Material.DIAMOND_LEGGINGS).setAnzahl(2).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3).setAnzahl(1).build());
                            player.getInventory().addItem(new ItemManager(Material.DIAMOND_BOOTS).setAnzahl(2).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3).setAnzahl(1).build());


                            new PvPPassManager().setStufe(player.getUniqueId(), 11);
                            event.getInventory().setItem(13, PvPPassGUI.Stufe11Claimed);
                            player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 100, 14);
                            player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast deine §6Stufe §eXI §7Belohnung erhalten§8.");
                            player.sendMessage(PrefixManager.PVP_PASS + "§8+§e2§8x §7Prot §6III §7Helm");
                            player.sendMessage(PrefixManager.PVP_PASS + "§8+§e2§8x §7Prot §6III §7Brustplatte");
                            player.sendMessage(PrefixManager.PVP_PASS + "§8+§e2§8x §7Prot §6III §7Hose");
                            player.sendMessage(PrefixManager.PVP_PASS + "§8+§e2§8x §7Prot §6III §7Schuhe");
                        } else {

                            player.getInventory().addItem(new ItemManager(Material.DIAMOND_HELMET).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3).setAnzahl(1).build());
                            player.getInventory().addItem(new ItemManager(Material.DIAMOND_CHESTPLATE).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3).setAnzahl(1).build());
                            player.getInventory().addItem(new ItemManager(Material.DIAMOND_LEGGINGS).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3).setAnzahl(1).build());
                            player.getInventory().addItem(new ItemManager(Material.DIAMOND_BOOTS).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3).setAnzahl(1).build());

                            new PvPPassManager().setStufe(player.getUniqueId(), 11);
                            event.getInventory().setItem(13, PvPPassGUI.Stufe11Claimed);
                            player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 100, 14);
                            player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast deine §6Stufe §eXI §7Belohnung erhalten§8.");
                            player.sendMessage(PrefixManager.PVP_PASS + "§8+§e1§8x §7Prot §6III §7Helm");
                            player.sendMessage(PrefixManager.PVP_PASS + "§8+§e1§8x §7Prot §6III §7Brustplatte");
                            player.sendMessage(PrefixManager.PVP_PASS + "§8+§e1§8x §7Prot §6III §7Hose");
                            player.sendMessage(PrefixManager.PVP_PASS + "§8+§e1§8x §7Prot §6III §7Schuhe");
                        }
                    } else {
                        player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast deine Belohnung §ebereits §7abgeholt§8.");
                        player.playSound(player.getLocation(), Sound.ANVIL_LAND, 100, 14);
                    }
                }
            }

            if (event.getRawSlot() == 15) {

                if (new KillAPI(player).getKills() > 64) {
                    if (!new PvPPassManager().getStufe(player.getUniqueId(),13)) {
                        if (PermissionsEx.getUser(player).inGroup("Salvia") || PermissionsEx.getUser(player).inGroup("Booster") || PermissionsEx.getUser(player).inGroup("Creator") || PermissionsEx.getUser(player).inGroup("Content") || PermissionsEx.getUser(player).inGroup("Supporter") || PermissionsEx.getUser(player).inGroup("Moderator") || PermissionsEx.getUser(player).inGroup("SrModerator") || PermissionsEx.getUser(player).inGroup("Developer") || PermissionsEx.getUser(player).inGroup("Admin") || PermissionsEx.getUser(player).inGroup("Owner")) {

                            player.getInventory().addItem(new ItemManager(Material.POTION).setData(16449).setAnzahl(2).build());
                            player.getInventory().addItem(new ItemManager(Material.POTION).setData(16459).setAnzahl(2).build());
                            player.getInventory().addItem(new ItemManager(Material.POTION).setData(16457).setAnzahl(2).build());
                            player.getInventory().addItem(new ItemManager(Material.POTION).setData(16450).setAnzahl(2).build());
                            player.getInventory().addItem(new ItemManager(Material.POTION).setData(16451).setAnzahl(2).build());

                            new PvPPassManager().setStufe(player.getUniqueId(), 13);
                            event.getInventory().setItem(15, PvPPassGUI.Stufe13Claimed);
                            player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 100, 14);
                            player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast deine §6Stufe §eXIII §7Belohnung erhalten§8.");
                            player.sendMessage(PrefixManager.PVP_PASS + "§8+§e1§8x §7Regenerationstrank");
                            player.sendMessage(PrefixManager.PVP_PASS + "§8+§e1§8x §7Sprungkrafttrank");
                            player.sendMessage(PrefixManager.PVP_PASS + "§8+§e1§8x §7Schnelligkeitstrank");
                            player.sendMessage(PrefixManager.PVP_PASS + "§8+§e1§8x §7Stärketrank");
                            player.sendMessage(PrefixManager.PVP_PASS + "§8+§e1§8x §7Feuerressistenztrank");
                            player.sendMessage(PrefixManager.PVP_PASS + "§8+§e1§8x §7Regenerationstrank");
                        } else {

                            player.getInventory().addItem(new ItemManager(Material.POTION).setData(16449).build());
                            player.getInventory().addItem(new ItemManager(Material.POTION).setData(16459).build());
                            player.getInventory().addItem(new ItemManager(Material.POTION).setData(16457).build());
                            player.getInventory().addItem(new ItemManager(Material.POTION).setData(16450).build());
                            player.getInventory().addItem(new ItemManager(Material.POTION).setData(16451).build());

                            new PvPPassManager().setStufe(player.getUniqueId(), 13);
                            event.getInventory().setItem(15, PvPPassGUI.Stufe13Claimed);
                            player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 100, 14);
                            player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast deine §6Stufe §eXIII §7Belohnung erhalten§8.");
                            player.sendMessage(PrefixManager.PVP_PASS + "§8+§e1§8x §7Regenerationstrank");
                            player.sendMessage(PrefixManager.PVP_PASS + "§8+§e1§8x §7Sprungkrafttrank");
                            player.sendMessage(PrefixManager.PVP_PASS + "§8+§e1§8x §7Schnelligkeitstrank");
                            player.sendMessage(PrefixManager.PVP_PASS + "§8+§e1§8x §7Stärketrank");
                            player.sendMessage(PrefixManager.PVP_PASS + "§8+§e1§8x §7Feuerressistenztrank");
                            player.sendMessage(PrefixManager.PVP_PASS + "§8+§e1§8x §7Regenerationstrank");
                        }
                    } else {
                        player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast deine Belohnung §ebereits §7abgeholt§8.");
                        player.playSound(player.getLocation(), Sound.ANVIL_LAND, 100, 14);
                    }
                }
            }

            if (event.getRawSlot() == 16) {
                if (new KillAPI(player).getKills() > 69) {
                    if (!new PvPPassManager().getStufe(player.getUniqueId(), 14)) {
                        if (PermissionsEx.getUser(player).inGroup("Salvia") || PermissionsEx.getUser(player).inGroup("Booster") || PermissionsEx.getUser(player).inGroup("Creator") || PermissionsEx.getUser(player).inGroup("Content") || PermissionsEx.getUser(player).inGroup("Supporter") || PermissionsEx.getUser(player).inGroup("Moderator") || PermissionsEx.getUser(player).inGroup("SrModerator") || PermissionsEx.getUser(player).inGroup("Developer") || PermissionsEx.getUser(player).inGroup("Admin") || PermissionsEx.getUser(player).inGroup("Owner")) {

                            ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
                            String command = "crate key " + player.getName() + " skyblock 32";
                            Bukkit.dispatchCommand(console, command);

                            new PvPPassManager().setStufe(player.getUniqueId(), 14);
                            event.getInventory().setItem(16, PvPPassGUI.Stufe14Claimed);
                            player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 100, 14);
                            player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast deine §6Stufe §eXIV §7Belohnung erhalten§8.");
                            player.sendMessage(PrefixManager.PVP_PASS + "§8+§e32§8x §aSkyblock §7Schlüssel");
                        } else {

                            ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
                            String command = "crate key " + player.getName() + " skyblock 16";
                            Bukkit.dispatchCommand(console, command);

                            new PvPPassManager().setStufe(player.getUniqueId(), 14);
                            event.getInventory().setItem(16, PvPPassGUI.Stufe14Claimed);
                            player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 100, 14);
                            player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast deine §6Stufe §eXIV §7Belohnung erhalten§8.");
                            player.sendMessage(PrefixManager.PVP_PASS + "§8+§e16§8x §aSkyblock §7Schlüssel");
                        }
                    } else {
                        player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast deine Belohnung §ebereits §7abgeholt§8.");
                        player.playSound(player.getLocation(), Sound.ANVIL_LAND, 100, 14);
                    }
                }
            }

        }

        if (event.getInventory().getName().equalsIgnoreCase("§8»│ §6§lPVP§8 - §6§lPASS §7S1")) {
            event.setCancelled(true);

            if (event.getRawSlot() == 23) {

                player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 100, 14);
                player.sendMessage(PrefixManager.PVP_PASS + "§7Der §ePvP§8-§ePass §8(§7Seite §6II§8) §7wurde geöffnet§8.");
                PvPPassGUI.openPvPPassInventorySite2(player);
            }

            if (event.getRawSlot() == 10) {

                if(new KillAPI(player).getKills() > 4) {
                    if (!new PvPPassManager().getStufe(player.getUniqueId(), 1)) {
                        if (PermissionsEx.getUser(player).inGroup("Salvia") || PermissionsEx.getUser(player).inGroup("Booster") || PermissionsEx.getUser(player).inGroup("Creator") || PermissionsEx.getUser(player).inGroup("Content") || PermissionsEx.getUser(player).inGroup("Supporter") || PermissionsEx.getUser(player).inGroup("Moderator") || PermissionsEx.getUser(player).inGroup("SrModerator") || PermissionsEx.getUser(player).inGroup("Developer") || PermissionsEx.getUser(player).inGroup("Admin") || PermissionsEx.getUser(player).inGroup("Owner")) {
                            tokens.addTokens(2000);
                            new PvPPassManager().setStufe(player.getUniqueId(), 1);
                            event.getInventory().setItem(10, PvPPassGUI.Stufe1Claimed);
                            player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 100, 14);
                            player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast deine §6Stufe §eI §7Belohnung erhalten§8.");
                            player.sendMessage(PrefixManager.PVP_PASS + "§8+§e2§8.§e000 §7Tokens");
                        } else {

                            tokens.addTokens(1000);
                            new PvPPassManager().setStufe(player.getUniqueId(), 1);
                            event.getInventory().setItem(10, PvPPassGUI.Stufe1Claimed);
                            player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 100, 14);
                            player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast deine §6Stufe §eI §7Belohnung erhalten§8.");
                            player.sendMessage(PrefixManager.PVP_PASS + "§8+§e1§8.§e000 §7Tokens");
                        }
                    } else {
                        player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast deine Belohnung §ebereits §7abgeholt§8.");
                        player.playSound(player.getLocation(), Sound.ANVIL_LAND, 100, 14);
                    }
                }
            }

            if (event.getRawSlot() == 11) {

                if(new KillAPI(player).getKills() > 9) {
                    if (!new PvPPassManager().getStufe(player.getUniqueId(), 2)) {
                        if (PermissionsEx.getUser(player).inGroup("Salvia") || PermissionsEx.getUser(player).inGroup("Booster") || PermissionsEx.getUser(player).inGroup("Creator") || PermissionsEx.getUser(player).inGroup("Content") || PermissionsEx.getUser(player).inGroup("Supporter") || PermissionsEx.getUser(player).inGroup("Moderator") || PermissionsEx.getUser(player).inGroup("SrModerator") || PermissionsEx.getUser(player).inGroup("Developer") || PermissionsEx.getUser(player).inGroup("Admin") || PermissionsEx.getUser(player).inGroup("Owner")) {
                            ItemStack DiaProt2Helm = new ItemManager(Material.DIAMOND_HELMET).setName("§8»│ §6§lStufe §e§lII §7Helm").addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2).addEnchantment(Enchantment.DURABILITY, 3).setAnzahl(2).build();
                            ItemStack DiaProt2Brustplatte = new ItemManager(Material.DIAMOND_CHESTPLATE).setName("§8»│ §6§lStufe §e§lII §7Brustplatte").addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2).addEnchantment(Enchantment.DURABILITY, 3).setAnzahl(2).build();
                            ItemStack DiaProt2Leggings = new ItemManager(Material.DIAMOND_LEGGINGS).setName("§8»│ §6§lStufe §e§lII §7Hose").addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2).addEnchantment(Enchantment.DURABILITY, 3).setAnzahl(2).build();
                            ItemStack DiaProt2Schuhe = new ItemManager(Material.DIAMOND_BOOTS).setName("§8»│ §6§lStufe §e§lII §7Schuhe").addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2).addEnchantment(Enchantment.DURABILITY, 3).setAnzahl(2).build();

                            player.getInventory().addItem(DiaProt2Helm);
                            player.getInventory().addItem(DiaProt2Brustplatte);
                            player.getInventory().addItem(DiaProt2Leggings);
                            player.getInventory().addItem(DiaProt2Schuhe);

                            new PvPPassManager().setStufe(player.getUniqueId(), 2);
                            event.getInventory().setItem(11, PvPPassGUI.Stufe2Claimed);
                            player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 100, 14);
                            player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast deine §6Stufe §eII §7Belohnung erhalten§8.");
                            player.sendMessage(PrefixManager.PVP_PASS + "§8+§e2§8x §7Prot §6II §7Helm");
                            player.sendMessage(PrefixManager.PVP_PASS + "§8+§e2§8x §7Prot §6II §7Brustplatte");
                            player.sendMessage(PrefixManager.PVP_PASS + "§8+§e2§8x §7Prot §6II §7Hose");
                            player.sendMessage(PrefixManager.PVP_PASS + "§8+§e2§8x §7Prot §6II §7Schuhe");

                        } else {

                            ItemStack DiaProt2Helm = new ItemManager(Material.DIAMOND_HELMET).setName("§8»│ §6§lStufe §e§lII §7Helm").addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2).addEnchantment(Enchantment.DURABILITY, 3).setAnzahl(1).build();
                            ItemStack DiaProt2Brustplatte = new ItemManager(Material.DIAMOND_CHESTPLATE).setName("§8»│ §6§lStufe §e§lII §7Brustplatte").addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2).addEnchantment(Enchantment.DURABILITY, 3).setAnzahl(1).build();
                            ItemStack DiaProt2Leggings = new ItemManager(Material.DIAMOND_LEGGINGS).setName("§8»│ §6§lStufe §e§lII §7Hose").addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2).addEnchantment(Enchantment.DURABILITY, 3).setAnzahl(1).build();
                            ItemStack DiaProt2Schuhe = new ItemManager(Material.DIAMOND_BOOTS).setName("§8»│ §6§lStufe §e§lII §7Schuhe").addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2).addEnchantment(Enchantment.DURABILITY, 3).setAnzahl(1).build();

                            player.getInventory().addItem(DiaProt2Helm);
                            player.getInventory().addItem(DiaProt2Brustplatte);
                            player.getInventory().addItem(DiaProt2Leggings);
                            player.getInventory().addItem(DiaProt2Schuhe);

                            new PvPPassManager().setStufe(player.getUniqueId(), 2);
                            event.getInventory().setItem(11, PvPPassGUI.Stufe2Claimed);
                            player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 100, 14);
                            player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast deine §6Stufe §eII §7Belohnung erhalten§8.");
                            player.sendMessage(PrefixManager.PVP_PASS + "§8+§e1§8x §7Prot §6II §7Helm");
                            player.sendMessage(PrefixManager.PVP_PASS + "§8+§e1§8x §7Prot §6II §7Brustplatte");
                            player.sendMessage(PrefixManager.PVP_PASS + "§8+§e1§8x §7Prot §6II §7Hose");
                            player.sendMessage(PrefixManager.PVP_PASS + "§8+§e1§8x §7Prot §6II §7Schuhe");
                        }
                    } else {
                        player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast deine Belohnung §ebereits §7abgeholt§8.");
                        player.playSound(player.getLocation(), Sound.ANVIL_LAND, 100, 14);
                    }
                }
            }

            if (event.getRawSlot() == 12) {

                if(new KillAPI(player).getKills() > 14) {
                    if (!new PvPPassManager().getStufe(player.getUniqueId(), 3)) {
                        if (PermissionsEx.getUser(player).inGroup("Salvia") || PermissionsEx.getUser(player).inGroup("Booster") || PermissionsEx.getUser(player).inGroup("Creator") || PermissionsEx.getUser(player).inGroup("Content") || PermissionsEx.getUser(player).inGroup("Supporter") || PermissionsEx.getUser(player).inGroup("Moderator") || PermissionsEx.getUser(player).inGroup("SrModerator") || PermissionsEx.getUser(player).inGroup("Developer") || PermissionsEx.getUser(player).inGroup("Admin") || PermissionsEx.getUser(player).inGroup("Owner")) {
                            ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
                            String command = "crate key " + player.getName() + " skyblock 6";
                            Bukkit.dispatchCommand(console, command);

                            new PvPPassManager().setStufe(player.getUniqueId(), 3);
                            event.getInventory().setItem(12, PvPPassGUI.Stufe3Claimed);
                            player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 100, 14);
                            player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast deine §6Stufe §eIII §7Belohnung erhalten§8.");
                            player.sendMessage(PrefixManager.PVP_PASS + "§8+§e6§8x §aSkyblock §7Schlüssel");

                        } else {

                            ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
                            String command = "crate key " + player.getName() + " skyblock 3";
                            Bukkit.dispatchCommand(console, command);

                            event.getInventory().setItem(12, PvPPassGUI.Stufe3Claimed);
                            player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 100, 14);
                            player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast deine §6Stufe §eIII §7Belohnung erhalten§8.");
                            player.sendMessage(PrefixManager.PVP_PASS + "§8+§e3§8x §aSkyblock §7Schlüssel");

                        }
                    } else {
                        player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast deine Belohnung §ebereits §7abgeholt§8.");
                        player.playSound(player.getLocation(), Sound.ANVIL_LAND, 100, 14);
                    }
                }
            }

            if (event.getRawSlot() == 13) {

                if(new KillAPI(player).getKills() > 19) {
                    if (!new PvPPassManager().getStufe(player.getUniqueId(), 4)) {
                        if (PermissionsEx.getUser(player).inGroup("Salvia") || PermissionsEx.getUser(player).inGroup("Booster") || PermissionsEx.getUser(player).inGroup("Creator") || PermissionsEx.getUser(player).inGroup("Content") || PermissionsEx.getUser(player).inGroup("Supporter") || PermissionsEx.getUser(player).inGroup("Moderator") || PermissionsEx.getUser(player).inGroup("SrModerator") || PermissionsEx.getUser(player).inGroup("Developer") || PermissionsEx.getUser(player).inGroup("Admin") || PermissionsEx.getUser(player).inGroup("Owner")) {
                            ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
                            String command = "crate key " + player.getName() + " aon 2";
                            Bukkit.dispatchCommand(console, command);

                            new PvPPassManager().setStufe(player.getUniqueId(), 4);
                            event.getInventory().setItem(13, PvPPassGUI.Stufe3Claimed);
                            player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 100, 14);
                            player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast deine §6Stufe §eIV §7Belohnung erhalten§8.");
                            player.sendMessage(PrefixManager.PVP_PASS + "§8+§e2§8x §cAlles§4Oder§cNichts §7Schlüssel");

                        } else {

                            ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
                            String command = "crate key " + player.getName() + " aon 1";
                            Bukkit.dispatchCommand(console, command);

                            new PvPPassManager().setStufe(player.getUniqueId(), 4);
                            event.getInventory().setItem(13, PvPPassGUI.Stufe4Claimed);
                            player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 100, 14);
                            player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast deine §6Stufe §eIV §7Belohnung erhalten§8.");
                            player.sendMessage(PrefixManager.PVP_PASS + "§8+§e1§8x §cAlles§4Oder§cNichts §7Schlüssel");
                        }
                    } else {
                        player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast deine Belohnung §ebereits §7abgeholt§8.");
                        player.playSound(player.getLocation(), Sound.ANVIL_LAND, 100, 14);
                    }
                }
            }

            if (event.getRawSlot() == 14) {

                if(new KillAPI(player).getKills() > 24) {
                    if (!new PvPPassManager().getStufe(player.getUniqueId(), 5)) {
                        if (PermissionsEx.getUser(player).inGroup("Salvia") || PermissionsEx.getUser(player).inGroup("Booster") || PermissionsEx.getUser(player).inGroup("Creator") || PermissionsEx.getUser(player).inGroup("Content") || PermissionsEx.getUser(player).inGroup("Supporter") || PermissionsEx.getUser(player).inGroup("Moderator") || PermissionsEx.getUser(player).inGroup("SrModerator") || PermissionsEx.getUser(player).inGroup("Developer") || PermissionsEx.getUser(player).inGroup("Admin") || PermissionsEx.getUser(player).inGroup("Owner")) {
                            ItemStack beacon = new ItemManager(Material.BEACON).setName("§8»│ §6§lStufe §e§lV §7Beacon").setAnzahl(2).build();
                            player.getInventory().addItem(beacon);

                            new PvPPassManager().setStufe(player.getUniqueId(), 5);
                            event.getInventory().setItem(14, PvPPassGUI.Stufe5Claimed);
                            player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 100, 14);
                            player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast deine §6Stufe §eV §7Belohnung erhalten§8.");
                            player.sendMessage(PrefixManager.PVP_PASS + "§8+§e2§8x §bBeacon");

                        } else {

                            ItemStack beacon = new ItemManager(Material.BEACON).setName("§8»│ §6§lStufe §e§lV §7Beacon").setAnzahl(1).build();
                            player.getInventory().addItem(beacon);

                            new PvPPassManager().setStufe(player.getUniqueId(), 5);
                            event.getInventory().setItem(14, PvPPassGUI.Stufe5Claimed);
                            player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 100, 14);
                            player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast deine §6Stufe §eV §7Belohnung erhalten§8.");
                            player.sendMessage(PrefixManager.PVP_PASS + "§8+§e1§8x §bBeacon");
                        }
                    } else {
                        player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast deine Belohnung §ebereits §7abgeholt§8.");
                        player.playSound(player.getLocation(), Sound.ANVIL_LAND, 100, 14);
                    }

                }
            }

            if (event.getRawSlot() == 15) {

                if(new KillAPI(player).getKills() > 29) {
                    if (!new PvPPassManager().getStufe(player.getUniqueId(),6)) {
                        if (PermissionsEx.getUser(player).inGroup("Salvia") || PermissionsEx.getUser(player).inGroup("Booster") || PermissionsEx.getUser(player).inGroup("Creator") || PermissionsEx.getUser(player).inGroup("Content") || PermissionsEx.getUser(player).inGroup("Supporter") || PermissionsEx.getUser(player).inGroup("Moderator") || PermissionsEx.getUser(player).inGroup("SrModerator") || PermissionsEx.getUser(player).inGroup("Developer") || PermissionsEx.getUser(player).inGroup("Admin") || PermissionsEx.getUser(player).inGroup("Owner")) {
                            new PvPPassManager().setStufe(player.getUniqueId(), 6);
                            tokens.addTokens(10000);
                            event.getInventory().setItem(15, PvPPassGUI.Stufe6Claimed);
                            player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 100, 14);
                            player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast deine §6Stufe §eVI §7Belohnung erhalten§8.");
                            player.sendMessage(PrefixManager.PVP_PASS + "§8+§e10§8.§e000 §7Tokens");

                        } else {

                            new PvPPassManager().setStufe(player.getUniqueId(), 6);
                            tokens.addTokens(5000);
                            event.getInventory().setItem(15, PvPPassGUI.Stufe6Claimed);
                            player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 100, 14);
                            player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast deine §6Stufe §eVI §7Belohnung erhalten§8.");
                            player.sendMessage(PrefixManager.PVP_PASS + "§8+§e5§8.§e000 §7Tokens");
                        }
                    } else {
                        player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast deine Belohnung §ebereits §7abgeholt§8.");
                        player.playSound(player.getLocation(), Sound.ANVIL_LAND, 100, 14);
                    }
                }
            }

            if (event.getRawSlot() == 16) {

                if (new KillAPI(player).getKills() > 34) {
                    if (!new PvPPassManager().getStufe(player.getUniqueId(),7)) {
                        if (PermissionsEx.getUser(player).inGroup("Salvia") || PermissionsEx.getUser(player).inGroup("Booster") || PermissionsEx.getUser(player).inGroup("Creator") || PermissionsEx.getUser(player).inGroup("Content") || PermissionsEx.getUser(player).inGroup("Supporter") || PermissionsEx.getUser(player).inGroup("Moderator") || PermissionsEx.getUser(player).inGroup("SrModerator") || PermissionsEx.getUser(player).inGroup("Developer") || PermissionsEx.getUser(player).inGroup("Admin") || PermissionsEx.getUser(player).inGroup("Owner")) {

                            int size = randomSpawnEgg.size();
                            int random = new Random().nextInt(size);

                            ItemStack picked = randomSpawnEgg.get(random);
                            picked.setAmount(2);

                            new PvPPassManager().setStufe(player.getUniqueId(), 7);
                            event.getInventory().setItem(16, PvPPassGUI.Stufe7Claimed);
                            player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 100, 14);
                            player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast deine §6Stufe §eVII §7Belohnung erhalten§8.");

                            if (picked.getData().getData() == 50) {
                                player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast ein §eCreeper Ei §7gezogen§8, §7yeah§8!");
                            } else if (picked.getData().getData() == 65) {
                                player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast ein §eFledermaus Ei §7gezogen§8, §7yeah§8!");
                            } else if (picked.getData().getData() == 59) {
                                player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast ein §eHöhlenspinnen Ei §7gezogen§8, §7yeah§8!");
                            } else if (picked.getData().getData() == 93) {
                                player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast ein §eHuhn Ei §7gezogen§8, §7yeah§8!");
                            } else if (picked.getData().getData() == 92) {
                                player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast ein §eKuh Ei §7gezogen§8, §7yeah§8!");
                            } else if (picked.getData().getData() == 58) {
                                player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast ein §eEnderman Ei §7gezogen§8, §7yeah§8!");
                            } else if (picked.getData().getData() == 57) {
                                player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast ein §eEndermite Ei §7gezogen§8, §7yeah§8!");
                            } else if (picked.getData().getData() == 68) {
                                player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast ein §eWächter Ei §7gezogen§8, §7yeah§8!");
                            } else if (picked.getData().getData() == 100) {
                                player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast ein §ePferd Ei §7gezogen§8, §7yeah§8!");
                            } else if (picked.getData().getData() == 62) {
                                player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast ein §eMagma Cube Ei §7gezogen§8, §7yeah§8!");
                            } else if (picked.getData().getData() == 96) {
                                player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast ein §ePilzkuh Ei §7gezogen§8, §7yeah§8!");
                            } else if (picked.getData().getData() == 98) {
                                player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast ein §eOzelot Ei §7gezogen§8, §7yeah§8!");
                            } else if (picked.getData().getData() == 90) {
                                player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast ein §eSchwein Ei §7gezogen§8, §7yeah§8!");
                            } else if (picked.getData().getData() == 101) {
                                player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast ein §eHasen Ei §7gezogen§8, §7yeah§8!");
                            } else if (picked.getData().getData() == 91) {
                                player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast ein §eSchaf Ei §7gezogen§8, §7yeah§8!");
                            } else if (picked.getData().getData() == 51) {
                                player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast ein §eSkelett Ei §7gezogen§8, §7yeah§8!");
                            } else if (picked.getData().getData() == 55) {
                                player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast ein §eSchleim Ei §7gezogen§8, §7yeah§8!");
                            } else if (picked.getData().getData() == 52) {
                                player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast ein §eSpinnen Ei §7gezogen§8, §7yeah§8!");
                            } else if (picked.getData().getData() == 94) {
                                player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast ein §eTintenfisch Ei §7gezogen§8, §7yeah§8!");
                            } else if (picked.getData().getData() == 120) {
                                player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast ein §eDorfbewohner Ei §7gezogen§8, §7yeah§8!");
                            } else if (picked.getData().getData() == 66) {
                                player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast ein §eHexen Ei §7gezogen§8, §7yeah§8!");
                            } else if (picked.getData().getData() == 95) {
                                player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast ein §eWolf Ei §7gezogen§8, §7yeah§8!");
                            } else if (picked.getData().getData() == 54) {
                                player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast ein §eZombie Ei §7gezogen§8, §7yeah§8!");
                            } else if (picked.getData().getData() == 57) {
                                player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast ein §eZombie Pigman Ei §7gezogen§8, §7yeah§8!");
                            }

                            player.getInventory().addItem(picked);
                        } else {

                            int size = randomSpawnEgg.size();
                            int random = new Random().nextInt(size);

                            ItemStack picked = randomSpawnEgg.get(random);
                            picked.setAmount(2);

                            new PvPPassManager().setStufe(player.getUniqueId(), 7);
                            event.getInventory().setItem(16, PvPPassGUI.Stufe7Claimed);
                            player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 100, 14);
                            player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast deine §6Stufe §eVII §7Belohnung erhalten§8.");

                            if (picked.getData().getData() == 50) {
                                player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast ein §eCreeper Ei §7gezogen§8, §7yeah§8!");
                            } else if (picked.getData().getData() == 65) {
                                player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast ein §eFledermaus Ei §7gezogen§8, §7yeah§8!");
                            } else if (picked.getData().getData() == 59) {
                                player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast ein §eHöhlenspinnen Ei §7gezogen§8, §7yeah§8!");
                            } else if (picked.getData().getData() == 93) {
                                player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast ein §eHuhn Ei §7gezogen§8, §7yeah§8!");
                            } else if (picked.getData().getData() == 92) {
                                player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast ein §eKuh Ei §7gezogen§8, §7yeah§8!");
                            } else if (picked.getData().getData() == 58) {
                                player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast ein §eEnderman Ei §7gezogen§8, §7yeah§8!");
                            } else if (picked.getData().getData() == 67) {
                                player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast ein §eEndermite Ei §7gezogen§8, §7yeah§8!");
                            } else if (picked.getData().getData() == 68) {
                                player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast ein §eWächter Ei §7gezogen§8, §7yeah§8!");
                            } else if (picked.getData().getData() == 100) {
                                player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast ein §ePferd Ei §7gezogen§8, §7yeah§8!");
                            } else if (picked.getData().getData() == 62) {
                                player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast ein §eMagma Cube Ei §7gezogen§8, §7yeah§8!");
                            } else if (picked.getData().getData() == 96) {
                                player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast ein §ePilzkuh Ei §7gezogen§8, §7yeah§8!");
                            } else if (picked.getData().getData() == 98) {
                                player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast ein §eOzelot Ei §7gezogen§8, §7yeah§8!");
                            } else if (picked.getData().getData() == 90) {
                                player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast ein §eSchwein Ei §7gezogen§8, §7yeah§8!");
                            } else if (picked.getData().getData() == 101) {
                                player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast ein §eHasen Ei §7gezogen§8, §7yeah§8!");
                            } else if (picked.getData().getData() == 91) {
                                player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast ein §eSchaf Ei §7gezogen§8, §7yeah§8!");
                            } else if (picked.getData().getData() == 51) {
                                player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast ein §eSkelett Ei §7gezogen§8, §7yeah§8!");
                            } else if (picked.getData().getData() == 55) {
                                player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast ein §eSchleim Ei §7gezogen§8, §7yeah§8!");
                            } else if (picked.getData().getData() == 52) {
                                player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast ein §eSpinnen Ei §7gezogen§8, §7yeah§8!");
                            } else if (picked.getData().getData() == 94) {
                                player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast ein §eTintenfisch Ei §7gezogen§8, §7yeah§8!");
                            } else if (picked.getData().getData() == 120) {
                                player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast ein §eDorfbewohner Ei §7gezogen§8, §7yeah§8!");
                            } else if (picked.getData().getData() == 66) {
                                player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast ein §eHexen Ei §7gezogen§8, §7yeah§8!");
                            } else if (picked.getData().getData() == 95) {
                                player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast ein §eWolf Ei §7gezogen§8, §7yeah§8!");
                            } else if (picked.getData().getData() == 54) {
                                player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast ein §eZombie Ei §7gezogen§8, §7yeah§8!");
                            } else if (picked.getData().getData() == 57) {
                                player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast ein §eZombie Pigman Ei §7gezogen§8, §7yeah§8!");
                            }

                            player.getInventory().addItem(picked);
                        }
                    } else {
                        player.sendMessage(PrefixManager.PVP_PASS + "§7Du hast deine Belohnung §ebereits §7abgeholt§8.");
                        player.playSound(player.getLocation(), Sound.ANVIL_LAND, 100, 14);
                    }
                }
            }
        }
    }
}

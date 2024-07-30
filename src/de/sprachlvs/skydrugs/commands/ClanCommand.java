package de.sprachlvs.skydrugs.commands;

import de.sprachlvs.skydrugs.SkyDrugs;
import de.sprachlvs.skydrugs.manager.PrefixManager;
import de.sprachlvs.skydrugs.utils.UUIDFetcher;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PotionSplashEvent;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ClanCommand implements CommandExecutor, Listener {
    static final File file = new File("plugins/System/clans.yml");
    static final YamlConfiguration cfg;

    static {
        cfg = YamlConfiguration.loadConfiguration(file);
    }

    Map<Player, Player> invites = new HashMap();
    Map<Player, Boolean> teleports = new HashMap();
    private int taskId;

    public static List<String> getPlayers(String clan) {
        List list = cfg.getStringList("Clans." + clan + ".Members");
        return list;
    }

    public static String getClan(Player p) {
        String clan = cfg.getString("Spieler." + UUIDFetcher.getUUID(p.getName()) + ".Clan");
        return clan;
    }

    public static String getClanTag(Player p) {
        String tag = cfg.getString("Clans." + getClan(p) + ".Name");
        return tag;
    }

    public static boolean claned(Player p) {
        return cfg.getString("Spieler." + UUIDFetcher.getUUID(p.getName()) + ".Clan") != null;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String cmdlabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("clan") && sender instanceof Player) {
            Player p = (Player) sender;
            if (args.length == 0) {
                SkyDrugs.getHeader("§3§lCLAN");
                p.sendMessage("§r");
                p.sendMessage(PrefixManager.CLAN + "§8/§3clan §3erstellen §8<§3Name§8> §8- §7Erstelle einen Clan");
                p.sendMessage(PrefixManager.CLAN + "§8/§3clan §3einladen §8<§3Name§8> §8- §7Lade Spieler ein");
                p.sendMessage(PrefixManager.CLAN + "§8/§3clan §3kick §8<§3Name§8> §8- §7Spieler kicken");
                p.sendMessage(PrefixManager.CLAN + "§8/§3clan §3annehmen §8- §7Clan Anfrage annehmen");
                p.sendMessage(PrefixManager.CLAN + "§8/§3clan §3ablehnen §8- §7Clan Anfrage ablehnen");
                p.sendMessage(PrefixManager.CLAN + "§8/§3clan §3verlassen §8- §7Verlasse den Clan");
                p.sendMessage(PrefixManager.CLAN + "§8/§3clan §3list §8- §7Ruft alle Mitglieder ab");
                p.sendMessage(PrefixManager.CLAN + "§8/§3clan §3löschen §8- §7Lösche den Clan");
                p.sendMessage("§r");
                SkyDrugs.getHeader("§3§lCLAN");
            }

            List members;
            int i;
            Player all;
            Player t;
            String clan;
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("erstellen")) {
                    p.sendMessage(PrefixManager.CLAN + "§7Syntax§8: /§3clan erstellen §8<§3Name§8>");
                }

                if (args[0].equalsIgnoreCase("einladen")) {
                    p.sendMessage(PrefixManager.CLAN + "§7Syntax§8: /§3clan einladen §8<§3Spieler§8>");
                }

                if (args[0].equalsIgnoreCase("list")) {
                    if (this.claned(p)) {
                        members = getPlayers(getClan(p));
                        p.sendMessage(PrefixManager.CLAN + "§8 ");
                        p.sendMessage(PrefixManager.CLAN + "§7Clanname§8: §3" + getClan(p) + " §8┃ §7Clanmitglieder§8: §3" + members.size() + "§8/§330");
                        p.sendMessage(PrefixManager.CLAN + "§8 ");
                        p.sendMessage(PrefixManager.CLAN + "§7Clanmitglieder§8:");

                        for (i = 0; i < members.size(); ++i) {
                            all = Bukkit.getPlayer((String) members.get(i));
                            if (all != null) {
                                p.sendMessage(PrefixManager.CLAN + " §8┃ §3" + all.getName());
                            } else {
                                p.sendMessage(PrefixManager.CLAN + " §8┃ §3" + (String) members.get(i));
                            }
                        }

                        p.sendMessage(PrefixManager.CLAN + "§8 ");
                    } else {
                        p.sendMessage(PrefixManager.CLAN + "§cDu bist aktuell in keinem Clan vertreten§8.");
                    }
                }

                if (args[0].equalsIgnoreCase("kick")) {
                    p.sendMessage(PrefixManager.CLAN + "Syntax§8: /§3clan kick §8<§3Spieler§8>");
                }

                if (args[0].equalsIgnoreCase("löschen") | args[0].equalsIgnoreCase("delete")) {
                    if (this.claned(p)) {
                        if (this.isOwner(p)) {
                            this.deleteClan(getClan(p));

                        } else {
                            p.sendMessage(PrefixManager.CLAN + "§cDu bist nicht der Inhaber des Clans§8.");
                        }
                    } else {
                        p.sendMessage(PrefixManager.CLAN + "§cDu bist aktuell in keinem Clan vertreten§8.");
                    }
                }

                if (args[0].equalsIgnoreCase("verlassen") | args[0].equalsIgnoreCase("leave")) {
                    if (this.claned(p)) {
                        if (!this.isOwner(p)) {
                            for (int i5 = 0; i5 < getPlayers(getClan(p)).size(); ++i5) {
                                t = Bukkit.getPlayer((String) getPlayers(getClan(p)).get(i5));
                                if (t != null) {
                                    t.sendMessage(PrefixManager.CLAN + "§3" + p.getName() + " §7hat den Clan verlassen§8.");
                                    Iterator var25 = Bukkit.getOnlinePlayers().iterator();

                                }
                            }

                            this.removePlayer(getClan(p), p);
                        } else {
                            p.sendMessage(PrefixManager.CLAN + "§7Syntax§8: /§3clan löschen");
                        }
                    } else {
                        p.sendMessage(PrefixManager.CLAN + "§cDu bist aktuell in keinem Clan vertreten§8.");
                    }
                }

                if (args[0].equalsIgnoreCase("ablehnen") | args[0].equalsIgnoreCase("deny")) {
                    if (!this.claned(p)) {
                        if (this.invites.containsKey(p)) {
                            p.sendMessage(PrefixManager.CLAN + "§7Du hast die Einladung abgelehnt§8.");
                            if (this.invites.get(p) != null) {
                                ((Player) this.invites.get(p)).sendMessage(PrefixManager.CLAN + "§3" + p.getName() + " §7hat die Einladung abgelehnt§8.");
                            }

                            this.invites.remove(p);
                        } else {
                            p.sendMessage(PrefixManager.CLAN + "§cDu hast keine offenen Clananfragen§8.");
                        }
                    } else {
                        p.sendMessage(PrefixManager.CLAN + "§cDu bist aktuell in keinem Clan vertreten§8.");
                    }
                }

                if (args[0].equalsIgnoreCase("annehmen") | args[0].equalsIgnoreCase("accept")) {
                    if (this.claned(p)) {
                        p.sendMessage(PrefixManager.CLAN + "§cDu bist bereits in einem Clan§8.");
                    } else if (!this.invites.containsKey(p)) {
                        p.sendMessage(PrefixManager.CLAN + "§cDu wurdest von niemandem eingeladen§8.");
                    } else {
                        clan = getClan((Player) this.invites.get(p));
                        if (getPlayers(clan).size() >= 29) {
                            p.sendMessage(PrefixManager.CLAN + "§cDieser Clan ist voll§8.");
                        } else {
                            this.addPlayer(clan, p);
                            this.invites.remove(p);

                            for (int i3 = 0; i3 < getPlayers(clan).size(); ++i3) {
                                t = Bukkit.getPlayer((String) getPlayers(clan).get(i3));
                                if (t != null) {
                                    t.sendMessage(PrefixManager.CLAN + "§7Der Spieler §3" + p.getName() + " §7ist dem Clan beigetreten§8.");
                                    Iterator var28 = Bukkit.getOnlinePlayers().iterator();

                                }
                            }
                        }
                    }
                }
            }

            if (args.length == 2) {
                if (args[0].equalsIgnoreCase("erstellen") | args[0].equalsIgnoreCase("create")) {
                    if (!this.claned(p)) {
                        clan = args[1].toLowerCase();
                        if (clan.length() <= 5) {
                            if (!this.clanExists(clan)) {
                                if (this.isValid(clan)) {
                                    this.createClan(clan, p);

                                } else {
                                    p.sendMessage(PrefixManager.CLAN + "§cDer Clan-Name ist ungültig§8.");
                                }
                            } else {
                                p.sendMessage(PrefixManager.CLAN + "§cDieser Clan existiert bereits§8.");
                            }
                        } else {
                            p.sendMessage(PrefixManager.CLAN + "§cDu kannst höchstens 5 Buchstaben verwenden§8.");
                        }
                    } else {
                        p.sendMessage(PrefixManager.CLAN + "§cDu bist bereits in einem Clan§8.");
                    }
                }

                if (args[0].equalsIgnoreCase("list")) {
                    clan = args[1].toLowerCase();
                    if (cfg.getString("Clans." + clan + ".Owner") == null) {
                        p.sendMessage(PrefixManager.CLAN + "§cDieser Clan existiert nicht§8!");
                    } else {
                        members = getPlayers(clan);
                        List<String> amount = getPlayers(clan);
                        p.sendMessage(PrefixManager.CLAN + "§8 ");
                        p.sendMessage(PrefixManager.CLAN + "§7Clanmitglieder§8: §3" + amount.size() + "§8/§330");
                        p.sendMessage(PrefixManager.CLAN + "§8 ");
                        p.sendMessage(PrefixManager.CLAN + "§7Clanmitglieder§8:");

                        for (int i2 = 0; i2 < members.size(); ++i2) {
                            all = Bukkit.getPlayer((String) members.get(i2));
                            if (all != null) {
                                p.sendMessage(PrefixManager.CLAN + " §8┃ §3" + all.getName());
                            } else {
                                p.sendMessage(PrefixManager.CLAN + " §8┃ §3" + (String) members.get(i2));
                            }
                        }
                        p.sendMessage(PrefixManager.CLAN + "§8 ");
                    }
                }

                if (args[0].equalsIgnoreCase("kick")) {
                    if (!this.claned(p)) {
                        p.sendMessage(PrefixManager.CLAN + "§cDu bist in keinem Clan vertreten§8.");
                    } else if (!this.isOwner(p)) {
                        p.sendMessage(PrefixManager.CLAN + "§cDu musst der Inhaber des Clans sein§8.");
                    } else {
                        members = getPlayers(getClan(p));
                        t = Bukkit.getPlayer(args[1]);
                        if (!members.contains(t.getName().toLowerCase())) {
                            p.sendMessage(PrefixManager.CLAN + "§cDieser Spieler ist nicht in deinem Clan§8.");
                        } else {
                            this.removePlayer(getClan(p), t);

                            for (i = 0; i < getPlayers(getClan(p)).size(); ++i) {
                                all = Bukkit.getPlayer((String) getPlayers(getClan(p)).get(i));
                                if (all != null) {
                                    all.sendMessage(PrefixManager.CLAN + "§3" + t.getName() + " §7wurde aus dem Clan geworfen§8.");
                                }

                                t.sendMessage(PrefixManager.CLAN + "§cDu wurdest aus dem Clan geworfen§8!");
                            }
                        }
                    }
                }

                if (args[0].equalsIgnoreCase("einladen") | args[0].equalsIgnoreCase("invite")) {
                    clan = args[1];
                    if (this.claned(p)) {
                        if (this.isOwner(p)) {
                            t = Bukkit.getPlayer(clan);
                            if (t != null) {
                                if (!this.claned(t)) {
                                    if (!this.invites.containsKey(t)) {
                                        if (t != p) {
                                            this.invitePlayer(t, p);
                                            p.sendMessage(PrefixManager.CLAN + "§7Du hast §3" + t.getName() + " §7in deinen Clan eingeladen§8.");
                                            t.sendMessage(" ");
                                            t.sendMessage(PrefixManager.CLAN + "§7Du wurdest vom Clan §3" + this.getClanTag(p) + " §7eingeladen§8.");
                                            t.sendMessage(PrefixManager.CLAN + "§7Du willst die Einladung §aannehmen§8? - §3/clan annehmen");
                                            t.sendMessage(PrefixManager.CLAN + "§7Du willst die Einladung §cablehnen§8? - §3/clan ablehnen");
                                            t.sendMessage(" ");
                                        } else {
                                            p.sendMessage(PrefixManager.CLAN + "§cDu kannst dich nicht selbst einladen§8.");
                                        }
                                    } else {
                                        p.sendMessage(PrefixManager.CLAN + "§cDieser Spieler wurde bereits von jemandem eingeladen§8.");
                                    }
                                } else {
                                    p.sendMessage(PrefixManager.CLAN + "§cDieser Spieler ist bereits in einem Clan§8.");
                                }
                            } else {
                                p.sendMessage(PrefixManager.CLAN + "§cDieser Spieler ist nicht online§8.");
                            }
                        } else {
                            p.sendMessage(PrefixManager.CLAN + "§cDu bist nicht der Inhaber des Clans§8.");
                        }
                    } else {
                        p.sendMessage(PrefixManager.CLAN + "§cDu bist in keinem Clan vertreten§8.");
                    }
                }
            }
        }
        return false;
    }

    public void deleteClan(String clan) {
        List members = cfg.getStringList("Clans." + clan + ".Members");

        int i;
        for (i = 0; i < members.size(); ++i) {
            Player t = Bukkit.getPlayer((String) members.get(i));
            if (t != null) {
                t.sendMessage(PrefixManager.CLAN + "§cDer Clan wurde vom Inhaber gelöscht§8.");
                t.playSound(t.getLocation(), Sound.NOTE_PLING, 0.5F, 7.5F);
            }
        }

        for (i = 0; i < members.size(); ++i) {
            cfg.set("Spieler." + (String) members.get(i) + ".Clan", (Object) null);
        }

        cfg.set("Clans." + clan, (Object) null);

        try {
            cfg.save(file);
        } catch (IOException var7) {
            var7.printStackTrace();
        }

    }

    public void invitePlayer(Player invited, Player inviter) {
        this.invites.put(invited, inviter);
    }

    @EventHandler
    public void onPotionThrow(PotionSplashEvent event) {
        if (event.getPotion().getShooter() instanceof Player) {
            Player p = (Player) event.getPotion().getShooter();
            Iterator var3 = event.getAffectedEntities().iterator();

            while (var3.hasNext()) {
                LivingEntity ent = (LivingEntity) var3.next();
                if (ent instanceof Player) {
                    Player t = (Player) ent;
                    if (t != p && getClan(p) != null && getClan(t) != null && getClan(p).equalsIgnoreCase(getClan(t))) {
                        event.setCancelled(true);
                    }
                }
            }
        }

    }


    public boolean isOwner(Player p) {
        String owner = cfg.getString("Clans." + getClan(p) + ".Owner");
        return p.getUniqueId().toString().equalsIgnoreCase(owner);
    }

    public boolean isValid(String code) {
        return code.matches("[ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789_-]*");
    }

    public boolean clanExists(String clan) {
        return cfg.getString("Clans." + clan + ".Owner") != null;
    }

    public void addPlayer(String clan, Player p) {
        List members = cfg.getStringList("Clans." + clan + ".Members");
        members.add(UUIDFetcher.getUUID(p.getName()));
        cfg.set("Clans." + clan + ".Members", members);
        cfg.set("Spieler." + UUIDFetcher.getUUID(p.getName()) + ".Clan", clan);

        try {
            cfg.save(file);
        } catch (IOException var5) {
            var5.printStackTrace();
        }

    }

    public void removePlayer(String clan, Player p) {
        List members = cfg.getStringList("Clans." + clan + ".Members");
        members.remove(UUIDFetcher.getUUID(p.getName()));
        cfg.set("Clans." + clan + ".Members", members);
        cfg.set("Spieler." + UUIDFetcher.getUUID(p.getName()) + ".Clan", (Object) null);

        try {
            cfg.save(file);
        } catch (IOException var5) {
            var5.printStackTrace();
        }

    }



    public void createClan(String clanName, Player p) {





        cfg.set("Clans." + clanName + ".Name", clanName);
        cfg.set("Clans." + clanName + ".Owner", UUIDFetcher.getUUID(p.getName()));
        cfg.set("Spieler." + UUIDFetcher.getUUID(p.getName()) + ".Clan", clanName);
        List m = cfg.getStringList("Clans." + clanName + ".Members");
        m.add(p.getName().toLowerCase());
        cfg.set("Clans." + clanName + ".Members", m);
        p.sendMessage(PrefixManager.CLAN + "§7Glückwunsch§8, §7dein Clan §3" + clanName + " §7wurde erstellt§8.");
        p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 2.0F, 3.0F);
        Iterator var4 = Bukkit.getOnlinePlayers().iterator();

        try {
            cfg.save(file);
        } catch (IOException var6) {
            var6.printStackTrace();
        }
    }
}


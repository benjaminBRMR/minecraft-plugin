package de.sprachlvs.skydrugs;

import de.sprachlvs.skydrugs.apis.CounterAPI;
import de.sprachlvs.skydrugs.apis.TablistAPI;
import de.sprachlvs.skydrugs.commands.*;
import de.sprachlvs.skydrugs.crashfix.MessageFix;
import de.sprachlvs.skydrugs.events.GuessTheNumberEvent;
import de.sprachlvs.skydrugs.inventorys.*;
import de.sprachlvs.skydrugs.listener.*;
import de.sprachlvs.skydrugs.manager.EnderChestManager;
import de.sprachlvs.skydrugs.manager.ItemSkullManager;
import de.sprachlvs.skydrugs.runnables.CookieFarmerRunnable;
import de.sprachlvs.skydrugs.scoreboard.FastBoard;
import de.sprachlvs.skydrugs.scoreboard.PlayerScoreboard;
import de.sprachlvs.skydrugs.scoreboard.Scoreboard;
import de.sprachlvs.skydrugs.tablist.Tablist;
import de.sprachlvs.skydrugs.utils.SpawnUtils;
import de.sprachlvs.skydrugs.utils.TeleportUtil;
import de.sprachlvs.skydrugs.utils.TimeUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class SkyDrugs extends JavaPlugin {

    public static String
            PREFIX = "§8»│ §d§lSKYDRUGS §8▰§7▱ ",
            NOPERM = "§8»│ §d§lSKYDRUGS §8▰§7▱ §cDazu hast du keine Rechte§8.",
            TEAMCHAT_PREFIX = "§8»│ §5§lTEAMCHAT §8▰§7▱ §7",
            OFFLINE = "§8»│ §d§lSKYDRUGS §8▰§7▱ §cDieser Spieler wurde nicht gefunden§8.",
            PLACEHOLDER = "§8» §8┃§7§m-----------------------------------------§8┃§8 «";

    public static ItemStack weiter = ItemSkullManager.getSkull("§8»│ §7Nächste Seite", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTliZjMyOTJlMTI2YTEwNWI1NGViYTcxM2FhMWIxNTJkNTQxYTFkODkzODgyOWM1NjM2NGQxNzhlZDIyYmYifX19", null);
    public static ItemStack zurück = ItemSkullManager.getSkull("§8»│ §7Vorherige Seite", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYmQ2OWUwNmU1ZGFkZmQ4NGU1ZjNkMWMyMTA2M2YyNTUzYjJmYTk0NWVlMWQ0ZDcxNTJmZGM1NDI1YmMxMmE5In19fQ==", null);

    public static String getBase64(String string) {

        switch(string) {

            case "GRASSBLOCK":
                return "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODQ0OWI5MzE4ZTMzMTU4ZTY0YTQ2YWIwZGUxMjFjM2Q0MDAwMGUzMzMyYzE1NzQ5MzJiM2M4NDlkOGZhMGRjMiJ9fX0=";
            case "ENDERCHEST":
                return "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTZjYzQ4NmMyYmUxY2I5ZGZjYjJlNTNkZDlhM2U5YTg4M2JmYWRiMjdjYjk1NmYxODk2ZDYwMmI0MDY3In19fQ==";
        }
        return string;
    }

    public static String getHeader(String string) {
        return "§7   §8× §8§m---------|§7 " + string + " §8§m|---------§7 §8×";
    }

    public static SkyDrugs getInstance() {
        return instance;
    }

    public static SkyDrugs instance;

    private void setupListeners(PluginManager pluginManager) {
        pluginManager.registerEvents(new PlayerScoreboard(), this);
        pluginManager.registerEvents(new SpawnUtils(null), this);
        pluginManager.registerEvents(new AsyncPlayerChatListener(), this);
        pluginManager.registerEvents(new PvPPassGUI_Listener(), this);
        pluginManager.registerEvents(new ChatfarbeGUI_Listener(), this);
        pluginManager.registerEvents(new SignChangeListener(), this);
        pluginManager.registerEvents(new SignClickListener(), this);
        pluginManager.registerEvents(new PlayerBlockListener(), this);
        pluginManager.registerEvents(new SignBreakListener(), this);
        pluginManager.registerEvents(new PlayerJoinListener(), this);
        pluginManager.registerEvents(new ClanCommand(), this);
        pluginManager.registerEvents(new TeleportUtil(null), this);
        pluginManager.registerEvents(new WarpGUI_Listener(), this);
        pluginManager.registerEvents(new MessageFix(), this);
        pluginManager.registerEvents(new GutscheinListener(), this);
        pluginManager.registerEvents(new PlayerQuitListener(), this);
        pluginManager.registerEvents(new RanginfoCommand(), this);
        pluginManager.registerEvents(new TrashCommand(), this);
        pluginManager.registerEvents(new GuessTheNumberEvent(), this);
        pluginManager.registerEvents(new RankEventGUI(), this);
        pluginManager.registerEvents(new EventGUI(), this);
        pluginManager.registerEvents(new PerkGUI_Listener(), this);
        pluginManager.registerEvents(new CookieBlockListener(), this);
        pluginManager.registerEvents(new CookieCPSListener(), this);
        pluginManager.registerEvents(new CookieClickListener(), this);
        pluginManager.registerEvents(new CookieGUI_Listener(), this);
        pluginManager.registerEvents(new PlayerPerkListener(), this);
        pluginManager.registerEvents(new LeaveMSGCommand(), this);
        pluginManager.registerEvents(new JoinMSGCommand(), this);
        pluginManager.registerEvents(new BlockGUI_Listener(), this);
        pluginManager.registerEvents(new EnderChestManager(), this);
        pluginManager.registerEvents(new EnderChestCommand(), this);
        pluginManager.registerEvents(new PlayerInteractListener(), this);
    }

    private void setupCommands() {
        this.getCommand("pvppass").setExecutor(new PvPPassCommand());
        this.getCommand("booster").setExecutor(new BoosterCommand());
        this.getCommand("chatfarbe").setExecutor(new ChatfarbeCommand());
        this.getCommand("clan").setExecutor(new ClanCommand());
        this.getCommand("build").setExecutor(new BuildCommand());
        this.getCommand("spawn").setExecutor(new SpawnCommand());
        this.getCommand("warp").setExecutor(new WarpCommand());
        this.getCommand("ram").setExecutor(new RamCommand());
        this.getCommand("gutschein").setExecutor(new GutscheinCommand());
        this.getCommand("fly").setExecutor(new FlyCommand());
        this.getCommand("gamemode").setExecutor(new GamemodeCommand());
        this.getCommand("ranginfo").setExecutor(new RanginfoCommand());
        this.getCommand("feuerwerk").setExecutor(new FireworkCommand());
        this.getCommand("cc").setExecutor(new ClearchatCommand());
        this.getCommand("trash").setExecutor(new TrashCommand());
        this.getCommand("feed").setExecutor(new FeedCommand());
        this.getCommand("craft").setExecutor(new CraftCommand());
        this.getCommand("kopf").setExecutor(new KopfCommand());
        this.getCommand("rename").setExecutor(new RenameCommand());
        this.getCommand("event").setExecutor(new EventCommand());
        this.getCommand("buy").setExecutor(new BuyCommand());
        this.getCommand("perk").setExecutor(new PerkCommand());
        this.getCommand("enchant").setExecutor(new EnchantCommand());
        this.getCommand("blöcke").setExecutor(new BlockCommand());
        this.getCommand("cookieclicker").setExecutor(new CookieClickerCommand());
        this.getCommand("setkills").setExecutor(new SetKillsCommand());
        this.getCommand("stack").setExecutor(new StackCommand());
        this.getCommand("near").setExecutor(new NearCommand());
        this.getCommand("day").setExecutor(new DayCommand());
        this.getCommand("night").setExecutor(new NightCommand());
        this.getCommand("clear").setExecutor(new ClearCommand());
        this.getCommand("hat").setExecutor(new HatCommand());
        this.getCommand("jump").setExecutor(new JumpCommand());
        this.getCommand("sign").setExecutor(new SignCommand());
        this.getCommand("leavemsg").setExecutor(new LeaveMSGCommand());
        this.getCommand("joinmsg").setExecutor(new JoinMSGCommand());
        this.getCommand("teamchat").setExecutor(new TeamchatCommand());
        this.getCommand("werbung").setExecutor(new WerbungCommand());
        this.getCommand("enderchest").setExecutor(new EnderChestCommand());
    }

    private void setupOther() {}

    @Override
    public void onEnable() {
        try {

            TimeUtils.UPTIME = System.currentTimeMillis();
            Tablist.syncTablist();
            PerkGUI_Listener.startTask(this);

            instance = this;
            System.setProperty("-Dlog4j2.formatMsgNoLookups", "true");

            PvPPassGUI_Listener.setup();

            setupWorldSettings();
            setupListeners(Bukkit.getPluginManager());
            setupCommands();
            setupOther();

            Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new CookieFarmerRunnable(), 0L, 1200L);

            Bukkit.getScheduler().runTaskTimer(this, () -> {
                for (Player all : Bukkit.getOnlinePlayers()) {
                    Tablist.updateTablistRanks(all);
                    //Subtitle.sendSubtile(all);
                }
            }, 0, 40);

            Bukkit.getScheduler().runTaskTimer(this, () -> {
                for (Player all : Bukkit.getOnlinePlayers()) {
                    TablistAPI.sendTablist(all, "\n        §d§lSKYDRUGS§7.§d§lDE §8┃ §7Dein SkyPvP §8& §7Skyblock Server \n §7Online §8▰§7▱ §d" + Bukkit.getOnlinePlayers().size() + " §8/ §d120 \n",
                            "\n §7Discord §8▰§7▱ §ddc.skydrugs.de §8┃ §7Vote §8▰§7▱ §dvote.skydrugs.de \n\n §7Ingesamt registrierte Spieler§8: §d" + CounterAPI.getPlayerCount() + "\n§5↑ §dSkyPvP-1 §7ist erreichbar seit§8: §d" + TimeUtils.timeToString((System.currentTimeMillis() - TimeUtils.getInstance().getUptime()), true) + " §5↓ \n"
                    );
                }
            }, 0, 20);


            Bukkit.getConsoleSender().sendMessage("§7[§dSkyDrugs§7] §aPlugin wurde erfolgreich aktiviert.");


        }catch (final Exception e) {
            e.printStackTrace();
        }

        Bukkit.getScheduler().runTaskTimer((Plugin)this, () -> {
            for (FastBoard board : PlayerScoreboard.boards.values())
                Scoreboard.updatescoreboard(board);
        }, 0L, 20L);
    }


    private void setupWorldSettings() {
        Bukkit.getWorlds().forEach((w) -> w.setThundering(false));
        Bukkit.getWorlds().forEach((w) -> w.setStorm(false));
        Bukkit.getWorlds().forEach((w) -> w.setTime(1000L));
        Bukkit.getWorlds().forEach((w) -> w.setWeatherDuration(0));
    }

    @Override
    public void onDisable() {
        Bukkit.getOnlinePlayers().forEach(all -> all.kickPlayer("§cDer Server wird nun neugestartet."));

    }
}

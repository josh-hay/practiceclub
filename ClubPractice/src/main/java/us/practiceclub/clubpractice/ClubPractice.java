package us.practiceclub.clubpractice;

import lombok.Getter;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import us.practiceclub.clubpractice.commands.kit.KitCommand;
import us.practiceclub.clubpractice.commands.kit.KitCreateCommand;
import us.practiceclub.clubpractice.commands.settings.TimeCommand;
import us.practiceclub.clubpractice.files.FileHandler;
import us.practiceclub.clubpractice.handlers.KitHandler;
import us.practiceclub.clubpractice.handlers.PlayerHandler;
import us.practiceclub.clubpractice.handlers.ProfileHandler;
import us.practiceclub.clubpractice.listeners.LobbyListener;
import us.practiceclub.clubpractice.listeners.PlayerListener;
import us.practiceclub.clubpractice.scoreboard.ScoreboardHandler;
import us.practiceclub.clubpractice.tasks.ScoreboardTask;
import us.practiceclub.clubpractice.utilities.command.CommandFramework;

import java.util.Arrays;

public class ClubPractice extends JavaPlugin {

    @Getter private CommandFramework commandFramework;
    @Getter private FileHandler fileHandler;
    @Getter private ProfileHandler profileHandler;
    @Getter private PlayerHandler playerHandler;
    @Getter private KitHandler kitHandler;
    @Getter private ScoreboardHandler scoreboardHandler;

    @Override
    public void onEnable() {
        registerHandlers();
        registerListeners(new PlayerListener(this),
                new LobbyListener(this));
        registerCommands(new KitCommand(this),
                new KitCreateCommand(this),
                new TimeCommand());
        commandFramework.registerHelp();
        registerTasks(new ScoreboardTask(this));
    }

    private void registerCommands(Object... command) {
        Arrays.stream(command).forEach(c -> commandFramework.registerCommands(c));
    }

    private void registerListeners(Listener... listener) {
        Arrays.stream(listener).forEach(l -> getServer().getPluginManager().registerEvents(l, this));
    }

    private void registerTasks(BukkitRunnable... tasks) {
        Arrays.stream(tasks).forEach(t -> t.runTaskTimerAsynchronously(this, 0L, 0L));
    }

    private void registerHandlers() {
        commandFramework = new CommandFramework(this);
        fileHandler = new FileHandler(this);
        profileHandler = new ProfileHandler();
        playerHandler = new PlayerHandler();
        kitHandler = new KitHandler(this);
        scoreboardHandler = new ScoreboardHandler(this);
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }
}

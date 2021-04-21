package us.practiceclub.clubpractice;

import lombok.Getter;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import us.practiceclub.clubpractice.commands.CreateKitCommand;
import us.practiceclub.clubpractice.commands.KitCommand;
import us.practiceclub.clubpractice.files.FileHandler;
import us.practiceclub.clubpractice.handlers.KitHandler;
import us.practiceclub.clubpractice.handlers.PlayerHandler;
import us.practiceclub.clubpractice.handlers.ProfileHandler;
import us.practiceclub.clubpractice.listeners.LobbyListener;
import us.practiceclub.clubpractice.listeners.PlayerListener;

import java.util.Arrays;

public class ClubPractice extends JavaPlugin {

    @Getter private FileHandler fileHandler;
    @Getter private ProfileHandler profileHandler;
    @Getter private PlayerHandler playerHandler;
    @Getter private KitHandler kitHandler;

    @Override
    public void onEnable() {
        registerHandlers();
        registerListeners(new PlayerListener(this),
                new LobbyListener(this));
        getCommand("createkit").setExecutor(new CreateKitCommand(this));
        getCommand("kit").setExecutor(new KitCommand(this));
    }


    private void registerListeners(Listener... listener) {
        Arrays.stream(listener).forEach(l -> getServer().getPluginManager().registerEvents(l, this));
    }

    private void registerHandlers() {
        fileHandler = new FileHandler(this);
        profileHandler = new ProfileHandler();
        playerHandler = new PlayerHandler();
        kitHandler = new KitHandler(this);
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }
}

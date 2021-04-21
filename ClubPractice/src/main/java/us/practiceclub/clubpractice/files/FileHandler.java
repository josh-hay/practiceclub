package us.practiceclub.clubpractice.files;

import lombok.Getter;
import org.bukkit.configuration.file.YamlConfiguration;
import us.practiceclub.clubpractice.ClubPractice;

import java.io.File;
import java.io.IOException;

public class FileHandler {

    private File kitsFile, configFile;
    @Getter
    private YamlConfiguration kits, config;

    public FileHandler(ClubPractice clubPractice) {
        kitsFile = new File("kits.yml");
        configFile = new File("config.yml");
        if(!kitsFile.exists()) clubPractice.saveResource("kits.yml", false);
        if(!configFile.exists()) clubPractice.saveResource("config.yml", false);
        kits = YamlConfiguration.loadConfiguration(kitsFile);
        config = YamlConfiguration.loadConfiguration(configFile);
    }

    public void saveKits() {
        try {
            kits.save(kitsFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveConfig() {
        try {
            config.save(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

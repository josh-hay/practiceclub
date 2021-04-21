package us.practiceclub.clubpractice.handlers;

import com.google.common.collect.Maps;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.ItemStack;
import us.practiceclub.clubpractice.ClubPractice;
import us.practiceclub.clubpractice.kits.Kit;
import us.practiceclub.clubpractice.utilities.Base64Util;

import java.io.IOException;
import java.util.HashMap;

public class KitHandler {

    private ClubPractice clubPractice;
    private HashMap<String, Kit> kits;

    public KitHandler(ClubPractice clubPractice) {
        this.clubPractice = clubPractice;
        kits = Maps.newHashMap();
        loadKits();
    }

    private void loadKits() {
        ConfigurationSection config = clubPractice.getFileHandler().getKits().getConfigurationSection("kits");
        if(config == null) {
            System.out.println("Could not find any kits! Skipping.");
            return;
        }
        for (String key : config.getKeys(false)) {
            Kit kit = new Kit(config.getString(key + ".name"));
            try {
                kit.setContents(Base64Util.fromBase64(config.getString(key + ".contents"))); //TODO: From base 64 in file
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                kit.setArmorContents(Base64Util.fromBase64(config.getString(key + ".armor")));
            } catch (IOException e) {
                e.printStackTrace();
            }
            kits.put(key, kit);
        }
    }

    public void createKit(String key, String name, ItemStack[] contents, ItemStack[] armor) {
        clubPractice.getFileHandler().getKits().set("kits." + key + ".name", name);
        clubPractice.getFileHandler().getKits().set("kits." + key + ".contents", Base64Util.toBase64(contents));
        clubPractice.getFileHandler().getKits().set("kits." + key + ".armor", Base64Util.toBase64(armor));
        clubPractice.getFileHandler().saveKits();
        Kit k = new Kit(name);
        k.setContents(contents);
        k.setArmorContents(armor);
        kits.put(key, k);
    }

    public Kit getKit(String key) {
        return kits.get(key);
    }
}

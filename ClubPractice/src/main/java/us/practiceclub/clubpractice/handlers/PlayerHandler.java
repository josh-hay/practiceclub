package us.practiceclub.clubpractice.handlers;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class PlayerHandler {

    public void handleJoin(Player player) {
        reset(player);
    }

    public void clearArmor(Player player) {
        player.getInventory().setArmorContents(new ItemStack[]{});
    }

    public void reset(Player player) {
        player.setHealth(20);
        player.setFoodLevel(20);
        player.setSaturation(20);
        player.setAllowFlight(false);
        player.setFlying(false);
        player.setFireTicks(0);
        player.setTotalExperience(0);
        player.setExhaustion(0);
        player.setGameMode(GameMode.ADVENTURE);
    }

    public void handleDeath(Player player) {
        reset(player);
    }
}

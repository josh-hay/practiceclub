package us.practiceclub.clubpractice.handlers;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import us.practiceclub.clubpractice.enums.Items;

public class PlayerHandler {

    public void handleJoin(Player player) {
        reset(player);
        giveJoinItems(player);
    }

    public void clearArmor(Player player) {
        player.getInventory().setArmorContents(new ItemStack[]{});
    }

    public void reset(Player player) {
        player.setHealth(20);
        player.setFoodLevel(20);
        player.setSaturation(20);
        if(player.getGameMode() != GameMode.CREATIVE) {
            player.setAllowFlight(false);
            player.setFlying(false);
            player.setGameMode(GameMode.ADVENTURE);
        }
        player.setFireTicks(0);
        player.setTotalExperience(0);
        player.setExhaustion(0);
    }

    public void giveJoinItems(Player player) {
        if(!player.isOnline()) return;
        clearArmor(player);
        player.getInventory().clear();
        player.getInventory().setItem(0, Items.UNRANKED_QUEUE.getItem());
        player.getInventory().setItem(1, Items.RANKED_QUEUE.getItem());
        player.getInventory().setItem(2, Items.PREMIUM_QUEUE.getItem());
        player.getInventory().setItem(4, Items.SPECTATE.getItem());
        player.getInventory().setItem(6, Items.HOST_EVENTS.getItem());
        player.getInventory().setItem(7, Items.LEADERBOARDS.getItem());
        player.getInventory().setItem(8, Items.SETTINGS.getItem());
    }

    public void handleDeath(Player player) {
        reset(player);
    }
}

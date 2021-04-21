package us.practiceclub.clubpractice.kits;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Kit {

    @Getter
    private String name;
    @Getter @Setter
    private ItemStack[] contents, armorContents;

    public Kit(String name) {
        this.name = name;
        this.contents = new ItemStack[]{};
        this.armorContents = new ItemStack[]{};
    }

    public void applyTo(Player player) {
        player.getInventory().setContents(contents);
        player.getInventory().setArmorContents(armorContents);
    }
}

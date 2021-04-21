package us.practiceclub.clubpractice.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import us.practiceclub.clubpractice.utilities.C;
import us.practiceclub.clubpractice.utilities.ItemBuilder;

@Getter
@AllArgsConstructor
public enum Items {

    UNRANKED_QUEUE(new ItemBuilder(Material.WOOD_SWORD).setName(C.colorize("&cUnranked Queue &7(Right Click)")).toItemStack()),
    RANKED_QUEUE(new ItemBuilder(Material.GOLD_SWORD).setName(C.colorize("&cRanked Queue &7(Right Click)")).toItemStack()),
    PREMIUM_QUEUE(new ItemBuilder(Material.DIAMOND_SWORD).setName(C.colorize("&cPremium Queue &7(Right Click)")).toItemStack()),
    LEAVE_QUEUE(new ItemBuilder(Material.INK_SACK, 1, (byte) 1).setName(C.colorize("&cLeave Queue &7(Right Click)")).toItemStack()),
    SPECTATE(new ItemBuilder(Material.REDSTONE_TORCH_ON).setName(C.colorize("&cSpectate &7(Right Click)")).toItemStack()),
    SPECTATE_RANDOM(new ItemBuilder(Material.COMPASS).setName(C.colorize("&cSpectate Random &7(Right Click)")).toItemStack()),
    SPECTATE_LEAVE(new ItemBuilder(Material.LEVER).setName(C.colorize("&cStop Spectating &7(Right Click)")).toItemStack()),
    SPECTATE_MENU(new ItemBuilder(Material.BOOK).setName(C.colorize("&cSpectate Menu &7(Right Click)")).toItemStack()),
    HOST_EVENTS(new ItemBuilder(Material.BLAZE_POWDER).setName(C.colorize("&cHost Events &7(Right Click)")).toItemStack()),
    LEADERBOARDS(new ItemBuilder(Material.PAPER).setName(C.colorize("&cLeaderboards &7(Right Click)")).toItemStack()),
    SETTINGS(new ItemBuilder(Material.DIODE).setName(C.colorize("&cSettings &7(Right Click)")).toItemStack());

    private ItemStack item;
}


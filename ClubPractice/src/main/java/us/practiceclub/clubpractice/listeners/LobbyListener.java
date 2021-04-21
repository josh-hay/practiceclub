package us.practiceclub.clubpractice.listeners;

import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.*;
import us.practiceclub.clubpractice.ClubPractice;
import us.practiceclub.clubpractice.enums.Items;
import us.practiceclub.clubpractice.struct.PlayerState;
import us.practiceclub.clubpractice.utilities.C;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
public class LobbyListener implements Listener {

    private final ClubPractice clubPractice;

    private final List<String> DEVELOPERS = new ArrayList<>(Arrays.asList("8f384d1f-9b28-490f-bf90-8cae66f05905", ""));

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        clubPractice.getPlayerHandler().handleJoin(player);

        if(player.hasPermission("practice.lobbyFly")) {
            player.setAllowFlight(true);
            player.setFlying(true);
        }

        //TODO: TEMPORARY DEV TESTING, REMOVE ON FINAL BUILD.
        DEVELOPERS.forEach(uuid -> {
            if(player.getUniqueId().toString().equalsIgnoreCase(uuid)) {
                clubPractice.getProfileHandler().getProfile(player).setPlayerState(PlayerState.DEV);
                player.sendMessage(C.colorize("&cYou are in dev mode, normal lobby states do not apply."));
            }
        });

    }

    @EventHandler
    public void onDamage(EntityDamageEvent event) {
        if(!(event.getEntity() instanceof Player)) return;
        Player player = (Player) event.getEntity();
        if(clubPractice.getProfileHandler().getProfile(player) == null ||
            clubPractice.getProfileHandler().getProfile(player).getPlayerState() != PlayerState.LOBBY) return;
        event.setCancelled(true);
    }

    @EventHandler
    public void onTarget(EntityTargetEvent event) {
        if(!(event.getTarget() instanceof Player)) return;
        Player player = (Player) event.getTarget();
        if(clubPractice.getProfileHandler().getProfile(player) == null ||
                clubPractice.getProfileHandler().getProfile(player).getPlayerState() != PlayerState.LOBBY) return;
        event.setCancelled(true);
    }

    @EventHandler
    public void onBreakBlock(BlockBreakEvent event) {
        Player player = event.getPlayer();
        if(clubPractice.getProfileHandler().getProfile(player) == null ||
                clubPractice.getProfileHandler().getProfile(player).getPlayerState() != PlayerState.LOBBY) return;
        if(clubPractice.getProfileHandler().getProfile(player).isBuildEnabled()) return;
        event.setCancelled(true);
    }

    @EventHandler
    public void onPlaceBlock(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        if(clubPractice.getProfileHandler().getProfile(player) == null ||
                clubPractice.getProfileHandler().getProfile(player).getPlayerState() != PlayerState.LOBBY) return;
        if(clubPractice.getProfileHandler().getProfile(player).isBuildEnabled()) return;
        event.setCancelled(true);
    }

    @EventHandler
    public void onDropItem(PlayerDropItemEvent event) {
        Player player = event.getPlayer();
        if(clubPractice.getProfileHandler().getProfile(player) == null ||
                clubPractice.getProfileHandler().getProfile(player).getPlayerState() != PlayerState.LOBBY) return;
        event.setCancelled(true);
    }

    @EventHandler
    public void onItemDamage(PlayerItemDamageEvent event) {
        Player player = event.getPlayer();
        if(clubPractice.getProfileHandler().getProfile(player) == null ||
                clubPractice.getProfileHandler().getProfile(player).getPlayerState() != PlayerState.LOBBY) return;
        event.setCancelled(true);
    }

    @EventHandler
    public void onPickup(PlayerPickupItemEvent event) {
        Player player = event.getPlayer();
        if(clubPractice.getProfileHandler().getProfile(player) == null ||
                clubPractice.getProfileHandler().getProfile(player).getPlayerState() != PlayerState.LOBBY) return;
        event.setCancelled(true);
    }

    @EventHandler
    public void onHunger(FoodLevelChangeEvent event) {
        if(!(event.getEntity() instanceof Player)) return;
        Player player = (Player) event.getEntity();
        if(clubPractice.getProfileHandler().getProfile(player) == null ||
                clubPractice.getProfileHandler().getProfile(player).getPlayerState() != PlayerState.LOBBY) return;
        event.setCancelled(true);
    }

    @EventHandler
    public void onDamageEntity(EntityDamageByEntityEvent event) {
        if(!(event.getDamager() instanceof Player)) return;
        Player player = (Player) event.getDamager();
        if(clubPractice.getProfileHandler().getProfile(player) == null ||
                clubPractice.getProfileHandler().getProfile(player).getPlayerState() != PlayerState.LOBBY) return;
        event.setCancelled(true);
    }
    
    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if(clubPractice.getProfileHandler().getProfile(player) == null || 
            clubPractice.getProfileHandler().getProfile(player).getPlayerState() != PlayerState.LOBBY) return;
        if(!event.getAction().name().contains("RIGHT")) return;
        if(player.getItemInHand() == null || player.getItemInHand().getType() == Material.AIR) return;
        if(player.getItemInHand().isSimilar(Items.UNRANKED_QUEUE.getItem())) {
            //TODO: Queue Player
        } else if(player.getItemInHand().isSimilar(Items.RANKED_QUEUE.getItem())) {
            //TODO: Queue Player
        } else if(player.getItemInHand().isSimilar(Items.PREMIUM_QUEUE.getItem())) {
            //TODO: Queue Player
        } else if(player.getItemInHand().isSimilar(Items.SPECTATE.getItem())) {
            //TODO: Enable Spectator
        } else if(player.getItemInHand().isSimilar(Items.HOST_EVENTS.getItem())) {
            //TODO: Open Host Menu
        } else if(player.getItemInHand().isSimilar(Items.LEADERBOARDS.getItem())) {
            //TODO: Open Leaderboards
        } else if(player.getItemInHand().isSimilar(Items.SETTINGS.getItem())) {
            //TODO: Open Settings
        }
    }
}

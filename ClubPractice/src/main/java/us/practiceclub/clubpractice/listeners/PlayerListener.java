package us.practiceclub.clubpractice.listeners;

import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import us.practiceclub.clubpractice.ClubPractice;
import us.practiceclub.clubpractice.utilities.C;

@RequiredArgsConstructor
public class PlayerListener implements Listener {

    private final ClubPractice clubPractice;

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        event.setJoinMessage(null);
        sendWelcomeMessage(player);

        clubPractice.getProfileHandler().loadProfile(player);
    }

    private void sendWelcomeMessage(Player player) {
        C.colorize(clubPractice.getFileHandler().getConfig().getStringList("welcome-message")).forEach(player::sendMessage);
    }
}

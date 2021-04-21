package us.practiceclub.clubpractice.profile;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;
import us.practiceclub.clubpractice.struct.PlayerState;

import java.util.UUID;

public class PracticeProfile {

    private UUID uuid;
    private Player player;

    @Getter
    @Setter
    private PlayerState playerState;

    public PracticeProfile(Player player) {
        this.uuid = player.getUniqueId();
        this.player = player;
        this.playerState = PlayerState.LOBBY;
    }

}

package us.practiceclub.clubpractice.handlers;

import com.google.common.collect.Maps;
import org.bukkit.entity.Player;
import us.practiceclub.clubpractice.profile.PracticeProfile;

import java.util.HashMap;
import java.util.UUID;

public class ProfileHandler {

    private HashMap<UUID, PracticeProfile> practiceProfiles;

    public ProfileHandler() {
        practiceProfiles = Maps.newHashMap();
    }

    public void setupProfile(Player player) {
        PracticeProfile practiceProfile = new PracticeProfile(player);
        practiceProfiles.put(player.getUniqueId(), practiceProfile);
    }

    public void loadProfile(Player player) {
        if(!practiceProfiles.containsKey(player.getUniqueId())) setupProfile(player);
        PracticeProfile practiceProfile = practiceProfiles.get(player.getUniqueId());
    }

    public void saveProfile(Player player) {
        PracticeProfile practiceProfile = practiceProfiles.get(player.getUniqueId());

    }

    public PracticeProfile getProfile(Player player) {
        return getProfile(player.getUniqueId());
    }
    public PracticeProfile getProfile(UUID uuid) {
        return practiceProfiles.get(uuid);
    }
}

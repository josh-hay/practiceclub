package us.practiceclub.clubpractice.scoreboard;

import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;
import us.practiceclub.clubpractice.ClubPractice;
import us.practiceclub.clubpractice.profile.PracticeProfile;
import us.practiceclub.clubpractice.utilities.ScoreHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
public class ScoreboardHandler {

    private final ClubPractice clubPractice;

    public void update(Player player) {
        try {
            if (clubPractice.getProfileHandler().getProfile(player) == null || !ScoreHelper.hasScore(player)) {
                return;
            }
            PracticeProfile practiceProfile = clubPractice.getProfileHandler().getProfile(player);
            ScoreHelper scoreHelper = ScoreHelper.getByPlayer(player);

            List<String> slots = new ArrayList<>();

            // Title Divider ┃

            scoreHelper.setTitle("&c&lPractice Club");
            slots.add("&7&m-------------------------");

            switch (practiceProfile.getPlayerState()) {
                case LOBBY:
                case IN_MATCH:
                case QUEUED:
                case DEV:
                case STAFF:
                case SPECTATING: {
                    slots.add("&fOnline: &c" + clubPractice.getServer().getOnlinePlayers().size());
                    slots.add("&fIn Fights: &c" + 0);
                    break;
                }
            }

            slots.add("");
            slots.add("&cpracticeclub.us");
            slots.add("&7&m-------------------------");

            if (!practiceProfile.isScoreboardEnabled()) {
                slots.clear();
            }
            if (slots.size() < 15) {
                for (int i = slots.size() + 1; i <= 15; i++) {
                    scoreHelper.removeSlot(i);
                }
            }
            Collections.reverse(slots);
            scoreHelper.setSlotsFromList(slots);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

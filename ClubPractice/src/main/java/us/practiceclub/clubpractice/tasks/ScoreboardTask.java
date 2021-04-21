package us.practiceclub.clubpractice.tasks;

import lombok.RequiredArgsConstructor;
import org.bukkit.scheduler.BukkitRunnable;
import us.practiceclub.clubpractice.ClubPractice;

@RequiredArgsConstructor
public class ScoreboardTask extends BukkitRunnable {

    private final ClubPractice clubPractice;

    @Override
    public void run() {
        clubPractice.getServer().getOnlinePlayers().forEach(pl -> clubPractice.getScoreboardHandler().update(pl));
    }
}

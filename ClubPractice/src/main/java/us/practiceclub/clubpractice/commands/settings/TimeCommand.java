package us.practiceclub.clubpractice.commands.settings;

import org.bukkit.entity.Player;
import us.practiceclub.clubpractice.utilities.C;
import us.practiceclub.clubpractice.utilities.command.Command;
import us.practiceclub.clubpractice.utilities.command.CommandArgs;

public class TimeCommand {

    @Command(name = "day", permission = "practice.time.day", inGameOnly = true)
    public void day(CommandArgs commandArgs) {
        Player player = commandArgs.getPlayer();
        player.setPlayerTime(1000L, false);
        player.sendMessage(C.colorize("&aSet the time to day."));
    }

    @Command(name = "night", permission = "practice.time.night", inGameOnly = true)
    public void night(CommandArgs commandArgs) {
        Player player = commandArgs.getPlayer();
        player.setPlayerTime(20000L, false);
        player.sendMessage(C.colorize("&aSet the time to night."));
    }

}

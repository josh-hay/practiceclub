package us.practiceclub.clubpractice.commands;

import lombok.RequiredArgsConstructor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import us.practiceclub.clubpractice.ClubPractice;
import us.practiceclub.clubpractice.kits.Kit;
import us.practiceclub.clubpractice.utilities.C;

@RequiredArgsConstructor
public class KitCommand implements CommandExecutor {

    private final ClubPractice clubPractice;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

        if(!(sender instanceof Player)) return true;

        Player player = (Player) sender;

        Kit kit = clubPractice.getKitHandler().getKit(player.getName().toLowerCase());
        if(kit == null) {
            player.sendMessage(C.colorize("&cFailed to find your kit."));
            return true;
        } else {
            kit.applyTo(player);
            player.sendMessage(C.colorize("&aApplied your kit."));
            return true;
        }
    }
}

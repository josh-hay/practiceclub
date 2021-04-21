package us.practiceclub.clubpractice.commands.kit;

import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;
import us.practiceclub.clubpractice.ClubPractice;
import us.practiceclub.clubpractice.utilities.C;
import us.practiceclub.clubpractice.utilities.command.Command;
import us.practiceclub.clubpractice.utilities.command.CommandArgs;

@RequiredArgsConstructor
public class KitCreateCommand {

    private final ClubPractice clubPractice;

    @Command(name = "createkit", permission = "practice.kits.create", inGameOnly = true)
    public void createKit(CommandArgs commandArgs) {
        Player player = commandArgs.getPlayer();
        if(commandArgs.getArgs().length < 1) {
            player.sendMessage(C.colorize("&cUsage: /" + commandArgs.getLabel() + " <name>"));
            return;
        }
        String name = commandArgs.getArgs(0);
        if(clubPractice.getKitHandler().getKit(name.toLowerCase()) != null) {
            player.sendMessage(C.colorize("&cA kit with that name already exists."));
            return;
        }
        clubPractice.getKitHandler().createKit(name.toLowerCase(), name, player.getInventory().getContents(), player.getInventory().getArmorContents());
        player.sendMessage(C.colorize("&aSuccessfully created kit &l" + name.toLowerCase() + "&r&a."));
    }
}

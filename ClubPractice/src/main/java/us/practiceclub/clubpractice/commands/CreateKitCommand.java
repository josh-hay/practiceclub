package us.practiceclub.clubpractice.commands;

import lombok.RequiredArgsConstructor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import us.practiceclub.clubpractice.ClubPractice;
import us.practiceclub.clubpractice.utilities.C;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
public class CreateKitCommand implements CommandExecutor {

    private final ClubPractice clubPractice;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

        if(!(sender instanceof Player)) return true;

        Player player = (Player) sender;

        if(args.length < 2) {
            player.sendMessage(C.colorize("&cUsage: /createkit <key> <name>"));
            return true;
        }

        String key = args[0];

        List<String> joined = Arrays.asList(args);
        joined.remove(0);

        String name = String.join(" ", joined);

        ItemStack[] contents = player.getInventory().getContents();
        ItemStack[] armor = player.getInventory().getArmorContents();

        clubPractice.getKitHandler().createKit(key, name, contents, armor);

        player.sendMessage(C.colorize("&aCreated kit: Key: " + key + " Name:" + name));

        return true;
    }
}

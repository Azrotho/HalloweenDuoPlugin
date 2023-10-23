package fr.azrotho.halloweenduo.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class FriendCommandExecutor implements CommandExecutor {

    public static HashMap<Player, Player> duo = new HashMap<>();
    public static HashMap<Player, Integer> cooldown = new HashMap<>();
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        return false;
    }
}

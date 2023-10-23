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
        Player player = ((Player) commandSender);
        Player target = player.getServer().getPlayer(strings[0]);
        if(target == null) {
            player.sendMessage("§cLe joueur n'est pas connecté");
            return true;
        }
        if(target == player) {
            player.sendMessage("§cVous ne pouvez pas vous ajouter en ami");
            return true;
        }
        if(duo.containsKey(player)) {
            player.sendMessage("§cVous êtes déjà en ami avec " + duo.get(player).getName());
            return true;
        }
        duo.put(player, target);
        player.sendMessage("§aVous êtes maintenant en ami avec " + target.getName());
        return true;
    }
}

package fr.azrotho.halloweenduo.utils;

import fr.azrotho.halloweenduo.command.FriendCommandExecutor;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerUtils {
    public static int playerAlives() {
        int count = 0;
        for(Player player : Bukkit.getOnlinePlayers()) {
            if(player.getGameMode().equals(GameMode.ADVENTURE)) {
                count++;
            }
        }
        return count;
    }

    public static List<Player> getPlayersAlive() {
        List<Player> players = new ArrayList<>(Bukkit.getOnlinePlayers());
        players.removeIf(player -> player.getGameMode() != GameMode.ADVENTURE);
        return players;
    }

    public static boolean isFinalIsDuo() {
        if(Bukkit.getOnlinePlayers().size() == 2) {
            List<Player> finalist = getPlayersAlive();
            return FriendCommandExecutor.duo.get(finalist.get(0)) == finalist.get(1) && FriendCommandExecutor.duo.get(finalist.get(1)) == finalist.get(0);
        }
        return false;
    }
}

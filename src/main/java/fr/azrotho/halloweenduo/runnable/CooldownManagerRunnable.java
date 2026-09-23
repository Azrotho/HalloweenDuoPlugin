package fr.azrotho.halloweenduo.runnable;

import fr.azrotho.halloweenduo.command.FriendCommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class CooldownManagerRunnable extends BukkitRunnable {
    @Override
    public void run() {
        for(Player player : FriendCommandExecutor.cooldown.keySet()) {
            if(FriendCommandExecutor.cooldown.get(player) == 0) {
                FriendCommandExecutor.cooldown.remove(player);
                player.sendMessage("§aVous pouvez changer de /friend");
            } else {
                FriendCommandExecutor.cooldown.put(player, FriendCommandExecutor.cooldown.get(player) - 1);
            }
        }
    }
}

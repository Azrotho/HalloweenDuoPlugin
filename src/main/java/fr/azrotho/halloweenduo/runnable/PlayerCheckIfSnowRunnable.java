package fr.azrotho.halloweenduo.runnable;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerCheckIfSnowRunnable extends BukkitRunnable {
    @Override
    public void run() {
        for(Player player : Bukkit.getOnlinePlayers()) {
            if(player.getLocation().getBlock().getType().toString().contains("SNOW")) {
                player.damage(100);
                player.setGameMode(GameMode.SPECTATOR);
            }
            if(player.getLocation().add(0,-1,0).getBlock().getType().toString().contains("SNOW")) {
                player.damage(100);
                player.setGameMode(GameMode.SPECTATOR);
            }
        }
    }
}

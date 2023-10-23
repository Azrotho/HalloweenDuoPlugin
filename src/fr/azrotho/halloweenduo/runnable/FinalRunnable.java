package fr.azrotho.halloweenduo.runnable;

import fr.azrotho.halloweenduo.Main;
import fr.azrotho.halloweenduo.utils.PlayerUtils;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class FinalRunnable extends BukkitRunnable {
    @Override
    public void run() {
        if(!Main.started) return;
        if(PlayerUtils.playerAlives() <= 5) {
            for(Player player : Bukkit.getOnlinePlayers()) {
                if(player.getGameMode().equals(GameMode.ADVENTURE)) {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 20, 0, false, false, false));
                }
            }
        }

        if(PlayerUtils.getPlayersAlive().size() == 1) {
            for(Player player : Bukkit.getOnlinePlayers()) {
                player.setGameMode(GameMode.SPECTATOR);
                player.sendMessage("§c§lVictoire de " + PlayerUtils.getPlayersAlive().get(0).getName() + " !");
                player.sendTitle("§c§lVictoire !", "§c§lVictoire de " + PlayerUtils.getPlayersAlive().get(0).getName() + " !", 20, 100, 20);
                Main.started = false;
            }
        }

        if(PlayerUtils.isFinalIsDuo()) {
            for(Player player : Bukkit.getOnlinePlayers()) {
                player.setGameMode(GameMode.SPECTATOR);
                player.sendMessage("§c§lVictoire de l'équipe " + PlayerUtils.getPlayersAlive().get(0).getName() + " et " + PlayerUtils.getPlayersAlive().get(1).getName() + " !");
                player.sendTitle("§c§lVictoire !", "§c§lVictoire de l'équipe " + PlayerUtils.getPlayersAlive().get(0).getName() + " et " + PlayerUtils.getPlayersAlive().get(1).getName() + " !", 20, 100, 20);
                Main.started = false;
            }
        }
    }
}

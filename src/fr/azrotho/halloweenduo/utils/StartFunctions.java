package fr.azrotho.halloweenduo.utils;

import fr.azrotho.halloweenduo.Main;
import fr.azrotho.halloweenduo.command.FriendCommandExecutor;
import fr.azrotho.halloweenduo.runnable.RefillChestRunnable;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class StartFunctions {
    public static void start() {
        for(Player player : Bukkit.getOnlinePlayers()) {
            Main.timerInvulnerability = 30;
            FriendCommandExecutor.duo.clear();
            FriendCommandExecutor.cooldown.clear();
            player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 20 * 30, 20, false, false, false));
            player.setGameMode(GameMode.ADVENTURE);
            player.setHealth(20);
            player.teleport(new Location(player.getWorld(), 808, 202, -642));
            player.getInventory().clear();
            RefillChestRunnable.timerBeforeRefill = 15;
            RefillChest.clearAllChests();
            Main.started = true;
        }
    }
}

package fr.azrotho.halloweenduo.runnable;

import fr.azrotho.halloweenduo.Main;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class InvincibilityRunnable extends BukkitRunnable {
    @Override
    public void run() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.setSaturation(20);
            player.setFoodLevel(20);
            if(Main.timerInvulnerability == -1) {
                return;
            }
            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("Il vous reste " + Main.timerInvulnerability + " secondes d'invincibilité"));
            Main.timerInvulnerability--;
        }
    }
}

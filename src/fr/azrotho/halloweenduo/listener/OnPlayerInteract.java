package fr.azrotho.halloweenduo.listener;

import fr.azrotho.halloweenduo.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class OnPlayerInteract implements Listener {
    @EventHandler
    public void onInteraction(PlayerInteractEvent event) {
        if(event.getItem() == null) return;
        if(event.getItem().getType() == Material.AIR) return;
        if(event.getItem().isSimilar(ItemBuilder.getBlindnessItemStack())) {
            for(Player player : Bukkit.getOnlinePlayers()) {
                if(player != event.getPlayer()) {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 20 * 60, 0, false, false, false));
                }
            }
            event.getItem().setAmount(event.getItem().getAmount() - 1);
        }

        if(event.getItem().isSimilar(ItemBuilder.getSlownessItemStack())) {
            for(Player player : Bukkit.getOnlinePlayers()) {
                if(player != event.getPlayer()) {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 20 * 60, 1, false, false, false));
                }
            }
            event.getItem().setAmount(event.getItem().getAmount() - 1);
        }

        if(event.getItem().isSimilar(ItemBuilder.getDarknessItemStack())) {
            for(Player player : Bukkit.getOnlinePlayers()) {
                if(player != event.getPlayer()) {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.DARKNESS, 20 * 60, 0, false, false, false));
                }
            }
            event.getItem().setAmount(event.getItem().getAmount() - 1);
        }
    }
}

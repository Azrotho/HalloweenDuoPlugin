package fr.azrotho.halloweenduo.listener;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;

public class OnDamageListener implements Listener {
    @EventHandler
    public void onDamage(EntityDamageEvent event) {
        if(event.getEntity() instanceof Player player) {
            if(player.getHealth() - event.getFinalDamage() <= 0) {
                event.setCancelled(true);
                player.setGameMode(GameMode.SPECTATOR);
                for(ItemStack itemStack : player.getInventory().getContents()) {
                    if(itemStack != null) {
                        player.getWorld().dropItemNaturally(player.getLocation(), itemStack);
                    }
                }
                player.getInventory().clear();
            }
        }
    }
}

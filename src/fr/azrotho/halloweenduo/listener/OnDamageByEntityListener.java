package fr.azrotho.halloweenduo.listener;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

public class OnDamageByEntityListener implements Listener {
    @EventHandler
    @SuppressWarnings("deprecation")
    public void onDamageByEntity(EntityDamageByEntityEvent event) {
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
                Player killer = (Player) event.getDamager();
                killer.getItemInHand().setAmount(0);
            }
        }
    }
}

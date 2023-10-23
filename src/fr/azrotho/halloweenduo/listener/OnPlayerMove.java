package fr.azrotho.halloweenduo.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class OnPlayerMove implements Listener {
    @EventHandler
    public static void onPlayerMove(PlayerMoveEvent event) {
        if(event.getPlayer().getLocation().getBlock().getType().toString().contains("SNOW")) {
            event.getPlayer().damage(100);
        }
        if(event.getPlayer().getLocation().add(0,-1,0).getBlock().getType().toString().contains("SNOW")) {
            event.getPlayer().damage(100);
        }
    }
}

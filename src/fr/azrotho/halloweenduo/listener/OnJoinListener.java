package fr.azrotho.halloweenduo.listener;

import org.bukkit.*;
import org.bukkit.attribute.Attribute;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class OnJoinListener implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        event.getPlayer().teleport(new Location(event.getPlayer().getWorld(), 808, 202, -642));
        event.getPlayer().setGameMode(GameMode.SPECTATOR);
        event.getPlayer().getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(40);
        event.getPlayer().setHealth(40);
        for(World world : Bukkit.getWorlds()) {
            world.setGameRule(GameRule.NATURAL_REGENERATION, false);
        }
    }
}

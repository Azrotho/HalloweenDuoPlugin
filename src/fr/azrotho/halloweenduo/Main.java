package fr.azrotho.halloweenduo;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main extends JavaPlugin {
    Logger logger = Bukkit.getLogger();
    @Override
    public void onEnable() {
        logger.log(Level.INFO, "Plugin HalloweenDuo activé");
    }

    @Override
    public void onDisable() {
        logger.log(Level.INFO, "Plugin HalloweenDuo désactivé");
    }
}

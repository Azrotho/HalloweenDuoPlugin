package fr.azrotho.halloweenduo;

import fr.azrotho.halloweenduo.command.DebugCommandExecutor;
import fr.azrotho.halloweenduo.listener.OnDamageByEntityListener;
import fr.azrotho.halloweenduo.listener.OnDamageListener;
import fr.azrotho.halloweenduo.listener.OnJoinListener;
import fr.azrotho.halloweenduo.listener.OnPlayerMove;
import fr.azrotho.halloweenduo.runnable.CooldownManagerRunnable;
import fr.azrotho.halloweenduo.runnable.InvincibilityRunnable;
import fr.azrotho.halloweenduo.runnable.PlayerCheckIfSnowRunnable;
import fr.azrotho.halloweenduo.runnable.RefillChestRunnable;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main extends JavaPlugin {

    public static boolean started = false;
    public static int timerInvulnerability = 0;
    Logger logger = Bukkit.getLogger();
    @Override
    public void onEnable() {
        logger.log(Level.INFO, "Plugin HalloweenDuo activé");
        Objects.requireNonNull(getCommand("debug")).setExecutor(new DebugCommandExecutor());
        Bukkit.getPluginManager().registerEvents(new OnDamageListener(), this);
        Bukkit.getPluginManager().registerEvents(new OnDamageByEntityListener(), this);
        Bukkit.getPluginManager().registerEvents(new OnJoinListener(), this);
        Bukkit.getPluginManager().registerEvents(new OnPlayerMove(), this);

        RefillChestRunnable refillChestRunnable = new RefillChestRunnable();
        refillChestRunnable.runTaskTimer(this, 0, 20);

        InvincibilityRunnable invincibilityRunnable = new InvincibilityRunnable();
        invincibilityRunnable.runTaskTimer(this, 0, 20);

        PlayerCheckIfSnowRunnable playerCheckIfSnowRunnable = new PlayerCheckIfSnowRunnable();
        playerCheckIfSnowRunnable.runTaskTimer(this, 0, 0);

        CooldownManagerRunnable cooldownManagerRunnable = new CooldownManagerRunnable();
        cooldownManagerRunnable.runTaskTimer(this, 0, 20);
    }

    @Override
    public void onDisable() {
        logger.log(Level.INFO, "Plugin HalloweenDuo désactivé");
    }
}

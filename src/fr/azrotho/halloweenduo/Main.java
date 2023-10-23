package fr.azrotho.halloweenduo;

import fr.azrotho.halloweenduo.command.DebugCommandExecutor;
import fr.azrotho.halloweenduo.command.FriendCommandExecutor;
import fr.azrotho.halloweenduo.listener.*;
import fr.azrotho.halloweenduo.runnable.*;
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
        Objects.requireNonNull(getCommand("friend")).setExecutor(new FriendCommandExecutor());

        Bukkit.getPluginManager().registerEvents(new OnDamageListener(), this);
        Bukkit.getPluginManager().registerEvents(new OnDamageByEntityListener(), this);
        Bukkit.getPluginManager().registerEvents(new OnJoinListener(), this);
        Bukkit.getPluginManager().registerEvents(new OnPlayerMove(), this);
        Bukkit.getPluginManager().registerEvents(new OnPlayerInteract(), this);

        RefillChestRunnable refillChestRunnable = new RefillChestRunnable();
        refillChestRunnable.runTaskTimer(this, 0, 20);

        InvincibilityRunnable invincibilityRunnable = new InvincibilityRunnable();
        invincibilityRunnable.runTaskTimer(this, 0, 20);

        PlayerCheckIfSnowRunnable playerCheckIfSnowRunnable = new PlayerCheckIfSnowRunnable();
        playerCheckIfSnowRunnable.runTaskTimer(this, 0, 0);

        CooldownManagerRunnable cooldownManagerRunnable = new CooldownManagerRunnable();
        cooldownManagerRunnable.runTaskTimer(this, 0, 20);

        FinalRunnable finalRunnable = new FinalRunnable();
        finalRunnable.runTaskTimer(this, 0, 1);
    }

    @Override
    public void onDisable() {
        logger.log(Level.INFO, "Plugin HalloweenDuo désactivé");
    }
}

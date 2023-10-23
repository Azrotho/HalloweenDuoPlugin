package fr.azrotho.halloweenduo.runnable;

import fr.azrotho.halloweenduo.Main;
import fr.azrotho.halloweenduo.utils.RefillChest;
import org.bukkit.scheduler.BukkitRunnable;

public class RefillChestRunnable extends BukkitRunnable {

    public static int timerBeforeRefill = 0;
    @Override
    public void run() {
        if(!Main.started) {
            return;
        }
        if(timerBeforeRefill == 0) {
            RefillChest.refillChests();
            timerBeforeRefill = (int) (Math.random() * 60 * 4) + 60;
        } else {
            timerBeforeRefill--;
        }
    }
}

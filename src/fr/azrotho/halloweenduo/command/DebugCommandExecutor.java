package fr.azrotho.halloweenduo.command;

import fr.azrotho.halloweenduo.utils.RefillChest;
import fr.azrotho.halloweenduo.utils.StartFunctions;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class DebugCommandExecutor implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(!commandSender.isOp()) {
            commandSender.sendMessage("§cVous n'avez pas la permission d'utiliser cette commande");
            return true;
        }

        switch (strings[0]) {
            case "getRandomWeapon":
                Player player = (Player) commandSender;
                player.getInventory().addItem(fr.azrotho.halloweenduo.utils.LootUtils.getRandomWeapon());
                break;
            case "getRandomPotion":
                Player player1 = (Player) commandSender;
                player1.getInventory().addItem(fr.azrotho.halloweenduo.utils.LootUtils.getRandomPotion());
                break;
            case "refillChests":
                RefillChest.refillChests();
                break;
            case "start":
                StartFunctions.start();
        }

        return true;
    }
}

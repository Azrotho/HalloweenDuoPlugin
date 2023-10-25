package fr.azrotho.halloweenduo.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Chest;
import org.bukkit.block.data.Directional;

import java.util.List;

public class RefillChest {
    public static final List<Location> CHESTS = List.of(
            new Location(Bukkit.getWorld("world"), 808, 202, -615),
            new Location(Bukkit.getWorld("world"), 785, 202, -615),
            new Location(Bukkit.getWorld("world"), 788, 202, -592),
            new Location(Bukkit.getWorld("world"), 816, 202, -594),
            new Location(Bukkit.getWorld("world"), 826, 202, -592),
            new Location(Bukkit.getWorld("world"), 834, 202, -615),
            new Location(Bukkit.getWorld("world"), 828, 202, -644),
            new Location(Bukkit.getWorld("world"), 785, 202, -638),
            new Location(Bukkit.getWorld("world"), 820, 201, -637),

            new Location(Bukkit.getWorld("world"), 830, 208, -619),
            new Location(Bukkit.getWorld("world"), 786, 208, -614),
            new Location(Bukkit.getWorld("world"), 786, 208, -593),
            new Location(Bukkit.getWorld("world"), 809, 208, -592),
            new Location(Bukkit.getWorld("world"), 835, 208, -594)
    );

    public static void refillChests() {
        for(Location location : CHESTS) {
            LootUtils.spawnChest(location.clone(), BlockFace.NORTH, LootUtils.getRandomLoot());
        }
    }

    public static void refillRandomChest() {
        LootUtils.spawnChest(CHESTS.get((int) (Math.random() * CHESTS.size())).clone(), BlockFace.NORTH, LootUtils.getRandomLoot());
    }

    public static void clearAllChests() {
    for(Location location : CHESTS) {
            LootUtils.clearChest(location);
        }
    }
}

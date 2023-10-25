package fr.azrotho.halloweenduo.utils;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Chest;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;

public class LootUtils {
    private static final int FIREWORKS_NUM = 3;
    private static final double FIREWORKS_SPAWN_OFFSET = 0.5;

    private static final List<ItemStack> WEAPONS = List.of(
            new ItemStack(Material.STONE_SWORD),
            new ItemStack(Material.WOODEN_SWORD),
            new ItemStack(Material.GOLDEN_SWORD),
            new ItemStack(Material.WOODEN_AXE),
            new ItemStack(Material.STONE_AXE),
            new ItemStack(Material.NETHERITE_HOE),
            new ItemStack(Material.DIAMOND_SHOVEL),
            new ItemStack(Material.IRON_PICKAXE)
    );

    private static final List<ItemStack> POTIONS = List.of(
            ItemBuilder.createSplashPotionItemStack(
                    "§7Potion d'Invisibilité",
                    List.of(
                            new PotionEffect(PotionEffectType.INVISIBILITY, 30*20, 0, false)),
                    Color.GRAY
                    ),
            ItemBuilder.createSplashPotionItemStack(
                    "§bPotion de rapidité",
                    List.of(
                            new PotionEffect(PotionEffectType.SPEED, 30*20, 1, false)),
                    Color.GRAY
            ),
            ItemBuilder.createSplashPotionItemStack(
                    "§aPotion de maître tortue",
                    List.of(
                            new PotionEffect(PotionEffectType.SLOW, 30*20, 3, false),
                            new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 30*20, 2, false)),
                    Color.LIME
            ),
            ItemBuilder.createSplashPotionItemStack(
                    "§2Potion de Poison",
                    List.of(
                            new PotionEffect(PotionEffectType.POISON, 30*20, 1, false)),
                    Color.GREEN
            ),
            ItemBuilder.createSplashPotionItemStack(
                    "§d§lPotion de régénération",
                    List.of(
                            new PotionEffect(PotionEffectType.REGENERATION, 30*20, 0, false)),
                    Color.FUCHSIA
            ),
            ItemBuilder.createSplashPotionItemStack(
                    "§c§lPotion de force",
                    List.of(
                            new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 30*20, 0, false)),
                    Color.RED
            ),
            ItemBuilder.createSplashPotionItemStack(
                    "§5§lPotion de dégâts",
                    List.of(
                            new PotionEffect(PotionEffectType.HARM, 1, 0, false)),
                    Color.PURPLE
            ),
            ItemBuilder.createSplashPotionItemStack(
                    "§6§lPotion de Soin",
                    List.of(
                            new PotionEffect(PotionEffectType.HEAL, 1, 0, false)),
                    Color.ORANGE
            ),

            ItemBuilder.getLingeringPotionInstantDamageII()
    );

    private static final List<ItemStack> EXTRA_ITEMS = List.of(
            ItemBuilder.getDarknessItemStack(),
            ItemBuilder.getBlindnessItemStack(),
            ItemBuilder.getSlownessItemStack()
            );

    public static void spawnChest(Location loc, BlockFace direction, ItemStack... itemStacks) {
        Inventory inv = spawnChestInventory(loc, direction);
        if (inv == null) return;
        inv.clear();
        inv.addItem(itemStacks);
        spawnFireworks(loc);
    }

    public static void spawnChest(Location loc, Inventory inv) {
        spawnChest(loc, inv, BlockFace.NORTH);
    }

    public static void spawnChest(Location loc, Inventory inv, BlockFace direction) {
        Inventory chestInv = spawnChestInventory(loc, direction);
        if (chestInv == null) return;
        chestInv.setContents(inv.getContents());
        spawnFireworks(loc);
    }

    private static Inventory spawnChestInventory(Location loc) {
        return spawnChestInventory(loc, BlockFace.NORTH);
    }

    private static Inventory spawnChestInventory(Location loc, BlockFace direction) {
        World world = Bukkit.getWorld("world");
        if (world == null) return null;
        world.getBlockAt(loc).setType(Material.CHEST);
        Chest chest = (Chest) world.getBlockAt(loc).getState();
        org.bukkit.block.data.type.Chest chestData = (org.bukkit.block.data.type.Chest) chest.getBlockData();
        chestData.setFacing(direction);
        world.getBlockAt(loc).setBlockData(chestData);
        return chest.getBlockInventory();
    }

    private static void spawnFireworks(@NotNull Location loc) {
        World world = Bukkit.getWorld("world");
        if (world == null) return;
        world.playSound(loc, Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
    }

    public static ItemStack getRandomWeapon() {
        List<ItemStack> tempList = new java.util.ArrayList<>(WEAPONS);
        Collections.shuffle(tempList);
        return tempList.get(0);
    }

    public static ItemStack getRandomPotion() {
        List<ItemStack> tempList = new java.util.ArrayList<>(POTIONS);
        Collections.shuffle(tempList);
        return tempList.get(0);
    }

    public static ItemStack getRandomExtraItem() {
        List<ItemStack> tempList = new java.util.ArrayList<>(EXTRA_ITEMS);
        Collections.shuffle(tempList);
        return tempList.get(0);
    }

    public static ItemStack getRandomLoot() {
        int random = (int) (Math.random() * 100);
        if (random < 50) {
            return getRandomWeapon();
        } else if (random < 70) {
            return getRandomPotion();
        } else if (random < 90) {
            return new ItemStack(Material.GOLDEN_APPLE, 1);
        } else {
            return getRandomExtraItem();
        }
    }

    public static void clearChest(Location location) {
        Block block = location.getBlock();
        if (block.getType() != Material.CHEST) return;
        Chest chest = (Chest) block.getState();
        chest.getBlockInventory().clear();
    }
}

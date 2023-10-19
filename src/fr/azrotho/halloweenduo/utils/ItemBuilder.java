package fr.azrotho.halloweenduo.utils;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ItemBuilder {
    public static ItemStack createItemStack(Material material, int amount, @Nullable String name, @Nullable List<String> lore) {
        ItemStack itemStack = new ItemStack(material, amount);
        ItemMeta itemMeta = itemStack.getItemMeta();
        if (name != null) {
            assert itemMeta != null;
            itemMeta.setDisplayName(name);
        }
        if (lore != null) {
            assert itemMeta != null;
            itemMeta.setLore(lore);
        }
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public static ItemStack createSplashPotionItemStack(String name, List<PotionEffect> potionsEffect, Color color) {
        ItemStack itemStack = new ItemStack(Material.SPLASH_POTION);
        PotionMeta potionMeta = ((PotionMeta) itemStack.getItemMeta());
        potionMeta.setColor(color);
        for(PotionEffect potionEffect : potionsEffect) {
            potionMeta.addCustomEffect(potionEffect, true);
        }
        potionMeta.setDisplayName(name);
        itemStack.setItemMeta(potionMeta);
        return itemStack;
    }
}

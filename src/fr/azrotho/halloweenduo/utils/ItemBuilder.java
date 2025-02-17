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

    public static ItemStack getLingeringPotionInstantDamageII() {
        ItemStack itemStack = new ItemStack(Material.LINGERING_POTION);
        PotionMeta potionMeta = ((PotionMeta) itemStack.getItemMeta());
        assert potionMeta != null;
        potionMeta.setColor(Color.RED);
        potionMeta.addCustomEffect(new PotionEffect(org.bukkit.potion.PotionEffectType.HARM, 1, 1), true);
        potionMeta.setDisplayName("§cPotion de nuage de dégâts instantanés II");
        itemStack.setItemMeta(potionMeta);
        return itemStack;
    }

    public static ItemStack getDarknessItemStack() {
        return createItemStack(Material.ECHO_SHARD, 1, "§8§lTénèbres", List.of(
                "§7Un objet qui aveugle le reste des joueurs"
        ));
    }

    public static ItemStack getBlindnessItemStack() {
        return createItemStack(Material.BLACK_DYE, 1, "§8§lCécité", List.of(
                "§7Un objet qui aveugle le reste des joueurs"
        ));
    }

    public static ItemStack getSlownessItemStack() {
        return createItemStack(Material.NETHERITE_BLOCK, 1, "§8§lLenteur", List.of(
                "§7Un objet qui ralentit le reste des joueurs"
        ));
    }

    public static ItemStack getPumpkinItemStack() {
        return createItemStack(Material.PUMPKIN, 1, "§6§lCitrouille", List.of(
                "§7Un objet qui a un pouvoir plutôt rigolo"
        ));
    }
}

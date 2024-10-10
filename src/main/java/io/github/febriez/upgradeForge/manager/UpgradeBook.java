package io.github.febriez.upgradeForge.manager;

import com.coffeetory.lib.utils.ItemBuilder;
import io.github.febriez.upgradeForge.UpgradeForgeMain;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public record UpgradeBook(UUID id, Enchantment enchant, int level, int chance) {

    public static final NamespacedKey KEY = new NamespacedKey(UpgradeForgeMain.getInstance(), "book.id");

    public void apply(@NotNull ItemStack item) {
        item.addUnsafeEnchantment(enchant, item.getEnchantmentLevel(enchant) + level);
    }

    public boolean hasEnchant(@NotNull ItemStack item) {
        return item.hasItemMeta() && item.getItemMeta().hasEnchant(enchant);
    }

    public ItemStack getItem() {
        return new ItemBuilder(Material.PAPER)
                .withDisplayName("§f§l[ §d§l강화서 §f§l]")
                .withLore("§f강화 타입: " + Component.translatable(enchant.key().value()))
                .withLore("§f강화 단계: " + level)
                .withLore("§f강화 확률: " + chance / 100 + "." + chance % 100 + "%")
                .withPersistentData(KEY, id.toString())
                .build();
    }
}

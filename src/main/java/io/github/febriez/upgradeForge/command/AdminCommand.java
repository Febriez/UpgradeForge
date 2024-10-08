package io.github.febriez.upgradeForge.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class AdminCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String l, @NotNull String[] args) {
        if (!(sender instanceof Player p)) return false;
        ItemStack item = p.getInventory().getItemInMainHand();
        item.addUnsafeEnchantment(Enchantment.EFFICIENCY, item.getEnchantmentLevel(Enchantment.EFFICIENCY) + 5);
        return false;
    }
}

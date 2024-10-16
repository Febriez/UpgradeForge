package io.github.febriez.upgradeForge.gui;

import io.github.febriez.upgradeForge.manager.UpgradeBook;
import io.github.febriez.upgradeForge.manager.UpgradeManager;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class UpgradeGUI implements InventoryHolder {

    private final Player owner;
    private final Inventory inv;

    private UpgradeGUI(Player p) {
        owner = p;
        inv = Bukkit.createInventory(this, 27, Component.text(""));
    }

    public ItemStack getItem() {
        return inv.getItem(11);
    }

    public UpgradeBook getUpgradeBook() {
        ItemStack item = inv.getItem(13);
        String id = item == null || !item.hasItemMeta() ? null : item.getItemMeta().getPersistentDataContainer()
                .get(UpgradeBook.KEY, PersistentDataType.STRING);
        if (id == null || id.isEmpty()) return null;
        return UpgradeManager.getInstance().getUpgradeBook(UUID.fromString(id));
    }

    public boolean isSet() {
        return getItem() != null && getUpgradeBook() != null;
    }

    public boolean isAttachable() {
        return isSet() && getUpgradeBook().attachable(getItem());
    }

    public Player getOwner() {
        return owner;
    }

    @Override
    public @NotNull Inventory getInventory() {
        return inv;
    }
}

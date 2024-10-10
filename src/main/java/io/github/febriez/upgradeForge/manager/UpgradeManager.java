package io.github.febriez.upgradeForge.manager;

import org.bukkit.enchantments.Enchantment;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class UpgradeManager {

    private static UpgradeManager instance;

    private final Map<UUID, UpgradeBook> upgradeBookMap;

    private UpgradeManager() {
        upgradeBookMap = new HashMap<>();
    }

    public UpgradeBook getUpgradeBook(UUID uuid) {
        return upgradeBookMap.get(uuid);
    }

    public UpgradeBook registerUpgradeBook(Enchantment type, int level, int chance) {
        if (hasBook(type, level, chance)) return getBook(type, level, chance);
        UpgradeBook book = new UpgradeBook(UUID.randomUUID(), type, level, chance);
        return upgradeBookMap.put(book.id(), book);
    }

    private boolean hasBook(Enchantment type, int level, int chance) {
        return upgradeBookMap.values().stream().anyMatch(a -> a.enchant() == type && a.level() == level && a.chance() == chance);
    }

    private @NotNull UpgradeBook getBook(Enchantment type, int level, int chance) {
        Optional<UpgradeBook> result = upgradeBookMap.values().stream()
                .filter(a -> a.enchant() == type && a.level() == level && a.chance() == chance).findFirst();
        if (result.isEmpty()) throw new RuntimeException("Error Code: 스트림 오류");
        return result.get();
    }

    public static UpgradeManager getInstance() {
        if (instance == null) instance = new UpgradeManager();
        return instance;
    }
}

package io.github.febriez.upgradeForge.manager;

import java.util.HashMap;
import java.util.Map;
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

    public static UpgradeManager getInstance() {
        if (instance == null) instance = new UpgradeManager();
        return instance;
    }
}

package io.github.febriez.upgradeForge;

import com.coffeetory.lib.LibraryMain;
import io.github.febriez.upgradeForge.command.AdminCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class UpgradeForgeMain extends JavaPlugin {

    public static UpgradeForgeMain instance;

    @Override
    public void onEnable() {
        instance = this;
        LibraryMain.registerCommand(getCommand("강화"), new AdminCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static UpgradeForgeMain getInstance() {
        return instance;
    }
}

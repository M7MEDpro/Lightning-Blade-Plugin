package dev.m7med.lightningblade;

import dev.velix.imperat.BukkitImperat;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class LightningBlade extends JavaPlugin {
    public static LightningBlade instance;
    private ConfigManger config;
    private BukkitImperat imperat;
    private BladeCustomItem customItem;

    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();
        instance = this;
        config = new ConfigManger();
        customItem = new BladeCustomItem();
        imperat = BukkitImperat.builder(this).build();
        imperat.registerCommand(new GiveCommand());
        Bukkit.getPluginManager().registerEvents(new SwordUseEvent(),this);
    }

    @Override
    public void onDisable() {
    }
    public static LightningBlade getInstance() {
        return instance;
    }

    public ConfigManger getConfigManger() {
        return config;
    }
    public BladeCustomItem getCustomItem() {
        return customItem;
    }
}

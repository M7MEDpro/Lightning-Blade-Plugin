package dev.m7med.lightningblade;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.List;
import java.util.Map;

public class ConfigManger {
    private final FileConfiguration config = LightningBlade.getInstance().getConfig();
    private final MiniMessage mini = MiniMessage.miniMessage();

    private final Material material = Material.getMaterial(config.getString("Lighting-Sword.Material", "DIAMOND_SWORD"));
    private final Component displayName = mini.deserialize(config.getString("Lighting-Sword.Display-Name", "<gray>Light Sword"));
    private final List<Component> loreList = config.getStringList("Lighting-Sword.Lore").stream()
            .map(mini::deserialize)
            .toList();
    private final int cooldown = config.getInt("Lighting-Sword.cooldown", 10);
    private final boolean isEnchanted = config.getBoolean("Lighting-Sword.isEnchanted");
    private final List<String> enchantments = config.getStringList("Lighting-Sword.Enchantments");
    private final int range = config.getInt("Lighting-Sword.Range", 15);




    public Material getMaterial() {
        return material;
    }

    public Component getDisplayName() {
        return displayName;
    }

    public List<Component> getLoreList() {
        return loreList;
    }

    public int getCooldown() {
        return cooldown;
    }

    public boolean isEnchanted() {
        return isEnchanted;
    }

    public List<String> getEnchantments() {
        return enchantments;
    }

    public int getRange() {
        return range;
    }
    public static Component get(String key, Map<String, String> placeholders, String defaultMessage) {

        String raw = LightningBlade.getInstance().getConfig().getString("messages." + key, defaultMessage);

        for(Map.Entry<String, String> entry : placeholders.entrySet()) {
            raw = raw.replace("%" + (String)entry.getKey() + "%", (CharSequence)entry.getValue());
        }

        return MiniMessage.miniMessage().deserialize(raw);
    }
}

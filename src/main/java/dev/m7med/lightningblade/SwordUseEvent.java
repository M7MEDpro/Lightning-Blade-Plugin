package dev.m7med.lightningblade;

import net.kyori.adventure.text.Component;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SwordUseEvent implements Listener {
    Map<UUID, Long> cooldownMap = new HashMap<>();
    long cooldown = LightningBlade.getInstance().getConfigManger().getCooldown() * 1000L;
    @EventHandler
    public void onRightClick(PlayerInteractEvent event) {
        NamespacedKey lightningKey = LightningBlade.getInstance().getCustomItem().key;
        Player player = event.getPlayer();
        if (event.getAction() != Action.RIGHT_CLICK_BLOCK && event.getAction() != Action.RIGHT_CLICK_AIR) return;
        ItemStack item = player.getItemInHand();
        if (item == null || item.getType().isAir()) return;

        PersistentDataContainer container = item.getItemMeta().getPersistentDataContainer();
        if(container.has(lightningKey, PersistentDataType.BOOLEAN)) {
            if (cooldownMap.containsKey(player.getUniqueId())) {
                if (cooldownMap.get(player.getUniqueId()) + cooldown > System.currentTimeMillis()) {
                    long timeLeft = ((cooldownMap.get(player.getUniqueId()) + cooldown) - System.currentTimeMillis()) / 1000;

                    Map<String, String> data = Map.of("itemname", LightningBlade.getInstance().getConfig().getString("Lighting-Sword.Display-Name", "<gray>Light Sword"), "cooldown",String.valueOf(timeLeft) );
                    Component Massage =LightningBlade.getInstance().getConfigManger().get("cooldown",data,"you have to wait <red>%cooldown%<red> seocnds before using %itemname%");
                    player.sendMessage(Massage);
                    return;
                }
            }
            ;
            player.getWorld().strikeLightning(player.getTargetBlock(null, LightningBlade.getInstance().getConfigManger().getRange()).getLocation());
            cooldownMap.put(player.getUniqueId(), System.currentTimeMillis());
        }


    }

    @EventHandler
    public void onEntityRightClick(PlayerInteractAtEntityEvent event) {
        NamespacedKey lightningKey = LightningBlade.getInstance().getCustomItem().key;
        Player player = event.getPlayer();

        ItemStack item = player.getItemInHand();
        if (item == null || item.getType().isAir()) return;

        PersistentDataContainer container = item.getItemMeta().getPersistentDataContainer();
        if (!container.has(lightningKey, PersistentDataType.BOOLEAN)) return;

        if (cooldownMap.containsKey(player.getUniqueId())) {
            long lastUsed = cooldownMap.get(player.getUniqueId());
            if (lastUsed + cooldown > System.currentTimeMillis()) {
                long timeLeft = ((lastUsed + cooldown) - System.currentTimeMillis()) / 1000;
                Map<String, String> data = Map.of(
                        "itemname", LightningBlade.getInstance().getConfig().getString("Lighting-Sword.Display-Name", "<gray>Light Sword"),
                        "cooldown", String.valueOf(timeLeft)
                );
                Component message = LightningBlade.getInstance().getConfigManger().get(
                        "cooldown", data, "you have to wait <red>%cooldown%<red> seconds before using %itemname%"
                );
                player.sendMessage(message);
                return;
            }
        }

        event.getRightClicked().getWorld().strikeLightning(event.getRightClicked().getLocation());
        cooldownMap.put(player.getUniqueId(), System.currentTimeMillis());
    }

}

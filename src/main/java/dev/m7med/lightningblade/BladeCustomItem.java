package dev.m7med.lightningblade;

import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.List;

public class BladeCustomItem {
    ConfigManger configManger = LightningBlade.getInstance().getConfigManger();
    public NamespacedKey key = new NamespacedKey(LightningBlade.getInstance(), "Lightning-Sword");

    public ItemStack itemBuilder(){
         ItemStack item = new ItemStack(configManger.getMaterial());
         ItemMeta meta = item.getItemMeta();
         meta.displayName(configManger.getDisplayName());
         meta.getPersistentDataContainer().set(key, PersistentDataType.BOOLEAN,true);
         meta.lore(configManger.getLoreList());
         if(configManger.isEnchanted()){
             List<String> enchantments = configManger.getEnchantments();
             for (String enchantLine : enchantments) {
                 String[] parts = enchantLine.split(":");
                 if (parts.length == 2) {
                     String enchantName = parts[0].toUpperCase();
                     int level= Integer.parseInt(parts[1]);
                     Enchantment enchant = Enchantment.getByName(enchantName);
                     if (enchant != null) {
                         meta.addEnchant(enchant, level, true);
                 }
             }

             }}
         item.setItemMeta(meta);
         return item;
     }

}

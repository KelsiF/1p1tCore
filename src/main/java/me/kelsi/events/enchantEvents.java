package me.kelsi.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Collections;

public class enchantEvents implements Listener {

    JavaPlugin plugin;
    public enchantEvents(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onEnchantEvent(EnchantItemEvent event) {
        Player player = event.getEnchanter();
        if (player.hasPermission("1p1t.admin")) { //проверка админ ли, нужно на момент тестов плагина на основном сервере
            ItemStack item = event.getItem();
            ItemMeta itemmeta = item.getItemMeta();
            itemmeta.setLore(Collections.singletonList(itemmeta.getLore() + "\n<enchant>"));
        }
    }

}

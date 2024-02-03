package me.kelsi.events;

import static me.kelsi._1p1tCore.*;
import me.kelsi.utils.enchantRandomize;
import me.kelsi.utils.mainUtils;
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
            itemmeta.setLore(Collections.singletonList(mainUtils.color(itemmeta.getLore() + "\n<enchant>")));

            String enchant = null;
            int chance = enchantRandomize.randomize(5);
            for (int i = 0; i < 5; i++) {
                if (chance == i) {
                    enchant = enchantsSword.get(i);
                } if (chance != i) {
                    chance = enchantRandomize.randomize(5);
                    enchant = enchantsSword.get(i);
                } else {
                    player.sendActionBar("&cКастомное зачарование вам не выпало :(");
                }

                itemmeta.setLore(Collections.singletonList(mainUtils.color(itemmeta.getLore() + "\n" + enchant)));
            }
        }
    }

}

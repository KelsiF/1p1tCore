package me.kelsi;

import me.kelsi.events.enchantEvents;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class _1p1tCore extends JavaPlugin implements Listener {
    public static List<String> enchantsSword = new ArrayList<>();
    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new enchantEvents(this), this);
        for (int i = 0; i < 5; i++) {
            switch (i) {
                case 0:
                    enchantsSword.add("Отравление");
                case 1:
                    enchantsSword.add("Вампиризм");
                case 2:
                    enchantsSword.add("Стан");
                case 3:
                    enchantsSword.add("Опыт+");
                case 4:
                    enchantsSword.add("Двойной урон");
            }
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

package me.kelsi;

import me.kelsi.events.enchantEvents;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class _1p1tCore extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new enchantEvents(this), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

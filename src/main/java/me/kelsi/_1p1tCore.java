package me.kelsi;

import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import me.kelsi.commands.killCommand;
import me.kelsi.commands.statsCommand;
import me.kelsi.events.chatEvent;
import me.kelsi.events.deathEvent;
import me.kelsi.events.tabEvent;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;


public final class _1p1tCore extends JavaPlugin implements Listener {


    @Override
    public void onEnable() {
        // Plugin startup logic
            getCommand("stats").setExecutor(new statsCommand(this));
            getCommand("kill").setExecutor(new killCommand(this));
            getServer().getPluginManager().registerEvents(this, this);
            getServer().getPluginManager().registerEvents(new deathEvent(this), this);
            getServer().getPluginManager().registerEvents(new chatEvent(this), this);
            getServer().getPluginManager().registerEvents(new tabEvent(this), this);

            getConfig().options().copyDefaults();
            saveDefaultConfig();

        }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}

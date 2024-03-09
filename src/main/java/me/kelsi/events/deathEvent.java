package me.kelsi.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class deathEvent implements Listener {

    JavaPlugin plugin; public deathEvent(JavaPlugin plugin) {this.plugin = plugin;}

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        boolean isSuicided = plugin.getConfig().getBoolean("isSuicided");
        Player player = event.getEntity();

        if (isSuicided) {
            event.setDeathMessage(ChatColor.RED + player.getName() + " вскрыл вены...");
            plugin.getConfig().set("isSuicided", false);
        } else if (!isSuicided) {
            event.setDeathMessage(event.getDeathMessage());
            plugin.getConfig().set("isSuicided", false);
        }
    }

}

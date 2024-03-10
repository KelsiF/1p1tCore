package me.kelsi.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class chatEvent implements Listener {

    JavaPlugin plugin; public chatEvent(JavaPlugin plugin) {this.plugin = plugin;}

    @EventHandler
    public void onMessageSend(AsyncPlayerChatEvent event) {
        String message = event.getMessage();
        event.setCancelled(true);
        Player sender = event.getPlayer();
        String prefix = plugin.getConfig().getString("admin_prefix");

        for (Player p : plugin.getServer().getOnlinePlayers()) {
            if (sender.hasPermission("1p1t.admin")) {
                p.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + prefix + ChatColor.RESET + " <" + sender.getName() + ">" + " " + message);
            } else {
                p.sendMessage("<" + sender.getName() + ">" + " " + message);
            }
        }
    }

}

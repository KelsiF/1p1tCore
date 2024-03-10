package me.kelsi.events;

import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;
import me.kelsi.utils.color;

public class tabEvent implements Listener {


    JavaPlugin plugin; public tabEvent(JavaPlugin plugin) {this.plugin = plugin;}

    FileConfiguration config = plugin.getConfig();
    String tps = String.valueOf(Bukkit.getTPS());
    String online = String.valueOf(Bukkit.getOnlinePlayers().size());
    String header_text = color.color(config.getString("tab.header.a") + color.color(config.getString("tab.header.b")));
    String footer_text = color.color(config.getString("tab.footer.a").replace("value", online) + color.color(config.getString("tab.footer.b").replace("value", tps)));

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {

        Player player = event.getPlayer();
        if (plugin.getConfig().getBoolean("change.pt")) {
            plugin.getConfig().set("player_timer", player.getName());
        }
        for (Player p : Bukkit.getOnlinePlayers()) {
            BaseComponent[] header = TextComponent.fromLegacyText(color.color(header_text));
            BaseComponent[] footer = TextComponent.fromLegacyText(color.color(footer_text));
            p.setPlayerListHeaderFooter(header, footer);
        }

    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {

        Player player = event.getPlayer();
        if (plugin.getConfig().getBoolean("change.pt")) {
            plugin.getConfig().set("player_timer", player.getName());
        }
        for (Player p : Bukkit.getOnlinePlayers()) {
            BaseComponent[] header = TextComponent.fromLegacyText(color.color(header_text));
            BaseComponent[] footer = TextComponent.fromLegacyText(color.color(footer_text));
            p.setPlayerListHeaderFooter(header, footer);
        }

    }

    @EventHandler
    public void onTabUpdate(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        String timer_name = plugin.getConfig().getString("player_timer");


        if (player.getName().equalsIgnoreCase(timer_name)) {

            for (Player p : Bukkit.getOnlinePlayers()) {
                BaseComponent[] header = TextComponent.fromLegacyText(color.color(header_text));
                BaseComponent[] footer = TextComponent.fromLegacyText(color.color(footer_text));
                p.setPlayerListHeaderFooter(header, footer);
            }

        }
    }
}

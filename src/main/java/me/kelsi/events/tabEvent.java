package me.kelsi.events;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.WrappedChatComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;
import me.kelsi.utils.color;

import java.util.List;

public class tabEvent implements Listener {

    private List<String> headerLines;
    private List<String> footerLines;

    JavaPlugin plugin; public tabEvent(JavaPlugin plugin) {this.plugin = plugin;}

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {

        Player player = event.getPlayer();
        if (plugin.getConfig().getBoolean("change.pt")) {
            plugin.getConfig().set("player_timer", player.getName());
        }

    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {

        Player player = event.getPlayer();
        if (plugin.getConfig().getBoolean("change.pt")) {
            plugin.getConfig().set("player_timer", player.getName());
        }

    }

    @EventHandler
    public void onTabUpdate(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        String timer_name = plugin.getConfig().getString("player_timer");
        ProtocolManager manager = ProtocolLibrary.getProtocolManager();


        if (player.getName().equalsIgnoreCase(timer_name)) {

            PacketContainer pc = manager.createPacket((PacketType.Play.Server.PLAYER_LIST_HEADER_FOOTER));

            pc.getChatComponents().write(0, WrappedChatComponent.fromText(color.color(plugin.getConfig().getString("tab.header", ""))))
                    .write(1, WrappedChatComponent.fromText(color.color(plugin.getConfig().getString("tab, footer"))));
            try {
                for (Player p : Bukkit.getOnlinePlayers()) {
                    manager.sendServerPacket(p, pc);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}

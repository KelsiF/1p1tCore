package me.kelsi.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class killCommand implements CommandExecutor {
    JavaPlugin plugin; public killCommand(JavaPlugin plugin) {this.plugin = plugin;}
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // /kill null/player
        Player player = null;
        if (sender instanceof Player) {
            player = (Player) sender;
        }
        if (args.length <= 0) {
            plugin.getConfig().set("isSuicided", true);
            player.setHealth(0);
            plugin.saveConfig();

            return true;
        } else {
            if (player.hasPermission("fransetcore.admin")) {
                Player target = Bukkit.getPlayer(args[1]);
                target.setHealth(0);

                return true;
            } else {
                player.sendMessage(ChatColor.RED + "Убивать других игроков командой может только администрация");
            }
        }

        return true;
    }
}

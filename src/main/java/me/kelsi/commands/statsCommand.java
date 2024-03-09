package me.kelsi.commands;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import java.text.SimpleDateFormat;
import java.util.Date;

public class statsCommand implements CommandExecutor {
    JavaPlugin plugin; public statsCommand(JavaPlugin plugin) {this.plugin = plugin;}
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // /stats world/player /<player>
        Player player = (Player) sender;
        World world = player.getWorld();
        String world_text = ChatColor.BOLD + "Информация о мире:" + ChatColor.RESET + "\nНазвание: " + world.getName() + "Барьер: " + world.getWorldBorder().getSize() + "\nСложность: " + world.getDifficulty();
        if (args.length <= 0) {
            return false;
        } else {
            if (args[0] == null) {
                return false;
            } else {
                if (args[0].equals("world")) {
                    player.sendMessage(world_text);
                    return true;
                } else if(args[0].equals("player")) {
                    if (args[1] == null) {
                        return false;
                    } else {
                        if (player.hasPermission("1p1t.vip")) {
                            Player target = Bukkit.getPlayer(args[1]);
                            Date date = new Date(target.getFirstPlayed());
                            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
                            player.sendMessage(ChatColor.BOLD + "Информация о игроке: " + ChatColor.RESET + "\nНикнейм: " + target.getName() + "\nвпервые зашел на сервер: " + sdf.format(date) + "\nУбито игроков/мобов: " + target.getStatistic(Statistic.PLAYER_KILLS) + "/" + target.getStatistic(Statistic.MOB_KILLS) + "Смертей: " + target.getStatistic(Statistic.DEATHS) + "Наиграно: " + target.getStatistic(Statistic.PLAY_ONE_TICK) + " ч.");
                            return true;
                        } else {
                            player.sendMessage(ChatColor.RED + "Эта команда доступна только ВИП-игрокам.\nПриобрести его вы можете на сайте: shop.1p1t.ru");
                        }
                    }
                }
            }
        }

        return true;
    }
}

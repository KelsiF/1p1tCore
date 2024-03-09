package me.kelsi.utils;

import org.bukkit.ChatColor;

public class color {

    public static String color(String str) {
        return ChatColor.translateAlternateColorCodes('&', str);
    }

}

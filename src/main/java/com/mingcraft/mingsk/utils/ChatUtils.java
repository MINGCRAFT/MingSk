package com.mingcraft.mingsk.utils;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChatUtils {
    private static final Pattern HEX_PATTERN = Pattern.compile("&(#\\w{6})");

    public static String colored(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static List<String> colored(String... messages){
        List<String> result = new ArrayList<>();
        for (String message : messages) {
            result.add(ChatColor.translateAlternateColorCodes('&', message));
        }
        return result;
    }

    public static List<String> colored(List<String> messages){
        List<String> result = new ArrayList<>();
        for (String message : messages) {
            result.add(ChatColor.translateAlternateColorCodes('&', message));
        }
        return result;
    }

    public static String hexColored(String message) {
        Matcher matcher = HEX_PATTERN.matcher(ChatColor.translateAlternateColorCodes('&', message));
        StringBuffer buffer = new StringBuffer();

        while (matcher.find()) {
            matcher.appendReplacement(buffer, ChatColor.of(matcher.group(1)).toString());
        }

        return matcher.appendTail(buffer).toString();
    }

    public static List<String> hexColored(String... messages) {
        List<String> result = new ArrayList<>();
        for (String message : messages) {
            result.add(hexColored(message));
        }
        return result;
    }

    public static List<String> hexColored(List<String> messages) {
        List<String> result = new ArrayList<>();
        for (String message : messages) {
            result.add(hexColored(message));
        }
        return result;
    }

    public static String uncolored(String message) {
        return ChatColor.stripColor(message);
    }

    public static List<String> uncolored(String... messages) {
        List<String> result = new ArrayList<>();
        for (String message : messages) {
            result.add(uncolored(message));
        }
        return result;
    }

    public static List<String> uncolored(List<String> messages) {
        List<String> result = new ArrayList<>();
        for (String message : messages) {
            result.add(uncolored(message));
        }
        return result;
    }

    public static void sendConsole(String message) {
        Bukkit.getConsoleSender().sendMessage(ChatUtils.hexColored(message));
    }

    public static void sendConsole(String... messages) {
        for (String message : messages) {
            sendConsole(message);
        }
    }

    public static void sendConsole(List<String> messages) {
        for (String message : messages) {
            sendConsole(message);
        }
    }

    public static String decimalFormat(Double number, String format) {
        return new DecimalFormat(format).format(number);
    }
}

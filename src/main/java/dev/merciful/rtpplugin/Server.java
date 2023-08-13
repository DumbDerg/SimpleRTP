package dev.merciful.rtpplugin;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Collection;

/**
 * Merci's Server class
 * Has useful static methods to be used in coding
 */
public class Server {
   private static Collection<? extends Player> players = Bukkit.getOnlinePlayers();

    /**
     Input a message and a permission, and it will send that message to everyone with that permission
     */
    static void sendPermissionMessage(String message, String permission){
        for (Player player : players){
            if(player.hasPermission(permission)){
                player.sendMessage(message);
            }
        }

    }
    /**
     * Send a message via the console
     * @param message: message you want to send
     */
    static void ConsoleBroadcast(String message) {
        Bukkit.getConsoleSender().sendMessage(message);
    }

    public static Collection<? extends Player> getPlayers() {
        return players;
    }
}

package dev.merciful.rtpplugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

public class RTPCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("SimpleRTP.rtp")){
                Teleport teleport = new Teleport(player);
            }
        }else {
            Server.ConsoleBroadcast("Only a player can run this command!");
        }
        return false;
    }
}

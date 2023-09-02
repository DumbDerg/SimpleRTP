package dev.merciful.rtpplugin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Reload implements CommandExecutor {

    private final RTPPlugin plugin;

    public Reload(RTPPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("SimpleRtp.reload")) {
                plugin.saveConfig();
                plugin.reloadConfig();
                player.sendMessage("SimpleRTP: config.yml has reloaded!");
            }else {
                player.sendMessage("Error: You have no permission to perform this command!");
            }

        }else {
            plugin.saveConfig();
            plugin.reloadConfig();
            Bukkit.getServer().getConsoleSender().sendMessage("SimpleRTP: config.yml has reloaded!");
        }
        return true;
    }
}

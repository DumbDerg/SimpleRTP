package dev.merciful.rtpplugin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class RTPCommand implements CommandExecutor {

    private final RTPPlugin plugin;
    private HashMap<UUID, Long> cooldown;
    private Player player;

    public RTPCommand(RTPPlugin plugin) {
        this.plugin = plugin;
        this.cooldown = new HashMap<>();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            this.player = (Player) sender;
            if (!cooldown.containsKey(player.getUniqueId()) || System.currentTimeMillis()/1000 - cooldown.get(player.getUniqueId()) > plugin.getConfig().getLong("Cooldown")) {
                if (player.hasPermission("SimpleRtp.rtp")) {
                    Teleport teleport = new Teleport(player, plugin);
                    cooldown.put(player.getUniqueId(), cooldown.put(player.getUniqueId(), System.currentTimeMillis()/1000));
                }
            } else {
                Bukkit.getServer().getConsoleSender().sendMessage("Error: only players can run this command!");
            }
        }else {
            player.sendMessage("You can't use /rtp for another" + (plugin.getConfig().getLong("Cooldown") - (System.currentTimeMillis()/1000 - cooldown.get(player.getUniqueId())) + " seconds!"));


        }
        return true;
    }
}

package dev.merciful.rtpplugin;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class RTPPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getConsoleSender().sendMessage("Starting up SimpleRTP!");
        getCommand("rtp").setExecutor(new RTPCommand(this));
        getCommand("rtpReload").setExecutor(new Reload(this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

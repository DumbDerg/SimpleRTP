package dev.merciful.rtpplugin;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Teleport {
    private int i = 0; //A fail-safe just incase there are no safe locations after a set number of tries
    private Player player;
    private Location newLocation;
    private Random random = new Random();
    private final Material[] list = {Material.LAVA,Material.WATER,Material.FIRE,Material.MAGMA_BLOCK,Material.AIR,Material.VOID_AIR};
    private final ArrayList<Material> unsafeMaterials = new ArrayList<>(List.of(list));

    public Teleport(Player player) {
        this.player = player;
        getNewLocation();
    }

    private void getNewLocation() {
        if(!player.getWorld().getEnvironment().equals(World.Environment.NETHER)){
        while (true) {
            int x = random.nextInt(-(int) this.player.getWorld().getWorldBorder().getSize() / 2 - 1, (int) this.player.getWorld().getWorldBorder().getSize() / 2 - 1);
            int z = random.nextInt(-(int) this.player.getWorld().getWorldBorder().getSize() / 2 - 1, (int) this.player.getWorld().getWorldBorder().getSize() / 2 - 1);
            Block block = player.getWorld().getHighestBlockAt(x, z);
            this.newLocation = new Location(this.player.getWorld(), x, this.player.getWorld().getHighestBlockYAt(x, z) + 1, z);
            if (!unsafeMaterials.contains(block.getBlockData().getMaterial())) {
                teleportPlayer();
                break;
            } else {
                this.i += 1;
                if (this.i == 25) {
                    this.i = 0;
                    player.sendMessage("Error: Unable to find a safe spot to teleport you!");
                    break;
                }
            }
        }
        }else{
            player.sendMessage("Error: /rtp isn't usable in the Nether!");
        }


    }
    private void teleportPlayer(){
        this.player.teleport(this.newLocation);
    }



}
package org.example;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getLogger().info("Bedwars 활성화!");

        getServer().getPluginManager().registerEvents(new JoinListener(), this);
        getServer().getPluginManager().registerEvents(new BlockListener(), this);
        getServer().getPluginManager().registerEvents(new BedListener(), this);
    }

    @Override
    public void onDisable() {
        getLogger().info("Bedwars 비활성화!");
    }

    // 최소 테스트용 스폰 좌표
    public static Location getRedSpawn() {
        return new Location(Bukkit.getWorld("world"), 0, 100, 0);
    }

    public static Location getBlueSpawn() {
        return new Location(Bukkit.getWorld("world"), 10, 100, 0);
    }
}

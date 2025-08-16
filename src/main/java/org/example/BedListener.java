package org.example;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import java.util.HashMap;
import java.util.Map;

public class BedListener implements Listener {

    // 팀별 침대 존재 여부
    private final Map<String, Boolean> beds = new HashMap<>();

    public BedListener() {
        beds.put("RED", true);
        beds.put("BLUE", true);
    }

    @EventHandler
    public void onBedPlace(BlockPlaceEvent event) {
        Block block = event.getBlock();
        Player player = event.getPlayer();

        if (block.getType() == Material.RED_BED) {
            beds.put("RED", true);
            player.sendMessage("빨강팀 침대 설치됨!");
        } else if (block.getType() == Material.BLUE_BED) {
            beds.put("BLUE", true);
            player.sendMessage("파랑팀 침대 설치됨!");
        }
    }

    @EventHandler
    public void onBedBreak(BlockBreakEvent event) {
        Block block = event.getBlock();
        Player player = event.getPlayer();

        if (block.getType() == Material.RED_BED && beds.get("RED")) {
            beds.put("RED", false);
            player.sendMessage("빨강팀 침대 파괴!");
        } else if (block.getType() == Material.BLUE_BED && beds.get("BLUE")) {
            beds.put("BLUE", false);
            player.sendMessage("파랑팀 침대 파괴!");
        }
    }

    // 침대 상태 확인
    public boolean isBedAlive(String team) {
        return beds.getOrDefault(team, false);
    }
}

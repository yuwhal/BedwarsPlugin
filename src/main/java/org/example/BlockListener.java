package org.example;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.entity.Player;

public class BlockListener implements Listener {

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        // 예: 모든 블록 설치 허용
        player.sendMessage("블록 설치: " + event.getBlockPlaced().getType());
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        // 예: 모든 블록 파괴 허용
        player.sendMessage("블록 파괴: " + event.getBlock().getType());
    }
}

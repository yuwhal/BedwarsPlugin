package org.example;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.entity.Player;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        // 최소 구조: 플레이어를 빨강팀 스폰으로 이동
        player.teleport(Main.getRedSpawn());
        player.sendMessage("Bedwars 테스트: 빨강팀 스폰으로 이동!");
    }
}

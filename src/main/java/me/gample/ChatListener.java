package me.gample;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerChatEvent;

public class ChatListener implements Listener {

    private Main main;
    private int minKills = 2;

    public ChatListener(Main main) {
        this.main = main;
    }

    @EventHandler
    public void onChat(PlayerChatEvent event) {
        if (!(main.getWhitelistPlayers().containsKey(event.getPlayer()) && main.getWhitelistPlayers().get(event.getPlayer())>=minKills)) {
            event.setCancelled(true);
            event.getPlayer().sendMessage("§f§lB§b§lM §8» §cMusisz zabic §4"+minKills+" §cgraczy, aby pisac na czacie!");
        }
    }

    @EventHandler
    public void onDamage(PlayerDeathEvent event) {
        if (event.getEntity().getKiller() != null) {

            int killedPlayers = 0;

            if (main.getWhitelistPlayers().containsKey(event.getEntity().getKiller())) {
                killedPlayers = main.getWhitelistPlayers().get(event.getEntity().getKiller());
            }
            main.getWhitelistPlayers().put(event.getEntity().getKiller(), killedPlayers +1);
            System.out.println(killedPlayers);
            System.out.println(event.getEntity().getKiller());
        }
    }
}

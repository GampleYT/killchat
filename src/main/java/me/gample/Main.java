package me.gample;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main extends JavaPlugin {
    private Map<Player, Integer> whitelistPlayers = new HashMap<>();

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new ChatListener(this), this);
    }

    public Map<Player, Integer> getWhitelistPlayers() {
        return whitelistPlayers;
    }
}

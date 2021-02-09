package net.eduard.curso.projeto.minion;

import org.bukkit.Location;

import java.util.HashMap;
import java.util.Map;

public class MinionPlayer {

    private String player;

    private Map<Location , MinionSpawned> minions = new HashMap<>();
    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public Map<Location, MinionSpawned> getMinions() {
        return minions;
    }
}

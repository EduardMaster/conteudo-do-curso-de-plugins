package net.eduard.curso.projeto.minion;

import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;

public class MinionSpawned {

    private String dono;
    private Location location;
    private Minion minion;
    private int life;
    private int food;
    private ArmorStand stand;
    private ArmorStand pickaxeStand;
    private int stage;

    public void spawn(){
        stand = location.getWorld().spawn(location, ArmorStand.class);

    }
    public void despawn(){
        stand.remove();
    }

    public Minion getMinion() {
        return minion;
    }

    public void setMinion(Minion minion) {
        this.minion = minion;
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public ArmorStand getStand() {
        return stand;
    }

    public void setStand(ArmorStand stand) {
        this.stand = stand;
    }

    public ArmorStand getPickaxeStand() {
        return pickaxeStand;
    }

    public void setPickaxeStand(ArmorStand pickaxeStand) {
        this.pickaxeStand = pickaxeStand;
    }

    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }
}

package net.eduard.curso.projeto.minion;


import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public class Minion {

    private String name;
    private UUID id= UUID.randomUUID();
    private MinionJob minionJob = MinionJob.MINER;
    private ItemStack icon;
    private int maxFood;
    private int maxLife;
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void reload(ConfigurationSection section) {

    }

    public void save(ConfigurationSection section) {

    }

    public MinionJob getMinionJob() {
        return minionJob;
    }

    public void setMinionJob(MinionJob minionJob) {
        this.minionJob = minionJob;
    }


    public int getMaxLife() {
        return maxLife;
    }

    public void setMaxLife(int maxLife) {
        this.maxLife = maxLife;
    }

    public int getMaxFood() {
        return maxFood;
    }

    public void setMaxFood(int maxFood) {
        this.maxFood = maxFood;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ItemStack getIcon() {
        return icon;
    }

    public void setIcon(ItemStack icon) {
        this.icon = icon;
    }
}

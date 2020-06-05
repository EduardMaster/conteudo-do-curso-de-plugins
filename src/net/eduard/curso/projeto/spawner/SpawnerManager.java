package net.eduard.curso.projeto.spawner;

import java.util.ArrayList;

import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;

import net.eduard.api.lib.storage.Storable;

public class SpawnerManager implements Storable {

    private ArrayList<Spawner> spawners =
            new ArrayList<>();

    public ArrayList<Spawner> getSpawners() {
        return spawners;
    }

    public Spawner getSpawner(ItemStack icon) {
        for (Spawner spawner : spawners) {
            if (spawner.getIcon().isSimilar(icon)) {
                return spawner;
            }
        }

        return null;
    }

    public Spawner getSpawner(EntityType tipo) {
        for (Spawner spawner : spawners) {
            if (spawner.getTipo() == tipo) {
                return spawner;
            }
        }
        return null;
    }

    public void setSpawners(
            ArrayList<Spawner> spawners) {
        this.spawners = spawners;
    }

}

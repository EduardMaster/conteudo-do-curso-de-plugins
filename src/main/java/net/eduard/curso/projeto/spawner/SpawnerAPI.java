package net.eduard.curso.projeto.spawner;

import org.bukkit.entity.EntityType;

import net.eduard.api.lib.config.BukkitConfig;
import net.eduard.curso.Main;

public class SpawnerAPI {

	private static BukkitConfig config = new BukkitConfig("spawners.yml", Main.getInstance());

	private static SpawnerManager manager;

	public static void reload() {
		config.reloadConfig();
		if (config.contains("spawners")) {
			manager = (SpawnerManager) config.get("spawners");
		} else {
			manager = new SpawnerManager();
			for (EntityType mob : EntityType.values()) {
				Spawner spawner = new Spawner();
				spawner.setTipo(mob);
				spawner.setMaxStack(100);
				manager.getSpawners().add(spawner);
			}
			save();

		}

	}

	public static void save() {
		config.set("spawners", manager);
		config.saveConfig();
	}

	public static BukkitConfig getConfig() {
		return config;
	}

	public static void setConfig(BukkitConfig config) {
		SpawnerAPI.config = config;
	}

	public static SpawnerManager getManager() {
		return manager;
	}

	public static void setManager(SpawnerManager manager) {
		SpawnerAPI.manager = manager;
	}
}

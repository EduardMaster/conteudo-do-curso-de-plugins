package net.eduard.curso.rankup;

import net.eduard.api.lib.BukkitConfig;
import net.eduard.api.lib.storage.StorageAPI;
import net.eduard.curso.CursoEduard;

public class RankAPI {

	private static BukkitConfig config = new BukkitConfig("rankup.yml", CursoEduard.getInstance());
	private static RankManager manager;

	public static BukkitConfig getConfig() {
		return config;
	}

	public static void setConfig(BukkitConfig config) {
		RankAPI.config = config;
	}

	public static RankManager getManager() {
		return manager;
	}

	public static void setManager(RankManager manager) {
		RankAPI.manager = manager;
	}

	public static void reload() {
		StorageAPI.register(Rank.class);
		StorageAPI.register(RankManager.class);

		if (config.contains("ranks")) {

			manager = (RankManager) config.get("ranks");

			StorageAPI.updateReferences();
		} else {
			manager = new RankManager();
			Rank primeiro = new Rank();
			primeiro.setName("Base");
			primeiro.setLevel(1);
			manager.register(primeiro);
			save();
		}
	}

	public static void save() {
		config.set("ranks", manager);
		config.saveConfig();
	}
}

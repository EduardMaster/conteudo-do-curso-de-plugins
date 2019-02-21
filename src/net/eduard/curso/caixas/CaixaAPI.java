package net.eduard.curso.caixas;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import net.eduard.api.lib.BukkitConfig;
import net.eduard.api.lib.Mine;
import net.eduard.api.lib.storage.StorageAPI;
import net.eduard.curso.CursoEduard;

public class CaixaAPI {
	private static CaixaManager manager;
	private static BukkitConfig config = new BukkitConfig("caixas.yml", CursoEduard.getInstance());
	static {
		StorageAPI.register(Caixa.class);
		StorageAPI.register(CaixaManager.class);
	}

	public static BukkitConfig getConfig() {
		return config;
	}

	public static void setConfig(BukkitConfig config) {
		CaixaAPI.config = config;
	}

	public static void reload() {
		config.reloadConfig();
		if (config.contains("caixas")) {
			manager = (CaixaManager) config.get("caixas");

		} else {
			manager = new CaixaManager();
			Caixa caixaExemplo = new Caixa();
			caixaExemplo.setNome("Basica");
			caixaExemplo.setIconeLoja(Mine.newItem(Material.ENDER_CHEST, "§aCaixa B§sica por 30 pila"));
			caixaExemplo.setCaixa(Mine.newItem(Material.CHEST, "§6Caixa B§sica"));

			caixaExemplo.getPremios().add(new ItemStack(Material.DIAMOND, 64));
			caixaExemplo.getPremios().add(new ItemStack(Material.IRON_INGOT, 64));
			caixaExemplo.getPremios().add(new ItemStack(Material.STONE, 64));

			caixaExemplo.getPremios().add(new ItemStack(Material.DIAMOND_CHESTPLATE));
			caixaExemplo.getPremios().add(new ItemStack(Material.DIAMOND_LEGGINGS));
			caixaExemplo.getPremios().add(new ItemStack(Material.DIAMOND_BOOTS));
			caixaExemplo.getPremios().add(new ItemStack(Material.DIAMOND_HELMET));

			manager.getCaixas().add(caixaExemplo);

			save();

		}
	}

	public static void save() {

		config.set("caixas", manager);
		config.saveConfig();
	}

	public static CaixaManager getManager() {
		return manager;
	}

	public static void setManager(CaixaManager manager) {
		CaixaAPI.manager = manager;
	}

}

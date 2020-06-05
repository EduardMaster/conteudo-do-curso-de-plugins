package net.eduard.curso.projeto.caixas;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import net.eduard.api.lib.config.BukkitConfig;
import net.eduard.api.lib.modules.Mine;
import net.eduard.curso.Main;

public class CaixaAPI {
	private static CaixaManager manager;
	private static BukkitConfig config = new BukkitConfig("caixas.yml", Main.getInstance());
	
	static {
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
		
			caixaExemplo.setCaixa(Mine.newItem(Material.CHEST, "§6Caixa Básica"));

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

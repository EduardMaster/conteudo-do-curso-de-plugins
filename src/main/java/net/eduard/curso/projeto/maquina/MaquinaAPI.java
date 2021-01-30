package net.eduard.curso.projeto.maquina;

import java.util.concurrent.TimeUnit;

import org.bukkit.Material;

import net.eduard.api.lib.config.BukkitConfig;
import net.eduard.api.lib.modules.Mine;
import net.eduard.api.lib.storage.StorageAPI;
import net.eduard.curso.Curso;

public class MaquinaAPI {

	private static BukkitConfig config = new BukkitConfig("maquinas.yml", Curso.getInstance());
	private static MaquinaManager manager;

	public static void reload() {
		config.reloadConfig();
		if (config.contains("maquinas")) {
			manager = (MaquinaManager) config.get("maquinas");
			StorageAPI.updateReferences();
		} else {
			manager = new MaquinaManager();
			Maquina maquinaDeSatoche = new Maquina(); 
			maquinaDeSatoche.setNome("Satoche");
			maquinaDeSatoche.setIcon(Mine.newItem(Material.IRON_BLOCK, "§aMaquina de Satoche"));
			maquinaDeSatoche.setDrop(Mine.newItem(Material.DOUBLE_PLANT, "§eSatoche"));
			manager.getMaquinas().add(maquinaDeSatoche);
			Combustivel combustivel = new Combustivel();
			combustivel.setName("Energia Eletrica");
			combustivel.setIcon(Mine.newItem(Material.REDSTONE,"§eEnergia Eletrica"));
			combustivel.setPrice(1000);
			combustivel.setDuration(TimeUnit.MINUTES.toMillis(5));
			manager.getCombustiveis().add(combustivel);
			save();
			
		}
		for (MaquinaInstalada maquina : manager.getInstaladas()){
			manager.getMaquinasCache().put(maquina.getLocation(),maquina);
		}

	}

	public static void save() {
		config.set("maquinas", manager);
		config.saveConfig();
	}

	public static BukkitConfig getConfig() {
		return config;
	}

	public static void setConfig(BukkitConfig config) {
		MaquinaAPI.config = config;
	}

	public static MaquinaManager getManager() {
		return manager;
	}

	public static void setManager(MaquinaManager manager) {
		MaquinaAPI.manager = manager;
	}

}

package net.eduard.curso.economia;

import java.util.HashMap;

import org.bukkit.entity.Player;

import net.eduard.api.lib.BukkitConfig;
import net.eduard.curso.CursoEduard;

public class CoinsAPI {

	public static HashMap<String, Double> dinheiro = new HashMap<>();

	public static BukkitConfig config = new BukkitConfig("dinheiro.yml", CursoEduard.getInstance());

	public static void save() {
		config.set("contas", dinheiro);
		config.saveConfig();

	}

	@SuppressWarnings("unchecked")
	public static void reload() {
		config.reloadConfig();
		dinheiro = (HashMap<String, Double>) config.get("contas");

		for (String key : config.getSection("contas").getKeys(false)) {
			dinheiro.put(key, config.getDouble("contas." + key));
		}

	}

	public static void setCoins(Player p, double quantia) {
		dinheiro.put(p.getName().toLowerCase(), quantia);
	}

	public static void addCoins(Player p, double quantia) {
		setCoins(p, getCoins(p) + quantia);
	}

	public static void removeCoins(Player p, double quantia) {
		setCoins(p, getCoins(p) - quantia);
	}

	public static double getCoins(Player p) {
		return dinheiro.getOrDefault(p.getName().toLowerCase(), 0D);
	}

}

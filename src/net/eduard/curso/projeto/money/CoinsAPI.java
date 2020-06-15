package net.eduard.curso.projeto.money;

import java.util.HashMap;

import org.bukkit.entity.Player;

import net.eduard.api.lib.config.BukkitConfig;
import net.eduard.curso.Main;

public class CoinsAPI {

	public static HashMap<String, Double> dinheiro = new HashMap<>();

	public static BukkitConfig config = new BukkitConfig("dinheiro.yml", Main.getInstance());

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

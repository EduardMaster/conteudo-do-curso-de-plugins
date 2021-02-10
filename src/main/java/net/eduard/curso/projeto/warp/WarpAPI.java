package net.eduard.curso.projeto.warp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import net.eduard.api.lib.config.BukkitConfigs;
import org.bukkit.Location;

import net.eduard.api.lib.config.BukkitConfig;
import net.eduard.curso.Curso;

public class WarpAPI {

	private static BukkitConfigs config = new BukkitConfigs("warps.yml");

	public static void setWarp(String name, Location local) {
		config.set("Warps." + name.toLowerCase(), local);
	}

	public static boolean hasWarps() {
		return config.contains("Warps") && getWarps().size() > 0;
	}

	public static Location getWarp(String name) {
		return config.getLocation("Warps." + name.toLowerCase());
	}

	public static boolean hasWarp(String name) {
		return config.contains("Warps." + name.toLowerCase());
	}

	public static void removeWarp(String name) {
		config.remove("Warps." + name.toLowerCase());
	}

	public static BukkitConfigs getConfig() {
		return config;
	}

	public static List<String> getWarps() {
		return new ArrayList<>(config.getSection("Warps").getKeys(false));
	}


}

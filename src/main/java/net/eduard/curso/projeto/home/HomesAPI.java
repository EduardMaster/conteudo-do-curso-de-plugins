package net.eduard.curso.projeto.home;

import java.util.List;
import java.util.stream.Collectors;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import net.eduard.api.lib.config.BukkitConfig;

public class HomesAPI {

	public static BukkitConfig homeConfig = new BukkitConfig("armazenamento.yml");

	public static void setHome(Player player, String home) {
		homeConfig.set("armazenamento." + player.getName() + "." + home, player.getLocation());
	}

	public static boolean hasHomes(Player player) {
		return getHomes(player).size() > 0;
	}

	public static List<String> getHomes(Player player) {
		return homeConfig.getSection("armazenamento."+player.getName()).getKeys(false).stream().collect(Collectors.toList());
	}

	public static Location getHome(Player player, String home) {
		return homeConfig.getLocation("armazenamento." + player.getName() + "." + home);
	}

	public static boolean existsHome(Player player, String home) {
		return homeConfig.contains("armazenamento." + player.getName() + "." + home);
	}

	public static void deleteHome(Player player, String home) {
		homeConfig.remove("armazenamento." + player.getName() + "." + home);
	
	}
}

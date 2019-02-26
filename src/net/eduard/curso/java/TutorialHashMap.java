package net.eduard.curso.java;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

/**
 * @sub_Autor ZBeta
 * @author Eduard
 *
 */
public class TutorialHashMap {
	public static List<Entry<String, Integer>> valores;

	public static HashMap<String, Integer> kills_dos_jogadores = new HashMap<>();

	public static void atualizador() {

		valores = kills_dos_jogadores.entrySet().stream().sorted((x, y) -> y.getValue().compareTo(x.getValue()))
				.collect(Collectors.toList());

	}

	public static void loadTop(Player player) {
		int id = 1;
		player.sendMessage("");
		player.sendMessage(ChatColor.GRAY + "Aqui estão os top " + ChatColor.RED + "10 " + ChatColor.GRAY + "KILLERS.");
		player.sendMessage("");

	}

}

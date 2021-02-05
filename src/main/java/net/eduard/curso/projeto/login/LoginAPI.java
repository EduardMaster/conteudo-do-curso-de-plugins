package net.eduard.curso.projeto.login;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.entity.Player;

import net.eduard.api.lib.config.BukkitConfig;

public class LoginAPI {
	private static HashMap<UUID, String> registrados = new HashMap<>();
	private static HashMap<Player, Long> logados = new HashMap<>();
	
	public static void register(Player player,String senha) {
		config.set("Contas."+player.getUniqueId()+".senha", senha);
		registrados.put(player.getUniqueId() , senha);

	}
	public static void login(Player player) {
		logados.put(player,System.currentTimeMillis());
		
	}
	public static String getSenha(Player player) {
		return config.getString("Contas."+player.getUniqueId()+".senha");
	}
	public static void logout(Player player) {
		logados.remove(player);
	}
	public static boolean isRegistred(Player player) {
		return config.contains("Contas."+player.getUniqueId());
	}
	
	private static BukkitConfig config;
	
	public static BukkitConfig getConfig() {
		return config;
	}
	public static void setConfig(BukkitConfig config) {
		LoginAPI.config = config;
	}
	public static HashMap<UUID, String> getRegistrados() {
		return registrados;
	}
	public static void setRegistrados(HashMap<UUID, String> registrados) {
		LoginAPI.registrados = registrados;
	}
	public static HashMap<Player, Long> getLogados() {
		return logados;
	}
	public static void setLogados(HashMap<Player, Long> logados) {
		LoginAPI.logados = logados;
	}
	
}

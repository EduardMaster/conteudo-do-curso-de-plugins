package net.eduard.curso.sistemas;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class AutoMensageiro extends BukkitRunnable {

	public AutoMensageiro(JavaPlugin plugin) {
		int tempoQueRepete = 20 * 10;
		// Nosso repetidor
		runTaskTimer(plugin, tempoQueRepete, tempoQueRepete);
	
	}

	public void run() {
		String mensagem = "§6Que mensagem foda!";
		// A cada 10 segundos | 20 ticks vezes 10 = 20 segundos

		Bukkit.broadcastMessage(mensagem);

	}
}

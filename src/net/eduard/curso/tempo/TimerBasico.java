package net.eduard.curso.tempo;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import net.eduard.api.server.EduardPlugin;

/**
 * Sistema de Temporizador básico usando classe {@link BukkitRunnable}
 * 
 * @author Eduard
 *
 */
public class TimerBasico extends BukkitRunnable {

	public TimerBasico(EduardPlugin plugin) {
		// ligando timer a cada 20 ticks (1 segundo)
		runTaskTimerAsynchronously(plugin, 20, 20);
	}

	/**
	 * Estado do timer se esta ligado ou não
	 */

	private boolean estado = true;
	/**
	 * Contagem atual do Timer
	 */
	private int contagem = 10;

	/**
	 * Método run() sobeescrito da interface {@link Runnable}<br>
	 * Aqui fica oque irá acontecer quando passar 1 segundo
	 */
	public void run() {

		contagem--;

		Bukkit.broadcastMessage("§aA contagem vai acabar em " + contagem + " segundos");

		if (contagem == 0) {

			Bukkit.broadcastMessage("§aAcabou o timer de 10s");
			cancel();
			setEstado(false);
		}

		// TODO Auto-generated method stub

	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

}

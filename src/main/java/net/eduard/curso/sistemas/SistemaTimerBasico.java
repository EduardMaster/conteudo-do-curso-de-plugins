package net.eduard.curso.sistemas;

import net.eduard.curso.Sistema;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import net.eduard.api.server.EduardPlugin;

/**
 * Sistema de Temporizador básico usando classe {@link BukkitRunnable}
 * 
 * @author Eduard
 *
 */
public class SistemaTimerBasico extends Sistema {


	/**
	 * Estado do timer se esta ligado ou não
	 */

	private boolean estado = true;
	/**
	 * Contagem atual do Timer
	 */
	private int contagem = 10;

	@Override
	public void onEnable() {
		registerAsyncTimer(20,20);
	}

	@Override
	public void onDisable() {

	}

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


	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

}

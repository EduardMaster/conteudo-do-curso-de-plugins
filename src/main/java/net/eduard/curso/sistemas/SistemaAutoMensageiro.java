package net.eduard.curso.sistemas;

import net.eduard.curso.Sistema;
import org.bukkit.Bukkit;

public class SistemaAutoMensageiro extends Sistema {


	@Override
	public void onEnable() {
		registerAsyncTimer(20,20);
	}

	@Override
	public void onDisable() {

	}

	public void run() {
		String mensagem = "§6Que mensagem foda!";
		// A cada 10 segundos | 20 ticks vezes 10 = 20 segundos

		Bukkit.broadcastMessage(mensagem);

	}
}

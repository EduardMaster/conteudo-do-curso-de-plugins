package net.eduard.curso.economia;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class CoinsEventos implements Listener {

	@EventHandler
	public void entrar(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		if (!CoinsSQL.temContaCriada(p.getName())) {
			CoinsSQL.criarContaNova(p.getName());
		}
	}
}

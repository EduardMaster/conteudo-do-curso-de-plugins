package net.eduard.curso.projeto.ban;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;

public class PunicaoControler implements Listener{
	@EventHandler
	public void evento(PlayerKickEvent e) {
		Player p = e.getPlayer();

	}

}

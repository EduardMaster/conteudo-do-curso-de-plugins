package net.eduard.curso.ban;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;

public class PunicaoControler implements Listener{
	@EventHandler
	public void evento(PlayerKickEvent e) {
		Player p = e.getPlayer();
//		if (estaBanido(p.getName())) {
//			Banimento ban = banimentos.get(p.getName());
//			e.setLeaveMessage("§cVoce foi banido por " + ban.getAlvo());
//
//		}
	}

}

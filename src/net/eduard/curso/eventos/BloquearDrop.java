package net.eduard.curso.eventos;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

/**
 * Jogadores não vão poder dropar itens
 * @author Eduard
 *
 */
public class BloquearDrop implements Listener{
	
	@EventHandler
	public void aoJogadorDroparItem(PlayerDropItemEvent e) {

		e.setCancelled(true);
	}

}

package net.eduard.curso.eventos;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

import net.eduard.curso.Assunto;
/**
 * Jogadores não vão poder dropar itens
 * @author Eduard
 *
 */
@Assunto(subnivel=3)
public class BloquearDrop implements Listener{
	
	@EventHandler
	public void aoJogadorDroparItem(PlayerDropItemEvent e) {

		e.setCancelled(true);
	}

}

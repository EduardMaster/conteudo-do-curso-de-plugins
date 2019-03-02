package net.eduard.curso.eventos;

import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

import net.eduard.curso.Assunto;
/**
 * Não deixar creeper explodir
 * @author Eduard
 *
 */
@Assunto(subnivel=3)
public class BloquearExplosao implements Listener{
	
	
	@EventHandler
	public void quandoUmaEntidadeTentarExplodir(EntityExplodeEvent e) {

		Entity entidade = e.getEntity();
		if (entidade instanceof Creeper) {
			e.setCancelled(true);
		}
	}
}

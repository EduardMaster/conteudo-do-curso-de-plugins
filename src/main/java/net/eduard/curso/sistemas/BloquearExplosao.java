package net.eduard.curso.sistemas;

import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

/**
 * Não deixar creeper explodir
 * @author Eduard
 *
 */
public class BloquearExplosao implements Listener{
	
	
	@EventHandler
	public void quandoUmaEntidadeTentarExplodir(EntityExplodeEvent e) {

		Entity entidade = e.getEntity();
		if (entidade instanceof Creeper) {
			e.setCancelled(true);
		}
	}
}

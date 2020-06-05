package net.eduard.curso.eventos;

import java.util.HashMap;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;




public class GerarQuemCausouUltimoDano implements Listener{
	
	public static HashMap<Player, Entity> damager = new HashMap<>();

	@EventHandler
	public void event(EntityDamageByEntityEvent e) {
		if (e.getEntity() instanceof Player) {
			Player p = (Player) e.getEntity();
			damager.put(p, e.getDamager());
		}
	}
}

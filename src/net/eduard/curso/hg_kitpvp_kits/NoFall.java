package net.eduard.curso.hg_kitpvp_kits;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

import net.eduard.api.server.kits.KitAbility;

public class NoFall extends KitAbility {

	public NoFall() {
		setIcon(Material.LAPIS_BLOCK, "§fN§o leve dano de Queda");
	}
	@EventHandler
	public void event(EntityDamageEvent e) {
		if (e.getEntity() instanceof Player) {
			Player p = (Player) e.getEntity();
			if (hasKit(p) && e.getCause() == DamageCause.FALL) {
				e.setCancelled(true);
			}

		}
	}

}

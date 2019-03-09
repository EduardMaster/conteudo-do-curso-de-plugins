package net.eduard.curso.eventos;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageModifier;
import org.bukkit.event.player.PlayerItemDamageEvent;

public class EditarDefesa implements Listener{

	@EventHandler
	public void event(EntityDamageEvent e) {
		if (e.getEntity() instanceof Player) {
			Player p = (Player) e.getEntity();
			p.sendMessage("§aDano armadura "+e.getDamage(DamageModifier.ARMOR));
			p.sendMessage("§aDano base "+e.getDamage(DamageModifier.BASE));
			p.sendMessage("§aDano absorvendo "+e.getDamage(DamageModifier.ABSORPTION));
			p.sendMessage("§aDano resistido "+e.getDamage(DamageModifier.RESISTANCE));
			p.sendMessage("§aDano magico "+e.getDamage(DamageModifier.MAGIC));
			p.sendMessage("       --      ");
		}
	}
	@EventHandler
	public void event(PlayerItemDamageEvent e) {
		Player p = e.getPlayer();
//		ItemStack item = e.getItem(); 
		p.sendMessage("§aSeu dano: §2"+e.getDamage());
	}
}

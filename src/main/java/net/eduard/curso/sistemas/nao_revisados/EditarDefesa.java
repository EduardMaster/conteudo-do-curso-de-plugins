package net.eduard.curso.sistemas.nao_revisados;

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
			Player player = (Player) e.getEntity();
			player.sendMessage("§aDano armadura "+e.getDamage(DamageModifier.ARMOR));
			player.sendMessage("§aDano base "+e.getDamage(DamageModifier.BASE));
			player.sendMessage("§aDano absorvendo "+e.getDamage(DamageModifier.ABSORPTION));
			player.sendMessage("§aDano resistido "+e.getDamage(DamageModifier.RESISTANCE));
			player.sendMessage("§aDano magico "+e.getDamage(DamageModifier.MAGIC));
			player.sendMessage("       --      ");
		}
	}
	@EventHandler
	public void event(PlayerItemDamageEvent e) {
		Player player = e.getPlayer();
//		ItemStack item = e.getItem(); 
		player.sendMessage("§aSeu dano: §2"+e.getDamage());
	}
}

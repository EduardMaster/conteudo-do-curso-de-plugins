package net.eduard.curso.sistemas.com_eventos;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;



public class BlocoComImpulsao implements Listener{
	@EventHandler
	public void BlocoPulador(EntityDamageEvent e) {
		if (e.getEntity() instanceof Player) {
			Player player = (Player) e.getEntity();
			if (e.getCause().equals(EntityDamageEvent.DamageCause.FALL)
				&& JUMPERS.contains(player)) {
				e.setCancelled(true);
				JUMPERS.remove(player);
			}
		
		}
	}


	public static final ArrayList<Player> JUMPERS = new ArrayList<>();
	@EventHandler
	public void BlocoPulador(PlayerMoveEvent e) {

		Player player = e.getPlayer();
		if (e.getTo().getBlock().getRelative(BlockFace.DOWN)
			.getType() == Material.DIAMOND_BLOCK) {
			JUMPERS.remove(player);
			Vector sponge = player.getLocation().getDirection().multiply(0).setY(1);
			player.setVelocity(sponge);
			JUMPERS.add(player);
		}
	}
}

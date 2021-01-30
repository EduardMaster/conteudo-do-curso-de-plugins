package net.eduard.curso.sistemas;

import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class CombatLog {
	public static final HashMap<Player, Long> ON_COMBAT = new HashMap<>();

	@EventHandler
	public void Combat(EntityDamageByEntityEvent e) {

		if (e.getEntity() instanceof Player) {
			Player player = (Player) e.getEntity();
			if (e.getDamager() instanceof Player) {
				Player damager = (Player) e.getDamager();
				if (!ON_COMBAT.containsKey(player)) {
					player.sendMessage("§cVoce entrou em combate!");
				}
				if (!ON_COMBAT.containsKey(damager)) {
					player.sendMessage("§cVoce entrou em combate!");
				}
				ON_COMBAT.put(damager, System.currentTimeMillis());
				ON_COMBAT.put(player, System.currentTimeMillis());
			}
		}
	}

	@EventHandler
	public void Combat(PlayerCommandPreprocessEvent e) {

		Player player = e.getPlayer();
		if (ON_COMBAT.containsKey(player)) {
			e.setCancelled(true);
			player.sendMessage("§cVoce esta em combate n§o pode usar comandos!");
		}
	}

	@EventHandler
	public void Combat(PlayerDeathEvent e) {

		Player player = e.getEntity();
		if (ON_COMBAT.containsKey(player)) {
			ON_COMBAT.remove(player);
			player.sendMessage("§cVoce saiu do combate!");
		}
	}

	public static final int COMBAT_LIMIT_SECONDS = 15;

	@EventHandler
	public void event(PlayerQuitEvent e) {

		Player player = e.getPlayer();
		if (ON_COMBAT.containsKey(player)) {
			Long time = ON_COMBAT.get(player);
			long now = System.currentTimeMillis();
			if (now - time > (COMBAT_LIMIT_SECONDS * 1000)) {
				ON_COMBAT.remove(player);
			} else {
				player.setHealth(0);
			}
		}
	}

}

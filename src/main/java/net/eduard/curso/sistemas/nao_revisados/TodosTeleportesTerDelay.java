package net.eduard.curso.sistemas.nao_revisados;

import java.util.ArrayList;
import java.util.List;

import net.eduard.curso.Curso;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;



/**
 * Sistema de Delay ao fazer qualquer teleport
 * 
 * @author Eduard
 *
 */
public class TodosTeleportesTerDelay implements Listener {

	public int delaySeconds = 3;

	@EventHandler
	public void event(PlayerTeleportEvent e) {
		Player player = e.getPlayer();
		if (!teleporting.contains(player)) {
//			if (!p.hasPermission("delay.bypass")) {
			e.setCancelled(true);
			teleporting.add(player);
			new BukkitRunnable() {

				@Override
				public void run() {
					player.teleport(e.getTo());
					teleporting.remove(player);
				}
			}.runTaskLater(Curso.getInstance(), delaySeconds * 20);
//			}
		}
	}

	public static List<Player> teleporting = new ArrayList<>();

}

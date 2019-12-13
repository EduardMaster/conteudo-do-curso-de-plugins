package net.eduard.curso.armazenamento;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import net.eduard.api.lib.manager.EventsManager;
import net.eduard.curso.Main;

public class SpawnEvents extends EventsManager {

	@EventHandler
	public void entrarIrSpawn(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		if (Main.getConfigs().contains("spawn"))
			p.teleport(Main.getConfigs().getLocation("spawn"));
	}
	@EventHandler
	public void reiniciarTeleportaProSpawn(PlayerRespawnEvent e) {
//		Player p = e.getPlayer();
		if (Main.getConfigs().contains("spawn"))
			e.setRespawnLocation(Main.getConfigs().getLocation("spawn"));
	}
}

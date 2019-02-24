package net.eduard.curso.spawn;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import net.eduard.api.lib.manager.EventsManager;
import net.eduard.curso.CursoEduard;

public class SpawnEvents extends EventsManager {

	@EventHandler
	public void entrarIrSpawn(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		if (CursoEduard.getConfigs().contains("spawn"))
			p.teleport(CursoEduard.getConfigs().getLocation("spawn"));
	}
	@EventHandler
	public void reiniciarTeleportaProSpawn(PlayerRespawnEvent e) {
//		Player p = e.getPlayer();
		if (CursoEduard.getConfigs().contains("spawn"))
			e.setRespawnLocation(CursoEduard.getConfigs().getLocation("spawn"));
	}
}

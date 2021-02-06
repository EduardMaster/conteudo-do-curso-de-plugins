package net.eduard.curso.projeto.essentials;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import net.eduard.curso.Curso;

public class SpawnEvents implements Listener {

	@EventHandler
	public void entrarIrSpawn(PlayerJoinEvent e) {
		Player player = e.getPlayer();
		if (Curso.getConfigs().contains("spawn"))
			player.teleport(Curso.getConfigs().getLocation("spawn"));
	}
	@EventHandler
	public void reiniciarTeleportaProSpawn(PlayerRespawnEvent e) {

		if (Curso.getConfigs().contains("spawn"))
			e.setRespawnLocation(Curso.getConfigs().getLocation("spawn"));
	}
}

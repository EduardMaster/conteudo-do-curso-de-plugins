package net.eduard.curso.projeto.spawner;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class SpawnerController implements Listener{
 
	@EventHandler
	public void event(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		SpawnerManager m = SpawnerAPI.getManager();
		if (p.getItemInHand() == null)return;
		if (p.getItemInHand().getType() == Material.AIR)return;
		Spawner spawner = m.getSpawner(p.getItemInHand());
		if (spawner == null) {
			return;
		}
		SpawnerInstalado spawnerInstalada =  new SpawnerInstalado();
	}
	
	
}

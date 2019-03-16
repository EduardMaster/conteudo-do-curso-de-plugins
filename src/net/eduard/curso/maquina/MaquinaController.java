package net.eduard.curso.maquina;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import net.eduard.api.lib.Mine;

public class MaquinaController implements Listener {
	@EventHandler
	public void event(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		Maquina maquina2 = MaquinaAPI.getManager().getMaquina(e.getItemInHand());
		if (maquina2 != null) {
			MaquinaInstalada maquina = new MaquinaInstalada();
			maquina.setDono(e.getPlayer().getName());
			maquina.setLevel(1);
			maquina.setMaquina(maquina2);
			MaquinaAPI.getManager().getInstaladas().add(maquina);
			// Mine.remove(p.getInventory(), p.getItemInHand(),1);
		}

	}

	@EventHandler
	public void Interact(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		Combustivel combustivel = MaquinaAPI.getManager().getCombustivel(p.getItemInHand());

		if (combustivel == null)
			return;

		MaquinaInstalada maquina = MaquinaAPI.getManager().getMaquina(e.getClickedBlock().getLocation());

		if (maquina == null)
			return;

		maquina.setFuel(maquina.getFuel() + combustivel.getDuration());
		Mine.remove(p.getInventory(), p.getItemInHand(), 1);

	}

	@EventHandler
	public void Quebrar(BlockBreakEvent e) {
		Player p = e.getPlayer();
		MaquinaInstalada maquina = MaquinaAPI.getManager().getMaquina(e.getBlock().getLocation());
		if (maquina == null)
			return;
		e.setCancelled(true);
		e.getBlock().setType(Material.AIR);
	}

}

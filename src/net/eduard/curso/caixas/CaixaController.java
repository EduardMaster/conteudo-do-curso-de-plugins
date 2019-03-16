package net.eduard.curso.caixas;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import net.eduard.api.lib.Mine;

public class CaixaController implements Listener {

	@EventHandler
	public void event(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		for (Caixa caixa : CaixaAPI.getManager().getCaixas()) {
			if (caixa.getCaixa().isSimilar(p.getItemInHand())) {
				caixa.open(p);
				Mine.remove(p.getInventory(), caixa.getCaixa(), 1);
			}
		}
	} 

	@EventHandler
	public void event(InventoryClickEvent e) {
		if (e.getInventory().getName().startsWith("§aCaixa ")) {
			e.setCancelled(true);
		}
	}
}

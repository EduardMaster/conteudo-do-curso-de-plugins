package net.eduard.curso.eventos;

import java.util.Collection;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import net.eduard.curso.Assunto;
@Assunto(subnivel=4)
public class PegarDropsAutomaticoDeMineracao implements Listener {

	@EventHandler
	public void Quebrar(BlockBreakEvent e) {
//		Player p = e.getPlayer();
//		Collection<ItemStack> drops = e.getBlock().getDrops(p.getItemInHand());
//		for (ItemStack item : drops) {
//			p.getInventory().addItem(item);
//		}
//		e.setCancelled(true);
//		e.getBlock().setType(Material.AIR);

		new BukkitRunnable() {

			@Override
			public void run() {
				Collection<Entity> drops = e.getBlock().getLocation().getWorld()
						.getNearbyEntities(e.getBlock().getLocation(), 1, 1, 1);
				for (Entity entidade : drops) {
					if (entidade instanceof Item) {
						Item drop = (Item) entidade;
						e.getPlayer().getInventory().addItem(drop.getItemStack());
						drop.remove();

					}
				}

			}
		}.runTaskAsynchronously(JavaPlugin.getProvidingPlugin(getClass()));

	}
}

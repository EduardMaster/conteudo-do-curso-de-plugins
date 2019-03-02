package net.eduard.curso.eventos;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import net.eduard.curso.Assunto;

@Assunto(subnivel = 6)
public class JuntarPosts implements Listener {

	@EventHandler
	public void juntarPots(InventoryClickEvent e) {
		if (e.getWhoClicked() instanceof Player) {
			Player p = (Player) e.getWhoClicked();
			if (e.getInventory().equals(e.getWhoClicked().getInventory())) {
				if (e.getCurrentItem() != null) {
					if (e.getClick() == ClickType.DOUBLE_CLICK) {
						ItemStack item = e.getCurrentItem();
						if (item.getType() == Material.POTION) {
							e.setCancelled(true);
							int amount = item.getAmount();
							for (ItemStack itemStack : p.getInventory().getContents()) {
								if (itemStack == null)
									continue;
								if (item.isSimilar(itemStack)) {
									amount += itemStack.getAmount();
									item.setType(Material.AIR);
								}
								if (amount >= 64) {
									break;
								}
							}
							item.setAmount(amount);
						}
					}
				}
			}
		}
	}
}

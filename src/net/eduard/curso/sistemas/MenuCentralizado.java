package net.eduard.curso.sistemas;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class MenuCentralizado implements Listener {
	public MenuCentralizado(JavaPlugin plugin) {
		Bukkit.getPluginManager().registerEvents(this, plugin);
		// TODO Auto-generated constructor stub
	}

	@EventHandler
	public void event(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (e.getItem() == null)
			return;
		if (e.getItem().getType() == Material.APPLE) {
			abrir(p);

		}

	}

	public static boolean isColumn(int index, int colunm) {
		return getColumn(index) == colunm;
	}

	public static int getColumn(int index) {
		if (index < 9) {
			return index + 1;
		}
		return (index % 9) + 1;
	}

	public void abrir(Player p) {
		Inventory inv = Bukkit.createInventory(null, 6 * 9, "Centralizar");

		List<ItemStack> lista = new ArrayList<>();
		for (int i = 0; i < 35; i++) {
			lista.add(new ItemStack(Material.IRON_AXE));
		}

		int index = 10;
		for (ItemStack item : lista) {

			if (isColumn(index, 1)) {
				index++;
				continue;

			}
			if (isColumn(index, 9)) {
				index++;
				continue;

			}
			inv.setItem(index, item);
			;

			index++;

		}

		p.openInventory(inv);

	}

}

package net.eduard.curso.caixas;

import java.util.ArrayList;

import net.eduard.api.lib.modules.Extra;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import net.eduard.api.lib.modules.Mine;
import net.eduard.curso.Main;

public class CaixaMisteriosaBasica implements Listener {

	private static ItemStack caixaBasica = Mine.newItem(Material.CHEST, "§aCaixa básica");

	public CaixaMisteriosaBasica() {

	}
 
	@EventHandler
	public void entrarDarACaixa(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		p.getInventory().addItem(caixaBasica);
	}

	@EventHandler
	public void clicar(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if (p.getItemInHand() == null)
				return;
			if (p.getItemInHand().isSimilar(caixaBasica)) {
				abrir(p);
				Mine.remove(p.getInventory(), p.getItemInHand(), 1);

			}
		}
	}

	@EventHandler
	public void bloquearPegarItemNoMenu(InventoryClickEvent e) {
		if (e.getWhoClicked() instanceof Player) {
//			Player p = (Player) e.getWhoClicked();
			if (e.getInventory().getName().equals("Caixa básico")) {
				e.setCancelled(true);
				
			}
		}
	}

	public static void abrir(Player player) {
		Inventory menu = Bukkit.createInventory(null, 3 * 9, "Caixa básico");
		ArrayList<ItemStack> premios = new ArrayList<>();
		player.openInventory(menu);
		premios.add(new ItemStack(Material.DIAMOND, 64));
		premios.add(new ItemStack(Material.IRON_INGOT, 64));
		premios.add(new ItemStack(Material.STONE, 64));

		premios.add(new ItemStack(Material.DIAMOND_CHESTPLATE));
		premios.add(new ItemStack(Material.DIAMOND_LEGGINGS));
		premios.add(new ItemStack(Material.DIAMOND_BOOTS));
		premios.add(new ItemStack(Material.DIAMOND_HELMET));
		new BukkitRunnable() {
			int contador = 50;

			@Override
			public void run() {
				contador--;
				for (int i = 9 + 1; i < 18 - 2; i++) {
					menu.setItem(i, menu.getItem(i + 1));
				}

				for (int i = 0; i < 9 + 1; i++) {
					menu.setItem(i, Mine.newItem(Material.STAINED_GLASS_PANE, "", 1, Mine.getRandomInt(1, 15)));
				}
				for (int i = 18 - 2; i < menu.getSize(); i++) {
					menu.setItem(i, Mine.newItem(Material.STAINED_GLASS_PANE, "", 1, Mine.getRandomInt(1, 15)));
				}
				ItemStack prize = Extra.getRandom(premios);
				menu.setItem(Mine.getPosition(2, 8), prize);

				if (contador == 0) {
					cancel();
					String itemname = Mine.getName(prize);
					if (itemname.isEmpty()) {
						itemname = Extra.toTitle(prize.getType().name(), " ");
					}
					player.sendMessage("§aVoce recebeu o premio da caixa Básica");
					player.getInventory().addItem(prize);

					player.closeInventory();
				}
			}
		}.runTaskTimerAsynchronously(Main.getInstance(), 7, 7);
	}

}

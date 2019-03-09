package net.eduard.curso.caixas;

import java.util.ArrayList;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import net.eduard.api.lib.Mine;
import net.eduard.api.lib.storage.Storable;
import net.eduard.curso.Main;

public class Caixa implements Storable {

	private String nome;

	private ItemStack caixa;
	private ArrayList<ItemStack> premios = new ArrayList<>();

	public void open(Player player) {
		Inventory menu = Bukkit.createInventory(null, 3 * 9, "§aCaixa " + getNome());

		player.openInventory(menu);
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
				ItemStack prize = Mine.getRandom(getPremios());
				menu.setItem(Mine.getPosition(2, 8), prize);

				if (contador == 0) {
					cancel();
					String itemname = Mine.getName(prize);
					if (itemname.isEmpty()) {
						itemname = Mine.toTitle(prize.getType().name(), " ");
					}
					player.sendMessage("§aVoce recebeu o premio da caixa " + getNome());
					player.getInventory().addItem(prize);

					player.closeInventory();
				}
			}
		}.runTaskTimerAsynchronously(Main.getInstance(), 7, 7);

	}

	@Override
	public Object restore(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void store(Map<String, Object> map, Object object) {
		// TODO Auto-generated method stub

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ItemStack getCaixa() {
		return caixa;
	}

	public void setCaixa(ItemStack caixa) {
		this.caixa = caixa;
	}

	public ArrayList<ItemStack> getPremios() {
		return premios;
	}

	public void setPremios(ArrayList<ItemStack> premios) {
		this.premios = premios;
	}

}

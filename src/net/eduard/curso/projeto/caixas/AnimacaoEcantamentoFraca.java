package net.eduard.curso.projeto.caixas;

import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import net.eduard.api.lib.modules.Mine;
import net.eduard.curso.Main;

public class AnimacaoEcantamentoFraca implements Listener {

	public static void open(Player p,double chance, int nivel, Enchantment enchant,ItemStack item) {

		Inventory menu = Mine.newInventory("�0Encantando...", 3 * 9);
		Mine.remove(p.getInventory(), item,1);
		p.openInventory(menu);
		ItemStack vidro = Mine.newItem(Material.STAINED_GLASS_PANE, "Encantando...");
		
		new BukkitRunnable() {
			int id = 0;
			int estagio = 0;
			boolean alternaSom = false;
			@Override
			public void run() {
				if (alternaSom) {
					p.playSound(p.getLocation()	, Sound.NOTE_PLING, 2f, 1f);
					alternaSom=false;
				}else {
					alternaSom=true;
					p.playSound(p.getLocation()	, Sound.CLICK, 2f, 1f);
				}
				
				menu.setItem(id, vidro);
				if (estagio == 0) {
					if (id < 9) {
						id++;
					}else {
						estagio++;
					}
				}else if (estagio == 1) {
					id+=9;
					menu.setItem(id, vidro);
					if (id==9*5-1) {
						estagio = 3;
					}
				}else if (estagio == 3) {
					id--;
					menu.setItem(id, vidro);
					if (id == 4*9) {
						estagio++;
					}
				}else if (estagio==4) {
					id-=9;
					menu.setItem(id, vidro);
					if (id==0) {
						boolean deucerto = Mine.getChance(chance);
						if (deucerto) {
							vidro.setDurability(DyeColor.GREEN.getData());
							item.addUnsafeEnchantment(enchant, nivel);
							p.playSound(p.getLocation()	, Sound.ANVIL_USE, 2f, 1f);
							
						}else {
							p.playSound(p.getLocation()	, Sound.ZOMBIE_WOODBREAK, 2f, 1f);
							vidro.setDurability(DyeColor.RED.getData());
						}
						
						cancel();
					}
				}
				

			}
		}.runTaskTimerAsynchronously(Main.getInstance(), 6, Mine.getRandomInt(5, 10));
	}

}

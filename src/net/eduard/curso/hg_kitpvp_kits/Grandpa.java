package net.eduard.curso.hg_kitpvp_kits;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;

import net.eduard.api.lib.Mine;
import net.eduard.api.server.kits.KitAbility;

public class Grandpa extends KitAbility{

	public Grandpa() {
		setIcon(Material.STICK, "§fJogue seus inimigos para longe");
		Mine.addEnchant(add(Material.STICK), Enchantment.KNOCKBACK, 2);
	}
}

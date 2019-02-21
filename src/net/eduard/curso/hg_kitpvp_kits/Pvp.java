package net.eduard.curso.hg_kitpvp_kits;

import org.bukkit.Material;

import net.eduard.api.server.kits.KitAbility;


public class Pvp extends KitAbility{
	
	public Pvp() {
		setIcon(Material.LAPIS_BLOCK, "§fGanhe uma espada Melhor");
		add(Material.WOOD_SWORD);
	}

}

package net.eduard.curso.sistemas;

import net.eduard.curso.Sistema;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;

import net.eduard.api.lib.modules.Mine;

public class SistemaCrafts extends Sistema {
	
	public static void craftEspadaLonga() {
		ItemStack espada = Mine.newItem(Material.DIAMOND_SWORD, "§aEspada longa");
		ShapelessRecipe craftSimples = new ShapelessRecipe(espada);
		craftSimples.addIngredient(8, Material.DIAMOND);
		craftSimples.addIngredient(1, Material.STICK);
		Bukkit.addRecipe(craftSimples);
	}
	public static void craftEspadaCurta() {
		ItemStack espada = Mine.newItem(Material.IRON_SWORD, "§aEspada curta");
		ShapedRecipe craftExpecifico = new ShapedRecipe(espada);
		craftExpecifico.shape(
				" A ",
				"AAA",
				" S ");
		craftExpecifico.setIngredient('A', Material.IRON_INGOT);
		craftExpecifico.setIngredient('S', Material.STICK);
		
		Bukkit.addRecipe(craftExpecifico);
	}

	@Override
	public void onEnable() {
		craftEspadaCurta();
		craftEspadaLonga();
	}

	@Override
	public void onDisable() {

	}
}

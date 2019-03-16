package net.eduard.curso.spawner;

import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;

import net.eduard.api.lib.storage.Storable;

public class Spawner implements Storable{
	
	private EntityType tipo;
	private int maxStack;
	private ItemStack icon;

	public EntityType getTipo() {
		return tipo;
	}

	public void setTipo(EntityType tipo) {
		this.tipo = tipo;
	}

	public int getMaxStack() {
		return maxStack;
	}

	public void setMaxStack(int maxStack) {
		this.maxStack = maxStack;
	}

	public ItemStack getIcon() {
		return icon;
	}

	public void setIcon(ItemStack icon) {
		this.icon = icon;
	}

}

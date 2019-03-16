package net.eduard.curso.maquina;

import org.bukkit.inventory.ItemStack;

import net.eduard.api.lib.storage.Storable;

public class Combustivel implements Storable{
	private String name;
	private long duration;
	private double price;
	private ItemStack icon;

	public ItemStack getIcon() {
		return icon;
	}

	public void setIcon(ItemStack icon) {
		this.icon = icon;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

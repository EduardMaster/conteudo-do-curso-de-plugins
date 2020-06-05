package net.eduard.curso.projeto.maquina;

import org.bukkit.inventory.ItemStack;

import net.eduard.api.lib.storage.Storable;

public class Maquina implements Storable {
	private String nome;
	private ItemStack icon;
	private ItemStack drop;
	private int maxStack=1;
	private int maxLevel=1;
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ItemStack getIcon() {
		return icon;
	}

	public void setIcon(ItemStack icon) {
		this.icon = icon;
	}

	public int getMaxStack() {
		return maxStack;
	}

	public void setMaxStack(int maxStack) {
		this.maxStack = maxStack;
	}

	public int getMaxLevel() {
		return maxLevel;
	}

	public void setMaxLevel(int maxLevel) {
		this.maxLevel = maxLevel;
	}

	public ItemStack getDrop() {
		return drop;
	}

	public void setDrop(ItemStack drop) {
		this.drop = drop;
	}

	
}

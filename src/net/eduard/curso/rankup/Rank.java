package net.eduard.curso.rankup;

import net.eduard.api.lib.storage.Storable;
import net.eduard.api.lib.storage.StorageAttributes;
@StorageAttributes(indentificate=true)
public class Rank implements Storable {

	private String name;
	private String prefix;
	private int level;

	public int getPosicao() {
		return level;
	}
	public Rank() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

}

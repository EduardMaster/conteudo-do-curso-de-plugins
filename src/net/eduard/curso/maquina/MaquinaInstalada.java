package net.eduard.curso.maquina;

import org.bukkit.Location;

import net.eduard.api.lib.storage.Storable;
import net.eduard.api.lib.modules.StorageAttributes;

public class MaquinaInstalada implements Storable {

	@StorageAttributes(reference = true)
	private Maquina maquina;
	private String dono;
	private Location location;
	private int stack;
	private int level;
	private long fuel;
	private double drops;

	public Maquina getMaquina() {
		return maquina;
	}

	public void setMaquina(Maquina maquina) {
		this.maquina = maquina;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getDono() {
		return dono;
	}

	public void setDono(String dono) {
		this.dono = dono;
	}

	public int getStack() {
		return stack;
	}

	public void setStack(int stack) {
		this.stack = stack;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public double getDrops() {
		return drops;
	}

	public void setDrops(double drops) {
		this.drops = drops;
	}

	public long getFuel() {
		return fuel;
	}

	public void setFuel(long fuel) {
		this.fuel = fuel;
	}
}

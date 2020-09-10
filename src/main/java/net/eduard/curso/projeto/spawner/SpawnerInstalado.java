package net.eduard.curso.projeto.spawner;

import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;

import net.eduard.api.lib.storage.Storable;

public class SpawnerInstalado implements Storable{
	
	private EntityType tipo;
	private int stack;
	private Location location;
	private ArmorStand holograma;
	public EntityType getTipo() {
		return tipo;
	}
	public void setTipo(EntityType tipo) {
		this.tipo = tipo;
	}
	public int getStack() {
		return stack;
	}
	public void setStack(int stack) {
		this.stack = stack;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public ArmorStand getHolograma() {
		return holograma;
	}
	public void setHolograma(ArmorStand holograma) {
		this.holograma = holograma;
	}



}

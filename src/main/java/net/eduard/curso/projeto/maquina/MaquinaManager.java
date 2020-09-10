package net.eduard.curso.projeto.maquina;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;

import net.eduard.api.lib.storage.Storable;

public class MaquinaManager implements Storable {

	private ArrayList<Maquina> maquinas = new ArrayList<>();
	private ArrayList<Combustivel> combustiveis = new ArrayList<>();
	private ArrayList<MaquinaInstalada> instaladas = new ArrayList<>();
	private Map<Location,MaquinaInstalada> maquinasCache = new HashMap();

	public Maquina getMaquina(String nome) {
		for (Maquina maquina : maquinas) {
			if (maquina.getNome().equalsIgnoreCase(nome)) {
				return maquina;
			}
		}
		return null;
	}

	public MaquinaInstalada getMaquina(Location location) {
		return maquinasCache.get(location);
	}

	public Combustivel getCombustivel(ItemStack icon) {
		for (Combustivel combustivel : combustiveis) {
			if (combustivel.getIcon().isSimilar(icon)) {
				return combustivel;
			}
		}
		return null;
	}

	public Combustivel getCombustivel(String nome) {
		for (Combustivel combustivel : combustiveis) {
			if (combustivel.getName().equalsIgnoreCase(nome)) {
				return combustivel;
			}
		}
		return null;
	}

	
	public ArrayList<Maquina> getMaquinas() {
		return maquinas;
	}

	public void setMaquinas(ArrayList<Maquina> maquinas) {
		this.maquinas = maquinas;
	}

	public ArrayList<MaquinaInstalada> getInstaladas() {
		return instaladas;
	}

	public void setInstaladas(ArrayList<MaquinaInstalada> instaladas) {
		this.instaladas = instaladas;
	}

	public ArrayList<Combustivel> getCombustiveis() {
		return combustiveis;
	}

	public void setCombustiveis(ArrayList<Combustivel> combustiveis) {
		this.combustiveis = combustiveis;
	}

	public Maquina getMaquina(ItemStack icon) {
		for (Maquina maquina : maquinas) {
			if (maquina.getIcon().isSimilar(icon)) {
				return maquina;
			}
		}
		return null;
	}


	public Map<Location, MaquinaInstalada> getMaquinasCache() {
		return maquinasCache;
	}
}

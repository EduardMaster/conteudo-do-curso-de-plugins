package net.eduard.curso.caixas;

import java.util.ArrayList;
import java.util.Map;

import net.eduard.api.lib.storage.Storable;

public class CaixaManager  {

	private ArrayList<Caixa> caixas = new ArrayList<>();

	public Caixa getCaixa(String nome) {
		for (Caixa caixa : caixas) {
			if (caixa.getNome().equalsIgnoreCase(nome)) {
				return caixa;
			}
		}
		return null;
	}

	public ArrayList<Caixa> getCaixas() {
		return caixas;
	}

	public void setCaixas(ArrayList<Caixa> caixas) {
		this.caixas = caixas;
	}

}

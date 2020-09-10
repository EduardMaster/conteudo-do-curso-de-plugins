package net.eduard.curso.projeto.caixas;

import java.util.ArrayList;

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

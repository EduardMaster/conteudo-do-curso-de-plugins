package net.eduard.curso.java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class TutorialArrayList {

	public static List<String> nomes = new LinkedList<>();
	public static List<Integer> numerosDaSorte = new ArrayList<>();

	public static void main(String[] args) {
		nomes.add("Edu");
		nomes.add("Panda");
		nomes.add("Gabriel");
		nomes.add("Tiozinho");
		nomes.add("tiozinho");
		nomes.add("Beta");
		
		numerosDaSorte.add(10);
		numerosDaSorte.add(15);
		numerosDaSorte.add(12);
		numerosDaSorte.add(18);
		numerosDaSorte.add(25);
		numerosDaSorte.add(38);

		if (nomes.contains("Tiozinho")) {
			System.out.println("O jogador Tiozinho esta na lista");
		}
		if (!nomes.contains("tiozinho")) {
			System.out.println("O tiozinho não esta na lista");
		} else {
			System.out.println("O tiozinho esta na lista");
		}
		int id = 1;
		for (String nome : nomes) {
			System.out.println("Nome " + id + " : " + nome);
			id++;
		}
		System.out.println(numerosDaSorte);
		Integer sortearNumero = numerosDaSorte.get(new Random().nextInt(numerosDaSorte.size()));
		System.out.println("Numero aleatorio: "+sortearNumero);
//		forInfinito1();
		whileInfinito1();
	}

	public static void forInfinito1() {
		for (;;) {
			System.out.println("For que nunca acaba");
			
		}
	}

	public static void whileInfinito1() {
		while (true) {
			System.out.println("While que nunca acaba");
		
		}

	}
}

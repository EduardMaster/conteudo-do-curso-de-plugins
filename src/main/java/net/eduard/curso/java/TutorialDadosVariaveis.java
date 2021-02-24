package net.eduard.curso.java;

import net.eduard.curso.java.objetos.Pessoa;

public class TutorialDadosVariaveis {

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
	public static void main(String[] args) {
		int x = 10;
		// tipo
		// nome
		// =
		// valor
		int y = 20;
		int _1x = 10;
		int x1 = 10;
		int idadeDoEdu = 100;
		int idadeDoGustavo = 200;

		int somaDasDuasIdades = idadeDoEdu + idadeDoGustavo;

		System.out.println("idade do Edu: " + idadeDoEdu);

		System.out.println("Idade do edu é 100");

		System.out.println("Soma das duas idades é: " + somaDasDuasIdades);

		double pesoDoEdu = 1000;
		double pesoDoGustavo = 5000;

		double subtracaoDosPesos = pesoDoGustavo - pesoDoEdu;
		System.out.println("O resultado da subtração foi: " + subtracaoDosPesos);

		Pessoa p1 = new Pessoa();
		p1.setNome("Edu");
		p1.idade = 15;
		Pessoa p2 = new Pessoa();
		p2.nome = "Gabriel";
		p2.idade = 16;
		System.out.println(p1.nome);
		System.out.println(p2.nome);
		System.out.println(p1.idade);
		System.out.println(p2.idade);

	}

	
}

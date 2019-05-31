package net.eduard.curso.java;

public class TutorialVariaveis {
	public static class Pessoa {

		String nome = "Sem nome";
		int idade = 1;
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
		p1.nome = "Edu";
		p1.idade = 15;
		Pessoa p2 = new Pessoa();
		p2.nome = "Gabriel";
		p2.idade = 16;
		System.out.println(p1.nome);
		System.out.println(p2.nome);
		System.out.println(p1.idade);
		System.out.println(p2.idade);

	}

	public static void numerosBugados() {
		for (int x = 0; x < 10; x++) {
			for (int y = 0; y < 5; y++) {
				System.out.printf("		%s << %s = %s", x, y, x << y);
				System.out.printf("	%s >> %s = %s", x, y, x >> y);
			}
		}
	}
}

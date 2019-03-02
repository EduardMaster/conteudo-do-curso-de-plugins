package net.eduard.curso.java;

import java.util.ArrayList;
import java.util.Random;

public class NumerosAleatorios {
	public static void main(String[] args) {
		int y = 10;
		y = y - 5;
		System.out.println("valor do y: " + y);
		y--;
		System.out.println("valor do y: " + y);
		--y;
		System.out.println("valor do y: " + y);
		System.out.println("Ligando For");
		for (int x = 10; x > 0; x--) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Valor do X: " + x);
		}
		System.out.println("For finalizado");
		System.out.println("Ligando For");
		for (int z = 1; z < 101; z++) {
			try {
				Thread.sleep(1);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Valor do Z: " + z);

		}

		System.out.println("For finalizado");
		// Tipos primitivos
		// int
		// double
		// float
		// long
		// Tipos normais
		// Integer
		// Double
		// Float
		// Long

		while (true) {
			
			

			ArrayList<Integer> numeros = new ArrayList<>();
			Random gerador = new Random();
			for (int n = 0; n < 10; n++) {

				int numero = gerador.nextInt(100);
				numeros.add(numero);

			}
			System.out.println("Todos Numeros: " + numeros);

			for (int numeroGerado : numeros) {

				System.out.println("Numero gerado: " + numeroGerado);

				if (numeroGerado < 30) {
					System.out.println("Voc§ § muito sortudo");
				}
				if (numeroGerado < 10) {
					System.out.println("Voc§ § muito cagado");
				}
				if (numeroGerado < 5) {
					System.out.println("Sua sorte § de ouro");
				}
				if (numeroGerado == 1) {
					System.out.println("Sua sorte § muito foda!");
				}
			}
			System.out.println("Finalizado for Each (Para cada)");
			
			
			int resultadoDaChecagem = checarNumeros(numeros);
			if (resultadoDaChecagem == -1) {
				System.out.println("Voce § muito azarado n§o sorteou nenhum numero menor que 30");
			} else {
				System.out.println("Voc§ at§ que § sortudo tirou o numero menor que 30: " + resultadoDaChecagem);
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static int checarNumeros(ArrayList<Integer> numeros) {

		for (int numero : numeros) {
			if (numero < 5) {
				return numero;
			}
		}

		return -1;
	}
}

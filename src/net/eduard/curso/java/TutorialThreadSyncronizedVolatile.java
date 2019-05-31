package net.eduard.curso.java;

import java.util.ArrayList;

public class TutorialThreadSyncronizedVolatile {
	/**
	 * Quando tem o volatile a variavel fica sincronizada com todas as threads, se
	 * vc alterar o valor dela usando uma thread, na outra muda o valor na hora
	 */
	public static volatile boolean variavel1 = true;
	/**
	 * Caso nao tiver o 'volatile' a variavel pode acontecer de ter dois valores ao
	 * mesmo tempo
	 */
	public static boolean variavel2 = true;

	public static class ContaPlayer {
		String nome;
		double saldo;

	}

	public static ArrayList<ContaPlayer> contasDosJogadores = new ArrayList<>();

	public static void adicionarSaldo(String nome, double adicional) {
		for (ContaPlayer conta : contasDosJogadores) {
			if (conta.nome == nome) {

				conta.saldo = conta.saldo + adicional;

			}
		}

	}

	public static double getSaldo(String nome) {
		for (ContaPlayer conta : contasDosJogadores) {
			if (conta.nome == nome) {
				return conta.saldo;
			}
		}

		return -1;

	}

	public static Thread t1;
	public static Thread t2;

	public static void main(String[] args) {
		ContaPlayer conta1 = new ContaPlayer();
		conta1.nome = "Eduard";
		conta1.saldo = 0;
		contasDosJogadores.add(conta1);
		t1 = new Thread(new Runnable() {

			@Override
			public void run() {

				for (int i = 0; i < 100; i++) {

					adicionarSaldo("Eduard", 100);
					System.out.println("T1 Saldo: " + getSaldo("Eduard"));

				}
			}
		});
		t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					adicionarSaldo("Eduard", 100);
//					remover(100);
//					System.out.println("T2 Saldo: " + dinheiro);

				}
			}
		});
		long inicio = System.currentTimeMillis();
		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
			long fim = System.currentTimeMillis();

			long dif = fim - inicio;

			System.out.println("Diferenca " + dif);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

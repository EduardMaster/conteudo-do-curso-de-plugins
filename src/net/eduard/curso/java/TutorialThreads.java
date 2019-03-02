package net.eduard.curso.java;

/**
 * Classe mostrando com o método System.currentTimeMillis() funciona, ligando um
 * Timer em Java de 1 segundo
 * 
 * @author Eduard
 *
 */
public class TutorialThreads {

	public static void main(String[] args) throws InterruptedException {

		while (true) {

			System.out.println("Tempo atual: " + System.currentTimeMillis());
			// a cada 1000 equivale a 1 segundo
			Thread.sleep(1000);
		}
	}
}

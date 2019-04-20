package net.eduard.curso.tempo;

public class TempoExemplo {

	public static void main(String[] args) throws InterruptedException {
		while (true) {
			System.out.println("Tempo: " + System.currentTimeMillis());

			Thread.sleep(1000);
		}
	}
}

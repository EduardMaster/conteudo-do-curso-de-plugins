package net.eduard.curso.java;

public class TutorialLambda {
	
	public interface SimplesLamda{
		
		public void run(int numero);
		
		
	}

	public static void main(String[] args) {

		Runnable algoASerFeito = new Runnable() {
			public void run() {
				System.out.println("Algo sendo feito");
			}
		};

		Runnable lamdaSendoExecutada = () -> System.out.println("Estou usando Lambda");
		Runnable lamdaComVariosMetodosInternos = () -> {
			System.out.println("Mensagem 1");
			System.out.println("Mensagem 2");
			System.out.println("Mensagem 3");
		};
		SimplesLamda simples1 = (i) -> System.out.println("O numero colocado foi: "+i);

		algoASerFeito.run();
		lamdaSendoExecutada.run();
		lamdaComVariosMetodosInternos.run();
		simples1.run(200);

	}
}

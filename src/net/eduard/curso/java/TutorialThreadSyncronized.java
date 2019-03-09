package net.eduard.curso.java;

public class TutorialThreadSyncronized {

	private static int dinheiro = 1000;

	public synchronized static void retirar(int quantidade, String t) {
		System.out.println(t + "Dinheiro anterior " + dinheiro);
		System.out.println(t + "Dinheiro que vai retirar " + quantidade);

		if (dinheiro >= quantidade) {
			System.out.println(t + "Conta tem saldo para poder retirar");
			dinheiro -= quantidade;
			System.out.println(t + "Novo valor " + dinheiro + " | saldo retirado " + quantidade);
		} else {
			System.out.println(t + "Nao tem saldo para poder retirar " + quantidade);
		}

	}

	public static void main(String[] args) {

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
//				for (int i = 0; i < 1000; i++) {
				retirar(1000, "T1 ");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			}
		});
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
//				for (int i = 0; i < 1000; i++) {
				retirar(1000, "T2 ");
//					try {
//						Thread.sleep(100);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
			}
		});

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
			System.out.println(dinheiro);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}

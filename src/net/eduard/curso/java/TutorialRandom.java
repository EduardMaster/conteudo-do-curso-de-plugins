package net.eduard.curso.java;

import java.util.Random;

public class TutorialRandom {
	public static void main(String[] args) {
Random r = new Random();
		while (true) {
			long tempo1 = System.nanoTime();
			double nRandom = r.nextDouble();
			
			long tempo2 = System.nanoTime();
			 double n2 = r.nextDouble();

			System.out.println(tempo1+"-"+nRandom+" / "+tempo2 +"-"+ n2);
//			System.out.println("");
			if (nRandom < 0.10) {

//				System.out.println("Voce ganhou o premio");
			}
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}

package net.eduard.curso.java;

public class TutorialThreadVolatile extends Thread{
	
	public  boolean ligado = true;
	
	
	public void run() {
		while(ligado) {
			System.out.println("Running");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void desligar() {
		ligado = false;
	}
	public static void main(String[] args) {
		TutorialThreadVolatile t1 = new TutorialThreadVolatile();
		t1.start();

		t1.desligar();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
				
			}
		});
	}

}

package net.eduard.curso.testes;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class CalculadorDeUsoDeMemoria {
	public static ArrayList<String> cocos = new ArrayList<>();
	public static int contagematual = 0;
	public static void main(String[] args) {
		
		while(true) {
		Runtime r = Runtime.getRuntime();
		long freeMemory = r.freeMemory();
		long totalMemory = r.totalMemory();
		long maxMemory = r.maxMemory();
		
		DecimalFormat dec = new DecimalFormat("#,###.0");
		for (int i = 0; i < 1_000_000; i++) {
			cocos.add("Coco numero "+contagematual);
			contagematual++;
		}
		System.out.println("Free "+dec.format(freeMemory));
		System.out.println("Total "+dec.format(totalMemory));
		System.out.println("Max "+dec.format(maxMemory));
		try {
			
			System.out.println(" ");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
}

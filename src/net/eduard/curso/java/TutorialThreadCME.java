package net.eduard.curso.java;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;

import net.eduard.api.lib.modules.Extra;
import net.eduard.api.lib.modules.Extra.KeyType;

/**
 * Erro {@link ConcurrentModificationException}<br>
 * Usar Iterator não resolve<br>
 * Criar uma copia da Collection é a solução funcional<br>
 * ArrayList<?> listacopia = new ArrayList(listaasercopiada);
 * 
 * @author Eduard
 *
 */
public class TutorialThreadCME {
	public static ArrayList<String> lista = new ArrayList<>();

	public static void main(String[] args) throws InterruptedException {

//		for (int i = 0; i < 1000; i++) {
//			instancia.lista.add("numero "+i);
//		}
		Thread1 t1 = new Thread1();
		t1.start();
		Thread2 t2 = new Thread2();
		t2.start();

	}

}

class Thread2 extends Thread {
	@Override
	public void run() {
		while (true) {
			String texto = Extra.newKey(KeyType.LETTER, 16);
//			System.out.println("Remove o texto " + texto);
			TutorialThreadCME.lista.remove(0);

			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class Thread1 extends Thread {

	@Override
	public void run() {
		while (true) {
			int id = 0;

			System.out.println("Lendo lista");
//			for (String linha : new ArrayList<>(CurrentModificationDebug.getInstancia().lista)) {
////				System.out.println("Linha " + id++ + " " + linha);
//
//			}
			System.out.println("Mostrando linhas " + TutorialThreadCME.lista.size());

//			for (String linha :CurrentModificationDebug.getInstancia().lista) {
//				System.out.println("Linha " + id++ + " " + linha);

//			}

			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
	}
}

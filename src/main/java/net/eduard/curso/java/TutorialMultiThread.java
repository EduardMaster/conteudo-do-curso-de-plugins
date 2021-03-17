package net.eduard.curso.java;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;

/**
 * Erro {@link ConcurrentModificationException}<br>
 * Usar Iterator não resolve<br>
 * Criar uma copia da Collection é a solução funcional<br>
 * ArrayList<?> listacopia = new ArrayList(listaasercopiada);
 *
 * @author Eduard
 */
public class TutorialMultiThread {
    public static ArrayList<String> lista = new ArrayList<>();
    public static Object lock = new Object();
    public static void mudar(boolean tirar) {
        synchronized ((lock)) {
            if (tirar) {
                if (!lista.isEmpty()) {
                    TutorialMultiThread.lista.remove(0);
                }
            } else TutorialMultiThread.lista.add("MongoDBTeste");
        }
    }

    public static  void mudar2(boolean tirar) {
        if (tirar) {
            if (!lista.isEmpty()) {
                TutorialMultiThread.lista.remove(0);
            }
        } else TutorialMultiThread.lista.add("MongoDBTeste");
    }
    public static void main(String[] args) throws InterruptedException {
        ThreadExemplo1 t1 = new ThreadExemplo1();
        ThreadExemplo2 t2 = new ThreadExemplo2();
        t1.start();
        t2.start();
    }
    static class ThreadExemplo2 extends Thread {
        @Override
        public void run() {
            while (true) {
                System.out.println("Remove primeiro texto");
                TutorialMultiThread.mudar2(true);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

   static class ThreadExemplo1 extends Thread {
        @Override
        public void run() {
            while (true) {
                TutorialMultiThread.mudar2(false);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}


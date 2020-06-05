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
public class TutorialThreadCME {
    public static ArrayList<String> lista = new ArrayList<>();
    public static Object lock = new Object();

    public static void mudar(boolean tirar) {
        synchronized ((lock)) {
            if (tirar) {
                if (!lista.isEmpty()) {
                    TutorialThreadCME.lista.remove(0);
                }
            } else TutorialThreadCME.lista.add("MongoDBTeste");
        }
    }

    public static  void mudar2(boolean tirar) {

        if (tirar) {
            if (!lista.isEmpty()) {
                TutorialThreadCME.lista.remove(0);
            }
        } else TutorialThreadCME.lista.add("MongoDBTeste");

    }

    public static void main(String[] args) throws InterruptedException {


        Thread1 t1 = new Thread1();

        Thread2 t2 = new Thread2();

        t1.start();
        t2.start();
    }

    static class Thread2 extends Thread {
        @Override
        public void run() {
            while (true) {

                System.out.println("Remove primeiro texto");
                TutorialThreadCME.mudar2(true);

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

   static class Thread1 extends Thread {

        @Override
        public void run() {
            while (true) {

                TutorialThreadCME.mudar2(false);



                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        }
    }

}


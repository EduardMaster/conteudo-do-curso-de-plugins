package net.eduard.curso.java;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TutorialDadosQueue {

    public static ConcurrentLinkedQueue<Runnable> listaDeAfazeres = new ConcurrentLinkedQueue<>();

    public static void adding(){
        for (int i = 1; i <= 100; i++) {
            final int valor = i;
            listaDeAfazeres.add(()-> {
                System.out.println("Doing something with a number "+ valor );
            });
        }


    }
    public static void removing(){
        if (listaDeAfazeres.isEmpty())return;
        for (int i = 0; i < 20; i++) {
            Runnable r = listaDeAfazeres.poll();
            r.run();
        }
    }

    public static void main(String[] args) {

        adding();
        while(true) {
            removing();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (listaDeAfazeres.isEmpty()){
                adding();
            }

        }
    }

}

package net.eduard.curso.java;

/**
 * Aumentou o Uso da CPU de 75% depois se mantem no 25%
 */
public class LimiteCPU {
    public static void a( ){

    }
    public static void main(String[] args) {
        while(true){
            for (long i = 0; i < Long.MAX_VALUE; i++) {
                    a();

            }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

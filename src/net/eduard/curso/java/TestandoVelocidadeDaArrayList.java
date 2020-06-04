package net.eduard.curso.java;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Vector;

public class TestandoVelocidadeDaArrayList {

    public static void main(String[] args) {
        ArrayList<MaquinaFake> lista = new ArrayList();
        int maximo = 1500000;
        Random r = new Random();
        MaquinaFake ultimaMaquina = null;
        System.out.println("Iniciando inserção de dados "+maximo);
        long tempoInicial = System.currentTimeMillis();
        for (int id = 0;id<maximo;id++){
            FakeLocation local = new FakeLocation();
            local.world = "world";
            local.x = r.nextInt(maximo);
            local.y = r.nextInt(maximo);
            local.z = r.nextInt(maximo);

            MaquinaFake maquina = new MaquinaFake();
            maquina.setDono("DonoAleatorio"+r.nextInt(maximo));
            maquina.local = local;
            lista.add(maquina);
            ultimaMaquina = maquina;
        }
        long tempoFinal = System.currentTimeMillis();
        long dif = tempoFinal - tempoInicial;

        System.out.println("Inserção terminada diferença em millis: "+dif);
        tempoInicial = System.currentTimeMillis();
        int vezesPassado = 0;
        int hashDoUltimo = ultimaMaquina.local.hashCode();
        for (MaquinaFake maquina  : lista){
            vezesPassado++;
            if (maquina.local.hashCode() == hashDoUltimo){
                System.out.println("Maquina encontrada em "+vezesPassado);
                tempoFinal = System.currentTimeMillis();
                dif = tempoFinal - tempoInicial;
                System.out.println("Tempo pesquisando ultimo dado da lista usando HashCode "+dif);
                break;
            }
        }
        tempoInicial = System.currentTimeMillis();
         vezesPassado = 0;

        for (MaquinaFake maquina  : lista){
            vezesPassado++;
            if (maquina.local.equals( ultimaMaquina.local)){
                System.out.println("Maquina encontrada em "+vezesPassado);
                tempoFinal = System.currentTimeMillis();
                dif = tempoFinal - tempoInicial;
                System.out.println("Tempo pesquisando ultimo dado da lista usando equals "+dif);
                break;
            }
        }
    }
    public static class FakeLocation{
        String world;
        int x;
        int y;
        int z;

        @Override
        public boolean equals(Object o) {

            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            FakeLocation that = (FakeLocation) o;
            return x == that.x &&
                    y == that.y &&
                    z == that.z &&
                    Objects.equals(world, that.world);
        }

        @Override
        public int hashCode() {
            return Objects.hash(world, x, y, z);
        }
    }
    public static class MaquinaFake{
        private String dono;
        private FakeLocation local;
        public String getDono() {
            return dono;
        }

        public void setDono(String dono) {
            this.dono = dono;
        }


    }



}

package net.eduard.curso.java;

import net.eduard.curso.java.objetos.FakeLocation;
import net.eduard.curso.java.objetos.FakeMaquina;

import java.util.HashMap;
import java.util.Random;

public class TesteVelocidadeHashMap {

    public static void main(String[] args) {
        HashMap<FakeLocation, FakeMaquina> mapa = new HashMap();
        int maximo = 150000;
        Random r = new Random();
        FakeMaquina ultimaMaquina = null;
        System.out.println("Iniciando inserção de dados "+maximo);
        long tempoInicial = System.currentTimeMillis();
        for (int id = 0;id<maximo;id++){
            FakeLocation local = new FakeLocation();
            local.setWorld("world");
            local.setX(r.nextInt(maximo));
            local.setY(r.nextInt(maximo));
            local.setZ(r.nextInt(maximo));

            FakeMaquina maquina = new FakeMaquina();
            maquina.setDono("DonoAleatorio"+r.nextInt(maximo));
            maquina.setLocal(local);
            mapa.put(local,maquina);

            if (r.nextDouble() < 0.05) {
                ultimaMaquina = maquina;
            }
        }
        if (ultimaMaquina == null) {
            ultimaMaquina = mapa.values().iterator().next();
        }
        long tempoFinal = System.currentTimeMillis();
        long dif = tempoFinal - tempoInicial;

        System.out.println("Inserção terminada diferença em millis: "+dif);
        tempoInicial = System.currentTimeMillis();
        FakeMaquina encontrado = mapa.get(ultimaMaquina.getLocal());
        System.out.println("Maquina é igual? "+(encontrado == ultimaMaquina));
        tempoFinal = System.currentTimeMillis();
        dif = tempoFinal - tempoInicial;
        System.out.println("Tempo pesquisando ultimo dado da mapa usando HashCode "+dif);

        tempoInicial = System.currentTimeMillis();
       int  vezesPassado = 0;

        for (FakeMaquina maquina  : mapa.values()){
            vezesPassado++;
            if (maquina.getLocal().equals( ultimaMaquina.getLocal())){
                System.out.println("Maquina encontrada em "+vezesPassado);
                tempoFinal = System.currentTimeMillis();
                dif = tempoFinal - tempoInicial;
                System.out.println("Tempo pesquisando ultimo dado da mapa usando equals "+dif);
                break;
            }
        }
    }




}

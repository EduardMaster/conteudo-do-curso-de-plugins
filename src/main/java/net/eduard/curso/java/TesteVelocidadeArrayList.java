package net.eduard.curso.java;


import net.eduard.curso.java.TutorialDadosHashMap.*;

import java.util.ArrayList;
import java.util.Random;

public class TesteVelocidadeArrayList {

    public static void main(String[] args) {
        ArrayList<FakeMaquina> lista = new ArrayList();
        int maximo = 1500000;
        Random r = new Random();
        FakeMaquina ultimaMaquina = null;
        System.out.println("Iniciando inserção de dados " + maximo);
        long tempoInicial = System.currentTimeMillis();
        for (int id = 0; id < maximo; id++) {
            FakeLocation local = new FakeLocation();
            local.setWorld( "world");
            local.setX( r.nextInt(maximo));
            local.setY(r.nextInt(maximo));
            local.setZ(r.nextInt(maximo));
            local.hashCode();
            FakeMaquina maquina = new FakeMaquina();
            maquina.setDono("DonoAleatorio" + r.nextInt(maximo));
            maquina.setLocal( local);
            lista.add(maquina);
            ultimaMaquina = maquina;
        }
        long tempoFinal = System.currentTimeMillis();
        long dif = tempoFinal - tempoInicial;
        System.out.println("Inserção terminada diferença em millis: " + dif);
        tempoInicial = System.currentTimeMillis();
        int vezesPassado = 0;
        int hashDoUltimo = ultimaMaquina.getLocal().hashCode();
        for (FakeMaquina maquina : lista) {
            vezesPassado++;
            if (maquina.getLocal().hashCode() == hashDoUltimo) {
                System.out.println("Maquina encontrada em " + vezesPassado);
                tempoFinal = System.currentTimeMillis();
                dif = tempoFinal - tempoInicial;
                System.out.println("Tempo pesquisando ultimo dado da lista usando HashCode " + dif);
                break;
            }
        }
        tempoInicial = System.currentTimeMillis();
        vezesPassado = 0;
        for (FakeMaquina maquina : lista) {
            vezesPassado++;
            if (maquina.getLocal().equals(ultimaMaquina.getLocal())) {
                System.out.println("Maquina encontrada em " + vezesPassado);
                tempoFinal = System.currentTimeMillis();
                dif = tempoFinal - tempoInicial;
                System.out.println("Tempo pesquisando ultimo dado da lista usando equals " + dif);
                break;
            }
        }
        tempoInicial = System.currentTimeMillis();
        vezesPassado = 0;
        for (int id = 0; id < lista.size(); id++) {
            FakeMaquina maquina = lista.get(id);
            vezesPassado++;
            if (maquina.getLocal().hashCode() == hashDoUltimo ) {
                System.out.println("Maquina encontrada em " + vezesPassado);
                tempoFinal = System.currentTimeMillis();
                dif = tempoFinal - tempoInicial;
                System.out.println("Tempo pesquisando ultimo dado da lista usando equals " + dif);
                break;
            }
        }
    }
    static Object[][] teste = new Object[24][24];


}

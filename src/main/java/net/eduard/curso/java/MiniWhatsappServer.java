package net.eduard.curso.java;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MiniWhatsappServer {
    public static Scanner scanner;
    public static ServerSocket server;
    public static ArrayList<Socket> conexoes = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        scanner = new Scanner(System.in);
        LendoThread lendo = new LendoThread();
        lendo.start();
        server = new ServerSocket(24000);
        System.out.println("Serivodr ligado na porta 240000");

    /*
        try {
            System.out.write("Teste\n".getBytes());
            System.out.write((byte) 'A');
            System.out.write((byte) '\n');
        } catch (IOException e) {
            e.printStackTrace();
        }

     */
        while(true){
            System.out.println("Esperando uma conexão entrar!");
            Socket conexao = server.accept();
            System.out.println("Conexão aceita: "+conexao.getInetAddress().getHostAddress()
            +":"+ conexao.getPort());
            conexoes.add(conexao);
            System.out.println("Conexão registrada");
            /*
            try {
                Thread.sleep(10000);
                System.out.println("Passou se 10s");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            */
        }

    }
        static class LendoThread extends  Thread{

            @Override
            public void run() {

                while(true){

                    System.out.println("Escreva novamente: ");
                    String mensagem = scanner.nextLine();
                    System.out.printf("\n[Servidor]: %s\n", mensagem);
                    System.out.println("Enviando mensagem para os clientes");
                    List<Socket> conexoesFechada = new ArrayList<>();
                    for (Socket conexao  : conexoes){
                        try {
                            if (conexao.isClosed()){
                                System.out.println("Pulando conexao pois ela foi fechada");
                                conexoesFechada.add(conexao);
                                continue;
                            }
                            conexao.getOutputStream()
                                    .write((mensagem+"\n").getBytes(StandardCharsets.UTF_8));

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }


}

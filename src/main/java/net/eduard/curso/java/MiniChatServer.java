package net.eduard.curso.java;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class MiniChatServer {

    static class WhatAppClient {
        private Socket conexao;
        private Scanner scanner;

        public String getClientDescribe() {
            return conexao.getInetAddress().getHostAddress()
                    + ":" + conexao.getPort();
        }


        public WhatAppClient(Socket conexao) throws IOException {
            this.conexao = conexao;
            scanner = new Scanner(conexao.getInputStream());
            System.out.println("Conexão aceita: " + getClientDescribe());
        }

        public void sendMensagem(String message) throws IOException {
            conexao.getOutputStream()
                    .write((message + "\n").getBytes(StandardCharsets.UTF_8));
        }

        public boolean needRemove() {
            if (conexao.isClosed() || !conexao.isConnected()) {
                System.out.println("Pulando conexao pois ela foi fechada");
                return true;
            }

            return false;

        }

    }

    public static Scanner scanner;
    public static ServerSocket server;
    public static ArrayList<WhatAppClient> conexoes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        scanner = new Scanner(System.in);
        ReadingServerMessages lendo = new ReadingServerMessages();
        lendo.start();
        server = new ServerSocket(24000);
        System.out.println("Serivodr ligado na porta 24000");

        while (true) {
            System.out.println("Esperando uma conexão entrar!");
            Socket conexao = server.accept();
            WhatAppClient client = new WhatAppClient(conexao);
            conexoes.add(client);
            new ReadingClientMessages(client).start();
            System.out.println("Conexão registrada");

        }

    }

    static class ReadingClientMessages extends Thread {

        private WhatAppClient client;

        private ReadingClientMessages(WhatAppClient client) {
            this.client = client;
        }

        @Override
        public void run() {
            while (true) {
                System.out.println("Esperando mensagem do Client: " + client.getClientDescribe());

                String mensagem = client.scanner.nextLine();
                System.out.printf("["+client.getClientDescribe() + "]: %s\n", mensagem);
/*
                for (WhatAppClient whats : conexoes) {
                    if (whats.equals(client)) continue;
                    try {
                        whats.sendMensagem(mensagem);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

 */
            }
        }
    }


    static class ReadingServerMessages extends Thread {

        @Override
        public void run() {
            while (true) {
                System.out.println("Escreva novamente: ");
                String mensagem = scanner.nextLine();
                System.out.printf("[Servidor]: %s\n", mensagem);
                System.out.println("Enviando mensagem para os clientes");
                // List<Socket> conexoesFechada = new ArrayList<>();
                for (WhatAppClient whats : conexoes) {
                    try {
                        whats.sendMensagem(mensagem);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


}

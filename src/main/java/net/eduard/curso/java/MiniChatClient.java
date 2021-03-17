package net.eduard.curso.java;

import java.io.IOException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class MiniChatClient {
    public static Scanner scanner;
    public static Scanner scanner2;
    public static Socket client;

    public static void main(String[] args) throws IOException {
        scanner = new Scanner(System.in);
        LendoThread lendo = new LendoThread();
        lendo.start();
        System.out.println("Entrando em conexão com servidor");
        client = new Socket("localhost", 24000);
        scanner2 = new Scanner(client.getInputStream());
        System.out.println("Conexão estabelecida.");
        while (true) {
            try {
                String mensagemVindaDoServidor = scanner2.nextLine();
                if (!mensagemVindaDoServidor.isEmpty()) {
                    System.out.println("[Servidor] " + mensagemVindaDoServidor);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    static class LendoThread extends Thread {

        @Override
        public void run() {
            while (true) {
                System.out.println("Escreva novamente: ");
                String mensagem = scanner.nextLine()+"\n";
                try {
                    client.getOutputStream().write(mensagem
                            .getBytes(StandardCharsets.UTF_8));
                    System.out.printf("\n[Voce]: %s\n", mensagem);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }


}

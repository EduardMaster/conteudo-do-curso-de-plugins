package net.eduard.curso.java;

import java.io.IOException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class MiniWhatsappClient {
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
        System.out.println("Conexão estabelecida com: "+client.getInetAddress().getHostAddress()
        +":"+ client.getPort());
        while(true){
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
    public static String lerMensagem() {
        try {
            if (client.getInputStream().available() != -1) {

                byte[] bytes = new byte[client.getInputStream().available()];

                return new String(bytes, StandardCharsets.UTF_8) ;
            }

        } catch (IOException e) {

            e.printStackTrace();
        }
        return "";
    }

        static class LendoThread extends  Thread{

            @Override
            public void run() {

                while(true){

                    System.out.println("Escreva novamente: ");
                    String mensagem = scanner.nextLine();
                    try {
                        client.getOutputStream().write(mensagem.getBytes("UTF-8"));
                        System.out.printf("\n[Voce]: %s\n", mensagem);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }
        }


}

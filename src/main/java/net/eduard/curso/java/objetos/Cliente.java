package net.eduard.curso.java.objetos;

import net.eduard.api.lib.modules.Extra;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

public class Cliente {

    private String ip;
    private int porta;
    private Socket cliente;

    public Cliente(int porta) {
        setIp("localhost");
        setPorta(porta);
        try {
            setCliente(new Socket(ip, porta));
        } catch (UnknownHostException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    public Cliente() {

    }

    public void mandarMensagem(String mensagem) {
        System.out.println("Cliente mandando mensagem para o servidor: " + mensagem);
        try {
            cliente.getOutputStream().write(mensagem.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public String lerMensagem() {
        try {
            return Extra.readSTR(cliente.getInputStream(), StandardCharsets.UTF_8);
        } catch (IOException e) {

            e.printStackTrace();
        }
        return null;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPorta() {
        return porta;
    }

    public void setPorta(int porta) {
        this.porta = porta;
    }

    public Socket getCliente() {
        return cliente;
    }

    public void setCliente(Socket cliente) {
        this.cliente = cliente;
    }

}

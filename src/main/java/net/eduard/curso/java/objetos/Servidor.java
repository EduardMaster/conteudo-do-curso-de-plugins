package net.eduard.curso.java.objetos;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Servidor extends Thread {

    private int porta;
    private ServerSocket servidor;
    private List<Cliente> clientes = new ArrayList<>();

    public Socket aceitarConexao() throws IOException {
        System.out.println("Esperando por uma conexão");
        Socket conexao = getServidor().accept();
        System.out.println("Conexão feita");
        return conexao;

    }

    public Servidor(int porta) {
        setPorta(porta);
        try {
            setServidor(new ServerSocket(porta));
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        try {
            Socket socket = aceitarConexao();
            Cliente clienteNovo = new Cliente();
            clienteNovo.setCliente(socket);
            clienteNovo.setIp(socket.getInetAddress().getHostName());
            clienteNovo.setPorta(socket.getPort());
            clientes.add(clienteNovo);
            System.out.println("Cliente adicionado");
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public int getPorta() {
        return porta;
    }

    public void setPorta(int porta) {
        this.porta = porta;
    }

    public ServerSocket getServidor() {
        return servidor;
    }

    public void setServidor(ServerSocket servidor) {
        this.servidor = servidor;
    }

    public void mandarMensagem(String mensagem) {

        System.out.println("Mensagem sendo enviada para os clientes: " + mensagem);
        for (Cliente cliente : clientes) {
            try {
                cliente.getCliente().getOutputStream().write(mensagem.getBytes("UTF-8"));
            } catch (IOException e) {

                e.printStackTrace();
            }
        }


    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
}

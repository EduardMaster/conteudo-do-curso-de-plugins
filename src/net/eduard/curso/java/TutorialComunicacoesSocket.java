package net.eduard.curso.java;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import net.eduard.api.lib.modules.Extra;
/**
 * Sistema de comunicações entre servidor e cliente
 * @author Eduard
 *
 */
public class TutorialComunicacoesSocket {

	public static class Servidor extends Thread {

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
			
		System.out.println("Mensagem sendo enviada para os clientes: "+mensagem);
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

	public static class Cliente {

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
			System.out.println("Cliente mandando mensagem para o servidor: "+mensagem);
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
	public static void main(String[] args) throws IOException {
		
		Servidor servidor = new Servidor(12345);
		servidor.start();
		Cliente cliente = new Cliente(12345);
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
		cliente.mandarMensagem("oi");
		servidor.mandarMensagem("tudo bem");
		String lerMensagem = cliente.lerMensagem();
		System.out.println("Mensagem enviada para o cliente: "+lerMensagem);
		System.out.println("Servidor ligado");
		
	}

	
}

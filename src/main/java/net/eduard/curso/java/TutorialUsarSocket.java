package net.eduard.curso.java;

import java.io.IOException;

import net.eduard.curso.java.objetos.Cliente;
import net.eduard.curso.java.objetos.Servidor;

/**
 * Sistema de comunicações entre servidor e cliente
 * @author Eduard
 *
 */
public class TutorialUsarSocket {

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

package net.eduard.curso.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class EscrevendoELendoBytes {

	public static void main(String[] args) throws Exception {
		// 255 255 255 255 255 255
		// char
		File arquivo = new File("E:/arquivo.txt");
//		arquivo.createNewFile();
		FileOutputStream writer = new FileOutputStream(arquivo);
		writer.write("Olá tudo bem com você".getBytes());
		System.out.println("Escrevendo ");
		FileInputStream lendo = new FileInputStream(arquivo);
		byte[] b = new byte[2];
		lendo.read(b);
		System.out.println(new String(b));
	}
}

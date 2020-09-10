package net.eduard.curso.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.bukkit.configuration.file.YamlConfiguration;

public class TutorialComunicacoesArquivos {

	public static void main(String[] args) throws Exception {
		
		File arquivo = new File("E:/arquivo.txt");

		FileOutputStream writer = new FileOutputStream(arquivo);
		writer.write("Olá tudo bem com você".getBytes("UTF-8"));
		writer.close();
		System.out.println("Escrevendo ");
		FileInputStream lendo = new FileInputStream(arquivo);
		byte[] byteArray = new byte[lendo.available()];
		lendo.read(byteArray);
		lendo.close();
		System.out.println(new String(byteArray,"UTF-8"));
		File file = new File("E:/arquivo2.yml");
		File file2 = new File("E:/arquivo3.yml");
		YamlConfiguration config = new YamlConfiguration();
		config.set("Edu", "§2Boládo");

		FileOutputStream escrever = new FileOutputStream(file);
		
		escrever.write(config.saveToString().getBytes(StandardCharsets.ISO_8859_1));
		escrever.close();
		
		FileInputStream lendo3 = new FileInputStream(file);
		String textoLido = readSTR(lendo3, StandardCharsets.ISO_8859_1);
		FileOutputStream escrever2 = new FileOutputStream(file2);
		escrever2.write(textoLido.getBytes(StandardCharsets.UTF_8));
		escrever2.close();
	}
	
/**
 * Metodo que serve para ler um String aparatir de uma Stream
 * @param stream Stream
 * @param charset Conjunto de caracteres
 * @return A string lida
 * @throws IOException
 */
	public static String readSTR(InputStream stream, Charset charset) throws IOException {
		byte[] bytes = new byte[stream.available()];
		stream.read(bytes);
		return new String(bytes, charset);
	}
}

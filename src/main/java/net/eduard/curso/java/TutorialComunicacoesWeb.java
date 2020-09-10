package net.eduard.curso.java;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map.Entry;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class TutorialComunicacoesWeb {


	public static String sendPost(String link, String parametros) throws Exception {
		return sendRequest(link, parametros, "POST");
	}

	public static String sendGet(String link, String parametros) throws Exception {
		return sendRequest(link, parametros, "GET");
	}

	public static String sendRequest(String link, String parametros, String tipo) throws Exception {
		URL url = new URL(link);

		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setReadTimeout(5000);
		con.setRequestProperty("Content-Type", "application/json; charset=UTF-8;");
		con.setDoOutput(true);
		con.setDoInput(true);
		con.setRequestMethod(tipo);

		// String json = "teste={'teste':2}";
		OutputStream os = con.getOutputStream();
		os.write(parametros.getBytes("UTF-8"));
		os.close();

		InputStream is = con.getInputStream();
		DataInputStream dis = new DataInputStream(is);

		byte[] bytesLidos = new byte[dis.available()];
		dis.readFully(bytesLidos);
		String retorno = new String(bytesLidos, "UTF-8");

		return retorno;
	}

	public static void main(String[] args) {

		System.out.println("Abrindo console");
		try {

			URL link = new URL("http://localhost/pagina2.php");

			HttpURLConnection con = (HttpURLConnection) link.openConnection();
			con.setReadTimeout(5000);
			con.setRequestProperty("Content-Type", "application/json; charset=UTF-8;");
			con.setDoOutput(true);
			con.setDoInput(true);
			con.setRequestMethod("POST");

			String json = "teste={'teste':2}";
			OutputStream os = con.getOutputStream();
			os.write(json.getBytes("UTF-8"));
			os.close();

			InputStream is = con.getInputStream();
			DataInputStream dis = new DataInputStream(is);

			byte[] bytesLidos = new byte[dis.available()];
			dis.readFully(bytesLidos);
			String texto = new String(bytesLidos, "UTF-8");
			System.out.println(texto);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

	public static void main5(String[] args) {
		try {
			URL link = new URL("http://localhost/pegarPermissoes?token=123");
			try {
				URLConnection conexaoFeita = link.openConnection();
				conexaoFeita.setUseCaches(false);
				InputStream entrada = conexaoFeita.getInputStream();
				System.out.println("Deu certo");
				DataInputStream lendo = new DataInputStream(entrada);
				System.out.println(lendo.available());

				byte[] todosBytesLidos = new byte[lendo.available()];
				lendo.readFully(todosBytesLidos);
//				String teste = lendo.readLine();
				System.out.println("" + Charset.defaultCharset().name());
				String string = new String(todosBytesLidos, Charset.forName("UTF-8"));
				System.out.println(string);
				JsonParser ae = new JsonParser();
				JsonElement elemento = ae.parse(string);

				if (elemento.isJsonObject()) {
					System.out.println("� um mapa");
					JsonObject mapa = elemento.getAsJsonObject();
					for (Entry<String, JsonElement> item : mapa.entrySet()) {
						System.out.println(item.getKey() + " : " + item.getValue() + "");

					}
				}
//				Gson g = new Gson();
				// String a = lendo.readUTF();
//			
//				Scanner scan = new Scanner(lendo);
//				while (scan.hasNext()) {
//					String line = scan.nextLine();
//					System.out.println(line);
//				}
//				scan.close();

				System.out.println("Deu certo");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static HashMap<String, String> getMensagemBySite(String token) {

		try {

			URL link = new URL("http://localhost/pegarMesagem.php?token=" + token);

			HttpURLConnection con = (HttpURLConnection) link.openConnection();
			con.setReadTimeout(5000);
			con.setRequestProperty("Content-Type", "application/json; charset=UTF-8;");
			con.setDoOutput(true);
			con.setDoInput(true);
			con.setRequestMethod("POST");

//		String json = "{\"mensagem1\":\"teste\"}";
//		OutputStream os = con.getOutputStream();
//		os.write(json.getBytes("UTF-8"));
//		os.close();

			InputStream is = con.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			byte[] bytesLidos = new byte[dis.available()];
			dis.readFully(bytesLidos);
			String texto = new String(bytesLidos, "UTF-8");
			Gson g = new Gson();
			@SuppressWarnings("unchecked")
			HashMap<String, String> mensagems = g.fromJson(texto, HashMap.class);

			return mensagems;

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}

	public static String getNewToken() {

		try {

			URL link = new URL("http://localhost/gerarToken.php");
			HttpURLConnection con = (HttpURLConnection) link.openConnection();
			con.setReadTimeout(5000);
			con.setRequestProperty("Content-Type", "application/json; charset=UTF-8;");
			con.setDoOutput(true);
			con.setDoInput(true);
			con.setRequestMethod("POST");

			InputStream is = con.getInputStream();
			DataInputStream dis = new DataInputStream(is);

			byte[] bytesLidos = new byte[dis.available()];
			dis.readFully(bytesLidos);
			String texto = new String(bytesLidos, "UTF-8");

			return texto;

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}
}

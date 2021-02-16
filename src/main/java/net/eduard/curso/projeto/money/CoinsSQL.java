package net.eduard.curso.projeto.money;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import net.eduard.api.lib.database.DBManager;

public class CoinsSQL {
	private static Connection conexao;
	private static HashMap<String, Double> cacheamento = new HashMap<>();
	public static void abrirConexao() {
		try {

			conexao = DriverManager.
					getConnection("jdbc:sqlite:F:/Tudo/net.eduard.curso.projeto.money.MongoDBTeste/cash.db");

			Statement stmt = conexao.createStatement();
			stmt.execute("CREATE TABLE IF NOT EXISTS cash (nickname TEXT, amount INTEGER);");
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void criarContaNova(String nome) {
		//db.insert("dinheiro", nome, 0);

	}

	public static double pegarSaldo(String nome) {

		//return db.getDouble("dinheiro", "saldo", "nome = ?", nome);

		return 0;
	}

	public static boolean temContaCriada(String nome) {
		//return db.contains("dinheiro", "nome = ?", nome);
		return false;
	}

	public static void alterarSaldoConta(String nome, double novosaldo) {

	}

	public static void adicionarSaldoConta(String nome, double saldoAdicionado) {

	}

	public static void removerSaldoConta(String nome, double saldoRemovido) {

	}



	public static void criarTabelaContas() {
		//db.createTable("dinheiro", " nome VARCHAR(16) NOT NULL , saldo DOUBLE NOT NULL");

	}

}

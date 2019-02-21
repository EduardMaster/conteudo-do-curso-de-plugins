package net.eduard.curso.economia;

import java.util.HashMap;

import net.eduard.api.lib.manager.DBManager;

public class CoinsSQL {

	private static HashMap<String, Double> cacheamento = new HashMap<>();
	private static DBManager db = new DBManager("root", "", "localhost");

	public static void criarContaNova(String nome) {
		db.insert("dinheiro", nome, 0);

	}

	public static double pegarSaldo(String nome) {
		return db.getDouble("dinheiro", "saldo", "nome = ?", nome);
	}

	public static boolean temContaCriada(String nome) {
		return db.contains("dinheiro", "nome = ?", nome);
	}

	public static void alterarSaldoConta(String nome, double novosaldo) {
		db.change("dinheiro", "saldo = ?", "nome = ?", novosaldo, nome);
	}

	public static void adicionarSaldoConta(String nome, double saldoAdicionado) {
		db.change("dinheiro", "saldo = saldo + ?", "nome = ?", saldoAdicionado, nome);
	}

	public static void removerSaldoConta(String nome, double saldoRemovido) {
		db.change("dinheiro", "saldo = saldo - ?", "nome = ?", saldoRemovido, nome);
	}

	public static void abrirConexao() {
		db.openConnection();
	}

	public static void criarTabelaContas() {
		db.createTable("dinheiro", " nome VARCHAR(16) NOT NULL , saldo DOUBLE NOT NULL");
	}

	public static HashMap<String, Double> getCacheamento() {
		return cacheamento;
	}

	public static void setCacheamento(HashMap<String, Double> cacheamento) {
		CoinsSQL.cacheamento = cacheamento;
	}
}

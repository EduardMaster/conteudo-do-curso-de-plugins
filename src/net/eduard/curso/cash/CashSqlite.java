package net.eduard.curso.cash;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.bukkit.entity.Player;

import net.eduard.api.lib.BukkitConfig;

public class CashSqlite {
	private static Connection con;

	public static void abrirConexaoSQLite() {
		try {
			try {
				Class.forName("org.sqlite.JDBC");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			con = DriverManager.getConnection("jdbc:sqlite:F:/Tudo/Teste/cash.db");

			Statement stmt = con.createStatement();
			stmt.execute("CREATE TABLE IF NOT EXISTS cash (nickname TEXT, amount INTEGER);");
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
 
	public static void fecharSQLiteConexao() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void setCash(double cash, String nome) {
		/*
			
			*/
		if (hasAccount(nome)) {
			edit(nome, (int) cash);
		} else {
			try {
				Statement stmt = con.createStatement();
				stmt.execute("INSERT OR REPLACE INTO cash (nickname, amount) VALUES ('" + nome + "', '" + cash + "');");
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static boolean hasAccount(String nome) {
		boolean has = false;
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM cash where nickname = '" + nome + "';");

			if (rs.next()) {
				has = true;
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return has;
	}

	public static void edit(String nome, int valor) {
		try {
			Statement stmt = con.createStatement();
			stmt.execute("update cash set amount = '" + valor + "' where nickname = '" + nome + "';");
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static int getCash(String nome) {
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM cash where nickname = '" + nome + "';");
			int amount = 1;
			if (rs.next()) {
				amount = rs.getInt("amount");
			}
			rs.close();
			stmt.close();
			return amount;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;

	}

	public static HashMap<String, Double> contas = new HashMap<>();

	public static BukkitConfig config = new BukkitConfig("contas.yml");

	public static void addCash(Player player, double quantidade) {
		setCash(player, getCash(player) + quantidade);

	}

	public static void removeCash(Player player, double quantidade) {
		setCash(player, getCash(player) - quantidade);

	}

	public static void setCash(Player player, double quantidade) {
		contas.put(player.getName().toLowerCase(), quantidade);
		config.set(player.getName().toLowerCase(), quantidade);

	}

	public static List<Entry<String, Double>> gerarMoneyTop() {
		Stream<Entry<String, Double>> streamOrdenada = contas.entrySet().stream()
				.sorted(Comparator.comparing((Entry::getValue)));
		Stream<Entry<String, Double>> streamLimitada = streamOrdenada.limit(10);
//		streamLimitada.forEach(entrada -> {
//			String chave = entrada.getKey();
//			Double valor = entrada.getValue();
//			
//			
//			
//		});
//		streamLimitada.sorted(Collections.reverseOrder());
		return streamLimitada.collect(Collectors.toList());
	}

	public static void mostrarTopSQL(Player player) {
//		String query = "SELECT * FROM banco odery by quantia desc;";

	}

	public static void mostrarTop(Player player) {
		DecimalFormat formatador = new DecimalFormat("#.###,");
		List<Entry<String, Double>> top = gerarMoneyTop();
		int posicao = 1;
		for (Entry<String, Double> entrada : top) {
			String chave = entrada.getKey();
			Double valor = entrada.getValue();
			player.sendMessage("§a" + posicao + "§ " + chave + " R$ §2" + formatador.format(valor));
			posicao++;
			if (posicao >= 10) {
				break;
			}
		}
	}

	public static double getCash(Player player) {
		return contas.getOrDefault(player.getName().toLowerCase(), 0D);
	}

	public static double getCashConfig(Player player) {
		return config.getConfig().getDouble(player.getName().toLowerCase(), 0D);
	}

}

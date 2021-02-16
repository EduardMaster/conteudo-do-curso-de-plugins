package net.eduard.curso.projeto.cash;

import net.eduard.api.lib.config.BukkitConfigs;
import org.bukkit.entity.Player;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CashManager {
    private final Map<String, Double> contas = new HashMap<>();
    private BukkitConfigs config = new BukkitConfigs("cash.yml");
    private final CashSQL sql = new CashSQL();
    private boolean useSQL = false;
    public void reloadFromConfig(){

    }

    public Map<String, Double> getContas() {
        return contas;
    }

    public BukkitConfigs getConfig() {
        return config;
    }

    public CashSQL getSql() {
        return sql;
    }

    public void reloadFromSQL() {
        try {
            ResultSet rs = sql.getConnection().prepareStatement("SELECT * FROM " + sql.getTableName()).executeQuery();
            while (rs.next()) {
                contas.put(rs.getString("nickname")
                        ,rs.getDouble("amount"));
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void addCash(String player, double cash) {
        if (useSQL) {
            sql.addCash(player, cash);
        }
        contas.put(player.toLowerCase(), getCash(player) + cash);
    }

    public double getCash(String player) {
        return contas.getOrDefault(player.toLowerCase(), 0D);
    }

    public double getCashSQL(String player) {
        return sql.getCash(player);
    }

    public void setCash(String player, double cash) {
        if (useSQL) {
            sql.setCash(player, cash);
        }
    }

    public void mostrarTop(Player player) {
        DecimalFormat formatador = new DecimalFormat("#.###,");
        List<Map.Entry<String, Double>> top = gerarMoneyTop();
        int posicao = 1;
        for (Map.Entry<String, Double> entrada : top) {
            String chave = entrada.getKey();
            Double valor = entrada.getValue();
            player.sendMessage("§a" + posicao + "§ " + chave + " R$ §2" + formatador.format(valor));
            posicao++;
            if (posicao >= 10) {
                break;
            }
        }
    }

    public List<Map.Entry<String, Double>> gerarMoneyTop() {
        Stream<Map.Entry<String, Double>> streamOrdenada = contas.entrySet().stream()
                .sorted(Comparator.comparing((Map.Entry::getValue)));
        Stream<Map.Entry<String, Double>> streamLimitada = streamOrdenada.limit(10);

        return streamLimitada.collect(Collectors.toList());
    }

    public boolean isUseSQL() {
        return useSQL;
    }

    public void setUseSQL(boolean useSQL) {
        this.useSQL = useSQL;
    }


}

package net.eduard.curso.projeto.cash;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import net.eduard.curso.SQLConnection;

public class CashSQL extends SQLConnection {

    private String tableName = "cash_table";
     // varchar(50)
    public void criarTabela() {
        try {

            Statement stmt = getConnection().createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS "+getTableName() +
                    " (nickname TEXT, amount INTEGER);");
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void setCash(String player, double cash) {

        if (hasAccount(player)) {
            edit(player, (int) cash);
        } else {
            try {

                PreparedStatement stmt = getConnection().
                        prepareStatement("INSERT OR REPLACE INTO "+getTableName()+" (nickname, amount) VALUES (?,?);");
                stmt.setString(1,player);
                stmt.setDouble(2,cash);

                stmt.execute();
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean hasAccount(String player) {
        boolean haveAccount = false;
        try {
            PreparedStatement stmt = getConnection().
                    prepareStatement("SELECT * FROM "+getTableName()+" where nickname = ?;");
            stmt.setString(1, player);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                haveAccount = true;
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return haveAccount;
    }

    public void edit(String player, double valor) {
        try {
            PreparedStatement stmt = getConnection()
                    .prepareStatement(
                            "update "+getTableName()+" set amount = ? where nickname = ?;");

            stmt.setDouble(1, valor);
            stmt.setString(2, player);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public double getCash(String player) {
        try {
            PreparedStatement stmt = getConnection().
                    prepareStatement("SELECT * FROM "+getTableName()+" where nickname = ?;");
            stmt.setString(1, player);
            ResultSet rs = stmt.executeQuery();
            double amount = 1;
            if (rs.next()) {
                amount = rs.getDouble("amount");
            }
            rs.close();
            stmt.close();
            return amount;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;

    }

    public void addCash(String player, double quantidade) {
        try {
            PreparedStatement stmt = getConnection()
                    .prepareStatement(
                            "update "+getTableName()+" set amount = amount + ? where nickname = ?;");

            stmt.setDouble(1, quantidade);
            stmt.setString(2, player);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void removeCash(String player, double quantidade) {
        setCash(player, getCash(player) - quantidade);

    }

    public String getTableName() {
        return tableName;
    }
}

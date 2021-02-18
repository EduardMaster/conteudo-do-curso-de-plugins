package net.eduard.curso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnection {
    private String usuario = "root";
    private String senha = "";
    private int porta = 3306;
    private String database = "minecraft";
    private String host = "localhost";
    private String sqlitePath = "C:/sqlite/database.db";
    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void abrirMySQL(){
        try {
            try {
                Class.forName( "com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            connection =
                    DriverManager.getConnection(
                            "jdbc:mysql://%host:%port/%database?autoReconnect=true"
                    .replace("%host", host)
                    .replace("%port",""+porta)
                    .replace("%database" , database)
                    );


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void abrirSQLite(){
        try {
            try {
                Class.forName("org.sqlite.JDBC");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            connection =
                    DriverManager.getConnection(
                            "jdbc:sqlite:"+ sqlitePath);


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void fechar(){
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getPorta() {
        return porta;
    }

    public void setPorta(int porta) {
        this.porta = porta;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getSqlitePath() {
        return sqlitePath;
    }

    public void setSqlitePath(String sqlitePath) {
        this.sqlitePath = sqlitePath;
    }
}

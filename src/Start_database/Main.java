package Start_database;

import ClientManager.DAO.BDConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void TableClient(){
        BDConnection connection = new BDConnection();
        Statement stmt = null;

        Connection c = connection.getconnection();
        try {
            stmt = c.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            String sql = "CREATE TABLE Client " +
                    "(code INT PRIMARY KEY     NOT NULL," +
                    " name           TEXT    NOT NULL, " +
                    " spent            REAL," +
                    " balance          REAL," +
                    " winnings        REAL);";
            stmt.executeUpdate(sql);
        }catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
    public static void TableClientF(){
        BDConnection connection = new BDConnection();
        Statement stmt = null;
        Connection c = connection.getconnection();
        try {
            stmt = c.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            String sql = null;
            sql = "CREATE TABLE ClientF " +
                    "(code INT ," +
                    "FOREIGN KEY (code) REFERENCES Client(code)," +
                    " cpf           TEXT    NOT NULL);";
            stmt.executeUpdate(sql);
        }catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
    public static void TableClientJ(){
        BDConnection connection = new BDConnection();
        Statement stmt = null;
        Connection c = connection.getconnection();
        try {
            stmt = c.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            String sql = null;
            sql = "CREATE TABLE ClientJ " +
                    "(code INT ," +
                    "FOREIGN KEY (code) REFERENCES Client(code)," +
                    " cnpj           TEXT    NOT NULL);";
            stmt.executeUpdate(sql);
        }catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        TableClient();
        TableClientF();
        TableClientJ();



    }
}

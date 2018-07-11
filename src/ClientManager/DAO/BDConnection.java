package ClientManager.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDConnection {
    Connection connection = null;
    public BDConnection(){
        try {
            String driver = "org.postgresql.Driver";
            String user = "postgres";
            String senha = "postgres";
            String url = "jdbc:postgresql://localhost:5432/tds";
            try {
                Class.forName(driver);
                Connection con = null;
                connection = (Connection) DriverManager.getConnection(url, user, senha);
                System.out.println("Conexão realizada com Sucesso!");
            } catch (ClassNotFoundException ex) {
                System.err.print(ex.getMessage());
            } catch (SQLException e) {
                System.err.print(e.getMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

    }

    public Connection getconnection(){
        return this.connection;
    }

}

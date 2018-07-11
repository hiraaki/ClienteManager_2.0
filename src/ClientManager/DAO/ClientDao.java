package ClientManager.DAO;

import ClientManager.Models.Client;
import ClientManager.Models.ClientF;
import ClientManager.Models.ClientJ;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ClientDao {
    ArrayList<ClientF> ClientesF;
    ArrayList<ClientJ> ClientesJ;
    BDConnection bd;

    public ClientDao(){

        this.ClientesJ=new ArrayList<>();
        this.ClientesF=new ArrayList<>();
    }
    public void saveClientF(ClientF f){
        f.setCode(f.hashCode());
        System.out.println(f.getCpf()+f.getName()+f.getSpent());
        System.out.println("s");
        try {
            BDConnection bd= new BDConnection();
            String sql = "INSERT INTO client(code,name,spent,balance,winnings) "
                    + "VALUES ("+f.getCode()+","
                    +"'"+f.getName()+"'"+","
                    +f.getSpent()+","
                    +f.getBalance()+", "
                    +f.getWinnings()+");"+
                    "INSERT INTO clientf(code, cpf)" +
                    "VALUES("+f.getCode()+","
                    +"'"+f.getCpf()+"')";
            PreparedStatement stmt = bd.getconnection().prepareStatement(sql);
            stmt.executeUpdate();
            System.out.println("Opened database successfully");


        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.ClientesF.add(f);

    }
    public void saveClientJ(ClientJ J){
        System.out.println("a");
        bd = new BDConnection();
        J.setCode(J.hashCode());
        try {
            System.out.println("d");
            String sql = "INSERT INTO client (code,name,spent,balance,winnings) "
                    + "VALUES ("+J.getCode()+","
                    +"'"+J.getName()+"'"+","
                    +J.getSpent()+","
                    +J.getBalance()+", "
                    +J.getWinnings()+");"+"INSERT INTO clientj(code, cnpj)" +
                    "VALUES("+J.getCode()+","
                    +"'"+J.getCnpj()+"')";
            PreparedStatement stmt = bd.getconnection().prepareStatement(sql);
            stmt.executeUpdate();
            System.out.println("Opened database successfully");

        } catch (SQLException e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        this.ClientesJ.add(J);
    }

    public void deleteClientF(ClientF F){
        F.setCode(F.hashCode());
        bd = new BDConnection();
        try {
            Statement stmt = bd.getconnection().createStatement();
            String sql = "DELETE from clientf where code ="+F.getCode()+";" +
                    "DELETE from client where code ="+F.getCode()+";";

            stmt.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.ClientesF.remove(F);
    }

    public void deleteClientJ(ClientJ J){
        J.setCode(J.hashCode());
        bd = new BDConnection();
        try {
            Statement stmt = bd.getconnection().createStatement();
            String sql = "DELETE from clientj where code ="+J.getCode()+";" +
                    "DELETE from client where code ="+J.getCode()+";";

            stmt.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.ClientesJ.remove(J);
    }

    public Object getClient(int hash){
        Object response=null;
        bd = new BDConnection();
        try {
            Statement stmt = bd.getconnection().createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM Client where code="+hash+";" );
            if(rs.next()) {
                Client client = new Client(rs.getString("name"));
                client.setCode(rs.getInt("code"));
                client.setSpent(rs.getFloat("spent"));
                client.setBalance(rs.getFloat("balance"));
                client.setWinnings(rs.getFloat("winnings"));

                rs = stmt.executeQuery("SELECT * FROM clientj where code=" + hash + ";");
                if (rs.next()) {
                    ClientJ clientJ = new ClientJ(client.getName(),rs.getString("cnpj"));
                    clientJ.setCode(client.getCode());
                    clientJ.setBalance(client.getBalance());
                    clientJ.setSpent(client.getWinnings());
                    response = clientJ;
                } else {
                    rs = stmt.executeQuery("SELECT * FROM clientf where code=" + hash + ";");
                    rs.next();
                    ClientF clientF = new ClientF(client.getName(),rs.getString("cpf"));
                    clientF.setCode(client.getCode());
                    clientF.setBalance(client.getBalance());
                    clientF.setSpent(client.getWinnings());
                    response = clientF;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return response;
    }
}

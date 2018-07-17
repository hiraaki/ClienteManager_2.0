package ClientManager.DAO;

import ClientManager.Models.Client;
import ClientManager.Models.ClientF;
import ClientManager.Models.ClientJ;
import ClientManager.Models.Invoice;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**Classe que manipula e atualiza os  gastos, debitos e ganhos.
 *
 */
public class InvoiceDao {

    BDConnection bd;

    public InvoiceDao() {
        bd = new BDConnection();
    }

    public void addInvoice(Client client, Invoice invoice){
//        invoice.setClientID(client.getCode());
        invoice.setClient(client);
        invoice.getClient().addSpent(invoice.getSpent());
        invoice.setTotalcost(invoice.getSpent()+((invoice.getSpent()*invoice.getWinningPercentage())/100));
        invoice.getClient().addWinnings(invoice.getTotalcost());
        client.updateBalance();
        try {
            BDConnection bd= new BDConnection();
            String sql = "INSERT INTO invoice(clientid, description, spent, winningpercentage, totalcost) "
                    + "VALUES ("+client.getCode()+","
                    +"'"+invoice.getDescription()+"'"+","
                    +invoice.getSpent()+","
                    +invoice.getWinningPercentage()+","
                    +invoice.getTotalcost()+");";
            System.out.println(sql);
            PreparedStatement stmt = bd.getconnection().prepareStatement(sql);
            stmt.executeUpdate();
            System.out.println("Opened database successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        client.getServices().add(invoice);
        ClientDao c = new ClientDao();
        c.updateClientValues(client);
    }

    public void delete(Invoice in){
        System.out.println(in.getClient().getSpent());
        in.getClient().setWinnings(in.getClient().getWinnings()-in.getTotalcost());

        in.getClient().setSpent(in.getClient().getSpent()-in.getSpent());
        System.out.println("TotalDaFatura:"+in.getTotalcost());
        System.out.println("GastoDaFatura"+in.getSpent());

        System.out.println("ganho"+in.getClient().getWinnings());
        System.out.println("gasto"+in.getClient().getSpent());
        in.getClient().updateBalance();
        System.out.println("balaco"+in.getClient().getBalance());

        ClientDao cl= new ClientDao();
        cl.updateClientValues(in.getClient());

        bd = new BDConnection();
        try {
            Statement stmt = bd.getconnection().createStatement();
            String sql = "DELETE FROM invoice where id ="+in.getId()+";";
            System.out.println(sql);
            stmt.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<Invoice> getInvoice(int clienteCode){
        ArrayList<Invoice> invoices = new ArrayList<>();
        try {
            Statement stmt = bd.getconnection().createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM invoice where clientid="+clienteCode+";" );
            ClientDao cli = new ClientDao();
            while(rs.next()) {
                Invoice invoice = new Invoice(
                        rs.getString("description"),
                        new Client(),
                        rs.getFloat("spent"),
                        rs.getFloat("winningpercentage")
                );
                invoice.setId(rs.getInt("id"));
                Client c =cli.getClient(rs.getInt("clientid"));
                System.out.println(c.getSpent());
                System.out.println(c.getName());
                invoice.setClient(c);
                invoices.add(invoice);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return invoices;
    }

}

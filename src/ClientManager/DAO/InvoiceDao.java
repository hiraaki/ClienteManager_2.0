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
        invoice.setClientID(client.getCode());
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
        in.getClient().addWinnings(in.getTotalcost()*-1);
        in.getClient().addSpent(in.getSpent()*-1);
        in.getClient().updateBalance();
        ClientDao cl= new ClientDao();
        cl.updateClientValues(in.getClient());

        bd = new BDConnection();
        try {
            Statement stmt = bd.getconnection().createStatement();
            String sql = "DELETE from invoice where code ="+in.getId()+";";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Invoice> getInvoice(int codigoCliente){
        ArrayList<Invoice> invoices = new ArrayList<>();
        try {
            Statement stmt = bd.getconnection().createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM invoice where code="+codigoCliente+";" );
            ClientDao cli = new ClientDao();
            while(rs.next()) {
                Invoice invoice = new Invoice(
                        rs.getInt("clientid"),
                        rs.getString("description"),
                        (Client) cli.getClient(rs.getInt("clientid")),
                        rs.getFloat("spent"),
                        rs.getFloat("winningpercentage")
                );
                invoices.add(invoice);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return invoices;
    }

}

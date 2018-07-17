package ClientManager.Controls;

import ClientManager.DAO.InvoiceDao;
import ClientManager.Models.Client;
import ClientManager.Models.Invoice;

import java.util.ArrayList;

public class InvoiceDAOController {
    InvoiceDao InvoiceData;

    public InvoiceDAOController() {
        InvoiceData = new InvoiceDao();
    }

    public void registerInvoice(String description, Client client, float spent, float winningPercentage ){
        InvoiceData.addInvoice(client,new Invoice( description, client, spent, winningPercentage ));
    }
    public void deleteInvoice(Invoice in){
        InvoiceData.delete(in);
    }
    public ArrayList<Invoice> getInvoices(int clientCode){
        return InvoiceData.getInvoice(clientCode);
    }
}

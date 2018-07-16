package ClientManager.Controls;

import ClientManager.DAO.InvoiceDao;
import ClientManager.Models.Client;
import ClientManager.Models.Invoice;

public class InvoiceDAOController {
    InvoiceDao InvoiceData;

    public InvoiceDAOController() {
        InvoiceData = new InvoiceDao();
    }

    public void registerInvoice(int clientID, String description, Client client, float spent, float winningPercentage ){
        InvoiceData.addInvoice(client,new Invoice(clientID, description, client, spent, winningPercentage ));
    }
    public void deleteInvoice(Invoice in){
        InvoiceData.delete(in);
    }
}

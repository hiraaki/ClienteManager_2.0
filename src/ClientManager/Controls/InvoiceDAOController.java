package ClientManager.Controls;

import ClientManager.DAO.InvoiceDao;
import ClientManager.Models.Client;
import ClientManager.Models.Invoice;

public class InvoiceDAOController {
    InvoiceDao InvoiceData;

    public InvoiceDAOController(InvoiceDao invoiceData) {
        InvoiceData = invoiceData;
    }

    public void registerInvoiceF(int clientID, String description, Client client, float spent, float winningPercentage ){
        InvoiceData.addInvoice(client,new Invoice(clientID, description, client, spent, winningPercentage ));
    }
    public void registerInvoice(Invoice in){
        InvoiceData.delete(in);
    }
}

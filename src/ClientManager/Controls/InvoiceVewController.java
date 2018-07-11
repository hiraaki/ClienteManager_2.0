package ClientManager.Controls;

import ClientManager.DAO.SaveInvoiceData;
import ClientManager.Models.Client;
import ClientManager.Models.Invoice;

public class InvoiceVewController {
    SaveInvoiceData InvoiceData;

    public InvoiceVewController(SaveInvoiceData invoiceData) {
        InvoiceData = invoiceData;
    }

    public void registerInvoiceF(int clientID, String description, Client client, float spent, float winningPercentage ){
        InvoiceData.addInvoice(client,new Invoice(clientID, description, client, spent, winningPercentage ));
    }
    public void registerInvoice(Invoice in){
        InvoiceData.delete(in);
    }
}

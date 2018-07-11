package ClientManager.DAO;

import ClientManager.Models.Client;
import ClientManager.Models.ClientF;
import ClientManager.Models.ClientJ;
import ClientManager.Models.Invoice;

import java.util.ArrayList;

/**Classe que manipula e atualiza os  gastos, debitos e ganhos.
 *
 */
public class SaveInvoiceData {

    ArrayList<Invoice> invoices;
    ClientDao client;

    public SaveInvoiceData(ClientDao client) {
        this.invoices = new ArrayList<>();
        this.client = client;
    }

    public void addInvoice(Client client, Invoice invoice){
        invoice.setClientID(client.getCode());
        invoice.setClient(client);
        invoice.getClient().addSpent(invoice.getSpent());
        invoice.setTotalcost(invoice.getSpent()+((invoice.getSpent()*invoice.getWinningPercentage())/100));
        invoice.getClient().addWinnings(invoice.getTotalcost());
        client.updateBalance();
        this.invoices.add(invoice);
        client.getServices().add(invoice);
    }

    public void delete(Invoice in){
        int n = in.getClient().getCode();
        for(ClientF cli: client.ClientesF){
            if(cli.getCode()==n){
                cli.getServices().remove(in);
            }
        }
        for(ClientJ cli: client.ClientesJ){
            if(cli.getCode()==n){
                cli.getServices().remove(in);
            }
        }
    }

}

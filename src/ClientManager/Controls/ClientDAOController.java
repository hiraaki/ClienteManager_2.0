package ClientManager.Controls;

import ClientManager.DAO.ClientDao;
import ClientManager.Models.Client;
import ClientManager.Models.ClientF;
import ClientManager.Models.ClientJ;

import java.util.ArrayList;

/**
 * Essa é a classe de comunicação entre a view e o DAO e futuramente fará a validação de entrada
 */
public class ClientDAOController {
    ClientDao data;

    public ClientDAOController() {
        this.data = new ClientDao();
    }

    public void registerClientJ(String _name, String cnpj,String description){
        data.saveClientJ(new ClientJ(_name,cnpj,description));
        System.out.println("s");
    }
    public void  DeleteClientJ(String _name, String cnpj){
        data.deleteClientJ(new ClientJ(_name,cnpj));

    }
    public void registerClientF(String _name, String cpf,String description){
        data.saveClientF(new ClientF(_name,cpf,description));
        System.out.println("s");
    }
    public void  DeleteClientF(String _name, String cpf){
        data.deleteClientF(new ClientF(_name,cpf));
    }
    public ArrayList<Client> getClients(String name){
        return data.getClients(name);
    }
}

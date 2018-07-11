package ClientManager.Controls;

import ClientManager.DAO.ClientDao;
import ClientManager.Models.ClientF;
import ClientManager.Models.ClientJ;

/**
 * Essa é a classe de comunicação entre a view e o DAO e futuramente fará a validação de entrada
 */
public class ClientViewController {
    ClientDao data;

    public ClientViewController(ClientDao data) {
        this.data = data;
    }
    public void registerClientJ(String _name, String cnpj){
        data.saveClientJ(new ClientJ(_name,cnpj));
        System.out.println("s");
    }
    public void  DeleteClientJ(String _name, String cnpj){
        data.deleteClientJ(new ClientJ(_name,cnpj));
    }
    public void registerClientF(String _name, String cpf){
        data.saveClientF(new ClientF(_name,cpf));
        System.out.println("s");
    }
    public void  DeleteClientF(String _name, String cpf){
        data.deleteClientF(new ClientF(_name,cpf));
    }

}

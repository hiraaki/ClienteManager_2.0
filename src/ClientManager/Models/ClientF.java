package ClientManager.Models;

import java.util.Objects;

/**Classe que estende a classe cliente
 *
 */
public class ClientF  extends  Client{
    private String cpf;
    /**
     * Construtor da classe cliente pessoa física
     * @param name Armazena nome do cliente
     * @param cpf Armazena o cpf do cliente
     */
    public ClientF(String name, String cpf,String description) {
        super(name,description);
        this.cpf = cpf;
    }
    public ClientF(String name, String cpf) {
        super(name,"");
        this.cpf = cpf;
    }


    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        cpf = cpf;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==null) return false;
        if (obj==this||obj.getClass()!=this.getClass()) return false;
        ClientF F = (ClientF) obj;
        return F.hashCode() == this.hashCode();
    }

    @Override
    public int hashCode(){
        return Objects.hashCode(this.getName()+ this.cpf);
    }
}

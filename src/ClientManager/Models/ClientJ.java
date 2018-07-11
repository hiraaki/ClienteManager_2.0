package ClientManager.Models;

import java.util.Objects;

/**
 * Classe que estende a classe cliente
 */
public class ClientJ extends Client {
    private String cnpj;

    /**
     * Esse é o construtor da classe cliente pessoa Jurídica
     * @param name armazena o nome da empresa
     * @param cnpj armazena o cnpj da empresa
     */
    public ClientJ(String name, String cnpj) {
        super(name);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        cnpj = cnpj;
    }
    @Override
    public int hashCode(){
        return Objects.hashCode(this.getName()+ this.cnpj);
    }
}

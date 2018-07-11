package ClientManager.Models;

/**
 * Classe para manipulação de gastos e ganhos
 */
public class Invoice {
    private int id;
    private int clientID;
    private String description;
    private Client client;
    private float spent;
    private float winningPercentage;
    private float totalcost;

    /**
     * Esse é o construtor da classe Invoice a qual contrrola a entrada e saida de  gastos
     * @param clientID código do cliente
     * @param description descrição do serviço prestado
     * @param client cliente
     * @param spent valor gasto no serviço
     * @param winningPercentage porcentagem de ganho em cima de serviço prestado
     */
    public Invoice(int clientID, String description, Client client, float spent, float winningPercentage) {
        this.clientID = clientID;
        this.description = description;
        this.client = client;
        this.spent = spent;
        this.winningPercentage=winningPercentage;
        this.totalcost =this. winningPercentage-this.spent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public float getSpent() {
        return spent;
    }

    public void setSpent(float spent) {
        this.spent = spent;
    }

    public float getWinningPercentage() {
        return winningPercentage;
    }

    public void setWinningPercentage(float winningPercentage) {
        this.winningPercentage = winningPercentage;
    }

    public float getTotalcost() {
        return totalcost;
    }

    public void setTotalcost(float totalcost) {
        this.totalcost = totalcost;
    }
}

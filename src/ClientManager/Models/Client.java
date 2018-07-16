package ClientManager.Models;

import java.util.ArrayList;

/**Classe generica para cliente, onde
 *
 */
public class Client {
    private int code;
    private String name;
    private float spent;
    private float balance;
    private  float winnings;
    private String description;
    private ArrayList<Invoice> services;

    /**
     * Esse é o construtor da classe Client
     *
     * @param name é o nome do cliente
     *
     */
    public Client(String name) {
        this.spent=0;
        this.balance=0;
        this.winnings=0;
        this.name = name;
        this.description="";
        this.services=new ArrayList<>();
    }

    public Client() {
    }

    public void setSpent(float spent) {
        this.spent = spent;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public void setWinnings(float winnings) {
        this.winnings = winnings;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getSpent() {
        return spent;
    }

    public void addSpent(float spent) {
        this.spent += spent;
    }

    public float getBalance() {
        return balance;
    }

    public void updateBalance() {

        this.balance = this.spent-winnings;

    }

    public float getWinnings() {
        return winnings;
    }

    public void addWinnings(float winnings) {
        this.winnings = winnings;
    }

    public String getdescription() {
        return description;
    }

    public void setdescription(String description) {
        this.description = description;
    }

    public ArrayList<Invoice> getServices() {
        return services;
    }

    public void setServices(ArrayList<Invoice> services) {
        this.services = services;
    }
}

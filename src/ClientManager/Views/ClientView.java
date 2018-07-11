package ClientManager.Views;

import ClientManager.Controls.ClientViewController;

import java.util.Scanner;

public class ClientView {
    ClientViewController controller;
    public ClientView(ClientViewController controller) {
        this.controller = controller;
    }

    public static Scanner entrada = new Scanner(System.in);
    public void addClient(){
        System.out.print("Qual o tipo de cliente:\n\t(1)Pessoa Fisica\n\t(2) Pessoa Juridica\n\t(0) Sair\nOpção escolhida:");
        int op = entrada.nextInt();
        while ((op>2)&&(op<0)){
            System.out.println("opção Invalida");
        }

        if(op==1){
            System.out.println("Digite o Nome do Cliente:");
             String name;
             name= entrada.nextLine();
            System.out.println("Digite o CPF do Cliente:");
            String cpf= entrada.nextLine();
            controller.registerClientF(name,cpf);
        }else if(op==2){
            System.out.println("Digite o nome da Empresa:");
            String name;
            name= entrada.nextLine();
            System.out.println("Digite o CNPJ do Cliente:");
            String cnpj= entrada.nextLine();
            controller.registerClientJ(name,cnpj);
        }

    }
    public void delClient(){
        System.out.print("Qual o tipo de cliente:\n\t(1)Pessoa Fisica\n\t(2):Pessoa Juridica\nOpção escolhida:");
        int op = entrada.nextInt();
        if(op==1){
            System.out.println("Digite o Nome do Cliente:");
            String name;
            name= entrada.nextLine();
            System.out.println("Digite o CPF do Cliente:");
            String cpf= entrada.nextLine();
            controller.DeleteClientF(name,cpf);
        }else if(op==2){
            System.out.println("Digite o nome da Empresa:");
            String name;
            name= entrada.nextLine();
            System.out.println("Digite o CNPJ do Cliente:");
            String cnpj= entrada.nextLine();
            controller.DeleteClientJ(name,cnpj);
        }
    }
    public void totalSpent(){

    }
    public void Debit(){

    }
}

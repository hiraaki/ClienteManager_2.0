package ClientManager;

import ClientManager.Controls.ClientDAOController;
import ClientManager.DAO.ClientDao;
import ClientManager.Models.ClientF;
import ClientManager.Models.ClientJ;
import java.util.Objects;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Views/sample.fxml"));
        primaryStage.setTitle("Client Manager");
        primaryStage.setScene(new Scene(root, 650, 500));
        primaryStage.show();
    }

    public static void main(String[] args) {

        ClientDao ClientData = new ClientDao();


        ClientDAOController ClientController = new ClientDAOController();

        ClientController.registerClientJ("Plutão","37.664.060/0001-19","Telefone(32)3201 3212");
        ClientController.registerClientF("Rodrigo potato","410.858.110-50","Telefone(32)3201 3212");

        ClientJ J = (ClientJ) ClientData.getClient(Objects.hashCode("Plutão"+"37.664.060/0001-19"));
        System.out.println(J.getCode());
        System.out.println(J.getName());
        System.out.println(J.getBalance());
        System.out.println(J.getWinnings());
        System.out.println(J.getSpent());
        ClientData.deleteClient(J.getCode());
//        System.out.println(J.hashCode());
        ClientF F = (ClientF) ClientData.getClient(Objects.hashCode("Rodrigo potato"+"410.858.110-50"));
//        System.out.println(F.hashCode());
        System.out.println(F.getCode());
        System.out.println(F.getName());
        System.out.println(F.getBalance());
        System.out.println(F.getWinnings());
        System.out.println(F.getSpent());
        ClientData.deleteClient(F.getCode());
//        ClientData.deleteClientJ(J);
        launch(args);

    }
}

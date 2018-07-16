package ClientManager.Controls;

import ClientManager.Controls.ClientDAOController;
import ClientManager.Models.Client;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class UserView implements Initializable {
    @FXML
    private TextField clientName;
    @FXML
    private TableColumn<Client, String> nameColumn;

    @FXML
    private TableColumn<Client, String> descriptionColumn;

    @FXML
    private javafx.scene.control.TableView<Client> clientsTable;

    private ArrayList<Client> clients;
    ObservableList<Client> data = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        clients = new ArrayList<>();
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
    }
    public void buttonCadastrarCliente() throws IOException {
        FXMLLoader fx = new FXMLLoader(getClass().getResource("/ClientManager/Views/CadastroCliente.fxml"));
        Stage stage= new Stage();
        Parent c = fx.load();
        Scene scene = new Scene(c);
        stage.setScene(scene);
        stage.show();
    }
    public void buttonBuscaClientes(){
        ClientDAOController co= new ClientDAOController();
        ArrayList<Client> clients = co.getClients(clientName.getText());

    }
}

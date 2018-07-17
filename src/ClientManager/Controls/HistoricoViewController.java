package ClientManager.Controls;

import ClientManager.Models.Client;
import ClientManager.Models.Invoice;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HistoricoViewController implements Initializable {

    @FXML
    private Label clientNameText;
    @FXML
    private Label totalRecivedText;
    @FXML
    private Label balanceText;
    @FXML
    private Label totalSpentText;
    @FXML
    private TableView<Invoice> invoicesTable;

    @FXML
    private TableColumn<Invoice, String> descriptionColumn;
    @FXML
    private TableColumn<Invoice, Float> spentColumn;
    @FXML
    private TableColumn<Invoice, Float> percentageColumn;
    @FXML
    private TableColumn<Invoice, Float> totalCostColumn;

    private ArrayList<Invoice> invoices;

    private Client selected;

    private InvoiceDAOController controller;

    ObservableList<Invoice> data = FXCollections.observableArrayList();

    /**
     *
     * @param selected é cliente que foi selecionado na tabela de clientes
     */
    public HistoricoViewController(Client selected) {
        this.controller = new InvoiceDAOController();
        this.selected = selected;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.invoices=new ArrayList<>();
        this.invoices=controller.getInvoices(selected.getCode());

        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        spentColumn.setCellValueFactory(new PropertyValueFactory<>("spent"));
        percentageColumn.setCellValueFactory(new PropertyValueFactory<>("winningPercentage"));
        totalCostColumn.setCellValueFactory(new PropertyValueFactory<>("totalcost"));

        data.addAll(invoices);
        invoicesTable.setItems(data);

        clientNameText.setText(selected.getName());
        totalRecivedText.setText(String.valueOf(selected.getWinnings()));
        balanceText.setText(String.valueOf(selected.getBalance()));
        totalSpentText.setText(String.valueOf(selected.getSpent()));
    }
    public void buttonDeleteInvoice(){

        controller.deleteInvoice(invoicesTable.getSelectionModel().getSelectedItem());

    }
    public void buttonCadastraFatura() throws IOException {
        CadastroInvoiceController controller= new CadastroInvoiceController(this.selected);
        Stage stage= new Stage();
        FXMLLoader fx = new FXMLLoader(getClass().getResource("/ClientManager/Views/CadastroInvoice.fxml"));
        fx.setController(controller);
        Parent c = fx.load();
        Scene scene = new Scene(c);
        stage.setScene(scene);
        stage.show();
    }
}

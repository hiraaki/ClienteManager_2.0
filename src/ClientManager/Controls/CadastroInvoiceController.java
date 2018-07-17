package ClientManager.Controls;

import ClientManager.Models.Client;
import ClientManager.Models.Invoice;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class CadastroInvoiceController implements Initializable {
    Client selected;

    @FXML
    private Label nomeClienteText;

    @FXML
    private Label totalText;

    @FXML
    private TextField spentfield;

    @FXML
    private TextField percentagefield;

    @FXML
    private TextArea descriptionArea;

    public CadastroInvoiceController(Client selected) {
        this.selected = selected;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nomeClienteText.setText(selected.getName());
    }

    public void buttonCalcular(){
        float gastos = Float.parseFloat(spentfield.getText());
        float porcentagem = Float.parseFloat(percentagefield.getText());
        totalText.setText(String.valueOf(gastos+(gastos*porcentagem/100)));
    }

    public void buttonAdicionar(){
        InvoiceDAOController co= new InvoiceDAOController();
        co.registerInvoice(
                descriptionArea.getText(),
                selected,
                Float.parseFloat(spentfield.getText()),
                Float.parseFloat(percentagefield.getText())
        );
    }


}

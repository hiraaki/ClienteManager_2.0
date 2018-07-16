package ClientManager.Views;

import ClientManager.Controls.ClientViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class UserView implements Initializable {
    @FXML
    private TextField textfildNome;
    @FXML
    private TextField textfildcpfcnpj;
    @FXML
    private TextField winningstext;
    @FXML
    private Label GanhosLabel;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //carregaComboBox();
        //winningstext.setEditable(false);
//        GanhosLabel.setText("dsadsadsadsa Shablau");
    }

    @FXML
    private ChoiceBox<String> comboBox;
    ObservableList<String> observableList;

    public void carregaComboBox(){
        observableList = FXCollections.observableArrayList();
        comboBox.setItems(observableList);
        comboBox.setValue(observableList.get(0));
    }
    public void buttonCadastraCliente(){
        String name = textfildNome.getText();
        String cpfcnpj = textfildcpfcnpj.getText();
        if(cpfcnpj.length()<18){
            ClientViewController cvc=new ClientViewController();
            cvc.registerClientF(name,cpfcnpj);
        }else{
            ClientViewController cvc=new ClientViewController();
            cvc.registerClientJ(name,cpfcnpj);
        }
    }
}

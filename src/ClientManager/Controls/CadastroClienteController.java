package ClientManager.Controls;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class CadastroClienteController implements Initializable {

    @FXML
    private TextField textfildNome;
    @FXML
    private TextField textfildcpfcnpj;
    @FXML
    private TextArea descriptionText;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void buttonCadastraCliente(){
        String name = textfildNome.getText();
        String cpfcnpj = textfildcpfcnpj.getText();
        String description = descriptionText.getText();
        if(cpfcnpj.length()<18){
            ClientDAOController cvc=new ClientDAOController();
            cvc.registerClientF(name,cpfcnpj,description);
        }else{
            ClientDAOController cvc=new ClientDAOController();
            cvc.registerClientJ(name,cpfcnpj,description);
        }
    }
}

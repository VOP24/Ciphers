package vop;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

public class PrimaryController implements Initializable {
    @FXML
    private Spinner<Integer> caesarSpinner;
    @FXML
    private RadioButton atbashButton;
    @FXML
    private RadioButton ceasarButton;
    @FXML
    private Button encryptButton;
    @FXML
    private Button decryptButton;
    @FXML
    private TextField startMessage;
    @FXML
    private TextField encryptedMessage;
    @FXML
    private TextField decryptedMessage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        caesarSpinner.setValueFactory(
                new SpinnerValueFactory.IntegerSpinnerValueFactory(
                        0,
                        CipherInterface.ALPHABETH.length - 1,
                        CipherInterface.ALPHABETH.length / 2
                )
        );

        ToggleGroup radioButtonGroup = new ToggleGroup();
        atbashButton.setToggleGroup(radioButtonGroup);
        ceasarButton.setToggleGroup(radioButtonGroup);
        atbashButton.setSelected(true);
    }

    @FXML
    private void processMessage(ActionEvent event) {
        CipherInterface cipher;
        if (atbashButton.isSelected()) {
            cipher = new AtbashCipher();
        } else if (ceasarButton.isSelected()){
            cipher = new CaesarCipher(caesarSpinner.getValue());
        }
        else {
            cipher = null;
        }

        if (event.getSource().equals(encryptButton)) {
            encryptedMessage.setText(cipher.encrypt(startMessage.getText()));
        }
        else if (event.getSource().equals(decryptButton)){
            decryptedMessage.setText(cipher.decrypt(encryptedMessage.getText()));
        }
    }
}

package ejercicio3;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ResultadoController {

    @FXML
    private Label resultadoLabel;

    public void mostrarResultado(String resultado) {
        resultadoLabel.setText(resultado);
    }
}

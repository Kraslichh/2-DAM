package ejercicio4;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ResultadoController {

    @FXML
    private Label resultadoLabel;

    public void mostrarResultado(String nombre) {
        resultadoLabel.setText("Hola, " + nombre + "!"); // Mostrar el resultado en la etiqueta
    }
}
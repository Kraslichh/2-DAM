package ejercicio4;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class SampleController {

    @FXML
    private TextField nombreTextField;

    @FXML
    private void mostrarResultado() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Resultado.fxml"));
            Parent root = loader.load();

            // Obtener el controlador de la nueva ventana
            ResultadoController resultadoController = loader.getController();

            // Obtener el nombre del TextField
            String nombre = nombreTextField.getText();

            // Pasar el nombre al controlador de resultado
            resultadoController.mostrarResultado(nombre);

            // Configurar la nueva ventana y mostrarla
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Resultado");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
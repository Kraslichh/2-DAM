package Ejercicio4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private TextField nombreTextField;

    @FXML
    private ComboBox<String> yearComboBox;

    @FXML
    private TextField precioTextField;

    @FXML
    private ComboBox<String> sinopsisComboBox;

    @FXML
    private void handleAñadir(ActionEvent event) {
        // Lógica para añadir el juego a la base de datos o realizar acciones de añadir
        mostrarMensaje("Juego añadido con éxito.");
        limpiarCampos();
    }

    @FXML
    private void handleLimpiar(ActionEvent event) {
        limpiarCampos();
    }

    @FXML
    private void handleBorrar(ActionEvent event) {
        String nombreJuego = nombreTextField.getText();
        // Lógica para borrar el juego de la base de datos o realizar acciones de borrado
        mostrarMensaje("El juego '" + nombreJuego + "' ha sido borrado.");
        limpiarCampos();
    }

    private void mostrarMensaje(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private void limpiarCampos() {
        nombreTextField.clear();
        yearComboBox.getSelectionModel().clearSelection();
        precioTextField.clear();
        sinopsisComboBox.getSelectionModel().clearSelection();
    }
}

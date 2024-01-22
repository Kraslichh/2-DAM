package ejercicio3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class SimpleController implements Initializable {


    @FXML
    private ComboBox<String> comboBox1;


    @FXML
    private RadioButton radioButtonParticular;


    @FXML
    private RadioButton radioButtonEmpresa;


    @FXML
    private ChoiceBox<String> choiceBox1;


    @FXML
    private CheckBox checkBox1, checkBox2, checkBox3;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Configurar elementos del ComboBox
        ObservableList<String> items = FXCollections.observableArrayList("Opción 1", "Opción 2", "Opción 3");
        comboBox1.setItems(items);


        // Configurar elementos del ChoiceBox
        ObservableList<String> items2 = FXCollections.observableArrayList("CONTADO", "TRANSFERENCIA", "PAYPAL");
        choiceBox1.setItems(items2);


        // Configurar ToggleGroup para los RadioButtons
        ToggleGroup toggleGroup = new ToggleGroup();
        radioButtonParticular.setToggleGroup(toggleGroup);
        radioButtonEmpresa.setToggleGroup(toggleGroup);
    }
    @FXML
    private void handleBtnAceptarAction() { //lo añadimos al botón en Ejercicio 13 usando on //onAction="#handleBtnAceptarAction"
        mostrarResultado();
    }
    // Método para abrir la nueva ventana con los resultados
    @FXML
    private void mostrarResultado() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Resultado.fxml")); //cargamos el fichero //Resultado
            Parent root = loader.load();


            // Obtener el controlador de la nueva ventana
            ResultadoController resultadoController = loader.getController();


            // Construir el mensaje de resultados, con esta clase creamos de manera mas eficiente cadena de caracters
            StringBuilder mensaje = new StringBuilder(); //
            mensaje.append("ComboBox: ").append(comboBox1.getValue()).append("\n"); //Podemos usar el metodo //append


            if (radioButtonParticular.isSelected()) {
                mensaje.append("RadioButton seleccionado: Particular\n");
            } else if (radioButtonEmpresa.isSelected()) {
                mensaje.append("RadioButton seleccionado: Empresa\n");
            }


            mensaje.append("ChoiceBox: ").append(choiceBox1.getValue()).append("\n");


            if (checkBox1.isSelected()) {
                mensaje.append("CheckBox 1 seleccionado\n");
            }
            if (checkBox2.isSelected()) {
                mensaje.append("CheckBox 2 seleccionado\n");
            }
            if (checkBox3.isSelected()) {
                mensaje.append("CheckBox 3 seleccionado\n");
            }


            // Mostrar el resultado en la nueva ventana
            resultadoController.mostrarResultado(mensaje.toString());


            // Configurar la nueva ventana y mostrarla
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Resultados");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

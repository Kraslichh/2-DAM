package Ejercicios;
import java.awt.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class Controlador {

    @FXML
    private TableView<Persona> tabla;

    @FXML
    private TableColumn<Persona, Integer> idColumna;

    @FXML
    private TableColumn<Persona, String> nombreColumna;

    @FXML
    private TableColumn<Persona, String> apellido1Columna;

    @FXML
    private TableColumn<Persona, String> apellido2Columna;

    @FXML
    private TableColumn<Persona, String> fechaNacimientoColumna;

    @FXML
    private TableColumn<Persona, Boolean> esRepetidorColumna;

    @FXML
    private TableColumn<Persona, String> telefonoColumna;
    
    private void cargarDatos(ActionEvent event) {
        // Aquí coloca la lógica para cargar los datos desde la base de datos
        // y mostrarlos en la tabla
        // Puedes utilizar la TableView y las propiedades de la clase Persona
    }

    public void initialize() {
        // Configurar las columnas de la tabla
        idColumna.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        nombreColumna.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
        apellido1Columna.setCellValueFactory(cellData -> cellData.getValue().apellido1Property());
        apellido2Columna.setCellValueFactory(cellData -> cellData.getValue().apellido2Property());
        fechaNacimientoColumna.setCellValueFactory(cellData -> cellData.getValue().fechaNacimientoProperty());
        esRepetidorColumna.setCellValueFactory(cellData -> cellData.getValue().esRepetidorProperty().asObject());
        telefonoColumna.setCellValueFactory(cellData -> cellData.getValue().telefonoProperty());


        // Aquí puedes cargar los datos desde la base de datos y agregarlos a la tabla
        // Por ahora, se muestra un ejemplo con datos ficticios
        tabla.setItems(Persona.getDatosEjemplo());
    }
}

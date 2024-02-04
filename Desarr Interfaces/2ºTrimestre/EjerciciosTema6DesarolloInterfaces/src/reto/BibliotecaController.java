package reto;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class BibliotecaController {
    @FXML
    private TextField tituloField;
    
    @FXML
    private TextField autorField;
    
    @FXML
    private TextField anioField;
    
    @FXML
    private ChoiceBox<String> categoriaChoiceBox;
    
    @FXML
    private TableView<Libro> librosTable;
    
    @FXML
    private TableColumn<Libro, Integer> idColumn;
    
    @FXML
    private TableColumn<Libro, String> tituloColumn;
    
    @FXML
    private TableColumn<Libro, String> autorColumn;
    
    @FXML
    private TableColumn<Libro, Integer> anioColumn;
    
    // Declarar otros métodos y lógica aquí
}
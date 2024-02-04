package Ejercicio2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;


import java.sql.SQLException;
import java.util.List;


public class Controller {


    @FXML
    private TableView<TVideoJuego> tableViewVideojuegos;


    @FXML
    private TableColumn<TVideoJuego, String> nombreColumn;


    @FXML
    private TableColumn<TVideoJuego, Integer> anioColumn;


    @FXML
    private TableColumn<TVideoJuego, String> companiaColumn;


    @FXML
    private TableColumn<TVideoJuego, Double> precioColumn;


    @FXML
    private TableColumn<TVideoJuego, String> sinopsisColumn;


    @FXML
    private TableColumn<TVideoJuego, String> plataformaColumn;


    @FXML
    private TextField nombreTextField;


    @FXML
    private TextField anioTextField;


    @FXML
    private ComboBox<String> cmbCompania;


    @FXML
    private TextField precioTextField;


    @FXML
    private TextField sinopsisTextField;


    @FXML
    private ChoiceBox<String> choicePlataforma;


    @FXML
    private Button btnAgregarJuego;


    private TVideoJuegoModel model;


    public void inicializar(String dbURL, String dbUser, String dbPassword) throws SQLException {
        // Inicializa el modelo de la base de datos
        model = new TVideoJuegoModel(dbURL, dbUser, dbPassword);
          


        // Configura el botón de agregar juego
        btnAgregarJuego.setOnAction(event -> agregarJuego());


        // Configura los desplegables
        cargarCompanias();
        cargarPlataformas();


        // Al inicializar el controlador, carga los juegos desde la base de datos
        
    }


  
    private void cargarCompanias() {
        // Puedes obtener la lista de compañías desde la base de datos o definirla estáticamente
        // Por ahora, la definiremos estáticamente
        List<String> companias = List.of("EA", "Ubisoft", "Activision", "Nintendo", "Sony", "Microsoft");


        // Configura el ComboBox con las compañías
        cmbCompania.setItems(FXCollections.observableArrayList(companias));
    }


    private void cargarPlataformas() {
        // Puedes obtener la lista de plataformas desde la base de datos o definirla estáticamente
        // Por ahora, la definiremos estáticamente
        List<String> plataformas = List.of("PC", "PlayStation", "Xbox", "Nintendo Switch");


        // Configura el ChoiceBox con las plataformas
        choicePlataforma.setItems(FXCollections.observableArrayList(plataformas));
    }


    @FXML
    private void agregarJuego() {
        // Obtener los valores de los campos de texto y desplegables
        String nombre = nombreTextField.getText();
        int anio = Integer.parseInt(anioTextField.getText());
        String compania = cmbCompania.getValue();
        double precio = Double.parseDouble(precioTextField.getText());
        String sinopsis = sinopsisTextField.getText();
        String plataforma = choicePlataforma.getValue();


        // Crear un nuevo TVideoJuego
        TVideoJuego nuevoJuego = new TVideoJuego(0, nombre, anio, compania, precio, sinopsis, plataforma);


        // Agregar el juego a la base de datos y actualizar la TableView
        try {
            model.addVideoJuego(nuevoJuego);
          
        } catch (SQLException e) {
            e.printStackTrace();
        }


        // Mostrar un mensaje indicando que el juego ha sido añadido
        String mensaje = "Juego añadido:\n" +
                "Nombre: " + nombre + "\n" +
                "Año: " + anio + "\n" +
                "Compañía: " + compania + "\n" +
                "Precio: " + precio + "\n" +
                "Sinopsis: " + sinopsis + "\n" +
                "Plataforma: " + plataforma;


        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Juego Añadido");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();


        // Limpiar los campos después de agregar el juego
        limpiarCampos();
    }


    private void limpiarCampos() {
        nombreTextField.clear();
        anioTextField.clear();
        cmbCompania.setValue(null);
        precioTextField.clear();
        sinopsisTextField.clear();
        choicePlataforma.setValue(null);
    }


    @FXML
    private void cerrarConexion() {
        model.close();
    }
}

package ejercicio3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            // Cargamos el archivo Sample.fxml como la ventana principal
            FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
            Parent root = loader.load();
            primaryStage.setTitle("Formulario Clientes");
            primaryStage.setScene(new Scene(root, 400, 600));
            primaryStage.show();

            // Obtén una referencia al controlador de Sample.fxml
            SimpleController simpleController = loader.getController();

            // Puedes configurar eventos o métodos en el controlador de Sample.fxml
            // Por ejemplo, para abrir la ventana de Resultado.fxml al hacer clic en un botón en Sample.fxml:
            // simpleController.getBotonMostrarResultado().setOnAction(e -> mostrarResultado());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 // Puedes agregar un método para mostrar la ventana Resultado.fxml cuando sea necesario
    private void mostrarResultado() {
        try {
            // Creamos un cargador FXMLLoader para cargar Resultado.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Resultado.fxml"));
            
            // Cargamos el contenido de Resultado.fxml en un nodo Parent
            Parent root = loader.load();
            
            // Creamos una nueva ventana (Stage) para mostrar los resultados
            Stage stage = new Stage();
            stage.setTitle("Resultados"); // Título de la ventana
            stage.setScene(new Scene(root, 400, 600)); // Establecemos el contenido y dimensiones
            stage.show(); // Mostramos la ventana
        } catch (Exception e) {
            e.printStackTrace(); // Manejamos cualquier excepción que pueda ocurrir al cargar la ventana
        }
    }
}
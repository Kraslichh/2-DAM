package Ejercicio3;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Ejercicio3 extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
	    // Utiliza getResource para obtener la URL del archivo FXML
	    URL fxmlURL = getClass().getResource("Simple.fxml");

	    if (fxmlURL == null) {
	        System.out.println("No se pudo encontrar el archivo FXML.");
	        System.exit(1);
	    }

	    // Cargar el archivo FXML
	    Parent root = FXMLLoader.load(fxmlURL);

	    primaryStage.setTitle("Ejercicio Simple");
	    primaryStage.setScene(new Scene(root, 300, 200)); // Tamaño de la ventana
	    primaryStage.show();
	}

    public static void main(String[] args) {
        launch(args);
    }
}

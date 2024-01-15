package application;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Ejercicio2 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Proyecto FX");

        // Crear la disposición horizontal para los botones
        HBox hbox = new HBox(10); // 10 pixels de espacio entre los botones
        hbox.setAlignment(Pos.TOP_LEFT);

        // Crear 8 botones y agregarlos a la disposición horizontal
        for (int i = 1; i <= 8; i++) {
            Button button = new Button("Botón " + i);
            int buttonNumber = i;
            button.setOnAction(e -> onButtonClick(buttonNumber));
            hbox.getChildren().add(button);
        }

        // Crear la escena y establecerla en la ventana
        Scene scene = new Scene(hbox, 600, 300);
        primaryStage.setScene(scene);

        // Mostrar la ventana
        primaryStage.show();
    }

    // Método para manejar el clic en los botones
    private void onButtonClick(int buttonNumber) {
        System.out.println("Botón " + buttonNumber + " clickeado");
    }
}

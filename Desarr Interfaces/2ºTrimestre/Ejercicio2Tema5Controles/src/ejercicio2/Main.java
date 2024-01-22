package ejercicio2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {

    private TextField valorField;
    private Label resultadoLabel;

    @Override
    public void start(Stage primaryStage) {
        // Configuración de la interfaz de usuario
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10, 10, 10, 10));

        valorField = new TextField();
        valorField.setPromptText("Ingrese el valor");
        resultadoLabel = new Label("Resultado: ");

        Button calcular4Button = new Button("Calcular 4%");
        Button calcular10Button = new Button("Calcular 10%");
        Button calcular21Button = new Button("Calcular 21%");

        // Manejo de eventos para los botones
        calcular4Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                calcularPorcentaje(4);
            }
        });

        calcular10Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                calcularPorcentaje(10);
            }
        });

        calcular21Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                calcularPorcentaje(21);
            }
        });

        // Agregar elementos al grid
        gridPane.add(valorField, 0, 0);
        gridPane.add(resultadoLabel, 0, 1, 3, 1);
        gridPane.add(calcular4Button, 0, 2);
        gridPane.add(calcular10Button, 1, 2);
        gridPane.add(calcular21Button, 2, 2);

        Scene scene = new Scene(gridPane, 400, 200);
        primaryStage.setTitle("Calculadora de Porcentaje");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void calcularPorcentaje(int porcentaje) {
        try {
            double valor = Double.parseDouble(valorField.getText());
            double resultado = (valor * porcentaje) / 100;
            resultadoLabel.setText("Resultado: " + resultado);
        } catch (NumberFormatException e) {
            resultadoLabel.setText("Error: Ingresa un valor válido.");
        }
    }
}

package ejercicio1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {

    private TextField operador1Field;
    private TextField operador2Field;
    private Label resultadoLabel;

    @Override
    public void start(Stage primaryStage) {
        // Configuración de la interfaz de usuario
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10, 10, 10, 10));

        operador1Field = new TextField();
        operador1Field.setPromptText("Operador 1");
        operador2Field = new TextField();
        operador2Field.setPromptText("Operador 2");
        resultadoLabel = new Label("Resultado: ");

        Button sumarButton = new Button("Sumar");
        Button restarButton = new Button("Restar");
        Button multiplicarButton = new Button("Multiplicar");
        Button dividirButton = new Button("Dividir");
        Button limpiarButton = new Button("Limpiar");
        Button salirButton = new Button("Salir");

        // Manejo de eventos para los botones
        sumarButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                sumar();
            }
        });

        restarButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                restar();
            }
        });

        multiplicarButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                multiplicar();
            }
        });

        dividirButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dividir();
            }
        });

        limpiarButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                limpiar();
            }
        });

        salirButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                salir();
            }
        });

        // Agregar elementos al grid
        gridPane.add(operador1Field, 0, 0);
        gridPane.add(operador2Field, 1, 0);
        gridPane.add(resultadoLabel, 0, 1, 2, 1);
        gridPane.add(sumarButton, 0, 2);
        gridPane.add(restarButton, 1, 2);
        gridPane.add(multiplicarButton, 0, 3);
        gridPane.add(dividirButton, 1, 3);
        gridPane.add(limpiarButton, 0, 4);
        gridPane.add(salirButton, 1, 4);

        Scene scene = new Scene(gridPane, 300, 200);
        primaryStage.setTitle("Calculadora");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void sumar() {
        try {
            double operador1 = Double.parseDouble(operador1Field.getText());
            double operador2 = Double.parseDouble(operador2Field.getText());
            double resultado = operador1 + operador2;
            resultadoLabel.setText("Resultado: " + resultado);
        } catch (NumberFormatException e) {
            resultadoLabel.setText("Error: Ingresa números válidos.");
        }
    }

    private void restar() {
        try {
            double operador1 = Double.parseDouble(operador1Field.getText());
            double operador2 = Double.parseDouble(operador2Field.getText());
            double resultado = operador1 - operador2;
            resultadoLabel.setText("Resultado: " + resultado);
        } catch (NumberFormatException e) {
            resultadoLabel.setText("Error: Ingresa números válidos.");
        }
    }

    private void multiplicar() {
        try {
            double operador1 = Double.parseDouble(operador1Field.getText());
            double operador2 = Double.parseDouble(operador2Field.getText());
            double resultado = operador1 * operador2;
            resultadoLabel.setText("Resultado: " + resultado);
        } catch (NumberFormatException e) {
            resultadoLabel.setText("Error: Ingresa números válidos.");
        }
    }

    private void dividir() {
        try {
            double operador1 = Double.parseDouble(operador1Field.getText());
            double operador2 = Double.parseDouble(operador2Field.getText());
            if (operador2 != 0) {
                double resultado = operador1 / operador2;
                resultadoLabel.setText("Resultado: " + resultado);
            } else {
                resultadoLabel.setText("Error: No se puede dividir por cero.");
            }
        } catch (NumberFormatException e) {
            resultadoLabel.setText("Error: Ingresa números válidos.");
        }
    }

    private void limpiar() {
        operador1Field.clear();
        operador2Field.clear();
        resultadoLabel.setText("Resultado: ");
    }

    private void salir() {
        System.exit(0);
    }
}

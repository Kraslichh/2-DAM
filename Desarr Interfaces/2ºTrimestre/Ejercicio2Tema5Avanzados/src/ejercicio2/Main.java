package ejercicio2;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Configuración del formulario en la parte izquierda
        VBox leftPane = new VBox();
        leftPane.setSpacing(10);
        leftPane.setStyle("-fx-padding: 10px;");

        Label titleLabel = new Label("Nuevo Videojuego");
        titleLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
        TextField nombreField = new TextField();
        nombreField.setPromptText("Nombre");
        TextField precioField = new TextField();
        precioField.setPromptText("Precio");
        TextField consolaField = new TextField();
        consolaField.setPromptText("Consola");
        TextField pegiField = new TextField();
        pegiField.setPromptText("PEGI");
        Button agregarButton = new Button("Agregar");

        leftPane.getChildren().addAll(titleLabel, nombreField, precioField, consolaField, pegiField, agregarButton);

        // Configuración de la tabla en la parte derecha
        TableView<Game> tableView = new TableView<>();
        TableColumn<Game, String> nombreColumn = new TableColumn<>("Nombre");
        nombreColumn.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        TableColumn<Game, Double> precioColumn = new TableColumn<>("Precio");
        precioColumn.setCellValueFactory(new PropertyValueFactory<>("precio"));
        TableColumn<Game, String> consolaColumn = new TableColumn<>("Consola");
        consolaColumn.setCellValueFactory(new PropertyValueFactory<>("consola"));
        TableColumn<Game, String> pegiColumn = new TableColumn<>("PEGI");
        pegiColumn.setCellValueFactory(new PropertyValueFactory<>("pegi"));

        tableView.getColumns().addAll(nombreColumn, precioColumn, consolaColumn, pegiColumn);

        // Configuración de la ventana
        SplitPane splitPane = new SplitPane();
        splitPane.getItems().addAll(leftPane, tableView);

        Scene scene = new Scene(splitPane, 800, 400);
        primaryStage.setTitle("Ventana Personalizada");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

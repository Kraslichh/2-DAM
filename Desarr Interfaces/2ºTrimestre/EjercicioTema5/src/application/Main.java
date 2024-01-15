package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class Main extends Application {
@Override
public void init() throws Exception {
super.init();
System.out.println("Método init() llamado.");
// Puedes agregar código de inicialización aquí si es necesario.
}
@Override
public void start(Stage primaryStage) {
try {
BorderPane root = new BorderPane();
Scene scene = new Scene(root, 400, 400);
scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
primaryStage.setScene(scene);
primaryStage.show();
System.out.println("Método start() llamado.");
} catch (Exception e) {
e.printStackTrace();
}
}
@Override
public void stop() throws Exception {
super.stop();
System.out.println("Método stop() llamado.");
// Puedes agregar código de limpieza o cierre aquí si es necesario.
}
public static void main(String[] args) {
launch(args);
}
}

module Ejercicios1Tema6 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    // Asegúrate de que 'Ejercicio2' es el nombre correcto del paquete donde se encuentra tu clase Main y otras clases relacionadas con JavaFX.
    opens Ejercicio2 to javafx.graphics, javafx.fxml;
    opens Ejercicio4 to javafx.graphics, javafx.fxml;
}

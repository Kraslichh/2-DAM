/**
 * 
 */
/**
 * 
 */
module Ejercicio2Tema5Controles {
    requires javafx.controls;
    requires javafx.fxml;
    // Añade otros módulos de JavaFX según sea necesario, por ejemplo:
     requires javafx.graphics;
     requires javafx.base;
     
    // Si utilizas la reflexión o cargas FXML, también necesitarás:
    opens ejercicio1; // Reemplaza 'tu.paquete' con el nombre de tu paquete
    exports ejercicio1;
    exports ejercicio2;
    exports ejercicio3;
    exports ejercicio4;
    exports ejercicio5;
    opens ejercicio4 to javafx.fxml;
    opens ejercicio5 to javafx.fxml;
}
   
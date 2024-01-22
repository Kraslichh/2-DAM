/**
 * 
 */
/**
 * 
 */
module EjercicioTema2Avanzados {

    requires javafx.controls;
    requires javafx.fxml;
    // Añade otros módulos de JavaFX según sea necesario, por ejemplo:
     requires javafx.graphics;
     requires javafx.base;
     
    // Si utilizas la reflexión o cargas FXML, también necesitarás:
    opens ejercicios; // Reemplaza 'tu.paquete' con el nombre de tu paquete
    exports ejercicios; // Reemplaza 'tu.paquete' con el nombre de tu paquete
    exports ejercicio2;
}
   
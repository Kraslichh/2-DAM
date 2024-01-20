package clases;
import java.util.List;
import java.sql.*;

public class EmpleadoController {
    private EmpleadoModel model; // Instancia del modelo
    private EmpleadoView view;   // Instancia de la vista

    // Constructor que recibe la URL de la base de datos, el usuario y la contraseña
    public EmpleadoController(String dbURL, String dbUser, String dbPassword) throws SQLException {
        model = new EmpleadoModel(dbURL, dbUser, dbPassword); // Inicializa el modelo con la conexión a la base de datos
        view = new EmpleadoView(); // Inicializa la vista
    }

    // Método para mostrar los clientes
    public void mostrarEmpleado() throws SQLException {
        List<Empleados> empleados = model.getAllEmpleados(); // Obtiene la lista de clientes desde el modelo
        view.mostrarEmpleado(empleados); // Muestra los clientes en la vista
    }

    // Método para cerrar la conexión a la base de datos
    public void cerrarConexion() throws SQLException {
        model.close(); // Cierra la conexión en el modelo
    }
}

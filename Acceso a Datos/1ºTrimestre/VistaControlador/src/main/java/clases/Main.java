package clases;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String dbURL = "jdbc:mysql://localhost/empresa"; // URL de la base de datos
        String dbUser = "root"; // Usuario de la base de datos
        String dbPassword = ""; // Contraseña del usuario

        try {
            ClienteController controller = new ClienteController(dbURL, dbUser, dbPassword); // Crea una instancia del controlador
            System.out.println("--Clientes--");
            controller.mostrarClientes(); // Llama al método del controlador para mostrar los clientes
            controller.cerrarConexion(); // Llama al método del controlador para cerrar la conexión a la base de datos
            
            EmpleadoController empleado= new EmpleadoController(dbURL, dbUser, dbPassword);
            System.out.println("--Empleados--");
            empleado.mostrarEmpleado();
            empleado.cerrarConexion();
        } catch (SQLException e) {
            e.printStackTrace(); // Maneja las excepciones de SQL imprimiendo el error
        }
        
    }
}


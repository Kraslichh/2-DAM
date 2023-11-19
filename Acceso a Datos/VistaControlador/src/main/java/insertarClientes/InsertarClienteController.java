package insertarClientes;

import java.util.List;
import java.sql.*;

public class InsertarClienteController {
    private InsertarClienteController model; // Instancia del modelo
    private InsertarClienteView view; // Instancia de la vista
    private String dbURL = "jdbc:mysql://localhost:3306/empresa";
    private String dbUser = "root";
    private String dbPassword = "";

    // Constructor que recibe la URL de la base de datos, el usuario y la contraseña
    public InsertarClienteController(String dbURL, String dbUser, String dbPassword) {
        this.dbURL = dbURL;
        this.dbUser = dbUser;
        this.dbPassword = dbPassword;
    }

    public InsertarClienteController(InsertarClienteController model, InsertarClienteView view) {
        this.model = model;
        this.view = view;
    }

    // Método para insertar los clientes en la base de datos
    public void insertarClientes(List<InsertarCliente> clientes) {
        Connection connection = null;
        try {
            connection = obtenerConexion(); // Obtiene la conexión para manejar transacciones

            connection.setAutoCommit(false); // Desactiva el modo de auto-commit para manejar transacciones

            insertarClienteModel(clientes, connection); // Inserta los clientes en la base de datos a través del método local

            connection.commit(); // Confirma la transacción si todo ha ido bien
        } catch (SQLException e) {
            // Si hay un error, se revierte la transacción
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException rollbackException) {
                    rollbackException.printStackTrace();
                }
            }
            e.printStackTrace();
            // Manejo de errores aquí, como registrar el error o lanzar una excepción
        } finally {
            if (connection != null) {
                try {
                    connection.setAutoCommit(true); // Restaura el modo de auto-commit
                    connection.close(); // Cierra la conexión
                } catch (SQLException closeException) {
                    closeException.printStackTrace();
                }
            }
        }
    }

    public Connection obtenerConexion() throws SQLException {
        // Aquí se obtiene y devuelve la conexión a la base de datos
        // Asegúrate de manejar correctamente las excepciones y configurar los detalles de conexión
        return DriverManager.getConnection(dbURL, dbUser, dbPassword);
    }

    public void insertarClienteModel(List<InsertarCliente> clientes, Connection connection) throws SQLException {
        String query = "INSERT INTO clientes (id ,nif, nombre, edad) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);

        for (InsertarCliente cliente : clientes) {
            statement.setInt(1, cliente.getId());
            statement.setString(2, cliente.getNif());
            statement.setString(3, cliente.getNombre());
            statement.setString(4, cliente.getEdad());

            statement.executeUpdate();
        }

        statement.close();
    }

    // Método para cerrar la conexión a la base de datos
    public void cerrarConexion() throws SQLException {
        model.cerrarConexion(); // Cierra la conexión en el modelo
    }
}

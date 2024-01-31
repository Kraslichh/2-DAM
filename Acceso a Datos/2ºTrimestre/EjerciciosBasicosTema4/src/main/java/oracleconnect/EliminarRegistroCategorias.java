package oracleconnect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EliminarRegistroCategorias {
	private static final String URL = "jdbc:mysql://localhost:3306/tema4ejercicios"; // URL de la base de datos
	private static final String USUARIO = "root";
	private static final String CONTRASENA = "";

    public static void main(String[] args) {
        Connection conexion = null;
        PreparedStatement sentencia = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);

            String sqlEliminar = "DELETE FROM CategoriasProductos WHERE id = ?";

            sentencia = conexion.prepareStatement(sqlEliminar);

            // Eliminar el registro con id 2
            sentencia.setInt(1, 2); // id

            int filasAfectadas = sentencia.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Registro eliminado con éxito.");
            } else {
                System.out.println("No se encontró el registro para eliminar.");
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el driver JDBC de Oracle: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error al conectarse a la base de datos o al ejecutar la consulta: " + e.getMessage());
        } finally {
            try {
                if (sentencia != null) {
                    sentencia.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar los recursos: " + e.getMessage());
            }
        }
    }
}

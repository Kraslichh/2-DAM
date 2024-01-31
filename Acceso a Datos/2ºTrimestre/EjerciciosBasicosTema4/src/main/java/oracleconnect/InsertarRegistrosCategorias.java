package oracleconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertarRegistrosCategorias {

	private static final String URL = "jdbc:mysql://localhost:3306/tema4ejercicios"; // URL de la base de datos
	private static final String USUARIO = "root";
	private static final String CONTRASENA = "";


    public static void main(String[] args) {
        Connection conexion = null;
        PreparedStatement sentencia = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);

            String sqlInsertar = "INSERT INTO CategoriasProductos (id, Categoria, Subcategoria) VALUES (?, ?, ?)";

            sentencia = conexion.prepareStatement(sqlInsertar);

            // Insertar primer registro
            sentencia.setInt(1, 1); // id
            sentencia.setString(2, "Informática"); // Categoria
            sentencia.setString(3, "portátiles"); // Subcategoria
            sentencia.executeUpdate();

            // Insertar segundo registro
            sentencia.setInt(1, 2); // id
            sentencia.setString(2, "Alimentación"); // Categoria
            sentencia.setString(3, "Monitor"); // Subcategoria
            sentencia.executeUpdate();

            System.out.println("Registros insertados con éxito.");

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
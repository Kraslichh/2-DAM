package oracleconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CrearTablaCategorias {

	private static final String URL = "jdbc:mysql://localhost:3306/tema4ejercicios"; // URL de la base de datos
	private static final String USUARIO = "root";
	private static final String CONTRASENA = "";

    public static void main(String[] args) {
        Connection conexion = null;
        Statement sentencia = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);

            String sqlCrearTabla = "CREATE TABLE CategoriasProductos (" +
            	    "id INT PRIMARY KEY, " +
            	    "Categoria VARCHAR(30), " +
            	    "Subcategoria VARCHAR(30))";

            sentencia = conexion.createStatement();
            sentencia.execute(sqlCrearTabla);

            System.out.println("Tabla 'CategoriasProductos' creada con éxito.");

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

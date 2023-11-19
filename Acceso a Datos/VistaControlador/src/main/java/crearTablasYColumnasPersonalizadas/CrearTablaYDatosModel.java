package crearTablasYColumnasPersonalizadas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CrearTablaYDatosModel {

    public void crearTablasPersonalizadas() {
        final String url = "jdbc:mysql://localhost:3306/empresa"; // Selecciona la base de datos 'empresa'
        final String usuario = "root";
        final String contraseña = "";

        try (Connection conn = DriverManager.getConnection(url, usuario, contraseña)) {
            Statement stmt = conn.createStatement();

            Scanner scanner = new Scanner(System.in);

            System.out.println("Ingrese el nombre de la primera tabla:");
            String nombreTabla1 = scanner.nextLine();

            System.out.println("Ingrese las columnas y tipos de datos separadas por comas (por ejemplo: id INT, nombre VARCHAR(50), edad INT):");
            String columnasTabla1 = scanner.nextLine();

            String sqlTabla1 = "CREATE TABLE IF NOT EXISTS " + nombreTabla1 + " (" + columnasTabla1 + ")";
            stmt.executeUpdate(sqlTabla1);
            System.out.println("Tabla '" + nombreTabla1 + "' creada correctamente.");

            System.out.println("Ingrese el nombre de la segunda tabla:");
            String nombreTabla2 = scanner.nextLine();

            System.out.println("Ingrese las columnas y tipos de datos separadas por comas (por ejemplo: id INT, nombre VARCHAR(50), edad INT):");
            String columnasTabla2 = scanner.nextLine();

            String sqlTabla2 = "CREATE TABLE IF NOT EXISTS " + nombreTabla2 + " (" + columnasTabla2 + ")";
            stmt.executeUpdate(sqlTabla2);
            System.out.println("Tabla '" + nombreTabla2 + "' creada correctamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

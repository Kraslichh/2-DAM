package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SolucionCrearProcedimiento2 {

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // Establece la conexión a la base de datos
            conn = DriverManager.getConnection("jdbc:mysql://localhost/phonelandcenec", "root", "");

            // Crea el procedimiento almacenado para calcular el IVA y el total
            String sql = "CREATE PROCEDURE CalcularIvaYTotal() " +
                    "BEGIN " +
                    "    SELECT nombre, precio, precio * 0.21 AS iva, precio * 1.21 AS total FROM productos; " +
                    "END";

            stmt = conn.createStatement();

            // Ejecuta la consulta SQL para crear el procedimiento
            stmt.execute(sql);

            System.out.println("Procedimiento creado exitosamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SolucionInvocacionProcedimiento2 {

    public static void main(String[] args) {
    	Connection conn = null;
        CallableStatement cstmt = null;

        try {
            // Establece la conexión a la base de datos
            conn = DriverManager.getConnection("jdbc:mysql://localhost/phoneland", "root", "");

            // Llama al procedimiento almacenado
            cstmt = conn.prepareCall("{call CalcularIvaYTotal()}");

            // Ejecuta el procedimiento
            cstmt.execute();

            // Obtiene los resultados
            ResultSet rs = cstmt.getResultSet();

            // Muestra los resultados en la consola
            System.out.println("Nombre\tPrecio\tIVA\tTotal");
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                double precio = rs.getDouble("precio");
                double iva = rs.getDouble("iva");
                double total = rs.getDouble("total");

                System.out.println(nombre + "\t" + precio + "\t" + iva + "\t" + total);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (cstmt != null) {
                    cstmt.close();
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

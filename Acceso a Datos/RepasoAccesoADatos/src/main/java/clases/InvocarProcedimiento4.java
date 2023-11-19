package clases;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class InvocarProcedimiento4 {

    public static void main(String[] args) {
        Connection conn = null;
        CallableStatement cstmt = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/phonelandcenec", "root", "");
            double precio = 100.0;

            // Llamar al procedimiento almacenado
            cstmt = conn.prepareCall("call CalculaPrecioDescuentoIvaTotal(?,?,?,?,?)");

            // Introducimos los valores necesarios
            cstmt.setDouble(1, precio);

            for (int i = 2; i < 6; i++) { // Cambiado a 6 para el último parámetro
                cstmt.registerOutParameter(i, Types.DECIMAL);
            }

            // Ejecutar el procedimiento
            cstmt.execute();

            // Obtener los resultados si el procedimiento devuelve algo
            double descuento = cstmt.getDouble(2); // Parámetro a devolver
            double precio_descuento = cstmt.getDouble(3); // Parámetro a devolver
            double iva = cstmt.getDouble(4); // Parámetro a devolver
            double total = cstmt.getDouble(5); // Parámetro a devolver

            System.out.println("Procedimiento invocado");
            System.out.println("El importe sin IVA es....... " + precio);
            System.out.println("El descuento es.............  " + descuento);
            System.out.println("El precio con descuento es..  " + precio_descuento);
            System.out.println("El IVA es...................  " + iva);
            System.out.println("El total es................. " + total);

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

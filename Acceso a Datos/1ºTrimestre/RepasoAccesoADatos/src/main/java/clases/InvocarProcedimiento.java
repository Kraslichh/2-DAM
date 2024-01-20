package clases;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;

public class InvocarProcedimiento {

    public static void main(String[] args) {
        Connection conn = null;
        //definimos un objeto callableStatement sirve para
        //preparar la ejecución del procedimiento
        CallableStatement cstmt = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/empresa", "root", "");

            // Llamar al procedimiento almacenado
            cstmt = conn.prepareCall("call ObtenerClientes()");

            // Ejecutar el procedimiento
            cstmt.execute();

            // Obtener los resultados si el procedimiento devuelve algo
            ResultSet rs = cstmt.getResultSet();
            //en este bucle vamos mostrando por pantalla el 
            // resultado de lo que hemos realizdao
            
            
            while (rs.next()) {
                int id = rs.getInt("id");
                String nif = rs.getString("nif");
                String nombre = rs.getString("nombre");
                String edad = rs.getString("edad");
                System.out.println("id: " + id + ", nif: " + nif + ", "
                		+ "nombre: " + nombre + ", edad: " + edad);
            }

            System.out.println("Procedimiento invocado");

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

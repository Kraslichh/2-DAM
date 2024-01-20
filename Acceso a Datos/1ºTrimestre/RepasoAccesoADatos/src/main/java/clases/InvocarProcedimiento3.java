package clases;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.sql.ResultSet;

public class InvocarProcedimiento3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Connection conn = null;
	        CallableStatement cstmt = null;

	        try {
	            conn = DriverManager.getConnection("jdbc:mysql://localhost/phonelandcenec", "root", "");

	            // Llamar al procedimiento almacenado
	            cstmt = conn.prepareCall("call CalculaPrecioIva2(?,?)");
	            cstmt.setDouble(1, 100.0); //1 es el primer valor del argumento del procedimiento
	            cstmt.registerOutParameter(2, Types.DECIMAL);
	            // Ejecutar el procedimiento
	            cstmt.execute();

	            // Obtener los resultados si el procedimiento devuelve algo
	           double precioConIva=cstmt.getDouble(2);//el parametro dos es el que me tiene que devolver
	            
	            System.out.println("Procedimiento invocado");
	            System.out.println("El importe con iva "+precioConIva);

	            conn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}
}
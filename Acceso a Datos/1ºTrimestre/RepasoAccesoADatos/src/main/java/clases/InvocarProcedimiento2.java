package clases;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.sql.ResultSet;
public class InvocarProcedimiento2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Connection conn = null;
	        CallableStatement cstmt = null;

	        try {
	            conn = DriverManager.getConnection("jdbc:mysql://localhost/phonelandcenec", "root", "");

	            // Llamar al procedimiento almacenado
	            cstmt = conn.prepareCall("call CalculaEdad1(?,?)");
	            cstmt.setInt(1, 1977); //1 es el primer valor del argumento del procedimiento
	            cstmt.registerOutParameter(2, Types.INTEGER);
	            // Ejecutar el procedimiento
	            cstmt.execute();

	            // Obtener los resultados si el procedimiento devuelve algo
	            int edad=cstmt.getInt(2);//el parametro dos es el que me tiene que devolver
	            
	            System.out.println("Procedimiento invocado");
	            System.out.println("la edad es "+edad);

	            conn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}
}

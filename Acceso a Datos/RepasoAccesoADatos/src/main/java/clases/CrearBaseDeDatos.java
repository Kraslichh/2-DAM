package clases;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;

public class CrearBaseDeDatos {

	public static void main(String[] args) throws SQLException {
		// TODO Esbozo de método generado automáticamente
		Connection conn=null; //creamos el objeto conexión
		Statement stmt=null; //Un Statement es una interfaz en Java 
		//utilizada para ejecutar instrucciones SQL en una base de datos 
		//a través de una conexión JDBC (Java Database Connectivity). 
		//En esencia, un Statement es una forma de enviar consultas 
		//SQL a la base de datos para realizar diversas operaciones, como recuperar 
		//datos, insertar registros, actualizar información o eliminar registros.
		String sql="CREATE DATABASE empresa";
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost/","root","");
			stmt=conn.createStatement();
			//La creación de un Statement en Java implica obtener una instancia de la interfaz Statement 
			//a partir de un objeto Connection
			stmt.execute(sql);
				System.out.println("La base de datos empresa ok");
				conn.close();
				stmt.close();
		}
		catch (SQLException e)
		{ e.printStackTrace(); //imprime informacion sobre la excepcion
				}	
		}
}



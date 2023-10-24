package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CrearTabla {
	public static void main(String[] args) throws Exception {
		// TODO Esbozo de método generado automáticamente
		Connection conn = null;
		Statement stmt = null;  	
		String sql="CREATE TABLE clientes (id INT PRIMARY KEY,"
				+ "nif VARCHAR(10) NOT NULL,"
				+ "nombre VARCHAR(60) NOT NULL, "
				+ "Edad VARCHAR(2))";   	 
		try {
		  conn = DriverManager.getConnection(
             "jdbc:mysql://localhost/empresa1","root","");
		  stmt = conn.createStatement();
		  stmt.execute(sql);
		  System.out.println("Creada la tabla clientes");
		  conn.close();
		  stmt.close();
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
	}
}

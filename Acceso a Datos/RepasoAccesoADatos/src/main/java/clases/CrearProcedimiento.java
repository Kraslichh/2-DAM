package clases;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class CrearProcedimiento {

	public static void main(String[] args) {
		Connection conn = null;
		 // creamos una interfaz preparedStatement
        // con el fin de preparar la instrucción sql que vamos a utilizar
		//sin esta interfaz no podemos ejecutar la sentencia sql
        PreparedStatement presta = null; 
        //definimos las variables string que son las sentencias que vamos a usar
        String dropProcedure = "DROP PROCEDURE IF EXISTS ObtenerClientes";
        String createProcedure = "CREATE PROCEDURE ObtenerClientes() " +
                "BEGIN " +
                "SELECT * FROM clientes;" +
                "END;";

        try {
        	//el objeto conexión
            conn = DriverManager.getConnection("jdbc:mysql://localhost/empresa", "root", "");
            
            // Primero, preparamos la sentencia 
            //este procedimiento lo borrará en el caso de que exita
            presta = conn.prepareStatement(dropProcedure);
            //ejecutamos el procedimiento
            presta.executeUpdate();

            // Luego, creamos el procedimiento
            //primero preparamos la sentencia con la instrucción que hemos creado
            //previamente
            presta = conn.prepareStatement(createProcedure);
            //lo ejecutamos
            presta.executeUpdate();

            System.out.println("Procedimiento creado");

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
}



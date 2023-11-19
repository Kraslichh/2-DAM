package clases;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class ConectarDb {

	public static void main(String[] args) throws SQLException {
		// TODO Esbozo de método generado automáticamente
		Connection conect=null;
		try {
			conect=DriverManager.
					getConnection("jdbc:mysql://localhost/empresa","root","");
			if (conect!=null) {
				System.out.println("Conexión a base de datos ok");
				conect.close();
			}
		}
		catch (SQLException e)
		{ System.out.println("Error en la conexión " +e.getMessage());
					
	
			}
			
			
		}
		
			
	}



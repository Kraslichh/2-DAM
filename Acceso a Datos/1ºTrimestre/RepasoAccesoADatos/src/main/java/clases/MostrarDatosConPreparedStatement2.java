package clases;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class MostrarDatosConPreparedStatement2 {

	public static void main(String[] args) throws SQLException {
		// TODO Esbozo de método generado automáticamente
		Connection conn=null;
		PreparedStatement preparedStatement = null;
		String sql="SELECT * FROM clientes";
		try {
			
			conn=DriverManager.getConnection("jdbc:mysql://localhost/empresa","root","");
			 preparedStatement = conn.prepareStatement(sql);
	         ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int id=rs.getInt("id");
				String nif=rs.getString("nif");
				String nombre=rs.getString("nombre");
				String edad=rs.getString("edad");
				System.out.println("id: "+id+" ,nif "+nif+ " ,nombre "+
							nombre+", edad "+edad);
			
			}		
				
				conn.close();
				preparedStatement.close();
				rs.close();
		}
		catch (SQLException e)
		{ e.printStackTrace();
					
	
			}
			
			
		}
		
			
	}


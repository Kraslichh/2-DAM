package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MostrarDatos {
  public static void main(String[] args) {
    Connection conn = null;
    Statement stmt = null;
    String sql = "SELECT * FROM clientes";
    try {
      conn = DriverManager.getConnection(
             "jdbc:mysql://localhost/empresa1","root","");
      stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {
        int id = rs.getInt("id");
        String nif = rs.getString("nif");
        String nombre = rs.getString("nombre");
        int edad = rs.getInt("edad");
        System.out.println("id: " + id + ", nif: " + nif + 
                           ", nombre: " + nombre + ", edad: " + edad);
      }
      rs.close();
      conn.close();
      stmt.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}

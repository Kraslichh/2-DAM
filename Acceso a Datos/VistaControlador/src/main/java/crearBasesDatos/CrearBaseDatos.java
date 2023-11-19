package crearBasesDatos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CrearBaseDatos {
//CrearBaseDatos Model.
    public void crearBaseDeDatos() {
        final String url = "jdbc:mysql://localhost:3306/";
        final String usuario = "root";
        final String contraseña = "";

        try (Connection conn = DriverManager.getConnection(url, usuario, contraseña)) {
            Statement stmt = conn.createStatement();

            String sql = "CREATE DATABASE IF NOT EXISTS empresa";

            stmt.executeUpdate(sql);
            System.out.println("Base de datos 'empresa' creada correctamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

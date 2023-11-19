package insertarDatospersonalizados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertarDatosPersonalizadosModel {

    public void insertarDatosEnTabla(String nombreTabla) {
        final String url = "jdbc:mysql://localhost:3306/empresa"; // Selecciona la base de datos 'empresa'
        final String usuario = "root";
        final String contraseña = "";

        try (Connection conn = DriverManager.getConnection(url, usuario, contraseña)) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Ingrese los datos separados por comas (por ejemplo: valor1, valor2, valor3):");
            String valores = scanner.nextLine();

            String[] valoresArray = valores.split(",\\s*");

            StringBuilder placeholders = new StringBuilder();
            for (int i = 0; i < valoresArray.length; i++) {
                placeholders.append("?");
                if (i < valoresArray.length - 1) {
                    placeholders.append(",");
                }
            }

            String sql = "INSERT INTO " + nombreTabla + " VALUES (" + placeholders + ")";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            for (int i = 0; i < valoresArray.length; i++) {
                pstmt.setString(i + 1, valoresArray[i]);
            }

            pstmt.executeUpdate();
            System.out.println("Datos insertados en la tabla '" + nombreTabla + "' correctamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

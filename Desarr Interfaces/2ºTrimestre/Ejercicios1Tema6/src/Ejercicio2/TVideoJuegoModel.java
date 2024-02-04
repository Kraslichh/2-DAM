package Ejercicio2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TVideoJuegoModel {
    private static ObservableList<TVideoJuego> videojuegosList = FXCollections.observableArrayList();
    private String dbURL = "jdbc:mysql://localhost:3306/ejercicios1tema6"; // Ajusta tu_base_de_datos
    private String dbUser = "root"; // Ajusta tu_usuario
    private String dbPassword = ""; // Ajusta tu_contraseña
    private Connection conn = null;

    // Constructor que recibe los parámetros de conexión
    public TVideoJuegoModel(String dbURL, String dbUser, String dbPassword) {
        this.dbURL = dbURL;
        this.dbUser = dbUser;
        this.dbPassword = dbPassword;
        loadVideojuegosFromDatabase();
    }

    public ObservableList<TVideoJuego> getVideojuegosList() {
        return videojuegosList;
    }
    public void addVideoJuego(TVideoJuego nuevoJuego) throws SQLException {
	    String query = "INSERT INTO tvideojuegos (nombre, anio, compania, precio, sinopsis, plataforma) VALUES (?, ?, ?, ?, ?, ?)";


	    try (PreparedStatement stmt = conn.prepareStatement(query)) {
	        stmt.setString(1, nuevoJuego.getNombre());
	        stmt.setInt(2, nuevoJuego.getAnio());
	        stmt.setString(3, nuevoJuego.getCompania());
	        stmt.setDouble(4, nuevoJuego.getPrecio());
	        stmt.setString(5, nuevoJuego.getSinopsis());
	        stmt.setString(6, nuevoJuego.getPlataforma());


	        stmt.executeUpdate();
	    }
	}

    // Método privado para cargar los videojuegos desde la base de datos
    void loadVideojuegosFromDatabase() {
        try {
            conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id, nombre, anio, compania, precio, sinopsis, plataforma FROM tvideojuegos");

            while (rs.next()) {
                TVideoJuego videojuego = new TVideoJuego(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getInt("anio"),
                        rs.getString("compania"),
                        rs.getDouble("precio"),
                        rs.getString("sinopsis"),
                        rs.getString("plataforma"));
                videojuegosList.add(videojuego);
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<TVideoJuego> getAllVideoJuegos() {
        return new ArrayList<>(videojuegosList);
    }

    public void close() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
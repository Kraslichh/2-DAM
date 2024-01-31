package reto;
import java.util.List;

public interface LibroDAO {
    void agregarLibro(Libro libro);
    Libro obtenerLibro(Long id);
    List<Libro> obtenerTodosLosLibros();
    void actualizarLibro(Libro libro);
    void eliminarLibro(Long id);
}
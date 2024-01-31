package reto;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Inicializar el DAO de Libros
        LibroDAO libroDAO = new LibroDAOImpl();

        // Crear un nuevo libro
        Libro nuevoLibro = new Libro("Título del Libro", "Autor del Libro", "Editorial XYZ", "1234567890", 2022);

        // Agregar el libro a la base de datos
        libroDAO.agregarLibro(nuevoLibro);
        System.out.println("Libro agregado: " + nuevoLibro);

        // Obtener un libro por su ID
        Long libroId = nuevoLibro.getId();
        Libro libroObtenido = libroDAO.obtenerLibro(libroId);
        System.out.println("Libro obtenido por ID: " + libroObtenido);

        // Obtener todos los libros
        List<Libro> todosLosLibros = libroDAO.obtenerTodosLosLibros();
        System.out.println("Todos los libros en la base de datos:");
        for (Libro libro : todosLosLibros) {
            System.out.println(libro);
        }

        // Actualizar un libro
        libroObtenido.setTitulo("Nuevo Título");
        libroObtenido.setAnioPublicacion(2023);
        libroDAO.actualizarLibro(libroObtenido);
        System.out.println("Libro actualizado: " + libroObtenido);

        // Eliminar un libro por su ID
        libroDAO.eliminarLibro(libroId);
        System.out.println("Libro eliminado con ID: " + libroId);

        // Obtener todos los libros después de la eliminación
        todosLosLibros = libroDAO.obtenerTodosLosLibros();
        System.out.println("Todos los libros en la base de datos después de la eliminación:");
        for (Libro libro : todosLosLibros) {
            System.out.println(libro);
        }

        // Cerrar la sesión de Hibernate
        HibernateUtil.shutdown();
    }
}
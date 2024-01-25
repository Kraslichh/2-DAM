package ejerciciosreto;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            // Crear y guardar entidades
            Autor autor = new Autor("Autor Ejemplo");
            Categoria categoria = new Categoria("Categoría Ejemplo");
            Cliente cliente = new Cliente("Cliente Ejemplo");
            session.save(autor);
            session.save(categoria);
            session.save(cliente);

            Set<Autor> autores = new HashSet<>();
            autores.add(autor);
            Set<Categoria> categorias = new HashSet<>();
            categorias.add(categoria);

            Libro libro = new Libro("Libro Ejemplo");
            libro.setAutores(autores);
            libro.setCategorias(categorias);
            session.save(libro);

            Pedido pedido = new Pedido(cliente);
            Set<Libro> librosPedido = new HashSet<>();
            librosPedido.add(libro);
            pedido.setLibros(librosPedido);
            session.save(pedido);

            // Consulta HQL para obtener todos los libros de un autor específico
            Query query = session.createQuery("from Libro l join l.autores a where a.nombre = :nombreAutor");
            query.setParameter("nombreAutor", "Autor Ejemplo");
            List<Libro> librosDeAutor = query.list();

            // Consulta HQL para obtener todos los libros en una categoría dada
            query = session.createQuery("from Libro l join l.categorias c where c.nombre = :nombreCategoria");
            query.setParameter("nombreCategoria", "Categoría Ejemplo");
            List<Libro> librosEnCategoria = query.list();

            // Consulta HQL para obtener el historial de pedidos de un cliente
            query = session.createQuery("from Pedido p where p.cliente.nombre = :nombreCliente");
            query.setParameter("nombreCliente", "Cliente Ejemplo");
            List<Pedido> pedidosCliente = query.list();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}

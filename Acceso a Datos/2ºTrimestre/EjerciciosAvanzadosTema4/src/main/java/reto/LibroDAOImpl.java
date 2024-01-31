package reto;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class LibroDAOImpl implements LibroDAO {

    @Override
    public void agregarLibro(Libro libro) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(libro);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public Libro obtenerLibro(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Libro.class, id);
        }
    }

    @Override
    public List<Libro> obtenerTodosLosLibros() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Libro", Libro.class).list();
        }
    }

    @Override
    public void actualizarLibro(Libro libro) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(libro);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarLibro(Long id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Libro libro = session.get(Libro.class, id);
            if (libro != null) {
                transaction = session.beginTransaction();
                session.delete(libro);
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
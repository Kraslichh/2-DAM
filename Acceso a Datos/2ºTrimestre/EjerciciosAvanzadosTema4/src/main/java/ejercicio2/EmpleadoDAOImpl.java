package ejercicio2;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class EmpleadoDAOImpl implements EmpleadoDAO {

    @Override
    public void agregarEmpleado(Empleado empleado) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(empleado);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public Empleado obtenerEmpleado(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Empleado.class, id);
        }
    }

    @Override
    public List<Empleado> obtenerTodosLosEmpleados() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Empleado", Empleado.class).list();
        }
    }

    @Override
    public void actualizarEmpleado(Empleado empleado) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(empleado);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarEmpleado(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.buildSessionFactory().openSession()) {
            Empleado empleado = session.get(Empleado.class, id);
            if (empleado != null) {
                transaction = session.beginTransaction();
                session.delete(empleado);
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
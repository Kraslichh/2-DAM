package ejercicio3;


import org.hibernate.Session;
import org.hibernate.Transaction;

public class EmpleadoCRUD {

    // Método para insertar un empleado
    public void insertarEmpleado(Empleado empleado) {
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

    // Método para obtener un empleado por su ID
    public Empleado obtenerEmpleado(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Empleado.class, id);
        }
    }

    // Método para actualizar un empleado
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

    // Método para eliminar un empleado
    public void eliminarEmpleado(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
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

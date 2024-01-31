package conversiones1;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class EliminarRegistros {

    public static void eliminarEmpresa(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Empresa empresa = session.get(Empresa.class, id);
            if (empresa != null) {
                session.delete(empresa);
            }

            transaction.commit();
            System.out.println("Registro eliminado correctamente.");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        eliminarEmpresa(2);
    }
}

package conversiones1;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class InsertarRegistros {

    public static void insertarEmpresa(int id, String nombre, String pais) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Empresa empresa = new Empresa(id, nombre, pais);
            session.save(empresa);

            transaction.commit();
            System.out.println("Registro insertado correctamente.");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        insertarEmpresa(1, "Informática", "Portátiles");
        insertarEmpresa(2, "Alimentación", "Verduras");
    }
}

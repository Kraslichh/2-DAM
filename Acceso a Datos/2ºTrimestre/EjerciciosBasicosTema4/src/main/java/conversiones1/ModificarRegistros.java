package conversiones1;


import org.hibernate.Session;
import org.hibernate.Transaction;

public class ModificarRegistros {

    public static void modificarEmpresa(int id, String nuevoPais) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Empresa empresa = session.get(Empresa.class, id);
            if (empresa != null) {
                empresa.setPais(nuevoPais);
                session.update(empresa);
            }

            transaction.commit();
            System.out.println("Registro modificado correctamente.");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        modificarEmpresa(2, "Monitores");
    }
}

package conversiones1;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class CrearTabla {
    
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            // Aquí puedes realizar operaciones de creación de tablas o insertar datos.
            // Por ejemplo, insertamos un objeto Empresa
            Empresa nuevaEmpresa = new Empresa(1, "NombreEmpresa", "PaísEmpresa");
            session.save(nuevaEmpresa);

            // Comprometemos la transacción
            transaction.commit();
            System.out.println("Tabla 'empresa' creada con éxito y datos insertados.");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
            HibernateUtil.shutdown();
        }
    }
}
package ejercicios;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Productos {

    public static void main(String[] args) {
        SessionFactory sessionFactory = null;
        Transaction transaction = null;
        try {
            sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
            Session session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            // Crear objeto Fabricante
            Fabricante fabricante = new Fabricante("Fabricante XYZ");
            session.save(fabricante);

            // Crear y guardar un objeto Producto
            Producto producto = new Producto("Producto ABC", 0, fabricante);
            session.save(producto);

            transaction.commit();
            System.out.println("Producto guardado: " + producto);

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (sessionFactory != null) {
                sessionFactory.close();
            }
        }
    }
}

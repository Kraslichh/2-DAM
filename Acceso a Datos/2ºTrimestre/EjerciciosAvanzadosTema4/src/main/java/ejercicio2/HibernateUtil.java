package ejercicio2;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    static SessionFactory buildSessionFactory() {
        try {
            // Crea la SessionFactory desde hibernate.cfg.xml
            return new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Muestra un mensaje de error en caso de fallo
            System.err.println("La creación inicial de SessionFactory falló." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        // Cierra los caches y pools de conexiones
        getSessionFactory().close();
    }
}
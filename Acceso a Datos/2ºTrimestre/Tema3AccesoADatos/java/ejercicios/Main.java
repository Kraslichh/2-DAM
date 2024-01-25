package ejercicios;

import java.math.BigDecimal;
import java.sql.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {
        // Configurar la sesión de Hibernate
        SessionFactory sessionFactory = new Configuration()
                .configure() // Carga el archivo de configuración hibernate.cfg.xml
                .addAnnotatedClass(Fabricante.class) // Asegúrate de que estas clases también estén mapeadas
                .addAnnotatedClass(Producto.class)
                .addAnnotatedClass(Compra.class)
                .addAnnotatedClass(Juego.class) // Añade la clase Juego a la configuración
                .buildSessionFactory();

        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            // FABRICANTE
            Fabricante fabricante = new Fabricante("pc gaming3");
            session.save(fabricante);

            // PRODUCTO
            Producto producto = new Producto("PORTATIL gaming3", 3000.00, fabricante);
            session.save(producto);

            // COMPRAS
            Compra compra = new Compra(Date.valueOf("2024-01-03"), 1, producto);
            session.save(compra);

         // JUEGO
            Juego juego = new Juego("World of Wordcraft", 2010, "Blizzard", new BigDecimal("80.00"), "Pedazo de juego", "todas");
            session.save(juego);


            // Commit de la transacción
            transaction.commit();

            // Impresión de los objetos para verificar
            System.out.println(producto.toString());
            System.out.println(fabricante.toString());
            System.out.println(compra.toString());
            System.out.println(juego.toString()); // Imprimir el juego

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
            sessionFactory.close();
        }
    }
}

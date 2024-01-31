package ejercicio1;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class EmpresaDAOHibernate implements EmpresaDAO {

    @Override
    public void agregarEmpresa(Empresa empresa) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(empresa);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void actualizarEmpresa(Empresa empresa) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(empresa);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarEmpresa(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Empresa empresa = session.get(Empresa.class, id);
            if (empresa != null) {
                transaction = session.beginTransaction();
                session.delete(empresa);
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public Empresa obtenerEmpresa(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Empresa.class, id);
        }
    }

    @Override
    public List<Empresa> obtenerTodasLasEmpresas() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Empresa", Empresa.class).list();
        }
    }
}

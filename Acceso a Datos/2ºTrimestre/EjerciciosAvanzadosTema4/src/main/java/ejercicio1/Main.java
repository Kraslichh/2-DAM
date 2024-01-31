package ejercicio1;
public class Main {

    public static void main(String[] args) {
        EmpresaDAO empresaDAO = new EmpresaDAOHibernate();

        // Crear y agregar una nueva empresa
        Empresa nuevaEmpresa = new Empresa();
        nuevaEmpresa.setNombre("Ejemplo S.A.");
        nuevaEmpresa.setPais("España");
        empresaDAO.agregarEmpresa(nuevaEmpresa);

        // Actualizar una empresa
        Empresa empresaExistente = empresaDAO.obtenerEmpresa(1);
        if (empresaExistente != null) {
            empresaExistente.setNombre("Nombre Actualizado");
            empresaDAO.actualizarEmpresa(empresaExistente);
        }

        // Mostrar todas las empresas
        for (Empresa empresa : empresaDAO.obtenerTodasLasEmpresas()) {
            System.out.println(empresa);
        }

        // Eliminar una empresa
        empresaDAO.eliminarEmpresa(1);

        // Cerrar la sesión de Hibernate
        HibernateUtil.shutdown();
    }
}
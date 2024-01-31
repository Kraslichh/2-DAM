package ejercicio2;

public class Main {

    public static void main(String[] args) {
        EmpleadoDAO empleadoDAO = new EmpleadoDAOImpl();

        // Crear y agregar un nuevo empleado
        Empleado nuevoEmpleado = new Empleado("Juan Pérez", "Desarrollo", 30000);
        empleadoDAO.agregarEmpleado(nuevoEmpleado);
        System.out.println("Empleado agregado: " + nuevoEmpleado);

        // Obtener y mostrar un empleado
        Empleado empleadoRecuperado = empleadoDAO.obtenerEmpleado(nuevoEmpleado.getId());
        if (empleadoRecuperado != null) {
            System.out.println("Empleado recuperado: " + empleadoRecuperado);
        }

        // Actualizar un empleado
        if (empleadoRecuperado != null) {
            empleadoRecuperado.setSalario(32000);
            empleadoDAO.actualizarEmpleado(empleadoRecuperado);
            Empleado empleadoActualizado = empleadoDAO.obtenerEmpleado(empleadoRecuperado.getId());
            System.out.println("Empleado actualizado: " + empleadoActualizado);
        }

        // Eliminar un empleado
        if (empleadoRecuperado != null) {
            empleadoDAO.eliminarEmpleado(empleadoRecuperado.getId());
            System.out.println("Empleado con ID " + empleadoRecuperado.getId() + " ha sido eliminado.");
        }

        // Listar todos los empleados
        System.out.println("Lista de empleados:");
        for (Empleado empleado : empleadoDAO.obtenerTodosLosEmpleados()) {
            System.out.println(empleado);
        }

        // Cerrar la sesión de Hibernate
        HibernateUtil.shutdown();
    }
}

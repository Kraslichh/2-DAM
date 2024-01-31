package ejercicio3;

public class Main {

    public static void main(String[] args) {
        EmpleadoCRUD empleadoCRUD = new EmpleadoCRUD();

        // Crear y añadir un nuevo empleado
        Empleado nuevoEmpleado = new Empleado("Juan Pérez", "Desarrollo", 30000);
        empleadoCRUD.insertarEmpleado(nuevoEmpleado);
        System.out.println("Empleado insertado: " + nuevoEmpleado);

        // Obtener y mostrar un empleado
        Empleado empleadoRecuperado = empleadoCRUD.obtenerEmpleado(nuevoEmpleado.getId());
        if (empleadoRecuperado != null) {
            System.out.println("Empleado recuperado: " + empleadoRecuperado);
        }

        // Actualizar un empleado
        if (empleadoRecuperado != null) {
            empleadoRecuperado.setSalario(32000);
            empleadoCRUD.actualizarEmpleado(empleadoRecuperado);
            Empleado empleadoActualizado = empleadoCRUD.obtenerEmpleado(empleadoRecuperado.getId());
            System.out.println("Empleado actualizado: " + empleadoActualizado);
        }

        // Eliminar un empleado
        if (empleadoRecuperado != null) {
            empleadoCRUD.eliminarEmpleado(empleadoRecuperado.getId());
            System.out.println("Empleado con ID " + empleadoRecuperado.getId() + " ha sido eliminado.");
        }
    }
}
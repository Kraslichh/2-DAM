package clases;
import java.util.List;

public class EmpleadoView {
    // Método para mostrar los empleados en la vista
    public void mostrarEmpleado(List<Empleados> empleados) {
        for (Empleados empleado : empleados) {
            System.out.println("ID: " + empleado.getId());
            System.out.println("NIF: " + empleado.getNombre());
            System.out.println("Nombre: " + empleado.getApellido());
            System.out.println("Edad: " + empleado.getDni());
            System.out.println();
        }
    }
}

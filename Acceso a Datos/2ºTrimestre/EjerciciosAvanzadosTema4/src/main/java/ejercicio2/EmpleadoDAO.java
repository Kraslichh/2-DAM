package ejercicio2;


import java.util.List;

public interface EmpleadoDAO {
    void agregarEmpleado(Empleado empleado);
    Empleado obtenerEmpleado(int id);
    List<Empleado> obtenerTodosLosEmpleados();
    void actualizarEmpleado(Empleado empleado);
    void eliminarEmpleado(int id);
}

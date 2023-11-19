package insertarClientes;
import java.util.List;

public class InsertarClienteView {
    // Método para mostrar la inserción de clientes en la vista
    public void mostrarInsercionClientes(List<InsertarCliente> clientes) {
        for (InsertarCliente cliente : clientes) {
            System.out.println("Nombre: " + cliente.getNombre());
            System.out.println("Email: " + cliente.getEdad());
            System.out.println("----- Cliente insertado -----");
            System.out.println();
        }
    }
}

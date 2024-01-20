package insertarClientes;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	

    	
    	public static void main(String[] args) {
    	    Scanner scanner = new Scanner(System.in);

            String dbURL = "jdbc:mysql://localhost/empresa"; // URL de la base de datos
            String dbUser = "root"; // Usuario de la base de datos
            String dbPassword = ""; // Contraseña del usuario
            
    	    // Crear una instancia de la vista
    	    InsertarClienteView view = new InsertarClienteView();

    	    // Crear una instancia del modelo (proporciona la conexión a la base de datos)
    	    InsertarClienteController modelo = new InsertarClienteController("jdbc:mysql://localhost:3306/empresa", "root", "");

    	    // Crear una instancia del controlador (pasando el modelo y la vista)
    	    InsertarClienteController controller = new InsertarClienteController(modelo, view);
      

        List<InsertarCliente> clientes = new ArrayList<>();

        // Solicitar datos del cliente al usuario
        System.out.println("Ingrese los datos del cliente (id, nif, nombre, edad) o 'fin' para terminar:");
        while (true) {
            System.out.print("ID: ");
            String id = scanner.nextLine();
            if (id.equalsIgnoreCase("fin")) {
                break;
            }
            
            System.out.print("NIF: ");
            String nif = scanner.nextLine();
            
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Edad: ");
            String edad = scanner.nextLine();

            // Crear instancia de cliente y agregar a la lista
            InsertarCliente cliente = new InsertarCliente(Integer.parseInt(id), nif, nombre, edad);
            clientes.add(cliente);
        }

        // Insertar clientes en la base de datos a través del controlador
        controller.insertarClientes(clientes);

        // Mostrar la inserción de clientes en la vista
        view.mostrarInsercionClientes(clientes);

        scanner.close();
    }
}



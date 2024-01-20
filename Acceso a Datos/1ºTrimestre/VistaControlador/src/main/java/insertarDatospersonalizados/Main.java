package insertarDatospersonalizados;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InsertarDatosPersonalizadosView vista = new InsertarDatosPersonalizadosView();
        InsertarDatosPersonalizadosModel modelo = new InsertarDatosPersonalizadosModel();
        InsertarDatosPersonalizadosController controlador = new InsertarDatosPersonalizadosController(vista, modelo);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre de la tabla en la que desea insertar datos:");
        String nombreTabla = scanner.nextLine();

        controlador.insertarDatosEnTabla(nombreTabla);
    }
}

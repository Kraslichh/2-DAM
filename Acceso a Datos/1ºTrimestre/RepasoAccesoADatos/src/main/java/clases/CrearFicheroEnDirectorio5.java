package clases;

import java.io.File;
import java.io.IOException;

public class CrearFicheroEnDirectorio5 {
    public static void main(String[] args) {
        String ruta = ".\\src\\ficheros\\ejercicio1";
        String nombreFichero = "fichero1.txt"; // Nombre del fichero que deseas crear

        // Combinar la ruta del directorio con el nombre del fichero
        String rutaFichero = ruta + File.separator + nombreFichero;

        File fichero = new File(rutaFichero);

        if (fichero.exists()) {
            System.out.println("El fichero ya existe.");
        } else {
            try {
                boolean creado = fichero.createNewFile();
                if (creado) {
                    System.out.println("El fichero ha sido creado con �xito.");
                } else {
                    System.out.println("No se pudo crear el fichero.");
                }
            } catch (IOException e) {
                System.out.println("Error al crear el fichero: " + e.getMessage());
            }
        }
    }
}

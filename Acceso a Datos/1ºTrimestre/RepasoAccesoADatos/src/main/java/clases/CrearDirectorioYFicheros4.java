package clases;

import java.io.File;
import java.io.IOException;

public class CrearDirectorioYFicheros4 {
    public static void main(String[] args) {
        // Nombre del directorio que queremos crear
        String nombreDirectorio = "NEWDIREC";

        // Directorio actual
        String directorioActual = System.getProperty("user.dir");

        // Crear un objeto File para el directorio
        File directorio = new File(directorioActual, nombreDirectorio);

        // Comprobar si el directorio ya existe
        if (!directorio.exists()) {
            // Crear el directorio
            boolean directorioCreado = directorio.mkdir();
            if (directorioCreado) {
                System.out.println("Directorio creado correctamente: " + directorio.getAbsolutePath());
            } else {
                System.out.println("No se pudo crear el directorio.");
                return;
            }
        }

        // Crear ficheros en el directorio
        File fichero1 = new File(directorio, "fichero1.txt");
        File fichero2 = new File(directorio, "fichero2.txt");

        try {
            // Crear los ficheros
            boolean fichero1Creado = fichero1.createNewFile();
            boolean fichero2Creado = fichero2.createNewFile();

            if (fichero1Creado && fichero2Creado) {
                System.out.println("Ficheros creados correctamente.");
            } else {
                System.out.println("No se pudieron crear los ficheros.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Renombrar un fichero
        File ficheroARenombrar = new File(directorio, "fichero1.txt");
        File ficheroRenombrado = new File(directorio, "nuevoNombre.txt");

        if (ficheroARenombrar.exists()) {
            boolean ficheroRenombradoExitosamente = ficheroARenombrar.renameTo(ficheroRenombrado);
            if (ficheroRenombradoExitosamente) {
                System.out.println("Fichero renombrado correctamente.");
            } else {
                System.out.println("No se pudo renombrar el fichero.");
            }
        } else {
            System.out.println("El fichero a renombrar no existe.");
        }
    }
}

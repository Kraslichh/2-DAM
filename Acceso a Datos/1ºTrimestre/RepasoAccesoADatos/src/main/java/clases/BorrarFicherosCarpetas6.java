package clases;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BorrarFicherosCarpetas6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String opcion;
        String ruta = "C:\\prueba\\";

        try {
            do {
                System.out.println("Seleccione una opción:");
                System.out.println("A - Crear carpeta");
                System.out.println("B - Borrar carpeta");
                System.out.println("C - Salir");

                opcion = scanner.nextLine();

                switch (opcion) {
                    case "A":
                        System.out.println("Introduzca el nombre de la carpeta:");
                        String nombreCarpeta = scanner.nextLine();
                        File carpeta = new File(ruta + nombreCarpeta);

                        if (!carpeta.exists()) {
                            if (carpeta.mkdirs()) {
                                System.out.println("La carpeta " + nombreCarpeta + " se ha creado correctamente.");

                                try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta + nombreCarpeta + "\\" + nombreCarpeta + ".txt"))) {
                                    bw.write("Contenido para " + nombreCarpeta);
                                    System.out.println("Fichero creado");
                                } catch (IOException e) {
                                    System.out.println("No se ha podido escribir en el fichero");
                                }
                            } else {
                                System.out.println("Error al crear la carpeta.");
                            }
                        } else {
                            System.out.println("La carpeta " + nombreCarpeta + " ya existe.");
                        }
                        break;

                    case "B":
                        System.out.println("Introduzca el nombre de la carpeta que desea borrar:");
                        String nombreCarpetaBorrar = scanner.nextLine();
                        File carpetaBorrar = new File(ruta + nombreCarpetaBorrar);

                        if (carpetaBorrar.exists()) {
                            if (borrarDirectorio(carpetaBorrar)) {
                                System.out.println("La carpeta " + nombreCarpetaBorrar + " se ha borrado correctamente.");
                            } else {
                                System.out.println("Error al borrar la carpeta.");
                            }
                        } else {
                            System.out.println("La carpeta " + nombreCarpetaBorrar + " no existe.");
                        }
                        break;

                    case "C":
                        System.out.println("Saliendo...");
                        break;

                    default:
                        System.out.println("Opción inválida.");
                        break;
                }

            } while (!opcion.equals("C"));
        } finally {
            scanner.close();
        }
    }

    // Método para borrar un directorio recursivamente
    private static boolean borrarDirectorio(File directorio) {
        if (directorio.isDirectory()) {
            File[] archivos = directorio.listFiles();
            if (archivos != null) {
                for (File archivo : archivos) {
                    borrarDirectorio(archivo);
                }
            }
        }
        return directorio.delete();
    }
}


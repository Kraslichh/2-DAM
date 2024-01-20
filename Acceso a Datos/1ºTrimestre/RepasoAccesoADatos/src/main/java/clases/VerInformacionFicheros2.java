package clases;

import java.io.*;
public class VerInformacionFicheros2 {
public static void main(String[] args) {
  System.out.println("INFORMACI�N SOBRE EL FICHERO:");
  File f = new File(".\\src\\ficheros\\VerInformacionFicheros.java");
   if(f.exists()){
        System.out.println("Nombre del fichero  : "+f.getName());
        System.out.println("Ruta                : "+f.getPath());
        System.out.println("Ruta absoluta       : "+f.getAbsolutePath());
        System.out.println("Lectura       : "+f.canRead());
        System.out.println("Escritura   : "+f.canWrite());
        System.out.println("Tama�o              : "+f.length()+ " Kb"); // El tama�o es expresado en bytes
		System.out.println("Directorio    : "+f.isDirectory()); 
		System.out.println("Fichero       : "+f.isFile());
		System.out.println("Nombre del directorio padre: "+f.getParent());
  }
 }
}


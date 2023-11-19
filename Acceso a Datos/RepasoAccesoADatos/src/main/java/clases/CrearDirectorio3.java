package clases;

import java.io.File;

public class CrearDirectorio3 {
	public static void main(String[] args) {
		String ruta=".\\src\\ficheros\\";
		String carpeta = "ejercicio1";
		File directorio = new File(ruta+carpeta);
		if (directorio.exists()==true) {
			System.out.println("la carpeta existe idiota");
		} else {
		directorio.mkdir();
		System.out.println("carpeta creada");
		}
	}
	
}
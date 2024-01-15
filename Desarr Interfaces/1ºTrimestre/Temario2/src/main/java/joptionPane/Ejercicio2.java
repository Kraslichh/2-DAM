package joptionPane;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ejercicio2 {

	public static void main(String[] args) {
		JFrame ventana= new JFrame("Mi primera ventana");
		//tamaño de la ventana del programa
		ventana.setSize(400,400);
		//Esto es para que cuando le demos a la X se cierre el programa sino lo hacemos
		//al darle a la X se quedara el programa en segundo plano.
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Esto para es crear un texto en la ventana del programa.
		JLabel texto=new JLabel("Hola Maxi");
		//aqui agregamos a la ventana la variable texto con el .add
		ventana.getContentPane().add(texto);
		
		
		
		
		
		
		
		
		//Esto seria para que se viera la ventana
		ventana.setVisible(true);		
	}

}

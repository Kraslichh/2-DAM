package jOptionPanel;
import javax.swing.JOptionPane;
public class JOptionPanel3 {

	public static void main(String[] args) {
		String nombre = JOptionPane.showInputDialog(null,"Dime tu nombre", "Datos personales", JOptionPane.QUESTION_MESSAGE);
		
		//Hacemos un pequeño bucle condicional con if para que se lea el nombre del cliente sino que salga un mensaje 
		//Diciendo le has dado a cancelar.
		if (nombre!=null) {
		System.out.println("Respuesta del usuario: "+ nombre );
		
		}else {
			System.out.println("Le has dado a cancelar");
		}

	}

}

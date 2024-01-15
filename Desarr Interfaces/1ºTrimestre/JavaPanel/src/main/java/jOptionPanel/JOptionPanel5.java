package jOptionPanel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class JOptionPanel5 {

	public static void main(String[] args) {
		//Declaracion de los botones y lo que pone dentro
		UIManager.put("OptionPane.yesButtonText", "Si");
		UIManager.put("OptionPane.noButtonText", "No");
		UIManager.put("OptionPane.cancelButtonText", "Cancelar");
		//declaracion de variable que almacenara el nombre del usuario
		String nombre = JOptionPane.showInputDialog(null,"Dime tu nombre", "Datos personales", JOptionPane.QUESTION_MESSAGE);
		//Hacemos un pequeño bucle condicional con if para que se lea el nombre del usuario sino que salga un mensaje 
		//Diciendo le has dado a cancelar.
		if (nombre!=null) {
		System.out.println("Respuesta del usuario: "+ nombre );
		
		}else {
			System.out.println("Le has dado a cancelar");
		}
		//Aqui realizamos otro tipo de JOptionPane , en esta preguntaremos basicamente si o no con una ventanita como todas
		float codigo=JOptionPane.showConfirmDialog(null, "¿Te gustaria crear un script para unity?", "Developer",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.INFORMATION_MESSAGE);
		//Solamente si le damos a que si saldran estas opciones
		if(codigo==JOptionPane.YES_OPTION) {
			System.out.println(nombre+", Ya estamos mas cerca de cumplir mi sueño");
			int opcion=JOptionPane.showConfirmDialog(null, "¿Estas seguro?", "Confirmar", JOptionPane.YES_NO_CANCEL_OPTION);
			
			if(opcion==JOptionPane.YES_OPTION) {
				JOptionPane.showMessageDialog(null, "Has elegido Sí.");
				
			}else if (opcion==JOptionPane.NO_OPTION) {
				JOptionPane.showMessageDialog(null, "Has elegido No.");
			}else {
				JOptionPane.showMessageDialog(null, "Has cancelado la accion");
			}
			//En el caso de que digas que no saltara directamente aqui
		}else if(codigo==JOptionPane.NO_OPTION) {
			System.out.println("Jo.. Ahora estoy mas lejos de mi sueño me tocara usar chat gpt");
			//Y si le das a cancelar o la x de la ventana saldra este mensajito de aqui :)
		}else {
			System.out.println("Has cancelado la creacion de un script :(");
		}
		//FIN
	}

}

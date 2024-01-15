package jOptionPanel;
import javax.swing.JOptionPane;
public class JOptionPanel {

	public static void main(String[] args) {
		int codigo=JOptionPane.showConfirmDialog(null, "¿Quieres un eurito para poder pagar la mensualidad del wow?", "Donacion",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.INFORMATION_MESSAGE);
		
		if(codigo==JOptionPane.YES_OPTION) {
			System.out.println("Ya estamos mas cerca de la mensualidad del wow");
		}else if(codigo==JOptionPane.NO_OPTION) {
			System.out.println("Jo.. Ahora estoy mas lejos de tener la mensualidad del wow, tendre que farmear oro");
		}else {
			System.out.println("Has cancelado la donacion a maximiliam para que tenga el wow un mes mas :(");
		}
		

	}

}

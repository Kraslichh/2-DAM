package jOptionPanel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
public class JOptionPanel4 {

	public static void main(String[] args) {
		UIManager.put("OptionPane.yesButtonText", "Si");
		UIManager.put("OptionPane.noButtonText", "No");
		UIManager.put("OptionPane.cancelButtonText", "Cancelar");

		
		
		int opcion=JOptionPane.showConfirmDialog(null, "¿Quieres continuar?", "Confirmar", JOptionPane.YES_NO_CANCEL_OPTION);
		
		if(opcion==JOptionPane.YES_OPTION) {
			JOptionPane.showMessageDialog(null, "Has elegido Sí.");
			
		}else if (opcion==JOptionPane.NO_OPTION) {
			JOptionPane.showMessageDialog(null, "Has elegido No.");
		}else {
			JOptionPane.showMessageDialog(null, "Has cancelado la accion");
		}
	}

}

package jOptionPanel;
import javax.swing.JOptionPane;
public class JOptionPanelRepaso {
	
	public static void main(String[] args) {
		String nombre = JOptionPane.showInputDialog(null,"Lok’tar Ogar, dime tu nombre", "Nuevo personaje de la horda",
				JOptionPane.QUESTION_MESSAGE);
		//Con cariño al wow por todos esos años de fidelidad hacia el juego tambien aqui jajajaja WOW hasta la sopa
	if(nombre!=null) {
		System.out.println("Bienvenid@ jef@ de guerra " +nombre+", que los espiritus te guien");
	}else {
		System.out.println("Necesito que me digas tu nombre jef@ de guerra sino no podremos combatir a la alianza.");
	}
	}

}

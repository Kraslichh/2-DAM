import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana4Jframe {
    private JFrame ventana;
    private JPanel panel;
    private JButton[] botones;

    private void inicializarVentana() {
        ventana = new JFrame("Mi Ventana");
        ventana.setSize(400, 300);
        ventana.setVisible(true);

        panel = new JPanel();
        panel.setLayout(null);
        ventana.getContentPane().add(panel);

        botones = new JButton[3];
        agregarBotonesConBucle(3);
    }

    private void agregarBotonesConBucle(int cantidad) {
        String[] nombres = {"Aceptar", "Cancelar", "Cerrar"};
        int x = 50;

        for (int i = 0; i < cantidad; i++) {
            botones[i] = new JButton(nombres[i]);
            botones[i].setBounds(x, 50, 100, 30);
            panel.add(botones[i]);

            final String nombreBoton = nombres[i];
            botones[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    mostrarMensajeVentana("Has pulsado " + nombreBoton);
                }
            });

            x += 120;
        }
    }

    private void mostrarMensajeVentana(String mensaje) {
        JFrame mensajeVentana = new JFrame("Mensaje");
        mensajeVentana.setSize(300, 100);
        mensajeVentana.setVisible(true);
        mensajeVentana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel mensajePanel = new JPanel();
        mensajePanel.setLayout(null);
        mensajeVentana.getContentPane().add(mensajePanel);

        JLabel mensajeLabel = new JLabel(mensaje);
        mensajeLabel.setBounds(50, 20, 200, 30);
        mensajePanel.add(mensajeLabel);
    }

    public static void main(String[] args) {
        Ventana4Jframe miClase = new Ventana4Jframe();
        miClase.inicializarVentana();
    }
}

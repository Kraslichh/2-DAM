import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ejercicio2 {
    private JFrame ventana;
    private JPanel panel;
    private JButton[] botones;

    private void inicializarVentana() {
        ventana = new JFrame("Ejercicio2");
        ventana.setSize(300, 300);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);
        ventana.getContentPane().add(panel);

        botones = new JButton[5]; // Añadimos espacio para el botón "Redimensionar"
        agregarBotonesConBucle(5); // Actualizamos la cantidad de botones
    }

    private void agregarBotonesConBucle(int cantidad) {
        String[] nombres = {"Continuar", "Volver", "Quitar", "Siguiente", "Redimensionar"};
        int x = 50;
        int y = 80;

        for (int i = 0; i < cantidad; i++) {
            botones[i] = new JButton(nombres[i]);
            botones[i].setBounds(x, y, 100, 30);
            panel.add(botones[i]);

            final String nombreBoton = nombres[i];
            botones[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (nombreBoton.equals("Redimensionar")) {
                        mostrarMensajeVentanaRedimensionar("Has pulsado el botón de redimensionar");
                    } else {
                        mostrarMensajeVentana("Has pulsado " + nombreBoton);
                    }
                }
            });

            y += 40;
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

    private void mostrarMensajeVentanaRedimensionar(String mensaje) {
        JFrame mensajeVentana = new JFrame("Mensaje de Redimensionar");
        mensajeVentana.setSize(400, 400);
        mensajeVentana.setVisible(true);
        mensajeVentana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel mensajePanel = new JPanel();
        mensajePanel.setLayout(null);
        mensajeVentana.getContentPane().add(mensajePanel);

        JLabel mensajeLabel = new JLabel(mensaje);
        mensajeLabel.setBounds(50, 20, 300, 30);
        mensajePanel.add(mensajeLabel);
    }

    public static void main(String[] args) {
        Ejercicio2 miClase = new Ejercicio2();
        miClase.inicializarVentana();
    }
}

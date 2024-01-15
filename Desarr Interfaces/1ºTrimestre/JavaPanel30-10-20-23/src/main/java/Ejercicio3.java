import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ejercicio3 {
    private JFrame ventana;
    private JPanel panelBotones;
    private JPanel panelMensaje;
    private JLabel mensajePrincipal;
    private JLabel mensajeSecundario;
    private JButton[] botones;

    public Ejercicio3() {
        ventana = new JFrame("Ejercicio Swing");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear el panel de botones
        panelBotones = new JPanel();
        botones = new JButton[3]; // Cambia la cantidad de botones según tu necesidad

        for (int i = 0; i < botones.length; i++) {
            botones[i] = new JButton("Botón " + (i + 1));
            botones[i].addActionListener(new BotonListener());
            panelBotones.add(botones[i]);
        }

        // Crear el panel del mensaje
        panelMensaje = new JPanel();
        mensajePrincipal = new JLabel("Pulsa un botón");
        mensajeSecundario = new JLabel(""); // Nuevo JLabel para mostrar mensajes secundarios

        // Configuración de los paneles
        panelBotones.setLayout(new FlowLayout());
        panelMensaje.setLayout(new GridLayout(2, 1));

        // Agregar componentes a la ventana
        panelMensaje.add(mensajePrincipal);
        panelMensaje.add(mensajeSecundario);
        ventana.setLayout(new BorderLayout());
        ventana.add(panelBotones, BorderLayout.NORTH);
        ventana.add(panelMensaje, BorderLayout.CENTER);

        ventana.pack();
        ventana.setVisible(true);
    }

    private class BotonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton botonPulsado = (JButton) e.getSource();
            String nombreBoton = botonPulsado.getText();
            mensajePrincipal.setText("Has pulsado el botón: " + nombreBoton);

            // Actualizar el mensaje secundario
            String mensajeSecundarioNuevo = "Mensaje diferente para " + nombreBoton;
            mensajeSecundario.setText(mensajeSecundarioNuevo);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Ejercicio3();
            }
        });
    }
}

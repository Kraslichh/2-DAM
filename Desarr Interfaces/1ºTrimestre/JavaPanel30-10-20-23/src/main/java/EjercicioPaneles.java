import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EjercicioPaneles {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createGUI();
        });
    }

    private static void createGUI() {
        JFrame frame = new JFrame("Contenedores con JPanel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new FlowLayout(FlowLayout.CENTER));
        frame.add(panelSuperior, BorderLayout.NORTH);

        JLabel mensajeLabel = new JLabel("Mensaje: ");
        mensajeLabel.setFont(new Font("Serif", Font.BOLD, 20));
        panelSuperior.add(mensajeLabel);

        JLabel mensajeBoton = new JLabel(""); // Nuevo JLabel para mostrar el mensaje del botón
        panelSuperior.add(mensajeBoton);

        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new FlowLayout());
        frame.add(panelCentral, BorderLayout.CENTER);

        for (int i = 1; i <= 3; i++) {
            JButton button = new JButton("Boton " + i);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton source = (JButton) e.getSource();
                    String mensaje = source.getText(); // Obtener el texto del botón
                    mensajeBoton.setText(mensaje); // Actualizar el JLabel con el mensaje
                }
            });

            JLabel label = new JLabel("Etiqueta " + i);
            panelCentral.add(button);
            panelCentral.add(label);

            if (i != 3) {
                panelCentral.add(Box.createRigidArea(new Dimension(20, 0))); // Espacio entre los botones
            }
        }

        frame.pack();
        frame.setVisible(true);
    }
}

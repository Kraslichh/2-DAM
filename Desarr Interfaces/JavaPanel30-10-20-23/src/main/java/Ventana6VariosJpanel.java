import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana6VariosJpanel extends JFrame {
    private JLabel etiquetaBienvenida;
    private JLabel etiquetaMensaje;

    public Ventana6VariosJpanel() {
        setTitle("Ejemplo con Dos Contenedores");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panelBotonesSuperior = new JPanel();
        JPanel panelBotonesInferior = new JPanel();
        JPanel panelMensaje = new JPanel();

        etiquetaBienvenida = new JLabel("¡Bienvenido!");
        etiquetaMensaje = new JLabel("Mensaje:");

        panelBotonesSuperior.setLayout(new FlowLayout());
        panelBotonesInferior.setLayout(new FlowLayout());

        for (int i = 1; i <= 3; i++) {
            JButton boton = new JButton("Boton " + i);
            final int numeroBoton = i;
            boton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    etiquetaMensaje.setText("Mensaje: " + ((JButton) e.getSource()).getText());
                    etiquetaBienvenida.setText("¡Bienvenido: " + ((JButton) e.getSource()).getText() + " Otra vez");
                }
            });
            panelBotonesSuperior.add(boton);
        }

        for (int i = 1; i <= 3; i++) {
            JButton boton = new JButton("Ventana " + i);
            final int numeroBoton = i;
            boton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    abrirNuevaVentana("Has pulsado Ventana " + numeroBoton);
                }
            });
            panelBotonesInferior.add(boton);
        }

        setLayout(new BorderLayout());
        add(etiquetaBienvenida, BorderLayout.NORTH);
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new BorderLayout());
        panelBotones.add(panelBotonesSuperior, BorderLayout.NORTH);
        panelBotones.add(panelBotonesInferior, BorderLayout.SOUTH);
        add(panelBotones, BorderLayout.CENTER);
        add(etiquetaMensaje, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void abrirNuevaVentana(String mensaje) {
        JFrame nuevaVentana = new JFrame("Nueva Ventana");
        nuevaVentana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        nuevaVentana.setSize(300, 200);
        nuevaVentana.setLocationRelativeTo(this);
        JLabel etiqueta = new JLabel(mensaje);
        nuevaVentana.add(etiqueta, BorderLayout.CENTER);
        nuevaVentana.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Ventana6VariosJpanel();
            }
        });
    }
}

package joptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Ejercicio3 {

    public static void main(String[] args) {
        JFrame ventana = new JFrame("Ventana con botón");
        JButton boton= new JButton("Pulsa aquí");

        ventana.setSize(400, 400);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.getContentPane().setLayout(null);
        ventana.getContentPane().add(boton);

        boton.setBounds(150, 150, 100, 40); // Establece la ubicación y el tamaño del botón

        boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Aquí se abrirá una ventana emergente para pedir el nombre
                String nombreIngresado = JOptionPane.showInputDialog(ventana, "Ingresa tu nombre:");
                
                if (nombreIngresado != null && !nombreIngresado.isEmpty()) {
                    // Si el usuario ingresó un nombre, mostrar un mensaje con el nombre
                    JOptionPane.showMessageDialog(ventana, "Tu nombre es " + nombreIngresado);
                } else {
                    // Manejar el caso en el que el usuario no ingresó un nombre
                    JOptionPane.showMessageDialog(ventana, "No ingresaste un nombre válido.");
                }
            }
        });

        ventana.setVisible(true);
    }
}

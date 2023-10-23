package joptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class EjemploJOptionPane {

    public static void main(String[] args) {
        JFrame ventana = new JFrame("Ejemplo de JOptionPane");
        ventana.setSize(400, 200);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton boton = new JButton("Mostrar opciones");
        ventana.add(boton);

        boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String[] opciones = { "Sí", "No", "Cancelar" };

                int seleccion = JOptionPane.showOptionDialog(ventana, "¿Te gusta programar en Java?",
                        "Pregunta Importante", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                        opciones, opciones[2]);

                if (seleccion == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(ventana, "¡Genial! Java es un lenguaje de programación increíble.");
                } else if (seleccion == JOptionPane.NO_OPTION) {
                    JOptionPane.showMessageDialog(ventana, "Oh, ¡qué lástima! Java es muy poderoso.");
                } else if (seleccion == JOptionPane.CANCEL_OPTION) {
                    JOptionPane.showMessageDialog(ventana, "Has cancelado la pregunta.");
                }

                String nombre = JOptionPane.showInputDialog(ventana, "Ingresa tu nombre:");
                if (nombre != null && !nombre.isEmpty()) {
                    int edad = Integer.parseInt(JOptionPane.showInputDialog(ventana, "Ingresa tu edad:"));
                    if (edad >= 18) {
                        int respuesta = JOptionPane.showConfirmDialog(ventana,
                                "¿Eres mayor de edad y te gusta programar en Java?", "Confirmación",
                                JOptionPane.YES_NO_OPTION);
                        if (respuesta == JOptionPane.YES_OPTION) {
                            JOptionPane.showMessageDialog(ventana,
                                    "Hola " + nombre + "! Eres mayor de edad y te gusta programar en Java. ¡Buena elección!");
                        } else {
                            JOptionPane.showMessageDialog(ventana, "Hola " + nombre + "! Eres mayor de edad, pero no te gusta Java.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(ventana, "Hola " + nombre + "! Eres menor de edad.");
                    }
                } else {
                    JOptionPane.showMessageDialog(ventana, "No ingresaste un nombre válido.");
                }
            }
        });

        ventana.setVisible(true);
    }
}

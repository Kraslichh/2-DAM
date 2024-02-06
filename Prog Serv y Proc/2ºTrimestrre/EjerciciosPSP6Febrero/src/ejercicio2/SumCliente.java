package ejercicio2;

import java.io.*;
import java.net.*;

public class SumCliente {
    public static void main(String[] args) {
        String hostName = "localhost"; // O la dirección IP del servidor
        int portNumber = 12345; // Debe coincidir con el puerto del servidor

        try (Socket socket = new Socket(hostName, portNumber);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Conectado al servidor. Ingresa dos números para sumar:");
            for (int i = 0; i < 2; i++) {
                String userInput = stdIn.readLine(); // Lee la entrada del usuario
                out.println(userInput); // Envía cada número al servidor
            }

            System.out.println("Resultado de la suma recibido del servidor:");
            System.out.println(in.readLine()); // Lee y muestra la respuesta del servidor

        } catch (UnknownHostException e) {
            System.err.println("No se puede conectar al host: " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("No se pudo obtener E/S para la conexión con: " + hostName);
            System.exit(1);
        }
    }
}

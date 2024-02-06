package ejercicio1;

import java.io.*;
import java.net.*;

public class CurrencyConverterClient {

    public static void main(String[] args) {
        String hostName = "localhost"; // O la dirección IP del servidor
        int portNumber = 12345; // Debe coincidir con el puerto del servidor

        try (Socket socket = new Socket(hostName, portNumber);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Conectado al servidor. Ingresa una cantidad en Euros para convertir:");
            String userInput;
            while ((userInput = stdIn.readLine()) != null) { // Lee la entrada del usuario desde la consola
                out.println(userInput); // Envía la cantidad en euros al servidor
                System.out.println("Conversión recibida del servidor:");
                System.out.println(in.readLine()); // Lee y muestra la respuesta del servidor
                System.out.println("\nIngresa otra cantidad en Euros para convertir o presiona Ctrl+D para terminar.");
            }

        } catch (UnknownHostException e) {
            System.err.println("No se puede conectar al host: " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("No se pudo obtener E/S para la conexión con: " + hostName);
            System.exit(1);
        }
    }
}

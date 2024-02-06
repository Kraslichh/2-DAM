package ejercicio2;
import java.io.*;
import java.net.*;

public class SumCliente {
    public static void main(String[] args) {
        String hostName = "localhost";
        int portNumber = 12345;

        try (Socket socket = new Socket(hostName, portNumber);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Conectado al servidor. Ingresa el primer número:");
            String number1 = stdIn.readLine(); // Lee el primer número del usuario
            out.println(number1); // Envía el primer número al servidor
            
            System.out.println("Ingresa el segundo número:");
            String number2 = stdIn.readLine(); // Lee el segundo número del usuario
            out.println(number2); // Envía el segundo número al servidor
            
            System.out.println("Elige la operación (sumar, restar, multiplicar):");
            String operation = stdIn.readLine(); // Lee la operación del usuario
            out.println(operation); // Envía la operación al servidor

            // Lee y muestra la respuesta del servidor
            System.out.println("Respuesta del servidor:");
            System.out.println(in.readLine());

        } catch (UnknownHostException e) {
            System.err.println("No se puede conectar al host: " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("No se pudo obtener E/S para la conexión con: " + hostName);
            System.exit(1);
        }
    }
}

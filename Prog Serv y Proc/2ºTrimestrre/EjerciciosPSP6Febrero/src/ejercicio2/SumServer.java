package ejercicio2;
import java.io.*;
import java.net.*;

public class SumServer {
    public static void main(String[] args) {
        final int PORT = 12345; // Puerto en el que el servidor escucha

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Servidor iniciado, escuchando en el puerto " + PORT);

            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

                    double result = 0;
                    double number1 = Double.parseDouble(in.readLine()); // Lee el primer número
                    double number2 = Double.parseDouble(in.readLine()); // Lee el segundo número
                    String operation = in.readLine(); // Lee la operación

                    switch (operation) {
                        case "sumar":
                            result = number1 + number2;
                            break;
                        case "restar":
                            result = number1 - number2;
                            break;
                        case "multiplicar":
                            result = number1 * number2;
                            break;
                        default:
                            out.println("Operación no válida");
                            continue; // Salta al siguiente ciclo del while si la operación no es válida
                    }

                    out.println("Resultado: " + result); // Envía el resultado de la operación al cliente
                } catch (IOException e) {
                    System.out.println("Exception caught when trying to listen on port " + PORT + " or listening for a connection");
                    System.out.println(e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Could not listen on port: " + PORT);
            System.out.println(e.getMessage());
        }
    }
}


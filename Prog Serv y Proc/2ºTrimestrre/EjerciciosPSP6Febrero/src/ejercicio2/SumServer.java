package ejercicio2;
import java.io.*;
import java.net.*;

public class SumServer {
    public static void main(String[] args) {
        final int PORT = 12345; // Puerto en el que el servidor escucha

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Servidor iniciado, escuchando en el puerto " + PORT);

            while (true) { // El servidor corre indefinidamente
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

                    double sum = 0;
                    int count = 0;
                    String inputLine;

                    while ((inputLine = in.readLine()) != null && count < 2) { // Lee dos números del cliente
                        try {
                            double number = Double.parseDouble(inputLine);
                            sum += number;
                            count++;
                            if (count == 1) {
                                System.out.println("Primer número recibido. Ahora dime el otro.");
                                out.println("Primer número recibido. Ahora dime el otro."); // Opcional: enviar confirmación al cliente
                            }
                        } catch (NumberFormatException e) {
                            out.println("Error: Entrada no válida, asegúrese de enviar números.");
                            break;
                        }
                    }

                    if (count == 2) {
                        out.println("Suma: " + sum); // Envía la suma de vuelta al cliente
                    }
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

package ejercicio1;
import java.io.*;
import java.net.*;

public class CurrencyConverterServer {

    public static void main(String[] args) {
        final int PORT = 12345; // Puerto en el que el servidor escucha
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Servidor iniciado, escuchando en el puerto: " + PORT);
            
            while (true) { // El servidor corre indefinidamente
                try (Socket clientSocket = serverSocket.accept(); // Acepta una conexión de un cliente
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                    
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) { // Lee la cantidad en euros del cliente
                        double euros = Double.parseDouble(inputLine);
                        String response = convertCurrencies(euros);
                        out.println(response); // Envía las conversiones al cliente
                    }
                } catch (IOException e) {
                    System.out.println("Exception caught when trying to listen on port "
                        + PORT + " or listening for a connection");
                    System.out.println(e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Could not listen on port: " + PORT);
            System.out.println(e.getMessage());
        }
    }

    private static String convertCurrencies(double euros) {
        // Tasas de conversión ficticias
        double toDollarRate = 1.1;
        double toPoundRate = 0.85;
        double toYenRate = 130.0;

        double dollars = euros * toDollarRate;
        double pounds = euros * toPoundRate;
        double yen = euros * toYenRate;

        // Construye una respuesta con las conversiones
        return "Euros: " + euros + "\n" +
               "Dollars: " + String.format("%.2f", dollars) + "\n" +
               "Pounds: " + String.format("%.2f", pounds) + "\n" +
               "Yen: " + String.format("%.2f", yen);
    }
}

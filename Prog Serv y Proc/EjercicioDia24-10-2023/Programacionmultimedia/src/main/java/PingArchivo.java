import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class PingArchivo {
    public static void main(String[] args) {
        String ipAddress = "192.168.0.1";
        String outputFile = "ping_output.txt";

        try {
            // Construir el comando para hacer ping y redirigir la salida a un archivo
            String command = "ping " + ipAddress + " > " + outputFile;
            Process process = Runtime.getRuntime().exec(command);

            // Esperar a que el proceso termine
            process.waitFor();

            // Leer la salida del comando (opcional)
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            System.out.println("Ping completado. Los resultados se han guardado en " + outputFile);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

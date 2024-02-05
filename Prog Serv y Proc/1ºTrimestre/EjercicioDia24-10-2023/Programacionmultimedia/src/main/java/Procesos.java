import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Procesos {
    public static void main(String[] args) {
        try {
            // Ejecuta el comando "tasklist" para listar los procesos
            ProcessBuilder processBuilder = new ProcessBuilder("tasklist");
            Process process = processBuilder.start();

            // Lee la salida del proceso
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Espera a que el proceso termine
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}


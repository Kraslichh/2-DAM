import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;



public class CambiarFecha {
    public static void main(String[] args) {
        try {
            // Crear un nuevo proceso para ejecutar el comando 'date'
            Process process = Runtime.getRuntime().exec("date");

            // Obtener la secuencia de salida del proceso
            OutputStream outputStream = process.getOutputStream();

            // Obtener la fecha actual
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
            String newDate = dateFormat.format(new Date());

            // Escribir la nueva fecha en la secuencia de salida
            String command = "date " + newDate;
            outputStream.write(command.getBytes());
            outputStream.flush();

            // Cerrar la secuencia de salida
            outputStream.close();

            // Esperar a que el proceso termine
            process.waitFor();

            System.out.println("Fecha cambiada a: " + newDate);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
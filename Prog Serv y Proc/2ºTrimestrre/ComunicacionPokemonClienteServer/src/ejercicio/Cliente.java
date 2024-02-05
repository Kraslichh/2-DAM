package ejercicio;

import java.io.*;
import java.net.*;

public class Cliente {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket socket = new Socket("localhost", 12345);
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

        Pokemon pikachu = new Pokemon("Pikachu", 100, 5);
        oos.writeObject(pikachu);

        String mensaje = (String) ois.readObject();
        System.out.println(mensaje);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String respuesta = reader.readLine();
        oos.writeObject(respuesta);

        Object respuestaServidor = ois.readObject();
        System.out.println(respuestaServidor);

        ois.close();
        oos.close();
        socket.close();
    }
}

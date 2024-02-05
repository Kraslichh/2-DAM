package ejercicio;
import java.io.*;
import java.net.*;
import java.util.Random;

public class Servidor {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Servidor iniciado. Esperando al cliente...");
        Socket socket = serverSocket.accept();

        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

        Pokemon pokemon = (Pokemon) ois.readObject();

        oos.writeObject("Entrenador Gary quiere luchar (Y/N)");
        String respuesta = (String) ois.readObject();

        if ("N".equalsIgnoreCase(respuesta)) {
            oos.writeObject("Eres un cagao");
        } else {
            Random rand = new Random();
            int num = rand.nextInt(100) + 1;
            if (num < 50) {
                pokemon.setVida(0);
                oos.writeObject("Has perdido. " + pokemon.getNombre() + " vida=0.");
            } else {
                pokemon.setNivel(pokemon.getNivel() + 1);
                oos.writeObject("Has ganado. " + pokemon.getNombre() + " nivel " + pokemon.getNivel() + ".");
            }
        }

        ois.close();
        oos.close();
        socket.close();
        serverSocket.close();
    }
}

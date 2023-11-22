package ejercicios;

public class EjercicioDos {

    public static void main(String[] args) {
        Object lock = new Object();

        // Hilo para imprimir "tic"
        Thread hiloTic = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("tic");
                try {
                    Thread.sleep(500); // Pausa de 0.5 segundos
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock) {
                    lock.notify(); // Notificar al otro hilo
                    try {
                        if (i < 4) {
                            lock.wait(); // Esperar al otro hilo si no es la última impresión
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        // Hilo para imprimir "tac"
        Thread hiloTac = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                synchronized (lock) {
                    try {
                        lock.wait(); // Esperar a que el otro hilo imprima
                        System.out.println("tac");
                        Thread.sleep(500); // Pausa de 0.5 segundos
                        lock.notify(); // Notificar al otro hilo
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        // Iniciar los hilos
        hiloTic.start();
        hiloTac.start();
    }
}

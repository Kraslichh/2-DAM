package ejercicios;

public class EjercicioUno {

	   public static void main(String[] args) {
	        // Hilo para imprimir números pares
	        Thread hiloPares = new Thread(() -> {
	            for (int i = 2; i <= 20; i += 2) {
	                System.out.println("Hilo de Pares: " + i);
	                try {
	                    Thread.sleep(200);
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	            }
	        });

	        // Hilo para imprimir números impares
	        Thread hiloImpares = new Thread(() -> {
	            for (int i = 1; i <= 19; i += 2) {
	                System.out.println("Hilo de Impares: " + i);
	                try {
	                    Thread.sleep(200);
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	            }
	        });

	        // Iniciar los hilos
	        hiloPares.start();
	        hiloImpares.start();
	    }

}

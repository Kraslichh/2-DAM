
public class abrirPrograma {
    public static void main(String[] args) {
        try {
            // Ejecuta el comando para abrir la calculadora
            Process calculadoraProcess = Runtime.getRuntime().exec("calc");

            // Espera a que la calculadora se cierre
            calculadoraProcess.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


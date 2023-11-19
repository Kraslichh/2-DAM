package crearBasesDatos;

public class Main {
    public static void main(String[] args) {
    	CrearBaseDatosView vista = new CrearBaseDatosView();
    	CrearBaseDatos modelo = new CrearBaseDatos();
    	CrearBaseDatosController CrearBaseDatosController = new CrearBaseDatosController(vista, modelo);

    	CrearBaseDatosController.crearBaseDatos();
    }
}
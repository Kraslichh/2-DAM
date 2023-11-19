package crearBasesDatos;

public class CrearBaseDatosController {
	// EmpresaController.java
	    private CrearBaseDatosView vista;
	    private CrearBaseDatos modelo;

	    public CrearBaseDatosController(CrearBaseDatosView vista, CrearBaseDatos modelo) {
	        this.vista = vista;
	        this.modelo = modelo;
	    }

	    public void crearBaseDatos() {
	        modelo.crearBaseDeDatos();
	        vista.mostrarMensaje("Base de datos 'empresa' creada correctamente.");
	    }
	}

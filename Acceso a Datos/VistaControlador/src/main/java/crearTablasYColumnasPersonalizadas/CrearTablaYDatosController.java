package crearTablasYColumnasPersonalizadas;


public class CrearTablaYDatosController {

    private CrearTablaYDatosView vista;
    private CrearTablaYDatosModel modelo;

    public CrearTablaYDatosController(CrearTablaYDatosView vista, CrearTablaYDatosModel modelo) {
        this.vista = vista;
        this.modelo = modelo;
    }

    public void crearTabla() {
        modelo.crearTablasPersonalizadas(); // Llama al método para crear ambas tablas
        vista.mostrarMensaje("Tablas 'empleados' y 'clientes' creadas correctamente.");
    }
}
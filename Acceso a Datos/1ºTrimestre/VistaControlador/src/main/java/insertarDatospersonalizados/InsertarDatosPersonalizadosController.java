package insertarDatospersonalizados;

public class InsertarDatosPersonalizadosController {

    private InsertarDatosPersonalizadosView vista;
    private InsertarDatosPersonalizadosModel modelo;

    public InsertarDatosPersonalizadosController(InsertarDatosPersonalizadosView vista, InsertarDatosPersonalizadosModel modelo) {
        this.vista = vista;
        this.modelo = modelo;
    }

    public void insertarDatosEnTabla(String nombreTabla) {
        modelo.insertarDatosEnTabla(nombreTabla);
        vista.mostrarMensaje("Datos insertados en la tabla '" + nombreTabla + "' correctamente.");
    }
}

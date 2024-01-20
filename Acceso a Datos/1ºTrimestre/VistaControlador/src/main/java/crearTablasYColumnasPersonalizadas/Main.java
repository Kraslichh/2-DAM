package crearTablasYColumnasPersonalizadas;

//En tu clase principal o donde desees iniciar el proceso:
public class Main {
 public static void main(String[] args) {
     CrearTablaYDatosView vista = new CrearTablaYDatosView();
     CrearTablaYDatosModel modelo = new CrearTablaYDatosModel();
     CrearTablaYDatosController controlador = new CrearTablaYDatosController(vista, modelo);

     controlador.crearTabla();
 }
}
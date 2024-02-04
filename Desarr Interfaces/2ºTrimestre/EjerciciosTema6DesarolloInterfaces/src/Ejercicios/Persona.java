package Ejercicios;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Persona {
    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty nombre = new SimpleStringProperty();
    private final StringProperty apellido1 = new SimpleStringProperty();
    private final StringProperty apellido2 = new SimpleStringProperty();
    private final StringProperty fechaNacimiento = new SimpleStringProperty();
    private final BooleanProperty esRepetidor = new SimpleBooleanProperty();
    private final StringProperty telefono = new SimpleStringProperty();

    public Persona() {
    }

    public Persona(int id, String nombre, String apellido1, String apellido2, String fechaNacimiento, boolean esRepetidor, String telefono) {
        setId(id);
        setNombre(nombre);
        setApellido1(apellido1);
        setApellido2(apellido2);
        setFechaNacimiento(fechaNacimiento);
        setEsRepetidor(esRepetidor);
        setTelefono(telefono);
    }
    // Métodos getter y setter para las propiedades

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getNombre() {
        return nombre.get();
    }

    public StringProperty nombreProperty() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }
    public void setApellido1(String apellido1) {
        this.apellido1.set(apellido1);
    }

    public void setApellido2(String apellido2) {
        this.apellido2.set(apellido2);
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento.set(fechaNacimiento);
    }

    public void setEsRepetidor(boolean esRepetidor) {
        this.esRepetidor.set(esRepetidor);
    }

    public void setTelefono(String telefono) {
        this.telefono.set(telefono);
    }

    // Define getters y setters para las demás propiedades
    public StringProperty apellido1Property() {
        return apellido1;
    }

    public StringProperty apellido2Property() {
        return apellido2;
    }

    public StringProperty fechaNacimientoProperty() {
        return fechaNacimiento;
    }

    public BooleanProperty esRepetidorProperty() {
        return esRepetidor;
    }

    public StringProperty telefonoProperty() {
        return telefono;
    }
    // Métodos estáticos para obtener datos de ejemplo
    public static ObservableList<Persona> getDatosEjemplo() {
        ObservableList<Persona> listaPersonas = FXCollections.observableArrayList();
        listaPersonas.add(new Persona(1, "Juan", "Perez", "Gomez", "01/01/1990", false, "123-456-789"));
        listaPersonas.add(new Persona(2, "Maria", "Lopez", "Fernandez", "15/03/1985", true, "987-654-321"));
        // Agrega más datos según sea necesario
        return listaPersonas;
    }
}

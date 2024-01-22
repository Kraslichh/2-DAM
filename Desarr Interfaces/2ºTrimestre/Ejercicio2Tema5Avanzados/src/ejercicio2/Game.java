package ejercicio2;

import javafx.beans.property.*;

public class Game {
    private final StringProperty nombre;
    private final DoubleProperty precio;
    private final StringProperty consola;
    private final StringProperty pegi;

    public Game() {
        this(null, 0.0, null, null);
    }

    public Game(String nombre, double precio, String consola, String pegi) {
        this.nombre = new SimpleStringProperty(nombre);
        this.precio = new SimpleDoubleProperty(precio);
        this.consola = new SimpleStringProperty(consola);
        this.pegi = new SimpleStringProperty(pegi);
    }

    // Métodos getter y setter para cada propiedad
    public String getNombre() {
        return nombre.get();
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public StringProperty nombreProperty() {
        return nombre;
    }

    public double getPrecio() {
        return precio.get();
    }

    public void setPrecio(double precio) {
        this.precio.set(precio);
    }

    public DoubleProperty precioProperty() {
        return precio;
    }

    public String getConsola() {
        return consola.get();
    }

    public void setConsola(String consola) {
        this.consola.set(consola);
    }

    public StringProperty consolaProperty() {
        return consola;
    }

    public String getPegi() {
        return pegi.get();
    }

    public void setPegi(String pegi) {
        this.pegi.set(pegi);
    }

    public StringProperty pegiProperty() {
        return pegi;
    }
}
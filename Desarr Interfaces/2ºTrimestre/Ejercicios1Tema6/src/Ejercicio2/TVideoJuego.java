package Ejercicio2;


import javafx.beans.property.*;


public class TVideoJuego {
	 private StringProperty nombre = new SimpleStringProperty();
	    private IntegerProperty anio = new SimpleIntegerProperty();
	    private StringProperty compania = new SimpleStringProperty();
	    private DoubleProperty precio = new SimpleDoubleProperty();
	    private StringProperty sinopsis = new SimpleStringProperty();
	    private StringProperty plataforma = new SimpleStringProperty();
	    
	public TVideoJuego(int id, String nombre, int anio, String compania, Double precio, String sinopsis, String plataforma) {
		this.nombre.set(nombre);
        this.anio.set(anio);
        this.compania.set(compania);
        this.precio.set(precio);
        this.sinopsis.set(sinopsis);
        this.plataforma.set(plataforma);
	}
	
   


    // Métodos getter para propiedades observables
    public String getNombre() {
        return nombre.get();
    }


    public StringProperty nombreProperty() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }


    public int getAnio() {
        return anio.get();
    }


    public IntegerProperty anioProperty() {
        return anio;
    }


    public void setAnio(int anio) {
        this.anio.set(anio);
    }


    public String getCompania() {
        return compania.get();
    }


    public StringProperty companiaProperty() {
        return compania;
    }


    public void setCompania(String compania) {
        this.compania.set(compania);
    }


    public double getPrecio() {
        return precio.get();
    }


    public DoubleProperty precioProperty() {
        return precio;
    }


    public void setPrecio(double precio) {
        this.precio.set(precio);
    }


    public String getSinopsis() {
        return sinopsis.get();
    }


    public StringProperty sinopsisProperty() {
        return sinopsis;
    }


    public void setSinopsis(String sinopsis) {
        this.sinopsis.set(sinopsis);
    }


    public String getPlataforma() {
        return plataforma.get();
    }


    public StringProperty plataformaProperty() {
        return plataforma;
    }


    public void setPlataforma(String plataforma) {
        this.plataforma.set(plataforma);
    }


    // Otros métodos y constructores
}

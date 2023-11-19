package insertarClientes;

public class InsertarCliente {
    private int id;
    private String nif;
    private String nombre;
    private String edad;

    public InsertarCliente(int id, String nif, String nombre, String edad) {
        this.id = id;
        this.nif = nif;
        this.nombre = nombre;
        this.edad = edad;
    }

    public int getId() {
        return id;
    }

    public String getNif() {
        return nif;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEdad() {
        return edad;
    }
}

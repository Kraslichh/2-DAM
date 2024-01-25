package ejercicios;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "compra")
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;

    @Column(name = "cantidad")
    private int cantidad;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    // Constructor por defecto
    public Compra() {
    }

    // Constructor con parámetros
    public Compra(Date fecha, int cantidad, Producto producto) {
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.producto = producto;
    }

    // Getters y Setters...

    @Override
    public String toString() {
        return "Compra{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", cantidad=" + cantidad +
                ", producto=" + producto +
                '}';
    }
}

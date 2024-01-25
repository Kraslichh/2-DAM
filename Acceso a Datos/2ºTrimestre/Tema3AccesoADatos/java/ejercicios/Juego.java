package ejercicios;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "TVIDEOJUEGOS")
public class Juego {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idjuego")
    private int id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "anio", nullable = false)
    private int anio;

    @Column(name = "compania", nullable = false, length = 50)
    private String compania;

    @Column(name = "precio", precision = 10, scale = 2, nullable = false)
    private BigDecimal precio;

    @Column(name = "sinopsis", length = 150)
    private String sinopsis;

    @Column(name = "plataforma", length = 50)
    private String plataforma;

    // Constructor vacío
    public Juego() {
    }

    // Constructor con parámetros (sin id, Hibernate se encarga de eso)
    public Juego(String nombre, int anio, String compania, BigDecimal precio, String sinopsis, String plataforma) {
        this.nombre = nombre;
        this.anio = anio;
        this.compania = compania;
        this.precio = precio;
        this.sinopsis = sinopsis;
        this.plataforma = plataforma;
    }

    @Override
    public String toString() {
        return "Juego{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", anio=" + anio +
                ", compania='" + compania + '\'' +
                ", precio=" + precio +
                ", sinopsis='" + sinopsis + '\'' +
                ", plataforma='" + plataforma + '\'' +
                '}';
    }
}

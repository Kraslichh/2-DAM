package ejercicios;

import javax.persistence.*;

@Entity
@Table(name = "fabricante")
public class Fabricante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nombre")
    private String nombre;

    public Fabricante() {
    }

    public Fabricante(String nombre) {
        this.nombre = nombre;
    }

    // Getters y Setters...

    @Override
    public String toString() {
        return "Fabricante{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}

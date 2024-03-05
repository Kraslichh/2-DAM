package actividad2
// MostrarDatosActivity.kt
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.proyectosqlite2.R

class MostrarDatosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar_datos)

        val tvAlumnos = findViewById<TextView>(R.id.tvAlumnos)
        val btnVolver = findViewById<Button>(R.id.btnVolver)

        val dataManager = DataManagerAlumno(this)
        val alumnosList = dataManager.getAllAlumnos()

        val nombres = StringBuilder()
        for (alumno in alumnosList) {
            nombres.append("ID: ${alumno.id}, Nombre: ${alumno.nombre}, Apellidos: ${alumno.apellidos}, DNI: ${alumno.dni}, Edad: ${alumno.edad}, Curso: ${alumno.curso}\n\n")
        }
        tvAlumnos.text = nombres.toString()

        btnVolver.setOnClickListener {
            finish() // Cierra esta actividad y vuelve a la actividad anterior (MainActivity)
        }
    }
}

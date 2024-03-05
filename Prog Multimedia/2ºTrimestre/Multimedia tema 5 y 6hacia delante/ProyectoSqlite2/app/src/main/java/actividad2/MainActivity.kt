package actividad2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.proyectosqlite2.R

class MainActivity : AppCompatActivity() {

    private lateinit var dataManager: DataManagerAlumno

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dataManager = DataManagerAlumno(this)

        val etNombre = findViewById<EditText>(R.id.etNombre)
        val etApellidos = findViewById<EditText>(R.id.etApellidos)
        val etDNI = findViewById<EditText>(R.id.etDNI)
        val etEdad = findViewById<EditText>(R.id.etEdad)
        val etCurso = findViewById<EditText>(R.id.etCurso)
        val btnAgregar = findViewById<Button>(R.id.btnAgregar)
        val btnMostrar = findViewById<Button>(R.id.btnMostrar)
        val tvAlumnos = findViewById<TextView>(R.id.tvAlumnos)

        btnAgregar.setOnClickListener {
            val nombre = etNombre.text.toString()
            val apellidos = etApellidos.text.toString()
            val dni = etDNI.text.toString()
            val edad = etEdad.text.toString().toIntOrNull() ?: 0
            val curso = etCurso.text.toString()

            if (nombre.isNotEmpty() && apellidos.isNotEmpty() && dni.isNotEmpty() && edad > 0 && curso.isNotEmpty()) {
                val alumno = Alumno(nombre = nombre, apellidos = apellidos, dni = dni, edad = edad, curso = curso)
                dataManager.addAlumno(alumno)
                Toast.makeText(this, "Alumno agregado correctamente", Toast.LENGTH_SHORT).show()
                limpiarCampos()
            } else {
                Toast.makeText(this, "Por favor, complete todos los campos correctamente", Toast.LENGTH_SHORT).show()
            }
        }

        btnMostrar.setOnClickListener {
            val intent = Intent(this, MostrarDatosActivity::class.java)
            startActivity(intent)
        }
    }

    private fun limpiarCampos() {
        val etNombre = findViewById<EditText>(R.id.etNombre)
        val etApellidos = findViewById<EditText>(R.id.etApellidos)
        val etDNI = findViewById<EditText>(R.id.etDNI)
        val etEdad = findViewById<EditText>(R.id.etEdad)
        val etCurso = findViewById<EditText>(R.id.etCurso)

        etNombre.text.clear()
        etApellidos.text.clear()
        etDNI.text.clear()
        etEdad.text.clear()
        etCurso.text.clear()
    }
}

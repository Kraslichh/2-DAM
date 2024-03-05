package com.example.proyectosqlite1
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var dataManager: DataManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dataManager = DataManager(this)

        val etNombre = findViewById<EditText>(R.id.etNombre)
        val etApellidos = findViewById<EditText>(R.id.etApellidos)
        val btnAgregar = findViewById<Button>(R.id.btnAgregar)
        val btnMostrar = findViewById<Button>(R.id.btnMostrar)

        btnAgregar.setOnClickListener {
            val nombre = etNombre.text.toString()
            val apellidos = etApellidos.text.toString()
            if (nombre.isNotEmpty() && apellidos.isNotEmpty()) {
                dataManager.addName(nombre, apellidos)
                Toast.makeText(this, "Se agregó a la base de datos: $nombre $apellidos", Toast.LENGTH_SHORT).show()
                etNombre.text.clear() // Limpiamos el componente EditText
                etApellidos.text.clear()
            } else {
                Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show()
            }
        }

        // Muestra todos los datos en otra actividad
        btnMostrar.setOnClickListener {
            val intent = Intent(this, MostrarNombresActivity::class.java)
            startActivity(intent)
        }
    }
}

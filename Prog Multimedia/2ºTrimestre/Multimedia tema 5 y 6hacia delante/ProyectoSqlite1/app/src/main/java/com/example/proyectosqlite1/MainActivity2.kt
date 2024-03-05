package com.example.proyectosqlite1

import android.widget.TextView
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MostrarNombresActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // Obtener los nombres de la intención
        val nombres = intent.getStringExtra("nombres")

        // Mostrar los nombres en un TextView
        val textView = findViewById<TextView>(R.id.tvMostrarNombres)
        textView.text = nombres

        // Configurar el botón para volver atrás
        val btnVolver = findViewById<Button>(R.id.btnVolver)
        btnVolver.setOnClickListener {
            finish() // Cerrar esta actividad para volver atrás
        }
    }
}

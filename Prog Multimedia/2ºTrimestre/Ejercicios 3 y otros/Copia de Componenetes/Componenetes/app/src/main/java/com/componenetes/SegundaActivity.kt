package com.componenetes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SegundaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda)
        // Recuperar valores de ingresos y edad
        val ingresos = intent.getIntExtra("ingresos", 0)
        val edad = intent.getIntExtra("edad", 0)
        val opcionSeleccionada = intent.getStringExtra("opcionSeleccionada") ?: ""


        // Hacer lo que necesites con los valores
        val tvResultado = findViewById<TextView>(R.id.tvResultado)
        tvResultado.text = "Ingresos: $ingresos al mes, Edad: $edad años: opcion $opcionSeleccionada"
    }
}


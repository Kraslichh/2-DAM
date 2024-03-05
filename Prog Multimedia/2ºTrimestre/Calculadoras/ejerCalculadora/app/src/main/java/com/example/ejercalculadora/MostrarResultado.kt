package com.example.ejercalculadora

import android.os.Bundle

import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MostrarResultado : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar_resultado)

        val tvResultado: TextView = findViewById(R.id.tvResult)

        // Recuperar el resultado del Intent
        val resultado = intent.getStringExtra("resultado")

        // Mostrar el resultado en el TextView
        tvResultado.text = "Resultado: $resultado"
    }
}

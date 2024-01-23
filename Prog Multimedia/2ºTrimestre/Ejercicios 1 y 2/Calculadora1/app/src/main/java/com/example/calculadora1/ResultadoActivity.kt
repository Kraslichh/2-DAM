package com.example.calculadora1

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultadoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        val resultadoTextView: TextView = findViewById(R.id.tvResultado)

        val numero1 = intent.getDoubleExtra("NUMERO1", 0.0)
        val numero2 = intent.getDoubleExtra("NUMERO2", 0.0)
        val operacion = intent.getStringExtra("OPERACION")

        val resultado = when (operacion) {
            "+" -> numero1 + numero2
            "-" -> numero1 - numero2
            "*" -> numero1 * numero2
            "/" -> if (numero2 != 0.0) numero1 / numero2 else Double.NaN
            else -> Double.NaN
        }

        val resultadoTexto = if (!resultado.isNaN()) {
            "Resultado: $resultado"
        } else {
            "Resultado: Indefinido (división por cero)"
        }

        resultadoTextView.text = resultadoTexto
    }
}

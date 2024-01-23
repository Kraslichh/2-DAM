package com.example.calculadora1

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var etNumero1: EditText
    private lateinit var etNumero2: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etNumero1 = findViewById(R.id.etNumero1)
        etNumero2 = findViewById(R.id.etNumero2)
    }

    fun onCalcularClick(view: View) {
        val numero1 = etNumero1.text.toString().toDouble()
        val numero2 = etNumero2.text.toString().toDouble()
        val resultadoTextView: TextView = findViewById(R.id.tvResultado)

        when (view.id) {
            R.id.btnSumar -> {
                val resultado = numero1 + numero2
                resultadoTextView.text = "Resultado: $resultado"
            }
            R.id.btnRestar -> {
                val resultado = numero1 - numero2
                resultadoTextView.text = "Resultado: $resultado"
            }
            R.id.btnMultiplicar -> {
                val resultado = numero1 * numero2
                resultadoTextView.text = "Resultado: $resultado"
            }
            R.id.btnDividir -> {
                val resultado = if (numero2 != 0.0) numero1 / numero2 else Double.NaN
                resultadoTextView.text = "Resultado: $resultado"
            }
        }
    }
}

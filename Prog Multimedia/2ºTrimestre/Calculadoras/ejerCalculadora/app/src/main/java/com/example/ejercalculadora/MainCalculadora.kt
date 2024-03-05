package com.example.ejercalculadora
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainCalculadora : AppCompatActivity() {

    private lateinit var etOperador1: EditText
    private lateinit var etOperador2: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_calculadora)

        etOperador1 = findViewById(R.id.etop1)
        etOperador2 = findViewById(R.id.etop2)

        val btnSumar: Button = findViewById(R.id.btnSumar)
        val btnRestar: Button = findViewById(R.id.btnRestar)
        val btnMultiplicar: Button = findViewById(R.id.btnMultiplicar)
        val btnDividir: Button = findViewById(R.id.btnDividir)

        btnSumar.setOnClickListener { realizarOperacion("+") }
        btnRestar.setOnClickListener { realizarOperacion("-") }
        btnMultiplicar.setOnClickListener { realizarOperacion("*") }
        btnDividir.setOnClickListener { realizarOperacion("/") }
    }

    private fun realizarOperacion(operador: String) {
        val operando1 = etOperador1.text.toString().toDoubleOrNull()
        val operando2 = etOperador2.text.toString().toDoubleOrNull()

        if (operando1 != null && operando2 != null) {
            val resultado = when (operador) {
                "+" -> operando1 + operando2
                "-" -> operando1 - operando2
                "*" -> operando1 * operando2
                "/" -> {
                    if (operando2 != 0.0) operando1 / operando2
                    else null
                }
                else -> null
            }

            val resultadoString = resultado?.toString() ?: "Error"

            val intent = Intent(this, MostrarResultado::class.java).apply {
                putExtra("resultado", resultadoString)
            }

            startActivity(intent)
        }
    }
}

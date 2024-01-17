package com.example.calculadoraejercicio2

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var tvInput: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvInput = findViewById(R.id.tvInput)
    }

    fun onDigit(view: View) {
        tvInput.append((view as Button).text)
    }

    fun onClear(view: View) {
        tvInput.text = ""
    }

    fun onDecimalPoint(view: View) {
        if (!tvInput.text.contains(".")) {
            tvInput.append(".")
        }
    }

    fun onOperator(view: View) {
        if (tvInput.text.isNotEmpty() && "+-*/".none { tvInput.text.toString().endsWith(it) }) {
            tvInput.append((view as Button).text)
        }
    }

    fun onEqual(view: View) {
        try {
            // Aquí necesitarás implementar la lógica para evaluar la expresión
            // Por ejemplo, si estás utilizando una librería de parsing de expresiones,
            // evaluarías la expresión así:
            // val result = ExpressionBuilder(tvInput.text.toString()).build().evaluate()
            // tvInput.text = result.toString()

            // Esto es solo un placeholder para indicar dónde iría la lógica de evaluación
            tvInput.text = evaluateExpression(tvInput.text.toString())
        } catch (e: Exception) {
            tvInput.text = "Error"
        }
    }

    // Esta función es un placeholder para donde implementarías la lógica de evaluación real
    private fun evaluateExpression(expression: String): String {
        // Implementa la lógica de evaluación aquí
        return expression
    }
}

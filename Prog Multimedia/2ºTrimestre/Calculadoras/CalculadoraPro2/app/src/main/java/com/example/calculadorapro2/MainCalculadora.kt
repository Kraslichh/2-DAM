package com.example.calculadorapro2
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainCalculadora : AppCompatActivity() {

    private lateinit var tvCalculadora: TextView
    private var operando1: Double = 0.0
    private var operador: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_calculadora)

        tvCalculadora = findViewById(R.id.tvCalculadora)

        val buttonIds = listOf(
            R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3,
            R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7,
            R.id.btn8, R.id.btn9
        )

        for (buttonId in buttonIds) {
            val button = findViewById<Button>(buttonId)
            button.setOnClickListener { onDigitButtonClick(button.text.toString()) }
        }

        val operationButtonIds = listOf(
            R.id.btnSumar, R.id.btnrestar, R.id.btnMultiplicar, R.id.btnDividir
        )

        for (buttonId in operationButtonIds) {
            val button = findViewById<Button>(buttonId)
            button.setOnClickListener { onOperatorButtonClick(button.text.toString()) }
        }

        val btnIgual = findViewById<Button>(R.id.btnIgual)
        btnIgual.setOnClickListener { calculate() }

        val btnDel = findViewById<Button>(R.id.btnDel)
        btnDel.setOnClickListener { deleteLastDigit() }

        val btnPunto = findViewById<Button>(R.id.btnpunto)
        btnPunto.setOnClickListener { appendDecimalPoint() }
    }

    private fun onDigitButtonClick(digit: String) {
        val currentText = tvCalculadora.text.toString()
        tvCalculadora.text = if (currentText == "0") digit else currentText + digit
    }

    private fun appendDecimalPoint() {
        val currentText = tvCalculadora.text.toString()
        if (!currentText.contains('.')) {
            tvCalculadora.text = currentText + "."
        }
    }

    private fun onOperatorButtonClick(operator: String) {
        operando1 = tvCalculadora.text.toString().toDouble()
        this.operador = operator
        tvCalculadora.text = "0"
    }

    private fun calculate() {
        val operando2 = tvCalculadora.text.toString().toDouble()
        when (operador) {
            "+" -> tvCalculadora.text = (operando1 + operando2).toString()
            "-" -> tvCalculadora.text = (operando1 - operando2).toString()
            "X" -> tvCalculadora.text = (operando1 * operando2).toString()
            "/" -> {
                if (operando2 != 0.0) {
                    tvCalculadora.text = (operando1 / operando2).toString()
                } else {
                    tvCalculadora.text = "Error"
                }
            }
        }
    }

    private fun deleteLastDigit() {
        val currentText = tvCalculadora.text.toString()
        if (currentText.length > 1) {
            tvCalculadora.text = currentText.substring(0, currentText.length - 1)
        } else {
            tvCalculadora.text = "0"
        }
    }
}

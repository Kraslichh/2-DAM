package com.example.calculadoraejercicio2

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import net.objecthunter.exp4j.ExpressionBuilder

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
            val result = evaluateExpression(tvInput.text.toString())
            tvInput.text = result.toString()
        } catch (e: Exception) {
            tvInput.text = "Error"
        }
    }

    private fun evaluateExpression(expression: String): String {
        return try {
            val result = ExpressionBuilder(expression).build().evaluate()
            result.toString()
        } catch (e: Exception) {
            "Error"
        }
    }
}
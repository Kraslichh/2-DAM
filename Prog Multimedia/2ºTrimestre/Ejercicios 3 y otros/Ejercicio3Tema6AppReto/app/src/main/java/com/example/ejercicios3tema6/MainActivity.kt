package com.example.ejercicios3tema6

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ejercicios3tema6.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    // Lateinit para el binding que se inicializará en onCreate
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inicializar el binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calcularButton.setOnClickListener {
            val alturaStr = binding.alturaEditText.text.toString()
            val pesoStr = binding.pesoEditText.text.toString()

            if (alturaStr.isNotEmpty() && pesoStr.isNotEmpty()) {
                val height = alturaStr.toDouble() / 100
                val weight = pesoStr.toDouble()
                val bmi = BMICalculator.calculateBMI(weight, height)

                val intent = Intent(this, ResultActivity::class.java).apply {
                    putExtra("BMI", bmi)
                }
                startActivity(intent)
            } else {
                // Mostrar un mensaje de error o manejar la entrada vacía de alguna manera
                Toast.makeText(this, "Por favor, ingrese altura y peso", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

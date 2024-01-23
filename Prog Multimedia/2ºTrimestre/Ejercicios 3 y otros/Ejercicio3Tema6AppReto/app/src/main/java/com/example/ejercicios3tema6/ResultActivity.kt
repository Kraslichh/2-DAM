package com.example.ejercicios3tema6

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ejercicios3tema6.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bmi = intent.getDoubleExtra("BMI", 0.0)
        binding.bmiResultTextView.text = String.format("%.2f", bmi)
        binding.bmiCategoryTextView.text = getBMICategory(bmi)

        binding.recalcularButton.setOnClickListener {
            finish()
        }
    }

    private fun getBMICategory(bmi: Double): String {
        return when {
            bmi < 18.5 -> getString(R.string.bajo_peso)
            bmi < 24.9 -> getString(R.string.peso_normal)
            bmi < 29.9 -> getString(R.string.sobrepeso)
            bmi < 34.9 -> getString(R.string.obesidad_grado_1)
            bmi < 39.9 -> getString(R.string.obesidad_grado_2)
            else -> getString(R.string.obesidad_extrema_grado_3)
        }
    }
}

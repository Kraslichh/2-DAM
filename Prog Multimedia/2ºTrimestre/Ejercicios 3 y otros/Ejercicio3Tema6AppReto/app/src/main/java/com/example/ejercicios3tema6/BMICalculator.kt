package com.example.ejercicios3tema6

object BMICalculator {
    fun calculateBMI(weight: Double, height: Double): Double {
        return weight / (height * height)
    }
}

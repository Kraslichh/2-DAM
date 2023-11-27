package com.example.ejerciciostema5condicionatesybucles.Ejercicios

class Ejercicio1 {
    fun calcularImpuestos(sueldo: Double) {
        if (sueldo > 3000) {
            println("Debe abonar impuestos.")
        } else {
            println("No debe abonar impuestos.")
        }
    }
}

fun main() {
    val ejercicio1 = Ejercicio1()
    val sueldoIngresado = 3500.0 // Puedes cambiar este valor para probar diferentes casos
    ejercicio1.calcularImpuestos(sueldoIngresado)
}
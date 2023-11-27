package com.example.ejerciciostema5condicionatesybucles.Ejercicios
fun calcularOperaciones(num1: Int, num2: Int) {
    if (num1 < num2) {
        val suma = num1 + num2
        val resta = num2 - num1
        println("La suma es: $suma y la resta es: $resta")
    } else {
        val producto = num1 * num2
        val division = num1.toDouble() / num2.toDouble()
        println("El producto es: $producto y la división es: $division")
    }
}

fun main() {
    val valor1 = 8 // Cambia estos valores para probar diferentes casos
    val valor2 = 5
    calcularOperaciones(valor1, valor2)
}


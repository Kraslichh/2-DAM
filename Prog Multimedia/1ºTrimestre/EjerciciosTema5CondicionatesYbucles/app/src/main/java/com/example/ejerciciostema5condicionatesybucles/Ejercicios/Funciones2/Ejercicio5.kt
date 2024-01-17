package com.example.ejerciciostema5condicionatesybucles.Ejercicios.Funciones2

fun obtenerMayor(a: Int, b: Int): Int {
    return if (a > b) a else b
}

fun main() {
    val numero1 = 15 // Cambia estos valores para probar diferentes casos
    val numero2 = 20
    val mayor = obtenerMayor(numero1, numero2)
    println("El número mayor es: $mayor")
}

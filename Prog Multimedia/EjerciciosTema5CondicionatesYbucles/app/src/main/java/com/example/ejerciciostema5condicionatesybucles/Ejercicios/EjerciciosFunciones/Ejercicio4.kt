package com.example.ejerciciostema5condicionatesybucles.Ejercicios.EjerciciosFunciones

fun calcularSuperficieCuadrado(lado: Int): Int {
    return lado * lado
}

fun main() {
    print("Ingrese el lado del cuadrado: ")
    val lado = readLine()?.toIntOrNull() ?: 0
    val superficie = calcularSuperficieCuadrado(lado)
    println("La superficie del cuadrado es: $superficie")
}

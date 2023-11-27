package com.example.ejerciciostema5condicionatesybucles.Ejercicios

fun encontrarMayorYMostrar(num1: Int, num2: Int) {
    val mayor = if (num1 > num2) num1 else num2
    println("El número mayor es: $mayor")
}

fun main() {
    val numeroA = 15 // Cambia estos valores para probar diferentes casos
    val numeroB = 20
    encontrarMayorYMostrar(numeroA, numeroB)
}

package com.example.ejerciciostema5condicionatesybucles.Ejercicios

fun encontrarMayor(num1: Int, num2: Int) {
    val mayor = if (num1 > num2) num1 else num2
    println("El número mayor es: $mayor")
}

fun main() {
    val numero1 = 10 // Cambia estos valores para probar diferentes casos
    val numero2 = 5
    encontrarMayor(numero1, numero2)
}
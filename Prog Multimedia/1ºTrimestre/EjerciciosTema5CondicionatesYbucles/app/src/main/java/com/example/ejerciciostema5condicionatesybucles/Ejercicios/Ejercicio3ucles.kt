package com.example.ejerciciostema5condicionatesybucles.Ejercicios

fun calcularPromedio() {
    var total = 0
    var cantidad = 0
    var numero: Int
    do {
        print("Ingrese un número (0 para finalizar): ")
        numero = readLine()?.toIntOrNull() ?: 0
        if (numero != 0) {
            total += numero
            cantidad++
        }
    } while (numero != 0)

    if (cantidad != 0) {
        val promedio = total.toDouble() / cantidad
        println("El promedio es: $promedio")
    }
}

fun main() {
    calcularPromedio()
}

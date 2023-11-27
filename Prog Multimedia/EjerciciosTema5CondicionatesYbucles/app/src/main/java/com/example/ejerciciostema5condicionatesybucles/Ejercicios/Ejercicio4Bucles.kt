package com.example.ejerciciostema5condicionatesybucles.Ejercicios

fun sumarYCalcularPromedio() {
    var suma = 0
    repeat(10) {
        print("Ingrese el valor ${it + 1}: ")
        val valor = readLine()?.toIntOrNull() ?: 0
        suma += valor
    }
    val promedio = suma.toDouble() / 10
    println("La suma de los valores es: $suma")
    println("El promedio de los valores es: $promedio")
}

fun main() {
    sumarYCalcularPromedio()
}

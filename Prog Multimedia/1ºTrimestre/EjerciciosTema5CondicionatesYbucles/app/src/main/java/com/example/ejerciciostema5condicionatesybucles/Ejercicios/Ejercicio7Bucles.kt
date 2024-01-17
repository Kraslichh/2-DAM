package com.example.ejerciciostema5condicionatesybucles.Ejercicios

fun evaluarPromedio() {
    var suma = 0.0
    repeat(3) {
        print("Ingrese la nota $it: ")
        val nota = readLine()?.toDoubleOrNull() ?: 0.0
        suma += nota
    }
    val promedio = suma / 3
    val mensaje = when {
        promedio >= 7 -> "Promocionado"
        promedio >= 4 && promedio < 7 -> "Regular"
        else -> "Reprobado"
    }
    println("El promedio es $promedio - $mensaje")
}

fun main() {
    evaluarPromedio()
}

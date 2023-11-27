package com.example.ejerciciostema5condicionatesybucles.Ejercicios

fun calcularPromedioYMostrarResultado(nota1: Double, nota2: Double, nota3: Double) {
    val promedio = (nota1 + nota2 + nota3) / 3

    val mensaje = when (promedio) {
        in 0.0..4.0 -> "SUSPENSO"
        5.0 -> "SUFICIENTE"
        6.0 -> "BIEN"
        in 7.0..8.0 -> "NOTABLE"
        in 9.0..10.0 -> "SOBRESALIENTE"
        else -> "Nota fuera de rango"
    }

    println("El promedio es $promedio - $mensaje")
}

fun main() {
    val notaAlumno1 = 7.5 // Cambia estos valores para probar diferentes casos
    val notaAlumno2 = 8.0
    val notaAlumno3 = 9.5
    calcularPromedioYMostrarResultado(notaAlumno1, notaAlumno2, notaAlumno3)
}

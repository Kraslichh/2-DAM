package com.example.ejerciciostema5condicionatesybucles.Ejercicios.EjerciciosFunciones

fun mostrarPresentacion2() {
    println("Bienvenido al programa")
}

fun sumarYMostrar2(a: Int, b: Int) {
    val suma = a + b
    println("La suma de $a y $b es igual a $suma")
}

fun despedida2() {
    println("¡Hasta luego!")
}

fun main() {
    mostrarPresentacion2()
    val valorA = 8 // Cambia estos valores para probar diferentes casos
    val valorB = 12
    sumarYMostrar2(valorA, valorB)
    despedida2()
}

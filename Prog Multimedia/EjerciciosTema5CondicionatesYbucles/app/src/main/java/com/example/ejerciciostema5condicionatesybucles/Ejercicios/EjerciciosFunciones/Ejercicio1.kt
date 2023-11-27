package com.example.ejerciciostema5condicionatesybucles.Ejercicios.EjerciciosFunciones

fun mostrarPresentacion() {
    println("Bienvenido al programa")
}

fun sumarYMostrar(a: Int, b: Int) {
    val suma = a + b
    println("La suma de $a y $b es igual a $suma")
}

fun despedida() {
    println("¡Hasta luego!")
}

fun main() {
    mostrarPresentacion()
    val valor1 = 5 // Cambia estos valores para probar diferentes casos
    val valor2 = 7
    sumarYMostrar(valor1, valor2)
    despedida()
}

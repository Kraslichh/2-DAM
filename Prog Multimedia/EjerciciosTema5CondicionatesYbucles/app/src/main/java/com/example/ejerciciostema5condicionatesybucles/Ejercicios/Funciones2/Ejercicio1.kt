package com.example.ejerciciostema5condicionatesybucles.Ejercicios.Funciones2
fun presentacion() {
    println("¡Bienvenido al programa!")
}

fun pedirValores(): Pair<Int, Int> {
    print("Ingrese el primer valor: ")
    val valor1 = readLine()?.toIntOrNull() ?: 0
    print("Ingrese el segundo valor: ")
    val valor2 = readLine()?.toIntOrNull() ?: 0
    return Pair(valor1, valor2)
}

fun mostrarSuma(valor1: Int, valor2: Int) {
    val suma = valor1 + valor2
    println("La suma de los valores es: $suma")
}

fun despedida() {
    println("¡Hasta luego!")
}

fun main() {
    presentacion()
    val (val1, val2) = pedirValores()
    mostrarSuma(val1, val2)
    despedida()
}


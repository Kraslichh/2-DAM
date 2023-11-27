package com.example.ejerciciostema5condicionatesybucles.Ejercicios.Funciones2

fun presentacion2() {
    println("¡Bienvenido al programa!")
}

fun pedirValores2(): Pair<Int, Int> {
    print("Ingrese el primer valor: ")
    val valorA = readLine()?.toIntOrNull() ?: 0
    print("Ingrese el segundo valor: ")
    val valorB = readLine()?.toIntOrNull() ?: 0
    return Pair(valorA, valorB)
}

fun mostrarSuma2(valorA: Int, valorB: Int) {
    val suma = valorA + valorB
    println("La suma de los valores es: $suma")
}

fun despedida2() {
    println("¡Hasta luego!")
}

fun main() {
    presentacion2()
    val (valorA, valorB) = pedirValores2()
    mostrarSuma2(valorA, valorB)
    despedida2()
}

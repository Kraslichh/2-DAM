package com.example.ejerciciostema5condicionatesybucles.Ejercicios.Funciones2

fun numeroEnCastellano(numero: Int): String {
    return when (numero) {
        1 -> "uno"
        2 -> "dos"
        3 -> "tres"
        4 -> "cuatro"
        5 -> "cinco"
        else -> "error"
    }
}

fun main() {
    print("Ingrese un número entre 1 y 5: ")
    val numero = readLine()?.toIntOrNull() ?: 0
    val resultado = numeroEnCastellano(numero)
    println("El número en castellano es: $resultado")
}

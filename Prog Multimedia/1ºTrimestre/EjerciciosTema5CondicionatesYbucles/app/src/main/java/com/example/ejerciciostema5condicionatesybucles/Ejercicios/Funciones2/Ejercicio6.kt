package com.example.ejerciciostema5condicionatesybucles.Ejercicios.Funciones2

fun contarCaracteres(palabra: String): Int {
    return palabra.length
}

fun main() {
    print("Ingrese la primera palabra: ")
    val palabra1 = readLine() ?: ""
    print("Ingrese la segunda palabra: ")
    val palabra2 = readLine() ?: ""

    val longitud1 = contarCaracteres(palabra1)
    val longitud2 = contarCaracteres(palabra2)

    if (longitud1 > longitud2) {
        println("La primera palabra tiene más caracteres")
    } else if (longitud2 > longitud1) {
        println("La segunda palabra tiene más caracteres")
    } else {
        println("Ambas palabras tienen la misma cantidad de caracteres")
    }
}

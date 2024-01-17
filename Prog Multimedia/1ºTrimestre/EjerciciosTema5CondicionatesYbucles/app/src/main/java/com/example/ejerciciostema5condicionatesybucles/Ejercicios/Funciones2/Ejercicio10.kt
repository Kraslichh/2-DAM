package com.example.ejerciciostema5condicionatesybucles.Ejercicios.Funciones2

fun contarMultiplos() {
    var multiplos2 = 0
    var multiplos5 = 0

    repeat(10) {
        print("Ingrese un valor: ")
        val valor = readLine()?.toIntOrNull() ?: 0

        if (valor % 2 == 0) {
            multiplos2++
        }

        if (valor % 5 == 0) {
            multiplos5++
        }
    }

    println("Cantidad de números múltiplos de 2: $multiplos2")
    println("Cantidad de números múltiplos de 5: $multiplos5")
}

fun main() {
    contarMultiplos()
}

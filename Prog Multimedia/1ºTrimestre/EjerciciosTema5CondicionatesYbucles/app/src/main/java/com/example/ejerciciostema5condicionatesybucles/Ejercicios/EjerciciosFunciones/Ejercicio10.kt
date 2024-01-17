package com.example.ejerciciostema5condicionatesybucles.Ejercicios.EjerciciosFunciones

fun contarMultiplos() {
    var multiplosDeDos = 0
    var multiplosDeCinco = 0

    repeat(10) {
        print("Ingrese un valor: ")
        val valor = readLine()?.toIntOrNull() ?: 0
        if (valor % 2 == 0) {
            multiplosDeDos++
        }
        if (valor % 5 == 0) {
            multiplosDeCinco++
        }
    }

    println("Cantidad de valores múltiplos de 2: $multiplosDeDos")
    println("Cantidad de valores múltiplos de 5: $multiplosDeCinco")
}

fun main() {
    contarMultiplos()
}

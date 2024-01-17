package com.example.ejerciciostema5condicionatesybucles.Ejercicios.Arrays

fun arrayBidimensional() {
    val array = arrayOf(arrayOf(1, "Hola", true), arrayOf(2.5, false, 'c'))
    array.forEach { subArray ->
        subArray.forEach { element ->
            print("$element ")
        }
        println()
    }
}

fun main() {
    arrayBidimensional()
}

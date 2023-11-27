package com.example.ejerciciostema5condicionatesybucles.Ejercicios.Arrays

fun casting() {
    val numeroDouble: Double = 3.14
    val numeroInt: Int = numeroDouble.toInt()
    println("Número double: $numeroDouble")
    println("Número int (casteado desde double): $numeroInt")
}

fun main() {
    casting()
}

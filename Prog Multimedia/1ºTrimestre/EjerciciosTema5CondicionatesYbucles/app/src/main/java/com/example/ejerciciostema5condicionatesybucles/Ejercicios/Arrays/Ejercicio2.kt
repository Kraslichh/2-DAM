package com.example.ejerciciostema5condicionatesybucles.Ejercicios.Arrays

fun contarHaciaAtras() {
    val contador = Array(10) { 10 - it }
    contador.forEach { println(it) }
}

fun main() {
    contarHaciaAtras()
}

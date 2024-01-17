package com.example.ejerciciostema5condicionatesybucles.Ejercicios.Arrays

fun agregarValoresUsandoSet() {
    val numerosSet = mutableSetOf(1, 2, 3)
    numerosSet.add(4)
    numerosSet.add(5)
    numerosSet.forEach { println(it) }
}

fun main() {
    agregarValoresUsandoSet()
}

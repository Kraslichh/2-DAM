package com.example.ejerciciostema5condicionatesybucles.Ejercicios.Arrays

fun copiarYAnadirDatos() {
    val array1 = arrayOf(1, 2, 3)
    val array2 = arrayOf(*array1, 4, 5, 6) // Copia y añade nuevos datos
    array2.forEach { println(it) }
}

fun main() {
    copiarYAnadirDatos()
}

package com.example.ejerciciostema5condicionatesybucles.Ejercicios.Arrays

fun ejercicioCiudades() {
    val ciudadesAndalucia = arrayOf("Sevilla", "Málaga", "Cádiz", "Huelva", "Córdoba", "Granada", "Jaén", "Almería")
    ciudadesAndalucia.forEach { ciudad ->
        println(ciudad)
    }
}

fun main() {
    ejercicioCiudades()
}

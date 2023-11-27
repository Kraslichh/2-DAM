package com.example.ejerciciostema5condicionatesybucles.Ejercicios

fun contarPiezasAptas() {
    var cantidadPiezasAptas = 0
    val cantidadPiezas = readLine()?.toInt() ?: 0
    repeat(cantidadPiezas) {
        print("Ingrese la longitud del perfil $it: ")
        val longitud = readLine()?.toDouble() ?: 0.0
        if (longitud >= 1.20 && longitud <= 1.30) {
            cantidadPiezasAptas++
        }
    }
    println("Cantidad de piezas aptas: $cantidadPiezasAptas")
}

fun main() {
    println("Ingrese la cantidad de piezas a procesar: ")
    contarPiezasAptas()
}

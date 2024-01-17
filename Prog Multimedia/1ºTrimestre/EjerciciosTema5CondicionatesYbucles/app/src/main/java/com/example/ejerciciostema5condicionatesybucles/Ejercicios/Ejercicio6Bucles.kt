package com.example.ejerciciostema5condicionatesybucles.Ejercicios

fun determinarCuadrante() {
    print("Ingrese la coordenada X: ")
    val x = readLine()?.toIntOrNull() ?: 0
    print("Ingrese la coordenada Y: ")
    val y = readLine()?.toIntOrNull() ?: 0

    when {
        x > 0 && y > 0 -> println("El punto se encuentra en el 1er Cuadrante")
        x < 0 && y > 0 -> println("El punto se encuentra en el 2do Cuadrante")
        x < 0 && y < 0 -> println("El punto se encuentra en el 3er Cuadrante")
        x > 0 && y < 0 -> println("El punto se encuentra en el 4to Cuadrante")
        x == 0 || y == 0 -> println("El punto se encuentra en un eje")
        else -> println("El punto no se encuentra en ninguno de los cuadrantes")
    }
}

fun main() {
    determinarCuadrante()
}

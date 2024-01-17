package com.example.ejerciciostema5condicionatesybucles.Ejercicios.Funciones2

fun calcularCuadrado(lado: Int, opcion: Int) {
    when (opcion) {
        1 -> println("El perímetro del cuadrado es: ${lado * 4}")
        2 -> println("La superficie del cuadrado es: ${lado * lado}")
        else -> println("Opción inválida")
    }
}

fun main() {
    print("Ingrese el lado del cuadrado: ")
    val ladoCuadrado = readLine()?.toIntOrNull() ?: 0
    print("¿Qué desea calcular? (1 para perímetro, 2 para superficie): ")
    val opcionCalculo = readLine()?.toIntOrNull() ?: 0
    calcularCuadrado(ladoCuadrado, opcionCalculo)
}

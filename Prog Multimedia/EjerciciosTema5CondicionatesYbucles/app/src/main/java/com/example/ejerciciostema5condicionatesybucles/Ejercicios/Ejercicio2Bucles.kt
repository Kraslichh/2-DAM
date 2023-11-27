package com.example.ejerciciostema5condicionatesybucles.Ejercicios

fun contarDigitos() {
    var numero: Int
    do {
        print("Ingrese un número entre 0 y 999 (0 para finalizar): ")
        numero = readLine()?.toIntOrNull() ?: 0
        if (numero != 0) {
            val cantidadDigitos = numero.toString().length
            println("El número tiene $cantidadDigitos dígitos")
        }
    } while (numero != 0)
}

fun main() {
    contarDigitos()
}

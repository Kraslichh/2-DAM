package com.example.ejerciciostema5condicionatesybucles.Ejercicios

fun calcularYMostrarValor(numero: Int) {
    val resultado: Int
    val mensaje: String

    if (numero % 2 == 0) {
        resultado = numero * numero
        mensaje = "Se calculó el cuadrado: $resultado"
    } else {
        resultado = numero * numero * numero
        mensaje = "Se calculó el cubo: $resultado"
    }

    println(mensaje)
}

fun main() {
    val numeroIngresado = 7 // Cambia este valor para probar diferentes casos
    calcularYMostrarValor(numeroIngresado)
}

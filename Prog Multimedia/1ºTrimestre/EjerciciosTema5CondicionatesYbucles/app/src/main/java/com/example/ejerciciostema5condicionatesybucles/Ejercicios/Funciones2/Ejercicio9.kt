package com.example.ejerciciostema5condicionatesybucles.Ejercicios.Funciones2

fun subrayarTexto(texto: String, caracter: Char = '-') {
    println(texto)
    println(caracter.toString().repeat(texto.length))
}

fun main() {
    print("Ingrese un texto: ")
    val texto = readLine() ?: ""
    print("Ingrese el carácter de subrayado (opcional, presione Enter para usar '-'): ")
    val caracter = readLine()?.firstOrNull() ?: '-'
    subrayarTexto(texto, caracter)
}

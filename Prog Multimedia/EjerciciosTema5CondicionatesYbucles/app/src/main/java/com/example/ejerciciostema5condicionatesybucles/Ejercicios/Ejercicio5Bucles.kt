package com.example.ejerciciostema5condicionatesybucles.Ejercicios

fun contarNotas() {
    var mayoresOIgualesA7 = 0
    var menoresA7 = 0
    repeat(10) {
        print("Ingrese la nota del alumno ${it + 1}: ")
        val nota = readLine()?.toIntOrNull() ?: 0
        if (nota >= 7) {
            mayoresOIgualesA7++
        } else {
            menoresA7++
        }
    }
    println("Cantidad de alumnos con notas mayores o iguales a 7: $mayoresOIgualesA7")
    println("Cantidad de alumnos con notas menores a 7: $menoresA7")
}

fun main() {
    contarNotas()
}

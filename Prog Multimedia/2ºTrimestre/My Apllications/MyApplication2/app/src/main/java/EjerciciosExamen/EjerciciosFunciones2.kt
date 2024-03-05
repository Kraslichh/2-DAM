package EjerciciosExamen

import kotlin.random.Random

fun main() {
    println("Bienvenido al juego de Piedra, Papel o Tijeras")

    print("Ingresa el número de partidas que deseas jugar: ")
    val numPartidas = readLine()?.toIntOrNull() ?: 0

    var partidasUsuario = 0
    var partidasMaquina = 0

    repeat(numPartidas) {
        // Elección del usuario
        print("Elige: piedra, papel o tijeras: ")
        val eleccionUsuario = readLine()?.toLowerCase()

        // Elección aleatoria de la máquina
        val elecciones = listOf("piedra", "papel", "tijeras")
        val eleccionMaquina = elecciones[Random.nextInt(elecciones.size)]

        // Determinar el ganador de la partida
        val resultado = when {
            eleccionUsuario == eleccionMaquina -> "Empate"
            eleccionUsuario == "piedra" && eleccionMaquina == "tijeras" ||
                    eleccionUsuario == "papel" && eleccionMaquina == "piedra" ||
                    eleccionUsuario == "tijeras" && eleccionMaquina == "papel" -> {
                partidasUsuario++
                "Ganaste"
            }
            else -> {
                partidasMaquina++
                "Ganó la Máquina"
            }
        }

        // Mostrar resultado de la partida
        println("Usuario eligió: $eleccionUsuario, Máquina eligió: $eleccionMaquina. $resultado")
    }

    // Mostrar resultado final
    println("\nResultado Final:")
    println("Partidas ganadas por el usuario: $partidasUsuario")
    println("Partidas ganadas por la máquina: $partidasMaquina")
}

package EjerciciosExamen
// Clase base - Deporte
open class Deporte(val nombre: String, val tipoTerreno: String) {
    open fun mostrarDetalles() {
        println("Nombre: $nombre, Tipo de Terreno: $tipoTerreno")
    }
}

// Clases hijas - Deportes específicos
class Futbol(nombre: String, tipoTerreno: String, val numeroJugadores: Int, val esCampoGrande: Boolean) : Deporte(nombre, tipoTerreno) {
    override fun mostrarDetalles() {
        super.mostrarDetalles()
        println("Número de Jugadores: $numeroJugadores, ¿Es campo grande?: $esCampoGrande")
    }
}

class Baloncesto(nombre: String, tipoTerreno: String, val alturaCanasta: Double, val esDeporteEquipo: Boolean) : Deporte(nombre, tipoTerreno) {
    override fun mostrarDetalles() {
        super.mostrarDetalles()
        println("Altura de Canasta: $alturaCanasta, ¿Es deporte de equipo?: $esDeporteEquipo")
    }
}

class Balonmano(nombre: String, tipoTerreno: String, val esDeporteOlimpico: Boolean, val esContacto: Boolean) : Deporte(nombre, tipoTerreno) {
    override fun mostrarDetalles() {
        super.mostrarDetalles()
        println("¿Es deporte olímpico?: $esDeporteOlimpico, ¿Es deporte de contacto?: $esContacto")
    }
}

class Voleibol(nombre: String, tipoTerreno: String, val esDeportePlaya: Boolean, val numeroJugadoresEquipo: Int) : Deporte(nombre, tipoTerreno) {
    override fun mostrarDetalles() {
        super.mostrarDetalles()
        println("¿Es deporte de playa?: $esDeportePlaya, Número de jugadores por equipo: $numeroJugadoresEquipo")
    }
}

fun main() {
    // Crear instancias de cada deporte
    val futbol = Futbol("Fútbol", "Campo de césped", 11, true)
    val baloncesto = Baloncesto("Baloncesto", "Pista de baloncesto", 3.05, true)
    val balonmano = Balonmano("Balonmano", "Pista de balonmano", true, true)
    val voleibol = Voleibol("Voleibol", "Arena", true, 6)

    // Mostrar detalles de cada deporte
    println("Detalles del Fútbol:")
    futbol.mostrarDetalles()

    println("\nDetalles del Baloncesto:")
    baloncesto.mostrarDetalles()

    println("\nDetalles del Balonmano:")
    balonmano.mostrarDetalles()

    println("\nDetalles del Voleibol:")
    voleibol.mostrarDetalles()
}

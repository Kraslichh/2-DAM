package EjerciciosExamen
// Interfaz jugable
interface Jugable {
    fun jugable(nombreUsuario: String)
}

// Interfaz para hacer sonidos
interface SonidoAmbiente {
    fun reproducirSonido()
}
//Interfaz para guardar partida
interface GuardadoPartida{
    fun guardadoPartida()
}

// Clase Aventura que implementa Jugable,reporducirSonido y guardar partidas
class Aventura(s: String) : Jugable, SonidoAmbiente,GuardadoPartida {
    override fun jugable(nombreusuario: String) {
        println("El Juego Va a comenzar")
    }

    override fun reproducirSonido() {
        println("El Juego va a repodrudicir el sonido")
    }

    override fun guardadoPartida() {
        println("El Jugador Guardo la partida")
    }
}

// Clase Deportes que implementa Jugable,reporducirSonido y guardar partidas
class Deportes(nombre: String) : Jugable,SonidoAmbiente,GuardadoPartida {
    override fun jugable(nombreUsuario: String) {
        println("El Juego Va a comenzar")
    }

    override fun reproducirSonido() {
        println("El Juego va a repodrudicir el sonido")
    }
    override fun guardadoPartida() {
        println("El Jugador Guardo la partida")
    }
    // Clase Estatregias que implementa Jugable,reporducirSonido y guardar partidas
    class Estrategia(nombre: String) :Jugable,SonidoAmbiente,GuardadoPartida{
        override fun jugable(nombreUsuario: String) {
            println("El Juego Va a comenzar")
        }

        override fun reproducirSonido() {
            println("El Juego va a repodrudicir el sonido")
        }

        override fun guardadoPartida() {
            println("El Jugador Guardo la partida")
        }
    }
}
//Main donde se desarrolla todo
fun main() {
    // Crea instancias de Deportes ,estrategias y aventuras
    val Destiny = Aventura("Destiny")
    val fifa24 = Deportes("Fifa 24")
    val DayZ=Deportes.Estrategia("Day Z")
    //Llama a sus métodos y los imprime
    Destiny.jugable("Paco")
    Destiny.reproducirSonido()
    Destiny.guardadoPartida()
    println()
    fifa24.jugable("Juan")
    fifa24.reproducirSonido()
    fifa24.guardadoPartida()
    println()
    DayZ.jugable("Miguel")
    DayZ.reproducirSonido()
    DayZ.guardadoPartida()





}
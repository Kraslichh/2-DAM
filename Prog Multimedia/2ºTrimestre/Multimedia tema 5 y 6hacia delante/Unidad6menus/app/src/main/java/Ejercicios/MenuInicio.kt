package Ejercicios

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.unidad6menus.R

class MenuInicio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_inicio)

        val botonEjercicio1 = findViewById<Button>(R.id.buttonEjercicio1)
        botonEjercicio1.setOnClickListener {
            navegarAEjercicio(1)
        }

        val botonEjercicio2 = findViewById<Button>(R.id.buttonEjercicio2)
        botonEjercicio2.setOnClickListener {
            navegarAEjercicio(2)
        }

        val botonEjercicio3 = findViewById<Button>(R.id.buttonEjercicio3)
        botonEjercicio3.setOnClickListener {
            navegarAEjercicio(3)
        }
    }

    private fun navegarAEjercicio(numeroEjercicio: Int) {
        // Dependiendo del número de ejercicio, puedes abrir la misma actividad
        // o cambiar la clase de actividad en consecuencia.
        val intent = Intent(this, Ejercicios.MenuInicio::class.java)
        intent.putExtra("numeroEjercicio", numeroEjercicio)
        startActivity(intent)
    }
}

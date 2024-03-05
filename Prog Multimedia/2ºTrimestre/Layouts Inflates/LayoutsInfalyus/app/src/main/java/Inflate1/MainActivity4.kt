package Inflate1

import android.view.View
import com.example.layoutsinfalyus.R
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflar el diseño XML correcto (activity_main.xml)
        val rootView: View = LayoutInflater.from(this).inflate(R.layout.activity_main4, null)

        // Obtener referencia al LinearLayout
        val linearLayout = rootView.findViewById<LinearLayout>(R.id.linearLayoutContainer)

        // Crear un nuevo TextView dinámicamente
        val nuevoTextView = TextView(this)
        nuevoTextView.text = "Hola, Alberto"

        // Agregar el nuevo TextView al contenedor
        linearLayout.addView(nuevoTextView)

        // Establecer la vista inflada en la actividad
        setContentView(rootView)
    }
}

package com.example.apuntesexamen
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Encuentra el botón por su ID y configura el evento de clic
        val buttonSolicitarCita = findViewById<Button>(R.id.buttonSolicitarCita)
        buttonSolicitarCita.setOnClickListener {
            // Inicia SegundaActividad cuando se presiona el botón
            val intent = Intent(this, SegundaActividad::class.java)
            startActivity(intent)
        }

    }
}
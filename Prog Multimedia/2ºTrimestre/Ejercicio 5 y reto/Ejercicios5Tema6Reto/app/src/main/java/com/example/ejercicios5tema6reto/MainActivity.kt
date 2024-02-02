package com.example.ejercicios5tema6reto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addButton: Button = findViewById(R.id.add_field_button)
        val container: LinearLayout = findViewById(R.id.container)

        addButton.setOnClickListener {
            // Inflar la vista personalizada y añadirla al contenedor
            val inflater: LayoutInflater = LayoutInflater.from(this)
            val view = inflater.inflate(R.layout.custom_input_field, container, false)
            container.addView(view)
        }
    }
}
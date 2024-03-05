package com.example.ejersegundaappejer7

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainDatos : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_datos)

        val btnLogin: Button = findViewById(R.id.btnLogin)
        val etNombre: EditText = findViewById(R.id.etNombre)
        val etApellidos: EditText = findViewById(R.id.etApellidos)
        val etCurso: EditText = findViewById(R.id.etCurso)
        val etAsignatura: EditText = findViewById(R.id.etAsignatura)
        val etNota: EditText = findViewById(R.id.etNota)

        btnLogin.setOnClickListener(View.OnClickListener {
            // Obtener los valores de los EditText
            val nombre = etNombre.text.toString()
            val apellidos = etApellidos.text.toString()
            val curso = etCurso.text.toString()
            val asignatura = etAsignatura.text.toString()
            val nota = etNota.text.toString()

            // Crear un intent y pasar datos
            val intent = Intent(this@MainDatos, MostrarDatos::class.java)
            intent.putExtra("EXTRA_NAME", nombre)
            intent.putExtra("EXTRA_APELLIDOS", apellidos)
            intent.putExtra("EXTRA_CURSO", curso)
            intent.putExtra("EXTRA_ASIGNATURA", asignatura)
            intent.putExtra("EXTRA_NOTAS", nota)

            // Iniciar la nueva actividad (MostrarDatos) con datos adicionales
            startActivity(intent)
        })
    }
}

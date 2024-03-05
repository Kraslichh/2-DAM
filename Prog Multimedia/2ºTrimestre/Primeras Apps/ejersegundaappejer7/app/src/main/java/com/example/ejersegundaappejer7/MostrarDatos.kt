package com.example.ejersegundaappejer7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MostrarDatos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar_datos)

        val resultadoname = findViewById<TextView>(R.id.tvResultName)
        val name: String = intent.extras?.getString("EXTRA_NAME").orEmpty()
        resultadoname.text = "Nombre: $name"

        val resultadoapellidos = findViewById<TextView>(R.id.tvResultApellidos)
        val apellidos: String = intent.extras?.getString("EXTRA_APELLIDOS").orEmpty()
        resultadoapellidos.text = "Apellidos: $apellidos"

        val resultadocurso = findViewById<TextView>(R.id.tvResultCurso)
        val curso: String = intent.extras?.getString("EXTRA_CURSO").orEmpty()
        resultadocurso.text = "Curso: $curso"

        val resultadoasignatura = findViewById<TextView>(R.id.tvResultAsignatura)
        val asignatura: String = intent.extras?.getString("EXTRA_ASIGNATURA").orEmpty()
        resultadoasignatura.text = "Asignatura: $asignatura"

        val resultadonotas = findViewById<TextView>(R.id.tvResultNotas)
        val notas: String = intent.extras?.getString("EXTRA_NOTAS").orEmpty()
        resultadonotas.text = "Notas: $notas"
    }
}


package com.example.recicledviewtrabajos

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

val trabajos = listOf(
    Trabajos("Proyecto de Desarrollo de Software", listOf(
        Subject("Análisis de Requisitos"),
        Subject("Diseño de la Arquitectura"),
        Subject("Implementación del Código"),
        Subject("Pruebas de Software")
    )),
    Trabajos("Investigación en Inteligencia Artificial", listOf(
        Subject("Aprendizaje Automático"),
        Subject("Procesamiento de Lenguaje Natural"),
        Subject("Visión por Computadora"),
        Subject("Ética en Inteligencia Artificial")
    )),
    Trabajos("Desarrollo de Aplicaciones Móviles", listOf(
        Subject("Diseño de Interfaces de Usuario"),
        Subject("Programación en Kotlin"),
        Subject("Integración de Servicios Web"),
        Subject("Pruebas en Dispositivos Móviles")
    )),
    Trabajos("Gestión de Proyectos de TI", listOf(
        Subject("Planificación y Control de Proyectos"),
        Subject("Gestión de Recursos"),
        Subject("Calidad en Proyectos de TI"),
        Subject("Evaluación de Riesgos")
    ))
)

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Corrige el ID del RecyclerView
        val recyclerViewTrabajos: RecyclerView = findViewById(R.id.recyclerView)
        recyclerViewTrabajos.layoutManager = LinearLayoutManager(this)

        // Cambia la creación del adaptador a TrabajosAdapter
        recyclerViewTrabajos.adapter = TrabajosAdapter(trabajos) { trabajo ->
            showSubjectsDialog(trabajo)
        }
    }

    private fun showSubjectsDialog(trabajo: Trabajos) {
        val subjects = trabajo.subjects.map { it.name }.toTypedArray()

        AlertDialog.Builder(this)
            .setTitle("Actividades de ${trabajo.name}")
            .setItems(subjects) { _, _ ->
                // Acción al hacer clic en una actividad (puedes implementar algo aquí)
            }
            .setPositiveButton("Aceptar") { dialog, _ ->
                dialog.dismiss()
            }
            .create()
            .show()
    }
}

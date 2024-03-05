package com.example.recicledviewasignaturas
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.appcompat.app.AlertDialog



val courses = listOf(
    Course("1º DAM", listOf(Subject("Programación"), Subject("Bases de Datos"), Subject("Redes"))),
    Course("2º DAM", listOf(Subject("Desarrollo Web"), Subject("Seguridad"), Subject("Empresas")))
)

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerViewCourses: RecyclerView = findViewById(R.id.recyclerView)
        recyclerViewCourses.layoutManager = LinearLayoutManager(this)
        recyclerViewCourses.adapter = CourseAdapter(courses) { course ->
            showSubjectsDialog(course)
        }
    }

    private fun showSubjectsDialog(course: Course) {
        val subjects = course.subjects.map { it.name }.toTypedArray()

        AlertDialog.Builder(this)
            .setTitle("Asignaturas de ${course.name}")
            .setItems(subjects) { _, _ ->
                // Acción al hacer clic en una asignatura (puedes implementar algo aquí)
            }
            .setPositiveButton("Aceptar") { dialog, _ ->
                dialog.dismiss()
            }
            .create()
            .show()
    }
}

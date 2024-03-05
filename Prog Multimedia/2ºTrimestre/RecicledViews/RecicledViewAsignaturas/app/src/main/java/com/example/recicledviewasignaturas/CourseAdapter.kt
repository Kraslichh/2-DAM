package com.example.recicledviewasignaturas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CourseAdapter(private val courses: List<Course>, private val onCourseClickListener: (Course) -> Unit) :
    RecyclerView.Adapter<CourseAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_course, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val course = courses[position]

        // Aquí es donde debes obtener el TextView dentro de la vista item_course.xml
        val courseTextView: TextView = holder.itemView.findViewById(R.id.courseNameTextView)

        // Ahora, establece el texto en el TextView
        courseTextView.text = course.name

        // Asigna el clic al itemView (puede seguir usándolo si es necesario)
        holder.itemView.setOnClickListener { onCourseClickListener(course) }
    }

    override fun getItemCount(): Int = courses.size
}

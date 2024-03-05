package com.example.proyectofragmentos2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment

class AlumnoListFragment : Fragment() {

    interface OnAlumnoSelectedListener {
        fun onAlumnoSelected(alumno: Alumno)
    }

    private val alumnos = arrayOf(
        Alumno("Juan"),
        Alumno("María"),
        Alumno("Pedro")
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_alumno_list, container, false)
        val listViewAlumnos = view.findViewById<ListView>(R.id.listViewAlumnos)

        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, alumnos.map { it.nombre })
        listViewAlumnos.adapter = adapter

        listViewAlumnos.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val alumno = alumnos[position]
            (requireActivity() as? OnAlumnoSelectedListener)?.onAlumnoSelected(alumno)
        }

        return view
    }
}

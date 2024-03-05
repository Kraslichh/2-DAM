package com.example.proyectofragmentos2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class AlumnoDetailFragment : Fragment() {

    companion object {
        private const val ARG_ALUMNO_NOMBRE = "arg_alumno_nombre"

        fun newInstance(nombre: String): AlumnoDetailFragment {
            val fragment = AlumnoDetailFragment()
            val args = Bundle()
            args.putString(ARG_ALUMNO_NOMBRE, nombre)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_alumno_detail, container, false)
        val textViewNombre = view.findViewById<TextView>(R.id.textViewNombre)

        arguments?.let { args ->
            val nombre = args.getString(ARG_ALUMNO_NOMBRE)
            textViewNombre.text = "Nombre: $nombre"
        }

        return view
    }
}



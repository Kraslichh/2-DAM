package com.example.proyectofragmentos2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), AlumnoListFragment.OnAlumnoSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, AlumnoListFragment())
                .commit()
        }
    }

    override fun onAlumnoSelected(alumno: Alumno) {
        val fragment = AlumnoDetailFragment.newInstance(alumno.nombre)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }
}

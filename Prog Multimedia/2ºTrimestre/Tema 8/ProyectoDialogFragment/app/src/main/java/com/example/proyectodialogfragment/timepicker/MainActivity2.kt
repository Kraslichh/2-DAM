package com.example.proyectodialogfragment.timepicker

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.proyectodialogfragment.R

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Mostrar el diálogo cuando se inicia la actividad
        val dialogFragment = MyTimePickerDialogFragment()
        dialogFragment.show(supportFragmentManager, "MyTimePickerDialogFragment")
    }
}

package com.example.proyectodialogfragment.timepicker
import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment

class MyTimePickerDialogFragment : DialogFragment(), TimePickerDialog.OnTimeSetListener {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // Obtener la hora actual
        val hour = 12
        val minute = 0

        // Crear y devolver el diálogo del selector de tiempo
        return TimePickerDialog(requireContext(), this, hour, minute, false)
    }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        // Manejar la hora seleccionada aquí
        val time = "Hora seleccionada: $hourOfDay:$minute"
        // Puedes hacer lo que quieras con el tiempo seleccionado, como mostrarlo en un TextView
    }
}

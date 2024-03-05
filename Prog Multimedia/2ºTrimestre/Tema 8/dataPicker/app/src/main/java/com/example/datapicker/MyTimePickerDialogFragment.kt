package com.example.datapicker
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
        val selectedTime = "$hourOfDay:$minute"
        val activity = activity as? MainActivity2
        activity?.updateSelectedTime(selectedTime)
    }
}

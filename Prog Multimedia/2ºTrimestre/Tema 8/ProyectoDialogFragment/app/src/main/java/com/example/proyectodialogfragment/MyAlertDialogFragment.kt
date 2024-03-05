package com.example.proyectodialogfragment

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class MyAlertDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(requireActivity())
            .setTitle("¡Hola!")
            .setMessage("¿Estás seguro de que quieres continuar?")
            .setPositiveButton("Sí") { dialog, which ->
                // Acción a realizar cuando se hace clic en el botón "Sí"
            }
            .setNegativeButton("No") { dialog, which ->
                // Acción a realizar cuando se hace clic en el botón "No"
                dialog.dismiss()
            }
            .create()
    }
}

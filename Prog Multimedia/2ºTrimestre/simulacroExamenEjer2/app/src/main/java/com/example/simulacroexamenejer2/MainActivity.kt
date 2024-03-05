package com.example.simulacroexamenejer2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.TimePicker
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.File
import java.io.FileWriter
import java.security.MessageDigest
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var showVideosAndAnimationsButton: Button
    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var saveUserInfoButton: Button
    private lateinit var datePicker: DatePicker
    private lateinit var timePicker: TimePicker

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Vinculando elementos del layout con las variables en Kotlin
        showVideosAndAnimationsButton = findViewById(R.id.showVideosAndAnimationsButton)
        usernameEditText = findViewById(R.id.usernameEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        saveUserInfoButton = findViewById(R.id.saveUserInfoButton)
        datePicker = findViewById(R.id.datePicker)
        timePicker = findViewById(R.id.timePicker)

        // Establecer un listener para el botón para mostrar videos y animaciones
        showVideosAndAnimationsButton.setOnClickListener {
            // Abrir la segunda pantalla
            val intent = Intent(this, VideosActivity::class.java)
            startActivity(intent)
        }

        // Establecer un listener para el botón para guardar el usuario, contraseña encriptada, fecha y hora
        saveUserInfoButton.setOnClickListener {
            guardarUsuarioYFecha()
        }
    }

    // Método para guardar el nombre de usuario, contraseña encriptada, fecha y hora
    private fun guardarUsuarioYFecha() {
        val username = usernameEditText.text.toString()
        val password = passwordEditText.text.toString()
        val encryptedPassword = encryptPassword(password) // Encriptar la contraseña
        val selectedDate = getSelectedDate()
        val selectedTime = getSelectedTime()

        try {
            val file = File(filesDir, "user_info.txt")
            val fileWriter = FileWriter(file, true)
            fileWriter.append("$username - $encryptedPassword - $selectedDate - $selectedTime\n") // Guardar datos
            fileWriter.close()

            // Mostrar mensaje Toast con confirmación
            val toastMessage = "¡Usuario \"$username\" y contraseña encriptada guardados correctamente!"
            Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show()

            // Imprimir en la consola la confirmación y la ubicación del archivo
            val consoleMessage =
                "¡Usuario y contraseña encriptada guardados!\nNombre de usuario: $username\nContraseña encriptada: $encryptedPassword\nFecha: $selectedDate\nHora: $selectedTime\nArchivo guardado en: ${file.absolutePath}"
            Log.d("MainActivity", consoleMessage)
        } catch (e: Exception) {
            // En caso de error, registrar el error en la consola y mostrar un mensaje Toast
            Log.e("MainActivity", "Error al guardar la información del usuario: ${e.message}")
            Toast.makeText(this, "Error al guardar la información del usuario", Toast.LENGTH_SHORT).show()
        }
    }

    // Función para encriptar la contraseña usando SHA-256
    private fun encryptPassword(password: String): String {
        val bytes = MessageDigest.getInstance("SHA-256").digest(password.toByteArray())
        return bytes.joinToString("") { "%02x".format(it) }
    }

    // Función para obtener la fecha seleccionada del DatePicker
    private fun getSelectedDate(): String {
        val day = datePicker.dayOfMonth
        val month = datePicker.month + 1 // El mes se devuelve como índice base cero, por lo que sumamos 1
        val year = datePicker.year
        return "$day-$month-$year"
    }

    // Función para obtener la hora seleccionada del TimePicker
    private fun getSelectedTime(): String {
        val hour = timePicker.hour
        val minute = timePicker.minute
        return "$hour:$minute"
    }
}

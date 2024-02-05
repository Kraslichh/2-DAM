package com.example.apuntesexamen

import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SegundaActividad : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda_actividad)

        // Botón Volver
        val btnVolver = findViewById<Button>(R.id.btnVolver)
        btnVolver.setOnClickListener {
            finish()
        }

        // Botón Pedir Cita
        val btnPedirCita = findViewById<Button>(R.id.btnPedirCita)
        btnPedirCita.setOnClickListener {
            val nombre = findViewById<TextView>(R.id.nombreTextView).text.toString()
            val apellido = findViewById<TextView>(R.id.apellidoTextView).text.toString()
            val fecha = findViewById<TextView>(R.id.fechaTextView).text.toString()

            // Obtener altura y peso del usuario
            val alturaEditText = findViewById<EditText>(R.id.alturaEditText)
            val pesoEditText = findViewById<EditText>(R.id.pesoEditText)

            val alturaStr = alturaEditText.text.toString()
            val pesoStr = pesoEditText.text.toString()

            // Verificar que se hayan ingresado valores válidos
            if (alturaStr.isEmpty() || pesoStr.isEmpty()) {
                // Mostrar un Toast si faltan datos
                val mensaje = "Por favor, ingrese su altura y peso para calcular el IMC."
                mostrarToast(mensaje)
            } else {
                val altura = alturaStr.toFloat()
                val peso = pesoStr.toFloat()

                // Calcular el IMC
                val imc = calcularIMC(altura, peso)

                // Mostrar el resultado en un TextView
                val calculoTextView = findViewById<TextView>(R.id.calculoTextView)
                calculoTextView.text = "Su IMC es: $imc"

                // Calcular TMB, TMA y FCM
                val edadTMBEditText = findViewById<EditText>(R.id.tmbTextView)
                val duracionTMAEditText = findViewById<EditText>(R.id.tmaEditText)
                val edadFCMEditText = findViewById<EditText>(R.id.fcmEditText)

                val edadTMBStr = edadTMBEditText.text.toString()
                val duracionTMAStr = duracionTMAEditText.text.toString()
                val edadFCMStr = edadFCMEditText.text.toString()

                if (edadTMBStr.isEmpty() || duracionTMAStr.isEmpty() || edadFCMStr.isEmpty()) {
                    val mensaje = "Por favor, complete todos los campos de cálculo."
                    mostrarToast(mensaje)
                } else {
                    val edadTMB = edadTMBStr.toInt()
                    val duracionTMA = duracionTMAStr.toInt()
                    val edadFCM = edadFCMStr.toInt()

                    // Calcular TMB, TMA y FCM aquí
                    val tmb = calcularTMB(edadTMB, altura, peso)
                    val tma = calcularTMA(tmb, duracionTMA)
                    val fcm = calcularFCM(edadFCM)

                    // Mostrar los resultados en TextViews
                    val tmbTextView = findViewById<TextView>(R.id.tmbTextView)
                    val tmaTextView = findViewById<TextView>(R.id.tmaEditText)
                    val fcmTextView = findViewById<TextView>(R.id.fcmEditText)

                    tmbTextView.text = "Su TMB es: $tmb"
                    tmaTextView.text = "Su TMA es: $tma"
                    fcmTextView.text = "Su FCM es: $fcm"

                    // Mensaje de éxito
                    val mensajeExito = "Cita de Urgencias pedida con éxito\nNombre: $nombre\nApellido: $apellido\nFecha: $fecha"
                    mostrarToast(mensajeExito)
                }
            }
        }
    }

    private fun calcularIMC(altura: Float, peso: Float): Float {
        // Fórmula del IMC: IMC = peso (kg) / (altura (m) * altura (m))
        return peso / (altura * altura)
    }

    private fun calcularTMB(edad: Int, altura: Float, peso: Float): Float {
        // Fórmula del TMB (Tasa Metabólica Basal): TMB = 88.362 + (13.397 x peso en kg) + (4.799 x altura en cm) - (5.677 x edad en años)
        return 88.362f + (13.397f * peso) + (4.799f * (altura * 100)) - (5.677f * edad)
    }

    private fun calcularTMA(tmb: Float, duracionEjercicio: Int): Float {
        // Fórmula del TMA (Tasa Metabólica Activa): TMA = TMB x Factor de actividad (según el tipo y duración del ejercicio)
        // Supongamos que el factor de actividad es 1.2 para este ejemplo
        val factorActividad = 1.2f
        return tmb * factorActividad * (duracionEjercicio / 60.0f) // Dividido por 60 para convertir minutos a horas
    }

    private fun calcularFCM(edad: Int): Int {
        // Fórmula de la FCM (Frecuencia Cardíaca Máxima): FCM = 220 - edad
        return 220 - edad
    }

    private fun mostrarToast(mensaje: String) {
        // Crear el Toast personalizado
        val inflater = layoutInflater
        val container = findViewById<ViewGroup>(R.id.custom_toast_container)
        val layout = inflater.inflate(R.layout.custom_toast, container)
        val text: TextView = layout.findViewById(R.id.text)
        text.text = mensaje

        with (Toast(applicationContext)) {
            setGravity(Gravity.CENTER_VERTICAL, 0, 0)
            duration = Toast.LENGTH_LONG
            view = layout
            show()
        }
    }
}

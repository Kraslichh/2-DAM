package com.example.datapicker
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // Mostrar el diálogo cuando se inicia la actividad
        val dialogFragment = MyTimePickerDialogFragment()
        dialogFragment.show(supportFragmentManager, "MyTimePickerDialogFragment")
    }

    fun updateSelectedTime(time: String) {
        val textViewSelectedTime = findViewById<TextView>(R.id.textViewSelectedTime)
        textViewSelectedTime.text = time
    }
}


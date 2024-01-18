package com.example.ejercicio5misprimerasapps

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextName = findViewById<EditText>(R.id.editTextName)
        val buttonSubmit = findViewById<Button>(R.id.buttonSubmit)

        buttonSubmit.setOnClickListener {
            val intent = Intent(this, WelcomeActivity::class.java).apply {
                putExtra(WelcomeActivity.EXTRA_NAME, editTextName.text.toString())
            }
            startActivity(intent)
        }
    }
}

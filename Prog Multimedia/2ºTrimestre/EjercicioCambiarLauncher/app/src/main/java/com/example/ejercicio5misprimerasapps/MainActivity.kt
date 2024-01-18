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

        val nameEditText = findViewById<EditText>(R.id.editTextName)
        val lastNameEditText = findViewById<EditText>(R.id.editTextLastName)
        val courseEditText = findViewById<EditText>(R.id.editTextCourse)
        val subjectEditText = findViewById<EditText>(R.id.editTextSubject)
        val gradeEditText = findViewById<EditText>(R.id.editTextGrade)
        val buttonSubmit = findViewById<Button>(R.id.buttonSubmit)

        buttonSubmit.setOnClickListener {
            val intent = Intent(this, WelcomeActivity::class.java).apply {
                putExtra(WelcomeActivity.EXTRA_NAME, nameEditText.text.toString())
                putExtra(WelcomeActivity.EXTRA_LAST_NAME, lastNameEditText.text.toString())
                putExtra(WelcomeActivity.EXTRA_COURSE, courseEditText.text.toString())
                putExtra(WelcomeActivity.EXTRA_SUBJECT, subjectEditText.text.toString())
                putExtra(WelcomeActivity.EXTRA_GRADE, gradeEditText.text.toString())
            }
            startActivity(intent)
        }
    }
}

package com.example.ejercicio5misprimerasapps

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class WelcomeActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_NAME = "EXTRA_NAME"
        const val EXTRA_LAST_NAME = "EXTRA_LAST_NAME"
        const val EXTRA_COURSE = "EXTRA_COURSE"
        const val EXTRA_SUBJECT = "EXTRA_SUBJECT"
        const val EXTRA_GRADE = "EXTRA_GRADE"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val name = intent.getStringExtra(EXTRA_NAME)
        val lastName = intent.getStringExtra(EXTRA_LAST_NAME)
        val course = intent.getStringExtra(EXTRA_COURSE)
        val subject = intent.getStringExtra(EXTRA_SUBJECT)
        val grade = intent.getStringExtra(EXTRA_GRADE)

        val welcomeTextView = findViewById<TextView>(R.id.textViewWelcome)
        welcomeTextView.text = getString(R.string.welcome_message, name)

        val detailsTextView = findViewById<TextView>(R.id.textViewDetails)
        detailsTextView.text = getString(
            R.string.details_format, lastName, course, subject, grade
        )
    }
}

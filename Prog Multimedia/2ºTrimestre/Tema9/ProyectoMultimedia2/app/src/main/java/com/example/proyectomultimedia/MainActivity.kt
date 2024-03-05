package com.example.proyectomultimedia

import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Encuentra los ImageViews en el layout usando sus IDs respectivos
        val imageView1 = findViewById<ImageView>(R.id.imageView)
        val imageView2 = findViewById<ImageView>(R.id.imageView1)
        val imageView3 = findViewById<ImageView>(R.id.imageView2)
        val imageView4 = findViewById<ImageView>(R.id.imageView3)

        // Cargar las animaciones personalizadas para cada ImageView
        val animation1: Animation = AnimationUtils.loadAnimation(this, R.anim.rotation)
        val animation2: Animation = AnimationUtils.loadAnimation(this, R.anim.slide_in)
        val animation3: Animation = AnimationUtils.loadAnimation(this, R.anim.combined)
        val animation4: Animation = AnimationUtils.loadAnimation(this, R.anim.scale)

        // Aplicar las animaciones a cada ImageView
        imageView1.startAnimation(animation1)
        imageView2.startAnimation(animation2)
        imageView3.startAnimation(animation3)
        imageView4.startAnimation(animation4)
    }
}

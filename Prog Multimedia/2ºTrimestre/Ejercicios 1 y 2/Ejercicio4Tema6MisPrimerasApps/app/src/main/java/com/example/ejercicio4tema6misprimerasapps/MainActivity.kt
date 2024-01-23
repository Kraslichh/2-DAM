package com.example.ejercicio4tema6misprimerasapps

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.ejercicio4tema6misprimerasapps.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}

package com.example.proyectofragmentobasico

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class HelloFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_hello, container, false)
        val buttonGoodbye = view.findViewById<Button>(R.id.buttonGoodbye)

        buttonGoodbye.setOnClickListener {
            (activity as MainActivity).displayGoodbyeFragment()
        }

        return view
    }
}

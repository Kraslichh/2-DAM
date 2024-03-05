package com.example.layoutinflater.inflate1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.layoutinflater.R;

public class MainActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflar el diseño XML
        //LayoutInflater crear un objeto layoutinflater
        // .inflate se infla con este metodo usando el layoutinflater
        //
        View rootView = LayoutInflater.from(this).inflate(R.layout.activity_main, null);

        // Obtener referencia al TextView inflado
        TextView textView = rootView.findViewById(R.id.textView1);

        // Establecer la vista inflada en la actividad
        setContentView(rootView);
    }
}



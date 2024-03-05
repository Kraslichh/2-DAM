package com.example.layoutinflater.inflate4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.layoutinflater.R;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Inflar el diseño XML
        View rootView = LayoutInflater.from(this).inflate(R.layout.activity_main4, null);

        // Obtener referencia al linearLayout (puedes usar el tipo de layout que estés utilizando)
        LinearLayout linearLayout = rootView.findViewById(R.id.linearLayoutContainer);

        // Crear un nuevo TextView dinámicamente
        TextView nuevoTextView = new TextView(this);
        nuevoTextView.setText("Hola, Alberto");

        // Agregar el nuevo TextView al contenedor
        linearLayout.addView(nuevoTextView);

        // Establecer la vista inflada en la actividad
        setContentView(rootView);
    }
}
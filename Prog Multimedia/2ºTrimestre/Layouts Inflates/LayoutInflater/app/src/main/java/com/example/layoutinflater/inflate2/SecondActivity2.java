package com.example.layoutinflater.inflate2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.layoutinflater.R;

public class SecondActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflar el diseño XML de la segunda actividad
        View rootView = LayoutInflater.from(this).inflate(R.layout.activity_second2, null);
        setContentView(rootView);

        // Obtener referencia al TextView y al botón en la segunda actividad
        TextView textViewSecondActivity = findViewById(R.id.textViewSecondActivity);
        Button btnBackToMainActivity = findViewById(R.id.btnOpenMainActivity);

        // Configurar el texto del TextView
        textViewSecondActivity.setText("¡Bienvenido a la Segunda Actividad!");

        // Configurar el clic del botón para volver a la actividad principal
        btnBackToMainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Finalizar la segunda actividad y volver a la actividad principal
                finish();
            }
        });
    }
}

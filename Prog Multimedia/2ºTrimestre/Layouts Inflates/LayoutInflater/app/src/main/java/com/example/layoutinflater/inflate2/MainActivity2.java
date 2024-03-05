package com.example.layoutinflater.inflate2;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.layoutinflater.R;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflar el diseño XML de la actividad
        //LayoutInflater crear un objeto layoutinflater
        // .inflate se infla con este metodo usando el layoutinflater
        //
        View Vista1 = LayoutInflater.from(this).inflate(R.layout.activity_main2, null);
        setContentView(Vista1);
        //con el botón nos vamos al secondActivity2
        // Obtener referencia al botón en la actividad
        Button btnOpenSecondActivity = findViewById(R.id.btnOpenSecondActivity);

        // Verificar si el botón es nulo antes de configurar el clic
        if (btnOpenSecondActivity != null) {
            // Configurar el clic del botón para abrir SecondActivity2
            btnOpenSecondActivity.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Iniciar SecondActivity2
                    Intent intent = new Intent(MainActivity2.this, SecondActivity2.class);
                    startActivity(intent);
                }
            });
        }
    }
}

package com.example.layoutinflater.inflate3;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.layoutinflater.R;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflar el diseño XML de la actividad principal
        //LayoutInflater crear un objeto layoutinflater
        // .inflate se infla con este metodo usando el layoutinflater
        //root null se usa cuando no hay raiz especifica, en estos ejemplos
        //podemos usar mejor false que null desde la versión 24
        View rootView = LayoutInflater.from(this).inflate(R.layout.activity_main3, null);
        setContentView(rootView);

        // Obtener referencia al botón en la actividad principal
        Button btnGoToImages = findViewById(R.id.btnGoToImages);

        // Configurar el clic del botón para ir a la actividad de imágenes
        btnGoToImages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Iniciar la actividad de imágenes
                Intent intent = new Intent(MainActivity3.this, ImagesActivity3.class);
                startActivity(intent);
            }
        });
    }
}

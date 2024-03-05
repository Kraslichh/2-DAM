package com.example.layoutinflater.inflate3;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.layoutinflater.R;

public class ImagesActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

          /*  Inflar el diseño XML de la actividad de imágenes
         Inflar el diseño XML de la actividad principal
        LayoutInflater crear un objeto layoutinflater
         .inflate se infla con este metodo usando el layoutinflater
        es imporante entender que cuando creamos un activity con un por ejemplo
      un constraintlayout, ese único contrainstlayout actua como un viewgroup, lo cual
      no quiere decir que no tenga otros viewgroup, en este caso como solo hay uno
      pondriamos esa referencia en null, porque hacemos referencia al principal.
        *
        * */
        View rootView = LayoutInflater.from(this).inflate(R.layout.activity_images, null);
        setContentView(rootView);

        // Obtener referencias a los botones de imágenes
        Button btnImage1 = findViewById(R.id.btnImage1);
        Button btnImage2 = findViewById(R.id.btnImage2);
        Button btnImage3 = findViewById(R.id.btnImage3);

        // Configurar clics de los botones para ir a la actividad del contenedor
        btnImage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Iniciar la actividad del contenedor con un mensaje específico
                startContainerActivity("Has seleccionado Imagen 1");
            }
        });

        btnImage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Iniciar la actividad del contenedor con un mensaje específico
                startContainerActivity("Has seleccionado Imagen 2");
            }
        });

        btnImage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Iniciar la actividad del contenedor con un mensaje específico
                startContainerActivity("Has seleccionado Imagen 3");
            }
        });
    }

    private void startContainerActivity(String message) {
        Intent intent = new Intent(ImagesActivity3.this, ContainerActivity.class);
        // message es una variable que definimos en containerActivity
        intent.putExtra("message", message);
        startActivity(intent);
    }
}

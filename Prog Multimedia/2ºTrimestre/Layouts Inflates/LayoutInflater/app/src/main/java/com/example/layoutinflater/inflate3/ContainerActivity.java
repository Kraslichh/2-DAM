package com.example.layoutinflater.inflate3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.layoutinflater.R;

public class ContainerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflar el diseño XML de la actividad del contenedor
        View rootView = LayoutInflater.from(this).inflate(R.layout.activity_container, null);
        setContentView(rootView);

        // Obtener referencia al TextView en la actividad del contenedor
        TextView tvContainerText = findViewById(R.id.tvContainerText);

        // Obtener el mensaje de la actividad anterior imagesActivity3
        String message = getIntent().getStringExtra("message");

        // Configurar el texto del TextView con el mensaje qde imagesActivity3
        tvContainerText.setText(message);
    }
}

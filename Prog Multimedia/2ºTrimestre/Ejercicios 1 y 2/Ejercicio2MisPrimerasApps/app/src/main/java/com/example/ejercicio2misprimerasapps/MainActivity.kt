package com.example.ejercicio2misprimerasapps

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ejercicio2misprimerasapps.ui.theme.Ejercicio2MisPrimerasAppsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Ejercicio2MisPrimerasAppsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CenteredButtonScreen()
                }
            }
        }
    }
}

@Composable
fun CenteredButtonScreen() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        ButtonRow()
    }
}

@Composable
fun ButtonRow() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.wrapContentSize()
    ) {
        Button(
            onClick = { /* TODO: Handle Aceptar */ }
        ) {
            Text("Aceptar")
        }
        Spacer(modifier = Modifier.width(8.dp))
        Button(
            onClick = { /* TODO: Handle Cancelar */ }
        ) {
            Text("Cancelar")
        }
        Spacer(modifier = Modifier.width(8.dp))
        Button(
            onClick = { /* TODO: Handle Salir */ }
        ) {
            Text("Salir")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Ejercicio2MisPrimerasAppsTheme {
        CenteredButtonScreen()
    }
}

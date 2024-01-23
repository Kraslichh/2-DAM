@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.ejerciciosmisprimerasapps

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ejerciciosmisprimerasapps.ui.theme.EjerciciosMisPrimerasAppsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EjerciciosMisPrimerasAppsTheme {
                LoginScreen()
            }
        }
    }
}

@Composable
fun LoginScreen() {
    // State for email and password
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.height(32.dp))
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                color = MaterialTheme.colorScheme.primary
            ) {}
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Añade tu email") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Añade la contraseña") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
            Button(
                onClick = {
                    // Handle login logic here
                },
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.End)
            ) {
                Text("Login")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    EjerciciosMisPrimerasAppsTheme {
        LoginScreen()
    }
}

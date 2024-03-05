import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Context
import android.util.Log
import android.widget.Button
import com.example.ficherosbasesdatos.R
import java.io.OutputStreamWriter

class Almacenamiento1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_almacenamiento1)  // Agregado el paréntesis aquí

        val btnCrearArchivo: Button = findViewById(R.id.btnCrearArchivo)

        btnCrearArchivo.setOnClickListener {
            crearArchivo()
        }
    }

    private fun crearArchivo() {
        try {
            val fileName = "Alberto el grande"
            val fileContent = "Alberto imperator"

            // Abrir un OutputStreamWriter en el modo privado (solo accesible por esta aplicación)
            var osw: OutputStreamWriter = OutputStreamWriter(openFileOutput(fileName, Context.MODE_PRIVATE))

            // Escribir el contenido en el archivo
            osw.write(fileContent)

            // Limpiar y cerrar el OutputStreamWriter
            osw.flush() //limpiamos
            osw.close() //cerramos

            Log.d("Éxito", "Archivo creado con éxito!")
        } catch (e: Exception) {
            Log.e("Error", "Error al usar OutputStreamWriter: " + e.message)
        }
    }
}

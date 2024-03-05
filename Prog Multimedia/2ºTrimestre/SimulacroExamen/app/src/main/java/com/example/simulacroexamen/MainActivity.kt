package com.example.simulacroexamen
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {

    private lateinit var db: FirebaseFirestore
    private lateinit var editTextNombre: EditText
    private lateinit var editTextApellidos: EditText
    private lateinit var editTextDireccion: EditText
    private lateinit var editTextCp: EditText
    private lateinit var editTextCiudad: EditText
    private lateinit var editTextProvincia: EditText
    private lateinit var editTextTelefono: EditText
    private lateinit var btnAgregar: Button
    private lateinit var btnMostrar: Button
    private lateinit var btnEliminar: Button
    private lateinit var btnActualizar: Button
    private lateinit var textViewDatos: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializar Firestore y establecer la conexión con la base de datos "Empresa"
        db = FirebaseFirestore.getInstance()

        // Referencias a las vistas
        editTextNombre = findViewById(R.id.editTextNombre)
        editTextApellidos = findViewById(R.id.editTextApellidos)
        editTextDireccion = findViewById(R.id.editTextDireccion)
        editTextCp = findViewById(R.id.editTextCp)
        editTextCiudad = findViewById(R.id.editTextCiudad)
        editTextProvincia = findViewById(R.id.editTextProvincia)
        editTextTelefono = findViewById(R.id.editTextTelefono)
        btnAgregar = findViewById(R.id.btnAgregar)
        btnMostrar = findViewById(R.id.btnMostrar)
        btnEliminar = findViewById(R.id.btnEliminar)
        btnActualizar = findViewById(R.id.btnActualizar)
        textViewDatos = findViewById(R.id.textViewDatos)

        // Configurar listeners de los botones
        btnAgregar.setOnClickListener { agregarDatos() }
        btnMostrar.setOnClickListener { mostrarDatos() }
        btnEliminar.setOnClickListener { eliminarRegistro() }
        btnActualizar.setOnClickListener { actualizarDatos() }
    }

    private fun agregarDatos() {
        val nombre = editTextNombre.text.toString().trim()
        val apellidos = editTextApellidos.text.toString().trim()
        val direccion = editTextDireccion.text.toString().trim()
        val cp = editTextCp.text.toString().trim()
        val ciudad = editTextCiudad.text.toString().trim()
        val provincia = editTextProvincia.text.toString().trim()
        val telefono = editTextTelefono.text.toString().trim()

        // Crear un nuevo registro con los datos
        val nuevoRegistro = hashMapOf(
            "Nombre" to nombre,
            "Apellidos" to apellidos,
            "Direccion" to direccion,
            "Cp" to cp,
            "Ciudad" to ciudad,
            "Provincia" to provincia,
            "Telefono" to telefono
        )

        // Agregar el nuevo registro a la colección "DatosPersonales"
        db.collection("DatosPersonales")
            .add(nuevoRegistro)
            .addOnSuccessListener {
                Toast.makeText(this, "Datos agregados correctamente", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener {
                Toast.makeText(this, "Error al agregar datos", Toast.LENGTH_SHORT).show()
            }
    }

    private fun mostrarDatos() {
        // Obtener todos los registros de la colección "DatosPersonales"
        db.collection("DatosPersonales")
            .get()
            .addOnSuccessListener { result ->
                val datos = StringBuilder()
                for (document in result) {
                    datos.append("Nombre: ${document.data["Nombre"]}, ")
                        .append("Apellidos: ${document.data["Apellidos"]}, ")
                        .append("Direccion: ${document.data["Direccion"]}, ")
                        .append("Cp: ${document.data["Cp"]}, ")
                        .append("Ciudad: ${document.data["Ciudad"]}, ")
                        .append("Provincia: ${document.data["Provincia"]}, ")
                        .append("Telefono: ${document.data["Telefono"]}\n")
                }
                textViewDatos.text = datos.toString()
            }
            .addOnFailureListener {
                Toast.makeText(this, "Error al obtener datos", Toast.LENGTH_SHORT).show()
            }
    }

    private fun eliminarRegistro() {
        // Eliminar un registro por su nombre
        val nombre = editTextNombre.text.toString().trim()
        db.collection("DatosPersonales")
            .whereEqualTo("Nombre", nombre)
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    document.reference.delete()
                        .addOnSuccessListener {
                            Toast.makeText(this, "Registro eliminado correctamente", Toast.LENGTH_SHORT).show()
                        }
                        .addOnFailureListener { e ->
                            Toast.makeText(this, "Error al eliminar el registro: ${e.message}", Toast.LENGTH_SHORT).show()
                        }
                }
            }
            .addOnFailureListener {
                Toast.makeText(this, "Error al buscar el registro para eliminar", Toast.LENGTH_SHORT).show()
            }
    }

    private fun actualizarDatos() {
        // Actualizar el nombre de un registro por su nombre actual
        val nombreActual = editTextNombre.text.toString().trim()
        val nombreNuevo = "Gandalf" // Nuevo nombre a actualizar

        db.collection("DatosPersonales")
            .whereEqualTo("Nombre", nombreActual)
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    document.reference.update("Nombre", nombreNuevo)
                        .addOnSuccessListener {
                            Toast.makeText(this, "Datos actualizados correctamente", Toast.LENGTH_SHORT).show()
                        }
                        .addOnFailureListener { e ->
                            Toast.makeText(this, "Error al actualizar los datos: ${e.message}", Toast.LENGTH_SHORT).show()
                        }
                }
            }
            .addOnFailureListener {
                Toast.makeText(this, "Error al buscar el registro para actualizar", Toast.LENGTH_SHORT).show()
            }
    }
}

package actividad2

import android.content.ContentValues
import android.content.Context
import android.database.Cursor

class DataManagerAlumno(context: Context) {

    private val dbHelper = DatabaseHelper(context)

    fun addAlumno(alumno: Alumno) {
        val db = dbHelper.writableDatabase
        val values = ContentValues().apply {
            put(DatabaseHelper.COLUMN_NOMBRE, alumno.nombre)
            put(DatabaseHelper.COLUMN_APELLIDOS, alumno.apellidos)
            put(DatabaseHelper.COLUMN_DNI, alumno.dni)
            put(DatabaseHelper.COLUMN_EDAD, alumno.edad)
            put(DatabaseHelper.COLUMN_CURSO, alumno.curso)
        }
        db.insert(DatabaseHelper.TABLE_NAME_ALUMNOS, null, values)
        db.close()
    }

    fun getAllAlumnos(): List<Alumno> {
        val db = dbHelper.readableDatabase
        val cursor: Cursor = db.rawQuery("SELECT * FROM ${DatabaseHelper.TABLE_NAME_ALUMNOS}", null)
        val alumnos = mutableListOf<Alumno>()
        while (cursor.moveToNext()) {
            val alumno = Alumno(
                id = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID)),
                nombre = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_NOMBRE)),
                apellidos = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_APELLIDOS)),
                dni = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_DNI)),
                edad = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_EDAD)),
                curso = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_CURSO))
            )
            alumnos.add(alumno)
        }
        cursor.close()
        db.close()
        return alumnos
    }
}

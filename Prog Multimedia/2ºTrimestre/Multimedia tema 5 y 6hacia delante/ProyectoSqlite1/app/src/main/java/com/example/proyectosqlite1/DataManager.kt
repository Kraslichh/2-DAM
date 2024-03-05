// DataManager.kt
package com.example.proyectosqlite1

import android.content.ContentValues
import android.content.Context

class DataManager(context: Context) {
    private val dbHelper = DatabaseHelper(context)

    fun addName(nombre: String, apellidos: String) {
        val db = dbHelper.writableDatabase
        val values = ContentValues().apply {
            put(DatabaseHelper.COLUMN_NAME, nombre)
            put(DatabaseHelper.COLUMN_APELLIDOS, apellidos)
        }
        db.insert(DatabaseHelper.TABLE_NAME, null, values)
        db.close()
    }

    fun getAllNames(context: Context): String {
        val db = dbHelper.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM ${DatabaseHelper.TABLE_NAME}", null)
        val names = StringBuilder()

        while (cursor.moveToNext()) {
            val name = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_NAME))
            val apellidos = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_APELLIDOS))
            names.append("$name $apellidos\n")
        }

        cursor.close()
        db.close()

        if (names.isEmpty()) {
            return "No hay nombres en la base de datos"
        }

        return names.toString()
    }

    fun addName(nombre: String) {

    }
}


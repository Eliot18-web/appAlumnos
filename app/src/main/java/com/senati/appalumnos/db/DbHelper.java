package com.senati.appalumnos.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    // Subimos la versión a 2 para que ejecute el cambio de tabla
    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NOMBRE = "senati.db";
    // Corregido: Nombre de la tabla sin el ".db"
    private static final String TABLE_CONCTACTOS = "alumnos";

    //Constructor DbHelper
    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    //Evento se va crear : para crear la base de datos
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // COLOCAMOS EL SCRIPT SQL
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_CONCTACTOS + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT ," +
                "nombre TEXT NOT NULL," +
                "telefono TEXT NOT NULL, " +
                "correo_electronico TEXT)");
    }

    // Evento se ejecuta cuando cambia la version de la base de datos.
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_CONCTACTOS);
        onCreate(sqLiteDatabase);
    }
}

package com.lutrias.projectunit2_matiasmarchant_santiagofierro.database;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class AdminSQliteOpenHelper extends SQLiteOpenHelper{


    //Constructor para instanciar la base de datos
    public AdminSQliteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    // Método para poder crear el modelo de trabajo
    @Override
    public void onCreate(SQLiteDatabase db) {
       db.execSQL("CREATE TABLE wishs (id INTERGER PRIMARY KEY , nombre text, categoria text)");



    }


    //Método para realizar actualizaciones en el modelo
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

package com.example.jorge.ejerciciovideoturismo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Jorge on 22/07/2015.
 */
public class BDPeliculas extends SQLiteOpenHelper {
    public static final String DB_NAME = "uris.db";
    public static final int DB_VERSION = 1;

    public BDPeliculas(Context context){
        super(context,DB_NAME,null,DB_VERSION);


    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        //Crear la tabla Quotes
        db.execSQL(UriDePeliculas.SCRIPT_URIS);
        //Insertar registros iniciales
        db.execSQL(UriDePeliculas.INSERT_URIS_SCRIPT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

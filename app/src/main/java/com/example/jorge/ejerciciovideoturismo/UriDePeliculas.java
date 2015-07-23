package com.example.jorge.ejerciciovideoturismo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;
import android.util.Log;

/**
 * Created by Jorge on 22/07/2015.
 */
public class UriDePeliculas {
        //Metainformación de la base de datos
        public static final String URIS_TABLE_NAME = "Uris";
        public static final String STRING_TYPE = "direccion";
        public static final String INT_TYPE = "integer";

        //Campos de la tabla uris
        public static class UrisColumnas{
            public static final String ID_URIS = BaseColumns._ID;
            public static final String DIRECCION = "direccion";
        }

        //Script de Creación de la tabla Uris
        public static final String SCRIPT_URIS =
                "create table "+URIS_TABLE_NAME+"(" +
                        UrisColumnas.ID_URIS+" "+INT_TYPE+" primary key autoincrement," +
                        UrisColumnas.DIRECCION+" "+STRING_TYPE+" not null)";

        //Scripts de inserción por defecto
        public static final String INSERT_URIS_SCRIPT =
                "insert into "+URIS_TABLE_NAME+" values(" +
                        "null,"
                        +"\"android.resource://com.example.jorge.ejerciciovideoturismo/raw/hombresdehonor\")," +
                        "(null," +
                        "\"android.resource://com.example.jorge.ejerciciovideoturismo/raw/eradehielo\")," +
                        "(null," +
                        "\"android.resource://com.example.jorge.ejerciciovideoturismo/raw/losvengadores\")";


    private BDPeliculas openHelper;
        private SQLiteDatabase database;

        public UriDePeliculas(Context context) {
            //Creando una instancia hacia la base de datos
            openHelper = new BDPeliculas(context);
            database = openHelper.getWritableDatabase();
        }
    public String getIdUri(int id){
        Cursor c = database.rawQuery(
                "select direccion from "+ URIS_TABLE_NAME + " WHERE _ID =" + id  , null);
        c.moveToFirst();
        c.getString(c.getColumnIndex("direccion"));
        return c.getString(c.getColumnIndex("direccion"));
    }

}


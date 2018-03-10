package com.iesnervion.agomez.a2048.Converters;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;

/**
 * Created by aleja on 10/02/2018.
 */

public class TableroConverter
{
    @TypeConverter
    public String fromStringArray (String [][] tabla)
    {
        Gson gson = new Gson();
        String tablaSerializada = gson.toJson(tabla);

        return tablaSerializada;
    }

    @TypeConverter
    public String [][] toStringArray (String tablaSerializada)
    {
        Gson gson = new Gson();
        String [][] tabla = gson.fromJson(tablaSerializada, String[][].class);

        return tabla;
    }
}

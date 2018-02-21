package com.example.agomez.examen_final_alejandro_gomez.TypeConverters;

import android.arch.persistence.room.TypeConverter;

import com.example.agomez.examen_final_alejandro_gomez.Models.Posicion;
import com.google.gson.Gson;

/**
 * Created by agomez on 21/02/18.
 */

public class FutbolistaTypeConverter
{
    //Lo haria con ArrayList, pero me daba problemas con el Converter
    // y no he querido perder mucho tiempo.
    //El problema es que al convertirlo de vuelta en un arrayList, este es un LinkedTreeMap
    //de GSon, y no hay manera de transformarlo de vuelta en un array.
    //He probado haciendo inserciones una a una, casteando, y nada.
    //Asi que he optado por el metodo menos eficaz que es utilizando arrays estaticos.
    //Debido a esto el codigo de la aplicacion ha sido modificado para utilizar este metodo
    //utilizando tacticas poco eficaces.

    @TypeConverter
    public String fromPosicionArray (Posicion [] posiciones)
    {
        Gson gson = new Gson();
        String posicionesSerializadas = gson.toJson(posiciones);

        return posicionesSerializadas;
    }

    @TypeConverter
    public Posicion [] toPosicionArray (String posicionesSerializadas)
    {
        Gson gson = new Gson();
        Posicion [] posiciones = gson.fromJson(posicionesSerializadas, Posicion [].class);

        return posiciones;
    }
}

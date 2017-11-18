package com.iesnervion.agomez.googlemaps;

/**
 * Created by aleja on 18/11/2017.
 */

public class Ciudad
{
    private String nombre;
    private String latitud;
    private String longitud;

    public Ciudad ()
    {
        this.nombre = "";
        this.latitud = "";
        this.longitud = "";
    }

    public Ciudad (String nombre, String latitud, String longitud)
    {
        this.nombre = nombre;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public String getNombre ()
    {
        return nombre;
    }

    public String getLatitud ()
    {
        return latitud;
    }

    public String getLongitud ()
    {
        return longitud;
    }

    @Override
    public String toString ()
    {
        return this.nombre;
    }
}

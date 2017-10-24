package com.example.agomez.reproductormusica;

import android.widget.ImageView;

/**
 * Propiedades.
 *      Basicas:                String titulo       -----------     CONSULTABLE/MODIFICABLE
 *                              String autor        -----------     CONSULTABLE/MODIFICABLE
 *                              String album        -----------     CONSULTABLE/MODIFICABLE
 *                              String duracion     -----------     CONSULTABLE/MODIFICABLE
 *                              Integer portada     -----------     CONSULTABLE/MODIFICABLE
 *
 *      Derivadas:
 *      Compuestas:
 * Created by agomez on 24/10/17.
 */

public class Cancion
{
    private String titulo;
    private String autor;
    private String album;
    private String duracion;
    private Integer portada;

    public Cancion ()
    {
        this.titulo = "";
        this.autor = "";
        this.album = "";
        this.duracion = "";
        this.portada = 0;
    }

    public Cancion (String titulo, String autor, String album, String duracion, Integer portada)
    {
        this.titulo = titulo;
        this.autor = autor;
        this.album = album;
        this.duracion = duracion;
        this.portada = portada;
    }

    public String getTitulo ()
    {
        return titulo;
    }

    public void setTitulo (String titulo)
    {
        this.titulo = titulo;
    }

    public String getAutor ()
    {
        return autor;
    }

    public void setAutor (String autor)
    {
        this.autor = autor;
    }

    public String getAlbum ()
    {
        return album;
    }

    public void setAlbum (String album)
    {
        this.album = album;
    }

    public String getDuracion ()
    {
        return duracion;
    }

    public void setDuracion (String duracion)
    {
        this.duracion = duracion;
    }

    public Integer getPortada ()
    {
        return portada;
    }

    public void setPortada (Integer portada)
    {
        this.portada = portada;
    }
}

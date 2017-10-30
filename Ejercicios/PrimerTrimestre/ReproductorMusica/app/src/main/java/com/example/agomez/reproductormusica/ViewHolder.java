package com.example.agomez.reproductormusica;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by agomez on 30/10/17.
 */

public class ViewHolder
{
    ImageView portada;
    TextView titulo;
    TextView autor;
    TextView album;
    TextView duracion;

    public ViewHolder (View vista)
    {
        this.portada = (ImageView) vista.findViewById(R.id.portada);
        this.titulo = (TextView) vista.findViewById(R.id.titulo);
        this.autor = (TextView) vista.findViewById(R.id.autor);
        this.album = (TextView) vista.findViewById(R.id.album);
        this.duracion = (TextView) vista.findViewById(R.id.duracion);
    }

    public ImageView getPortada ()
    {
        return portada;
    }

    public void setPortada (ImageView portada)
    {
        this.portada = portada;
    }

    public TextView getAutor ()
    {
        return autor;
    }

    public void setAutor (TextView autor)
    {
        this.autor = autor;
    }

    public TextView getAlbum ()
    {
        return album;
    }

    public void setAlbum (TextView album)
    {
        this.album = album;
    }

    public TextView getTitulo ()
    {
        return titulo;
    }

    public void setTitulo (TextView titulo)
    {
        this.titulo = titulo;
    }

    public TextView getDuracion ()
    {
        return duracion;
    }

    public void setDuracion (TextView duracion)
    {
        this.duracion = duracion;
    }
}

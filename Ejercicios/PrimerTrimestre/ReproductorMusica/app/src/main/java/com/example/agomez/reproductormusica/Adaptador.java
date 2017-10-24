package com.example.agomez.reproductormusica;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.agomez.reproductormusica.R;

/**
 * Created by agomez on 18/10/17.
 */

public class Adaptador extends ArrayAdapter<Cancion>
{
    private final Activity actividad;
    private final Cancion [] canciones;

    public Adaptador (Activity actividad,Cancion [] canciones)
    {
        super(actividad, R.layout.row, canciones);
        this.actividad = actividad;
        this.canciones = canciones;
    }

    public View getView (int posicion, View convertView, ViewGroup parent)
    {
        View vista = convertView;

        if (vista == null) {
            LayoutInflater inflater = actividad.getLayoutInflater();
            vista = inflater.inflate(R.layout.row, null, true);//super.getView(posicion,view,parent);
        }

        TextView txtTitulos = (TextView) vista.findViewById(R.id.titulo);
        TextView txtAutores = (TextView) vista.findViewById(R.id.autor);
        TextView txtAlbumes = (TextView) vista.findViewById(R.id.album);
        TextView txtDuraciones = (TextView) vista.findViewById(R.id.duracion);
        ImageView imgPortadas = (ImageView) vista.findViewById(R.id.portada);

        txtTitulos.setText(canciones[posicion].getTitulo());
        txtAutores.setText(canciones[posicion].getAutor());
        txtAlbumes.setText(canciones[posicion].getAlbum());
        txtDuraciones.setText(canciones[posicion].getDuracion());
        imgPortadas.setImageResource(/*portadas[posicion]*/R.drawable.portada1);

        return vista;
    }
}

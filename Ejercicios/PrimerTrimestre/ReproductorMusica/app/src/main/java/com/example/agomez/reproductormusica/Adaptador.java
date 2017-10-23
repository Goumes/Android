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

public class Adaptador extends ArrayAdapter<String>
{
    private final Activity actividad;
    private final String [] titulos;
    private final String [] autores;
    private final String [] albumes;
    private final String [] duraciones;
    private final Integer [] portadas;

    public Adaptador (Activity actividad, String [] titulos, String [] autores, String [] albumes, String [] duraciones, Integer [] portadas)
    {
        super(actividad, R.layout.row, titulos);
        this.actividad = actividad;
        this.titulos = titulos;
        this.autores = autores;
        this.albumes = albumes;
        this.portadas = portadas;
        this.duraciones = duraciones;
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

        txtTitulos.setText(titulos[posicion]);
        txtAutores.setText(autores[posicion]);
        txtAlbumes.setText(albumes[posicion]);
        txtDuraciones.setText(duraciones[posicion]);
        imgPortadas.setImageResource(/*portadas[posicion]*/R.drawable.portada1);

        return vista;
    }
}

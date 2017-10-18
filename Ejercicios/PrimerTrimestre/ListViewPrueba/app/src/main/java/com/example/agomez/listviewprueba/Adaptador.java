package com.example.agomez.listviewprueba;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by agomez on 18/10/17.
 */

public class Adaptador extends ArrayAdapter <String>
{
    private final Activity actividad;
    private final String [] nombres;
    private final Integer [] imagenes;

    public Adaptador (Activity actividad, String [] nombres, Integer [] imagenes)
    {
        super(actividad, R.layout.row, nombres);
        this.actividad = actividad;
        this.nombres = nombres;
        this.imagenes = imagenes;
    }

    public View getView (int posicion, View view, ViewGroup parent)
    {
        LayoutInflater inflater = actividad.getLayoutInflater();
        View vista = inflater.inflate(R.layout.row, null, true);//super.getView(posicion,view,parent);

        TextView txtView = (TextView) vista.findViewById(R.id.texto);
        ImageView imgView = (ImageView) vista.findViewById(R.id.imagen);

        txtView.setText(nombres[posicion]);
        imgView.setImageResource(imagenes[posicion]);

        return vista;
        }
}

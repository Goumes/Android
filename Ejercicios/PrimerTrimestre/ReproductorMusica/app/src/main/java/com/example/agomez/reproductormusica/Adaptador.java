package com.example.agomez.reproductormusica;

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
        ViewHolder viewHolder;

        if (vista == null) {
            LayoutInflater inflater = actividad.getLayoutInflater();
            vista = inflater.inflate(R.layout.row, null, true);//super.getView(posicion,view,parent);

            viewHolder = new ViewHolder (vista);
            vista.setTag(viewHolder);

        }

        else
        {
            viewHolder = (ViewHolder) vista.getTag();
        }

        TextView txtTitulos = viewHolder.getTitulo();
        TextView txtAutores = viewHolder.getAutor();
        TextView txtAlbumes = viewHolder.getAlbum();
        TextView txtDuraciones = viewHolder.getDuracion();
        ImageView imgPortadas = viewHolder.getPortada();

        txtTitulos.setText(canciones[posicion].getTitulo());
        txtAutores.setText(canciones[posicion].getAutor());
        txtAlbumes.setText(canciones[posicion].getAlbum());
        txtDuraciones.setText(canciones[posicion].getDuracion());
        imgPortadas.setImageResource(/*portadas[posicion]*/R.drawable.portada1);

        return vista;
    }
}

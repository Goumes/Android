package com.iesnervion.agomez.examenantiguo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by aleja on 21/11/2017.
 */

public class JugadorAdapter extends ArrayAdapter<Jugador>
{
    private ArrayList<Jugador> jugadores;

    public JugadorAdapter (Context context, int resource, ArrayList <Jugador> jugadores)
    {
        super (context, resource, jugadores);
        this.jugadores = jugadores;
    }


    public View getView (int posicion, View convertView, ViewGroup parent)
    {
        View vista = convertView;
        ViewHolder myViewHolder;
        Jugador jugador;

        if (vista == null)
        {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            vista = inflater.inflate(R.layout.row, null);
            myViewHolder = new ViewHolder(vista); // Aqui
            vista.setTag(myViewHolder);
        }

        else
        {
            myViewHolder = (ViewHolder) vista.getTag();
        }

        jugador = getItem(posicion);

        if (jugador != null)
        {
            TextView txtNombre = myViewHolder.getNombre ();
            TextView txtPosicion = myViewHolder.getPosicion ();
            TextView txtPeso = myViewHolder.getPeso ();
            TextView txtAltura = myViewHolder.getAltura ();
            ImageView imgFoto = myViewHolder.getImagen();

            txtNombre.setText(jugador.getNombre());
            txtPosicion.setText(jugador.getPosicion());
            txtPeso.setText(String.valueOf(jugador.getPeso()));
            txtAltura.setText(String.valueOf(jugador.getAltura()));
            imgFoto.setImageResource(jugador.getFoto());
        }

        return vista;
    }
}

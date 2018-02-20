package com.iesnervion.agomez.examenfinalaopasado.Adapter;

import android.view.View;
import android.widget.TextView;

import com.iesnervion.agomez.examenfinalaopasado.R;

/**
 * Created by aleja on 20/02/2018.
 */

public class ViewHolder
{
    TextView nombre;
    TextView telefono;

    public ViewHolder (View view)
    {
        this.nombre = view.findViewById(R.id.nombre);
        this.telefono = view.findViewById(R.id.telefono);
    }

    public TextView getNombre() {
        return nombre;
    }

    public void setNombre(TextView nombre) {
        this.nombre = nombre;
    }

    public TextView getTelefono() {
        return telefono;
    }

    public void setTelefono(TextView telefono) {
        this.telefono = telefono;
    }
}

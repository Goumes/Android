package com.example.agomez.examen_final_alejandro_gomez.Adapter;

import android.widget.TextView;

/**
 * Created by agomez on 21/02/18.
 */

public class ViewHolder
{
    TextView nombre;
    TextView posiciones;

    public ViewHolder(TextView nombre, TextView posiciones) {
        this.nombre = nombre;
        this.posiciones = posiciones;
    }

    public TextView getNombre() {
        return nombre;
    }

    public void setNombre(TextView nombre) {
        this.nombre = nombre;
    }

    public TextView getPosiciones() {
        return posiciones;
    }

    public void setPosiciones(TextView posiciones) {
        this.posiciones = posiciones;
    }
}

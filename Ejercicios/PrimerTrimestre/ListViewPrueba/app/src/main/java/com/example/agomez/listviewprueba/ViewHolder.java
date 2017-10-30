package com.example.agomez.listviewprueba;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by agomez on 30/10/17.
 */

public class ViewHolder
{
    TextView texto;
    ImageView imagen;

    public ViewHolder (View row, int textoId, int imagenId)
    {
        this.texto = (TextView) row.findViewById(R.id.texto) ;
        this.imagen = (ImageView) row.findViewById(R.id.imagen);
    }

    public TextView getTexto()
    {
        return texto;
    }

    public void setTexto (TextView texto)
    {
        this.texto = texto;
    }

    public ImageView getImagen()
    {
        return imagen;
    }

    public void setImagen (ImageView imagen)
    {
        this.imagen = imagen;
    }
}

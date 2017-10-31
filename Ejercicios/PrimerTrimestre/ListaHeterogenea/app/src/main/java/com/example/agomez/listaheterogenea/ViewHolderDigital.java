package com.example.agomez.listaheterogenea;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by agomez on 30/10/17.
 */

public class ViewHolderDigital
{
    private ImageView preview;
    private TextView modelo;
    private TextView marca;
    private TextView precio;
    private TextView fuenteDigito;

    public ViewHolderDigital (View vista)
    {
        this.preview = (ImageView) vista.findViewById(R.id.preview);
        this.modelo = (TextView) vista.findViewById(R.id.modelo);
        this.marca = (TextView) vista.findViewById(R.id.marca);
        this.precio = (TextView) vista.findViewById(R.id.precio);
        this.fuenteDigito = (TextView) vista.findViewById(R.id.fuente);
    }

    public ImageView getPreview ()
    {
        return preview;
    }

    public void setPreview (ImageView preview)
    {
        this.preview = preview;
    }

    public TextView getModelo ()
    {
        return modelo;
    }

    public void setModelo (TextView modelo)
    {
        this.modelo = modelo;
    }

    public TextView getMarca ()
    {
        return marca;
    }

    public void setMarca (TextView marca)
    {
        this.marca = marca;
    }

    public TextView getPrecioprecio ()
    {
        return precio;
    }

    public void setPrecio (TextView precio)
    {
        this.precio = precio;
    }

    public TextView getFuenteDigito ()
    {
        return fuenteDigito;
    }

    public void setFuenteDigito (TextView fuenteDigito)
    {
        this.fuenteDigito = fuenteDigito;
    }
}

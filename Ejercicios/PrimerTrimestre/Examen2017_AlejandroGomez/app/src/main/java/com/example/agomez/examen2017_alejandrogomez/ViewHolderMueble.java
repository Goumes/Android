package com.example.agomez.examen2017_alejandrogomez;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by agomez on 22/11/17.
 */

public class ViewHolderMueble
{
    private ImageView foto;
    private TextView color;
    private TextView precio;
    private TextView cantidad;

    public ViewHolderMueble (View vista)
    {
        this.foto = (ImageView) vista.findViewById(R.id.imgMueble);
        this.color = (TextView) vista.findViewById(R.id.colorMueble);
        this.precio = (TextView) vista.findViewById(R.id.precioMueble);
        this.cantidad = (TextView) vista.findViewById(R.id.numeroMueble);
    }

    public ImageView getFoto() {
        return foto;
    }

    public void setFoto(ImageView foto) {
        this.foto = foto;
    }

    public TextView getColor() {
        return color;
    }

    public void setColor(TextView color) {
        this.color = color;
    }

    public TextView getPrecio() {
        return precio;
    }

    public void setPrecio(TextView precio) {
        this.precio = precio;
    }

    public TextView getCantidad() {
        return cantidad;
    }

    public void setCantidad(TextView cantidad) {
        this.cantidad = cantidad;
    }
}

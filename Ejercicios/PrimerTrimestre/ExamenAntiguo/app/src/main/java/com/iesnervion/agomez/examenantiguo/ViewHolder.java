package com.iesnervion.agomez.examenantiguo;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by aleja on 21/11/2017.
 */

public class ViewHolder {
    private ImageView imagen;
    private TextView nombre;
    private TextView posicion;
    private TextView peso;
    private TextView altura;

    public ViewHolder (View vista)
    {
        this.imagen = (ImageView) vista.findViewById(R.id.imagenRow);
        this.nombre = (TextView) vista.findViewById(R.id.nombreRow);
        this.posicion = (TextView) vista.findViewById(R.id.posicionRow);
        this.peso = (TextView) vista.findViewById(R.id.pesoRow);
        this.altura = (TextView) vista.findViewById(R.id.alturaRow);
    }

    public ImageView getImagen() {
        return imagen;
    }

    public void setImagen(ImageView imagen) {
        this.imagen = imagen;
    }

    public TextView getNombre() {
        return nombre;
    }

    public void setNombre(TextView nombre) {
        this.nombre = nombre;
    }

    public TextView getPosicion() {
        return posicion;
    }

    public void setPosicion(TextView posicion) {
        this.posicion = posicion;
    }

    public TextView getPeso() {
        return peso;
    }

    public void setPeso(TextView peso) {
        this.peso = peso;
    }

    public TextView getAltura() {
        return altura;
    }

    public void setAltura(TextView altura) {
        this.altura = altura;
    }
}

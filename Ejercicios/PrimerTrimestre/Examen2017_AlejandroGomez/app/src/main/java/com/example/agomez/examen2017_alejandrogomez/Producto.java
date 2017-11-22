package com.example.agomez.examen2017_alejandrogomez;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by agomez on 22/11/17.
 */

public class Producto implements Parcelable
{
    protected String nombre;
    protected double precio;
    protected String descripcion;

    public Producto ()
    {
        this.nombre = "";
        this.precio = 0.0;
        this.descripcion = "";
    }

    public Producto (String nombre, double precio, String descripcion)
    {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nombre);
        dest.writeDouble(this.precio);
        dest.writeString(this.descripcion);
    }

    protected Producto(Parcel in) {
        this.nombre = in.readString();
        this.precio = in.readDouble();
        this.descripcion = in.readString();
    }

}

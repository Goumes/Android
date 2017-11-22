package com.example.agomez.examen2017_alejandrogomez;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by agomez on 22/11/17.
 */

public class ProductoMueble extends Producto implements Parcelable
{
    private ArrayList<ColoresFotos> coloresFotos;

    public ProductoMueble ()
    {
        super ();
        this.coloresFotos = new ArrayList<>();

    }

    public ProductoMueble (String nombre, double precio, String descripcion, ArrayList<ColoresFotos> coloresFotos)
    {
        super (nombre, precio, descripcion);
        this.coloresFotos = coloresFotos;
    }

    public ArrayList<ColoresFotos> getColoresFotos() {
        return coloresFotos;
    }

    public void setColoresFotos(ArrayList<ColoresFotos> coloresFotos) {
        this.coloresFotos = coloresFotos;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeTypedList(this.coloresFotos);
        dest.writeString(this.nombre);
        dest.writeDouble(this.precio);
        dest.writeString(this.descripcion);
    }

    protected ProductoMueble(Parcel in) {
        super(in);
        this.coloresFotos = in.createTypedArrayList(ColoresFotos.CREATOR);
        this.nombre = in.readString();
        this.precio = in.readDouble();
        this.descripcion = in.readString();
    }

    public static final Creator<ProductoMueble> CREATOR = new Creator<ProductoMueble>() {
        @Override
        public ProductoMueble createFromParcel(Parcel source) {
            return new ProductoMueble(source);
        }

        @Override
        public ProductoMueble[] newArray(int size) {
            return new ProductoMueble[size];
        }
    };
}

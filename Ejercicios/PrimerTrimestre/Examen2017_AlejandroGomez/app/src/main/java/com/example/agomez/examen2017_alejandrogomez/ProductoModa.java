package com.example.agomez.examen2017_alejandrogomez;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by agomez on 22/11/17.
 */

public class ProductoModa extends Producto implements Parcelable
{
    private ArrayList<ColoresTallas> coloresTallas;

    public ProductoModa ()
    {
        super ();
        this.coloresTallas = new ArrayList<>();
    }

    public ProductoModa (String nombre, double precio, String descripcion, ArrayList<ColoresTallas> coloresTallas)
    {
        super (nombre, precio, descripcion);
        this.coloresTallas = coloresTallas;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(this.coloresTallas);
        dest.writeString(this.nombre);
        dest.writeDouble(this.precio);
        dest.writeString(this.descripcion);
    }

    protected ProductoModa(Parcel in) {
        this.coloresTallas = new ArrayList<ColoresTallas>();
        in.readList(this.coloresTallas, ColoresTallas.class.getClassLoader());
        this.nombre = in.readString();
        this.precio = in.readDouble();
        this.descripcion = in.readString();
    }

    public static final Creator<ProductoModa> CREATOR = new Creator<ProductoModa>() {
        @Override
        public ProductoModa createFromParcel(Parcel source) {
            return new ProductoModa(source);
        }

        @Override
        public ProductoModa[] newArray(int size) {
            return new ProductoModa[size];
        }
    };

    public ArrayList<ColoresTallas> getColoresTallas() {
        return coloresTallas;
    }

    public void setColoresTallas(ArrayList<ColoresTallas> coloresTallas) {
        this.coloresTallas = coloresTallas;
    }
}

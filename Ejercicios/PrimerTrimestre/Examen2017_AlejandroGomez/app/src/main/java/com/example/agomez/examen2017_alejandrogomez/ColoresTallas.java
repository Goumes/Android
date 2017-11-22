package com.example.agomez.examen2017_alejandrogomez;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by agomez on 22/11/17.
 */

public class ColoresTallas implements Parcelable
{
    private Integer talla;
    private ArrayList<ColoresFotos> coloresFotos;


    public ColoresTallas()
    {
        this.talla = 0;
        this.coloresFotos = new ArrayList<>();
    }

    public ColoresTallas(Integer talla, ArrayList<ColoresFotos> coloresFotos) {
        this.talla = talla;
        this.coloresFotos = coloresFotos;
    }


    public Integer getTalla() {
        return talla;
    }

    public void setTalla(Integer talla) {
        this.talla = talla;
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
        dest.writeValue(this.talla);
        dest.writeTypedList(this.coloresFotos);
    }

    protected ColoresTallas(Parcel in) {
        this.talla = (Integer) in.readValue(Integer.class.getClassLoader());
        this.coloresFotos = in.createTypedArrayList(ColoresFotos.CREATOR);
    }

    public static final Creator<ColoresTallas> CREATOR = new Creator<ColoresTallas>() {
        @Override
        public ColoresTallas createFromParcel(Parcel source) {
            return new ColoresTallas(source);
        }

        @Override
        public ColoresTallas[] newArray(int size) {
            return new ColoresTallas[size];
        }
    };
}

package com.iesnervion.agomez.examenantiguo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by aleja on 21/11/2017.
 */

public class Jugador implements Parcelable
{
    private String nombre;
    private String posicion;
    private int foto;
    private double altura;
    private double peso;

    public Jugador ()
    {
        this.nombre = "";
        this.posicion = "";
        this.foto = 0;
        this.altura = 0.0;
        this.peso = 0.0;
    }

    public Jugador (String nombre, String posicion, int foto, double altura, double peso)
    {
        this.nombre = nombre;
        this.posicion = posicion;
        this.foto = foto;
        this.altura = altura;
        this.peso = peso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nombre);
        dest.writeString(this.posicion);
        dest.writeInt(this.foto);
        dest.writeDouble(this.altura);
        dest.writeDouble(this.peso);
    }

    protected Jugador(Parcel in) {
        this.nombre = in.readString();
        this.posicion = in.readString();
        this.foto = in.readInt();
        this.altura = in.readDouble();
        this.peso = in.readDouble();
    }

    public static final Creator<Jugador> CREATOR = new Creator<Jugador>() {
        @Override
        public Jugador createFromParcel(Parcel source) {
            return new Jugador(source);
        }

        @Override
        public Jugador[] newArray(int size) {
            return new Jugador[size];
        }
    };
}

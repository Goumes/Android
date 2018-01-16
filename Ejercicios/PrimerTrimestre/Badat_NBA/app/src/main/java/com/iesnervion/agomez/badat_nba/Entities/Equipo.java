package com.iesnervion.agomez.badat_nba.Entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by aleja on 10/01/2018.
 */

@Entity (tableName = "equipos", indices = {@Index("nombre")}) //No consigo meter el unique
public class Equipo implements Parcelable
{
    @PrimaryKey
    private String nombre;

    private int fundacion;

    @ColumnInfo (name = "color_1")
    private String color1;

    @ColumnInfo (name = "color_2")
    private String color2;

    @ColumnInfo (name = "color_1_Hex")
    private String color1Hex;

    @ColumnInfo (name = "color_2_Hex")
    private String color2Hex;

    private String presidente;
    private String entrenador;
    private String estadio;
    private String ubicacion;
    private Bitmap logo;

    public Equipo(String nombre, int fundacion, String color1, String color2, String color1Hex, String color2Hex, String presidente, String entrenador, String estadio, String ubicacion, Bitmap logo) {
        this.nombre = nombre;
        this.fundacion = fundacion;
        this.color1 = color1;
        this.color2 = color2;
        this.color1Hex = color1Hex;
        this.color2Hex = color2Hex;
        this.presidente = presidente;
        this.entrenador = entrenador;
        this.estadio = estadio;
        this.ubicacion = ubicacion;
        this.logo = logo;
    }

    public Equipo ()
    {
        this.nombre = "";
        this.fundacion = 0;
        this.color1 = "";
        this.color2 = "";
        this.color1Hex = "";
        this.color2Hex = "";
        this.presidente = "";
        this.entrenador = "";
        this.estadio = "";
        this.ubicacion = "";
        this.logo = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFundacion() {
        return fundacion;
    }

    public void setFundacion(int fundacion) {
        this.fundacion = fundacion;
    }

    public String getColor1() {
        return color1;
    }

    public void setColor1(String color1) {
        this.color1 = color1;
    }

    public String getColor2() {
        return color2;
    }

    public void setColor2(String color2) {
        this.color2 = color2;
    }


    public String getColor1Hex() {
        return color1Hex;
    }

    public void setColor1Hex(String color1Hex) {
        this.color1Hex = color1Hex;
    }

    public String getColor2Hex() {
        return color2Hex;
    }

    public void setColor2Hex(String color2Hex) {
        this.color2Hex = color2Hex;
    }

    public String getPresidente() {
        return presidente;
    }

    public void setPresidente(String presidente) {
        this.presidente = presidente;
    }

    public String getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(String entrenador) {
        this.entrenador = entrenador;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Bitmap getLogo ()
    {
        return this.logo;
    }

    public void setLogo (Bitmap logo)
    {
        this.logo = logo;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nombre);
        dest.writeInt(this.fundacion);
        dest.writeString(this.color1);
        dest.writeString(this.color2);
        dest.writeString(this.color1Hex);
        dest.writeString(this.color2Hex);
        dest.writeString(this.presidente);
        dest.writeString(this.entrenador);
        dest.writeString(this.estadio);
        dest.writeString(this.ubicacion);
        dest.writeParcelable(this.logo, flags);
    }

    protected Equipo(Parcel in) {
        this.nombre = in.readString();
        this.fundacion = in.readInt();
        this.color1 = in.readString();
        this.color2 = in.readString();
        this.color1Hex = in.readString();
        this.color2Hex = in.readString();
        this.presidente = in.readString();
        this.entrenador = in.readString();
        this.estadio = in.readString();
        this.ubicacion = in.readString();
        this.logo = in.readParcelable(Bitmap.class.getClassLoader());
    }

    public static final Creator<Equipo> CREATOR = new Creator<Equipo>() {
        @Override
        public Equipo createFromParcel(Parcel source) {
            return new Equipo(source);
        }

        @Override
        public Equipo[] newArray(int size) {
            return new Equipo[size];
        }
    };
}

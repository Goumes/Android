package com.example.agomez.examen2016;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by agomez on 8/11/17.
 */

public class Team implements Parcelable
{
    private int id;
    private String nombre;
    private int logo;

    public Team ()
    {
        this.id = 0;
        this.nombre = "";
        this.logo = 0;
    }

    public Team (int id, String nombre, int logo)
    {
        this.id = id;
        this.nombre = nombre;
        this.logo = logo;
    }

    public int getId()
    {
        return id;
    }

    public void setId (int id)
    {
        this.id = id;
    }

    public String getNombre ()
    {
        return nombre;
    }

    public void setNombre (String nombre)
    {
        this.nombre = nombre;
    }

    public int getLogo ()
    {
        return logo;
    }

    public void setLogo (int logo)
    {
        this.logo = logo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.nombre);
        dest.writeInt(this.logo);
    }

    protected Team(Parcel in) {
        this.id = in.readInt();
        this.nombre = in.readString();
        this.logo = in.readInt();
    }

    public static final Creator<Team> CREATOR = new Creator<Team>() {
        @Override
        public Team createFromParcel(Parcel source) {
            return new Team(source);
        }

        @Override
        public Team[] newArray(int size) {
            return new Team[size];
        }
    };
}

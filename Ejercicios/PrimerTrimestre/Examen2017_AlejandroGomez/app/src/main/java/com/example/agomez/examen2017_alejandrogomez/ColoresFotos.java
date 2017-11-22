package com.example.agomez.examen2017_alejandrogomez;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by agomez on 22/11/17.
 */

public class ColoresFotos implements Parcelable
{
    private String color;
    private int foto;

    public ColoresFotos ()
    {
        this.color = "";
        this.foto = 0;
    }

    public ColoresFotos (String color, int foto)
    {
        this.color = color;
        this.foto = foto;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.color);
        dest.writeInt(this.foto);
    }

    protected ColoresFotos(Parcel in) {
        this.color = in.readString();
        this.foto = in.readInt();
    }

    public static final Creator<ColoresFotos> CREATOR = new Creator<ColoresFotos>() {
        @Override
        public ColoresFotos createFromParcel(Parcel source) {
            return new ColoresFotos(source);
        }

        @Override
        public ColoresFotos[] newArray(int size) {
            return new ColoresFotos[size];
        }
    };

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}

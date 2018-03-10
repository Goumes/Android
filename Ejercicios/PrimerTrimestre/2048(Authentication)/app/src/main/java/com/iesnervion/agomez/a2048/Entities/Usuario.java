package com.iesnervion.agomez.a2048.Entities;

import com.google.gson.annotations.SerializedName;

public class Usuario {

    @SerializedName("id")
    private String id;
    @SerializedName("highscore")
    private int highscore;

    public Usuario() {
    }
    public Usuario(String id, int highscore) {
        super();
        this.id = id;
        this.highscore = highscore;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getHighscore() {
        return highscore;
    }

    public void setHighscore(int highscore) {
        this.highscore = highscore;
    }

    public int compareTo (Usuario usuario)
    {
        int resultado = 0;

        if (this.getHighscore() > usuario.getHighscore())
        {
            resultado = 1;
        }

        else if (this.getHighscore() < usuario.getHighscore())
        {
            resultado = -1;
        }

        return resultado;
    }

}
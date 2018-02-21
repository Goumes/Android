package com.example.agomez.examen_final_alejandro_gomez.Models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by agomez on 21/02/18.
 */

@Entity(tableName = "posiciones", indices = {@Index("id")})
public class Posicion
{
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;
    private String nombre;

    public Posicion ()
    {
        this.nombre = " DEL ";
    }

    public Posicion(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
